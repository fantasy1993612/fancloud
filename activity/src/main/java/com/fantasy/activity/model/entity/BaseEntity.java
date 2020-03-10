package com.fantasy.activity.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 基础类 每张表都应该有创建时间和更新时间
 */
@MappedSuperclass
@Data
@ToString
@EqualsAndHashCode
public class BaseEntity {

    /**
     * 创建时间
     */
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * 是否删除标志
     */
    @Column(name = "deleted", columnDefinition = "TINYINT default 0")
    private Integer deleted = 0;

    @PrePersist
    protected void prePersist() {
        deleted = 0;
        Date now = new Date();
        if (createTime == null) {
            createTime = now;
        }

        if (updateTime == null) {
            updateTime = now;
        }
    }

    @PreUpdate
    protected void preUpdate() {
        updateTime = new Date();
    }

    @PreRemove
    protected void preRemove() {
        updateTime = new Date();
    }

}

