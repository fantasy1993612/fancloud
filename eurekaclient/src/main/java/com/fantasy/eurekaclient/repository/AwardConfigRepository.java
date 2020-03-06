package com.fantasy.eurekaclient.repository;

import com.fantasy.eurekaclient.model.entity.AwardConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: xiangming
 * @date: 2020/02/28 17:09
 * @describetion:
 */
@Repository
public interface AwardConfigRepository extends JpaRepository<AwardConfig, Integer> {

}
