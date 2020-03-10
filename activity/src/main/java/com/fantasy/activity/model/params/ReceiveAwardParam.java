package com.fantasy.activity.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: xiangming
 * @date: 2020/03/02 00:06
 * @describetion:
 */
@ApiModel(description = "领奖入参")
@Data
public class ReceiveAwardParam {

    @ApiModelProperty(value = "活动名称", example = "id")
    private Integer activityId;

    @ApiModelProperty(value = "身份证号", example = "5101061992")
    private String idNo;

    @ApiModelProperty(value = "奖项id", example = "5101061992")
    private String awardPrizeId;

}
