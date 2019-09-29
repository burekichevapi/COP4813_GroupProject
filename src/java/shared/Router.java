/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Amer Delic
 */
public class Router
{

    private HttpServletRequest _request;
    private final String _errorPage = "error.jsp";

    public Router(HttpServletRequest request)
    {
        _request = request;
    }

    public String GetPage(Class controller)
    {
        Method[] methods = controller.getDeclaredMethods();
        
        for (Method method : methods) 
        {    
            ButtonMethod annotation = method.getAnnotation(ButtonMethod.class);
            
            if (annotation != null) 
                if (_request.getParameter(annotation.buttonName()) != null)
                        try {
                            return invokeButtonMethod(method);
            }
            catch (IllegalAccessException | InvocationTargetException ex) {
                System.err.println("Button Method Error." + ex);
                return _errorPage;
            }
        }
        
        return _errorPage;
    }

    private String invokeButtonMethod(Method buttonMethod)
            throws IllegalAccessException, InvocationTargetException
    {
        String resultInvoke = "Could not invoke method";
        try {
            resultInvoke = (String) buttonMethod.invoke(null);
        }
        catch (IllegalAccessException ex) {
            System.err.println("(invoke) Button method is not public." + ex);
            throw ex;
        }
        catch (InvocationTargetException ex) {
            System.err.println("(invoke) Button method exception" + ex);
            throw ex;
        }
        return resultInvoke;
    }
}
