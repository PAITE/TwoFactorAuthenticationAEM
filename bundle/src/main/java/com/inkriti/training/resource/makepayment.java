package com.inkriti.training.resource;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by user on 18-10-2016.
 */

@SlingServlet(paths = "/bin/makepayment", methods = "POST", metatype = true)


public class makepayment extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();


        JSONObject data=new JSONObject();

        try {
            data.put("data","transaction successfull");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.getWriter().print(data);
        session.invalidate();




    }
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();


        JSONObject data=new JSONObject();

        try {
            data.put("data","transaction successfull");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.getWriter().print(data);
        session.invalidate();



    }
}
