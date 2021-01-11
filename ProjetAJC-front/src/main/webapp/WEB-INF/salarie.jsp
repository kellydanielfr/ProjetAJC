<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Admin</title>

</head>
<body>
<h1>Salarié</h1>
<!--
	<a id="btnDisconnect" href="disconnect"><input type="button" class="btn btn-danger" value="Se deconnecter"></a>

				<h1>Mon profil</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Login</th>
							<th>Password</th>
							<th>Mail</th>
							<th>PC</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						

							<tr>
								<td>${emp.login}</td>
								<td>${emp.password}</td>
								<td>${emp.mail}</td>
								<td>${emp.pc.id}-${emp.pc.marque}</td>
								<td><input  onclick="updateEmp()" type="button" class="btn btn-warning" value="Modifier">
								</td>
							</tr>

					</tbody>
				</table>

				<div id="updateFormEmp">
					<h3>Modifier l'employé</h3>
					<form action="emp" method="post">

						<input value="${emp.id}" type="hidden" name="id_emp">
						<input value="${emp.pc.id}" type="hidden"  name="id_pc">
						<label
							for="update_login">Login :</label> <input required
							id="update_login" name="login" value="${emp.login}" type="text"
							placeholder="Saisir votre login"><br> <label
							for="update_password">Password :</label> <input required
							value="${emp.password}" name="password" type="password"
							placeholder="Saisir votre password"><br> <label
							for="update_mail">Mail :</label> <input required name="mail" value="${emp.mail}" type="email"
							placeholder="Saisir votre mail"><br>
							
							<input name="btnForm" class="btn btn-warning"
							type="submit" value="Modifier">
					</form>
				</div>
 -->
</body>
</html>




<script>


//GESTION Employé

function updateEmp()
{
	updateFormEmp.style.display="block";
}

</script>