package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.ContractType;
import com.mx.bbva.business.repository.ContractTypeRepository;
import com.mx.bbva.business.service.ContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractTypeServiceImpl implements ContractTypeService {
    private ContractTypeRepository contractTypeRepository;

    @Override
    public List<ContractType> findAllContractTypes() {
        return contractTypeRepository.findAll();
    }

    @Autowired
    public void setContractTypeRepository(ContractTypeRepository contractTypeRepository) {
        this.contractTypeRepository = contractTypeRepository;
    }
}
