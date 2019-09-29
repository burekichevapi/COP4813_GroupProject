/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Account;

import Domain.User;
import hibernate.HibernateHelper;
import java.util.List;

/**
 *
 * @author Amer Delic
 */
public class AccountContext
{
    public User FindUserByEmail(String email)
    {
        List<User> usersInDB = HibernateHelper.getListData(User.class);

        for (User user : usersInDB) {
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
