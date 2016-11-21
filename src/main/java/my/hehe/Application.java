package my.hehe;

import javax.annotation.Resource;
import javax.servlet.Filter;

import my.hehe.util.TSTDTZApi;
import my.hehe.util.WXApi;

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
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableScheduling
@PropertySources({ @PropertySource("classpath:/config/application.yml"),
		@PropertySource(value="classpath:/config/api.properties",encoding="utf-8") })
//sometimes  the  properties  must  be  set  "classpath:/resources/config/application.yml" ,because it  don't  find it ,i don't know 
public class Application extends SpringBootServletInitializer implements
		EmbeddedServletContainerCustomizer {

	@Resource
	private WXApi api;

	@Bean
	public WXApi getWXApi() {
		return new WXApi(new RestTemplate());
	}

	@Bean
	public TSTDTZApi getTstdtzApi() {
//		return new TSTDTZApi(new RestTemplate());
		return new TSTDTZApi();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("**")// api.getIP()
						.allowedMethods("POST");
			}
		};
	}

	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
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
// @Configuration
// //@EnableWebSecurity
// class SecurityConfig extends WebSecurityConfigurerAdapter{
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// // TODO Auto-generated method stub
// // super.configure(http);
// http.csrf();
// // http.requiresChannel().antMatchers("/receive").requiresSecure();
// }
//
// }
