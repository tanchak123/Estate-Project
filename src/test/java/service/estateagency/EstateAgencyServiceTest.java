package service.estateagency;

import com.ithillel.model.EstateAgency;
import com.ithillel.service.interfaces.EstateAgencyService;
import org.junit.Assert;
import org.junit.Test;
import service.ServiceTest;

public class EstateAgencyServiceTest extends ServiceTest {

    protected EstateAgencyService estateAgencyService = (EstateAgencyService) annotationConfigApplicationContext
            .getBean("estateAgencyServiceImpl");

    @Test
    public void createTest() {
        EstateAgency estateAgency = new EstateAgency();
        estateAgency.setName("CreateTest");
        estateAgencyService.create(estateAgency);
        Assert.assertEquals(estateAgencyService.getById(estateAgency.getId()).getName(), estateAgency.getName());
    }

    @Test
    public void delete() {
        estateAgencyService.deleteById(53L);
    }

    @Test
    public void getAllSorted() {
//        estateAgencyService.getAllSorted("name")
//                .forEach(region -> System.out.println(region.getName()));
//        estateAgencyService.getAllSorted("id")
//                .forEach(region -> System.out.println(region.getId()));
//        estateAgencyService.getAllSorted("createDate")
//                .forEach(region -> System.out.println(region.getCreateDate().toString()));
    }
}
