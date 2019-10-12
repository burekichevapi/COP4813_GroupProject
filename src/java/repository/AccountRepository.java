/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import Domain.Account;
import java.util.List;

/**
 *
 * @author Amer Delic
 */
public class AccountRepository
{

    public Account FindAccountByEmail(String email)
    {
        List<Account> usersInDB = HibernateHelper.getListData(Account.class);

        for (Account user : usersInDB) {
            if (IsFoundBy(email, user.getEmail()))
                return user;
        }

        return null;
    }
    
    public Account FindAccountByUserName(String userName)
    {
        List<Account> usersInDB = HibernateHelper.getListData(Account.class);

        for (Account user : usersInDB) {
            if (IsFoundBy(userName, user.getUserName()))
                return user;
        }

        return null;
    }

    public boolean isValidPassword(String email, String password)
    {
        List<Account> usersInDB = HibernateHelper.getListData(Account.class);

        for (Account user : usersInDB) {
            if (IsFoundBy(email, user.getEmail()) &&
                    IsFoundBy(password, user.getPassword()))
                return true;
        }

        return false;
    }

    public void AddNewAccount(Account account)
    {
        HibernateHelper.updateDB(account);
    }
    
    public void UpdateUser(Account account)
    {
        HibernateHelper.updateDB(account);
    }

    private boolean IsFoundBy(String lookingFor, String item)
    {
        return lookingFor.compareToIgnoreCase(item) == 0;
    }
}
