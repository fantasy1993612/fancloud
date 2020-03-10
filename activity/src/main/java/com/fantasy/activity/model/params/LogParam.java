package com.fantasy.activity.model.params;

import com.fantasy.activity.model.InputConverter;
import com.fantasy.activity.constant.LogType;
import com.fantasy.activity.model.entity.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: xiangming
 * @date: 2020/02/29 03:29
 * @describetion:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogParam implements InputConverter<Log> {

    @Size(max = 1023, message = "Length of log key must not be more than {max}")
    private String logKey;

    @NotNull(message = "Log type must not be null")
    private LogType type;

    @NotBlank(message = "Log content must not be blank")
    @Size(max = 1023, message = "Log content must not be more than 1023")
    private String content;
}
