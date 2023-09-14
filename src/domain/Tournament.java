package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Tournament implements GenericEntity{
    
    private Long tournamentID;
    private String name;
    private String city;
    private LocalDate beginningDate;
    private LocalDate endingDate;
    private Integer numberOfPlayers;
    private Integer atpType;

    public Tournament() {
    }

    public Tournament(Long tournamentID, String name, String city, LocalDate beginningDate, LocalDate endingDate, Integer numberOfPlayers, Integer atpType) {
        this.tournamentID = tournamentID;
        this.name = name;
        this.city = city;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.numberOfPlayers = numberOfPlayers;
        this.atpType = atpType;
    }

    public Tournament(Long tournamentID) {
        this.tournamentID = tournamentID;
    }

    public Long getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(Long tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(LocalDate beginningDate) {
        this.beginningDate = beginningDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Integer getAtpType() {
        return atpType;
    }

    public void setAtpType(Integer atpType) {
        this.atpType = atpType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.tournamentID);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.city);
        hash = 17 * hash + Objects.hashCode(this.beginningDate);
        hash = 17 * hash + Objects.hashCode(this.endingDate);
        hash = 17 * hash + Objects.hashCode(this.numberOfPlayers);
        hash = 17 * hash + Objects.hashCode(this.atpType);
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
        final Tournament other = (Tournament) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.tournamentID, other.tournamentID)) {
            return false;
        }
        if (!Objects.equals(this.beginningDate, other.beginningDate)) {
            return false;
        }
        if (!Objects.equals(this.endingDate, other.endingDate)) {
            return false;
        }
        if (!Objects.equals(this.numberOfPlayers, other.numberOfPlayers)) {
            return false;
        }
        return Objects.equals(this.atpType, other.atpType);
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public String getTableName() {
        return "tournament";
    }

    @Override
    public String getColumnNameForInsert() {
        return "tournamentid,name,city,beginningdate,endingdate,numberofplayers,type";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(tournamentID).append(",")
                .append("'").append(name).append("',")
                .append("'").append(city).append("',")
                .append("'").append(beginningDate).append("','")
                .append(endingDate).append("',")
                .append(numberOfPlayers).append(",")
                .append(atpType);
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        setTournamentID(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT t.tournamentid,t.name,t.city,t.beginningdate,t.endingdate,t.numberofplayers,t.type FROM tournament AS t";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Tournament(rs.getLong("tournamentid"), rs.getString("name"), rs.getString("city"), rs.getDate("beginningdate").toLocalDate(), rs.getDate("endingdate").toLocalDate(), rs.getInt("numberofplayers"), rs.getInt("type"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "tournamentid=" + ((Tournament)object).getTournamentID();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Tournament tournament = (Tournament) object;
        return "name=" + "'" + tournament.getName() + "'" + ", city='" + tournament.getCity()+ "'" + ", beginningdate='" + tournament.getBeginningDate()+ "'" + ", endingdate='" + tournament.getEndingDate()+ "'" + ", numberofplayers=" + tournament.getNumberOfPlayers() + ", type=" + tournament.getAtpType();
    }
    
}
