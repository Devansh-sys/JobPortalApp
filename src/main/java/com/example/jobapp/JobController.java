package com.example.jobapp;
import com.example.jobapp.model.JobPost;
import com.example.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService service;
    // This method handles requests to the root URL ("/") and the "/home" URL
    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }
    //getmapping is specifically for get method
    @GetMapping("/viewalljobs")
    public String viewalljobs(Model m){
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }

    @GetMapping("/addjob")
    public String addjob(){
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        System.out.println("Job Post: " + jobPost);
        return "success";
    }



}
