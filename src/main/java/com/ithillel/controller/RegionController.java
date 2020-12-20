package com.ithillel.controller;

import com.ithillel.model.Client;
import com.ithillel.model.Region;
import com.ithillel.model.dto.ClientDto;
import com.ithillel.model.dto.RegionDto;
import com.ithillel.service.interfaces.ClientService;
import com.ithillel.service.interfaces.RegionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegionController {

    @Autowired
    private RegionService regionService;

    private final String name = "region";

    @RequestMapping("/" + name + "s")
    public String allModels(Model model, @RequestParam(defaultValue = "0") Integer page) {
        if (page < 0) {
            return "redirect:/" + name + "s?page=0";
        }
        List<Region> regions = regionService.findAll(
                PageRequest.of(page, 3)).getContent();
        if (regions.size() == 0) {
            return "redirect:/"+ name +"s?page=" + --page;
        }
        List <RegionDto> clientDtoList = new ArrayList<>();
        regions.forEach(region -> clientDtoList.add(new RegionDto(
                region.getName(), region.getId())));
        model.addAttribute(name + "s", clientDtoList);
        model.addAttribute("page", page);
        return String.format("%ss/%ss", name, name);
    }

    @RequestMapping("/" + name + "/{id}")
    public String model(Model model,
                             @PathVariable Long id) {
        Region region = regionService.getById(id);
        ModelMapper modelMapper = new ModelMapper();
        RegionDto regionDto = modelMapper.map(region, RegionDto.class);
        model.addAttribute(name, regionDto);
        return String.format("%ss/%s", name, name);
    }

    @RequestMapping(value = "/" + name + "/update/{id}" , method = RequestMethod.GET)
    public String getUpdateHtml(Model model,
                                  @PathVariable Long id) {
        Region region = regionService.getById(id);
        ModelMapper modelMapper = new ModelMapper();
        RegionDto regionDto = modelMapper.map(region, RegionDto.class);
        System.out.println(regionDto.getName());
        System.out.println(regionDto.getId());
        model.addAttribute(name, regionDto);
        model.addAttribute("id", id);
        return String.format("%ss/%ssUpdate", name, name);
    }

    @RequestMapping(value = "/" + name + "/update", method = RequestMethod.POST)
    public String postUpdate(@ModelAttribute RegionDto regionDto)
            throws UnsupportedEncodingException {
        Region region = regionService.getById(regionDto.getId());
        regionDto.dtoToModel(region);
        System.out.println(region.getId());
        System.out.println(region.getName());
        regionService.update(region);
        return String.format("redirect:/%s/", name) + region.getId();
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
        regionService.deleteById(id);
        return String.format("redirect:/%ss/", name);
    }

    @GetMapping(value = "/" + name + "/create")
    private String getCreateHtml(Model model) {
        model.addAttribute(name, new Region());
        return String.format("%ss/%ssCreate", name, name);
    }

    @PostMapping(value = "/" + name + "/create")
    private String postCreate(@ModelAttribute Region region) {
        return "redirect:/" + name + "/" + regionService.create(region).getId();
    }
}
