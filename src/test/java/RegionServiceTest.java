import com.ithillel.appcontext.ApplicationContext;
import com.ithillel.dao.RegionDaoImpl;
import com.ithillel.model.Region;
import com.ithillel.service.RegionServiceImpl;
import com.ithillel.service.interfaces.RegionService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegionServiceTest extends ServiceTest {

    @Test
    public void createTest() {
        Region region = new Region();
        region.setName("CreateTest");
        regionService.create(region);
        Assert.assertEquals(regionService.getById(region.getId()).getName(), region.getName());
    }
}
