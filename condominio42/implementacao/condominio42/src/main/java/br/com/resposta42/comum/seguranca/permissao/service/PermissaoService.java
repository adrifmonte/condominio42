package br.com.resposta42.comum.seguranca.permissao.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.resposta42.comum.seguranca.permissao.dao.entidade.Permissao;
import br.com.resposta42.comum.seguranca.permissao.dao.entidade.PermissaoDao;
import br.com.resposta42.comum.seguranca.permissao.service.bean.PermissaoBean;

@Stateless
public class PermissaoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private PermissaoDao permissaoDao;

	public void insert(PermissaoBean permissaoBean) {
		permissaoDao.create(PermissaoConverter.converter(permissaoBean));
	}

	public void update(PermissaoBean permissaoBean) {
		permissaoDao.update(PermissaoConverter.converter(permissaoBean));
	}

	public void delete(PermissaoBean permissaoBean) {
		permissaoDao.delete(PermissaoConverter.converter(permissaoBean));
	}

	@SuppressWarnings("unchecked")
	public List<PermissaoBean> findAll() {
		List<PermissaoBean> permissaoBeans = new ArrayList<PermissaoBean>();
		List<Permissao> permissoes = permissaoDao.findAll(Permissao.class);
		for (Permissao permissao : permissoes) {
			permissaoBeans.add(PermissaoConverter.converter(permissao));
		}
		return permissaoBeans;
	}

	public void findById(Long id) {
		permissaoDao.findById(id, Permissao.class);
	}
}
