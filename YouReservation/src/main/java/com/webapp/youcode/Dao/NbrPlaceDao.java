package com.webapp.youcode.Dao;
import com.webapp.youcode.model.*;
import java.util.List;

public interface NbrPlaceDao {

    public void addPlace(NbrPlace nbrPlace);

    public List<NbrPlace> placeList();

    public void removePlace(int id);

    public NbrPlace getPlace(int id);

    public void editPlace(NbrPlace nbrPlace);
}
