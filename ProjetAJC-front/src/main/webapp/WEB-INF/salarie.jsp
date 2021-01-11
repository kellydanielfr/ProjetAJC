<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Admin</title>

</head>
<body>
	<a id="btnDisconnect" href="disconnect"><input type="button"
		class="btn btn-danger" value="Se deconnecter"></a>


	<h1>Mes demandes</h1>
	<input id="btnAddEmp" type="button" class="btn btn-success"
		value="Créer une demande de congé">
	<br>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Type de demande</th>
				<th>Date de début</th>
				<th>Date de fin</th>
				<th>Nombre de jour</th>
				<th>Motif</th>
				<th>Service</th>
				<th>Etat</th>
			</tr>
		</thead>
		<tbody id="listDemande">
			<c:forEach items="${demandes}" var="demande">
				<tr>
					<td>${demande.typeConge}</td>
					<td>${demande.dateDebut}</td>
					<td>${demande.dateFin}</td>
					<td>${demande.nbJour}</td>
					<td>${demande.motif}</td>
					<td>${demande.salarie.service.libelle}</td>
					<td>${demande.etat}</td>
					<c:if test="${demande.etat == 'ATTENTE'}">
						<td><form class="formReponse" name="formReponse"
								action="salarie" method="post">
								<input type="hidden" value="${demande.id}" name="id_conge">
								<input type="submit" name="btnAnnuler" class="btn btn-danger"
									value="Annuler">
							</form></td>
					</c:if>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>