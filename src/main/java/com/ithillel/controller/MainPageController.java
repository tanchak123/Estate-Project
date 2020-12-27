package com.ithillel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/")
public class MainPageController {

    @GetMapping
    public String main() {
        return "main.html";
    }

    @GetMapping(value = "/style")
    public String css() {
        return "css/style.css";
    }

}
