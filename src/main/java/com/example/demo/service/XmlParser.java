package com.example.demo.service;

import com.example.demo.model.Job;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class XmlParser {

    private static final Logger logger = LoggerFactory.getLogger(XmlParser.class);

    XmlMapper mapper = new XmlMapper();

    public List<Job> xmlParse (String xmlString)  {
        try {
            return mapper.readValue(xmlString, new TypeReference<List<Job>>() {
                    }
            );
        } catch (JsonProcessingException e) {
            logger.error("Error for parsing xml file", e);
        }
        return Collections.emptyList();
    }
}
