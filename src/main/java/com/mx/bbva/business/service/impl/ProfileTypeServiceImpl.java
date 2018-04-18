package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.ProfileType;
import com.mx.bbva.business.repository.ProfileTypeRepository;
import com.mx.bbva.business.service.ProfileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileTypeServiceImpl implements ProfileTypeService {
    private ProfileTypeRepository profileTypeRepository;

    @Override
    public List<ProfileType> findAllProfileTypes() {
        return profileTypeRepository.findAll(new Sort(Sort.Direction.ASC, "profileTypeId"));
    }

    @Override
    public ProfileType findOneProfileType(Integer profileTypeId) {
        return profileTypeRepository.findById(profileTypeId).orElse(null);
    }

    @Autowired
    public void setProfileTypeRepository(ProfileTypeRepository profileTypeRepository) {
        this.profileTypeRepository = profileTypeRepository;
    }
}
