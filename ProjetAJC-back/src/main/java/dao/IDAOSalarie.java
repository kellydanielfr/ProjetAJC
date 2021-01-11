package dao;

import java.util.List;

import model.Salarie;

public interface IDAOSalarie extends IDAO<Salarie,Integer>{

	public List<Salarie> findAllFilter(String name);
}
