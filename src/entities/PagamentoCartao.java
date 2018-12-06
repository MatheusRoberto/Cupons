package entities;

import java.util.Date;

public class PagamentoCartao extends Pagamento {

	private String nroCartao;
	private String bandeira;
	
	public PagamentoCartao() {
		// TODO Auto-generated constructor stub
	}

	public PagamentoCartao(float v, Date d, String n, String b) {
		// TODO Auto-generated constructor stub
		super(true, v, d);
		setNroCartao(n);
		setBandeira(b);
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getNroCartao() {
		return nroCartao;
	}

	public void setNroCartao(String nroCartao) {
		this.nroCartao = nroCartao;
	}

}