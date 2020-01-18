package br.com.frajola.exemplares;

public class TCC extends Exemplar {
	String orientador;
	String areaDeConhecimento;
	Integer contadorTCC = 1;

	public TCC(String titulo, String autor, Integer ano, Integer exemplar, String orientador,
			String areaDeConhecimento) {
		super(titulo, autor, ano);
		this.orientador = orientador;
		this.areaDeConhecimento = areaDeConhecimento;
		this.contadorTCC++;
	}

	@Override
	public Integer contarExemplar() {
		return this.contadorTCC;
	}

}
