package br.com.frajola.exemplares;

public class Livro extends Exemplar{
	private String editora;
	private String isbn;
	private Integer contadorLivro = 0;
	
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

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	

}
