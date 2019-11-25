package com.barbet.gauthier.services;

import java.util.ArrayList;
import java.util.List;

import com.barbet.gauthier.exception.UpdateException;
import com.barbet.gauthier.models.IDao;
import com.barbet.gauthier.models.T;

public class SalleService implements IDao {

	private List<T> t;
	
	public SalleService() {
		super();
		t = new ArrayList<T>();
	}

	@Override
	public boolean create(T o) {
		return t.add(o);
	}

	@Override
	public boolean delete(T o) {
		return t.remove(o);
	}

	@Override
	public boolean update(T o, int id) throws UpdateException {
		// update necessite de rajouter l'id
		try {
			t.set(id, o);
			return true;
		} catch (IndexOutOfBoundsException e) {
			throw new UpdateException("Id " + id + " not in the list", e);
		}
	}

	@Override
	public T findById(int id) {
		return t.get(id);
	}

	@Override
	public List<T> findAll() {
		return t;
	}

	/**
	 * @return the t
	 */
	public List<T> getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(List<T> t) {
		this.t = t;
	}

	@Override
	public boolean update(T o) {
		// TODO Auto-generated method stub
		return false;
	}


}
