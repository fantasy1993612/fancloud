package com.fantasy.eurekaclient;

import com.fantasy.eurekaclient.dao.StudentRepository;
import com.fantasy.eurekaclient.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaclientApplicationTests {

	@Autowired
	private StudentRepository userRepository;

	@Test
	public void testRepository() {
		Student student = new Student();
		student.setEmail("fsdff");
		student.setLastName("dsdf");
		Student s = userRepository.save(student);
	}

}
