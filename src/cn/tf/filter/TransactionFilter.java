package cn.tf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;

import cn.tf.utils.H3Utils;

public class TransactionFilter  implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		try {
			//开启事务
			H3Utils.getCurrentSession().beginTransaction();
			
			chain.doFilter(request, response);
			
			H3Utils.getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			H3Utils.getCurrentSession().getTransaction().rollback();
		}
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
