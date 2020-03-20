package com.fantasy.fanauth.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: xiangming
 * @date: 2020/03/20 16:35
 * @describetion:
 */
@Entity
@Table(name = "user")
@Data
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

}
