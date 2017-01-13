package org.CommonsEJB.DAO.Impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.CommonsEJB.model.Perfil;
import org.CommonsEJB.model.Usuario;

public class PerfilDAO extends AbstractDAO<Perfil> implements Serializable {

	private static final long serialVersionUID = -7745067260158136209L;
	
	
	public Perfil buscaPerfilPorNome(String nome){
		
		Query query = em.createQuery("select p from Perfil as p where p.nome_perfil = :nome");
		query.setParameter("nome", nome);
		@SuppressWarnings("unchecked")
		List<Perfil> perfis = query.getResultList();
		Perfil perf = new Perfil();
		for (Perfil perfil : perfis) {
			if(perfil.getNome_perfil().equalsIgnoreCase(nome)){
				perf = perfil;
				break;
			}
		}
		return perf;
	}
	

}
