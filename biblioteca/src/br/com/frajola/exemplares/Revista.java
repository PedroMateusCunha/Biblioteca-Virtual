package br.com.frajola.exemplares;

public class Revista extends Exemplar {
	String tipo;
	String editora;
	static Integer contadorRevista = 0;

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
	

}
