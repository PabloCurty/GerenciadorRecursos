package br.com.uff.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.CommonsEJB.EmprestimoBean;

@ManagedBean(name="emprestimoBeanView")
@SessionScoped
public class EmprestimoView {
	
	//essa classe ira concentrar tudo relaciona a emprestimo/devolucao de chave e equipamento
	//melhor do que ficar criando um bean e uma view para cada
	
	@EJB
	private EmprestimoBean emprestimoBean;
	
	
	public void prepararCadastro(){
		System.out.println("Preparar cadastro");
	}

	public void cadastrar(){
		System.out.println("Cadastrar");
	}

}