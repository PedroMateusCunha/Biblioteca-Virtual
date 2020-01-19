package br.com.frajola.exemplares;

public class Revista extends Exemplar {
	private String tipo;
	private String editora;
	private static Integer contadorRevista = 0;

	public Revista(String titulo, String autor, Integer ano, String tipo,
			String editora) {
		super(titulo, autor, ano);
		this.tipo = tipo;
		this.editora = editora;
		Revista.contadorRevista++;
	}

	@Override
	public Integer contarExemplar() {
		return Revista.contadorRevista;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	

	
}
