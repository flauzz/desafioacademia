import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		//Parte 1 - Cadastramento de anúncios:
		Scanner entrada = new Scanner(System.in);
		
		String[] dados = new String[5];
		String dado = "";
		
		System.out.println("Digite o número de anúncios que irá cadastrar: "); //para saber o número máximo de loop para o "for"
		int numDeAnuncios = Integer.parseInt(entrada.next()); //coletando o dado digitado e o transformando em int
		
		Anuncio anuncio[] = new Anuncio[numDeAnuncios];
		//^^criando um objeto array da classe Anuncio, onde cada index do array contém um objeto da classe Anuncio^^
		
		String[] informacao = {"o nome", "o cliente", "a data de início (DD/MM/YYYY)", "a data de término (DD/MM/YYYY)",
				"o valor investido por dia (em real)"};
		//^^array do tipo string para ajudar no cadastramento dos anúncios^^
		
		//"for" para o cadastramento dos anúncios. O "j" percorre cada anúncio enquanto o "i" cada atributo que deve ter em um anúncio:
		for (int j = 0; j<numDeAnuncios; j++) {
			int i = 0;
			while(i<5) {
				System.out.println("Sobre o Anúncio " + j +", digite " + informacao[i] + ":");
				dado = entrada.next();
				dados[i] = dado;
				i++;
			}
			//adicionando cada atributo no seu respectivo objeto anúncio:
			anuncio[j] = new Anuncio();
			anuncio[j].setNome(dados);
			anuncio[j].setCliente(dados);
			anuncio[j].setDataInicio(dados);
			anuncio[j].setDataTermino(dados);
			anuncio[j].setInvestimentoPorDia(dados);
		}
		//Parte 2 - Gerando Relatórios
		//cada relatório só é feito quando solicitado. Anúncios sempre iniciam em zero
		System.out.println("Digite o número correspondente ao Anúncio que deseja visualizar o relatório:\n(Lembrete: foi(foram) cadastrado(s) " +
				numDeAnuncios + " anúncio(s), iniciando pelo Anúncio 0).");
		int relatorio = Integer.parseInt(entrada.next()); //coletando o dado digitado e o transformando em int
		
		System.out.println("====================== Relatório do Anúncio " + relatorio + ": =====================\n");
		System.out.println("Valor total investido: R$" + anuncio[relatorio].calculadora());
		
		
		//Parte 3 - Filtro, por cliente ou por intervalo de tempo:
		int opcao = 10;
		while (opcao != 0) {
			System.out.println("=====================================================================================\n");
			System.out.println("Se deseja filtrar os relatórios por cliente (digite 1), por intervalo de tempo (digite 2). "
					+ "Para encerrar digite 0 (zero):");
			opcao = Integer.parseInt(entrada.next());
			
			if(opcao == 0) {
				System.out.println("============= Fim do programa ===============");
			} else if (opcao == 1) {	
				System.out.println("Digite o nome do cliente: ");
				String nomeCliente = entrada.next();
				
				for (int j=0; j<numDeAnuncios; j++) {
					if (nomeCliente.equals(anuncio[j].getCliente())) {
						System.out.println("====================== Relatório(s) filtrado(s) do cliente " + nomeCliente + ": =====================\n");
						System.out.println("Valor total investido: R$" + anuncio[j].calculadora());
					}
				}
				
			} else if (opcao == 2) {
				System.out.println("Digite uma data (DD/MM/YYYY): ");
				String data = entrada.next();
				
				for (int j=0; j<numDeAnuncios; j++) {
					if (data.equals(anuncio[j].getDataInicio()) || data.equals(anuncio[j].getDataTermino())) {
						System.out.println("====================== Relatório(s) filtrado(s) pela data " + data + ": =====================\n");
						System.out.println("Nome do Cliente: " + anuncio[j].getCliente());
						System.out.println("Valor total investido: R$" + anuncio[j].calculadora());
					} else {
						System.out.println("Data inserida não encontrada no Anúncio " + j);
					}
				}
			}
		}
		
		entrada.close();
	}
}