import java.io.*;
import java.util.*;
public class SearchEngine
{
	InvertedPageIndex search;
	SearchEngine()
	{
		search = new InvertedPageIndex();
	}
	
	public void performAction(String actionMessage)
	{
		String[] x = actionMessage.split(" ");
		
		if(x[0].equals("addPage"))
		{
         	PageEntry page = new PageEntry(x[1]);
			search.addPage(page);
			
	}
		else if(x[0].equals("queryFindPagesWhichContainWord"))
		{
			MySet<PageEntry> temp = new MySet<PageEntry>();
			temp = search.getPagesWhichContainWord(x[1].toLowerCase());
			int m = search.pages.size();
			String str =  "";

			if(temp.isEmpty())
			{
				System.out.println("No webpage contains word "+ x[1]);
			} 
			else  
			{
				Node<PageEntry> newnode =  temp.head;
			    while(newnode!= null) 
				{
					str =  str + newnode.data.pn + ", ";
				   newnode = newnode.next;
				} 
				str = str.substring(0,str.length()-2);
			    System.out.println(str);
				
			}
		}
		
		else if(x[0].equals("queryFindPositionsOfWordInAPage"))
		{
			PageEntry pa = new PageEntry(x[2]);
			Node<WordEntry> nod = pa.getPageIndex().getWordEntries().head;
			int k  = 0;
			String ans  = "";
			while(nod!=null)
			{
				if(nod.data.getword().equals(x[1].toLowerCase()))
				{
					k=1;
					Node<Position> pos = nod.data.getAllPositionsForThisWord().head;
					while(pos!=null)
					{
						String s ="";
						     s= Integer.toString(pos.data.getWordIndex());
						
						ans = ans + s + ", "; 
					    pos = pos.next;
					}
					break;
				}
				nod = nod.next;
			}
			if(k ==1)
			{
				ans = ans.substring(0,ans.length()-2);
			    System.out.println(ans);
			}
			else
			{		 
		        System.out.println("Webpage "+x[2]+" does not contain word "+x[1]);
		
			}
		}
	}
}
	
