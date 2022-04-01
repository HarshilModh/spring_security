<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Sign Up works

<form action="/public/saveuser" method="post">
	Username : <input type="text" name="username"/><br><br>

	Password : <input type="password" name="password"/><br><br>
	<input type="hidden" name="${_csrf.parameterName}" value=${_csrf.token}/>

	<input type="submit"  value="Signup" />


</form>
</body>
</html>