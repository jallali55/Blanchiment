package com.gestion.blanchiment.Security;



import org.modelmapper.ModelMapper;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@Configuration
@EnableWebSecurity
@EnableSwagger2
public class WebConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    	
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(bCryptPasswordEncoder);
    }
   
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
	http.csrf().disable();
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	/*http.authorizeRequests().antMatchers("/login/**").permitAll();
	http.authorizeRequests().antMatchers("/clientsuspect/files/**").permitAll();
	http.authorizeRequests().anyRequest().authenticated();*/
	http.authorizeRequests().antMatchers("/**").permitAll();

	http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
    }
    

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String DEFAULT_INCLUDE_PATTERN = "/.*";

    
    @Bean
    public Docket customDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(regex(DEFAULT_INCLUDE_PATTERN))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Lists.newArrayList(apiKey()));

    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Blanchiment Back end")
                .description("Blanchiment Application")
                .license("@CopyRight BFI 2021")
                .licenseUrl("https://www.bfi.com/")
                .termsOfServiceUrl("")
                .version("Blanchiment v1")
                .contact(new Contact("","", ""))
                .build();
    }


    private ApiKey apiKey() {
        return new ApiKey("Bearer", AUTHORIZATION_HEADER, "header");
    }
  
}
