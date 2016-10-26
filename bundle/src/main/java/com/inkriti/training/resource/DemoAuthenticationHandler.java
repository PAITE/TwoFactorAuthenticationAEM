package com.inkriti.training.resource;

/**
 * Created by user on 02-09-2016.
 */

import com.day.crx.security.token.TokenUtil;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.auth.core.AuthUtil;
import org.apache.sling.auth.core.spi.*;
import org.apache.sling.jcr.api.SlingRepository;

import javax.jcr.Credentials;
import javax.jcr.SimpleCredentials;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component(metatype = false,label = "Demo Authentication Handler", description = "This is Demo Authentication")
@Service(value = AuthenticationHandler.class)
@Properties({
    @Property(name = "authtype", value = "demo", propertyPrivate = true),
        @Property(name = "path", value = {"/content/signinauth"})
})
public class DemoAuthenticationHandler extends DefaultAuthenticationFeedbackHandler implements
        AuthenticationHandler,AuthenticationFeedbackHandler{

    static final String AUTH_TYPE="demo";

    public AuthenticationInfo extractCredentials(HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse) {
        if(!AuthUtil.isValidateRequest(httpServletRequest)){
            AuthUtil.setLoginResourceAttribute(httpServletRequest,httpServletRequest.getContextPath()); // Why?
        }


        SlingRepository slingRepository;
        AuthenticationInfo authenticationInfo = new AuthenticationInfo(AUTH_TYPE,httpServletRequest.getParameter("j_username"),
                httpServletRequest.getParameter("j_password").toCharArray());
        return authenticationInfo;
        /*return createAuthenticationInfo(credentials);*/
    }

    private AuthenticationInfo createAuthenticationInfo(Credentials credentials){
        AuthenticationInfo authenticationInfo=new AuthenticationInfo(AUTH_TYPE);
        authenticationInfo.put("signinauth",credentials);
        return authenticationInfo;
    }

    public boolean authenticationSucceeded(HttpServletRequest request, HttpServletResponse response,
                                           AuthenticationInfo authInfo) {
        HttpSession session=request.getSession();
        session.setAttribute("isauthone","true");

        try {
            response.sendRedirect("/content/gateway.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void authenticationFailed(HttpServletRequest request, HttpServletResponse response,
                                     AuthenticationInfo authInfo) {
        HttpSession session=request.getSession();
        session.setAttribute("isauthone","false");

        try {
            response.sendRedirect("/content/sign.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean requestCredentials(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        return false;
    }

    public void dropCredentials(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

    }
}