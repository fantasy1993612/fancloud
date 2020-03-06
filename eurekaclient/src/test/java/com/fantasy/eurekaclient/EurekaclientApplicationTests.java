package com.fantasy.eurekaclient;

import com.fantasy.eurekaclient.repository.AwardPrizeRepository;
import com.fantasy.eurekaclient.model.entity.AwardPrize;
import com.fantasy.eurekaclient.model.entity.Task;
import com.fantasy.eurekaclient.model.params.ActivityParam;
import com.fantasy.eurekaclient.model.params.DrawAwardParam;
import com.fantasy.eurekaclient.service.IActivityService;
import com.fantasy.eurekaclient.service.IDrawAwardService;
import lombok.extern.slf4j.Slf4j;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EurekaclientApplicationTests {

    @Autowired
    private IActivityService activityService;

    @Autowired
    private IDrawAwardService drawAwardService;

    @Autowired
    private AwardPrizeRepository awardPrizeRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();



    @Test
    public void saveActivity() {
        for (int i = 0; i < 100; i++) {
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
        log.info("保存成功");
    }

    /**
     * 分页查询活动
     */
    @Test
    public void queryActivityInfoByPage() {
        //activityService.queryActivityInfoByPage(0,10);
    }

    @Test
    public void queryHotActivityList() {
        activityService.queryHotActivityInfo(0, 10);
    }

    @Test
    public void saveAwardPrize() {
        List<AwardPrize> awardPrizeList = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            awardPrizeList.add(buildAwardPrize());
        }

        awardPrizeRepository.saveAll(awardPrizeList);

    }

    private AwardPrize buildAwardPrize() {
        AwardPrize awardPrize = new AwardPrize();
        awardPrize.setAwardIndex(0);
        awardPrize.setActivityId(2);
        awardPrize.setTaskId(1);
        awardPrize.setAwardItemName("Jb");
        awardPrize.setAwardItemPrice(new BigDecimal(5));
        awardPrize.setPrizeName("fa");
        awardPrize.setAwardTimePeriodLimitId(212);
        awardPrize.setNum(5);
        awardPrize.setRemainNum(5);
        awardPrize.setRate(new BigDecimal(0.9));
        return awardPrize;
    }

    @Test
    public void concurrencyDrawAward() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                DrawAwardParam drawAwardParam = new DrawAwardParam();
                drawAwardParam.setActivityId(1);
                drawAwardService.drawAward(drawAwardParam);
            });
        }
    }

    @Test
    public void drawAward() {
        DrawAwardParam drawAwardParam = new DrawAwardParam();
        drawAwardParam.setActivityId(1);
        drawAwardService.drawAward(drawAwardParam);
    }

    @Test
    @PerfTest(threads = 1000, invocations = 1000,duration = 5000)
    public void testConcurrencyRedis() {
        DrawAwardParam drawAwardParam = new DrawAwardParam();
        drawAwardParam.setActivityId(1);
        drawAwardService.drawAward(drawAwardParam);
    }

    @Test
    public void initTask() {
        Task task = new Task();
        task.setActivityId(1);
        task.setTaskDescribe("任务");
        task.setTaskName("任务");
    }




}
