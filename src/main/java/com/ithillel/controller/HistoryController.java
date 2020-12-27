package com.ithillel.controller;

import com.ithillel.model.Realtor;
import com.ithillel.model.dto.HistoryDetailsDto;
import com.ithillel.model.dto.HistoryDto;
import com.ithillel.model.history.History;
import com.ithillel.service.interfaces.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    private final String name = "history";
    private final String pluralName = "histories";

    @RequestMapping("/" + pluralName)
    public String allModels(Model model, @RequestParam(defaultValue = "0") Integer page) {
        if (page < 0) {
            return "redirect:/" + pluralName + "?page=0";
        }
        List<History> histories = historyService.findAll(
                PageRequest.of(page, 3)).getContent();
        if (histories.size() == 0) {
            return "redirect:/"+ pluralName +"?page=" + --page;
        }
        List <HistoryDto> historyDtos = new ArrayList<>();
        histories.forEach(history -> {
            HistoryDto historyDto = new HistoryDto();
            historyDto.fromModel(history);
            historyDtos.add(historyDto);
        });
        model.addAttribute(pluralName, historyDtos);
        model.addAttribute("page", page);
        return String.format("%s/%s", pluralName, pluralName);
    }

    @RequestMapping("/" + name + "/{id}")
    public String model(Model model,
                        @PathVariable Long id) {
        History history = historyService.getById(id);
        HistoryDto historyDto = new HistoryDto();
        historyDto.fromModel(history);
        model.addAttribute(name, historyDto);
        return String.format("%s/%s", pluralName, name);
    }

    @RequestMapping(value = "/" + name + "/update/{id}" , method = RequestMethod.GET)
    public String getUpdateHtml(Model model,
                                @PathVariable Long id,
                                @RequestParam(required = false) String message) {
        History history = historyService.getById(id);
        HistoryDto historyDto = new HistoryDto();
        historyDto.fromModel(history);
        model.addAttribute("message", message);
        model.addAttribute(name, historyDto);
        model.addAttribute("id", id);
        return String.format("%s/%sUpdate", pluralName, pluralName);
    }

    @RequestMapping(value = "/" + name + "/update", method = RequestMethod.POST)
    public String postUpdate(@ModelAttribute HistoryDto historyDto, Model model)
            throws UnsupportedEncodingException {
        History history = historyService.getById(historyDto.getId());
        historyDto.toModel(history);
        historyService.update(history);
        return String.format("redirect:/%s/", name) + history.getId();
    }

    @RequestMapping(value = name + "/delete", method = RequestMethod.GET)
    public String delete() {
        return String.format("%s/%sDelete", pluralName, pluralName);
    }

    @RequestMapping(value = name + "/delete", method = RequestMethod.POST)
    private String getDeleteHtml(@RequestParam Long id) {
        return String.format("redirect:/%s/delete/", name) + id;
    }

    @RequestMapping(value = name + "/delete/{id}", method = RequestMethod.GET)
    private String postDelete(@PathVariable Long id) {
        historyService.deleteById(id);
        return String.format("redirect:/%s/", pluralName);
    }

    @GetMapping(value = "/" + name + "/create")
    private String getCreateHtml(Model model) {
        model.addAttribute(name, new History());
        return String.format("%s/%sCreate", pluralName, pluralName);
    }

    @PostMapping(value = "/" + name + "/create")
    private String postCreate(@ModelAttribute History history) {
        return "redirect:/" + name + "/" + historyService.create(history).getId();
    }

    @GetMapping(value = "/" + name + "/{id}/details")
    private String getDetails(@PathVariable Long id, Model model) {
        History history = historyService.eagerGetById(id);
        HistoryDetailsDto detailsDto = new HistoryDetailsDto();
        detailsDto.fromModel(history);
        model.addAttribute("history", detailsDto);
        return String.format("%s/%sDetails", pluralName, name);
    }
}
