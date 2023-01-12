////////////////////////////////////////////////
//
// net.ats.hiempsal.util.CrossFilter.java is
// a java class extending OncePerRequestFilter
// 
// Method syntax:
//     void doFilterInternal(..)
////////////////////////////////////////////////
package net.ats.hiempsal.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public class CrossFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST");
		res.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-req");
		filterChain.doFilter(req, res);
	}
}
