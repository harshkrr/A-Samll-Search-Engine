public class InvertedPageIndex{
	MySet<PageEntry> pages;
	MyHashTable hashtable;
	
	InvertedPageIndex(){
		pages= new MySet<PageEntry>();
		hashtable = new MyHashTable();
	}
	
	public void addPage(PageEntry p){
		pages.addElement(p);
		Node<WordEntry> temp = p.getPageIndex().getWordEntries().head;
		while(temp!=null){
			hashtable.addPositionsForWord(temp.data);
			temp = temp.next;
		}
	}

	public MySet<PageEntry> getPagesWhichContainWord(String str){
		MySet<PageEntry> make = new MySet<PageEntry>();
		Node<PageEntry> t =  pages.head;
		while(t!= null){
			Node<WordEntry> temp =  t.data.getPageIndex().getWordEntries().head;
			while(temp !=null)
			{
				if(temp.data.getword().equals(str))
				{
					make.addElement(t.data);
					break;
				}
				else
					temp = temp.next;
			}
			t= t.next;
		}
		return make;
	}					
}