package br.com.resposta42.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class GenericView implements Serializable {

	private static final long serialVersionUID = 1L;

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public static void adicionaMensagemSucesso(String mensagem) {
		getFacesContext().addMessage(null, new FacesMessage(mensagem));
	}
}
