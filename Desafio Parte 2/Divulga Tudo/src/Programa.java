import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		//Parte 1 - Cadastramento de an�ncios:
		Scanner entrada = new Scanner(System.in);
		
		String[] dados = new String[5];
		String dado = "";
		
		System.out.println("Digite o n�mero de an�ncios que ir� cadastrar: "); //para saber o n�mero m�ximo de loop para o "for"
		int numDeAnuncios = Integer.parseInt(entrada.next()); //coletando o dado digitado e o transformando em int
		
		Anuncio anuncio[] = new Anuncio[numDeAnuncios];
		//^^criando um objeto array da classe Anuncio, onde cada index do array cont�m um objeto da classe Anuncio^^
		
		String[] informacao = {"o nome", "o cliente", "a data de in�cio (DD/MM/YYYY)", "a data de t�rmino (DD/MM/YYYY)",
				"o valor investido por dia (em real)"};
		//^^array do tipo string para ajudar no cadastramento dos an�ncios^^
		
		//"for" para o cadastramento dos an�ncios. O "j" percorre cada an�ncio enquanto o "i" cada atributo que deve ter em um an�ncio:
		for (int j = 0; j<numDeAnuncios; j++) {
			int i = 0;
			while(i<5) {
				System.out.println("Sobre o An�ncio " + j +", digite " + informacao[i] + ":");
				dado = entrada.next();
				dados[i] = dado;
				i++;
			}
			//adicionando cada atributo no seu respectivo objeto an�ncio:
			anuncio[j] = new Anuncio();
			anuncio[j].setNome(dados);
			anuncio[j].setCliente(dados);
			anuncio[j].setDataInicio(dados);
			anuncio[j].setDataTermino(dados);
			anuncio[j].setInvestimentoPorDia(dados);
		}
		//Parte 2 - Gerando Relat�rios
		//cada relat�rio s� � feito quando solicitado. An�ncios sempre iniciam em zero
		System.out.println("Digite o n�mero correspondente ao An�ncio que deseja visualizar o relat�rio:\n(Lembrete: foi(foram) cadastrado(s) " +
				numDeAnuncios + " an�ncio(s), iniciando pelo An�ncio 0).");
		int relatorio = Integer.parseInt(entrada.next()); //coletando o dado digitado e o transformando em int
		
		System.out.println("====================== Relat�rio do An�ncio " + relatorio + ": =====================\n");
		System.out.println("Valor total investido: R$" + anuncio[relatorio].calculadora());
		
		
		//Parte 3 - Filtro, por cliente ou por intervalo de tempo:
		int opcao = 10;
		while (opcao != 0) {
			System.out.println("=====================================================================================\n");
			System.out.println("Se deseja filtrar os relat�rios por cliente (digite 1), por intervalo de tempo (digite 2). "
					+ "Para encerrar digite 0 (zero):");
			opcao = Integer.parseInt(entrada.next());
			
			if(opcao == 0) {
				System.out.println("============= Fim do programa ===============");
			} else if (opcao == 1) {	
				System.out.println("Digite o nome do cliente: ");
				String nomeCliente = entrada.next();
				
				for (int j=0; j<numDeAnuncios; j++) {
					if (nomeCliente.equals(anuncio[j].getCliente())) {
						System.out.println("====================== Relat�rio(s) filtrado(s) do cliente " + nomeCliente + ": =====================\n");
						System.out.println("Valor total investido: R$" + anuncio[j].calculadora());
					}
				}
				
			} else if (opcao == 2) {
				System.out.println("Digite uma data (DD/MM/YYYY): ");
				String data = entrada.next();
				
				for (int j=0; j<numDeAnuncios; j++) {
					if (data.equals(anuncio[j].getDataInicio()) || data.equals(anuncio[j].getDataTermino())) {
						System.out.println("====================== Relat�rio(s) filtrado(s) pela data " + data + ": =====================\n");
						System.out.println("Nome do Cliente: " + anuncio[j].getCliente());
						System.out.println("Valor total investido: R$" + anuncio[j].calculadora());
					} else {
						System.out.println("Data inserida n�o encontrada no An�ncio " + j);
					}
				}
			}
		}
		
		entrada.close();
	}
}