package com.dbserver.almoco.democratico.service;

import com.dbserver.almoco.democratico.model.BrazilCity;

import java.util.List;
import java.util.Optional;

public interface BrazilCityService {

    List<BrazilCity> findBrazilCityByState(String state);
    public List<BrazilCity> findAllCityNameByStateIgnoreCase(String state);
    BrazilCity create(BrazilCity brazilCity);
}
