package controller;

import java.util.concurrent.Semaphore;

public class threadPessoas extends Thread {
	
	private int pessoa;
	private Semaphore semaforo;
	public static int tamanhoCorredor = 200;
	
	public threadPessoas(int pessoa, Semaphore semaforo){
		this.pessoa = pessoa;
		this.semaforo = semaforo;
	}
	
	public void run() {
		corredor();
		try {
			semaforo.acquire();
			abrirPorta();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
			cruzar();
		}
	}
	
	public void corredor() {
		int espaçoPercorrido = 0;
		
		while(espaçoPercorrido <= tamanhoCorredor) {
			int passosDaPessoa = (int)((Math.random()*3)+4);	
			System.out.println("#" + pessoa + " andou: " + passosDaPessoa + " metros.");
			
			espaçoPercorrido += passosDaPessoa;
		}
	}
	
	public void abrirPorta() {
		int tempo = (int)((Math.random()*2)+1);
		System.out.println("#" + pessoa + " levou " + tempo + "s. Para abrir a porta");
	}
	
	public void cruzar() {
		System.out.println("#" + pessoa + " cruzou a porta");
	}
	
}
