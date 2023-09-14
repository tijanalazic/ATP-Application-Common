package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Player implements GenericEntity{
    
    private Long playerId;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String state;
    private Integer points;
    private Double height;
    private Double weight;
    private ATPList atpList;

    public Player() {
    }

    public Player(Long playerId, String firstName, String lastName, LocalDate birthday, String state, Integer points, Double height, Double weight, ATPList atpList) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.state = state;
        this.points = points;
        this.height = height;
        this.weight = weight;
        this.atpList = atpList;
    }

    public Player(Long playerId) {
        this.playerId = playerId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public ATPList getAtpList() {
        return atpList;
    }

    public void setAtpList(ATPList atpList) {
        this.atpList = atpList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.playerId);
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + Objects.hashCode(this.birthday);
        hash = 97 * hash + Objects.hashCode(this.state);
        hash = 97 * hash + Objects.hashCode(this.points);
        hash = 97 * hash + Objects.hashCode(this.height);
        hash = 97 * hash + Objects.hashCode(this.weight);
        hash = 97 * hash + Objects.hashCode(this.atpList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.playerId, other.playerId)) {
            return false;
        }
        return Objects.equals(this.birthday, other.birthday);
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public String getTableName() {
        return "player";
    }

    @Override
    public String getColumnNameForInsert() {
        return "playerid,firstname,lastname,birthday,state,points,height,weight,atplistid";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(playerId).append(",")
                .append("'").append(firstName).append("',")
                .append("'").append(lastName).append("',")
                .append("'").append(birthday).append("',")
                .append("'").append(state).append("',")
                .append(points).append(",")
                .append(height).append(",")
                .append(weight).append(",")
                .append(atpList.getAtpListId());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        setPlayerId(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT p.playerid,p.firstname,p.lastname,p.birthday,p.state,p.points,p.height,p.weight,p.atplistid FROM player AS p";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Player(rs.getLong("playerid"), rs.getString("firstname"), rs.getString("lastname"), rs.getDate("birthday").toLocalDate(), rs.getString("state"), rs.getInt("points"), rs.getDouble("height"), rs.getDouble("weight"), new ATPList(rs.getLong("atplistid")));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "playerid=" + ((Player) object).getPlayerId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Player player = (Player) object;
        return "firstname=" + "'" + player.getFirstName()+ "'" + ",lastname=" + "'" + player.getLastName()+ "'" + ",birthday=" + "'" + player.getBirthday()+ "'" + ",state=" + "'" + player.getState()+ "'" + ",points=" + player.getPoints() + ",height=" + player.getHeight() + ",weight=" + player.getWeight() + ",atplistid=" + player.getAtpList().getAtpListId();
    }

}
