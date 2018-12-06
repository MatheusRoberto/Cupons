package util;

import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import entities.ColecaoCupom;
import entities.ConexaoBD;
import entities.Cupom;
import entities.Endereco;
import entities.Fisica;
import entities.Juridica;

public class LeitorDados {
	private ConexaoBD bd;
	private ArrayList<Juridica> juridicas;
	private ArrayList<Cupom> cupons;
	private ArrayList<Endereco> enderecos;

	public LeitorDados(ConexaoBD bd) {
		// TODO Auto-generated constructor stub
		setBD(bd);
		this.juridicas = new ArrayList<>();
		this.cupons = new ArrayList<>();
		this.enderecos = new ArrayList<>();
	}

	private void setBD(ConexaoBD bd) {
		this.bd = bd;
	}

	public void lerArquivo() throws JSONException, ParseException {
		// TODO Auto-generated method stud
		JSONObject jsonObject;
		Reader in = new InputStreamReader(getClass().getResourceAsStream("/util/banco.json"));
		jsonObject = new JSONObject(new JSONTokener(in));
		for(int i = 0; i < jsonObject.getJSONArray("enderecos").length(); i++) {
			JSONObject endereco = jsonObject.getJSONArray("enderecos").getJSONObject(i);
			cadastraEndereco(endereco.getString("rua"), endereco.getString("CEP"), endereco.getString("numero"), endereco.getString("bairro"));
		}
		
		for (int i = 0; i < jsonObject.getJSONArray("fornecedores").length(); i++) {
			JSONObject juridico = jsonObject.getJSONArray("fornecedores").getJSONObject(i);
			cadastraJuridico(juridico.getString("nome"), juridico.getString("CNPJ"), juridico.getString("tipo"), juridico.getInt("endereco"));
		}

		for (int i = 0; i < jsonObject.getJSONArray("clientes").length(); i++) {
			JSONObject fisico = jsonObject.getJSONArray("clientes").getJSONObject(i);
			cadastraFisico(fisico.getString("nome"), fisico.getString("CPF"), fisico.getString("email"), fisico.getString("telefone"), fisico.getString("senha"), fisico.getInt("endereco"));
		}

		for (int i = 0; i < jsonObject.getJSONArray("cupons").length(); i++) {
			JSONObject cupom = jsonObject.getJSONArray("cupons").getJSONObject(i);
			cadastraCupom(cupom.getString("nome"), cupom.getString("promocao"), cupom.getString("tipo"), cupom.getBoolean("validado"),
					cupom.getInt("fornecedor"));
		}

		for (int i = 0; i < jsonObject.getJSONArray("colecoes").length(); i++) {
			JSONObject colecoes = jsonObject.getJSONArray("colecoes").getJSONObject(i);
			ArrayList<Integer> cps = new ArrayList<>();
			for (int j = 0; j < colecoes.getJSONArray("cupons").length(); j++) {
				cps.add(colecoes.getJSONArray("cupons").getInt(j));
			}
			cadastraColecoes(colecoes.getString("nome"), colecoes.getString("categoria"), colecoes.getString("versao"), colecoes.getString("dataValidade"),
					colecoes.getString("dataInicio"), colecoes.getFloat("preco"), cps);
		}
	}
	
	private void cadastraEndereco(String rua, String cep, String numero, String bairro) {
		Endereco end = new Endereco();
		end.setRua(rua);
		end.setCEP(cep);
		end.setNumero(numero);
		end.setBairro(bairro);
		this.enderecos.add(end);
		this.bd.cadastrarEndereco(end);
	}
	
	private void cadastraJuridico(String nome, String cnpj, String tipo, int en) {
		Juridica j = new Juridica();
		j.setCnpj(cnpj);
		j.setNome(nome);
		j.setTipo(tipo);
		j.setEndereco(this.enderecos.get(en));
		this.juridicas.add(j);
		this.bd.cadastrarCliente(j);
	}

	private void cadastraFisico(String nome, String cpf, String email, String telefone, String senha, int en) {
		Fisica f = new Fisica();
		f.setCpf(cpf);
		f.setNome(nome);
		f.setEmail(email);
		f.setTelefone(telefone);
		f.setSenha(senha);
		f.setEndereco(this.enderecos.get(en));
		this.bd.cadastrarCliente(f);
	}

	private void cadastraCupom(String nome, String promocao, String tipo, boolean v, int i) {
		Cupom c = new Cupom();
		c.setNome(nome);
		c.setPromocao(promocao);
		c.setTipo(tipo);
		c.setValidado(v);
		c.setFornecedor(this.juridicas.get(i));
		this.cupons.add(c);
		this.bd.cadastrarCupom(c);
	}

	private void cadastraColecoes(String nome, String categoria, String versao, String df, String di, float v, ArrayList<Integer> cp)
			throws ParseException {
		ColecaoCupom c = new ColecaoCupom();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		c.setNome(nome);
		c.setCategoria(categoria);
		c.setVersao(versao);
		c.setDataValidade(sdf.parse(df));
		c.setDataInicio(sdf.parse(di));
		c.setPreco(v);
		for (Integer integer : cp) {
			c.addCupom(cupons.get(integer));
		}
		this.bd.cadastrarColecaoCupom(c);
	}
}
