package compra_juego;

/**
 * quedo irrelevante
 */
public class Juego
{
    private String Gamelink;
    private String Game;
    private String Platform;
    private Integer Year;
    private String PlatformLink;
    private Integer Price;


    /**
     *
     * @param gamelink
     * @param game
     * @param platform
     * @param year
     * @param platformLink
     * @param price
     */
    public Juego(String gamelink, String game, String platform, Integer year, String platformLink, Integer price) {
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

    public Integer getYear() {
        return Year;
    }

    public Juego()
    {
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public String getPlatformLink() {
        return PlatformLink;
    }

    public void setPlatformLink(String platformLink) {
        PlatformLink = platformLink;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
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
