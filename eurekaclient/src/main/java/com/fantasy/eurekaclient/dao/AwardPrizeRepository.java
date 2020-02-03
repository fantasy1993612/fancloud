package com.fantasy.eurekaclient.dao;

import com.fantasy.eurekaclient.entity.AwardPrize;
import com.fantasy.eurekaclient.service.IAwardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xiangming
 * @Date: 2020-02-02-00:39
 * @Describetion
 */
@Repository
public interface AwardPrizeRepository extends JpaRepository<AwardPrize, Integer> {

    List<AwardPrize> findByActivityId(Integer activityId);

    @Query(nativeQuery = true,
            value = "SELECT cl.student_id AS studentId,st.last_name AS lastName " +
                    "FROM class cl,student st " +
                    "WHERE cl.student_id = st.id")
    List<IAwardInfo> queryAwardInfo(Integer activityId);

    @Modifying
    @Query(nativeQuery = true,
            value = "update award_prize set remain_num = remain_num -1 where id =?1")
    void updateAwardRemainNum(Integer id);
}
