package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Issue;

import java.util.List;

public interface IssueService {
    void saveIssue(Issue issue);

    Issue findIssue(Integer issueId);

    List<Issue> findAll();
}
