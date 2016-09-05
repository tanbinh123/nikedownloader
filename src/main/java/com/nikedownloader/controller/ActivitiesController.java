package com.nikedownloader.controller;

import com.nikedownloader.model.SearchComponent;
import com.nikedownloader.service.NikeDownloaderService;
import com.nikeplus.model.json.Activities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@Controller
public class ActivitiesController {


    @Autowired
    private NikeDownloaderService nikeDownloaderService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value="/activities/download", method= RequestMethod.GET)
    @ResponseBody
    public void downloadFile(@RequestParam(value="id") String id, HttpServletResponse httpServletResponse) throws Exception  {
        logger.info("id" + id);
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + "seba.xml");
        InputStream activity = nikeDownloaderService.getActivityInputStream(id);
        org.apache.tomcat.util.http.fileupload.IOUtils.copy(activity, httpServletResponse.getOutputStream());
    }

    @PostMapping("/search")
    public String searchActivities(@ModelAttribute SearchComponent searchComponent,  Model model) throws Exception {
        logger.info("TEEEEEEEEEEST222");
        Activities activities = nikeDownloaderService.getActivities(searchComponent.getStartDate(), searchComponent.getEndDate(), 1000);
        model.addAttribute("activities", activities.getData());
        return "activities";
    }
}
