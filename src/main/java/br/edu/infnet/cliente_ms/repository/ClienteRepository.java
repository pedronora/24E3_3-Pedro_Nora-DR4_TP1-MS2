package br.edu.infnet.cliente_ms.repository;

import br.edu.infnet.cliente_ms.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
