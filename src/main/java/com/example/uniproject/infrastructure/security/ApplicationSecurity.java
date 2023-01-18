package com.example.uniproject.infrastructure.security;
/*
public class ApplicationSecurity<CsrfTokenRepository> {
    private CsrfTokenRepository csrfTokenRepository() {

        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();

        repository.setSessionAttributeName("_csrf");

        return repository;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .disable()
                .csrf()
                .csrfTokenRepository(this.csrfTokenRepository())
                .and()
                .authorizeRequests()
                .antMatchers("/", "/register", "/login").permitAll()
                .antMatchers("/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/contacts")
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout");
    }


}

 */
