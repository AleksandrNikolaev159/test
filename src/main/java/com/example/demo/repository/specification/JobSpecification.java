package com.example.demo.repository.specification;

import com.example.demo.model.Job;
import com.example.demo.filter.JobFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class JobSpecification implements Specification<Job> {

    private final JobFilter jobFilter;
    public JobSpecification(JobFilter jobFilter) {
        this.jobFilter = jobFilter;
    }
    @Override
    public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if(jobFilter.getId() != null)
            predicates.add(criteriaBuilder.equal((root.get("id")), jobFilter.getId()));

        if (jobFilter.getType() != null)
            predicates.add(criteriaBuilder.equal(root.get("type"), jobFilter.getType()));

        if (jobFilter.getUser() != null)
            predicates.add(criteriaBuilder.equal(root.get("user"), jobFilter.getUser()));

        if (jobFilter.getDevice() != null)
            predicates.add(criteriaBuilder.equal(root.get("device"), jobFilter.getDevice()));

        if (jobFilter.getAmount() != null)
            predicates.add(criteriaBuilder.equal(root.get("amount"), jobFilter.getAmount()));

        if (jobFilter.getTimeFrom() != null)
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("time"), jobFilter.getTimeFrom()));

        if (jobFilter.getTimeTo() != null)
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("time"), jobFilter.getTimeTo()));

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    }
}
