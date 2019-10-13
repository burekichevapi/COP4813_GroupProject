/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Account;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Amer Delic
 */
public class EditAccountDTO
{
    private String _oldPassword;
    private String _password;
    private String _confirmNewPassword;
    private String _email;
    private String _aboutMe;
    
    public String getConfirmedNewPassword()
    { return _confirmNewPassword; }

    public void setConfirmNewPassword(String confirmNewPassword)
    { _confirmNewPassword = confirmNewPassword; }

    public String getOldPassword()
    { return _oldPassword; }

    public void setOldPassword(String currentPassword)
    { _oldPassword = currentPassword; }
    
    @NotNull(message = "Can't be empty")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{6,15}", 
            message = "Must be between 6 and 15 characters, with atleast 1 numeric, 1 lowercase,"
                    + "1 uppercase, and 1 special character.")    
    public String getPassword()
    { return _password; }

    public void setPassword(String newPassword)
    { _password = newPassword; }
    
    public String getEmail()
    { return _email; }
    
    public void setEmail(String email)
    { _email = email; }
    
    public void setAboutMe(String aboutMe)
    {_aboutMe = aboutMe;}
    
    public String getAboutMe()
    {return _aboutMe;}
    
    public boolean confirmedNewPassword()
    {
        return _password.compareTo(_confirmNewPassword) == 0;
    }
}
