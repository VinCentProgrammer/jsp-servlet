<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
            crossorigin="anonymous"></script>

    <%
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
    %>

    <link href="<%=url%>/public/css/login.css" rel="stylesheet">
</head>
<body class="text-center">

<%
    String loginError = request.getAttribute("loginError") + "";
    loginError = loginError.equals("null") ? "" : loginError;

    String username = request.getAttribute("username") + "";
    username = username.equals("null") ? "" : username;
    String password = request.getAttribute("password") + "";
    password = password.equals("null") ? "" : password;
%>


<main class="form-signin">
    <form action="login-action" method="POST">
        <img class="mb-4"
             src="https://getbootstrap.com/docs/5.0/assets/brand/bootstrap-logo.svg"
             alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">Login</h1>

        <p class="text-red"><%=loginError%>
        </p>

        <div class="form-floating">
            <input type="text" class="form-control" id="username"
                   placeholder="Enter username..." value="<%=username%>">
            <label for="username">Username</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password"
                   placeholder="Enter password..."> <label for="password">Password</label>
        </div>

        <div class="checkbox mb-3">
            <label> <input type="checkbox" value="remember-me">
                Remember me
            </label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign
            in
        </button>
        <a class="btn btn-primary w-100 mt-2" style="white-space: nowrap;"
           href="register.jsp"> Đăng ký </a>
        <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
    </form>


</main>

</body>
</html>