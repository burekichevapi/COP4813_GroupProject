/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import Domain.Account;
import hibernate.HibernateHelper;
import java.util.List;

/**
 *
 * @author Amer Delic
 */
public class AccountRepository
{
    public Account FindUserByEmail(String email)
    {
        List<Account> usersInDB = HibernateHelper.getListData(Account.class);

        for (Account user : usersInDB) {
            if (IsFoundBy(email, user.getEmail())) {
                return user;
            }
        }

        return null;
    }

    private boolean IsFoundBy(String value, String value2)
    {
        return value.compareToIgnoreCase(value2) == 0;
    }
}
