package br.com.resposta42.comum.seguranca.permissao.service;

import br.com.resposta42.comum.seguranca.permissao.dao.entidade.Permissao;
import br.com.resposta42.comum.seguranca.permissao.service.bean.PermissaoBean;

public class PermissaoConverter {
	private PermissaoConverter() {
	}

	public static Permissao converter(PermissaoBean bean) {
		Permissao permission = new Permissao();
		permission.setId(bean.getId());
		permission.setNome(bean.getNome());
		permission.setDescricao(bean.getDescricao());
		return permission;
	}

	public static PermissaoBean converter(Permissao entity) {
		PermissaoBean permissionBean = new PermissaoBean();
		permissionBean.setId(entity.getId());
		permissionBean.setNome(entity.getNome());
		permissionBean.setDescricao(entity.getDescricao());
		return permissionBean;
	}
}
