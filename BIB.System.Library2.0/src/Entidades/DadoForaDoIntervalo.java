package Entidades;

@SuppressWarnings("serial")
public class DadoForaDoIntervalo extends RuntimeException {

	public String getMessage() {
		return "Entrada invalida.\nA entrada anterior deve ser um numero inteiro.\n";
	}
}
