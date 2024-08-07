package br.edu.infnet.cliente_ms.service;

import br.edu.infnet.cliente_ms.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public List<Cliente> getAll();

    public Optional<Cliente> getById(Long id);

    public Cliente update(Long id, Cliente cliente);

    public Cliente save(Cliente produto);

    public void delete(Long id);
}
