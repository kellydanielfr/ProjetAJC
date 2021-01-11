package dao;

import java.util.List;

import model.Service;

public interface IDAOService extends IDAO<Service,Integer>{

	public List<Service> findAllFilter(String name);
}
