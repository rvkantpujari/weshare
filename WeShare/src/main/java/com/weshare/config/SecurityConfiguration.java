package com.weshare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.weshare.service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
	private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth
                    .userDetailsService(myUserDetailsService)
                    .passwordEncoder(bCryptPasswordEncoder);
    }
    
    private static final String[] PUBLIC_MATCHERS = {
    		"/user/category/all/communities",
    		"/user/contact",
    		"/user/home",
    		"/",
    		"/registration",
    		"/user/community/{communityName}",
    		"/user/category/{communityName}/communities",
    		"/error"
    };
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String loginPage = "/login";
        String logoutPage = "/logout";

        http.authorizeRequests()
        		// URLs matching for access rights
                .antMatchers(loginPage).permitAll()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("USER")
                .anyRequest().authenticated()
                .and().csrf().disable()
                .formLogin().loginPage(loginPage)
                .successHandler(customLoginSuccessHandler)
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
                .logoutSuccessUrl(loginPage).and().exceptionHandling()
        		.accessDeniedPage("/error");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/resources/**", 
        		   		"/static/**", 
        		   		"/css/**", 
        		   		"/js/**", 
        		   		"/images/**", 
        		   		"/fonts/**",
        		   		"/postImages/**");
    }

}
