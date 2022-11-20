/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtools.hw4.part9.controller;

import com.webtools.hw4.part9.utility.Utility;
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
    
    @RequestMapping(value = "/utility.htm", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternalGET(HttpServletRequest request, HttpServletResponse response, Utility utility) throws Exception {
        return helper(request, response, utility);
    }
    
    @RequestMapping(value = "/utility.htm", method = RequestMethod.POST)
    protected ModelAndView handleRequestInternalPOST(HttpServletRequest request, HttpServletResponse response, Utility utility) throws Exception {
        return helper(request, response, utility);
    }
    
    
    
    protected ModelAndView helper(HttpServletRequest request, HttpServletResponse response, Utility utility) throws Exception{
        return new ModelAndView("view");
    }
}
