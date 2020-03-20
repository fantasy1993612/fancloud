package com.fantasy.fanauth.repository;

import com.fantasy.fanauth.entity.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: xiangming
 * @date: 2020/03/20 16:37
 * @describetion:
 */
@Repository
public interface UserRepository extends CrudRepository<UserDO, Long> {

    UserDO findByUsername(String username);

}
