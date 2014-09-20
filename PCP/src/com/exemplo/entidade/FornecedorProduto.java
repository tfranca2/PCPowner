package com.exemplo.entidade;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="FORNECEDOR_PRODUTO")
@AssociationOverrides({
	@AssociationOverride(name = "pk.fornecedor",joinColumns = @JoinColumn(name = "ID_FORNECEDOR")),
	@AssociationOverride(name = "pk.produto", joinColumns = @JoinColumn(name = "ID_PRODUTO")) })
public class FornecedorProduto {
	
	@EmbeddedId
	private FornecedorProdutoPk pk = new FornecedorProdutoPk();
	
	@Column(name="DT_CRIACAO")
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	@Transient
	public Produto getProduto() {
		return getPk().getProduto();
	}

	public void setProduto(Produto produto) {
		getPk().setProduto(produto);
	}
	@Transient
	public Fornecedor getFornecedor() {
		return getPk().getFornecedor();
	}

	public void setFornecedor(Fornecedor fornecedor) {
		getPk().setFornecedor(fornecedor);
	}

	public FornecedorProdutoPk getPk() {
		return pk;
	}

	public void setPk(FornecedorProdutoPk pk) {
		this.pk = pk;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	
}
