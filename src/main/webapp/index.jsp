<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
    .center {
        text-align: center;
    }
    ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
      background-color: #333;
    }
    li {
      float: left;
    }
    li a {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
    }
    li a:hover {
      background-color: #111;
    }
    .active {
      background-color: #04AA6D;
    }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<html>
	<head>
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" isELIgnored="false"%>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>DnDCombatant</title>
	</head>
	<body ng-app="myApp" class="ng-cloak">

		<div class="center">
		    <h1>Dungeons & Dragons Combatant</h1>
		    <p>A place to hold your character sheet and help you take optimal actions in combat</p>
		</div>



		<form action="login" method="POST" modelAttribute="user">
            <div class="formcontainer center">
                <label for="username"><span><b>Username</b></span>
                    <input id="username" type="text" placeholder="Enter username" name="username" required>
                </label>

                <br>

                <label for="password"><span><b>Password</b></span>
                    <input id="password" type="password" placeholder="Enter password" name="password" required>
                </label>

                <br>

                <button type="submit">Login</button>
                <p class="has-error">${validation}</p>
            </div>
        </form>


	</body>
</html>
