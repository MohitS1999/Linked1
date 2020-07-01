import java.util.*;
class Node{
	int data;
	Node next;
}

public class Linked1{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		LinkedList list=new LinkedList();
		System.out.println("Enter the size of linked list");
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			list.insert(sc.nextInt());
		}
		//list.insertAtStart(2343);
		System.out.println("------------");
		//list.show();
		// list.insertAt(5,34);
		// list.deleteAt(3);
//list.insertAtSort(18);
		 // list.removeDuplicacy();
		// list.reverse(list.count());
		System.out.println("------------");
		list.show();
		if (list.isSorted()==true){
			System.out.println("LINKED LIST is sorted");
		}
		else{
			System.out.println("LINKED LIST is  not sorted");
		}
		list.findMiddle();
		// list.search(5);
		 // list.count();
		// list.sum();
		// list.max();
	}
}

class LinkedList{
	Node head;
	public void insert(int data){
		Node node=new Node();
		node.data=data;
		node.next=null;
		if (head==null){
			head=node;
		}
		else{
			Node n=head;
			while (n.next!=null){
				n=n.next;
			}
			n.next=node;
		}
	}
	public void insertAtStart(int data){
		Node node=new Node();
		node.data=data;
		node.next=null;
		node.next=head;
		head=node;
	}
	public void insertAt(int index,int data){
		Node node=new Node();
		node.data=data;
		node.next=null;
		Node n=head;
		if (index==0){
			insertAtStart(data);
		}
		else{
			for(int i=0;i<index-1;i++){
				n=n.next;
				//if index value is greater than size of linked list
				if (n==null)
					return;
			}
			node.next=n.next;
			n.next=node;
		}
	}
	public void deleteAt(int index){
		Node n=head;
		Node n1=null;
		if (index==0){
			head=head.next;
		}
		else{
			for(int i=0;i<index-1;i++){
				n=n.next;
			}
			 n1=n.next;
			n.next=n1.next;
			n1=null;
		}
	}
	public void show(){
		Node n=head;
		while (n.next!=null){
			System.out.println(n.data);
			n=n.next;
		}
		System.out.println(n.data);
	}
	public int count(){
		Node n=head;
		int c=0;
		while (n.next!=null){
			c++;
			n=n.next;
		}
		System.out.println("count:- "+(c+1));
		return (c+1);
	}
	public void sum(){
		Node n=head;
		int s=0;
		while (n.next!=null){
			s+=n.data;
			n=n.next;
		}
		s+=n.data;
		System.out.println("sum:-  "+s);
	}
	public void max(){
		Node n=head;
		int m=Integer.MIN_VALUE;
		while (n.next!=null){
			if (m<n.data){
				m=n.data;
			}
			n=n.next;
		}
		if (m<n.data){
			m=n.data;
		}
		System.out.println("MAXIMUM:-"+m);
	}
	public void search(int key){
		Node n=head;
		int f=0;
		while (n.next!=null){
			if (key==n.data){
				f=1;
				System.out.println(n.data+" - "+n);
				break;
			}
			n=n.next;
		}
		if (key==n.data){
			System.out.println(n.data+" - "+n);
			f=1;
		}
		if (f==0)
		System.out.println("element not found");
	}
	//we are inserting the data in the sorted linked list
	public void insertAtSort(int x){
		Node node=new Node();
		node.data=x;
		node.next=null;
		Node q=null;
		Node n=head;
		while ((n!=null) && (n.data<x)){
			q=n;
			n=n.next;
		}
		if (n==head){
			node.next=head;
			head=node;
		}
		else{
			node.next=q.next;
			q.next=node;
		}
	}
	public boolean isSorted(){
		Node n=head;
		int x=Integer.MIN_VALUE;
		while (n!=null){
			if (n.data<x){
				return false;
			}
			x=n.data;
			n=n.next;
		}
		return true;
	}
	public void removeDuplicacy(){
		Node n=head;
		Node q=head.next;
		while (q!=null){
			if (n.data!=q.data){
				n=q;
				q=q.next;
			}
			else{
				n.next=q.next;
				q=null;
				q=n.next;
			}
		}
	}
	public void reverse(int size){
		int arr[]=new int[size];
		int i=0;
		Node n=head;
		while (n!=null){
			arr[i]=n.data;
			i++;
			n=n.next;
		}
		n=head;
		i--;
		while (n!=null){
			n.data=arr[i--];
			n=n.next;
		}
	}
	public void findMiddle(){
		Node p=head;
		Node q=head;
		while(q!=null){
			q=q.next;
			if(q!=null){
				q=q.next;
			}
			if (q!=null){
				p=p.next;
			}
		}
		System.out.println(p.data);
	}
}
