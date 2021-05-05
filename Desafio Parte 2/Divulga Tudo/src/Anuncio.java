import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Anuncio {
	private String nome;
	private String cliente;
	private String dataInicio;
	private String dataTermino;
	private double investimentoPorDia;

	//método criado a partir da 1ª parte do desafio proposto pela Academia, com algumas adaptações:
	public String calculadora() {
		//Coletar a data Início e Término do objeto criado a partir dessa classe e as transformar em um formato data
		//Com elas no formato data, pegar a diferência em dias entre elas com o "compareTo" e então calcular o total investido no anúncio:
		DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataConvertida1 = LocalDate.parse(this.getDataInicio(), formato1);
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataConvertida2 = LocalDate.parse(this.getDataTermino(), formato2);
		
		int diferenca = dataConvertida2.compareTo(dataConvertida1);
		double totalInvestido = this.investimentoPorDia*diferenca;
		String valorTotalInvestido = String.format("%.2f", (this.investimentoPorDia*diferenca)); //formatando para visualização final
		
		double taxaCliques = (double) 12/100;
		double taxaCompartilhamento = (double) 3/20;
		

		int visualizacaoNaoCompartilhado = (int) Math.round(30*totalInvestido);
		
		int cliquesGeradosSemCompartilhamento = (int) Math.round(taxaCliques*visualizacaoNaoCompartilhado);
		
		int pessoasQueCompartilharamPrimario = (int) Math.round(cliquesGeradosSemCompartilhamento*taxaCompartilhamento);
		
		int visualizacaoPosCompartilhamento = pessoasQueCompartilharamPrimario*40;
		
		int cliquesGeradosPosCompartilhamento = 0;
		int pessoasQueCompartilharamSecundario = 0;
		for (int i=0; i<3; i++) {
			for (int j=0; j<pessoasQueCompartilharamPrimario; j++) {
				visualizacaoPosCompartilhamento = visualizacaoPosCompartilhamento + 40;
				cliquesGeradosPosCompartilhamento = (int) Math.round(visualizacaoPosCompartilhamento*taxaCliques);
				pessoasQueCompartilharamSecundario = (int) Math.round(cliquesGeradosPosCompartilhamento*taxaCompartilhamento); 
			}
		}
		
		int visualizacaoProjecao = visualizacaoNaoCompartilhado+visualizacaoPosCompartilhamento;
		
		System.out.println("Quantidade máxima de visualizações: " + visualizacaoProjecao);
		System.out.println("Quantidade máxima de cliques: " + (cliquesGeradosSemCompartilhamento+cliquesGeradosPosCompartilhamento));
		System.out.println("Quantidade máxima de compartilhamentos: " + (pessoasQueCompartilharamPrimario+pessoasQueCompartilharamSecundario));
		
		return valorTotalInvestido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String[] nome) {
		this.nome = nome[0];
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String[] cliente) {
		this.cliente = cliente[1];
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String[] dataInicio) {
		this.dataInicio = dataInicio[2];
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String[] dataTermino) {
		this.dataTermino = dataTermino[3];
	}

	public double getInvestimentoPorDia() {
		return investimentoPorDia;
	}

	public void setInvestimentoPorDia(String[] investimentoPorDia) {
		String pontoVirgula = investimentoPorDia[4].replace(",", ".");
		this.investimentoPorDia = Double.parseDouble(pontoVirgula);
	}
}