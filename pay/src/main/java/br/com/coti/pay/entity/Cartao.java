package br.com.coti.pay.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.coti.pay.entity.Cliente;
import br.com.coti.pay.entity.Consumo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cartao")
public class Cartao  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCartao;

	@Column(name = "nomeCartao")
	private String nomeCartao;

	@Column(name = "quantidade")
	private Integer quantidade = 0;

	@Column(name = "total")
	private Double total = 0.;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private java.util.Date dataPagamento;

	@OneToMany(mappedBy = "cartao", fetch = FetchType.EAGER,
			 cascade = { CascadeType.ALL })
	@JsonIgnore
	private Set<Consumo> consumos = new HashSet<Consumo>();
	
	@ManyToOne
	@JoinColumn(name="fkidcliente",referencedColumnName ="idCliente" )
	@JsonIgnore
	private Cliente cliente;
	
	
	public Cartao() {
	
	}
	
    
	
	public Cartao(Long idCartao, String nomeCartao, Integer quantidade, Double total, Date dataPagamento,
			Set<Consumo> consumos, Cliente cliente) {
		super();
		this.idCartao = idCartao;
		this.nomeCartao = nomeCartao;
		this.quantidade = quantidade;
		this.total = total;
		this.dataPagamento = dataPagamento;
		this.consumos = consumos;
		this.cliente = cliente;
	}



	// especifico "2000-08-20"
	public Long getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public java.util.Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(java.util.Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Set<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(Set<Consumo> consumos) {
		this.consumos = consumos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public void addConsumo(Consumo consumo) {
		 this.total += consumo.getValor();
		this.consumos.add(consumo);
	}

	public void   gerarQuantidade() {
		this.setQuantidade(consumos.size());
	}
	
	
}
