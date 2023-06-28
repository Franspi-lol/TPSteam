package compra_juego;

import java.util.Objects;

/**
 * Funcional de que esta es la clase jeugos que va a servir, la otra queda para no borrar por emergencia
 */
public class JuegoFuncional
{
    private String game;
    private String gameLink;
    private int year;
    private String genre;
    private String dev;
    private String devLink;
    private String publisher;
    private String publisherLink;
    private String platform;//the Playstation 4 - the Switch - the XBOX One
    private String platformLink;
    private int price;


    public JuegoFuncional(String game, String gameLink, int year, String genre, String dev, String devLink, String publisher, String publisherLink, String platform, String platformLink, int price) {
        this.game = game;
        this.gameLink = gameLink;
        this.year = year;
        this.genre = genre;
        this.dev = dev;
        this.devLink = devLink;
        this.publisher = publisher;
        this.publisherLink = publisherLink;
        this.platform = platform;
        this.platformLink = platformLink;
        this.price = price;
    }

    public JuegoFuncional() {
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getGameLink() {
        return gameLink;
    }

    public void setGameLink(String gameLink) {
        this.gameLink = gameLink;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public String getDevLink() {
        return devLink;
    }

    public void setDevLink(String devLink) {
        this.devLink = devLink;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherLink() {
        return publisherLink;
    }

    public void setPublisherLink(String publisherLink) {
        this.publisherLink = publisherLink;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformLink() {
        return platformLink;
    }

    public void setPlatformLink(String platformLink) {
        this.platformLink = platformLink;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JuegoFuncional that = (JuegoFuncional) o;
        return year == that.year && price == that.price && Objects.equals(game, that.game) && Objects.equals(gameLink, that.gameLink) && Objects.equals(genre, that.genre) && Objects.equals(dev, that.dev) && Objects.equals(devLink, that.devLink) && Objects.equals(publisher, that.publisher) && Objects.equals(publisherLink, that.publisherLink) && Objects.equals(platform, that.platform) && Objects.equals(platformLink, that.platformLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, gameLink, year, genre, dev, devLink, publisher, publisherLink, platform, platformLink, price);
    }

    @Override
    public String toString() {
        return "\nJuego {" +
                "game='" + game + '\'' +
                ", gameLink='" + gameLink + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", dev='" + dev + '\'' +
                ", devLink='" + devLink + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publisherLink='" + publisherLink + '\'' +
                ", platform='" + platform + '\'' +
                ", platformLink='" + platformLink + '\'' +
                ", price=" + price +
                '}'+"\n";
    }
}
