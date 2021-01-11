package dao;

import java.util.List;

public interface IDAO<T,K> {

	public T save(T t);
	public void delete(T t);
	public T findById(K id);
	public List<T> findAll();


}
