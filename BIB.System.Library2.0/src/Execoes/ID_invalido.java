package Execoes;

@SuppressWarnings("serial")
public class ID_invalido extends RuntimeException {
	private int id_livro;

	public ID_invalido(int id_livro) {
		this.id_livro = id_livro;
	}
	
	public String getMessage() {
		return String.format("Id inserido %s duplicado!", id_livro);
	}
}
