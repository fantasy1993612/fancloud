package com.fantasy.eurekaclient.event;

import com.fantasy.eurekaclient.constant.LogType;
import com.fantasy.eurekaclient.model.params.LogParam;
import org.springframework.context.ApplicationEvent;
import org.springframework.validation.ValidationUtils;

/**
 * @author: xiangming
 * @date: 2020/02/29 03:28
 * @describetion:
 */
public class LogEvent extends ApplicationEvent {
    private final LogParam logParam;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source   the object on which the event initially occurred (never {@code null})
     * @param logParam login param
     */
    public LogEvent(Object source, LogParam logParam) {
        super(source);

        this.logParam = logParam;
    }

    public LogEvent(Object source, String logKey, LogType logType, String content) {
        this(source, new LogParam(logKey, logType, content));
    }

    public LogParam getLogParam() {
        return logParam;
    }
}
