package com.example.demo.serviceimpl;

import com.example.demo.filter.JobFilter;
import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.specification.JobSpecification;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Transactional
@Repository
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public List saveAll(List<Job> jobList) {
        return jobRepository.saveAll(jobList);
    }

    @Override
    public List<Job> findByParams(JobFilter jobFilter) {
        List<Job> jobList = jobRepository.findAll(new JobSpecification(jobFilter));
        Collections.sort(jobList, (o1, o2) -> (o1.getTime().before(o2.getTime())) ? -1 : (o1.getTime().after(o2.getTime())) ? 1 : 0);
        return jobList;
    }

    @Override
    public Map<String,Long> responseMap(List<Job> jobList) {
        Map<String,Long> responseMap = new LinkedHashMap<>();
        for (Job job : jobList){
            if (responseMap.containsKey(job.getUser())){
                responseMap.put(job.getUser(), responseMap.get(job.getUser()) + job.getAmount());
            }
            else {
                responseMap.put(job.getUser(), job.getAmount());
            }
        }
        return responseMap;
    }
}


