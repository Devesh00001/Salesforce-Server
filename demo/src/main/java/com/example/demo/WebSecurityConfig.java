//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter
//{
//
//    @Autowired
//    private UsersDetailService usersDetailService;
//
//    //@Autowired
//    //private JwtRequestFilter jwtRequestFilter;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.userDetailsService(usersDetailService);
//    }
//
//    /* Bean of AuthManager due to it used to work in older version of spring */
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception
//    {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        /* Disable security */
//        http.csrf().disable();
//
//        /* User info page requires login as admin and user role. If no login, redirect */
//        http.authorizeRequests().antMatchers("users").access("hasAnyRole('admin', 'user')");
//
//        /* Only for admin */
//        http.authorizeRequests().antMatchers("logs", "admin").access("hasRole('admin')");
//
//        /* The pages does not require login/auth */
//        http.authorizeRequests().antMatchers("login", "logout", "/authenticate/, login/")
//                .permitAll();//.anyRequest().authenticated();
//
//        /* Using sessiong managment for intercept jwt auth . Spring won't create session, jwt will manage them*/
//        //http.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        //http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//    }
//}