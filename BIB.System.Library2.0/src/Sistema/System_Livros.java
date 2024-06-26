package Sistema;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Entidades.DadoForaDoIntervalo;
import Entidades.Livros;
import Execoes.ID_invalido;

public class System_Livros {
	Scanner entrada = new Scanner(System.in);

	List<Livros> lista_livros = new ArrayList<>();

	Livros livro1 = new Livros(1, "Dom Casmurro", "Machado de Assis", "1899", 5);
	Livros livro2 = new Livros(2, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "1943", 7);
	Livros livro3 = new Livros(3, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "1997", 3);
	Livros livro4 = new Livros(4, "Cem Anos de Solidão", "Gabriel García Márquez", "1967", 2);

	public void addLivrosExistentes() {
		lista_livros.add(livro1);
		lista_livros.add(livro2);
		lista_livros.add(livro3);
		lista_livros.add(livro4);
	}

	public void criarNovoLivro(Scanner s) {
		boolean sucesso = false;
		while (!sucesso) {
			System.out.println("Informe os respectivos dados do livro: ");
			System.out.println("Id: " + "\n" + "Titulo: " + "\n" + "Autor: " + "\n" + "Ano da publicacao: " + "\n"
					+ "Numero de copias disponiveis: " + "\n" + "=====================" + '\n');

			try {
				int id = s.nextInt();
				verificaIdDuplicado(id);
				String nome = s.next();
				String autor = s.next();
				String anoPubli = s.next();
				int copiasDisp = s.nextInt();

				Livros novoLivro = new Livros(id, nome, autor, anoPubli, copiasDisp);
				addNovosLivros(novoLivro);
				sucesso = true;
				s.nextLine();
			} catch (InputMismatchException e) {
				s.nextLine(); // Evita um erro
				DadoForaDoIntervalo ex = new DadoForaDoIntervalo(); // Demonstra que a exceção existe
				System.out.println(ex.getMessage() + "\n");
			} catch (ID_invalido e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void addNovosLivros(Livros novoLivro) {
		lista_livros.add(novoLivro);
		organizaLista();
		visualizarLivros();
	}

	public void verificaIdDuplicado(int novoIdLivro) {
		if (lista_livros.stream().anyMatch(livro -> livro.getId_livro() == novoIdLivro)) {
			throw new ID_invalido(novoIdLivro);
		}
	}

	public void visualizarLivros() {
		for (Livros livros : lista_livros) {
			System.out.println(livros);
		}
	}

	public void removerLivro(Scanner s) {
		boolean sucesso = false;
		while (!sucesso) {
			System.out.println("Informe o ID do livro que sera removido: ");
			int id_escolhido = s.nextInt();

			Iterator<Livros> livros = lista_livros.iterator();

			if (!lista_livros.stream().anyMatch(id -> id.getId_livro() == id_escolhido)) { // Id não existe
				System.out.println("ID nao localizado!");
			} else {
				while (livros.hasNext()) { // Percorre a lista_livros
					Livros livro = livros.next(); // Captura o livro
					if (livro.getId_livro() == id_escolhido) {
						System.out.println("Livro selecionado: \n");
						System.out.println(livro);
						System.out.println("Deseja realmente exclui-lo? (S ou N)");

						if (s.next().equalsIgnoreCase("s")) {
							livros.remove();
							organizaLista();
							visualizarLivros();
							sucesso = true;
							s.nextLine();
							break;
						} else {
							System.out.println("Remoção cancelada. Tente novamente.");
							break;
						}
					}
				}
			}
		}
	}

	public void organizaLista() {
		for (int i = 0; i < lista_livros.size(); i++) {
			if ((i + 1) != lista_livros.get(i).getId_livro()) {
				lista_livros.get(i).setId_livro(i + 1);
			}
		}
	}

	public void buscar(Scanner s) {
		System.out.println("Informe o nome do livro:");
		String pesquisa = s.nextLine().toLowerCase();
		System.out.println(pesquisa); // Possivel problema com algum /n
	
		boolean encontrado = lista_livros.stream().anyMatch(livro -> livro.getNome().toLowerCase().contains(pesquisa));
				
	
			if (encontrado) {
				lista_livros.stream().filter(livro -> livro.getNome().toLowerCase().contains(pesquisa))
						.forEach(System.out::println);
			} else {
				System.out.println("Livro nao localizado!");
				buscar(s);
			}
		
		
		

	}

} // Próxima Tesk adicionar a movimentação do método buscar 
