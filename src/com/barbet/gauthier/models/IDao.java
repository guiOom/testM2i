package com.barbet.gauthier.models;

import java.util.List;

import com.barbet.gauthier.exception.UpdateException;

public interface IDao {
	
	public boolean create ( T o);
	public boolean delete ( T o);
	public boolean update ( T o);
	public T findById (int id);
	public List <T> findAll ( );
	boolean update(T o, int id) throws UpdateException;
}
