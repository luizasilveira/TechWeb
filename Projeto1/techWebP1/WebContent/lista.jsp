<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import=" javax.servlet.http.HttpServlet"%>
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
		<div class="nav-wrapper grey darken-4">
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="login.jsp">Login</a></li>
				<li><a href="add.html">Adicionar</a></li>
				<li><a href="lista.jsp">Clientes</a></li>

			</ul>
		</div>
	</nav>

	<div class="card-panel z-depth-5">
		<h5 class="center">Clientes</h5>
		<%@ page import="java.util.*,techWebP1.*"%>
		<table class="centered">




			<thead>
				<tr>

					<th>Nome</th>
					<th>Nascimento</th>
					<th>CPF</th>
					<th>Endere�o</th>
					<th>Celular</th>
				</tr>
			</thead>

			<%
			DAO dao = new DAO();
			int id = (int) session.getAttribute("lojaid");
			System.out.println(id);
			List<Clients> clientes = dao.getClientes(id);
			for (Clients cliente : clientes) {
			%>


			<tbody>
				<tr>

					<td><%=cliente.getName()%></td>
					<td><%=cliente.getBirth()%></td>
					<td><%=cliente.getCPF()%></td>
					<td><%=cliente.getAdress()%></td>
					<td><%=cliente.getCelphone()%></td>

					<td>
						<form action="./RemoveClient" method="post">
							<button class="waves-effect waves-light btn-small  blue darken-1"
								type="submit" name="action">Remover</button>
							<input class="hide" type="text" value="<%=cliente.getId()%>"
								name="id">
						</form>
					</td>

					<td>
						<form action="./ClientData.jsp" method="post">
							<button class="waves-effect waves-light btn-small  blue darken-1"
								type="submit" name="action">editar</button>
							<input class="hide" type="text" value="<%=cliente.getId()%>"
								name="id">

						</form>
					</td>
				</tr>
			</tbody>
			<% } %>
		</table>
	</div>


	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>


</body>
</html>