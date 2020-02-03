package com.fantasy.eurekaclient.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @describtion: 活动实体类
 * @auther: xiangming
 * @date: 2020/1/30 8:17 PM
 */
@Entity
@Data
public class Activity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    //主键
    private Integer id;
    //活动名称
    @Column(nullable=false, length=256)
    private String activityName;
    //活动描述
    @Column(nullable=false, length=256)
    private String activityDescribe;
    //活动跳转方式
    @Column(nullable=false, length=128)
    private String skipWay;
    //活动图片id
    @Column(nullable=false, length=256)
    private String activityImgId;
    //活动开始时间
    @Column(nullable=false)
    private LocalDateTime startTime;
    //活动结束时间
    @Column(nullable=false)
    private LocalDateTime endTime;
    //活动发布状态 0 未发布 1 已发布 2 暂停 3 灰度 4 已上线 5 已结束
    @Column(nullable=false,columnDefinition = "tinyint default 0")
    private Integer status;
    //活动状态 0 未开启 1已开启
    @Column(nullable=false,columnDefinition = "tinyint default 0")
    private Integer activityStatus;

}
