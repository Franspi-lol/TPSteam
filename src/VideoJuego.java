public class VideoJuego
{
    private int id;
    private String name;
    private String genre[];
    private String developer[];
    private String publisher[];
    private String release;
    private int score; //1-10
    private boolean status;
    private int price; //20-60

    public VideoJuego(int id, String name, String[] genre, String[] developer, String[] publisher, String release) //constructor con solo datos JSON
    {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.developer = developer;
        this.publisher = publisher;
        this.release = release;
    }

    public VideoJuego(int id, String name, String[] genre, String[] developer, String[] publisher, String release, int score, boolean status, int price)//constructor completo
    {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.developer = developer;
        this.publisher = publisher;
        this.release = release;
        this.score = score;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String[] getDeveloper() {
        return developer;
    }

    public void setDeveloper(String[] developer) {
        this.developer = developer;
    }

    public String[] getPublisher() {
        return publisher;
    }

    public void setPublisher(String[] publisher) {
        this.publisher = publisher;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
