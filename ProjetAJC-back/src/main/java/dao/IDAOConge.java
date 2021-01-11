package dao;

import java.util.List;

import model.Conge;

public interface IDAOConge extends IDAO<Conge,Integer>{

	public List<Conge> findAllFilter(String name);

	public List<Conge> demandeAttente();
}
