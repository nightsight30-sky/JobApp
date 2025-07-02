package com.example.jobapp.service;

import com.example.jobapp.model.Job;
import com.example.jobapp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repo;

    public Job save(Job job) {
        return repo.save(job);
    }

    public List<Job> getAll() {
        return repo.findAll();
    }

    public Job getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Job update(Long id, Job newJob) {
        Job job = repo.findById(id).orElse(null);
        if (job != null) {
            job.setDescription(newJob.getDescription());
            job.setCompany(newJob.getCompany());
            job.setYearsOfExperience(newJob.getYearsOfExperience());
            return repo.save(job);
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
