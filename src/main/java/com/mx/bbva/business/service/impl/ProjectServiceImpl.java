package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Project;
import com.mx.bbva.business.repository.ProjectRepository;
import com.mx.bbva.business.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project findProject(String projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
