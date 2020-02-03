package com.fantasy.eurekaclient.service;

import java.math.BigDecimal;

public interface IAwardInfo {

    Integer getAwardId();
    /**
     * 奖项序列
     */
    Integer getIndex();
    /**
     * 概率
     */
    Double rate();
    /**
     * 奖品id
     */
    Integer getAwardItemId();
    /**
     * 奖品名称
     */
    String getAwardItemName();
    /**
     * 奖品价值
     */
    BigDecimal getAwardItemPrice();

}
