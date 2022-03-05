package chap08.after.auth.dto;

import chap08.after.auth.model.Customer;

public class LoginResult {
    private boolean success;
    private int resp;

    public LoginResult(boolean success, int resp) {
        this.success = success;
        this.resp = resp;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getResp() {
        return resp;
    }

    public static LoginResult fail(int resp) {
        return new LoginResult(false, resp);
    }

    public static LoginResult success() {
        return new LoginResult(true, 0);
    }
    
    public static LoginResult badAuthKey() {
        return new LoginResult(false, -1);
    }
    
    public static LoginResult authenticated(Customer c) {
        return new LoginResult(false, -2);
    }
}
