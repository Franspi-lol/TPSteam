package compra_juego;

public class Juego
{
    private String Gamelink;
    private String Game;
    private String Platform;
    private int Year;
    private String PlatformLink;
    private int Price;

    public Juego(String gamelink, String game, String platform, int year, String platformLink, int price) {
        Gamelink = gamelink;
        Game = game;
        Platform = platform;
        Year = year;
        PlatformLink = platformLink;
        Price = price;
    }

    public String getGamelink() {
        return Gamelink;
    }

    public void setGamelink(String gamelink) {
        Gamelink = gamelink;
    }

    public String getGame() {
        return Game;
    }

    public void setGame(String game) {
        Game = game;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    public int getYear() {
        return Year;
    }

    public Juego() {
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getPlatformLink() {
        return PlatformLink;
    }

    public void setPlatformLink(String platformLink) {
        PlatformLink = platformLink;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "Gamelink='" + Gamelink + '\'' +
                ", Game='" + Game + '\'' +
                ", Platform='" + Platform + '\'' +
                ", Year=" + Year +
                ", PlatformLink='" + PlatformLink + '\'' +
                ", Price=" + Price +
                '}';
    }
}
