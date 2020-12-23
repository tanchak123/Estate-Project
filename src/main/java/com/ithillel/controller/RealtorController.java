package com.ithillel.controller;

import com.ithillel.model.Realtor;
import com.ithillel.model.Region;
import com.ithillel.model.dto.RealtorDto;
import com.ithillel.model.dto.RegionDto;
import com.ithillel.service.interfaces.RealtorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RealtorController {


    @Autowired
    private RealtorService realtorService;

    private final String name = "realtor";

    @RequestMapping("/" + name + "s")
    public String allModels(Model model, @RequestParam(defaultValue = "0") Integer page) {
        if (page < 0) {
            return "redirect:/" + name + "s?page=0";
        }
        List<Realtor> realtors = realtorService.findAll(
                PageRequest.of(page, 3)).getContent();
        if (realtors.size() == 0) {
            return "redirect:/"+ name +"s?page=" + --page;
        }
        List <RealtorDto> realtorDtos = new ArrayList<>();
        realtors.forEach(realtor -> {
            RealtorDto realtorDto = new RealtorDto();
            realtorDto.modelToDto(realtor);
            realtorDtos.add(realtorDto);
        });
        model.addAttribute(name + "s", realtorDtos);
        model.addAttribute("page", page);
        return String.format("%ss/%ss", name, name);
    }

    @RequestMapping("/" + name + "/{id}")
    public String model(Model model,
                        @PathVariable Long id) {
        Realtor realtor = realtorService.getById(id);
        RealtorDto realtorDto = new RealtorDto();
        realtorDto.modelToDto(realtor);
        model.addAttribute(name, realtorDto);
        return String.format("%ss/%s", name, name);
    }

    @RequestMapping(value = "/" + name + "/update/{id}" , method = RequestMethod.GET)
    public String getUpdateHtml(Model model,
                                @PathVariable Long id,
                                @RequestParam(required = false) String message) {
        Realtor realtor = realtorService.getById(id);
        RealtorDto realtorDto = new RealtorDto();
        realtorDto.modelToDto(realtor);
        model.addAttribute("message", message);
        model.addAttribute(name, realtorDto);
        model.addAttribute("id", id);
        return String.format("%ss/%ssUpdate", name, name);
    }

    @RequestMapping(value = "/" + name + "/update", method = RequestMethod.POST)
    public String postUpdate(@ModelAttribute RealtorDto realtorDto, Model model)
            throws UnsupportedEncodingException {
        if (realtorDto.getExperience() > 50) {
            model.addAttribute("message", "Experience must be less then 50");
            return String.format("redirect:/%s/update/" + realtorDto.getId(), name);
        }
        Realtor realtor = realtorService.getById(realtorDto.getId());
        realtorDto.dtoToModel(realtor);
        realtorService.update(realtor);
        return String.format("redirect:/%s/", name) + realtor.getId();
    }

    @RequestMapping(value = name + "/delete", method = RequestMethod.GET)
    public String delete() {
        return String.format("%ss/%ssDelete", name, name);
    }

    @RequestMapping(value = name + "/delete", method = RequestMethod.POST)
    private String getDeleteHtml(@RequestParam Long id) {
        return String.format("redirect:/%s/delete/", name) + id;
    }

    @RequestMapping(value = name + "/delete/{id}", method = RequestMethod.GET)
    private String postDelete(@PathVariable Long id) {
        realtorService.deleteById(id);
        return String.format("redirect:/%ss/", name);
    }

    @GetMapping(value = "/" + name + "/create")
    private String getCreateHtml(Model model) {
        model.addAttribute(name, new Realtor());
        return String.format("%ss/%ssCreate", name, name);
    }

    @PostMapping(value = "/" + name + "/create")
    private String postCreate(@ModelAttribute Realtor realtor) {
        return "redirect:/" + name + "/" + realtorService.create(realtor).getId();
    }
}
