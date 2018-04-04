package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAllProjects();

    void saveProject(Project project);

    Project findProject(Integer projectId);
}
