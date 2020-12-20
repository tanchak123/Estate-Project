package service.estateagency;

import com.ithillel.model.Area;
import com.ithillel.model.District;
import com.ithillel.model.EstateAgency;
import com.ithillel.model.Region;
import com.ithillel.service.interfaces.DistrictService;
import com.ithillel.service.interfaces.EstateAgencyService;
import com.ithillel.utils.CustomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import service.ServiceTest;

public class EstateAgencyServiceTest extends ServiceTest {

    protected EstateAgencyService estateAgencyService = (EstateAgencyService) annotationConfigApplicationContext
            .getBean("estateAgencyServiceImpl");
    protected DistrictService districtService = (DistrictService) annotationConfigApplicationContext
            .getBean("districtServiceImpl");

    @Test
    public void createTest() {
        EstateAgency estateAgency = new EstateAgency();
        estateAgency.setName("CreateTest");
        District district = new District();
        district.setName("123");
        district.getEstateAgencyList().add(estateAgency);
        estateAgency.setDistrict(district);
        Area area = new Area();
        area.setName("TEST");
        area.getDistrictList().add(district);
        Region region = new Region();
        region.setName("TEST");
        region.setArea(area);
        area.setRegion(region);
        district.setArea(area);
        estateAgencyService.create(estateAgency);
        Assert.assertEquals(estateAgencyService.getById(estateAgency.getId()).getName(), estateAgency.getName());
    }

    @Test
    public void delete() {
        estateAgencyService.deleteById(54L);
    }

    @Test
    public void pageable() {
        final String name = "name";
        final String value = "CreateTest";
        CustomUtils.testPageable(name, value, estateAgencyService,
                PageRequest.of(0, 3));
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
