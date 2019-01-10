#! /usr/bin/env python3

import re
import requests
import argparse
import time
import hashlib
import json
import logging
from requests.adapters import HTTPAdapter

sess = requests.Session()
sess.mount('', HTTPAdapter(max_retries=5))
headers = {
    "User-Agent": "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Mobile Safari/537.36"}
logging.getLogger().setLevel(logging.DEBUG)
logging.debug('')


def get_api(url, rate):
    url = re.sub(r'.*douyu.com', 'https://m.douyu.com/room', url)

    sess.headers.update({'referer': url})
    for i in range(1, 8):
        html = sess.get(url, headers=headers, allow_redirects=False)
        if html.status_code == 200:
            break

    # room_id_patt = r'room_id\s*:\s*(\d+),'
    room_id_patt = r'"rid"\s*:\s*(\d+),'
    room_id = re.search(room_id_patt, html.text).group(1)

    api_url = "http://www.douyutv.com/api/v1/"
    args = "room/%s?aid=wp&client_sys=wp&time=%d" % (room_id, int(time.time()))
    auth_md5 = (args + "zNzMV1y4EMxOHS6I5WKm").encode("utf-8")
    auth_str = hashlib.md5(auth_md5).hexdigest()
    json_request_url = "%s%s&auth=%s" % (api_url, args, auth_str)

    sess.headers.update({'referer': json_request_url})
    content = sess.get(json_request_url, headers=headers)

    json_content = json.loads(content.text)
    data = json_content['data']

    show_status = data.get('show_status')
    if show_status is not "1":
        raise ValueError("Offline!!")

    other_bit = data.get('rtmp_multi_bitrate')
    if rate == "1":
        real_url = data.get('rtmp_url') + '/' + other_bit.get('middle')
    elif rate == "2":
        real_url = data.get('rtmp_url') + '/' + other_bit.get('middle2')
    else:
        real_url = data.get('rtmp_url') + '/' + data.get('rtmp_live')

    return (real_url)


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('url')
    parser.add_argument('ratio', nargs='?', default='3')
    args = parser.parse_args()

    rid = args.url
    rate = args.ratio

    flv_url = get_api(rid, rate)

    print(flv_url)