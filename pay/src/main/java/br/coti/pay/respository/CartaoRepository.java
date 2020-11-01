package br.coti.pay.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coti.pay.entity.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

}
