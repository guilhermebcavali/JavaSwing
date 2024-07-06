package src.model;
public class CorpoCeleste {
	private String nome;
	private double massa;
	private double diametro;
	private double distanciaDoSol;

	public CorpoCeleste(String nome, double massa, double diametro, double distanciaDoSol) {
		this.nome = nome;
		this.massa = massa;
		this.diametro = diametro;
		this.distanciaDoSol = distanciaDoSol;
	}

	public String getNome() {
		return nome;
	}

	public double getMassa() {
		return massa;
	}

	public double getDiametro() {
		return diametro;
	}

	public double getDistanciaDoSol() {
		return distanciaDoSol;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMassa(double massa) {
		this.massa = massa;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public void setDistanciaDoSol(double distanciaDoSol) {
		this.distanciaDoSol = distanciaDoSol;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ").append(this.nome);
		sb.append(", Massa:").append(this.massa);
		sb.append(" kg, Diâmetro: ").append(diametro);
		sb.append("km, Distância do Sol: ").append(this.distanciaDoSol).append("milhões km, ");
		return sb.toString();
	}
}
