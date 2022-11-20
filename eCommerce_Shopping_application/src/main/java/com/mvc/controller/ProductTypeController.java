/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.pojo.Book;
import com.mvc.pojo.Computer;
import com.mvc.pojo.Music;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author gunav
 */

@Controller
public class ProductTypeController {
    
    
    public ProductTypeController() {
    }
    
    @RequestMapping(value="/product.htm", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternalGET(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("in product controller GET");
        String param = request.getParameter("param");
        System.out.println("param"+param);
        if(param.equals("Book")) {
            System.out.println("inside Book param");
            Book obj = new Book();
            request.setAttribute("list", obj.getBook());
            return new ModelAndView("book","book",obj);
        }
        else if(param.equals("Computer")) {
            Computer obj = new Computer();
            request.setAttribute("list", obj.getComputer());
            return new ModelAndView("computer","computer",obj);
        }
        else if(param.equals("Music")) {
            Music obj = new Music();
            request.setAttribute("list", obj.getMusic());
            return new ModelAndView("music","music",obj);
        }
        else {
            ModelAndView mv = new ModelAndView();
//            mv.setViewName("cart");
//            return mv;
            return new ModelAndView("cart");
        }
    }
    
    @RequestMapping(value="/product.htm", method = RequestMethod.POST)
    protected ModelAndView handleRequestInternalPOST(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("in product controller POST");
        String param = request.getParameter("param");
        System.out.println("param"+param);
        if(param.equals("Book")) {
            System.out.println("inside Book param");
            Book obj = new Book();
            request.setAttribute("list", obj.getBook());
            return new ModelAndView("book","book",obj);
        }
        else if(param.equals("Computer")) {
            Computer obj = new Computer();
            request.setAttribute("list", obj.getComputer());
            return new ModelAndView("computer","computer",obj);
        }
        else if(param.equals("Music")) {
            Music obj = new Music();
            request.setAttribute("list", obj.getMusic());
            return new ModelAndView("music","music",obj);
        }
        else {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("cart");
            return mv;
        }
    }
    
}
