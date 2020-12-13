package com.ithillel.controller;

import com.ithillel.model.Client;
import com.ithillel.model.dto.ClientDto;
import com.ithillel.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/clients")
    public String allClients(Model model) {
        List<Client> clients = clientService.getAllByValueOrderById("client", "id",
                PageRequest.of(0, 3),  null).getContent();
        List <ClientDto> clientDtoList = new ArrayList<>();
        clients.forEach(client -> clientDtoList.add(new ClientDto(client.getId(),
                client.getName(),
                client.getSurname(),
                client.getLogin())));
        model.addAttribute("clients", clientDtoList);
        return "clients";
    }

}
