package com.easyfactory.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/main");
		registry.addViewController("/main").setViewName("main");
		registry.addViewController("/main2").setViewName("main2");
		
		registry.addViewController("/member/signup").setViewName("member/signup");
		registry.addViewController("/member/update").setViewName("member/update");
		registry.addViewController("/member/updateCheck").setViewName("member/updateCheck");
		
		registry.addViewController("/feb/indexChart").setViewName("feb/indexChart");
		
		registry.addViewController("/feb/feb1").setViewName("feb/feb1");
		registry.addViewController("/feb/feb2").setViewName("feb/feb2");
		registry.addViewController("/feb/feb3").setViewName("feb/feb3");
		registry.addViewController("/feb/feb4").setViewName("feb/feb4");
		registry.addViewController("/feb/feb5").setViewName("feb/feb5");
		registry.addViewController("/feb/feb6").setViewName("feb/feb6");
		registry.addViewController("/feb/feb7").setViewName("feb/feb7");
		registry.addViewController("/feb/feb8").setViewName("feb/feb8");
		registry.addViewController("/feb/guideLines").setViewName("feb/guideLines");
		
		registry.addViewController("/issue/list").setViewName("issue/list");
	}
/*
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor())
			.addPathPatterns("/edit/**")
			.excludePathPatterns("/edit/help/**");
	}

	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
*/
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.label");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}

}
