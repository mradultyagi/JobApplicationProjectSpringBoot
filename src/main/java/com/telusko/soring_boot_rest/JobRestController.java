package com.telusko.soring_boot_rest;

import com.telusko.soring_boot_rest.model.JobPost;
import com.telusko.soring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getalljobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobPost getJob(@PathVariable("id") int id){
        return service.getJob(id);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable int id){
        service.deleteJob(id);
        return "Job with id " + id + " has been deleted.";
    }
}
