package br.com.uff.web.util;

/**
 * Classe com funcionalidades que auxiliam manipulação de uma URL
 */
public class UrlHelper {

	/**
	 * Construtor privado
	 */
	private UrlHelper(){
		super();
	}
	
	/**
	 * Expressão regular que remove o dswid=xxxx da url passada
	 * @param oldUrl url que terá o parâmetro removido
	 * @return url sem o dswid
	 */
	public static String removeDswidDaUrl(String oldUrl) {
		String regex = "(&dswid=-?\\d+)|(dswid=-?\\d+&)|(\\?dswid=-?\\d+$)";
		return oldUrl.replaceFirst(regex, "");
	}

	
}
