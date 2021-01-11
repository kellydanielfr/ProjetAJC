<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Espace manager</title>
</head>
<body>
<h1>${test}</h1>
	<a id="btnDisconnect" href="disconnect"><input type="button"
		class="btn btn-danger" value="Se deconnecter"></a>
	<div id="content">

		<div class="tab-content" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-emp" role="tabpanel"
				aria-labelledby="pills-emp-tab">

				<h1>Validation des demandes en attentes</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nom du demandeur</th>
							<th>Type de demande</th>
							<th>Date de début</th>
							<th>Date de fin</th>
							<th>Nombre de jour</th>
							<th>Motif</th>
							<th>Service</th>
						</tr>
					</thead>
					<tbody id="listDemande">
						<c:forEach items="${demandes}" var="demande">
							<tr>
								<td>${demande.salarie.nom} ${demande.salarie.prenom}</td>
								<td>${demande.typeConge}</td>
								<td>${demande.dateDebut}</td>
								<td>${demande.dateFin}</td>
								<td>${demande.nbJour}</td>
								<td>${demande.motif}</td>
								<td>${demande.salarie.service.libelle}</td>
								<td><form class="formReponse" name="formReponse" action="manager" method="post">
									<input type="hidden" value="${demande.id}" name="id_conge">
									<input type="submit" class="btn btn-success" name="btnReponse"value="Valider">
									<input type="submit" name="btnReponse" class="btn btn-danger" value="Refuser">
								</form></td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>