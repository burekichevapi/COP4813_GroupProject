/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Amer Delic
 */
@Entity
public class User
{
    private Long _id;
    private String _userName;
    private String _password;
    private String _email;
    private Date _birthdate;
    private String _aboutMe;
    
    @Id
    @GeneratedValue
    public Long getId()
    {return _id;}
    
    public void setId(long id)
    {_id = id;}
    
    
    
}
