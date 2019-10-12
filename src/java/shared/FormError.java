/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import org.hibernate.validator.engine.PathImpl;

/**
 *
 * @author Amer Delic
 */
public class FormError
{
    private Map<String, String> _errorMap = new HashMap<String, String>();
    private static final javax.validation.Validator _VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public Map getErrors()
    { return _errorMap; }

    public void clearErrors()
    {
        if (_errorMap != null)
            _errorMap.clear();
    }
    
    public void addErrors(String errorType, String errorMessage)
    {
        _errorMap.put(errorType, errorMessage);
    }

    public boolean isValidObject(Object sessionObject)
    {
        findErrorsIn(sessionObject); //Sets errors

        if (_errorMap.isEmpty()) // Tests if there is any errors
            return true;

        return false;
    }

    private void findErrorsIn(Object sessionObject)
    {
        Set<ConstraintViolation<Object>> errors = _VALIDATOR.validate(sessionObject); //Check for errors in attributes of object "data"

        _errorMap.clear();

        //Violations are put in map so they can be accessed with JSP's
        //JSP's can only access Maps, no other enumerable data type will work
        if (!errors.isEmpty())
            for (ConstraintViolation<Object> propertyWithErrors : errors) 
            {
                PathImpl pathToProperty = (PathImpl) propertyWithErrors.getPropertyPath(); //Get path of property that was violated
                // this path is split into (property.errorMessage) into the map in the next line.
                
                String PropertyName = (String) pathToProperty.getLeafNode().getName();
                
                _errorMap.put(PropertyName, propertyWithErrors.getMessage());//Get name of property (i.e. hobby, aversion, ect.). get message from annotation above property
            }
    }
}
