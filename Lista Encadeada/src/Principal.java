
public class Principal {

	public static void main(String[] args) {

		Lista lista = new Lista();
		lista.criaLista();
		lista.addOrdenado("XOI 5316");
		lista.addOrdenado("OXT 1231");
		lista.addOrdenado("BUO 1245");
		//lista.altera("Josemar");
		lista.imprime();
		System.out.println(lista.ehVazio());
		
	}

}
