<%--
  Created by IntelliJ IDEA.
  User: songguohua
  Date: 2018/5/11
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%--<h1>登录成功</h1>--%>
 <h1>request内置对象</h1>
 用户名：<%=request.getParameter("username")%>
 密码：<%=request.getParameter("password")%>
 爱好：<%=request.getParameterValues("favorite")%>
 <hr>


</body>
</html>
