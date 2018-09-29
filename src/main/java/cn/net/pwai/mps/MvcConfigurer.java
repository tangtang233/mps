package cn.net.pwai.mps;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author tangwei
 */

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "cn.net.pwai.mps.**.controller", "cn.net.pwai.mps.**.repository"
})
public class MvcConfigurer implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        /*
         * 1.ServletMappings 设置的是 "/" 2.setUseSuffixPatternMatch默认设置为true,
         * 那么,"/user" 就会匹配 "/user.*",也就是说,"/user.html" 的请求会被 "/user" 的 Controller所拦截.
         * 3.如果该值为false,则不匹配
         */
        configurer.setUseSuffixPatternMatch(false);

        /*
         * setUseTrailingSlashMatch的默认值为true
         * 也就是说, "/user" 和 "/user/" 都会匹配到 "/user"的Controller
         */
        configurer.setUseTrailingSlashMatch(true);
    }


}