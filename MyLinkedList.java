public class MyLinkedList<T> {
	Node<T> head=null;
	Node<T> tail=null;
	int size=0;
	public MyLinkedList() {}    // initially empty list
	
	public int size(){
		return size;
	}
	public Boolean isEmpty()
	{
		return (size==0);
	}

	public void Insert(T d){

		Node<T> temp=head;
		if(temp==null)
		{
			Node<T> a=new Node<>(d,null);
    	    head=a;
		}
		else{
 		  	while(temp.next!=null)
			{
				temp=temp.next;
			}
			Node<T> a=new Node<>(d,null);
			temp.next=a;
		}
	}

	public T first()
	{
		if (isEmpty())
		{
			return null;
		}
		else 
		{
			return head.data;
		}
	}
	public T last()
	{
		if (isEmpty())
		{
			return null;
		}
		else
		{
			return tail.data;
		}
	}
	public boolean isMember(T t)
	{
		Node<T> temp = head;
		while(temp!=null) {
			if(temp.data == t){
				return true;
			} temp = temp.next;
		} return false;
	}
	public void addFirst(T t)
	{
		Node<T> newele = new Node<T>(t,head);
		if (isEmpty())
		{
			tail=newele;
		}
		size=size+1;
	}
	public void addLast(T t)
	{
		Node<T> newele=new Node<>(t,null);
		if (isEmpty())
		{
			head=newele;
		}
		else {
			tail.next = newele;
			tail=newele;
		}
		size=size+1;
	}
	public void addLists(MyLinkedList<T> l)
	{
		Node<T> temp=new Node<>(l.head.data,l.head.next);
		while (temp!=null)
		{
			addLast(temp.data);
			temp=temp.next;
		}
	}
	public T removeFirst()
	{
		if (isEmpty()) return null;
		T temp=head.data;
			head=head.next;
			size=size-1;
		
		if (size==0)
		{
			tail=null;
			
		}
		return temp;
	}

public static void main(String[] args) {
}
	

}
