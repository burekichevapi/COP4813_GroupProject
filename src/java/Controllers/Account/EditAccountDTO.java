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
    private String _currentPassword;
    private String _newPassword;
    private String _confirmNewPassword;
    private String _email;
    
    public String getConfirmNewPassword()
    { return _confirmNewPassword; }

    public void setConfirmNewPassword(String confirmNewPassword)
    { _confirmNewPassword = confirmNewPassword; }

    public String getCurrentPassword()
    { return _currentPassword; }

    public void setCurrentPassword(String currentPassword)
    { _currentPassword = currentPassword; }

    @NotNull(message = "Can't be empty")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{6,15}",
            message = "Must be between 6 and 15 characters, with atleast 1 numeric, 1 lowercase,"
                    + "1 uppercase, and 1 special character.")   
    public String getNewPassword()
    { return _newPassword; }

    public void setNewPassword(String newPassword)
    { _newPassword = newPassword; }
    
    public String getEmail()
    {return _email;}
    
    public void setEmail(String email)
    {_email = email;}
    
    public boolean confirmedNewPassword()
    {
        return _newPassword.compareTo(_confirmNewPassword) == 0;
    }
}
