package main.java.fachadaparadao;

import main.java.dao.ConcreteDAOConfiguracoesDeJogoArquivos;
import main.java.dao.ConcreteDAOListaDePalavrasArquivos;
import main.java.dao.ConcreteDAOPalavrasDeListaArquivos;
import main.java.dao.ConcreteDAORankingArquivos;
import main.java.dao.InterfaceDAOConfiguracoesDeJogo;
import main.java.dao.InterfaceDAOListaDePalavras;
import main.java.dao.InterfaceDAOPalavrasDeLista;
import main.java.dao.InterfaceDAORanking;
import main.java.jogo.PalavrasETraducoes;

public class FachadaDAO 
{
	private static FachadaDAO singletonFachadaDAO;
	private InterfaceDAOConfiguracoesDeJogo acessaConfiguracoesJogo;
	private InterfaceDAOListaDePalavras acessaListasDePalavras;
	private InterfaceDAOPalavrasDeLista acessaPalavrasDeLista;
	private InterfaceDAORanking acessaRanking;
	
	
	private FachadaDAO()
	{
		this.acessaConfiguracoesJogo = new ConcreteDAOConfiguracoesDeJogoArquivos();
		this.acessaListasDePalavras = new ConcreteDAOListaDePalavrasArquivos();
		this.acessaPalavrasDeLista = new ConcreteDAOPalavrasDeListaArquivos();
		this.acessaRanking = new ConcreteDAORankingArquivos();
	}
	
	public synchronized static FachadaDAO getFachadaDAO()
	{
		if(singletonFachadaDAO == null)

		{
			singletonFachadaDAO = new FachadaDAO();
		}
		
		return singletonFachadaDAO;
	}
	
	public String [] lerConfiguracoesJogo()
	{
		return this.acessaConfiguracoesJogo.lerConfiguracoesJogo();
	}
	
	public void setarNovasConfiguracoesJogo(int tempoParaSetarBomba, int tempoParaBombaExplodir)
	{
		this.acessaConfiguracoesJogo.setarNovasConfiguracoesJogo(tempoParaSetarBomba, tempoParaBombaExplodir);
	}
	
	public boolean criarNovaListaPalavras(String nomeLista)
	{
		return this.acessaListasDePalavras.criarNovaListaPalavras(nomeLista);
	}
	
	public boolean removerListaPalavras(String nomeLista)
	{
		return this.acessaListasDePalavras.removerListaPalavras(nomeLista);
	}
	
	public boolean limparListaPalavras(String nomeLista)
	{
		return this.acessaListasDePalavras.limparListaPalavras(nomeLista);
	}
	
	public String [] extrairNomesDeTodasAsListasDePalavras()
	{
		return this.acessaListasDePalavras.extrairNomesDeTodasAsListasDePalavras();
	}
	
	public boolean listaDePalavrasJahExiste(String nomeLista)
	{
		return this.acessaListasDePalavras.listaDePalavrasJahExiste(nomeLista);
	}
	
	public boolean mudarListaASerUsadaNoJogo(String nomeLista)
	{
		return this.acessaListasDePalavras.mudarListaASerUsadaNoJogo(nomeLista);
	}
	
	public String pegarNomeListaASerUsadaNoJogo()
	{
		return this.acessaListasDePalavras.pegarNomeListaASerUsadaNoJogo();
	}
	
	public PalavrasETraducoes extrairPalavrasETraducoes(String listaOndeEstaoOsDados)
	{
		return this.acessaPalavrasDeLista.extrairPalavrasETraducoes(listaOndeEstaoOsDados);
	}
	
	public boolean adicionarNovaPalavraNaLista(String nomeLista, String palavraNova, String traducaoNova)
	{
		return this.acessaPalavrasDeLista.adicionarNovaPalavraNaLista(nomeLista, palavraNova, traducaoNova);
	}
	
	public void removerPalavraDaLista(String nomeDalista, String traducaoDaPalavraASerRemovida)
	{
		this.acessaPalavrasDeLista.removerPalavraDaLista(nomeDalista, traducaoDaPalavraASerRemovida);
	}
	
	public void inserirJogadorRanking(String nomeJogador, int pontuacao)
	{
		this.acessaRanking.inserirJogadorRanking(nomeJogador, pontuacao);
	}
	
	public String[] lerRanking()
	{
		return this.acessaRanking.lerRanking();
	}
}
