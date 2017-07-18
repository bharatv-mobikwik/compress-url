package com.commons.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by MOBIKWIK\omk707 on 17/7/17.
 */
public class WebAppInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(UrlShortenerAppContext.class);
        rootContext.registerShutdownHook();
        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        //DefaultHtmlEscape
        servletContext.setInitParameter("defaultHtmlEscape", "true");

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(UrlShortenerServletContext.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
        dynamic.setLoadOnStartup(1);
        dynamic.addMapping("/api/*");
        // servletContext.addFilter("ApplicationInsightsWebFilter", WebRequestTrackingFilter.class).addMappingForUrlPatterns(null, false, "/*");
    }
}
