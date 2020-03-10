package com.fantasy.activity.controller;

import com.fantasy.activity.model.dto.AwardPrizeDto;
import com.fantasy.activity.model.response.BaseResponse;
import com.fantasy.activity.model.params.DrawAwardParam;
import com.fantasy.activity.service.IDrawAwardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xiangming
 * @Date: 2020-02-02-00:22
 * @Describetion
 */
@Api(tags = "派奖")
@Slf4j
@RestController
@RequestMapping(value = "/distributeAward")
public class DistributeAwardController {

    @Autowired
    private IDrawAwardService drawAwardService;

    @ApiOperation(value = "抽奖",response = AwardPrizeDto.class)
    @PostMapping("/drawAward")
    public BaseResponse<AwardPrizeDto> drawAward(@RequestBody DrawAwardParam drawAwardParam){
        return BaseResponse.ok(drawAwardService.drawAward(drawAwardParam));
    }

}
