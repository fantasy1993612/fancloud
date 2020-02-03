package com.fantasy.eurekaclient;

import com.fantasy.eurekaclient.params.ActivityParam;
import com.fantasy.eurekaclient.params.DrawAwardParam;
import com.fantasy.eurekaclient.service.IActivityService;
import com.fantasy.eurekaclient.service.IDrawAwardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EurekaclientApplicationTests {

    @Autowired
    private IActivityService activityService;

    @Autowired
    private IDrawAwardService drawAwardService;


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
        log.info("保存成功");
    }

    @Test
    public void drawAward(){
        DrawAwardParam drawAwardParam = new DrawAwardParam();
        drawAwardParam.setActivityId(1);
        drawAwardService.drawAward(drawAwardParam);
    }
}
