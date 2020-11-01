package br.com.coti.pay.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import br.com.coti.pay.entity.Cartao;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcliente")
	private Long idCliente;

	@NotEmpty(message = "Digite Valores")
	@Pattern(regexp = "{a-z A-Z}[2,50]")
	@Column(name = "nomecliente", length = 50, nullable = true)
	private String nomeCliente;

	@Column(name = "email", length = 50, unique = true, nullable = true)
	@Email(message = "Email Invalido")
	private String email;

	@Min(value = -1000, message = "Saldo nao ser Negativo")
	@Column(name = "saldo")
	private Double saldo = 0.;

	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.ALL })
	@JsonIgnore
	private Set<Cartao> cartoes = new HashSet<>();

	public Cliente() {

	}
	
	public Cliente(Long idCliente,
			@NotEmpty(message = "Digite Valores") @Pattern(regexp = "{a-z A-Z}[2,50]") String nomeCliente,
			@Email(message = "Email Invalido") String email,
			@Min(value = -1000, message = "Saldo nao ser Negativo") Double saldo) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.email = email;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", email=" + email + ", saldo="
				+ saldo + "]";
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Set<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(Set<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	// Adicionar o Varios
	// One adiciona o Varios
	public void addCartao(Cartao cartao) {
		this.saldo += cartao.getTotal();
		this.cartoes.add(cartao);
	}

}