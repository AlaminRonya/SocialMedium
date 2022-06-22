<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 6/8/2022
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <jsp:include page="../include/css.jsp"/>
    </head>
    <body>
    <jsp:include page="../include/navbar.jsp"/>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-9">
                    <%--@elvariable id="locationDto" type=""--%>
                    <form:form action="${pageContext.request.contextPath}/locations/v1/location/insert" method="post" modelAttribute="locationDto" >
                        <div class="form-group">
                            <label for="name">Name</label>
                            <form:input type="text" cssClass="form-control" id="name" placeholder="Location Name" path="locationName"/>
                        </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
