/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Amer Delic
 */
public class Mapper
{
    public static <F,T> T MapProperties(F from, T to) throws NoSuchMethodException
    {
        try 
        {
            org.apache.commons.beanutils.BeanUtils.
                    populate(to, org.apache.commons.beanutils.BeanUtils.describe(from));
            
            return to;
        }
        catch (IllegalAccessException iae) {
            System.err.println("Populate - Illegal Access." + iae);
        }
        catch (InvocationTargetException ite) {
            System.err.println("Populate - Invocation Target." + ite);
        }
        
        return to;
    }
    
    public static void MapDataFromRequest(Object data, HttpServletRequest request)
    {
        try 
        {
            org.apache.commons.beanutils.BeanUtils.
                    populate(data, request.getParameterMap());
        }
        catch (IllegalAccessException iae) {
            System.err.println("Populate - Illegal Access." + iae);
        }
        catch (InvocationTargetException ite) {
            System.err.println("Populate - Invocation Target."+ ite);
        }
    }
}
