package com.grupo56.equipo1.proyecto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.grupo56.equipo1.proyecto.service.UsuariosService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuariosService usuariosService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuariosService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/newuser/**", "/entrada/**", "/", "/comments/**",
                        "/assets/**", "/css/**", "/js/**", "/vendors/**", "/img/**").permitAll()
                // .antMatchers(HttpMethod.DELETE,"/api/v1/products/{productId}").hasRole(ADMIN.name())
                // .antMatchers(HttpMethod.PUT, "/api/v1/products/{productId}").hasRole(ADMIN.name())
                .antMatchers("/panel").hasRole("USER")
                .antMatchers("/posts/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and().httpBasic() //OPCIONAL SE PUEDE BORRAR
                .and().exceptionHandling().accessDeniedPage("/404")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/panel",true).permitAll()
                .and().logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll();

    }
}

/*
 http.authorizeRequests().antMatchers(
 "/newuser/**",
 "/entrada/**",
 "/assets/**",
 "/css/**",
 "/js/**",
 "/vendors/**",
 "/",
 "/img/**").permitAll().anyRequest().authenticated()
 .and().formLogin().loginPage("/login").permitAll()
 .and().logout().invalidateHttpSession(true)
 .clearAuthentication(true)
 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
 .logoutSuccessUrl("/login?logout").permitAll();
 */