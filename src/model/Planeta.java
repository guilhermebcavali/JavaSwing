package src.model;
public class Planeta extends CorpoCeleste {
  private String tipo;
  private int numeroDeSatelites;
  private double periodoOrbital;
  private boolean possuiAtmosfera;

  public Planeta(String nome, double massa, double diametro, double distanciaDoSol, String tipo, int numeroDeSatelites, double periodoOrbital, boolean possuiAtmosfera) {
      super(nome, massa, diametro, distanciaDoSol);
      this.tipo = tipo;
      this.numeroDeSatelites = numeroDeSatelites;
      this.periodoOrbital = periodoOrbital;
      this.possuiAtmosfera = possuiAtmosfera;
  }

  public String getTipo() { return this.tipo; }
  public int getNumeroDeSatelites() { return this.numeroDeSatelites; }
  public double getPeriodoOrbital() { return this.periodoOrbital; }
  public boolean possuiAtmosfera() { return this.possuiAtmosfera; }
  
  public void setTipo(String tipo) { this.tipo = tipo; }
  public void setNumeroDeSatelites(int numeroDeSatelites) { this.numeroDeSatelites = numeroDeSatelites; }
  public void setPeriodoOrbital(double periodoOrbital) { this.periodoOrbital = periodoOrbital; }
  public void setPossuiAtmosfera(boolean possuiAtmosfera) { this.possuiAtmosfera = possuiAtmosfera; }

  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder(super.toString());
      sb.append("Tipo: ").append(this.tipo).append(", ");
      sb.append("Número de Satélites: ").append(this.numeroDeSatelites).append(", ");
      sb.append("Período Orbital: ").append(this.periodoOrbital).append(", ");
      sb.append("Possui Atmosfera: ").append(this.possuiAtmosfera);

      return sb.toString();
  }
}