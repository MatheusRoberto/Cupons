package entities;

public class ItemCompra {

	private int qtde;
	private Compra compra;
	private ColecaoCupom colecaoCupom;

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public ColecaoCupom getColecaoCupom() {
		return colecaoCupom;
	}

	public boolean addProduto(ColecaoCupom colecaoCupom) {
		this.colecaoCupom = colecaoCupom;
		return true;
	}

	public Boolean removerProduto() {
		// TODO implement here
		this.colecaoCupom = null;
		return true;
	}

}