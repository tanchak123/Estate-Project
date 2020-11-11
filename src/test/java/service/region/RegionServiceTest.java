package service.region;

import com.ithillel.model.Region;
import org.junit.Assert;
import org.junit.Test;
import service.ServiceTest;

import java.sql.Timestamp;
import java.time.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
                2020, 11, 1, 0, 0, 0);
        LocalDateTime localDateTime1 = LocalDateTime.of(
                2020, 11, 30, 23, 59, 59);
        regionService.getBetWeenTimeStamp("updateDate", Timestamp.from(localDateTime
                        .toInstant(OffsetDateTime.now().getOffset()))
                , Timestamp.from(localDateTime1
                        .toInstant(OffsetDateTime.now().getOffset())))
                .forEach(region -> System.out.println(region.toString()));
    }
}
