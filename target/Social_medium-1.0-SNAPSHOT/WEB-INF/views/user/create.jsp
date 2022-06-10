<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 19-May-22
  Time: 08:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-9">
                    <%--@elvariable id="userDto" type=""--%>
                    <form:form action="${pageContext.request.contextPath}/user/add" method="POST" modelAttribute="userDto" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <form:input type="text" cssClass="form-control" id="name" placeholder="Name" path="name"/>
                        </div>
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <form:input type="email" cssClass="form-control" id="email" placeholder="Email" path="email"/>
                        </div>

                        <div class="form-group">
                            <label for="password">Password</label>
                            <form:input type="password" cssClass="form-control" id="password" placeholder="Password" path="password"/>
                        </div>
                        <form:select cssClass="dropdown" path="location">
                            <form:option selected="true" value="Select Location" disabled="true"/>
                            <form:options items="${locationList}"/>
                        </form:select>
                        <br>
                        <input path="profileImage" type="file" accept="image/*" />
                        <button type="submit" class="btn btn-primary">Create</button>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
