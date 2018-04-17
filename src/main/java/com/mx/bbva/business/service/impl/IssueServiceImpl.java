package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Issue;
import com.mx.bbva.business.repository.IssueRepository;
import com.mx.bbva.business.service.IssueService;
import com.mx.bbva.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    private IssueRepository issueRepository;

    @Override
    public void saveIssue(Issue issue) {
        issue.setIssueUploadDate(new DateUtils().getCurrentDate());
        issueRepository.save(issue);
    }

    @Override
    public Issue findIssue(Integer issueId) {
        return issueRepository.findById(issueId).orElse(null);
    }

    @Override
    public List<Issue> findAll() {
        return issueRepository.findAll();
    }

    @Autowired
    public void setIssueRepository(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }
}
