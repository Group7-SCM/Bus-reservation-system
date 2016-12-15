/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.reservation;

/**
 *
 * @author Najihah64
 */

public class Login {
    private String username;
    private String password;
    private String[][] accounts = {{"najihah", "12345"},{"ily", "54321"}};

    public Login (String username, String password) 
    {
        this.username = username;
        this.password = password;
        boolean active;
    }

    public boolean checkPassword()
    {

        if((username.equals(accounts[0][0])) && (password.equals(accounts[0][1])))
            return true;
        else
            return false;
        //im understanding
    }

    public void deactivateAccount()
    {
        boolean active = false;
    }
}
		




