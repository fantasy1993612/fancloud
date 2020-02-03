package com.fantasy.eurekaclient.service;

import com.fantasy.eurekaclient.entity.AwardPrize;

import java.util.List;

public interface IAwardPrizeService {

    List<AwardPrize>  queryAwardInfo(Integer activityId);

}
