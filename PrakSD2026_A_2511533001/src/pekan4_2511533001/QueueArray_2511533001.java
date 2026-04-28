package pekan4_2511533001;

public class QueueArray_2511533001 {
	int front_3001, rear_3001, size_3001;
	int capacity_3001;
	int array_3001[];
	
	public QueueArray_2511533001 (int capacity_3001) {
		this.capacity_3001 = capacity_3001;
		front_3001 = this.size_3001 = 0;
		rear_3001 = capacity_3001 - 1;
		array_3001 = new int[this.capacity_3001];
	}
	
	boolean isFull_3001(QueueArray_2511533001 queue_3001) {
		return (queue_3001.size_3001 == queue_3001.capacity_3001);
	}
	boolean isEmpty_3001(QueueArray_2511533001  queue_3001) {
		return (queue_3001.size_3001 == 0);
	}
	
	void enqueue_3001 (int item) {
		if (isFull_3001(this))
			return;
		this.rear_3001 = (this.rear_3001 + 1) % this.capacity_3001;
		this.array_3001[this.rear_3001] = item;
		this.size_3001 = this.size_3001 + 1;
		System.out.println(item + "  enqueued to queue");
	}
	
	int dequeue_3001() {
		if (isEmpty_3001(this))
			return Integer.MIN_VALUE;
		int item = this.array_3001[this.front_3001];
		this.front_3001 =(this.front_3001 + 1) % this.capacity_3001;
		this.size_3001 = this.size_3001 - 1;
		return item;
	}
	int front_3001() {
		if (isEmpty_3001(this))
			return Integer.MIN_VALUE;
		
		return this.array_3001[this.rear_3001];
	}
	int rear_3001() {
		if (isEmpty_3001(this))
			return Integer.MIN_VALUE;
		return this.array_3001[this.rear_3001];
}
void display_3001() {
	int i;
	if (front_3001 == rear_3001) {
		System.out.printf("\nAntrian Kosong\n");
		return;
	}
	for (i = front_3001; i < rear_3001; i++) {
		System.out.printf(" %d <--", array_3001[i]);
	}
	return;
	}
}


