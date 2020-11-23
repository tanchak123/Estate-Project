package service.history;

import com.ithillel.model.*;
import com.ithillel.model.history.History;
import com.ithillel.model.history.HistoryDetail;
import com.ithillel.service.interfaces.ClientService;
import com.ithillel.service.interfaces.HistoryService;
import org.junit.Assert;
import org.junit.Test;
import service.ServiceTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.logging.SimpleFormatter;

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
        history.setHistory_level("TEST");
        history.setHistory_type("HIGH");
        history.setCreate_date(System.currentTimeMillis());
        ClientService clientService = (ClientService) annotationConfigApplicationContext
                .getBean("clientServiceImpl");
        Client client = clientService.eagerGetById(6L);
        history.setClient(client);
        HistoryDetail historyDetail = new HistoryDetail();
        historyDetail.setHistory(history);
        historyDetail.setName(client.getName());
        historyDetail.setValue(history.getHistory_type());
        history.setHistoryDetail(historyDetail);
        historyService.create(history);
        Assert.assertEquals(historyService.getById(history.getId()).getHistory_type(), history.getHistory_type());
        Assert.assertNotNull(client.getHistoryList());
    }

    @Test
    public void delete() {
        historyService.deleteById(28L);
    }

    @Test
    public void update() {
        History updated = historyService.getById(26L);
        updated.setHistory_level("HIGH");
        historyService.update(updated);
        String history_level = historyService.getById(updated.getId()).getHistory_level();
        Assert.assertEquals("Local model and database model not equals"
                , history_level
                , updated.getHistory_level());
    }

    @Test
    public void callDeleteProcedure() {
        LocalDateTime localDateTime = LocalDateTime.of(
                2020, 11, 19, 14, 38, 4);
        LocalDateTime localDateTime1 = LocalDateTime.of(
                2020, 11, 19, 14, 41, 4);
        Timestamp timestamp = Timestamp.from(localDateTime
                .toInstant(OffsetDateTime.now().getOffset()));
        Timestamp timestamp1 = Timestamp.from(localDateTime1
                .toInstant(OffsetDateTime.now().getOffset()));
        historyService.callDeleteProcedure(timestamp);
        historyService.callDeleteProcedureNative(timestamp1);
        historyService.callDeleteProcedureTemplate(timestamp);
    }
}
