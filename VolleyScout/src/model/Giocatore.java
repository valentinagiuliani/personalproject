package model;

public class Giocatore {
	private String nome;
	private String cognome;
	private String ruolo;
	private String numero;
	
	public Giocatore(){
		this.setNome(null);
		this.setCognome(null);
		this.setRuolo(null);
		this.setNumero(null);
	}
	
	public Giocatore(String n,String c,String r,String num){
		this.setNome(n);
		this.setCognome(c);
		this.setRuolo(r);
		this.setNumero(num);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
