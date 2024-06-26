package Sistema;

import java.util.InputMismatchException;
import java.util.Scanner;

import Entidades.DadoForaDoIntervalo;

public class System_Movi {
	System_Livros livros = new System_Livros();
	
	String bv = "Bem-Vindo a biblioteca virtual!";
	
	String moviA = "Informe sua acao: \n"
            + "[1] - Vizualizar Livros\n" +
            "[2] - Adicionar Livros\n" +
            "[3] - Remover livros";
	
	String moviB = "Informe sua acao: \n"
            + "[1] - Adicionar Livros\n" +
            "[2] - Remover livros\n" +
            "[3] - Buscar um livro\n" +
            "[4] - Sair";
	 
	public void movi1(Scanner sc) {
		livros.addLivrosExistentes();
		
		System.out.println(bv);
		
		boolean entradaValida = false;
		
		while(!entradaValida) {
			System.out.println(moviA);
			try {
		        int opcao = sc.nextInt();
		        entradaValida = true;

		        switch (opcao) {
		            case 1:
		                livros.visualizarLivros();
		                System.out.println(moviB);
		                movi2(sc);
		                break;
		            case 2:
		                livros.criarNovoLivro(livros.entrada);
		                System.out.println(moviB);
		                movi2(sc);
		                break;
		            case 3:
		                livros.removerLivro(livros.entrada);
		                System.out.println(moviB);
		                movi2(sc);
		                break;
		            default: 
		                System.out.println("Opcao invalida!");
		    	        movi1(sc);
		                break;
		        }        
			} catch (InputMismatchException e) {  
				sc.nextLine(); // Evita um erro
	            DadoForaDoIntervalo ex = new DadoForaDoIntervalo(); // Demonstra que a exceção existe
	            System.out.println(ex.getMessage());
			} 
		}
		
		
}
	
	public void movi2(Scanner sc) { 
		
		boolean entradaValida = false;
		
		while (!entradaValida) {
			try {
				int opcao = sc.nextInt();
				entradaValida = true;
				
				switch (opcao) {
				case 1:
					livros.criarNovoLivro(livros.entrada);
					System.out.println(moviB);
					movi2(sc);
					break;
				case 2:
					livros.removerLivro(livros.entrada);
					System.out.println(moviB);
					movi2(sc);
					break;
				case 3:
					livros.buscar(livros.entrada);
					System.out.println(moviB);
					movi2(sc);
					break;
				case 4:
					System.out.println("Saindo do sistema......");
					break;
				default:
					System.out.println("Opção inválida");
					movi2(sc);
					break;
				}
			} catch (InputMismatchException e) { 
				sc.nextLine(); // Evita um erro
	            DadoForaDoIntervalo ex = new DadoForaDoIntervalo(); // Demonstra que a exceção existe
	            System.out.println(ex.getMessage());
	            
	            System.out.println(moviB);
			} 
		}
        
	}	
}
