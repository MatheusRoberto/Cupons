package entities;

public class Juridica extends Cliente {

	private String cnpj;
	private String tipo;
	private String descricao;
	
	public Juridica(String n, String e, String t, String s, String c, String end, String tp, String d, Endereco en) {
		// TODO Auto-generated constructor stub
		super(n, end, t, s, en);
		setCnpj(c);
		setTipo(tp);
		setDescricao(d);
	}
	
	public Juridica() {
		// TODO Auto-generated constructor stub
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean validarCupom(Cupom cupom) {
		// TODO implement here
		if(cupom.isValidado() == false ) {
			if(cupom.getFornecedor() == this) {
				cupom.setValidado(true);
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	
	@Override
	public void listarDados() {
		// TODO Auto-generated method stub
		System.out.println(getNome());
		System.out.println(getEmail());
		System.out.println(getTelefone());
		System.out.println(getSenha());
		System.out.println(getCnpj());
		System.out.println(getEndereco());
		System.out.println(getTipo());
		System.out.println(getDescricao());
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome() + " CNPJ: "+getCnpj();
	}

}