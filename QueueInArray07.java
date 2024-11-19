/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queueinarray;

/**
 *
 * @author FYPLAB-IMAC-17
 */
public class QueueInArray {
    int front, size , capacity;
    int array[];
    public QueueInArray(int length){
        capacity=length;
        front=size=0;
        array=new int[capacity];
    }
    boolean isFull(){
        return (size==capacity);

    }
    boolean isEmpty(){
        return (size==0);
    }
    void enqueue(int item){
        if (isFull())
            return;
        int pos;
        pos=(front+size)%capacity;
        array[pos]=item;
        size=size+1;
        System.out.println(item+"enqueued to queue");
    }
    int dequeue(){
        if (isEmpty())
            return 0;
        int item= array[front];
        front=(front+1)%capacity;
        size=size-1;
        return item;
    }
    int front(){
        if(isEmpty())
            return 0;
        return array[front];
    }
}
class Lab07
{
    public static void main(String[]args){
        QueueInArray q=new QueueInArray(10);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        System.out.println(""+q.size);
        q.enqueue(77);
        System.out.println(q.dequeue()+"dequeue from queue\n");
        System.out.println("front item is"+q.front);

    }
 }
public class QueueInLinkedList {
    private Node front;
    private Node rear;
    static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public boolean isEmpty(){
        return (front==null);
    }
    public void insertLast(int new_data){
        Node new_node=new Node(new_data);
        if(isEmpty())
            front=new_node;
        else
            rear.next=new_node;
        rear=new_node;
    }

    public int deleteFirst(){
        int temp= front.data;
        if(front.next==null)
            rear=null;
        front=front.next;
        return temp;
    }

    void displayList(){
        System.out.println("====displaying elements of DEQ====");
        Node current=front;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }
}
class Queue_2{
    QueueInLinkedList llist;
    public Queue_2(){
        llist =new QueueInLinkedList();
    }
    public boolean isEmpty(){
        return llist.isEmpty();
    }
    public void enqueue(int new_data){
        llist.insertLast(new_data);
    }
    public int deque(){
        return llist.deleteFirst();
    }
    void printQueue(){
        llist.displayList();
    }
}
class QueueClient{
    public static void main(String[]args){
        Queue_2 list=new Queue_2();
        list.enqueue(10);
        list.enqueue(20);
        list.enqueue(30);
        list.enqueue(40);
        list.printQueue();
        list.deque();
        list.printQueue();
    }
}