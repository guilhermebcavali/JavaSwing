package src.model;

public class Estrela extends CorpoCeleste {
  private double luminosidade;
  private String tipoEspectral;
  private double temperaturaSuperficie;

  public Estrela(String nome, double massa, double diametro, double distanciaDoSol, double luminosidade, String tipoEspectral, double temperaturaSuperficie) {
    super(nome, massa, diametro, distanciaDoSol);
    this.luminosidade = luminosidade;
    this.tipoEspectral = tipoEspectral;
    this.temperaturaSuperficie = temperaturaSuperficie;
  }

  public double getLuminosidade() { return this.luminosidade; }
  public String getTipoEspectral() { return this.tipoEspectral; }
  public double getTemperaturaSuperficie() { return this.temperaturaSuperficie; }

  public void setLuminosidade(double luminosidade) { this.luminosidade = luminosidade; }
  public void setTipoEspectral(String tipoEspectral) { this.tipoEspectral = tipoEspectral; }
  public void setTemperaturaSuperficie(double temperaturaSuperficie) { this.temperaturaSuperficie = temperaturaSuperficie; }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append(", Luminosidade: ").append(this.luminosidade).append("L☉, ");
    sb.append("Tipo Espectral: ").append(this.tipoEspectral).append(", ");
    sb.append("Temperatura da Superfície: ").append(temperaturaSuperficie).append(" K");

    return sb.toString();
  }
}