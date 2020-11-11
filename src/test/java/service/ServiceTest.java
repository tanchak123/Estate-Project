package service;

import com.ithillel.appcontext.ApplicationContext;
import com.ithillel.service.interfaces.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServiceTest {

    protected static AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(ApplicationContext.class);
    protected RegionService regionService;
    protected CityService cityService;
    protected DistrictService districtService;
    protected AreaService areaService;
    protected EstateAgencyService estateAgencyService;
    protected RealtorService realtorService;
    protected RealPropertyService realPropertyService;


    @Test
    public void testBeans() {
        regionService = (RegionService) annotationConfigApplicationContext
                .getBean("regionServiceImpl");
        realtorService = (RealtorService) annotationConfigApplicationContext
                .getBean("realtorServiceImpl");
        areaService = (AreaService) annotationConfigApplicationContext
                .getBean("areaServiceImpl");
        estateAgencyService = (EstateAgencyService) annotationConfigApplicationContext
                .getBean("estateAgencyServiceImpl");
        realPropertyService = (RealPropertyService) annotationConfigApplicationContext
                .getBean("realPropertyServiceImpl");
        cityService = (CityService) annotationConfigApplicationContext
                .getBean("cityServiceImpl");
        districtService = (DistrictService) annotationConfigApplicationContext
                .getBean("districtServiceImpl");
    }
}
