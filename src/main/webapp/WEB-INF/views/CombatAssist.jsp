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
	    <ul>
          <li><a href="/DnDCombatant/">Home</a></li>
          <li><a href="/DnDCombatant/CharacterSheet/">Character Sheets</a></li>
          <li><a class="active" href="/DnDCombatant/CombatAssist/">Combat Assist</a></li>
        </ul>

		<div class="center">
		    <h1>Combat Assist</h1>
		    <p>Damage and hit chance averages for your D&D Combat actions.</p>
		</div>


	</body>
</html>