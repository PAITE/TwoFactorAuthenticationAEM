package com.inkriti.training.impl.filters;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.sling.SlingFilter;
import org.apache.felix.scr.annotations.sling.SlingFilterScope;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by user on 19-10-2016.
 */

@SlingFilter(generateComponent = false, generateService = true, order = 2147483647, scope = SlingFilterScope.REQUEST)
@Component(immediate = true, metatype = false)
public class authFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!(servletRequest instanceof SlingHttpServletRequest) ||
                !(servletResponse instanceof SlingHttpServletResponse)) {
            // Not a SlingHttpServletRequest/Response, so ignore.
            filterChain.doFilter(servletRequest, servletResponse); // This line would let you proceed to the rest of the filters.
            return;
        }

        final SlingHttpServletResponse slingResponse = (SlingHttpServletResponse) servletResponse;
        final SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) servletRequest;
        final Resource resource = slingRequest.getResource();

        if (resource.getPath().startsWith("/bin/makepayment")) {
            // Is the SlingFilterScope is REQUEST, redirects can be issued.


            HttpSession session=((SlingHttpServletRequest) servletRequest).getSession();

            String isAuthOne=(String)session.getAttribute("isauthone");
            String isotpverify=(String)session.getAttribute("otpverified");

            if(isAuthOne!=null)
            {

                if(isAuthOne.equals("false"))
                {
                    try {
                        slingResponse.sendRedirect("/content/sign.html");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                if(isAuthOne.equals("true"))
                {
                    if(isotpverify==null)
                    {

                        try {
                            slingResponse.sendRedirect("/content/otpverify.html");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }


                    if(isotpverify!=null)
                    {
                        if(isotpverify.equals("false"))
                        {
                            try {
                                slingResponse.sendRedirect("/content/otpverify.html");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        if(isotpverify.equals("true"))
                        {
                            slingRequest.getRequestDispatcher("/bin/makepayment").forward(slingRequest,slingResponse);

                        }

                    }
                }

            }

            else{


                try {
                    slingResponse.sendRedirect("/content/sign.html");
                } catch (IOException e) {
                    e.printStackTrace();
                }







                }



















            //Write your custom code here.



            return;
        }

        // to proceed with the rest of the Filter chain
        filterChain.doFilter(servletRequest, servletResponse);

    }


    public void destroy() {

    }
}
