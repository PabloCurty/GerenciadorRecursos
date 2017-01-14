package br.com.uff.web.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.uff.web.util.UrlHelper;

public class SessaoExpiradaFilter implements Filter {

	private static final String AJAX_REDIRECT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<partial-response><redirect url=\"%s\"></redirect></partial-response>";

	public SessaoExpiradaFilter() {
		super();
	}

	@Override
	public void destroy() {
		// nothing to do

	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// nothing to do

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String contextPath = httpRequest.getContextPath();
		String showcaseHomeUrl = contextPath + "/login.xhtml";
		if (httpRequest.getSession(false) == null) {
			tratarSessaoInvalida(httpRequest, httpResponse, showcaseHomeUrl);
			return;
		}

		chain.doFilter(request, response);

	}

	
	/**
	 * Trata a requisição para uma sessão invalida, executando o
	 * redirecionamento para página de inicial do ShowCase.
	 * O redirecionamento é feito de formas diferentes de acordo com o tipo de
	 * requisição: comum ou ajax.
	 *
	 * @param httpRequest Requisição HTTP
	 * @param httpResponse Resposta HTTP
	 * @param showcaseHomeUrl Url da página de login
	 * @throws IOException
	 */
	private void tratarSessaoInvalida(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse, String showcaseHomeUrl)
			throws IOException	 {

		adicionaUrlRequisitadaNaSessao(httpRequest, showcaseHomeUrl);
		
		if ("partial/ajax".equals(httpRequest.getHeader("Faces-Request"))) {
			httpResponse.setContentType("text/xml");
			httpResponse.setCharacterEncoding("UTF-8");
			httpResponse.getWriter().printf(AJAX_REDIRECT_XML, showcaseHomeUrl);
		} else {
			httpResponse.sendRedirect(showcaseHomeUrl);
		}
	}

	/**
	 * Cria sessão caso não haja nenhuma ativa no momento. Caso a sessão ainda não contenha o atributo oldUrl (armazena 
	 * url que usuário será redirecionado após o login) ele adiciona esse atributo com seu devido valor resgatado do HttpRequest
	 * para que logo após a autenticação o usuário retorne para onde estava no sistema.

	 * @param httpRequest Requisição HTTP
	 * @param showcaseHomeUrl Url da página de login
	 */
	private void adicionaUrlRequisitadaNaSessao(HttpServletRequest httpRequest, String showcaseHomeUrl) {
		HttpSession session = httpRequest.getSession(true);
		if(!showcaseHomeUrl.equals(httpRequest.getRequestURI()) && session.getAttribute("oldUrl") == null){
			String queryString = httpRequest.getQueryString();
			if(queryString == null || queryString.isEmpty()){
				queryString = "faces-redirect=true";
			}else if(!queryString.contains("faces-redirect=true")){
				queryString += "&faces-redirect=true";
			}
			String oldUrl = httpRequest.getServletPath() + "?" + queryString;
			session.setAttribute("oldUrl", UrlHelper.removeDswidDaUrl(oldUrl));
		}
	}
}
