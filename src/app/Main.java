package app;

import java.text.ParseException;
import java.util.Date;

import org.json.JSONException;

import entities.Compra;
import entities.ConexaoBD;
import entities.Fisica;
import entities.PagamentoCartao;
import util.LeitorDados;

public class Main {

	public static void main(String[] args) throws JSONException, ParseException {
		// TODO Auto-generated method stub
		ConexaoBD bd = new ConexaoBD();
		LeitorDados l = new LeitorDados(bd);
		l.lerArquivo();
		Fisica f = new Fisica();
		f = (Fisica) bd.buscarClienteNome("Henry Emanuel Rafael Santos").get(0);
		f.setConexaoBD(bd);
		Compra compra = new Compra();
		compra.setFisica(f);
		compra.adicionaColecao(bd.buscarColecaoCupomCategoria("Restaurante").get(0), 1);
		//compra.listaItensCompra();
		PagamentoCartao pc = new PagamentoCartao();
		pc.setBandeira("Mastercard");
		pc.setValor(bd.buscarColecaoCupomCategoria("Restaurante").get(0).getPreco());
		pc.setPago(true);
		pc.setNroCartao("445522336699887744");
		pc.setDataLimite(new Date(System.currentTimeMillis()));
		compra.setConexaoBD(bd);
		compra.finalizarCompra(pc);
		//System.out.println(f.buscarColecaoComprado());
		System.out.println(f.usarCupom(f.buscarColecaoComprado().get(0).getCupons().get(0)));
		
	}

}
