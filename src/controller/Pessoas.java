package controller;	

	import java.util.concurrent.Semaphore;

	public class Pessoas extends Thread {
		
		private int idPessoa;
		private static int posChegada;
		private static int posSaida;
		private Semaphore semaforo;
		
		public Pessoas(int idPessoa, Semaphore semaforo){
			this.idPessoa = idPessoa;
			this.semaforo = semaforo;
			
		}
		@Override
		public void run() {
			pessoaAndando();
			try {
				semaforo.acquire();
				pessoaEspera();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
			
			semaforo.release();
			pessoaPorta();
			
			}
		}
		
		private void pessoaPorta() {
			posSaida++;
			System.out.println("# "+idPessoa+"foi a"+posSaida+"o. a fechar a porta");

		}
		private void pessoaEspera() {
			System.out.println("# "+idPessoa+" abriu a porta");
			int tempo = (int)((Math.random()*1001)+1000);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}
		private void pessoaAndando() {
			int distanciaT = 200;
			int distanciaP = 0;
			int desloca = (int)((Math.random()*4)+2);
			int tempo = 1000;
			while(distanciaP<distanciaT){
				distanciaP += desloca;
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("# "+idPessoa+"ja andou"+distanciaP+"m.");
			}
			posChegada++;
			System.out.println("#"+idPessoa+"foi a"+posChegada+"o. a chegar");

			
		}
	}