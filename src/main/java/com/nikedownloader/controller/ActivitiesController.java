package com.nikedownloader.controller;

import com.nikedownloader.service.NikeDownloaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
