package com.fantasy.eurekaclient.dao;

import com.fantasy.eurekaclient.entity.AwardRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: xiangming
 * @Date: 2020-02-06-19:53
 * @Describetion: 中奖记录
 */
@Repository
public interface AwardRecordRepository extends JpaRepository<AwardRecord, Integer> {


}
