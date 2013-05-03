package br.com.resposta42.comum.seguranca.permissao.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.resposta42.comum.seguranca.permissao.service.PermissaoService;
import br.com.resposta42.comum.seguranca.permissao.service.bean.PermissaoBean;
import br.com.resposta42.util.GenericView;

@Named
@SessionScoped
public class PermissaoView extends GenericView {

	private static final long serialVersionUID = 1L;

	private static final String CONSULTAR = "permissao-consultar";
	
	private static final String INCLUIR = "permissao-incluir";
	
	private static final String ALTERAR = "permissao-alterar";

	@Inject
	private PermissaoService permissaoService;

	private PermissaoBean permissaoInclusao;

	private PermissaoBean permissaoAlteracao;
	
	private List<PermissaoBean> permissoes;

	@PostConstruct
	public void postConstruct() {
		consultar();
	}

	public String consultar() {
		permissoes = new ArrayList<PermissaoBean>();
		permissoes.addAll(permissaoService.findAll());
		return CONSULTAR;
	}

	public String irParaIncluir() {
		permissaoInclusao = new PermissaoBean();
		return INCLUIR;
	}
	
	public String incluir() {
		try {
			permissaoService.insert(permissaoInclusao);

			super.adicionaMensagemSucesso("Permissao inserida.");
			return consultar();
		} catch (Exception e) {
			super.adicionaMensagemSucesso(e.getMessage());
			return INCLUIR;
		}
	}

	public String irParaAlterar(PermissaoBean permissaoSelecionada) {
		permissaoAlteracao = permissaoSelecionada;
		return ALTERAR;
	}
	
	public String alterar() {
		try {
			permissaoService.update(permissaoAlteracao);

			super.adicionaMensagemSucesso("Permissao "
					+ permissaoAlteracao.getId() + " alterada.");
			return consultar();
		} catch (Exception e) {
			super.adicionaMensagemSucesso(e.getMessage());
			return ALTERAR;
		}
	}

	public String excluir(PermissaoBean permissaoSelecionada) {
		try {
			permissaoService.delete(permissaoSelecionada);
			
			super.adicionaMensagemSucesso("Permissao excluida.");
			return consultar();
		} catch (Exception e) {
			super.adicionaMensagemSucesso(e.getMessage());
			return CONSULTAR;
		}
	}
	
	public PermissaoBean getPermissaoAlteracao() {
		return permissaoAlteracao;
	}

	public void setPermissaoAlteracao(PermissaoBean permissaoAlteracao) {
		this.permissaoAlteracao = permissaoAlteracao;
	}

	public PermissaoBean getPermissaoInclusao() {
		return permissaoInclusao;
	}

	public void setPermissaoInclusao(PermissaoBean permissaoInclusao) {
		this.permissaoInclusao = permissaoInclusao;
	}

	public List<PermissaoBean> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissaoBean> permissoes) {
		this.permissoes = permissoes;
	}

}
