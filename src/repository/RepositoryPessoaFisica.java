package repository;

import java.util.ArrayList;
import java.util.List;

import modules.Pessoa;
import modules.PessoaFisica;

public class RepositoryPessoaFisica implements IRepositoryCRUD{
	List<PessoaFisica> listPF = new ArrayList<PessoaFisica>();
	
	@Override
	public boolean create(Pessoa pessoa) {
		boolean check = false;
		try {
			listPF.add((PessoaFisica) pessoa);
			check = true;
		} catch (Exception e) {
			check = false;
		}
		return check;
	}

	@Override
	public List<PessoaFisica> read() {
		return listPF;
	}

	@Override
	public boolean update(Pessoa pessoa) {
		boolean check = false;
		PessoaFisica pf = (PessoaFisica) pessoa;
		try {
			for (int i = 0; i < listPF.size(); i++) {
				if (listPF.get(i).getCpf() == pf.getCpf()) {
					listPF.get(i).setName(pf.getName());
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
			for (int i = 0; i < listPF.size(); i++) {
				if (listPF.get(i).getCpf() == id) {
					listPF.remove(i);
					check = true;
				}
			}
		} catch (Exception e) {
			check = false;
		}
		return check;
	}
	
	
}
