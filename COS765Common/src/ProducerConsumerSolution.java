import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerSolution {

	public static Boolean full = false;

	public static void main(String args[]) {

		Vector sharedQueue = new Vector();
		int size = 4;
		Thread producer = new Thread(new Producer(sharedQueue, size, full),
				"Producer");
		Thread consumer = new Thread(new Consumer(sharedQueue, size, full),
				"Consumer");
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
				System.out.println("Produced: " + i);				
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
				if (ProducerConsumerSolution.full)
					System.out.println("Consumed: " + consume());
				Thread.sleep(20);
			} catch (InterruptedException ex) {
			}
		}
	}

	private int consume() throws InterruptedException {

		// wait if queue is empty
		while (buffer.isEmpty()) {
			synchronized (buffer) {
				System.out.println("Buffer vazio. "
						+ Thread.currentThread().getName()
						+ " esperando, size: " + buffer.size());
				ProducerConsumerSolution.full = false;
				buffer.wait();
			}
		}

		synchronized (buffer) {
			buffer.notifyAll();
			return (Integer) buffer.remove(0);
		}
	}
}
