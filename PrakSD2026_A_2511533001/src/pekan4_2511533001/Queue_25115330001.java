package pekan4_2511533001;
	public class Queue_25115330001 {
	    int front_3001, rear_3001, max_3001;
	    String queue_3001[];

	    public Queue_25115330001(int max_3001) {
	        this.max_3001 = max_3001;
	        queue_3001 = new String[max_3001];
	        front_3001 = -1;
	        rear_3001 = -1;
	    }

	    public boolean isEmpty_3001() {
	        return (front_3001 == -1);
	    }

	    public boolean isFull_3001() {
	        return (rear_3001 == max_3001 - 1);
	    }

	    public void enqueue_3001(String data_3001) {
	        if (isFull_3001()) {
	            System.out.println("Antrian penuh");
	        } else {
	            if (isEmpty_3001()) {
	                front_3001 = 0;
	            }
	            rear_3001++;
	            queue_3001[rear_3001] = data_3001;
	            System.out.println("Data berhasil ditambahkan ke antrian");
	        }
	    }

	    public void dequeue_3001() {
	        if (isEmpty_3001()) {
	            System.out.println("Antrian kosong");
	        } else {
	            System.out.println(queue_3001[front_3001] + " telah dilayani");
	            if (front_3001 == rear_3001) {
	                front_3001 = rear_3001 = -1;
	            } else {
	                front_3001++;
	            }
	        }
	    }

	    public void display_3001() {
	        if (isEmpty_3001()) {
	            System.out.println("Antrian kosong");
	        } else {
	            System.out.println("Isi antrian:");
	            int no= 1;
	            for (int i = front_3001; i <= rear_3001; i++) {
	                System.out.println(no + ". " + queue_3001[i]);
	                no++;
	            }
	        }
	    }

	    public void reverse_3001() {
	        if (isEmpty_3001()) {
	            System.out.println("Antrian kosong!");
	        } else {
	            int start = front_3001;
	            int end = rear_3001;
	            while (start < end) {
	                String temp = queue_3001[start];
	                queue_3001[start] = queue_3001[end];
	                queue_3001[end] = temp;
	                start++;
	                end--;
	            }
	        }
	    }
	}