package my.hehe;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableScheduling
@PropertySources({ @PropertySource("classpath:/config/application.yml"),//package jar��the config path must be write ��"classpath:/resources/config/application.yml"
		@PropertySource("classpath:/config/api.properties") })			//if you config file in dir:"resourse"!!!!

public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{

	Logger logger=Logger.getLogger(Application.class);
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/receive").allowedOrigins("*").allowedMethods("POST");
            }
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Application.class);
	}

	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(80);
	}

}
//@Configuration
////@EnableWebSecurity
//class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
////		super.configure(http);
//		http.csrf();
////		http.requiresChannel().antMatchers("/receive").requiresSecure();
//	}
//	
//}
