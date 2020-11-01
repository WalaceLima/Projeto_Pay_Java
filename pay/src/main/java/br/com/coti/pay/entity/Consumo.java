package br.com.coti.pay.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.coti.pay.entity.Cartao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="consumo")
public class Consumo implements Serializable{
 
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsumo;
	
	@Column(name="nomeConsumo")
	private String nomeConsumo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
	            )
	private Date dataHora;
	@Column
	private Double valor;
	
	@Column(name="estabelecimento")
	private String estabelecimento;
	
	@ManyToOne
	@JoinColumn(name="id_cartao", referencedColumnName ="idCartao")
	@JsonIgnore
	private Cartao cartao;
	
	
	
	public Consumo() {
	
	}
	
	//Cliente seus dados(relaciona)
	//Cartao (relaciona a todos)
	//Consumo(relaciona ao anterior)
	
	public Consumo(Long idConsumo, String nomeConsumo, Date dataHora, Double valor, String estabelecimento,
			Cartao cartao) {
		super();
		this.idConsumo = idConsumo;
		this.nomeConsumo = nomeConsumo;
		this.dataHora = dataHora;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
	}


	
	
	public Long getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(Long idConsumo) {
		this.idConsumo = idConsumo;
	}
	public String getNomeConsumo() {
		return nomeConsumo;
	}
	public void setNomeConsumo(String nomeConsumo) {
		this.nomeConsumo = nomeConsumo;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
			
}
