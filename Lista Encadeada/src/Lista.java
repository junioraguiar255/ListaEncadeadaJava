import java.util.Scanner;

public class Lista {

	private Nodo prim;
	Scanner leitor = new Scanner(System.in);

	public void criaLista() { //cria lista nula
		prim = null;
	}
	
	public boolean verificaExiste(String i) { // verifica se um cadastro já existe
		for (Nodo n = prim; n != null; n = n.getProx()) {
			if (n.getInfo().equals(i)) {
				return true;
			}
		}
		return false;
	}

	public void add(String i) { // add um elemento
		Nodo novo = new Nodo();
		novo.setInfo(i);
		novo.setProx(prim);
		prim = novo;
	}

	public void imprime() { // imprime toda a lista
		for (Nodo n = prim; n != null; n = n.getProx()) {
			System.out.println(n.getInfo());
		}
	}

	public boolean ehVazio() { //verifica se a lista está vazia
		if (prim == null)
			return true;
		else
			return false;
	}

	public Nodo procura(String i) { // procura por determinado elemento
		for (Nodo n = prim; n != null; n = n.getProx()) {
			if (n.getInfo().equals(i)) {
				return n;
			}
		}
		return null; /* nao achou o elemento */
	}

	public void altera(String i) { // altera um elemento
		for (Nodo n = prim; n != null; n = n.getProx()) {
			if (n.getInfo().equals(i)) {

				System.out.println("Digite o valor:");
				String p = leitor.nextLine();
				n.setInfo(p);
				System.out.println("Valor alterado");
			}
		}
		/* nao achou o elemento */
	}

	public void remove(String i) { // remove um elemento da lista
		/* objeto para o elemento anterior */
		Nodo anterior = null;
		/* objeto para percorrer a lista */
		Nodo p = prim;

		/* procura elemento na lista, guardando anterior */
		while (p != null && p.getInfo() != i) {
			anterior = p;
			p = p.getProx();
		}

		/* verifica se achou elemento */
		if (p == null) {
			/* nao achou: mantem prim da forma como estah */
			return;
		}

		/* retira elemento */
		if (anterior == null) {
			/* retira elemento do inicio */
			prim = p.getProx();
		} else {
			/* retira elemento do meio da lista */
			anterior.setProx(p.getProx());
		}
	}

	public void addOrdenado(String i) { // add ordenado
		Nodo novo;
		/* objeto para o elemento anterior */
		Nodo anterior = null;
		/* objeto para percorrer a lista */
		Nodo p = prim;

		int result = 0;
		if(!(p==null)) {
			result = p.getInfo().compareTo(i);
		}
		
		
		/* procura elemento na lista, guardando anterior */
		while (p != null && result < 0) {
			anterior = p;
			p = p.getProx();
		}

		/* cria novo elemento */
		novo = new Nodo();
		novo.setInfo(i);

		/* encadeia o elemento */
		if (anterior == null) { /* inseri o elemento no inicio */
			novo.setProx(prim);
			prim = novo;
		} else { /* inseri elemento no meio da lista */
			novo.setProx(anterior.getProx());
			anterior.setProx(novo);
		}
	}

}
