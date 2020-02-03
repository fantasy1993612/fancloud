package com.fantasy.eurekaclient;

import com.fantasy.eurekaclient.dao.StudentRepository;
import com.fantasy.eurekaclient.entity.Student;
import com.fantasy.eurekaclient.params.ActivityParam;
import com.fantasy.eurekaclient.params.DrawAwardParam;
import com.fantasy.eurekaclient.service.IActivityService;
import com.fantasy.eurekaclient.service.IDrawAwardService;
import com.fantasy.eurekaclient.service.IRecordStudent;
import com.fantasy.eurekaclient.service.IStudentInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaclientApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(EurekaclientApplicationTests.class);
    @Autowired
    private StudentRepository userRepository;

    @Autowired
    private IRecordStudent recordStudent;

    @Autowired
    private IActivityService activityService;

    @Autowired
    private IDrawAwardService drawAwardService;

    @Test
    public void testRepository() {
        Student student = new Student();
        student.setEmail("xiangming");
        //Student s = userRepository.save(student);
        Student email = userRepository.findByEmail("xiangming");
        logger.info("根据邮件名称查询：{}", email.getEmail());
        userRepository.findAll();
    }


    /**
     * 分页查询例子
     */
    @Test
    public void testPageQuery() {
        //从第一页开始每页2条
        int page = 0, size = 2;
        Sort sort = new Sort(Sort.Direction.ASC, "oid");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Student> list1 = userRepository.findAll(pageable);
        logger.info("根据邮件名称查询内容：{}，总页数：{},总条数：{}", list1.getContent(), list1.getTotalPages(), list1.getTotalElements());
    }

    /**
     * 连表查询
     */
    @Test
    public void UnionQuery() {
        List<IStudentInfo> studentInfos = userRepository.getStudentInfo();
        logger.info("查询学生信息：{}", studentInfos.toArray());
    }


    /**
     * 多条件查询
     */
    @Test
    public void multiQuery() {
        Student student = new Student();
        student.setId(1);
        student.setEmail("xiangming");
        student.setLastName("fantasy");
        Example<Student> studentExample = Example.of(student);
        Optional<Student> studentOptionl = userRepository.findOne(studentExample);
        if (studentOptionl.isPresent()) {
            logger.info("多条件查询学生信息：{}", studentOptionl.get());
        }
        //多条件查询方法2
        Optional<Student> studentOptional1 =
                userRepository.findByIdAndEmailAndLastName(1, "xiangming", "fantasy");
        if (studentOptional1.isPresent()) {
            logger.info("多条件查询学生信息：{}", studentOptionl.get());
        }
    }

    /**
     * 注解的使用
     */
    @Test
    public void cahcheUse(){
        Student student = recordStudent.getStudentRecord("xiangming");
        logger.info("学生缓存记录：{}",student);
    }

    @Test
    public void saveActivity() {
        ActivityParam activityParam = new ActivityParam();
        activityParam.setActivityName("初始活动");
        activityParam.setActivityDescribe("活动描述");
        activityParam.setActivityImgId("323");
        activityParam.setActivityStatus(1);
        activityParam.setStartTime(LocalDateTime.now());
        activityParam.setEndTime(LocalDateTime.now());
        activityParam.setSkipWay("sd");
        activityParam.setStatus(1);
        activityService.save(activityParam);
    }

    @Test
    public void drawAward(){
        DrawAwardParam drawAwardParam = new DrawAwardParam();
        drawAwardParam.setActivityId(1);
        drawAwardService.drawAward(drawAwardParam);
    }
}
