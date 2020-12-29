package service;


import com.ithillel.appcontext.security.SecurityConfig;
import com.ithillel.appcontext.web.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        com.ithillel.appcontext.ApplicationContext.class, WebConfig.class, SecurityConfig.class})
@WebAppConfiguration
public class ServiceTest {

    @Autowired
    protected ApplicationContext annotationConfigApplicationContext;


    @Test
    public void testBeans() {
        System.out.println("fdasfas");
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
//    protected AnnotationConfigApplicationContext annotationConfigApplicationContext;

//    protected static AnnotationConfigApplicationContext annotationConfigApplicationContext =
//            new AnnotationConfigApplicationContext(ApplicationContext.class);
//
//

}
