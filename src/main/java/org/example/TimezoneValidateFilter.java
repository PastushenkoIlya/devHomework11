package org.example;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.TimeZone;

@WebFilter("/improvedTime")
public class TimezoneValidateFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String timezoneInput = request.getParameter("timezone");
        if(Arrays.asList(TimeZone.getAvailableIDs()).contains(timezoneInput)) {
            chain.doFilter(request, response);
        }
        else{
            response.setStatus(400);
            response.setContentType("text/html");
            response.getWriter().write("Invalid timezone");
            response.getWriter().close();
        }
    }
}
