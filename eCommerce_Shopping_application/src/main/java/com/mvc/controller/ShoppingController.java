/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gunav
 */

@Controller
public class ShoppingController {
    
    @RequestMapping(value="/cart.htm", method = RequestMethod.GET)
    public void getProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        authentication(request, response);
    }
    
    @RequestMapping(value="/cart.htm", method = RequestMethod.POST)
    public void postRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        authentication(request, response);
    }
    
    private void authentication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String auth = request.getHeader("Authorization");
        if (auth == null) {
            askForPassword(response);
        } else {
            String userInfo = auth.substring(6).trim();
            byte[] nameAndPasswordBytes = Base64.getDecoder().decode(userInfo);
            String nameAndPassword = new String(nameAndPasswordBytes);
            int index = nameAndPassword.indexOf(':');
            String user = nameAndPassword.substring(0, index);
            String password = nameAndPassword.substring(index + 1);
            if (areEqualReversed(user, password)) {
                processRequest(request, response);
            } else {
                askForPassword(response);
            }
        }
    }
    
    private void askForPassword(HttpServletResponse response) {
        response.setStatus(response.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate",
                "BASIC realm=\"Store-cart\"");
    }

    private boolean areEqualReversed(String s1, String s2) {
        s2 = (new StringBuffer(s2)).reverse().toString();
        return ((s1.length() > 0) && s1.equals(s2));
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        List<String> list;
        if (action.equals("add")) {
            String[] items = request.getParameterValues("chkItem");
            if (session.getAttribute("list") != null)
                list = (List<String>) session.getAttribute("list");
            else
                list = new ArrayList<>();
            for (String s : items) {
                list.add(s);
            }
            request.setAttribute("item", items);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/confirmAdd.jsp");
            rd.forward(request, response);
        } else {
            String element = request.getParameter("element");
            list = (List<String>) session.getAttribute("list");
            list.remove(element);
            request.setAttribute("item", element);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/confirmDelete.jsp");
            rd.forward(request, response);
        }
        session.setAttribute("list", list);
    }
}
