#!/usr/bin/env python
# -*- coding: utf-8 -*
import requests
import json

def rob01sign():
    headers = {'Host': 'api.xiaoheihe.cn',
               'Accept': '*/*',
               'Cookie': 'pkey=MTU1MDczNzQ3OS4xOV82NjAyODU4b2lmbmpjb2poc2RjaWJxaw____;hkey=143597e3a2082b4c099cc0e4c9e14314',
               'User-Agent': 'xiaoheihe/1.1.53 (iPhone; iOS 12.1.2; Scale/3.00)',
               'Accept-Language': 'zh-Hans-US;q=1, en-US;q=0.9',
               'Referer': 'http://api.maxjia.com/'}
    api_url = "https://api.xiaoheihe.cn/task/sign/?lang=zh-cn&os_type=iOS&os_version=12.1.2&_time=1550737479&version=1.1.53&device_id=F6EC84D6-EBA5-41E0-9285-CBF6D8CB4500&heybox_id=6602858&hkey=005ceca8ce72a3794b9319f79433324c"
    r = requests.get(api_url, headers=headers)
    print r.text
    status = r.json()['status']
    msg = r.json()['msg']
    text = "iPhoneX sign task "+status
    if len(msg) > 0:
        text + "\n" + msg
    return text

def rob02sign():
    headers = {'Host': 'api.xiaoheihe.cn',
               'Accept': '*/*',
               'Cookie': 'pkey=MTU1MTA2MjU5Ni4xMV8xNDYzMDk0N2d4bHZlbHV4dGltY2dtaG8__;hkey=fc1cd81ddbc5c3767ad4dfc4bd4cb430',
               'User-Agent': 'xiaoheihe/1.1.54 (iPad; iOS 11.3; Scale/2.00)',
               'Accept-Language': 'zh-Hans-CN;q=1',
               'Referer': 'http://api.maxjia.com/'}
    api_url = "https://api.xiaoheihe.cn/task/sign/?lang=zh-cn&os_type=iOS&os_version=11.3&_time=1551062596&version=1.1.54&device_id=953949AB-0FCB-43D4-8707-392B66288B9B&heybox_id=14630947&hkey=66a9d694c5aa269e47c844b7423e3da5"
    r = requests.get(api_url, headers=headers)
    print(r.text)
    status = r.json()['status']
    msg = r.json()['msg']
    text = "iPad sign task " + status
    if len(msg) > 0:
        text + "\n" + msg
    return text

def dingMsg(text):
    headers = {'Content-Type': 'application/json;charset=utf-8'}
    api_url = "https://oapi.dingtalk.com/robot/send?access_token=7e6f02c3087edd19362340532a116a1f98d5b4310dba34685560598dc3803ccf"
    json_text = {
        "msgtype": "text",
        "at": {
            "atMobiles": [
                "18667905583"
            ],
            "isAtAll": False
        },
        "text": {
            "content": text
        }
    }
    requests.post(api_url, json.dumps(json_text), None, headers=headers)

msg_text = rob01sign() + "\n" + rob02sign()
dingMsg(msg_text)