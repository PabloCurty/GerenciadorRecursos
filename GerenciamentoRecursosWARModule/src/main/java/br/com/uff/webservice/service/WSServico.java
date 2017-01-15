package br.com.uff.webservice.service;
 
import java.util.HashSet;
import java.util.Set;
 
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
 
@ApplicationPath("/rs")
public class WSServico extends Application {
 
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
 
	public WSServico() {
		singletons.add(new AloMundoService());
	}
 
	public Set<Class<?>> getClasses() {
		return empty;
	}
 
	public Set<Object> getSingletons() {
		return singletons;
	}
}