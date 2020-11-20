package service.realtor;

import com.ithillel.model.Realtor;
import com.ithillel.model.Region;
import com.ithillel.service.interfaces.RealtorService;
import org.junit.Assert;
import org.junit.Test;
import service.ServiceTest;

public class RealtorServiceTest extends ServiceTest {

    protected RealtorService realtorService = (RealtorService) annotationConfigApplicationContext
            .getBean("realtorServiceImpl");

    @Test
    public void eagerGetById() {
        Realtor realtor = realtorService.eagerGetById(54L);
        Assert.assertNotNull(realtor.getEstateAgencyList());
        Assert.assertNotNull(realtor.getRealPropertyList());
    }

    @Test
    public void delete() {
        realtorService.cascadeDelete(realtorService.getById(57L));
//        realtorService.deleteById(78L);
    }
}
