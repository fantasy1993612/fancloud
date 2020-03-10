package com.fantasy.activity.event;

import com.fantasy.activity.model.params.LogParam;
import com.fantasy.activity.constant.LogType;
import org.springframework.context.ApplicationEvent;

/**
 * @author: xiangming
 * @date: 2020/02/29 03:28
 * @describetion: 日志事件
 */
public class LogEvent extends ApplicationEvent {
    private final LogParam logParam;

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
