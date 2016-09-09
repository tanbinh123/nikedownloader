package com.nikedownloader.controller;

import com.nikedownloader.LoginException;
import com.nikedownloader.model.SearchComponent;
import com.nikedownloader.model.json.Activities;
import com.nikedownloader.service.NikeDownloaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public String login(@RequestParam String email, @RequestParam char[] password, Model model) throws Exception{

        try {
            nikeDownloaderService.sendPost(email, password);
        } catch (Exception e) {
            throw new LoginException("Wrong login or password. Please try again.");
        }

        LocalDate dateNow = LocalDate.now();
        Activities activities = nikeDownloaderService.getActivities(dateNow.minusMonths(6L), dateNow, 1000);
        model.addAttribute("activities", activities.getData());
        model.addAttribute("searchComponent", new SearchComponent(dateNow.minusMonths(6L), dateNow));

        return "activities";
    }

/*    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("index");
        return mav;
    }*/

    @ExceptionHandler(LoginException.class)
    public ModelAndView handleLoginError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
