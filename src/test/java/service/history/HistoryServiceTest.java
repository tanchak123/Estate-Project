package service.history;

import com.ithillel.enums.HistoryLevel;
import com.ithillel.enums.HistoryType;
import com.ithillel.model.*;
import com.ithillel.model.dto.HistoryDetailsDto;
import com.ithillel.model.dto.HistoryDto;
import com.ithillel.model.history.History;
import com.ithillel.model.history.HistoryDetail;
import com.ithillel.service.interfaces.ClientService;
import com.ithillel.service.interfaces.HistoryService;
import com.ithillel.utils.CustomUtils;
import com.ithillel.utils.interfaces.UtilsInterfaces;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import service.ServiceTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;

public class HistoryServiceTest extends ServiceTest {

    private final HistoryService historyService = (HistoryService) annotationConfigApplicationContext
            .getBean("historyServiceImpl");


    @Test
    public void getById() {
        History history = historyService.getById(26L);
        System.out.println(history.toString());

    }

    @Test
    public void getAll() {
        historyService.getAll().forEach(history -> System.out.println(history.getId()));
    }

    @Test
    public void createTest() {
        History history = new History();
        history.setHistoryLevel(HistoryLevel.LOW);
        history.setHistoryType(HistoryType.CREATE);
        history.setCreateDate(System.currentTimeMillis());
        ClientService clientService = (ClientService) annotationConfigApplicationContext
                .getBean("clientServiceImpl");
        Client client = clientService.eagerGetById(6L);
        history.setClient(client);
        client.getHistoryList().add(history);
        System.out.println(client.getId());

        HistoryDetail historyDetail = new HistoryDetail();
        historyDetail.setHistory(history);
        historyDetail.setName(client.getName());
        historyDetail.setValue(history.getHistoryType().name());

        history.setHistoryDetail(historyDetail);
        historyService.create(history);
        Assert.assertEquals(historyService.getById(history.getId()).getHistoryType(), history.getHistoryType());
        Assert.assertNotNull(client.getHistoryList());
    }

    @Test
    public void delete() {
        historyService.deleteById(28L);
    }

    @Test
    public void update() {
        History updated = historyService.getById(26L);
        updated.setHistoryLevel(HistoryLevel.HIGH);
        historyService.update(updated);
        HistoryLevel history_level = historyService.getById(updated.getId()).getHistoryLevel();
        Assert.assertEquals("Local model and database model not equals"
                , history_level
                , updated.getHistoryLevel());
    }

    @Test
    public void callDeleteProcedure() {
        LocalDateTime localDateTime = LocalDateTime.of(
                2020, 11, 19, 14, 42, 7);
        LocalDateTime localDateTime1 = LocalDateTime.of(
                2020, 11, 19, 14, 41, 4);
        Timestamp timestamp = Timestamp.from(localDateTime
                .toInstant(OffsetDateTime.now().getOffset()));
        Timestamp timestamp1 = Timestamp.from(localDateTime1
                .toInstant(OffsetDateTime.now().getOffset()));
        historyService.deleteAllByCreateDateBefore(timestamp.getTime());
    }

    @Test
    public void pageable() {
        final String name = "historyLevel";
        final String value = "TEST";
        CustomUtils.testPageable(name, value, historyService,
                PageRequest.of(0, 3));
    }

    @Test
    public void historyDto() {
        History history = historyService.eagerGetById(24L);
        HistoryDetailsDto detailsDto = new HistoryDetailsDto();
        detailsDto.fromModel(history);
        System.out.println(detailsDto.toString());
        Assert.assertEquals(detailsDto.toString().split(",").length, 7);
        HistoryDto historyDto = new HistoryDto();
        historyDto.fromModel(history);
        System.out.println(historyDto.toString());
        Assert.assertEquals(historyDto.toString().split(",").length, 4);
    }
}
