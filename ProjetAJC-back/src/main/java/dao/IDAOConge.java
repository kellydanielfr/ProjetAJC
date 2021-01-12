package dao;

import java.time.LocalDate;
import java.util.List;

import model.Conge;

public interface IDAOConge extends IDAO<Conge,Integer>{


	public List<Conge> demandeAttente();

	List<Conge> demandeSalarie(Integer Id);

	
	List<Conge> findAllFilterByService(Integer id);

	List<Conge> findAllFilterByDate(LocalDate dateDebut, LocalDate dateFin);

	List<Conge> findAllFilterByServiceDate(Integer id, LocalDate dateDebut, LocalDate dateFin);
}
