public class PageIndex
{
	MyLinkedList<WordEntry> ll ;
	
	PageIndex(){
		ll = new MyLinkedList<WordEntry>();
	}
	
	public void addPositionForWord(String str,Position p)
	{
		int k = 0;
		Node<WordEntry> n = ll.head;
		while(n!= null)
		{
			if(n.data.getword().equals(str))
			{
				k= 1;
				n.data.getAllPositionsForThisWord().Insert(p);
				break;
			}
			else
			n=n.next;
		}
		if(k==0)
		{
			WordEntry temp = new WordEntry(str);
			temp.getAllPositionsForThisWord().Insert(p);
			ll.Insert(temp); 
		}
	}
	
	public MyLinkedList<WordEntry> getWordEntries()
	{
		return ll;
	}

	
}
	