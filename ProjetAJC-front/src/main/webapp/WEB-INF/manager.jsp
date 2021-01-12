<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Espace manager</title>
</head>
<body>
	<a id="btnDisconnect" href="disconnect"><input type="button"
		class="btn btn-danger" value="Se deconnecter"></a>

	<h1>Validation des demandes en attentes</h1>

	<a href="#filtres" data-toggle="collapse">Voir filtres</a>
	<div id="filtres" class="collapse">
	<form  class="formReponse" name="formReponse" action="manager" method="post">
	<div name="filtre" style="display: flex">
		<label for="dateDebutFiltre">Date de début :</label> <input id="dateDebutFiltre" name="dateDebutFiltre" type="date" onchange="dateFinMinFiltre()"><br>
		<label for="dateFinFiltre">Date de fin :</label> <input id="dateFinFiltre" name="dateFinFiltre" type="date" value="" min="">	
	<label for="service">Services : </label> <select id="service" name="service">
							<option value="" selected="selected">Choisir un service</option>
							<c:forEach items="${services}" var="service">
							<option value="${service.id}">${service.libelle}</option>
							</c:forEach>
						</select>
						</div>
	<button type="submit" name="btnFiltre" class="btn btn-primary" name="btnFiltre" value="Filtrer">Filtrer</button>
	<button type="submit" name="btnFiltreOff" class="btn btn-primary" name="btnFiltreOff" value="FilbtnFiltreOfftrer">Supprimer les filtres</button>
	<button type="submit" name="btnAll" class="btn btn-primary" name="btnAll" value="btnAll">Voir toutes les demandes de congé</button>
	</form>
	</div>
	
	<div id="content">
		<div class="tab-content" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-emp" role="tabpanel"
				aria-labelledby="pills-emp-tab">
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
							<th></th>
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
								<td>
								<c:if test="${demande.etat == 'ATTENTE'}">
								<input type="submit" class="btn btn-success"
									name="btnReponse" value="Valider">
									<button type="button" name="btnReponse" class="btn btn-danger"
										value="Refuser" data-toggle="modal"
										data-target="#popupRefuser">Refuser</button> <!-- Modal -->
									<div class="modal fade" id="popupRefuser" tabindex="-1"
										role="dialog" aria-labelledby="popupRefuserLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="popupRefuserLabel">Motif
														du refus</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<form class="formReponse" name="formReponse"
													action="manager" method="post">
													<div class="modal-body">
														<input type="hidden" value="${demande.id}" name="id_conge">
														<label for="motif">Motif du refus</label>
														<textarea required class="form-control" name="motif"
															id="motif" rows="3" placeholder="Entrez un motif"></textarea>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Fermer</button>
														<button type="submit" name="btnReponse"
															class="btn btn-primary" name="btnRefuser" value="Refuser">Sauvegarder</button>
													</div>
												</form>
											</div>
										</div>
									</div>
									</c:if></td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script>
	//$('#myModal').on('shown.bs.modal', function () {$('#myInput').trigger('focus')})

	function dateFinMinFiltre() {
		dateFinFiltre.value = dateDebutFiltre.value;
		dateFinFiltre.min = dateDebutFiltre.value;
	}
</script>
</html>