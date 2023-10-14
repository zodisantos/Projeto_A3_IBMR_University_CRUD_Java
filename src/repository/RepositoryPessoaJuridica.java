package repository;

import java.util.ArrayList;
import java.util.List;

import modules.Pessoa;
import modules.PessoaJuridica;

public class RepositoryPessoaJuridica implements IRepositoryCRUD {
	List<PessoaJuridica> listPJ = new ArrayList<PessoaJuridica>();

	@Override
	public boolean create(Pessoa pessoa) {
		boolean check = false;
		try {
			listPJ.add((PessoaJuridica) pessoa);
			check = true;
		} catch (Exception e) {
			check = false;
		}
		return check;
	}

	@Override
	public List<PessoaJuridica> read() {
		return listPJ;
	}

	@Override
	public boolean update(Pessoa pessoa) {
		boolean check = false;
		PessoaJuridica pj = (PessoaJuridica) pessoa;
		try {
			for(int i = 0; i < listPJ.size(); i++) {
				if(listPJ.get(i).getCnpj() == pj.getCnpj()) {
					listPJ.get(i).setName(pj.getName());
					check = true;
				}
			}	
		} catch (Exception e) {
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean delete(long id) {
		boolean check = false;
		try {
			for(int i = 0; i < listPJ.size(); i++) {
				if(listPJ.get(i).getCnpj() == id) {
					listPJ.remove(i);
					check = true;
				}
			}
		} catch(Exception e) {
			check = false;
		}
		return check;
	}
	
}
