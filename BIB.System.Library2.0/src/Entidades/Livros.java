package Entidades;

public class Livros {
	
		private int id_livro;
		private String nome;
		private String autor;
		private String ano_publi;
		private int copias_disp;

		public Livros() {
			
		}
		
		public Livros(int id_livro,String nome, String autor, String ano_publi, int copias_disp) {
			this.id_livro = id_livro;
			this.nome = nome;
			this.autor = autor;
			this.ano_publi = ano_publi;
			this.copias_disp = copias_disp;
		}
						
		public int getId_livro() {
			return id_livro;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public void setId_livro(int id_livro) {
			this.id_livro = id_livro;
		}

		public String toString() {
			return "Id: " + this.id_livro + "\n" +
					"Titulo: " + this.nome + "\n" +
					"Autor: "+ this.autor + "\n" +
					"Ano da publicacao: " + this.ano_publi + "\n" +
					"Numero de copias disponiveis: " + this.copias_disp + "\n" +
					"=====================" + '\n';	
		}

}
