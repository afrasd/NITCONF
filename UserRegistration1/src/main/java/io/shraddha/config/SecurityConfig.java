package io.shraddha.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/oauth2/**", "/","/profile","/login", "landingpage","/swagger-ui.html/**","/swagger-ui.html#/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .oauth2Login()
//                .loginPage("/login")
//                .defaultSuccessUrl("/dummy")
//                .and()
//            .logout()
//                .logoutSuccessUrl("/")
//                .logoutUrl("/logout")
//                .and()
//            .oauth2Login();
//    }
//}



import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/oauth2/**", "/", "/profile", "/login", "landingpage").permitAll()
                .anyRequest().authenticated()
                .and()
            .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/dummy")
                .and()
            .logout()
                .logoutSuccessUrl("/")
                .logoutUrl("/logout")
                .and()
            .oauth2Login();
        
        // Add JWT Authentication Filter before other filters
        //http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .anyRequest().permitAll() // Allow access to all endpoints
//                .and()
//            .csrf().disable(); // Disable CSRF protection for simplicity (optional)
//    }
//}

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/oauth2/**","/").permitAll() // Allow access to OAuth endpoints
//                .anyRequest().authenticated() // Require authentication for all other requests
//                .and()
//            .oauth2Login() // Enable OAuth2 login
//                .loginPage("/login") // Custom login page URL
//                .defaultSuccessUrl("/dummy") // Redirect URL upon successful authentication
//                .and()
//            .logout() // Configure logout
//                .logoutSuccessUrl("/") // Redirect URL after logout
//                .logoutUrl("/logout") // Logout URL
//                .and()
//                .oauth2Login()
//                .and()
//            .csrf().disable(); // Disable CSRF protection for simplicity (optional)
//    }
//}
