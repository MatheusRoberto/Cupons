package entities;

public class Cupom {

	private final long codigoValidacao;
	private String nome;
	private String promocao;
	private String descricao;
	private String tipo;
	private boolean validado;
	private Juridica fornecedor;
	private ConexaoBD conexaoBD = new ConexaoBD();

	public Cupom() {
		// TODO Auto-generated constructor stub
		this.codigoValidacao = geraCodigo();
		this.validado = false;
	}

	public Cupom(String n, String d, String t, Juridica j) {
		// TODO Auto-generated constructor stub
		this.codigoValidacao = geraCodigo();
		this.validado = false;
		setNome(n);
		setDescricao(d);
		setTipo(t);
		setFornecedor(j);
	}

	public long getCodigoValidacao() {
		return codigoValidacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}

	public Juridica getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Juridica fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Boolean cadastrarCupom() {
		System.out.println("Cadastro do cupom: ");
		conexaoBD.cadastrarCupom(this);
		listarCupom();
		return true;
	}

	public Boolean excluirCupom() {
		// TODO implement here
		System.out.println("Excluindo cupom: ");
		conexaoBD.removerCupom(this);
		toString();
		return true;
	}

	public Boolean editarCupom() {
		// TODO implement here
		System.out.println("Editar cupom: ");
		toString();
		return true;
	}

	public void listarCupom() {
		System.out.println("Cupom: "+getNome()+" - Fornecedor: "+ getFornecedor());
		System.out.println("Promoção: "+getPromocao());
		System.out.println("Tipo: "+getTipo());
		System.out.println("Descrição: "+getDescricao());
		System.out.println("Codigo: "+getCodigoValidacao());
		System.out.println();
	}
	
	private long geraCodigo() {
		return (long) (1000000000000l + Math.random() * 8999999999999l);
	}


	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

}