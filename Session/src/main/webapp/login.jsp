<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Login</title>
</head>
<body>
	<form id="form-login" action="login-action" method="POST">
		<table>
			<tr>
				<td colspan="2">Login Form</td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input id="username" name="username"
					placeholder="Username..." type="text" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="password" name="password"
					placeholder="Password..." type="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>