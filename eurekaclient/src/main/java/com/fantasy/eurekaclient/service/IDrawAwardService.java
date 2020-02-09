package com.fantasy.eurekaclient.service;

import com.fantasy.eurekaclient.model.dto.AwardPrizeDto;
import com.fantasy.eurekaclient.params.DrawAwardParam;

public interface IDrawAwardService {

    AwardPrizeDto drawAward(DrawAwardParam drawAwardParam);
}
