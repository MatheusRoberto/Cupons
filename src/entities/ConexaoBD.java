package entities;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 */
public class ConexaoBD {

	private ArrayList<Cliente> ArrayListCliente = new ArrayList<Cliente>();
	private ArrayList<Compra> ArrayListCompra = new ArrayList<Compra>();
	private ArrayList<ColecaoCupom> ArrayListColecaoCupom = new ArrayList<ColecaoCupom>();
	private ArrayList<Cupom> ArrayListCupom = new ArrayList<Cupom>();
	private ArrayList<Endereco> arrayListEndereco = new ArrayList<>();

	/**
	 * Default constructor
	 */
	public ConexaoBD() {
	}

	/**
	 * @return
	 */
	public Object consulta() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public Long executa() {
		// TODO implement here
		return null;
	}

	ArrayList<Cliente> getArrayListCliente() {
		return ArrayListCliente;
	}

	void setArrayListCliente(ArrayList<Cliente> arrayListCliente) {
		ArrayListCliente = arrayListCliente;
	}

	ArrayList<Compra> getArrayListCompra() {
		return ArrayListCompra;
	}

	void setArrayListCompra(ArrayList<Compra> arrayListCompra) {
		ArrayListCompra = arrayListCompra;
	}

	ArrayList<ColecaoCupom> getArrayListColecaoCupom() {
		return ArrayListColecaoCupom;
	}

	void setArrayListColecaoCupom(ArrayList<ColecaoCupom> arrayListColecaoCupom) {
		ArrayListColecaoCupom = arrayListColecaoCupom;
	}

	ArrayList<Cupom> getArrayListCupom() {
		return ArrayListCupom;
	}

	void setArrayListCupom(ArrayList<Cupom> arrayListCupom) {
		ArrayListCupom = arrayListCupom;
	}

	// cliente
	public void cadastrarCliente(Cliente c) {
		getArrayListCliente().add(c);
	}

	public void removerCliente(Cliente c) {
		List<Cliente> cli = (List<Cliente>) this.ArrayListCliente.stream().collect(Collectors.toList());
		if (cli.contains(c)) {
			cli.remove(c);
			this.ArrayListCliente = (ArrayList<Cliente>) cli;
		} else {
			System.out.println("Cliente " + c.getNome() + " n�o existe.");
		}
	}

	public void editarCliente(Cliente c) {
		removerCliente(c);
		cadastrarCliente(c);
	}

	public Cliente buscarCliente(Cliente c) {
		List<Cliente> cli = (List<Cliente>) this.ArrayListCliente.stream().collect(Collectors.toList());
		if (cli.contains(c)) {
			return c;
		} else {
			System.out.println("Cliente " + c.getNome() + " n�o existe.");
		}
		return null;
	}

	public ArrayList<Cliente> buscarClienteNome(String nome) {
		ArrayList<Cliente> cli = new ArrayList<Cliente>();
		for (int i = 0; i < this.ArrayListCliente.size(); i++) {
			if (this.ArrayListCliente.get(i).getNome().contains(nome)) {
				cli.add(this.ArrayListCliente.get(i));
			}
		}
		return cli;
	}

	public ArrayList<Cliente> buscarClienteEmail(String email) {
		ArrayList<Cliente> cli = new ArrayList<Cliente>();
		for (int i = 0; i < this.ArrayListCliente.size(); i++) {
			if (this.ArrayListCliente.get(i).getEmail().contains(email)) {
				cli.add(this.ArrayListCliente.get(i));
			}
		}
		return cli;
	}

	public ArrayList<Cliente> buscarClienteCPF(String cpf) {
		ArrayList<Cliente> cli = new ArrayList<Cliente>();
		for (int i = 0; i < this.ArrayListCliente.size(); i++) {
			if (this.ArrayListCliente.get(i) instanceof Fisica) {
				Fisica pessoa = (Fisica) this.ArrayListCliente.get(i);
				if (pessoa.getCpf().contains(cpf)) {
					cli.add(this.ArrayListCliente.get(i));
				}
			}
		}
		return cli;
	}

	public ArrayList<Cliente> buscarClienteCNPJ(String cnpj) {
		ArrayList<Cliente> cli = new ArrayList<Cliente>();
		for (int i = 0; i < this.ArrayListCliente.size(); i++) {
			if (this.ArrayListCliente.get(i) instanceof Juridica) {
				Juridica empresa = (Juridica) this.ArrayListCliente.get(i);
				if (empresa.getCnpj().contains(cnpj)) {
					cli.add(this.ArrayListCliente.get(i));
				}
			}
		}
		return cli;
	}

	public void listarTodosClientes() {
		Iterator<Cliente> it = this.ArrayListCliente.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// compra
	public void cadastrarCompra(Compra c) {
		getArrayListCompra().add(c);
		//getArrayListItemCompra().addAll(c.getItens());
	}

	public void removerCompra(Compra c) {
		List<Compra> compra = (List<Compra>) this.ArrayListCompra.stream().collect(Collectors.toList());
		;
		if (compra.contains(c)) {
			compra.remove(c);
			this.ArrayListCompra = (ArrayList<Compra>) compra;
		} else {
			System.out.println("Compra " + c.getClass() + " n�o existe.");
		}
	}

	public void editarCompra(Compra c) {
		removerCompra(c);
		cadastrarCompra(c);
	}

	public Compra buscarCompra(Compra c) {
		List<Compra> compra = (List<Compra>) this.ArrayListCompra.stream().collect(Collectors.toList());
		if (compra.contains(c)) {
			/*ArrayList<ItemCompra> itens = this.buscaItemCompra(c);
			for (ItemCompra itemCompra : itens) {
				c.adicionaColecao(itemCompra.getColecaoCupom(), itemCompra.getQtde());
			}*/
			return c;
		} else {
			System.out.println("Compra " + c.getClass() + " n�o existe.");
		}
		return null;
	}

	public ArrayList<Compra> buscarCompraCliente(Cliente c) {
		ArrayList<Compra> compra = new ArrayList<Compra>();
		for (int i = 0; i < this.ArrayListCompra.size(); i++) {
			if (this.ArrayListCompra.get(i).getFisica().equals(c)) {
				/*ArrayList<ItemCompra> itens = this.buscaItemCompra(this.ArrayListCompra.get(i));
				for (ItemCompra itemCompra : itens) {
					this.ArrayListCompra.get(i).adicionaColecao(itemCompra.getColecaoCupom(), itemCompra.getQtde());
				}*/
				compra.add(this.ArrayListCompra.get(i));
			}
		}
		return compra;
	}

	public ArrayList<Compra> buscarCompraData(Date data) {
		ArrayList<Compra> compra = new ArrayList<Compra>();
		for (int i = 0; i < this.ArrayListCompra.size(); i++) {
			if (this.ArrayListCompra.get(i).getDataVenda().equals(data)) {
				/*ArrayList<ItemCompra> itens = this.buscaItemCompra(this.ArrayListCompra.get(i));
				for (ItemCompra itemCompra : itens) {
					this.ArrayListCompra.get(i).adicionaColecao(itemCompra.getColecaoCupom(), itemCompra.getQtde());
				}*/
				compra.add(this.ArrayListCompra.get(i));
			}
		}
		return compra;
	}

	public void listarTodasCompras() {
		Iterator<Compra> it = this.ArrayListCompra.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// cole��o cupom
	public void cadastrarColecaoCupom(ColecaoCupom c) {
		getArrayListColecaoCupom().add(c);
	}

	public void removerColecaoCupom(ColecaoCupom c) {
		List<ColecaoCupom> colecao = (List<ColecaoCupom>) this.ArrayListColecaoCupom.stream()
				.collect(Collectors.toList());
		;
		if (colecao.contains(c)) {
			colecao.remove(c);
			this.ArrayListColecaoCupom = (ArrayList<ColecaoCupom>) colecao;
		} else {
			System.out.println("colecao " + c.getVersao() + " n�o existe.");
		}
	}

	public void editarColecaoCupom(ColecaoCupom c) {
		removerColecaoCupom(c);
		cadastrarColecaoCupom(c);
	}

	public ColecaoCupom buscarColecaoCupom(ColecaoCupom c) {
		List<ColecaoCupom> colecao = (List<ColecaoCupom>) this.ArrayListColecaoCupom.stream().collect(Collectors.toList());
		if (colecao.contains(c)) {
			return c;
		} else {
			System.out.println("Colecao " + c.getVersao() + " n�o existe.");
		}
		return null;
	}

	public ArrayList<ColecaoCupom> buscarColecaoCupomNome(String nome) {
		ArrayList<ColecaoCupom> colecao = new ArrayList<ColecaoCupom>();
		for (int i = 0; i < this.ArrayListColecaoCupom.size(); i++) {
			if (this.ArrayListColecaoCupom.get(i).getNome().contains(nome)) {
				colecao.add(this.ArrayListColecaoCupom.get(i));
			}
		}
		return colecao;
	}

	public ArrayList<ColecaoCupom> buscarColecaoCupomCategoria(String categoria) {
		ArrayList<ColecaoCupom> colecao = new ArrayList<ColecaoCupom>();
		for (int i = 0; i < this.ArrayListColecaoCupom.size(); i++) {
			if (this.ArrayListColecaoCupom.get(i).getCategoria().contains(categoria)) {
				colecao.add(this.ArrayListColecaoCupom.get(i));
			}
		}
		return colecao;
	}

	public void listarTodasColecaoCupom() {
		List<ColecaoCupom> colecaoCupom = (List<ColecaoCupom>) this.ArrayListColecaoCupom.stream()
				.collect(Collectors.toList());
		for (int i = 0; i < colecaoCupom.size(); i++) {
			colecaoCupom.get(i).listarColecao();
		}
	}

	// cupom
	public void cadastrarCupom(Cupom c) {
		getArrayListCupom().add(c);
	}

	public void removerCupom(Cupom c) {
		List<Cupom> cupom = (List<Cupom>) this.ArrayListCupom.stream().collect(Collectors.toList());
		if (cupom.contains(c)) {
			cupom.remove(c);
			this.ArrayListCupom = (ArrayList<Cupom>) cupom;
		} else {
			System.out.println("cupom " + c.getNome() + " n�o existe.");
		}
	}

	public void editarCupom(Cupom c) {
		removerCupom(c);
		cadastrarCupom(c);
	}

	public Cupom buscarCupom(Cupom c) {
		List<Cupom> cupom = (List<Cupom>) this.ArrayListCupom.stream().collect(Collectors.toList());
		;
		if (cupom.contains(c)) {
			return c;
		} else {
			System.out.println("cupom " + c.getNome() + " n�o existe.");
		}
		return null;
	}

	public ArrayList<Cupom> buscarCupomNome(String nome) {
		ArrayList<Cupom> cupom = new ArrayList<Cupom>();
		for (int i = 0; i < this.ArrayListColecaoCupom.size(); i++) {
			if (this.ArrayListCupom.get(i).getNome().contains(nome)) {
				cupom.add(this.ArrayListCupom.get(i));
			}
		}
		return cupom;
	}

	public ArrayList<Cupom> buscarCupomTipo(String tipo) {
		ArrayList<Cupom> cupom = new ArrayList<Cupom>();
		for (int i = 0; i < this.ArrayListColecaoCupom.size(); i++) {
			if (this.ArrayListCupom.get(i).getTipo().contains(tipo)) {
				cupom.add(this.ArrayListCupom.get(i));
			}
		}
		return cupom;
	}

	public ArrayList<Cupom> buscarCupomFornecedor(String nome) {
		ArrayList<Cupom> cupom = new ArrayList<Cupom>();
		for (int i = 0; i < this.ArrayListColecaoCupom.size(); i++) {
			if (this.ArrayListCupom.get(i).getFornecedor().getNome().contains(nome)) {
				cupom.add(this.ArrayListCupom.get(i));
			}
		}
		return cupom;
	}

	public void listarTodasCupom() {
		List<Cupom> cupom = (List<Cupom>) this.ArrayListCupom.stream().collect(Collectors.toList());
		for (int i = 0; i < cupom.size(); i++) {
			cupom.get(i).listarCupom();
		}
	}

/*	public ArrayList<ItemCompra> buscaItemCompra(Compra c) {
		ArrayList<ItemCompra> itens = new ArrayList<>();
		for (ItemCompra item : ArrayListItemCompra) {
			if (item.getCompra().equals(c))
				itens.add(item);
		}
		return itens;
	}*/ 

	public ArrayList<Endereco> getArrayListEndereco() {
		return arrayListEndereco;
	}

	public void setArrayListEndereco(ArrayList<Endereco> arrayListEndereco) {
		this.arrayListEndereco = arrayListEndereco;
	}
	
	public void cadastrarEndereco(Endereco en) {
		getArrayListEndereco().add(en);
	}

	@SuppressWarnings("unlikely-arg-type")
	public void removerEndereco(Endereco en) {
		List<Cliente> end = (List<Cliente>) this.ArrayListCliente.stream().collect(Collectors.toList());
		if (end.contains(en)) {
			end.remove(en);
			this.ArrayListCliente = (ArrayList<Cliente>) end;
		} else {
			System.out.println("Endereco nao existe.");
		}
	}

	public void editarEndereco(Endereco c) {
		removerEndereco(c);
		cadastrarEndereco(c);
	}

	public Endereco buscarEndereco(Endereco en) {
		List<Endereco> end= (List<Endereco>) this.arrayListEndereco.stream().collect(Collectors.toList());
		if (end.contains(en)) {
			return en;
		} else {
			System.out.println("Endereco nao existe.");
		}
		return null;
	}

	public ArrayList<Endereco> buscarEnderecoRua(String rua) {
		ArrayList<Endereco> end = new ArrayList<Endereco>();
		for (int i = 0; i < this.ArrayListCliente.size(); i++) {
			if (this.arrayListEndereco.get(i).getRua().contains(rua)) {
				end.add(this.arrayListEndereco.get(i));
			}
		}
		return end;
	}

}