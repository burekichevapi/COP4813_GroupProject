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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.Router;
import shared.Session;
import shared.DestinationPage;
import shared.FormError;
import shared.Mapper;

/**
 *
 * @author Amer Delic
 */
public class AccountController
{
    private HttpServlet _servlet;
    private HttpServletRequest _request;
    private HttpServletResponse _response;
    private Session _session;
    private Router<AccountController> _router;
    private AccountRepository _accountRepo;
    private Account _account;
    private FormError _formErrors;
    private Cookie _userEmailCookie;
    private Cookie _userPassword;

    AccountController(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)
    {
        _servlet = servlet;
        _request = request;
        _response = response;
        _session = new Session(_request);
        _router = new Router<AccountController>(_request);
        _accountRepo = new AccountRepository();
        _account = new Account();
        _formErrors = new FormError();
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
        _formErrors.clearErrors();
        
        _session.addToSession("user", _account);
        
        String page = _router.RouteDestinationPageFor(this);
        
        if(_userEmailCookie != null)
        {
            _session.addToSession("userEmailCookie", _userEmailCookie);
            _session.addToSession("userPasswordCookie", _userPassword);            
        }
        
        _request.getRequestDispatcher(page).forward(_request, _response);
    }
 
    public void doPost()
            throws ServletException, IOException
    {
        _formErrors.clearErrors();

        String page = _router.RouteDestinationPageFor(this);
        
        _session.addToSession("user", _account);
        _session.addToSession("errors", _formErrors);
        
        if(_userEmailCookie != null)
        {
            _session.addToSession("userEmailCookie", _userEmailCookie);
            _session.addToSession("userPasswordCookie", _userPassword);            
        }
        
        _request.getRequestDispatcher(page).forward(_request, _response);
    }
    
    @DestinationPage(buttonName = "loginButton")
    public String logIn()
    {        
        _session.MapDataFromRequest(_account);
        
        if(_accountRepo.isValidPassword(_account.getEmail(), _account.getPassword()))
        {
            _account = _accountRepo.FindAccountByEmail(_account.getEmail());
            
            setLoginCookies(_account.getEmail(), _account.getPassword());
            
            return "index.jsp";
        }
        
        _account = null;
        _formErrors.addErrors("invalidCredentials", "Invalid login, please try again.");
        
        return "login.jsp";
    
    }
    
    @DestinationPage(buttonName = "registerationButton")
    public String register()
    {
        _session.MapDataFromRequest(_account);
        
        if(!_formErrors.isValidObject(_account))
        {
            _request.getSession().invalidate();
            _account = null;
            
            return "registration.jsp";
        }
        if(_accountRepo.FindAccountByEmail(_account.getEmail()) != null
                || _accountRepo.FindAccountByUserName(_account.getUserName()) != null)
        {
            _formErrors.addErrors("invalidRegistration", "This Email or User Name already"
                    + "exists, try logging in.");
            
            _request.getSession().invalidate();
            _account = null;
            
            return "registration.jsp";
        }
        
        _accountRepo.AddNewAccount(_account);
        
        setLoginCookies(_account.getEmail(), _account.getPassword());
        
        return "index.jsp";
        
    }
    
    @DestinationPage(buttonName = "logOutButton")
    public String logOut()
    {
        _account = (Account)_request.getSession().getAttribute("user");
        
        _request.getSession().invalidate();
        setLoginCookies(_account.getEmail(), _account.getPassword());
        return "index.jsp";
    }
    
    @DestinationPage(buttonName = "editAccountButton")
    public String editAccount()
    {
        Mapper.MapDataFromRequest(_account, _request);
        
        return "editAccountPage.jsp";
    }
    @DestinationPage(buttonName = "updateAboutMeButton")
    public String updateAboutMe()
    {
        EditAccountDTO editAccountDTO = new EditAccountDTO();
        Mapper.MapDataFromRequest(editAccountDTO, _request);
        
        _account = _accountRepo.FindAccountByEmail(editAccountDTO.getEmail());
        
        _account.setAboutMe(editAccountDTO.getAboutMe());
        _accountRepo.UpdateUser(_account);
        _request.getSession().setAttribute("user", _account);
        
        return "editAccountPage.jsp";
    }
    
    @DestinationPage(buttonName = "changePasswordButton")
    public String changePassword() throws NoSuchMethodException
    {
        EditAccountDTO editAccountDTO = new EditAccountDTO();
        Mapper.MapDataFromRequest(editAccountDTO, _request);        
        
        if(!_formErrors.isValidObject(editAccountDTO))
        {
            _request.getSession().setAttribute("errors", _formErrors);

            return "editAccountPage.jsp";
        }
        
        _account = _accountRepo.FindAccountByEmail(editAccountDTO.getEmail());
        
        if(!_account.passwordMatchs(editAccountDTO.getOldPassword()))
        {
            _formErrors.addErrors("wrongPassword", "Incorrect Password.");
            
            _request.getSession().setAttribute("errors", _formErrors);
        }
        else if(!editAccountDTO.confirmedNewPassword())
        {
            _formErrors.addErrors("passwordsNotEqual", "Passwords don't match.");
            
            _request.getSession().setAttribute("errors", _formErrors);
        }
        else
        {
            _account.setPassword(editAccountDTO.getConfirmedNewPassword());
            _accountRepo.UpdateUser(_account);
            setLoginCookies(_account.getEmail(), _account.getPassword());
        }
        
        _request.getSession().setAttribute("user", _account);
        
        return "editAccountPage.jsp";
    }
    
    @DestinationPage(isDefault = true)
    public String index()
    {
        return "login.jsp";
    }
    
    private void setLoginCookies(String userEmail, String userPassword)
    {
        _userEmailCookie = new Cookie("userEmail", userEmail);
        _userPassword = new Cookie("userPassword", userPassword);
            
        _userEmailCookie.setMaxAge(-1); //Persist until Brower Shutdown
        _userEmailCookie.setSecure(true);
        _userPassword.setMaxAge(-1); //Persist until Brower Shutdown
        _userPassword.setSecure(true);
            
        _response.addCookie(_userEmailCookie);
        _response.addCookie(_userPassword);
    }
    

}
