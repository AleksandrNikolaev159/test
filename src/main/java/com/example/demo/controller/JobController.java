package com.example.demo.controller;

import com.example.demo.filter.JobFilter;
import com.example.demo.model.Job;
import com.example.demo.service.JobService;
import com.example.demo.service.XmlParser;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @Autowired
    private XmlParser xmlParser;

    private static final Gson gson = new Gson();

    @PostMapping(value = "jobs", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postJob(@RequestBody String requestBody){
        List<Job> jobList = xmlParser.xmlParse(requestBody) ;
        jobService.saveAll(jobList);
        return new ResponseEntity(gson.toJson(jobService.responseMap(jobList)),HttpStatus.OK);
    }

    @GetMapping(value = "/statistics")
    public ResponseEntity <Set<Job>> getJob (@ModelAttribute JobFilter jobFilter){
        return new ResponseEntity(jobService.findByParams(jobFilter),HttpStatus.OK);
    }
}
