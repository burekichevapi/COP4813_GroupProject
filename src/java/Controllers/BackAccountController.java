/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amer Delic
 */
public class BackAccountController
{

    private HttpServlet _servlet;
    private HttpServletRequest _request;
    private HttpServletResponse _response;

    BackAccountController(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)
    {
        _servlet = servlet;
        _request = request;
        _response = response;
    }

    static void initHibernate(HttpServlet servlet)
    {
        Boolean createTables = Boolean.parseBoolean(servlet.getInitParameter("createTables"));

        if (createTables) 
            hibernate.HibernateHelper.createTable(Domain.User.class);

        hibernate.HibernateHelper.initSessionFactory(Domain.User.class);
    }

    public void doGet()
            throws IOException, ServletException
    {
        _request.getRequestDispatcher("/WEB-INF/classes/Controllers/success.jsp").forward(_request, _response);
    }

    public void doPost()
            throws ServletException, IOException
    {
        _request.getRequestDispatcher("/WEB-INF/classes/Controllers/success.jsp").forward(_request, _response);
    }

}
