package com.dashboard.controller;

import com.dashboard.service.UrlResponseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MOBIKWIK\omk707 on 17/7/17.
 */
@RestController
@RequestMapping(value ="/url")
public class UrlDashboardController {



    @Autowired
    private UrlResponseService urlResponseService;

    static int k=0;

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void method(){

        logger.info("hdskfgkajfdvb");


    }
    @RequestMapping(value = "/long/{longUrl}", method = RequestMethod.POST)
    public String urlLongSave(@PathVariable("longUrl") String longUrl, HttpServletRequest http) throws Exception {

        logger.info("entered block where we get rrequest to convert a long url to short");
        String response;
        boolean flag;

        response= String.valueOf(urlResponseService.ifExists(longUrl,http));
        if(response!=null)
            return response;


        else {
            urlResponseService.persist(longUrl, http);
            return "url inserted";
        }

    }

    @RequestMapping(value = "/short/{shorturl}",method = RequestMethod.GET)
    public String getUrlByShortUrl(@PathVariable("shorturl")String shorturl,HttpServletRequest httpServletRequest){



        logger.info("entered the controller where short url gives long url");
        String response;
        response=urlResponseService.ifExistsS(shorturl,httpServletRequest);
        if(response!=null)
            return response;
        else
            return "invalid";


    }








}
