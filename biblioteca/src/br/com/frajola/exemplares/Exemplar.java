package br.com.frajola.exemplares;

import java.util.ArrayList;

public abstract class Exemplar {
	String titulo;
	String autor;
	Integer ano;
	ArrayList<Exemplar> listaDeExemplares;
	
	public Exemplar(String titulo, String autor, Integer ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		listaDeExemplares = new ArrayList<Exemplar>();
	}
	
	public abstract Integer contarExemplar();

	public ArrayList<Exemplar> getListaDeExemplares() {
		return listaDeExemplares;
	}

	public void setListaDeExemplares(ArrayList<Exemplar> listaDeExemplares) {
		this.listaDeExemplares = listaDeExemplares;
	}
	
	public void adicionarExemplar(Exemplar e) {
		listaDeExemplares.add(e);
	}
	
	public void removerExemplar(Exemplar e) {
		if (listaDeExemplares.contains(e)) {
			listaDeExemplares.remove(e);			
		}
	}
	
	public void atualizarExemplar(Exemplar e) {
		//TODO Fazer atualização do exemplar
	}
	
	public void listarExemplares() {
		for (Exemplar exemplar : listaDeExemplares) {
			System.out.println(exemplar);
		}
	}
	
}
