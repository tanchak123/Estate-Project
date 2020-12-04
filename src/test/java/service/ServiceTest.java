package service;

import com.ithillel.appcontext.ApplicationContext;
import com.ithillel.service.interfaces.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServiceTest {

    protected static AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(ApplicationContext.class);


    @Test
    public void testBeans() {
        annotationConfigApplicationContext
                .getBean("regionServiceImpl");
        annotationConfigApplicationContext
                .getBean("realtorServiceImpl");
        annotationConfigApplicationContext
                .getBean("areaServiceImpl");
        annotationConfigApplicationContext
                .getBean("estateAgencyServiceImpl");
        annotationConfigApplicationContext
                .getBean("realPropertyServiceImpl");
        annotationConfigApplicationContext
                .getBean("cityServiceImpl");
        annotationConfigApplicationContext
                .getBean("districtServiceImpl");
    }
}
