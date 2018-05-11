<%--
  Created by IntelliJ IDEA.
  User: songguohua
  Date: 2018/5/10
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1> 这是一个H1标签</h1>

  <%!
    String printlnString() {

        String s = "";

        for (int x = 1; x < 10; x++) {
          for (int y = 1; y < x + 1; y++) {
              s += String.valueOf(x) +"*"+ String.valueOf(y) + "="+ String.valueOf(x*y) + "  ";
          }
          s += "</br>";
        }

        return s;
    }


  %>
  <br><%=printlnString()%></br>

  <h1>用户登录</h1>
  <hr>
  <form action="dologin.jsp" name="loginForm" method="post">
    <table>
      <tr>
        <td>用户名：</td>
        <td><input type="text" name="username"/></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="password" name="password"/></td>
      </tr>
      <tr>
        <td>爱好：</td>
        <td>
          <input type="checkbox" name="favorite" value="read">读书
          <input type="checkbox" name="favorite" value="movie">电影
          <input type="checkbox" name="favorite" value="music">音乐
          <input type="checkbox" name="favorite" value="internet">上网
        </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="登录"></td>
      </tr>
    </table>
  </form>

  </body>
</html>
