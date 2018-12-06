package entities;

import java.util.ArrayList;
import java.util.Date;

public class ColecaoCupom {
	
	private String nome;
	private String categoria;
	private String versao;
	private String descricao;
	private Date dataValidade;
	private Date dataInicio;
	private float preco;
	private ArrayList<Cupom> cupons;
	private ConexaoBD conexaoBD = new ConexaoBD();
	
	public ColecaoCupom() {
		// TODO Auto-generated constructor stub
		this.cupons = new ArrayList<>();
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public ArrayList<Cupom> getCupons(){
		return new ArrayList<>(this.cupons);
	}
	
	public void addCupom(Cupom c) {
		this.cupons.add(c);
	}
	
	public void removeCupom(Cupom c) {
		this.cupons.remove(c);
	}

	public void listarColecao() {
		// TODO implement here
		System.out.println("Coleção: "+getNome());
		System.out.println("Categoria: "+getCategoria()+ " - Versão: "+ getVersao());
		System.out.println("Valor: R$"+getPreco());
		System.out.println("Data de Inicio: "+getDataInicio()+"/ Data Termino: " + getDataValidade());
		System.out.println("Descrição: "+getDescricao());
		for(int i = 0; i < this.cupons.size(); i++) {
			getCupons().get(i).listarCupom();;
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println();
	}

	public Boolean cadastrarColecao() {
		// TODO implement here
		System.out.println("Cadastro de coleção: ");
		conexaoBD.cadastrarColecaoCupom(this);
		listarColecao();
		return true;
	}

	public Boolean excluirColecao() {
		// TODO implement here
		System.out.println("Excluindo de coleção: ");
		conexaoBD.removerColecaoCupom(this);
		listarColecao();
		return true;
	}

	public Boolean editarColecao() {
		// TODO implement here
		System.out.println("Editar coleção: ");
	
		listarColecao();
		return true;
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

}