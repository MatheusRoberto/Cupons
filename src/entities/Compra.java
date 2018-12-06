package entities;

import java.util.*;

/**
 * 
 */
public class Compra {

	private Date dataVenda;
	private Fisica fisica;
	private ArrayList<ItemCompra> itens;
	private Pagamento pagamento;
	private final int id = 0;
	private ConexaoBD conexaoBD = new ConexaoBD();
	
	public Compra() {
		// TODO Auto-generated constructor stub
		itens = new ArrayList<>();
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Fisica getFisica() {
		return fisica;
	}

	public void setFisica(Fisica fisica) {
		this.fisica = fisica;
	}

	public ArrayList<ItemCompra> getItens() {
		return this.itens;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public void setConexaoBD(ConexaoBD bd) {
		this.conexaoBD = bd;
	}
	
	public ConexaoBD getConexaoBD() {
		return this.conexaoBD;
	}

	public boolean adicionaColecao(ColecaoCupom cc, int quantidade) {
		ItemCompra ic = new ItemCompra();
		ic.setCompra(this);
		ic.addProduto(cc);
		ic.setQtde(quantidade);
		return addItem(ic);
	}

	public void removeColecao(ColecaoCupom cc) {
		ItemCompra ic = null;
		for (ItemCompra itemCompra : itens) {
			if (itemCompra.getColecaoCupom().equals(cc)) {
				ic = itemCompra;
				break;
			}
		}
		if (ic != null)
			removeItem(ic);
	}

	public void alteraQuantidade(ColecaoCupom cc, int qtde) {
		for (ItemCompra itemCompra : itens) {
			if (itemCompra.getColecaoCupom().equals(cc)) {
				itemCompra.setQtde(qtde);
				break;
			}
		}
	}
	
	public void listaItensCompra() {
		for (ItemCompra itemCompra : itens) {
			System.out.println(itemCompra);
		}
	}

	private boolean addItem(ItemCompra ic) {
		return this.itens.add(ic);
	}

	private void removeItem(ItemCompra ic) {
		this.itens.remove(ic);
	}

	public Boolean finalizarCompra(Pagamento p) {
		// TODO implement here
		this.pagamento = p;
		setDataVenda(new Date());
		if(itens.isEmpty() || getFisica() == null)
			return false;
		this.conexaoBD.cadastrarCompra(this);
		return true;
	}

	public int getId() {
		return id;
	}

}