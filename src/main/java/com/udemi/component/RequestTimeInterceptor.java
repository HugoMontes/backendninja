package com.udemi.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	
	// Primero: se ejecuta antes de entrar al metodo del controlador
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Antes que se ejecute el controlador guardara el tiempo actual en milisegundos
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	// Segundo: se ejecuta antes de salir del metodo del controlador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// Obtener el atributo de la request seteado en el aterior metodo
		long startTime=(long)request.getAttribute("startTime");
		// Mostrar la url y el tiempo de demora de la peticion TiempoActual-TiempoInicial
		LOG.info("--REQUEST URL: "+request.getRequestURL().toString()+
				 " --TOTAL TIME: "+(System.currentTimeMillis()-startTime)+" ms");
	}
}
