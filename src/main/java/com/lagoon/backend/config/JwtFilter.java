package com.lagoon.backend.config;


import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MahfuzCSE'11 on 30-Sep-16.
 */

public class JwtFilter extends GenericFilterBean {


    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            //chain.doFilter(req, res);

        } else {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {

                throw new ServletException("Missing or Invalid Authorization Header");
            }

            /******************First 7 character has been romoved ("Bearer")************************/
            final String token = authHeader.substring(7);


            try {
                /******Claims has been added in new version old version does not have this claims feature  *****/
                final Claims claims = Jwts.parser().setSigningKey("bcbjdcbhhbcvnbvcbnfvnbsdhjhjdsjkdsjksdmdxncxcjxhcxhhfdhbndsbnsdghsaghsbedghdsghdsgvdsvbdsbv bvcx ghcx").parseClaimsJws(token).getBody();
                request.setAttribute("claims", claims);

            } catch (final SignatureException e) {
                throw new ServletException("Invalid Token");
            }

            chain.doFilter(req, res);
        }


    }


}
