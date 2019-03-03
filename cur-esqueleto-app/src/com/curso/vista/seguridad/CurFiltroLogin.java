package com.curso.vista.seguridad;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.vista.bean.LoginMb;

/**
 * Servlet Filter implementation class CurFiltroLogin
 */
@WebFilter("/paginas/*")
public class CurFiltroLogin implements Filter {

    /**
     * Default constructor. 
     */
    public CurFiltroLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("***************************SE EJECUTO FILTRO LOGIN*********************************");
		LoginMb loginBean = (LoginMb) ((HttpServletRequest)request).getSession().getAttribute("loginMb");
		System.out.println("usuario logeado:" + loginBean);
		
		if (loginBean == null || !loginBean.isLoggedIn() ) {
			System.out.println("********************************NO SE HA REALIZADO LOGIN**********************************");
			String contextPath = ((HttpServletRequest)request).getContextPath();
			System.out.println("contextPath: " + contextPath);
			((HttpServletResponse)response).sendRedirect(contextPath + "/Login.xhtml");
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
