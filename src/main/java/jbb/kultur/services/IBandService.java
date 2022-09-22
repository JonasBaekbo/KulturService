package jbb.kultur.services;

import jbb.kultur.models.Band;

import java.util.List;

public interface IBandService extends ICrudService<Band,Long>{
    List<Band> findBandByName(String name);
}
