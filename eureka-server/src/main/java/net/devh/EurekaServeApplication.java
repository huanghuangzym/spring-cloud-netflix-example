package net.devh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableEurekaServer
@SpringBootApplication
public class EurekaServeApplication {


    @Configuration
    @EnableWebSecurity
    public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
            
            //http.csrf().disable();
            http.csrf().ignoringAntMatchers("/eureka/**");
            super.configure(http);
            //http.csrf().disable().httpBasic();
            // 关闭csrf
            //http.csrf().disable();
            // 支持httpBasic
            //http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServeApplication.class, args);
    }
}
