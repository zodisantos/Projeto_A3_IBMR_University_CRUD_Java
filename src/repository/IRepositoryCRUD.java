package repository;

import java.util.List;

import modules.Pessoa;

public interface IRepositoryCRUD {

	public boolean create(Pessoa pessoa);
	public List<?> read();
	public boolean update(Pessoa pessoa);
	public boolean delete(long id);
}
