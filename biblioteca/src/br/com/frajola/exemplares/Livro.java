package br.com.frajola.exemplares;

public class Livro extends Exemplar{
	String editora;
	String isbn;
	Integer contadorLivro = 1;
	
	public Livro(String titulo, String autor, Integer ano, String editora, String isbn) {
		super(titulo, autor, ano);
		this.editora = editora;
		this.isbn = isbn;
		this.contadorLivro++;
	}

	@Override
	public Integer contarExemplar() {
		return this.contadorLivro;
	}
	
	

}
