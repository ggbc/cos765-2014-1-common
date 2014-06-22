import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerSolution {

	public static Boolean full = false;

	public static void main(String args[]) {

		Vector sharedQueue = new Vector();
		int size = 4;		
		Thread producer = new Thread(new Producer(sharedQueue, size, full),
				"Produtor");
		Thread consumer = new Thread(new Consumer(sharedQueue, size, full),
				"Consumidor");
		producer.start();
		consumer.start();
	}
}

class Producer implements Runnable {

	private Vector buffer;
	private final int SIZE;

	public Producer(Vector buffer, int size, Boolean full) {
		this.buffer = buffer;
		this.SIZE = size;
		ProducerConsumerSolution.full = full;
	}

	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			try {
				//System.out.println("Produzido: " + i);				
				produce(i);				
				Thread.sleep(500);				
			} catch (InterruptedException ex) {
			}
		}
	}

	private void produce(int i) throws InterruptedException {

		while (buffer.size() == SIZE) {
			synchronized (buffer) {
				System.out.println("Buffer cheio. "
						+ Thread.currentThread().getName()
						+ " esperando, size: " + buffer.size());
				ProducerConsumerSolution.full = true;
				buffer.wait();
			}
		}

		// producing element and notify consumers
		synchronized (buffer) {
			buffer.add(i);
			buffer.notifyAll(); // só permite consumir quando esteve cheio em
								// algum momento
			System.out.println("P: " + buffer.toString());			
		}
	}
}

class Consumer implements Runnable {

	private Vector buffer;
	private final int SIZE;

	public Consumer(Vector buffer, int size, Boolean full) {
		this.buffer = buffer;
		this.SIZE = size;
		ProducerConsumerSolution.full = full;
	}

	@Override
	public void run() { 
		while (true) {
			try {
				if (ProducerConsumerSolution.full) // se nao testar vai tentar consumir toda hora 
//					System.out.println("Consumido: " + consume());
					consume();
				Thread.sleep(20);
			} catch (InterruptedException ex) {
			}
		}
	}

	private int consume() throws InterruptedException {
		// Se não ficou cheio ainda, espere 
		while (ProducerConsumerSolution.full == false) {
			synchronized (buffer) {
				System.out.println("Buffer ainda não encheu. "
						+ Thread.currentThread().getName()
						+ " esperando, size: " + buffer.size());
				buffer.wait();
			}
		}

		synchronized (buffer) {
						
			if (buffer.size() - 1 == 0)
				ProducerConsumerSolution.full = false;
			buffer.notifyAll();
			Integer i = (Integer) buffer.remove(0);
			System.out.println("C: " + buffer.toString());				
			return i;					
		}
	}
}
