package br.com.uff.webservice.service;
 
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.CommonsEJB.AlocacaoBean;
 
@Path("/aloMundo")
@Produces("application/json")
public class AloMundoService {
	
	@EJB
	private AlocacaoBean alocacaoBean;
 
	@GET
	@Path("/mensagem/{nome}")	
	public String criarMensagem(@PathParam("nome") String nome) {
		return "Ola " + nome + " seja bem vinda!" + System.currentTimeMillis();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lista/{data}")
	public List<Object> getLista(@PathParam("data") String data){
		
		//TODO tratar data
		
		Date date = new Date();
		
		//List<Object> lista = (List<Object>) alocacaoBean.buscaTodasAlocacoes(date);
		
		return null;
		
	}
}