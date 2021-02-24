package com.example.demo.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;

public class SampleTurboFilter extends TurboFilter {
    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable throwable) {
        if (level == Level.ERROR && logger.getName().equals("org.springframework.cloud.sleuth.instrument.web.ExceptionLoggingFilter")) {
            logger.warn(marker, format, params);
            return FilterReply.DENY;
        }
        return FilterReply.NEUTRAL;
    }
}
