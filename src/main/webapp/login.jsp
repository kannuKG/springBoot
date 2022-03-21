<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }

    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
   
</style>
</head>

<body>
	<div class="login-form">
		<h2 class="text-left">Login</h2>
		<form action="login">
		
		
		<div class="form-group">
			<br> Username :  <input type="text" class="form-control" name="username" required><br>
	    </div>
			<br> Password :  <input type="password" class="form-control" name="password" required><br>
			<a href="#" class="pull-right">Forgot Password?</a><br>
			<br> <input type="submit" value="Login"  class="pull-right">
		</form>
	</div>
</body>
</html>