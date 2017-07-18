package com.home.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by bharat on 18/7/17.
 */
@RestController
@RequestMapping("/home/")
public class HomeController {

    @RequestMapping(value = "ping", method = RequestMethod.GET)
    public ModelMap ping() {
        ModelMap map = new ModelMap("time", new Date().toString());
        map.put("version", this.getClass().getPackage().getImplementationVersion());
        map.put("module", "url-shortener-api");
        return map;
    }
}
