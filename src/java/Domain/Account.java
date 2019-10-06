/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Amer Delic
 */
@Entity
public class Account
{
    private Long _id;
    private String _userName;
    private String _password;
    private String _email;
    
    @Id
    @GeneratedValue
    public Long getId()
    {return _id;}
    
    public void setId(long id)
    {_id = id;}
    
    @NotNull(message = "Can't be empty")
    @Email
    public String getEmail()
    {return _email;}
    
    public void setEmail(String email)
    {_email = email;}
    
    
    @NotNull(message = "Can't be empty")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{6,15}", 
            message = "Must be between 6 and 15 characters, with atleast 1 numeric, 1 lowercase,"
                    + "1 uppercase, and 1 special character.")    
    public String getPassword()
    {return _password;}
    
    public void setPassword(String password)
    {_password = password;}
    
    @NotNull(message = "Can't be empty")
    @Pattern(regexp = "\\w{4,12}", message = "Alphanumeric characters and underscores only")    
    public String getUserName()
    {return _userName;}
    
    public void setUserName(String userName)
    {_userName = userName;}
}
