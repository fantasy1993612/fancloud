package designpattern.activity.model;

import lombok.Data;

/**
 * @author: xiangming
 * @date: 2020/02/25 15:26
 * @describetion:
 */
@Data
public class DrawAwardParm {

    private String activityId;

    private String userId;

    private Integer drawTimes;
}
