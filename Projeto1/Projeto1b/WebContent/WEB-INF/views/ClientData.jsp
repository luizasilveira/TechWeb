<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import=" javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



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



	<nav>
		<div class="nav-wrapper  grey darken-4 ">
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="Login">Login</a></li>
				<li><a href="addClient">Adicionar</a></li>
				<li><a href="listaCliente">Clientes</a></li>

			</ul>
		</div>
	</nav>
	<form action="update" method="post">
		<div class="card-panel z-depth-5">
			<h5 class="center">Dados do cliente</h5>
			<%@ page import="java.util.*,mvc.model.*"%>

			<table class="centered">




				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Nascimento</th>
						<th>CPF</th>
						<th>Endereço</th>
						<th>Celular</th>
					</tr>
				</thead>


			</table>


			<c:forEach items="<%=session.getAttribute(\"clientes\")%>" var="data">



				<div class="row">


					<div class="col s2">
						<div class="input-field">
							<input type="text" name="id" value="<c:out value="${data.id}"/>">

						</div>

					</div>
					<div class="col s2">

						<div class="input-field">
							<input type="text" name="name" value="<c:out value="${data.name}"/>">

						</div>
					</div>


					<div class="col s2">

						<div class="input-field">
							<input type="text" name="birth" value="<c:out value="${data.birth}"/>">

						</div>
					</div>


					<div class="col s2">

						<div class="input-field">
							<input type="text" name="CPF" value="<c:out value="${data.CPF}"/>">

						</div>
					</div>


					<div class="col s2">


						<div class="input-field">
							<input type="text" name="adress"value="<c:out value="${data.adress}"/>">

						</div>
					</div>



					<div class="col s2">


						<div class="input-field">
							<input type="text" name="celphone"
								value="<c:out value="${data.celphone}"/>">

						</div>
					</div>

					<input type="submit" name="submit" value="Alterar"
						class="btn left col s12 blue darken-1">

				</div>
			</c:forEach>



		</div>
	</form>


	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>


</body>
</html>