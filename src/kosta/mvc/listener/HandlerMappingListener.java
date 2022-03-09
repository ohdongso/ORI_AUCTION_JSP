package kosta.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.mvc.controller.Controller;

@WebListener
public class HandlerMappingListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext application =  sce.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	
    	Map<String, Controller> map = new HashMap<String, Controller>();
    	Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>();
    	
    	ResourceBundle rb = ResourceBundle.getBundle(fileName);
    	try {
    		for(String key :rb.keySet()) {
    			String value = rb.getString(key);
    			
    			Class<?> className = Class.forName(value);
    			Controller controller = (Controller)(className.getDeclaredConstructor().newInstance());
    			
    			System.out.println(key+", "+value+", "+controller);
    			
    			map.put(key, controller);
    			clzMap.put(key, className);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	
    	application.setAttribute("map", map);
    	application.setAttribute("clzMap", clzMap);
    	
    	application.setAttribute("path", application.getContextPath());
    }
}
