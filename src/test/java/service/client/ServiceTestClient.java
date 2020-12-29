package service.client;

import com.ithillel.model.Client;
import com.ithillel.service.interfaces.ClientService;
import com.ithillel.service.interfaces.HistoryService;
import org.junit.Assert;
import org.junit.Test;

import service.ServiceTest;


public class ServiceTestClient extends ServiceTest {

    private final ClientService clientService = (ClientService) annotationConfigApplicationContext
            .getBean("clientServiceImpl");
    private final HistoryService historyService = (HistoryService) super.annotationConfigApplicationContext
            .getBean("historyServiceImpl");


//    @Test
//    public void createTest() {
//            History history = new History();
//            history.setName("createTest");
//            history.setHistoryLevel(HistoryLevel.HIGH);
//            history.setHistoryType(HistoryType.CREATE);
//            history.setCreateDate(System.currentTimeMillis());
//
//            Client client = new Client();
//            client.setLogin("test");
//            client.setPassword("test");
//            client.setName("TESTER");
//            client.setSurname("TESTERENKO");
//            client.setRole(UserRole.USER);
//            client.addHistoryList(new ArrayList<>(List.of(history)));
//            history.setClient(client);
//            clientService.create(client);
//            Assert.assertEquals(clientService.getById(client.getId()).getLogin(),
//                    client.getLogin());
//    }
//
//    @Test
//    public void getAll() {
//        clientService.getAll().forEach(System.out::println);
//    }
//
//    @Test
//    public void deleteTest() {
//        clientService.deleteById(2L);
//        Assert.assertNull(clientService.getById(7L));
//    }
//
//    @Test
//    public void pageable() {
//        final String name = "name";
//        final String value = "TESTER";
//        CustomUtils.testPageable(name, value, clientService,
//                PageRequest.of(0, 3));
//        int page = 0;
//        Page<Client> all = clientService.findAll(PageRequest.of(page, 4));
//        while (all.getPageable().isPaged()) {
//            System.out.println("WHILE");
//            for (Client client : all.getContent()) {
//                System.out.println(client.getSurname());
//                System.out.println(client.getId());
//            }
//            page++;
//            all = clientService.findAll(all.nextPageable());
//            System.out.println("TOTAL " + all.getTotalPages());
//        }
//    }

    @Test
    public void getByLoginAndPassword() {
        String login = "test1";
        String password = "test";
        Client byLoginAndPassword = clientService.getByLogin(login);
        Assert.assertNotNull(byLoginAndPassword);
        Assert.assertEquals(login, byLoginAndPassword.getLogin());
        Assert.assertEquals(password, byLoginAndPassword.getPassword());
    }

}
