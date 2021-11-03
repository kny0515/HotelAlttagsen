package org.alttagsen.hotel.configuration;

import lombok.RequiredArgsConstructor;
import org.alttagsen.hotel.service.MemberService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    UserAuthenticationFailureHandler getFailuerHandler(){

        return new UserAuthenticationFailureHandler();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/"
                        ,"/hotel/join"
                        ,"/hotel/introduce"
                        ,"/hotel/room"
                        ,"/hotel/convenience"
                        ,"/hotel/event"
                        ,"/hotel/service"
                        ,"/hotel/restaurant"
                        ,"/hotel/introtourfood"
                        ,"/hotel/tour"
                        ,"/hotel/food"
                        ,"/hotel/reservation"
                        ,"/hotel/map"
                        ,"/css/**"
                )
                .permitAll();


        http.formLogin()
                .loginPage("/hotel/login")
                .failureHandler(getFailuerHandler())
                .permitAll();

        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasAnyAuthority("ROLE_ADMIN");

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/hotel/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        http.exceptionHandling()
                .accessDeniedPage("/error/denied");

        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(memberService)
        .passwordEncoder((getPasswordEncoder()));

        super.configure(auth);
    }
}
