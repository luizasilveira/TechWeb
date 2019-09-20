<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>



<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">


<style>
body {
	background-color: lightblue;
	width: 70%;
	margin: auto;
	padding: 50px;
	text-align: center;
}
</style>
</head>

<body>
	<form action="adicionaCliente" method="post">

		<nav>
			<div class="nav-wrapper  grey darken-4 ">
				<ul id="nav-mobile" class="left hide-on-med-and-down">
					<li><a href="login">Login</a></li>
					<li><a href="addClient">Adicionar</a></li>
					<li><a href="lista.jsp">Clientes</a></li>

				</ul>
			</div>
		</nav>

		<div class="card-panel z-depth-5">
			<h5 class="center">Novo cliente</h5>
			<div class="row">
				<div class="col s6">


					<div class="input-field">
						<input type="text" name="name"> <label>nome</label>
					</div>

					<div class="input-field">

						<input type="text" name="birth"> <label>Data
							de Nascimento</label>
					</div>

					<div class="input-field">

						<input type="text" name="CPF"> <label>CPF</label>
					</div>
				</div>

				<div class="col s6">
					<div class="input-field">

						<input type="text" name="adress"> <label>endereço</label>
					</div>

					<div class="input-field">

						<input type="text" name="celphone"> <label>Celular</label>
					</div>
				</div>



				<input type="submit" name="submit" value="Adicionar"
					class="btn left col s12  blue darken-1">

				<div class="clearfix"></div>


			</div>
		</div>
	</form>



	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>