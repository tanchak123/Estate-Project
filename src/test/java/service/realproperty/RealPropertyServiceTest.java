package service.realproperty;

import com.ithillel.model.Client;
import com.ithillel.model.EstateAgency;
import com.ithillel.model.RealProperty;
import com.ithillel.model.Realtor;
import com.ithillel.service.interfaces.EstateAgencyService;
import com.ithillel.service.interfaces.RealPropertyService;
import com.ithillel.utils.CustomUtils;
import com.ithillel.utils.interfaces.UtilsInterfaces;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import service.ServiceTest;

public class RealPropertyServiceTest extends ServiceTest {

    private final RealPropertyService realPropertyService = (RealPropertyService)
            annotationConfigApplicationContext.getBean("realPropertyServiceImpl");
    private final EstateAgencyService estateAgencyService = (EstateAgencyService)
            annotationConfigApplicationContext.getBean("estateAgencyServiceImpl");

    @Test
    public void createTest() {
        RealProperty realProperty = new RealProperty();
        realProperty.setName("Test");

        Realtor realtor = new Realtor();
        realtor.setName("412");
        realtor.setSurName("248");
        realtor.setExperience(12);
        realtor.getRealPropertyList().add(realProperty);
        realProperty.getRealtorList().add(realtor);
        realPropertyService.create(realProperty);
        EstateAgency agency = estateAgencyService.eagerGetById(54L);
        EstateAgency agency2 = estateAgencyService.eagerGetById(55L);
        agency.getRealtorList().add(realtor);
        agency2.getRealtorList().add(realtor);
        estateAgencyService.update(agency);
        estateAgencyService.update(agency2);
        Assert.assertEquals(realPropertyService.getById(realProperty.getId()).getName(),
                realProperty.getName());
    }

    @Test
    public void pageable() {
        final String name = "name";
        final String value = "Test";
        CustomUtils.testPageable(name, value, realPropertyService,
                PageRequest.of(0, 3));
    }
}
