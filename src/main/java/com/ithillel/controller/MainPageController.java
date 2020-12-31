package com.ithillel.controller;


import com.ithillel.model.Client;
import com.ithillel.service.interfaces.ClientService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.preauth.RequestAttributeAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/")
public class MainPageController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public String main() {
        return "main.html";
    }



    @GetMapping(value = "/style")
    public String css() {
        return "css/style.css";
    }
}
