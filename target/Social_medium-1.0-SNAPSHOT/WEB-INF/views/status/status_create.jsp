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
        <title>Status</title>
        <jsp:include page="../include/css.jsp"/>
    </head>
    <body>
    <jsp:include page="../include/navbar.jsp"/>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-9">

                <%--@elvariable id="statusDto" type="com.alamin.dto.StatusDto"--%>
                <form:form action="${pageContext.request.contextPath}/status/v1/status/add" method="post" modelAttribute="statusDto" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="title">Title</label>
                        <form:input type="text" cssClass="form-control" id="title" placeholder="" path="title"/>
                    </div>

                    <div class="form-group">
                        <label for="description">Description</label>
                        <form:textarea cssClass="form-control" path="description"/>
                    </div>

                    <form:select cssClass="dropdown" path="location">
                        <form:option selected="true" value="Select Location" disabled="true"/>
                        <form:options items="${locationList}"/>
                    </form:select>

                    <br>
                    <br>

                    <form:select cssClass="dropdown" path="privacy">
                        <form:option selected="true" value="Select Privacy" disabled="true"/>
                        <form:options items="${privacyList}"/>
                    </form:select>

                    <br>
                    <br>

                    <input type="file" name="images" multiple="multiple" accept="image/*"/>

                    <button type="submit" class="btn btn-primary">Create</button>
                </form:form>
            </div>
        </div>
    </div>

</body>
</html>
