package com.fantasy.eurekaclient.repository;

import com.fantasy.eurekaclient.model.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 活动仓库
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
