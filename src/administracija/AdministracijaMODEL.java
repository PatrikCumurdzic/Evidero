package administracija;

import java.io.Serializable;

public class AdministracijaMODEL implements Serializable{
	private String mjestoStanovanja;
	private String firma;
	private String fakultet;
	private String osnovnaSkola;
	private String srednjaSkola;

	
	public String getMjestoStanovanja() {
		return mjestoStanovanja;
	}
	public void setMjestoStanovanja(String mjestoStanovanja) {
		this.mjestoStanovanja = mjestoStanovanja;
	}
	
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	
	public String getFakultet() {
		return fakultet;
	}
	public void setFakultet(String fakultet) {
		this.fakultet = fakultet;
	}
	
	public String getOsnovnaSkola() {
		return osnovnaSkola;
	}
	public void setOsnovnaSkola(String osnovnaSkola) {
		this.osnovnaSkola = osnovnaSkola;
	}
	
	public String getSrednjaSkola() {
		return srednjaSkola;
	}
	public void setSrednjaSkola(String srednjaSkola) {
		this.srednjaSkola = srednjaSkola;
	}
}