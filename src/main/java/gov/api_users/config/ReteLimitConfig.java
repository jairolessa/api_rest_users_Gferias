package gov.api_users.config;

import gov.api_users.filter.ApiRateLimitFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReteLimitConfig {
    @Bean
    public FilterRegistrationBean<ApiRateLimitFilter> rateLimitFilter() {
        FilterRegistrationBean<ApiRateLimitFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ApiRateLimitFilter());
        registrationBean.addUrlPatterns("/*"); // Apply to all routes
        return registrationBean;
    }
}
