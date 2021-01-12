<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Salarie</title>
</head>
<body>
	<a id="btnDisconnect" href="disconnect"><input type="button"
		class="btn btn-danger" value="Se deconnecter"></a>


	<h1>Mes demandes</h1>

	<!-- Button trigger modal -->
	<button type="button" class="btn trigger" data-toggle="modal"
		id="popupAdd">Créer une demande de congé</button>

	
	<!-- Modal -->

		<div class="modal-wrapper" role="document">
			<div class="modalCreer">
				<div class="head">
				<a class="btn-close trigger" href="javascript:;"></a>
					<h5 class="modal-title" id="popupAjouterLabel">Créer une
						demande de congé</h5>
						
				</div>
				<form action="salarie" method="post" id="FormFiche">
					<div class="modal-body">
						<label for="date">Date de la demande :</label> ${aujourdhui}<br>
						<label for="dateDebut">Date de début :</label> <input required
							id="dateDebut" name="dateDebut" type="date" value="${today}"
							min="${today}" onchange="dateFinMin()"><br> <label
							for="dateFin">Date de fin :</label> <input required id="dateFin"
							name="dateFin" type="date" value="${today}" min="${today}"><br>
						<label for="type">Types de congé : </label> <select required
							id="type" name="type">
							<option value="" selected="selected">Choisir un type de
								congé</option>
							<option value="CP">Congés payés</option>
							<option value="CSS">Congés sans solde</option>
							<option value="AA">Absence autorisée</option>
							<option value="AJ">Absence justifiée</option>
						</select><br> <label for="motif">Motif de la demande</label>
						<textarea class="form-control" name="motif" id="motif" rows="3"
							placeholder="Entrez un motif"></textarea>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn trigger"
							data-dismiss="modal">Annuler</button>
						<button type="submit" class="btn btn-primary" id="btnSave" name="btnAjouter"
							value="Ajouter">Sauvegarder</button>
					</div>
				</form>
			</div>
		</div>
	

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
				<th></th>
			</tr>
		</thead>
		<tbody id="listDemande">
			<c:forEach items="${demandes}" var="demande">
				<tr>
					<td>${demande.typeConge.libelle}</td>
					<td>${demande.dateDebut}</td>
					<td>${demande.dateFin}</td>
					<td>${demande.nbJour}</td>
					<td>${demande.motif}</td>
					<td>${demande.salarie.service.libelle}</td>
					<c:choose>
					<c:when test="${demande.etat == 'VALIDE'}">
					<td style="color:green">${demande.etat}</td>
					</c:when>
					<c:when test="${demande.etat == 'REFUSE'}">
					<td style="color:red">${demande.etat}</td>
					</c:when>
					</c:choose>
					<c:if test="${demande.etat == 'ATTENTE'}">
						<td><form class="formReponse" name="formReponse"
								action="salarie" method="post">
								<input type="hidden" value="${demande.id}" name="id_conge">
								<input type="submit" name="btnAnnuler" class="btn btn-warning"
									value="Annuler">
							</form></td>
					</c:if>
					<td></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

</body>
<script>
	//$('#myModal').on('shown.bs.modal', function () {$('#myInput').trigger('focus')})

	function dateFinMin() {
		dateFin.value = dateDebut.value;
		dateFin.min = dateDebut.value;
	}
	
	//popup
	
	$( document ).ready(function() {
  $('.trigger').click(function() {
     $('.modal-wrapper').toggleClass('open');
    $('.modal-wrapper').toggleClass('blur');
     return false;
  });
});
</script>

</html>
