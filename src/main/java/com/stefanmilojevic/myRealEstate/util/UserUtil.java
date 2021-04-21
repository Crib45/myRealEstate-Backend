package com.stefanmilojevic.myRealEstate.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

public class UserUtil {

    /**
     * Returns email of logged in user from HttpServletRequest
     * @param request HttpServletRequest
     * @return email as String type
     */
    public static String getEmailFromRequest(HttpServletRequest request){
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        String email = new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
        return email;
    }
}
