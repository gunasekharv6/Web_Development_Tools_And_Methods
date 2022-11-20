/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.pojo.Movies;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author gunav
 */
public class MovieController extends AbstractController {

    public MovieController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();

        try {
            System.err.println("try");
            String action = request.getParameter("action");
            String errorMessage;

            mav.setViewName("movieView");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "MySql@1994");

            if (con != null) {
                Statement statement = con.createStatement();

                if (action.equals("add")) {
                    System.err.println("add");
                    String sql;
                    String title = request.getParameter("title");
                    String actor = request.getParameter("actor");
                    String actress = request.getParameter("actress");
                    String genre = request.getParameter("genre");
                    int yr = Integer.parseInt(request.getParameter("year"));

                    sql = "Select * from movies where title ='" + title + "'";
                    ResultSet resultSet = statement.executeQuery(sql);
                    if (resultSet.next() == true) {
                        errorMessage = "SQL exception! Duplicate Enteries of title not allowed";
                        request.setAttribute("errorMessage", errorMessage);
                        mav.setViewName("ErrorView");
                    } else {
                        sql = "INSERT INTO movies VALUES('" + title + "','" + actor + "','" + actress + "','" + genre + "','" + yr + "')";
                        int rs = statement.executeUpdate(sql);
                        if (rs <= 0) {
                            errorMessage = "SQL exception! Error Occured while inserting data";
                            request.setAttribute("errorMessage", errorMessage);
                            mav.setViewName("ErrorView");
                        } else {
                            request.setAttribute("type", "addMovie");
                            mav.setViewName("SuccessView");
                        }
                    }
                } else if (action.equals("search")) {
                    
                    System.out.println("action: "+action);
                    String searchBy = request.getParameter("radio");
                    String keyword = request.getParameter("keyword");
                    String sql = "";
                    sql += "SELECT * FROM movies where " + searchBy + " like '%" + keyword + "%'";
                    System.out.println(sql);
                    List<Movies> listMovies = new ArrayList<>();

                    ResultSet resultSet = statement.executeQuery(sql);
                    if (resultSet.next() == false) {
                        errorMessage = "No data found in library";
                        request.setAttribute("errorMessage", errorMessage);
                        mav.setViewName("ErrorView");
                    } else {
                        System.out.println("Data found in library");
                        Movies movies = new Movies(resultSet.getString("title"), resultSet.getString("actor"), resultSet.getString("actress"),
                                resultSet.getString("genre"), resultSet.getInt("year"));
                        listMovies.add(movies);
                        while (resultSet.next()) {
//                            System.out.println(resultSet.next());
                            System.out.println("resultSet.getString(\"title\")"+resultSet.getString("title"));
                            movies = new Movies(resultSet.getString("title"), resultSet.getString("actor"), resultSet.getString("actress"),
                                    resultSet.getString("genre"), resultSet.getInt("year"));
                            listMovies.add(movies);
                        }
                        request.setAttribute("type", "searchMovie");
                        if (keyword.isEmpty()) {
                            keyword = "All movies in library";
                        } else if (keyword.equals("%")) {
                            keyword = "All " + searchBy;
                        }
                        request.setAttribute("keyword", keyword);
                        request.setAttribute("list", listMovies);
                    }
                    
                } else {
                    System.err.println("request.getParameter(\"selection\")"+request.getParameter("selection") );
                    if (request.getParameter("selection").equals("browse")) {
                        mav.setViewName("searchMovie");
                    } else {
                        mav.setViewName("insertMovie");
                    }
                }
            } else {
                System.out.println("Error Occured: Unable to establish connection");
            }
        } catch (ClassNotFoundException e) {
            System.err.print("Class not Found! " + e.getMessage());
        } catch (SQLException e) {
            System.err.print("SQL exception!" + e.getMessage());
        }
        return mav;
    }
}
