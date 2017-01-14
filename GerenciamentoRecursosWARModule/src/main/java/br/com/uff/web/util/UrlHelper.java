package br.com.uff.web.util;

/**
 * Classe com funcionalidades que auxiliam manipula��o de uma URL
 */
public class UrlHelper {

	/**
	 * Construtor privado
	 */
	private UrlHelper(){
		super();
	}
	
	/**
	 * Express�o regular que remove o dswid=xxxx da url passada
	 * @param oldUrl url que ter� o par�metro removido
	 * @return url sem o dswid
	 */
	public static String removeDswidDaUrl(String oldUrl) {
		String regex = "(&dswid=-?\\d+)|(dswid=-?\\d+&)|(\\?dswid=-?\\d+$)";
		return oldUrl.replaceFirst(regex, "");
	}

	
}
