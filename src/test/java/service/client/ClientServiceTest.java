package service.client;

import com.ithillel.model.Client;
import com.ithillel.model.history.History;
import com.ithillel.service.interfaces.ClientService;
import com.ithillel.service.interfaces.HistoryService;
import org.junit.Assert;
import org.junit.Test;
import service.ServiceTest;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceTest extends ServiceTest {

    private final ClientService clientService = (ClientService) annotationConfigApplicationContext
            .getBean("clientServiceImpl");
    private final HistoryService historyService = (HistoryService) annotationConfigApplicationContext
            .getBean("historyServiceImpl");

    @Test
    public void createTest() {
        History history = new History();
        history.setHistory_level("TEST");
        history.setHistory_type("HIGH");
        history.setCreate_date(System.currentTimeMillis());

        Client client = new Client();
        client.setLogin("test");
        client.setPassword("test");
        client.setName("TESTER");
        client.setSurname("TESTERENKO");
        client.addHistoryList(new ArrayList<>(List.of(history)));
        history.setClient(client);
        clientService.create(client);
        Assert.assertEquals(clientService.getById(client.getId()).getLogin(),
                client.getLogin());
    }
}
