package entities;

public abstract class Cliente {

	private String nome;
	private String email;
	private String telefone;
	private String senha;
	private Endereco endereco;
	private ConexaoBD conexaoBD = new ConexaoBD();

	public Cliente(String n, String e, String t, String s, Endereco en) {
		// TODO Auto-generated constructor stub
		setNome(n);
		setEmail(e);
		setTelefone(t);
		setSenha(s);
		setEndereco(en);
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//Funcoes
	public Boolean cadastrar() {
		// TODO implement here
		System.out.println("Cadastro do cliente: ");
		getConexaoBD().cadastrarCliente(this);
		listarDados();
		return true;
	}

	public Boolean excluir() {
		// TODO implement here
		System.out.println("Excluindo cliente: ");
		getConexaoBD().removerCliente(this);
		toString();
		return true;
	}

	public Boolean editar() {
		// TODO implement here
		System.out.println("Editar cliente: ");
		
		toString();
		return true;
	}

	public abstract void listarDados();

	public ConexaoBD getConexaoBD() {
		return conexaoBD;
	}

	public void setConexaoBD(ConexaoBD conexaoBD) {
		this.conexaoBD = conexaoBD;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}