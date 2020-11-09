import com.ithillel.model.Region;
import org.junit.Assert;
import org.junit.Test;

public class RegionServiceTest extends ServiceTest {

    public RegionServiceTest() {
        testBeans();
    }
    @Test
    public void createTest() {
        Region region = new Region();
        region.setName("CreateTest");
        regionService.create(region);
        Assert.assertEquals(regionService.getById(region.getId()).getName(), region.getName());
    }
}
