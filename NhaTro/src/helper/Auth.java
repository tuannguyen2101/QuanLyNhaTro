/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import model.Info;
import model.TaiKhoan;

/**
 *
 * @author Admin
 */
public class Auth {

    public static TaiKhoan user;
    public static Info info;

    public boolean isLogin() {
        return user != null;
    }

    public boolean isManager() {
        return user.isRoles() & isLogin();
    }
}
