package br.com.fip.gati.revistaonline.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@javax.persistence.Entity
@Table(name="revista")
public class Revista extends Entity {

	@NotNull
	@Size(max=15)
	@Column(unique=true)
	private String issn;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="revista")
	private List<Edicao> edicoes;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="revista_avaliador", 
		joinColumns={@JoinColumn(name="revista_id")},
		inverseJoinColumns={@JoinColumn(name="avaliador_id")}
	)
	private List<Avaliador> avaliadores;

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public List<Edicao> getEdicoes() {
		return edicoes;
	}

	public void setEdicoes(List<Edicao> edicoes) {
		this.edicoes = edicoes;
	}

	public List<Avaliador> getAvaliadores() {
		return avaliadores;
	}

	public void setAvaliadores(List<Avaliador> avaliadores) {
		this.avaliadores = avaliadores;
	}
	
}
