package service.region;
import com.ithillel.model.*;
import com.ithillel.service.interfaces.RegionService;
import org.junit.Assert;
import org.junit.Test;
import service.ServiceTest;
import java.sql.Timestamp;
import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegionServiceTest extends ServiceTest {

    private final RegionService regionService = (RegionService) annotationConfigApplicationContext
            .getBean("regionServiceImpl");

    @Test
    public void getById() {
        Region region = regionService.getById(26L);
        System.out.println(region.toString());

    }

    @Test
    public void getAll() {
        regionService.getAll().forEach(region1 -> System.out.println(region1.getName()));
    }

    @Test
    public void createTest() {
        Region region = new Region();
        region.setName("Region");
        Area area = new Area();
        area.setName("Area");
        area.setRegion(region);

        District district = new District();
        district.setName("DistrictTest");
        district.setArea(area);
        area.getDistrictList().add(district);
        district = new District();
        district.setArea(area);
        district.setName("DistrictTest2");
        area.getDistrictList().add(district);

        City city = new City();
        city.setName("Южный");
        city.setDistrict(district);
        district.setCities(new ArrayList<>(List.of(city)));

        EstateAgency estateAgency1 = new EstateAgency();
        estateAgency1.setName("Радуга");
        estateAgency1.setDistrict(district);

        EstateAgency estateAgency2 = new EstateAgency();
        estateAgency2.setName("Зло");
        estateAgency2.setDistrict(district);
        district.setEstateAgency(new ArrayList<>(List.of(estateAgency1, estateAgency2)));

        Realtor realtor1 = new Realtor();
        realtor1.setName("Alex");
        realtor1.setSurName("Test1");
        realtor1.addEstateAgencyList(new ArrayList<>(List.of(estateAgency1, estateAgency2)));

        Realtor realtor2 = new Realtor();
        realtor2.setName("Василий");
        realtor2.setSurName("Test2");
        realtor2.setEstateAgencyList(new ArrayList<>(Collections.singletonList(estateAgency1)));
        estateAgency1.setRealtorList(new ArrayList<>(List.of(realtor1, realtor2)));
        estateAgency2.setRealtorList(new ArrayList<>(List.of(realtor2)));

        RealProperty realProperty2 = new RealProperty();
        realProperty2.setName("Универмаг");
        realProperty2.setRealtorList(new ArrayList<>(List.of(realtor2)));
        realtor2.setRealPropertyList(List.of(realProperty2));

        RealProperty realProperty1 = new RealProperty();
        realProperty1.setName("Дом");
        realProperty1.setRealtorList(new ArrayList<>(List.of(realtor1)));
        realtor1.setRealPropertyList(List.of(realProperty1));
        regionService.create(region);
        Assert.assertEquals(regionService.getById(region.getId()).getName(), region.getName());
    }

    @Test
    public void delete() {
        regionService.deleteById(28L);
    }

    @Test
    public void update() {
        Region updated = regionService.getById(26L);
        updated.setName("UPDATEDfromTest");
        regionService.update(updated);
        String name = regionService.getById(updated.getId()).getName();
        Assert.assertEquals("Local model and database model not equals", name, updated.getName());
    }

    @Test
    public void getAllSorted() {
        regionService.getAllSorted("name")
                .forEach(region -> System.out.println(region.getName()));
        regionService.getAllSorted("id")
                .forEach(region -> System.out.println(region.getId()));
        regionService.getAllSorted("createDate")
                .forEach(region -> System.out.println(region.getCreateDate()));
    }

    @Test
    public void getByCriteria() {
        regionService.getBetWeen("id", 10L, 30L)
                .forEach(region -> System.out.println(region.toString()));
        LocalDateTime localDateTime = LocalDateTime.of(
                2020, 11, 11, 3, 5, 0);
        LocalDateTime localDateTime1 = LocalDateTime.of(
                2020, 11, 30, 23, 59, 59);
        Timestamp timestamp = Timestamp.from(localDateTime
                        .toInstant(OffsetDateTime.now().getOffset()));
        Timestamp timestamp1 = Timestamp.from(localDateTime1
                .toInstant(OffsetDateTime.now().getOffset()));
        regionService.getBetWeen("createDate", timestamp.getTime()
                , timestamp1.getTime())
                .forEach(region -> System.out.println(region.toString()));
    }


//
//    List<C> getAll();
}
