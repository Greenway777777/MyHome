package com.livre.myhome.controller;

import com.livre.myhome.pojo.Website;
import com.livre.myhome.result.Result;
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
    public Result queryAll(){
        return ResultFactory.buildSuccessResult(websiteService.list());
    }

    @CrossOrigin
    @RequestMapping(value = "/api/websites",method = RequestMethod.POST)
    public Result update(@RequestBody Website website){
        websiteService.addOrUpdate(website);
        return ResultFactory.buildSuccessResult("");
    }
    @CrossOrigin
    @RequestMapping(value = "/api/admin/content/websites/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody Website website){
        websiteService.deleteById(website.getId());
        return ResultFactory.buildSuccessResult("");
    }
}
