/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.ButtonMethod;
import shared.Router;

/**
 *
 * @author Amer Delic
 */
public class AccountController
{

    private HttpServlet _servlet;
    private HttpServletRequest _request;
    private HttpServletResponse _response;
    private Router _router;

    AccountController(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)
    {
        _servlet = servlet;
        _request = request;
        _response = response;
        _router = new Router(_request);
    }

    static void initHibernate(HttpServlet servlet)
    {
        Boolean createTables = Boolean.parseBoolean(servlet.getInitParameter("createTables"));

        if (createTables) 
            hibernate.HibernateHelper.createTable(Domain.User.class);

        hibernate.HibernateHelper.initSessionFactory(Domain.User.class);
    }
    
    public String JSPPath(String page)
    { return "/WEB-INF/classes/Controllers/Account/" + page; }
    
    @ButtonMethod(buttonName="signInButton", isDefault = true)
    public static String signIn()
    {return "login.jsp";}
    
    @ButtonMethod(buttonName="registerationButton")
    public static String Register()
    {return "registration.jsp";}

    public void doGet()
            throws IOException, ServletException
    {
        String page = _router.GetPage(AccountController.class);
        String address = JSPPath(page);
        
        
        _request.getRequestDispatcher(address).forward(_request, _response);
    }

    public void doPost()
            throws ServletException, IOException
    {
        String page = _router.GetPage(AccountController.class);
        String address = JSPPath(page);
        
        
        _request.getRequestDispatcher(address).forward(_request, _response);
    }

}
