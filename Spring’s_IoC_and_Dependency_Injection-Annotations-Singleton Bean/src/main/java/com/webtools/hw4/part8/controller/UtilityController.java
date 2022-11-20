/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtools.hw4.part8.controller;

import com.webtools.hw4.part8.utility.Utility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gunav
 */

@Controller
public class UtilityController {

    @Autowired
    Utility utility1;
    
    @RequestMapping(value = "/utility.htm", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternalGET(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return helper(request, response);
    }
    
    @RequestMapping(value = "/utility.htm", method = RequestMethod.POST)
    protected ModelAndView handleRequestInternalPOST(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return helper(request, response);
    }
    
    
    
    protected ModelAndView helper(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setAttribute("info", utility1.getInfo());
        request.setAttribute("view", utility1);
        return new ModelAndView("view", "utility", utility1);
    }
}
