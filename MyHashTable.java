public class MyHashTable
{
	PageIndex map[];
	MyHashTable()
	{
		
	    map = new PageIndex[100];
		
	}
	private int getHashIndex(String str)
	{
		char strtochar[] = str.toCharArray();
		int k;
		k= ((int) strtochar[0] )*5+15;;
		int i = k % 100;
		return i;
	} 
	public void addPositionsForWord(WordEntry w)
	{
		
		int n = getHashIndex(w.getword());
		if(map[n]==null)
		{
			PageIndex temp = new PageIndex();
			Node<Position> pos = w.getAllPositionsForThisWord().head;
			while(pos!=null)
			{
			   temp.addPositionForWord(w.getword(),pos.data);
			   pos=pos.next;
			}
			map[n] = temp;
		}
		else
		{		
	            Node<WordEntry> temp1 = map[n].getWordEntries().head;
				
				while(temp1!=null)
				{	
			         if(temp1.data.getword().equals(w.getword()))
					 {
						Node<Position> pos = w.getAllPositionsForThisWord().head;
						while(pos!=null)
						{
							map[n].addPositionForWord(w.getword(),pos.data);
							pos= pos.next;
						}
						return;
				}
				 temp1 = temp1.next;
			}
			map[n].getWordEntries().addFirst(w);
		}
	}
						
	public int hashindex(String str)
	{
		return getHashIndex(str);
	}
}