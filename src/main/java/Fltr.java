

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/Fltr")
public class Fltr implements Filter {

    /**
     * Default constructor. 
     */
    public Fltr() {
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
		HttpServletRequest req =(HttpServletRequest) request; 
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("######");
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache");
        res.setDateHeader("Expires", 0L);
        System.out.println("filter1");
		
		HttpSession session = req.getSession(false);
		String uri = req.getRequestURI();
		System.out.println("URL:"+uri);
		System.out.println("session:"+session);
		
		if (uri.endsWith("/Register.html")){
			System.out.println("Register.html");
			RequestDispatcher z = request.getRequestDispatcher("/Register.html");
			z.forward(request, response);
			chain.doFilter(request, response);
		}
		if (uri.endsWith("/Register")){
			System.out.println("Register");
			RequestDispatcher z = request.getRequestDispatcher("/Register");
			z.forward(request, response);
			chain.doFilter(request, response);
		}
		if (uri.endsWith("/Failed")){
			System.out.println("logout");
			RequestDispatcher z = request.getRequestDispatcher("/index.html");
			z.forward(request, response);
			chain.doFilter(request, response);
		if (uri.endsWith("/admin.jsp")){
	            if (session != null) {
	        		System.out.println("isLoginActionSucceed:"+isLoginActionSucceed(session));

	                if (isLoginActionSucceed(session)) {
	                    res.sendRedirect(req.getContextPath() + "/admin.jsp");
	                    return;
	                }else {
	                	System.out.println("inside else");
	                }
	            }
	        } else {
	           
	            if (session == null) {
	            	System.out.println("session == null");
//	            	if (!isLoginActionSucceed(session)) {
	                    res.sendRedirect(req.getContextPath() + "/fail.html");
	                    return;
//	                }
	            	
	            }else
	            	if (session != null) {
	        		System.out.println("isLoginActionSucceed:"+isLoginActionSucceed(session));
	        		System.out.println("session != null");
	                if (!isLoginActionSucceed(session)) {
	                    res.sendRedirect(req.getContextPath() + "/index.html");
	                    return;
	                }
	            }
	        }
		}
		if (uri.endsWith("/index.html") || uri.endsWith("/Serv")) {
            if (session != null) {
        		System.out.println("isLoginActionSucceed:"+isLoginActionSucceed(session));

                if (isLoginActionSucceed(session)) {
                    res.sendRedirect(req.getContextPath() + "/Welcome");
                    return;
                }else {
                	System.out.println("inside else");
                }
            }
        } else {
           
            if (session == null) {
            	System.out.println("session == null");
//            	if (!isLoginActionSucceed(session)) {
                    res.sendRedirect(req.getContextPath() + "/index.html");
                    return;
//                }
            	
            }else
            	if (session != null) {
        		System.out.println("isLoginActionSucceed:"+isLoginActionSucceed(session));
        		System.out.println("session != null");
                if (!isLoginActionSucceed(session)) {
                    res.sendRedirect(req.getContextPath() + "/index.html");
                    return;
                }
            }
        }
		

        chain.doFilter(request, response);
	}
		
		
//		Person pers= (Person)req.getSession().getAttribute("per");
//		if(pers == null) {
//			res.sendRedirect("fail.html");
//		}
//

	 private boolean isLoginActionSucceed(HttpSession session){
	        
	        Person pers= (Person) session.getAttribute("per");
	        System.out.println(pers);
	        if(pers == null) {
	        	return false;
			}
	        return true;
	    }
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
