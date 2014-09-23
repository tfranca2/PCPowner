package com.exemplo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="volume")
public class Volume { //pacote; caixa; garrafa; bobina; etc...
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idVolume")
	private int id;
	@Column
	private String volume;
	@Column
	private String abreviatura;
	
	public Volume(){ }
	
	public Volume(String descricao, String abreviatura){
		this.volume = descricao;
		this.abreviatura = abreviatura;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	@Override
	public String toString() {
		return "Volume [id=" + id + ", volume=" + volume + ", abreviatura="
				+ abreviatura + "]";
	}
}
