package service.realtor;

import com.ithillel.service.interfaces.RealtorService;
import org.junit.Test;
import service.ServiceTest;

public class RealtorServiceTest extends ServiceTest {

    protected RealtorService realtorService = (RealtorService) annotationConfigApplicationContext
            .getBean("realtorServiceImpl");

    @Test
    public void delete() {
        realtorService.deleteById(63L);
    }
}
