package br.com.assembleia.dao;
 
import java.util.List;
 
import br.com.assembleia.model.Cargo;
 
public interface CargoDAO {
    Cargo getById(final Long id);
 
    List<Cargo> listarTodos();
 
    void salvar(Cargo cargo);
 
    void editar(Cargo cargo);
 
    void deletar(Cargo cargo);
 
    void deletarId(final Long id);
}