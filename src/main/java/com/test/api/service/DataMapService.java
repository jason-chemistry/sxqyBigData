package com.test.api.service;


import com.test.api.mapper.DataMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataMapService {
    @Autowired
    DataMapper dataMapper;

}
