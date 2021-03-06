package com.client.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class LoggingFilterConfig {

    @Bean
    public CommonsRequestLoggingFilter loggingFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeClientInfo(true);
        filter.setIncludeClientInfo(true);
        filter.setIncludeHeaders(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(5000);
        filter.setAfterMessagePrefix("REQUEST DATA: ");
        return filter;
    }
}