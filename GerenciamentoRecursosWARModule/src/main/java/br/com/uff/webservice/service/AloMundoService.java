package br.com.uff.webservice.service;
 
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.CommonsEJB.AlocacaoBean;
import org.CommonsEJB.model.Alocacao;
 
@RequestScoped
@Path("/aloMundo")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class AloMundoService {
	
	@Inject
	private AlocacaoBean alocacaoBean;
 
	@GET
	@Path("/mensagem/{nome}")	
	public String criarMensagem(@PathParam("nome") String nome) {
		return "Ola " + nome + " seja bem vinda!" + System.currentTimeMillis();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lista/{data}")
	public List<Alocacao> getLista(@PathParam("data") String data){
		
		//TODO tratar data
		
		//Date date = new Date();
		
		List<Alocacao> lista =  alocacaoBean.buscaTodasAlocacoes();
		
		return lista;
		
	}
}