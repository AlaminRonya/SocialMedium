<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/9/2022
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Name: ${user.getName()}<br>
Email: ${user.getEmail()}<br>
Location: ${user.getLocation().getLocationName()}<br>
Attachment Path: <img src="/images/${user.getAttachment().getAttachmentPath()}" alt="${user.getAttachment().getAttachmentPath()}"/> <br>

</body>
</html>
