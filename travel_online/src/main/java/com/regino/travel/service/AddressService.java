package com.regino.travel.service;

import com.regino.travel.domain.Address;

import java.util.List;

public interface AddressService {

    List<Address> findByUid(int uid);

    void save(Address param);

    void deleteByAid(int aid);

    void clearDefault(int uid);

    void setAsDefault(int aid);

    void editByAid(Address param);
}
