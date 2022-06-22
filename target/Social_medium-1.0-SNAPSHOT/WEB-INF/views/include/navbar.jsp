<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand 'Oswald', sans-serif !important text-capitalize font-weight-bold" href="#">
<%--            Rejection is free learning--%>
            <%--                <img th:src="@{/images/logo.png}"  src="../static/images/logo.png" width="auto" height="40" class="d-inline-block align-top" alt=""/>--%>
            <i class="fa-brands fa-java"></i>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto"></ul>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/" >Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link"  href="${pageContext.request.contextPath}/users/v1/user/add">Add User</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link"  href="${pageContext.request.contextPath}/locations/v1/location/insert">Add Location</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link"  href="${pageContext.request.contextPath}/status/v1/status/create">Add Status</a>
                </li>
            </ul>

        </div>
    </div>
</nav>