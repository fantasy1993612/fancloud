package com.fantasy.eurekaclient.dao;

import com.fantasy.eurekaclient.entity.Student;
import com.fantasy.eurekaclient.service.IStudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail(String email);

    @Query(nativeQuery = true,
            value = "SELECT cl.student_id AS studentId,st.last_name AS lastName " +
                    "FROM class cl,student st " +
                    "WHERE cl.student_id = st.oid")
    List<IStudentInfo> getStudentInfo();

    Optional<Student> findByOidAndEmailAndLastName(Integer oid,String email,String lastName);

}
