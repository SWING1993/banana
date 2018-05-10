<%--
  Created by IntelliJ IDEA.
  User: songguohua
  Date: 2018/5/10
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1> 这是一个H1标签</h1>
  <%
    System.out.println("哈哈哈哈");

  %>

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

  <%--<br>你好，<%=s%></br>--%>
  <%--<br>3+5=<%=add(3,5)%></br>--%>
  <%--<br>日期：<%=date%></br>--%>


  </body>
</html>
