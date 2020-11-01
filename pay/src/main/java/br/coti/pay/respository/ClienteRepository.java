package br.coti.pay.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.coti.pay.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
