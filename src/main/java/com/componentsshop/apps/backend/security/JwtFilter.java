package com.componentsshop.apps.backend.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.componentsshop.apps.backend.security.model.UserDetailsAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import contexts.shared.auth.infrastructure.TokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final UserDetailsLoader loader;
    private final TokenProvider provider;

    JwtFilter(TokenProvider provider, UserDetailsLoader loader) {
        this.provider = provider;
        this.loader = loader;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            try {
                String email = this.provider.decodeJWT(token);
                UserDetailsAdapter userDetailsAdapter = (UserDetailsAdapter) this.loader.loadUserByUsername(email);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetailsAdapter, null, userDetailsAdapter.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);

                filterChain.doFilter(request, response);
            } catch (SignatureVerificationException | TokenExpiredException | JWTDecodeException e) {
                HashMap<Object, Object> model = new HashMap<>();
                model.put("message", "Invalid Token");

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write(new ObjectMapper().writeValueAsString(model));
            }
        }
    }
}
