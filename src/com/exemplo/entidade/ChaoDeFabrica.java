package com.exemplo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="chaodefabrica")
public class ChaoDeFabrica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idChaodefabrica")
	private int id;
	@OneToOne
	private OrdemDeProducao ordem;
	@OneToOne
	private Produto produto;
	@Column
	private double consumoReal;
	@Column
	private double consumoNominal;
	@Column
	private double perda;
	@Column
	private double aproveitamento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public OrdemDeProducao getOrdem() {
		return ordem;
	}
	public void setOrdem(OrdemDeProducao ordem) {
		this.ordem = ordem;
	}
	public double getConsumoReal() {
		return consumoReal;
	}
	public void setConsumoReal(double consumoReal) {
		this.consumoReal = consumoReal;
	}
	public double getPerda() {
		return perda;
	}
	public void setPerda(double perda) {
		this.perda = perda;
	}
	public double getAproveitamento() {
		return aproveitamento;
	}
	public void setAproveitamento(double aproveitamento) {
		this.aproveitamento = aproveitamento;
	}
	public double getConsumoNominal() {
		return consumoNominal;
	}
	public void setConsumoNominal(double consumoNominal) {
		this.consumoNominal = consumoNominal;
	}
}