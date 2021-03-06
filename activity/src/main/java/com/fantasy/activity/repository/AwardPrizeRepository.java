package com.fantasy.activity.repository;

import com.fantasy.activity.model.entity.AwardPrize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xiangming
 * @Date: 2020-02-02-00:39
 * @Describetion: 奖项
 */
@Repository
public interface AwardPrizeRepository extends JpaRepository<AwardPrize, Integer> {

    /**
     * 通过活动id查询活动
     * @param activityId
     * @return
     */
    List<AwardPrize> findByActivityId(Integer activityId);


    /**
     * 更新奖品数量
     * @param id
     */
    @Modifying
    @Query(nativeQuery = true,
            value = "update award_prize set remain_num = remain_num -1 where id =?1")
    int updateAwardRemainNum(Integer id);
}
