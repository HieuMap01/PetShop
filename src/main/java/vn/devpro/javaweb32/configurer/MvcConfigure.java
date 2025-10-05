package vn.devpro.javaweb32.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import vn.devpro.javaweb32.dto.Jw32Contanst;

@Configuration
public class MvcConfigure implements WebMvcConfigurer, Jw32Contanst{
	@Bean
	public ViewResolver viewResolver() {
		// xử lý và trả về đối tượng view thông qua tên
		// ViewResolver sẽ tìm các file .jsp trong thư mục /WEB-INF/views/
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		//
		return bean;
	}
	
	public void addResourceHandlers( ResourceHandlerRegistry registry) {
		// Cấu hình đường dẫn để phục vụ file tĩnh (static resources)
		registry.addResourceHandler("/customer/**").addResourceLocations("classpath:/customer/");
		registry.addResourceHandler("/administrator/**").addResourceLocations("classpath:/administrator/");
		registry.addResourceHandler("/UploadFiles/**").addResourceLocations("file:" + FOLDER_UPLOAD);
	}
}
