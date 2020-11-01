package br.coti.pay.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.coti.pay.entity.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Long>{

}
