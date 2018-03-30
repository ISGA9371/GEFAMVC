package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Environment;

import java.util.List;

public interface EnvironmentService {
    List<Environment> findAllEnvironments();
}
