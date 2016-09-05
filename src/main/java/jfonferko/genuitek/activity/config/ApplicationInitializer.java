//package jfonferko.genuitek.activity.config;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
///**
// * Created by JFonferko on 2016-08-17.
// */
//@Configuration
//public class ApplicationInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		rootContext.register(AppConfig.class);
//
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
//
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
//				dispatcherServlet);
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//
//		servletContext.addListener(new ContextLoaderListener(rootContext));
//	}
//}