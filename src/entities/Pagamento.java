package entities;

import java.util.*;

/**
 * 
 */
public abstract class Pagamento {

	private Boolean pago;
	private float valor;
	private Date dataLimite;
	
	public Pagamento() {
		// TODO Auto-generated constructor stub
	}

	public Pagamento(boolean p, float v, Date d) {
		// TODO Auto-generated constructor stub
		setPago(p);
		setValor(v);
		setDataLimite(d);
	}
	
	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

}