package service.estateagency;

import com.ithillel.model.EstateAgency;
import com.ithillel.model.Region;
import org.junit.Assert;
import org.junit.Test;
import service.ServiceTest;

public class EstateAgencyServiceTest extends ServiceTest {

    @Test
    public void createTest() {
        EstateAgency estateAgency = new EstateAgency();
        estateAgency.setName("CreateTest");
        estateAgencyService.create(estateAgency);
        Assert.assertEquals(estateAgencyService.getById(estateAgency.getId()).getName(), estateAgency.getName());
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
