package com.dayton.rest.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bruce on 17-5-5.
 */
@Controller
@RequestMapping(value = "/user/*")
public class UserController {

    @RequestMapping(value = "add",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(HttpServletRequest request){
        System.out.println("method add");
        return "add";
    }

    @RequestMapping(value = "update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String update(HttpServletRequest request){

        return "update";
    }

    @RequestMapping(value = "delete",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String delete(HttpServletRequest request){

        return "delete"; }

    @RequestMapping(value = "list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String list(HttpServletRequest request){

        return "list";
    }

}
