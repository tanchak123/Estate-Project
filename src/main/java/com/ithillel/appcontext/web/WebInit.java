package com.ithillel.appcontext.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.ithillel.appcontext.ApplicationContext;
import com.ithillel.appcontext.security.SecurityConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setRequestCharacterEncoding("UTF-8");
        final AnnotationConfigWebApplicationContext configApplicationContext
                = new AnnotationConfigWebApplicationContext();
        configApplicationContext.register(ApplicationContext.class, SecurityConfig.class);
        servletContext.addListener(new ContextLoaderListener(configApplicationContext));
        final AnnotationConfigWebApplicationContext webApplicationContext
                = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebConfig.class);
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher"
                ,new DispatcherServlet(webApplicationContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

        servletContext.addFilter("springSecurityFilterChain",
                new DelegatingFilterProxy("springSecurityFilterChain"))
                .addMappingForUrlPatterns(null, true, "/*");
    }

}
