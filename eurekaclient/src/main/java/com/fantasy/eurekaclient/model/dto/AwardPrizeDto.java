package com.fantasy.eurekaclient.model.dto;

import com.fantasy.eurekaclient.model.entity.AwardPrize;
import com.fantasy.eurekaclient.model.OutputConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: xiangming
 * @Date: 2020-02-06-19:15
 * @Describetion：奖项类
 */
@ApiModel(description = "奖项类")
@Data
public class AwardPrizeDto implements OutputConverter<AwardPrizeDto, AwardPrize> {

    /**
     * 奖项名称
     */
    @ApiModelProperty(value = "奖项名称", example = "奖品名称")
    private String prizeName;
    /**
     * 奖品名称
     */
    @ApiModelProperty(value = "奖品名称", example = "奖品名称")
    private String awardItemName;
    /**
     * 奖项价值
     */
    @ApiModelProperty(value = "奖项价值", example = "5")
    private BigDecimal awardItemPrice;
    /**
     * 奖品数量
     */
    @ApiModelProperty(value = "奖品数量", example = "100")
    private Integer num;
    /**
     * 奖品剩余数量
     */
    @ApiModelProperty(value = "奖品剩余数量", example = "100")
    private Integer remainNum;
}
