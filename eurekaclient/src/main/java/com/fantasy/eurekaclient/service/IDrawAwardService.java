package com.fantasy.eurekaclient.service;

import com.fantasy.eurekaclient.entity.AwardPrize;
import com.fantasy.eurekaclient.params.DrawAwardParam;

public interface IDrawAwardService {

    AwardPrize drawAward(DrawAwardParam drawAwardParam);
}
