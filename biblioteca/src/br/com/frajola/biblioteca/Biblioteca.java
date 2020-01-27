package br.com.frajola.biblioteca;

import java.util.Vector;

import br.com.frajola.exemplares.Exemplar;
import br.com.frajola.exemplares.Livro;;

public class Biblioteca {
	private Vector<Exemplar> listaDeExemplares;

	public Biblioteca() {
		listaDeExemplares = new Vector<Exemplar>();
	}

	public Vector<?> getListaDeExemplares() {
		return listaDeExemplares;
	}

	public void setListaDeExemplares(Vector<Exemplar> listaDeExemplares) {
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
		// TODO Fazer atualização do exemplar
	}

	public void listarExemplares() {

		for (Exemplar exemplar : listaDeExemplares) {
			if(exemplar instanceof Livro) {				
				//TODO
				System.out.println("" + exemplar.getTitulo());
				System.out.println("" + exemplar.getAutor());
				System.out.println("" + exemplar.getAutor());
			}

		}

	}

}
