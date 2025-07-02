package com.example.jobapp.controller;

import com.example.jobapp.model.Job;
import com.example.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return service.save(job);
    }

    @GetMapping
    public List<Job> getJobs() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Job getJob(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        return service.update(id, job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        service.delete(id);
        return "Deleted job with id: " + id;
    }
}
