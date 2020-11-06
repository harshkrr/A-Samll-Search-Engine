public class WordEntry
{
	String word;
	MyLinkedList<Position> list = new MyLinkedList<Position>();
	public WordEntry(String str)
	{
		word = str;
	}

	public void addPosition(Position position)
	{
		list.addFirst(position);
	}

	public void addPositions(MyLinkedList<Position> positions)
	{
		Node<Position> n = positions.head;
		while(n!=null) {
			list.addFirst(n.data);
			n = n.next;
		}
	}

	public MyLinkedList<Position> getAllPositionsForThisWord()
	{
		return list;
	}

	public String getword() {
		return word;
	}

	
}