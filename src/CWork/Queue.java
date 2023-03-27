package CWork;

//reference  - https://www.programiz.com/java-programming/examples/queue-implementation
public class Queue {
    int Size = 3; // Size of Circular Queue
    int infront, back;
    Passenger[] pass = new Passenger[Size];

    Queue() {
        infront = -1;
        back = -1;
    }

    // Check if the queue is full
    boolean isFull1() {
        if (infront == 0 && back == Size - 1) {
            return true;
        }
        else return infront == back + 1;
    }

    // Check if the queue is empty
    boolean isEmpty() {
        return infront == -1;
    }


    //Enqueue: Inserts an item at the rear of the queue.
    void enQueue(Passenger element) {
        if (isFull1()) {
            System.out.println("Queue is full");
        } else {
            if (infront == -1)
                infront = 0;
            back = (back + 1) % Size;
            pass[back] = element;
            System.out.println("Inserted " + element.getfname());
        }
    }

    //Dequeue: Removes the object from the front of the queue and returns it, thereby decrementing queue size by one.
    Passenger deQueue() {
        Passenger Pa=new Passenger(0,null,null);
        Passenger element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Pa;
        } else {
            element = pass[infront];
            if (infront == back) {
                infront = -1;
                back = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */
            else {
                infront = (infront + 1) % Size;
            }
            return (element);
        }
    }

    void display() {
        /* Function to display status of Circular Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {

            for (i = infront; i != back; i = (i + 1) % Size)
                System.out.print(pass[i].getfname() + " ");
            System.out.println(pass[i].getfname());

        }
    }

    public static class Passenger {
        int expense;
        String fname;
        String sname;

        public Passenger() {
        }

        public Passenger( int expenses, String fname, String sname) {
            this.fname = fname;
            this.sname = sname;
            expense = expenses;
        }


        public int getexpense() {
            return expense;
        }

        public void setexpense(int expenses) {
            expense = expenses;
        }

        public String getfname() {
            return fname;
        }

        public void setfname (String fname) {
            this.fname = fname;
        }

        public String getsname() {
            return sname;
        }

        public void setsname(String sname) {
            this.sname = sname;
        }
    }
}
