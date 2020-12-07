package mdar.com.springbootConfigure.serviceConfig;

import mdar.com.springbootConfigure.interceptor.LoginIntercepter;
import mdar.com.user.entity.enumEntity.converter.db.UserRoleConverter;
import mdar.com.user.entity.enumEntity.converter.html.StringToUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;
import java.util.ArrayList;

@Configuration
public class WebServiceConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToUserRole());
    }

}
