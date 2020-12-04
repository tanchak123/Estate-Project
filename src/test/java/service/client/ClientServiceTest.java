package service.client;

import com.ithillel.model.Client;
import com.ithillel.model.history.History;
import com.ithillel.service.generic.interfaces.IteratorCustomService;
import com.ithillel.service.interfaces.ClientService;
import com.ithillel.service.interfaces.HistoryService;
import com.ithillel.utils.CustomUtils;
import com.ithillel.utils.interfaces.UtilsInterfaces;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
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
        history.setHistoryLevel("TEST");
        history.setHistoryType("HIGH");
        history.setCreateDate(System.currentTimeMillis());

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

    @Test
    public void pageable() {
        final String name = "name";
        final String value = "TESTER";
        CustomUtils.testPageable(name, value, clientService,
                PageRequest.of(0, 3));
    }



}
