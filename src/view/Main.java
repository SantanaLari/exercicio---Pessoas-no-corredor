package view;

import java.util.concurrent.Semaphore;

import controller.threadPessoas;

public class Main {

	public static void main(String[] args) {
		
		int permissoes = 4;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int pessoa = 0; pessoa < 4; pessoa++) {
			Thread pessoas = new threadPessoas(pessoa, semaforo);
			pessoas.start();
		}

	}

}
