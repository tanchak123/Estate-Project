package com.ithillel.controller;

import com.ithillel.enums.UserRole;
import com.ithillel.model.Client;
import com.ithillel.model.dto.ClientDto;
import com.ithillel.service.interfaces.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@EnableWebMvc
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @RequestMapping("/clients")
    public String allClients(Model model, @RequestParam(defaultValue = "0") Integer page) {
        if (page < 0) {
            return "redirect:/clients?page=0";
        }
        List<Client> clients = clientService.findAll(
                PageRequest.of(page, 3)).getContent();
        if (clients.size() == 0) {
            return "redirect:/clients?page=" + --page;
        }
        List <ClientDto> clientDtoList = new ArrayList<>();
        clients.forEach(client -> clientDtoList.add(new ClientDto(client.getId(),
                client.getName(),
                client.getSurname(),
                client.getLogin(),
                client.getRole().name())));
        model.addAttribute("clients", clientDtoList);
        model.addAttribute("page", page);
        return "clients/clients";
    }

    @GetMapping("/myprofile")
    public String myProfile(Authentication authentication) {
        Client client = clientService.getByLogin(authentication.getName());
        return "redirect:/client/" + client.getId();
    }

    @RequestMapping("/client/{id}")
    public String allClients(Model model,
                             @PathVariable Long id, Authentication authentication) {
        Client client = clientService.getById(id);
        String role = "";
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            role = grantedAuthority.getAuthority();
        }
        if (!role.substring(role.length() - 5).equals(UserRole.ADMIN.name()) && !client.getLogin()
                .equals(authentication.getName())) {
            return "redirect:/client/" + clientService.getByLogin(authentication.getName()).getId();
        }
        ModelMapper modelMapper = new ModelMapper();
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        model.addAttribute("client", clientDto);
        return "clients/client";
    }

    @RequestMapping(value = "/client/update/{id}", method = RequestMethod.GET)
    public String getUpdateClient(Model model,
                             @PathVariable Long id) {
        Client client = clientService.getById(id);
        ModelMapper modelMapper = new ModelMapper();
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        model.addAttribute("client", clientDto);
        model.addAttribute("id", id);
        return "clients/clientsUpdate";
    }

    @RequestMapping(value = "/client/update", method = RequestMethod.POST)
    public String updateClient(@ModelAttribute ClientDto clientDto)
            throws UnsupportedEncodingException {
        ModelMapper modelMapper = new ModelMapper();
        Client client = modelMapper.map(clientDto, Client.class);
        client.setPassword(clientService.getById(client.getId()).getPassword());
        clientService.update(client);
        return "redirect:/client/" + clientDto.getId();
    }

    @RequestMapping(value = "client/delete", method = RequestMethod.GET)
    public String deleteClient() {
        return "clients/clientsDelete";
    }

    @RequestMapping(value = "client/delete", method = RequestMethod.POST)
    private String deleteClient(@RequestParam Long id) {
        return "redirect:/client/delete/" + id;
    }

    @RequestMapping(value = "client/delete/{id}", method = RequestMethod.GET)
    private String delete(@PathVariable Long id) {
        clientService.deleteById(id);
        return "redirect:/clients/";
    }
    
    @GetMapping(value = "/client/create")
    private String createForm(Model model) {
        model.addAttribute("client", new Client());
        return "clients/clientsCreate";
    }

    @PostMapping(value = "/client/create")
    private String createForm(@ModelAttribute Client client) {
        return "redirect:/client/" + clientService.create(client).getId();
    }

}
