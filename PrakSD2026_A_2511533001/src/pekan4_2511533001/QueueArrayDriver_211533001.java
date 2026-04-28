package pekan4_2511533001;

public class QueueArrayDriver_211533001 {

	public static void main(String[] args) {
		QueueArray_2511533001 queue_3001 = new QueueArray_2511533001(1000);
		queue_3001.enqueue_3001(10);
		queue_3001.enqueue_3001(20);
		queue_3001.enqueue_3001(30);
		queue_3001.enqueue_3001(40);
		System.out.println("Item di depan "+ queue_3001.front_3001());
		System.out.println("Item dibelakang " +  queue_3001.rear_3001());
		System.out.println("tampilan queue");
		queue_3001.display_3001();
		System.out.println();
		System.out.println(queue_3001.dequeue_3001() + " dihapus dari queue");
		System.out.println("Item di depan "+ queue_3001.front_3001());
		System.out.println("Item dibelakang " +  queue_3001.rear_3001());
		System.out.println("tampilan queue setelah satu data dihapus");
		queue_3001.display_3001();
	}

}
