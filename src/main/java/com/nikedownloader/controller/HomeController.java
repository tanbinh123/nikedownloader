package com.nikedownloader.controller;

import com.nikedownloader.service.NikeDownloaderService;
import com.nikeplus.model.json.Activities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NikeDownloaderService nikeDownloaderService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String login(@RequestParam String email, @RequestParam char[] password,  Model model) throws Exception {
        logger.info("TEEEEEEEEEEST");

        nikeDownloaderService.sendPost(email,password);
        LocalDate dateNow = LocalDate.now();
        Activities activities = nikeDownloaderService.getActivities(dateNow.minusMonths(6L), dateNow, 1000);
        model.addAttribute("activities", activities.getData());
        return "activities";
    }
}
