public class Position
{
	PageEntry pe;
	int wordindex;

	public Position(PageEntry p, int wordIndex)
	{
		this.pe = p;
		this.wordindex = wordIndex;
	}

	public PageEntry getPageEntry() {
		return pe;
	}

	public int getWordIndex() {
		return wordindex;
	}
}