package com.example.jobapp.service;

import com.example.jobapp.model.JobPost;
import com.example.jobapp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepo repo;
    // Constructor-based dependency injection


    public void addJob(JobPost job){
        repo.addJob(job);
    }
    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }
}
