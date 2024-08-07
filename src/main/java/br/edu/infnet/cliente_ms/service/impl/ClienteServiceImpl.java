package br.edu.infnet.cliente_ms.service.impl;

import br.edu.infnet.cliente_ms.exception.ResourceNotFoundException;
import br.edu.infnet.cliente_ms.model.Cliente;
import br.edu.infnet.cliente_ms.repository.ClienteRepository;
import br.edu.infnet.cliente_ms.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isEmpty()) {
            throw new ResourceNotFoundException("Não encontrado o cliente com id: " + id);
        }
        return cliente;
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = getById(id);

        if (clienteOptional.isEmpty()) {
            throw new ResourceNotFoundException("Não encontrado cliente com id " + id);
        }

        Cliente existingCliente = clienteOptional.get();
        existingCliente.setNome(cliente.getNome());
        existingCliente.setCpf(cliente.getCpf());
        existingCliente.setEmail(cliente.getEmail());

        return clienteRepository.save(existingCliente);
    }

    @Override
    public Cliente save(Cliente produto) {
        return clienteRepository.save(produto);
    }

    @Override
    public void delete(Long id) {
        Optional<Cliente> cliente = getById(id);

        if (cliente.isEmpty()) {
            throw new ResourceNotFoundException("Não encontrado cliente com id " + id);
        }
        clienteRepository.deleteById(id);
    }
}
