package entities;

public class Endereco {
	private String rua;
	private String CEP;
	private String numero;
	private String bairro;
	
	public Endereco(){	}
	
	public Endereco(String rua, String cep, String numero, String bairro){
		setRua(rua);
		setBairro(bairro);
		setCEP(cep);
		setNumero(numero);
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
