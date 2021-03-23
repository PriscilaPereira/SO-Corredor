package view;

import java.util.concurrent.Semaphore;

import controller.Pessoas;

public class Corredor {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idPessoa = 0; idPessoa<4; idPessoa++) {
			Thread tPessoa = new Pessoas(idPessoa, semaforo);
			tPessoa.start();

	}

}
}