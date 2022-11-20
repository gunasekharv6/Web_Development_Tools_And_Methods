/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtools.hw4.part7.controller;

import com.webtools.hw4.part7.utility.Utility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author gunav
 */

public class UtilityController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Utility utility = (Utility) this.getApplicationContext().getBean("ut");
        request.setAttribute("info", utility.getInfo());
        request.setAttribute("view", utility);
        return new ModelAndView("view");
    }
}
