package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Stadium implements GenericEntity{
    
    private Long stadiumID;
    private String name;
    private Integer numberOfSeats;
    private String city;

    public Stadium() {
    }

    public Stadium(Long stadiumID, String name, int numberOfSeats, String city) {
        this.stadiumID = stadiumID;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.city = city;
    }

    public Stadium(Long stadiumID) {
        this.stadiumID = stadiumID;
    }

    public Long getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(Long stadiumID) {
        this.stadiumID = stadiumID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.stadiumID);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.numberOfSeats);
        hash = 97 * hash + Objects.hashCode(this.city);
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
        final Stadium other = (Stadium) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.stadiumID, other.stadiumID)) {
            return false;
        }
        return Objects.equals(this.numberOfSeats, other.numberOfSeats);
    }

    @Override
    public String getTableName() {
        return "stadium";
    }

    @Override
    public String getColumnNameForInsert() {
        return "stadiumid,name,numberofseats,city";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(stadiumID).append(",")
                .append("'").append(name).append("',")
                .append(numberOfSeats).append(",")
                .append("'").append(city).append("'");
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        setStadiumID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT s.stadiumid,s.name,s.numberofseats,s.city FROM stadium AS s";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Stadium(rs.getLong("stadiumid"), rs.getString("name"), rs.getInt("numberofseats"), rs.getString("city"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "stadiumid=" + ((Stadium)object).getStadiumID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Stadium stadium = (Stadium) object;
        return  "name=" + "'" + stadium.getName() + "'" + ", numberofseats = '" + stadium.getNumberOfSeats()+ "'" + ", city = '" + stadium.getCity()+ "'";
    }
    
}
