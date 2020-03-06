package com.fantasy.eurekaclient.repository;

import com.fantasy.eurekaclient.model.dto.AwardPrizeDto;
//import com.fantasy.eurekaclient.service.query.AwardPrizeQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AwardPrizeDao {
    //List<AwardPrizeDto> query(AwardPrizeQuery query);

    void batchAdd(@Param("list") List<AwardPrizeDto> dataList);
}