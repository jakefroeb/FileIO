/**
 * Created by jakefroeb on 9/8/16.
 */
public class FavoriteTeam {

    private String name;
    private String state;
    private String sportType;
    private Integer championships;
    private String favoritePlayer;

    FavoriteTeam(){};

    FavoriteTeam(String name, String state, String sportType, Integer championships, String favoritePlayer){
        this.name = name;
        this.state = state;
        this.sportType = sportType;
        this.championships = championships;
        this.favoritePlayer = favoritePlayer;
    }









    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public Integer getChampionships() {
        return championships;
    }

    public void setChampionships(Integer championships) {
        this.championships = championships;
    }

    public String getFavoritePlayer() {
        return favoritePlayer;
    }

    public void setFavoritePlayer(String favoritePlayer) {
        this.favoritePlayer = favoritePlayer;
    }





}
