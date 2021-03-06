package com.stefanmilojevic.myRealEstate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {


    private CustomAuthProvider customAuthProvider;

    @Autowired
    public void setCustomAuthProvider(CustomAuthProvider customAuthProvider) {
        this.customAuthProvider = customAuthProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeRequests()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/cities").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers(HttpMethod.GET, "/user/**").permitAll()
                .antMatchers(HttpMethod.GET, "/categories").permitAll()
                .antMatchers("/subcategory/getAllByCategoryTitle/**").permitAll()
                .antMatchers("/advertisement/getAllPublishedBySubCategoryId/**").permitAll()
                .antMatchers(HttpMethod.GET, "/advertisement/**").permitAll()
                .antMatchers("/advertisementPictures/getPrimaryByAdvertisementId/{advertisementId}/**").permitAll()
                .antMatchers("/advertisementPictures/getAllByAdvertisementId/**").permitAll()
                .antMatchers("/pictures/getByUserId/**").permitAll()
                .antMatchers("/profileComments/commentedOn/**").permitAll()
                .antMatchers(HttpMethod.GET, "/utilityEstate/getAllByAdvertId/**").permitAll()
                .antMatchers(HttpMethod.GET, "/advertComments/getAllByAdvertId/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS")
                        .allowedHeaders("*")
                        .allowedOrigins("*");
            }
        };
    }


}
