package com.example.demo.filter;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@Data
@NoArgsConstructor

public class JobFilter {

    public static final String DATE_PATTERN = "dd.MM.yyyy";
    public static final String TIME_ZONE = "Asia/Yekaterinburg";

    @XmlAttribute(name = "id")
    private Long id;

    @XmlElement(name = "type")
    private String type;

    @XmlElement(name = "user")
    private String user;

    @XmlElement(name = "device")
    private String device;

    @XmlElement(name = "amount")
    private Long amount;

    @DateTimeFormat(pattern = DATE_PATTERN)
    @JsonFormat(pattern = DATE_PATTERN, timezone = TIME_ZONE)
    private Date timeFrom;

    @DateTimeFormat(pattern = DATE_PATTERN)
    @JsonFormat(pattern = DATE_PATTERN, timezone = TIME_ZONE)
    private Date timeTo;
}
