package gettingstarted;

public class Movie {

	private final int id;
	private final String quote;
    private final String title;
	private final String name;

	public Movie(int id, String title, String quote, String name) {
		this.id = id;
		this.quote = quote;
        this.title = title;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getQuote() {
		return quote;
	}

	public String getName() {
		return name;
	}

    public String getTitle() {
		return title;
	}
}