package com.student;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.service.StudentService;

@Component
public class AuthFilter implements Filter {
	@Autowired
	StudentService stu;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(req.getRequestURI());
        if(req.getRequestURI().contains("/api/v1/students/")){
        if (req.getHeader("auth-token") != null ){
        	if(stu.checkSession(req.getHeader("auth-token"))) {
                chain.doFilter(request, response);

        	}
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.setStatus(401);
        }
        }else {
        	
            System.out.println("else");
        	 chain.doFilter(request, response);
        }
    }
}
