package com.exemplo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCidade")
	private int id;
	@Column
	private String cidade;
	@Column
	private String uf;
	@Column
	private String rais;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getRais() {
		return rais;
	}
	public void setRais(String rais) {
		this.rais = rais;
	}
	
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", cidade=" + cidade + ", uf=" + uf
				+ ", rais=" + rais + "]";
	}

}
