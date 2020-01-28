package com.fantasy.eurekaclient.service;

import com.fantasy.eurekaclient.dao.StudentRepository;
import com.fantasy.eurekaclient.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RecordStudentImpl implements IRecordStudent {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Cacheable(value = "studentRecord", key = "#email", unless = "#result == null")
    public Student getStudentRecord(String email) {
        return studentRepository.findByEmail(email);
    }
}
