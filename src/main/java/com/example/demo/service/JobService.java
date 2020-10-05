package com.example.demo.service;

import com.example.demo.filter.JobFilter;
import com.example.demo.model.Job;

import java.util.List;
import java.util.Map;

public interface JobService {

       List <Job> findAll();

       List saveAll(List<Job> jobList);

       List<Job> findByParams(JobFilter jobFilter);

       Map<String,Long> responseMap(List<Job> jobList);


}
