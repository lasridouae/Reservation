package com.webapp.youcode.Dao;

import java.util.List;

import com.webapp.youcode.Model.NbrPlace;

public interface NbrPlaceDao {

	public void create(NbrPlace nbrPlace);

	public List<NbrPlace> getAll();

	public void remove(long id);

	public NbrPlace getById(long id);

	public NbrPlace update(NbrPlace nbrPlace);
}
