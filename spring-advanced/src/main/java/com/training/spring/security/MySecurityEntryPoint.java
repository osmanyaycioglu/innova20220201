package com.training.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.spring.web.error.ErrorObj;

@Component
public class MySecurityEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(final HttpServletRequest requestParam,
                         final HttpServletResponse responseParam,
                         final AuthenticationException authExceptionParam) throws IOException, ServletException {
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setCause(23001);
        errorObjLoc.setMessage(authExceptionParam.getMessage());

        ObjectMapper mapperLoc = new ObjectMapper();
        responseParam.setHeader("Content-Type",
                                "application/json");
        byte[] writeValueAsBytesLoc = mapperLoc.writeValueAsBytes(errorObjLoc);
        responseParam.getOutputStream()
                     .write(writeValueAsBytesLoc);

    }

}
