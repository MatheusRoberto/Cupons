package entities;

import java.util.ArrayList;

public class Fisica extends Cliente {

	private String cpf;

	public Fisica(String n, String e, String t, String s, String c, Endereco en) {
		// TODO Auto-generated constructor stub
		super(n, e, t, s, en);
		setCpf(c);
	}

	public Fisica() {
		// TODO Auto-generated constructor stub
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean usarCupom(Cupom c) {
		// TODO implement here
		c.getFornecedor().validarCupom(c);
		return true;
	}

	@Override
	public void listarDados() {
		// TODO Auto-generated method stub
		System.out.println(getNome());
		System.out.println(getEmail());
		System.out.println(getTelefone());
		System.out.println(getSenha());
		System.out.println(getCpf());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome() + " CPF: " + getCpf();
	}

	public ArrayList<Compra> buscarCompra(Cliente c) {
		ArrayList<Compra> compraCliente = getConexaoBD().buscarCompraCliente(this);
		if (compraCliente != null) {
			return compraCliente;
		}
		return null;
	}

	public ArrayList<ColecaoCupom> buscarColecaoComprado() {
		ArrayList<Compra> compraCliente = this.buscarCompra(this);
		if (compraCliente != null) {
			//System.out.println(compraCliente);
			ArrayList<ColecaoCupom> colecao = new ArrayList<ColecaoCupom>();
			for (Compra compra : compraCliente) {
				for (ItemCompra item : compra.getItens()) {
					colecao.add(item.getColecaoCupom());
				}
			}
			//System.out.println(colecao);
			return colecao;
		}
		return null;
	}

	public void listarColecao() {
		ArrayList<ColecaoCupom> colecao = this.buscarColecaoComprado();
		if (colecao != null) {
			for (int i = 0; i < colecao.size(); i++) {
				colecao.get(i).listarColecao();
			}
		} else {
			System.out.println("Nenhuma colecao comprada");
		}
	}

	public ArrayList<Cupom> buscarCupom() {
		ArrayList<ColecaoCupom> colecao = this.buscarColecaoComprado();
		if (colecao != null) {
			ArrayList<Cupom> cupom = new ArrayList<Cupom>();
			for (int i = 0; i < colecao.size(); i++) {
				for (int j = 0; j < colecao.get(i).getCupons().size(); j++) {
					cupom.add(colecao.get(i).getCupons().get(j));
				}
			}
			return cupom;
		}
		return null;
	}

	public void listarCupom() {
		// TODO Auto-generated method stub
		ArrayList<Cupom> cupom = this.buscarCupom();
		if (cupom != null) {
			for (int i = 0; i < cupom.size(); i++) {
				cupom.get(i).listarCupom();
			}
		} else {
			System.out.println("Voce nao possui nenhum cupom");
		}
	}

	public void listarCupomValido() {
		ArrayList<Cupom> cupom = this.buscarCupom();
		if (cupom != null) {
			for (int i = 0; i < cupom.size(); i++) {
				if (cupom.get(i).isValidado() == false) {
					ArrayList<Cupom> cupomValido = new ArrayList<Cupom>();
					cupomValido.add(cupom.get(i));
					cupomValido.get(i).listarCupom();
				}
			}
		} else {
			System.out.println("Voce nao possui nenhum cupons validos");
		}
	}

	public void listarCupomInvalido() {
		// TODO Auto-generated method stub
		ArrayList<Cupom> cupom = this.buscarCupom();
		if (cupom != null) {
			for (int i = 0; i < cupom.size(); i++) {
				if (cupom.get(i).isValidado() == true) {
					ArrayList<Cupom> cupomInvalido = new ArrayList<Cupom>();
					cupomInvalido.add(cupom.get(i));
					cupomInvalido.get(i).listarCupom();
				}
			}
		} else {
			System.out.println("Voce nao possui nenhum cupons invalidos");

		}
	}

}