package LibrarySystem;

public class AudioBook extends Item {
	private String author;
	private String reader;
	
	public AudioBook(String aTitle, String aDescription, int aDate, String anAuthor, String aReader) {
		super(aTitle, aDescription, aDate);
		this.setAuthor(anAuthor);
		this.setReader(aReader);
	}
	
	public String toString() {
		return super.toString() + "\nAuthor: " + this.author 
		+ "\nReader: " + this.reader;
	}

	private void setAuthor(String anAuthor) {
		this.author = anAuthor;
	}

	private void setReader(String aReader) {
		this.reader = aReader;
	}
}
