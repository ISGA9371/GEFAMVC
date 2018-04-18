package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.ProfileType;

import java.util.List;

public interface ProfileTypeService {
    List<ProfileType> findAllProfileTypes();

    ProfileType findOneProfileType(Integer profileTypeId);
}
