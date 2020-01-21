package br.com.frajola.exemplares;

public class TCC extends Exemplar {
	private String orientador;
	private String areaDeConhecimento;
	private Integer contadorTCC = 0;

	public TCC(String titulo, String autor, Integer ano, String orientador,
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

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public Integer getContadorTCC() {
		return contadorTCC;
	}

	public void setContadorTCC(Integer contadorTCC) {
		this.contadorTCC = contadorTCC;
	}

	public String getAreaDeConhecimento() {
		return areaDeConhecimento;
	}

	public void setAreaDeConhecimento(String areaDeConhecimento) {
		this.areaDeConhecimento = areaDeConhecimento;
	}
	
	

}
