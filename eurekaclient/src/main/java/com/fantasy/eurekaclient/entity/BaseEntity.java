package com.fantasy.eurekaclient.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang.time.DateUtils;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@ToString
@EqualsAndHashCode
/**
 * 基础类 每张表都应该有创建时间和更新时间
 */
public class BaseEntity {

    /**
     * create time
     */
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date createTime;
    /**
     * Update time.
     */
    @Column(name = "update_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * Delete flag.
     */
    @Column(name = "deleted", columnDefinition = "TINYINT default 0")
    private Boolean deleted = false;

    @PrePersist
    protected void prePersist() {
        deleted = false;
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

