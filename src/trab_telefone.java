import java.util.Locale;
import java.util.Scanner;

public class trab_telefone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Informe a quantidade de clientes: ");
		int n = sc.nextInt();
		double tiu = n;
		// VETORES
		String nome[] = new String[n];
		String tel[] = new String[n];
		int tipo[] = new int[n];
		int min[] = new int[n];
		double valor[] = new double[n];
		// MATRIZ
		double tipos[][] = new double[3][2];
		
		// PEGANDO INFORMACAO DOS CLIENTES
		for(int i = 0; i < n; i ++){
			System.out.printf("Dados do %do. cliente: %n", i+1);
			System.out.println("Nome: ");
			sc.nextLine();
			nome[i] = sc.nextLine();
			System.out.println("Telefone: ");
			tel[i] = sc.nextLine();
			System.out.println("Tipo: ");
			tipo[i] = sc.nextInt();
			System.out.println("Minutos: ");
			min[i] = sc.nextInt();
			System.out.println();
		}
		// PREENCHENDO A MATRIZ
		System.out.println("Informe o preco basico e excedente de cada tipo de conta:");
		for(int linha = 0; linha < 3; linha++) {
			System.out.println("Tipo " + linha + ": ");
			for(int col = 0; col < 2; col ++) {
				tipos[linha][col] = sc.nextDouble();
			}
		}
		// CONTA
		double conta[] = new double[n];
		double usar = 0.0;
		for(int i = 0; i < n; i ++) {
			usar = 0;
			if(tipo[i] == 0) {
				if(min[i] > 90) {
					usar = min[i] - 90;
					usar = usar * tipos[0][1];
				}
				conta[i] =  tipos[0][0] + usar;
			}
			if(tipo[i] == 1) {
				if(min[i] > 90) {
					usar = min[i] - 90;
					usar = usar * tipos[1][1];
				}
				conta[i] =  tipos[1][0] + usar;
			}
			if(tipo[i] == 2) {
				if(min[i] > 90) {
					usar = min[i] - 90;
					usar = usar * tipos[2][1];
				}
				conta[i] =  tipos[2][0] + usar;
			}
		}
		// CONTA MAIS BARATA
		int barata = 0;
		double menor = 100000000;
		for(int i = 0; i < n; i++) {
			if(menor > conta[i]) {
				menor = conta[i];
				barata = i;
			}
		}
		// CONTA TOTAL
		double cTotal = 0;
		for(int i = 0; i < n; i++) {
			cTotal = cTotal + conta[i];
		}
		// CONSUMO MEDIO TIPO 1
		double media = 0;
		int contP = 0;
		for(int i = 0; i < n; i ++) {
			if(tipo[i] == 1) {
				media = media + min[i];
				contP = contP + 1;
			}
		}
		media = media/contP;
		// QUANTIDADE DE CLIENTES QUE CONSUMIRAM > 120m
		int cont = 0;
		for(int i = 0; i < n; i ++) {
			if(min[i] > 120) {
				cont = cont + 1;
			}
		}
		// QUANTIDADE DE CLIENTES TIPO 2
		double cor2 = 0;
		for(int i = 0; i < n; i ++) {
			if(tipo[i] == 2) {
				cor2 ++;
			}
		}
		double per = ((cor2 / 100)/n)*10000;
		//MENU
		boolean menu = true;
		int opcao = 0;
		while(menu) {
			System.out.println();
			System.out.println("MENU DE OPCOES:");
			System.out.println("1) Relatório de clientes");
			System.out.println("2) A receita total");
			System.out.println("3) Conta foi mais barata");
			System.out.println("4) Consumo medio de clientes tipo 1.");
			System.out.println("5) Clientes que consumiram acima de 120 minutos");
			System.out.println("6) Porcentagem de clientes tipo 2");
			System.out.println("7) Sair");
			System.out.println("Informe uma opcao: ");
			opcao = sc.nextInt();
			System.out.println();
			if(opcao == 7) {
				menu = false;
				System.out.println("FIM DO PROGRAMA!");
			}
			if(opcao == 1) {
				for(int i = 0; i < n; i ++) {
					System.out.printf(nome[i]+", "+tel[i]+", Tipo "+tipo[i]+", Minutos: "+min[i]+", Conta = R$ %.2f%n",conta[i]);
				}
				System.out.println();
			}
			if(opcao == 2) {
				System.out.printf("Valor total R$: %.2f%n",cTotal);
				System.out.println();
			}
			if(opcao == 3) {
				System.out.printf("A conta mais barata foi do(a) " + nome[barata] + ", telefone: " + tel[barata]);
				System.out.println();
			}
			if(opcao == 4) {
				System.out.println("O Consumo medio dos clientes tipo 1 é de " + media);
				System.out.println();
			}
			if(opcao == 5) {
				System.out.println("Total de " + cont + " cliente(s)");
				System.out.println();
			}
			if(opcao == 6) {
				System.out.printf("Porcentagem de clientes tipo 2: %.1f%%%n", per);
				System.out.println();
			}
		}
		sc.close();
	}

}
