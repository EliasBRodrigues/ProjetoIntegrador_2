package school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import school.web.interceptors.ErrorInterceptor;
import school.web.interceptors.TitleInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final TitleInterceptor titleInterceptor;
    private final ErrorInterceptor errorInterceptor;

    public WebConfig(TitleInterceptor titleInterceptor,
                     ErrorInterceptor errorInterceptor) {
        this.titleInterceptor = titleInterceptor;
        this.errorInterceptor = errorInterceptor;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(titleInterceptor);
        registry.addInterceptor(errorInterceptor).addPathPatterns("/error");

    }

    
}
