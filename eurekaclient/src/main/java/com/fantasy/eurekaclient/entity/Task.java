package com.fantasy.eurekaclient.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Auther: xiangming
 * @Date: 2020/1/31 01:15
 * @Description: 任务类型
 */
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String oid;

    String taskName;

    String taskDescribe;
}
