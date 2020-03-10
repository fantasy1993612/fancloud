package com.fantasy.activity.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: xiangming
 * @Date: 2020-02-02-18:15
 * @Describetion：中奖记录
 */
@Data
@Entity
public class AwardRecord extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;
    /**
     * 任务id
     */
    private Integer taskId;
    /**
     * 活动id
     */
    @Column(nullable=false,columnDefinition = "int comment '活动ID'")
    private Integer activityId;

    /**
     * 奖项名称
     */
    @Column(nullable=false,length = 256)
    private String prizeName;
    /**
     * 奖品名称
     */
    @Column(nullable=false,length = 256)
    private String awardItemName;
    /**
     * 奖项价值
     */
    @Column(nullable=false)
    private BigDecimal awardItemPrice;

    @Column(columnDefinition = "varchar(255) comment '用户住址'")
    private String address;

    @Column(columnDefinition = "varchar(11) comment '用户手机号'")
    private String userPhone;

    @Column(columnDefinition = "varchar(11) comment '用户名称'")
    private String userName;

    @Column(columnDefinition = "tinyint comment '奖品领取状态'")
    private Integer status;



}
