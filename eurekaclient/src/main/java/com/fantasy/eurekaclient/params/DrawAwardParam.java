package com.fantasy.eurekaclient.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: xiangming
 * @Date: 2020-02-02-00:33
 * @Describetion: 抽奖
 */
@ApiModel(description = "抽奖入参")
@Data
public class DrawAwardParam {

    @ApiModelProperty(value = "活动名称", example = "id")
    private Integer activityId;

    @ApiModelProperty(value = "身份证号", example = "5101061992")
    private String idNo;
}
