package br.com.coti.pay;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.coti.pay.entity.Cartao;
import br.com.coti.pay.entity.Cliente;
import br.com.coti.pay.entity.Consumo;
import br.coti.pay.respository.CartaoRepository;
import br.coti.pay.respository.ClienteRepository;
import br.coti.pay.respository.ConsumoRepository;

@SpringBootApplication
public class PayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PayApplication.class, args);
	}

	@Autowired
	ClienteRepository daocli;
	@Autowired
	CartaoRepository daocard;
	@Autowired
	ConsumoRepository daoconsumes;

	@Override
	public void run(String... args) throws Exception {
		try {
			daoconsumes.deleteAll();
			daocard.deleteAll();
			daocli.deleteAll();
			Cliente c = new Cliente();
			c.setNomeCliente("lu");
			c.setEmail("lu@gmail.com");

			Cartao credicard = new Cartao();
			credicard.setNomeCartao("CrediCard Itau");
			credicard.setDataPagamento(new Date("10/15/2020"));
			credicard.setQuantidade(3);

			Consumo consu1 = new Consumo();
			consu1.setNomeConsumo("Yakult");
			consu1.setValor(10.);
			consu1.setDataHora(new java.util.Date());
			consu1.setEstabelecimento("prix");

			Consumo consu2 = new Consumo();
			consu2.setNomeConsumo("tampico");
			consu2.setValor(8.);
			consu2.setDataHora(new java.util.Date());
			consu2.setEstabelecimento("prix");
			consu2.setCartao(credicard);

			Consumo consu3 = new Consumo();
			consu3.setNomeConsumo("ipad");
			consu3.setValor(2500.);
			consu3.setDataHora(new java.util.Date());
			consu3.setEstabelecimento("apple");
			consu3.setCartao(credicard);

			credicard.addConsumo(consu1);
			credicard.addConsumo(consu2);
			credicard.addConsumo(consu3);

			c.addCartao(credicard);
			credicard.gerarQuantidade();

			daocli.save(c);
			System.out.println("cliente gravado");

			daocard.save(credicard);
			System.out.println("Cartao de credito gravado");

			daoconsumes.save(consu1);
			daoconsumes.save(consu2);
			daoconsumes.save(consu3);
			System.out.println("Consumos gravados");

		} catch (Exception ex) {

		}

	}

}
