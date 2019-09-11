<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">


<style>
body {
background-color:  lightblue;
	width: 100%;
	margin: auto;
	padding: 50px;
	text-align: center;
}
</style>


</head>

<body>

	<div class="row">
		<div class="col l3 m3 s12"></div>
		<div class="col l6 m6 s12">
			<form action="./Login" method="POST">
				<nav>
					<div class="nav-wrapper grey darken-4">
						<ul id="nav-mobile" class="left hide-on-med-and-down">
							<li><a href="login.jsp">Login</a></li>
							<li><a href="Cadastro.jsp">Cadastro</a></li>


						</ul>
					</div>
				</nav>

				<div class="card-panel z-depth-5">
					<h5 class="center">Login</h5>
					<div class="input-field">
						<i class="material-icons prefix">account_circle</i> <input
							type="text" name="username"> <label> Usuario</label>
					</div>


					<div class="input-field">
						<i class="material-icons prefix">lock</i> <input type="password"
							name="password"> <label>Senha</label>
					</div>

					<input type="submit" name="submit" value="Entrar"
						class="btn left col s12  blue darken-1">


					<div class="clearfix"></div>
				</div>
			</form>

		</div>

	</div><script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>