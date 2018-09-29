package br.com.tudo;

import javax.json.bind.annotation.JsonbAnnotation;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@JsonbAnnotation
public class pessoa {
	
	private int id;
	
	private String nome;
	
	private int cpf;
	
	private int rg;
	
	private int numContato;
	
	public pessoa (){
		
	}
	
	
	
	public pessoa(int id, String nome, int cpf, int rg, int numContato) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.numContato = numContato;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public int getNumContato() {
		return numContato;
	}
	public void setNumContato(int numContato) {
		this.numContato = numContato;
	}



	@Override
	public String toString() {
		return ""+getId() +""+getNome();
	}
	
	
	
}
