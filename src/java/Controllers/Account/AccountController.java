/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Account;

import Domain.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.ButtonMethod;
import shared.Router;
import shared.Session;

/**
 *
 * @author Amer Delic
 */
public class AccountController
{
    private HttpServlet _servlet;
    private HttpServletRequest _request;
    private HttpServletResponse _response;
    private Session<AccountController> _session;
    private Router<AccountController> _router;
    private AccountContext _accountContext;
    private User _user;

    AccountController(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)
    {
        _servlet = servlet;
        _request = request;
        _response = response;
        _session = new Session<AccountController>(_request);
        _router = new Router<AccountController>(_request);
        _accountContext = new AccountContext();
        _user = new User();
    }

    static void initHibernate(HttpServlet servlet)
    {
        Boolean createTables = Boolean.parseBoolean(servlet.getInitParameter("createTables"));

        if (createTables) {
            hibernate.HibernateHelper.createTable(Domain.User.class);
        }

        hibernate.HibernateHelper.initSessionFactory(Domain.User.class);
    }

    public void doGet()
            throws IOException, ServletException
    {   
        _request.getSession().setAttribute("user", _user);
        
        String page = _router.GetPageFor(this);

        _request.getRequestDispatcher(jspAddress(page))
                .forward(_request, _response);
    }

    public void doPost()
            throws ServletException, IOException
    {
        _user = (User) _session.getSessionData(Session.State.READ, _user,
                "user");
        
        String page = _router.GetPageFor(this);
        
        _request.getSession().setAttribute("user", _user);

        _request.getRequestDispatcher(jspAddress(page))
                .forward(_request, _response);
    }

    public User getUser()
    { return _user; }

    @ButtonMethod(buttonName = "loginButton", isDefault = true)
    public String logIn()
    {
        return "login.jsp";
    }

    @ButtonMethod(buttonName = "registerationButton")
    public String Register()
    {
        return "registration.jsp";
    }
    
    @ButtonMethod(buttonName = "signInButton")
    public String signIn()
    {
        _session.MapDataFromRequest(_user);
        
        return "success.jsp";
    }

    private String jspAddress(String page)
    {
        return "/WEB-INF/classes/Controllers/Account/" + page;
    }
    

}
