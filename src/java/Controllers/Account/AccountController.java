/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Account;

import repository.AccountRepository;
import Domain.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.Router;
import shared.Session;
import shared.DestinationPage;
import shared.Validator;

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
    private AccountRepository _accountRepo;
    private Account _user;
    private Validator _validate;

    AccountController(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)
    {
        _servlet = servlet;
        _request = request;
        _response = response;
        _session = new Session<AccountController>(_request);
        _router = new Router<AccountController>(_request);
        _accountRepo = new AccountRepository();
        _user = new Account();
        _validate = new Validator();
    }

    static void initHibernate(HttpServlet servlet)
    {
        Boolean createTables = Boolean.parseBoolean(servlet.getInitParameter("createTables"));
        
        if (createTables)
            repository.HibernateHelper.createTable(Domain.Account.class);

        repository.HibernateHelper.initSessionFactory(Domain.Account.class);
    }

    public void doGet()
            throws IOException, ServletException
    {   
        _request.getSession().setAttribute("user", _user);
        
        _user = (Account) _session.GetSessionData(Session.State.IGNORE, _user, "user");
        
        String page = _router.RouteDestinationPageFor(this);
        
        _request.getRequestDispatcher(page)
                .forward(_request, _response);
    }

    public void doPost()
            throws ServletException, IOException
    {
        _request.getSession().setAttribute("user", _user);
        _request.getSession().setAttribute("errors", _validate);
        
        _user = (Account) _session.GetSessionData(Session.State.READ,
                _user, "user");
        
        String page = _router.RouteDestinationPageFor(this);

        _request.getRequestDispatcher(page)
                .forward(_request, _response);
    }

    public Account getUser()
    { return _user; }
    
    @DestinationPage(isDefault = true)
    public String logIn()
    {
        if(_accountRepo.FindAccountByEmail(_user.getEmail()) == null)
            return "registration.jsp";
        
        return "index.jsp";
    }

    @DestinationPage(buttonName = "loginButton")
    public String index()
    {
        return "login.jsp";
    }
    
    @DestinationPage(buttonName = "logOut")
    public String logOut()
    {
        _request.getSession().removeAttribute("user");
        _request.getSession().invalidate();
        return "index.jsp";
    }

    @DestinationPage(buttonName = "registerationButton")
    public String register()
    {
        _session.MapDataFromRequest(_user);
        
        if(!_validate.isValid(_user) ||
                _accountRepo.FindAccountByEmail(_user.getEmail()) != null)
        {
            _user = null;
            
            return "registration.jsp";
        }
        
        _accountRepo.AddNewAccount(_user);
        
        return "index.jsp";
        
    }
    
    @DestinationPage(buttonName = "signInButton")
    public String signIn()
    {
        _session.MapDataFromRequest(_user);
        
        if(_validate.isValid(_user))
            return "success.jsp";
        
        return "error.jsp";
    }

}
