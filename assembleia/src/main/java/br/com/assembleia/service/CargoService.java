package br.com.assembleia.service;

import br.com.assembleia.model.Cargo;
import java.util.List;

public interface CargoService {

    void salvar(Cargo cargo) throws IllegalArgumentException;

    List<Cargo> listarTodos();

    void editar(Cargo cargo);

    void deletar(Cargo cargo);
}
