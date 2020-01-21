package br.com.frajola.biblioteca;

import java.util.ArrayList;
import br.com.frajola.exemplares.Exemplar;
import br.com.frajola.exemplares.Livro;;

public class Biblioteca {
	private ArrayList<Exemplar> listaDeExemplares;

	public Biblioteca() {
		listaDeExemplares = new ArrayList<Exemplar>();
	}

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
		} // TODO lançar exeção
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
