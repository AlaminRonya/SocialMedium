package com.alamin.config;

import com.alamin.config.securities.SecurityConfig;
import com.alamin.utils.Constant;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // root config
        AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
        rootConfig.register(DBConfig.class, SecurityConfig.class);
        rootConfig.refresh();
        servletContext.addListener(new ContextLoaderListener(rootConfig));

        // Servlet Config
        AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
        servletConfig.register(WebMVCConfig.class);
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("servlet", new DispatcherServlet(servletConfig));

        // Multipart Config
        servletRegistration.setMultipartConfig(new MultipartConfigElement("/", Constant.MAX_UPLOAD_SIZE, Constant.MAX_UPLOAD_SIZE * 2, Constant.MAX_UPLOAD_SIZE / 2));

        // Multipart Filter Config
        FilterRegistration.Dynamic multipartFilter = servletContext.addFilter("multipartFilter", MultipartFilter.class);
        multipartFilter.addMappingForUrlPatterns(null, true, "/*");


//        MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/",Constant.MAX_UPLOAD_SIZE, Constant.MAX_UPLOAD_SIZE * 2, Constant.MAX_UPLOAD_SIZE / 2);
//        servletRegistration.setMultipartConfig(multipartConfigElement);




        // Load on StartUp
        servletRegistration.setLoadOnStartup(1);

        // mapping
        servletRegistration.addMapping("/");
    }
}
