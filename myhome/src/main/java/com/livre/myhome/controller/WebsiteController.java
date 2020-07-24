package com.livre.myhome.controller;

import com.livre.myhome.pojo.Website;
import com.livre.myhome.result.ResultFactory;
import com.livre.myhome.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebsiteController {
    @Autowired
    WebsiteService websiteService;

    @CrossOrigin
    @RequestMapping(value = "/api/websites",method = RequestMethod.GET)
    public List<Website> getAll(){
        return websiteService.getAll();
    }
}
