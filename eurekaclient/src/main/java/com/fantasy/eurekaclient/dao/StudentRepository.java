package com.fantasy.eurekaclient.dao;

import com.fantasy.eurekaclient.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail(Integer oid);
}
