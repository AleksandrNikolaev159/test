package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "users")
    private String user;

    @Column(name = "device")
    private String device;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time = new Date();
}
