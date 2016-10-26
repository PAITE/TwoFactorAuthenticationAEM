package com.inkriti.training.resource;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import javax.jcr.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by user on 18-10-2016.
 */

@SlingServlet(paths = "/bin/otpverify", methods = "POST", metatype = true)


public class otpverify extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        JSONObject data=new JSONObject();

        try {
            data.put("data","After verifying OTP");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        String otp=request.getParameter("otpnumber");
        response.getWriter().print(data);
        HttpSession session=request.getSession();
        if(otp.equals("1234"))
        {
            session.setAttribute("otpverified","true");
            try {
                response.sendRedirect("/bin/makepayment");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
       else{
            session.setAttribute("otpverified","false");
            try {
                response.sendRedirect("/content/otpverify.html");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }
}
