package by.heretic.strength_exercise_api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class ApplicationConfig {

//    @Bean
//    public FilterRegistrationBean<CommonsRequestLoggingFilter> loggingFilter(){
//        FilterRegistrationBean<CommonsRequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
//
//        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
//        loggingFilter.setIncludeQueryString(true);
//        loggingFilter.setIncludePayload(true);
//        loggingFilter.setMaxPayloadLength(10000);
//
//        registrationBean.setFilter(loggingFilter);
//        registrationBean.setOrder(1);
//
//        return registrationBean;
//    }
}
