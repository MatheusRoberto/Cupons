package entities;

import java.util.Date;

public class PagamentoCheque extends Pagamento {

	private int banco;
	private String nomeBanco;
	
	public PagamentoCheque() {
		// TODO Auto-generated constructor stub
	}

	public PagamentoCheque(float v, Date d, int b, String n) {
		// TODO Auto-generated constructor stub
		super(true, v, d);
		setBanco(b);
		setNomeBanco(n);
	}
	
	public int getBanco() {
		return banco;
	}

	public void setBanco(int banco) {
		this.banco = banco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

}