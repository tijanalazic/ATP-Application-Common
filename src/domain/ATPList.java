


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class ATPList implements GenericEntity{
    
    private Long atpListId;
    private String name;
    private Integer numberOfPlayers;

    public ATPList() {
    }

    public ATPList(Long atpListId, String name, Integer numberOfPlayers) {
        this.atpListId = atpListId;
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }

    public ATPList(Long atpListId) {
        this.atpListId = atpListId;
    }

    public ATPList(Long atpListId, Integer numberOfPlayers) {
        this.atpListId = atpListId;
        this.numberOfPlayers = numberOfPlayers;
    }

    public Long getAtpListId() {
        return atpListId;
    }

    public void setAtpListId(Long atpListId) {
        this.atpListId = atpListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.atpListId);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.numberOfPlayers);
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
        final ATPList other = (ATPList) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.atpListId, other.atpListId)) {
            return false;
        }
        return Objects.equals(this.numberOfPlayers, other.numberOfPlayers);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTableName() {
        return "atplist";
    }

    @Override
    public String getColumnNameForInsert() {
        return "atplistid,name,numberofplayers";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(atpListId).append(",")
                .append("'").append(name).append("',")
                .append(numberOfPlayers);
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getSelectValues() {
        return "SELECT a.atplistid,a.name,a.numberofplayers FROM atplist AS a";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new ATPList(rs.getLong("atplistid"), rs.getString("name"), rs.getInt("numberofplayers"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "atplistId=" + ((ATPList) object).getAtpListId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        ATPList atpList = (ATPList) object;
        return "name=" + "'" + atpList.getName() + "'" + ", numberofplayers = '" + atpList.getNumberOfPlayers() + "'";
    }

    @Override
    public void setId(Long id) {
        setAtpListId(id);
    }
    
}
