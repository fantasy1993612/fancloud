package com.fantasy.eurekaclient.dao;

import com.fantasy.eurekaclient.entity.AwardTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: xiangming
 * @Date: 2020-02-02-00:54
 * @Describetion：奖项次数
 */
@Repository
public interface AwardTimesRepository extends JpaRepository<AwardTimes, Integer> {


}
