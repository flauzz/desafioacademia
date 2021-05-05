package controle.desafios;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		
		/*
		 * Parte 0 - Coletar o valor investido pela ag�ncia Divulga Tudo atrav�s do Scanner,
		 * substituir a v�rgula por ponto (caso digitada) para evitar erro,
		 * guardar e converter o valor investido de string para double
		 * e guardar as taxas de cliques e compartilhamento:
		 */
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite o valor investido em reais: ");
		
		String pontoVirgula = entrada.next().replace(",", ".");
		double valorInvestido = Double.parseDouble(pontoVirgula);
		
		double taxaCliques = (double) 12/100; //12% das visualiza��es geram cliques
		double taxaCompartilhamento = (double) 3/20; //15% dos cliques geram compartilhamento
		
		/*
		 * Parte 1 - A partir do valor investido, c�lculo do n�mero de visualiza��es antes de qualquer compartilhamento,
		 * c�lculo do n�mero de cliques gerados antes de qualquer compartilhamento,
		 * c�lculo do n�mero de pessoas que compartilharam o an�ncio original (compartilhamento prim�rio)
		 * e a primeira camada de visualiza��es ap�s o compartilhamento desse n�mero de pessoas:
		 */

		int visualizacaoNaoCompartilhado = (int) Math.round(30*valorInvestido);
		//^^arredondando e deixando o valor inteiro (evitar ocorr�nca de visualiza��es quebradas)^^
		
		int cliquesGeradosSemCompartilhamento = (int) Math.round(taxaCliques*visualizacaoNaoCompartilhado);
		//^^arredondando e deixando o valor inteiro (evitar ocorr�nca de cliques quebrados)^^
		
		int pessoasQueCompartilharamPrimario = (int) Math.round(cliquesGeradosSemCompartilhamento*taxaCompartilhamento);
		//^^arredondando e deixando o valor inteiro (evitar ocorr�nca de compartilhamentos quebrados)^^
		
		int visualizacaoPosCompartilhamento = pessoasQueCompartilharamPrimario*40;
		
		/*
		 * Parte 2 - Ap�s a primeira camada de visualiza��es, c�lculo das camadas seguintes(compartilhamento secund�rio):
		 * Considerando que cada pessoa da primeira camada gere mais tr�s compartilhamentos
		 * (um total de 4 compartilhamentos sequenciais para cada pessoa da primeira camada)
		 * empregou-se o primeiro "for" para esses tr�s compartilhamentos secund�rios (i<3)
		 * e o segundo "for" para o n�mero de pessoas da primeira camada (j<pessoasQueCompartilharamPrimario).
		 * Com isso, calculou-se o n�mero de visualiza��es ap�s os compartilhamentos prim�rios:
		 */
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<pessoasQueCompartilharamPrimario; j++) {
				visualizacaoPosCompartilhamento = visualizacaoPosCompartilhamento + 40;
			}
		}
		
		/*
		 * Parte 3 - C�lculo da proje��o do n�mero de visualiza��es do an�ncio:
		 */
		
		int visualizacaoProjecao = visualizacaoNaoCompartilhado+visualizacaoPosCompartilhamento;
		
		/*
		 * Parte 4 - Informa��o da proje��o aproximada do n�mero de visualiza��es que o an�ncio ter� (an�ncio original + compartilhamentos)
		 * de acordo com o valor investido inserido no in�cio do texto:
		 */
		
		System.out.println("Proje��o aproximada de pessoas que visualizar�o esse mesmo an�ncio: " + visualizacaoProjecao);
		entrada.close();
	}
}