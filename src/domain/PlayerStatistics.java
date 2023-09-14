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
public class PlayerStatistics implements GenericEntity{
    
    private Player player;
    private Match match;
    private Integer aces;
    private Integer double_faults;
    private Integer winners;
    private Integer net_points_won;
    private Integer unforced_errors;

    public PlayerStatistics() {
    }

    public PlayerStatistics(Player player, Match match, Integer aces, Integer double_faults, Integer winners, Integer net_points_won, Integer unforced_errors) {
        this.player = player;
        this.match = match;
        this.aces = aces;
        this.double_faults = double_faults;
        this.winners = winners;
        this.net_points_won = net_points_won;
        this.unforced_errors = unforced_errors;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Integer getAces() {
        return aces;
    }

    public void setAces(Integer aces) {
        this.aces = aces;
    }

    public Integer getDouble_faults() {
        return double_faults;
    }

    public void setDouble_faults(Integer double_faults) {
        this.double_faults = double_faults;
    }

    public Integer getWinners() {
        return winners;
    }

    public void setWinners(Integer winners) {
        this.winners = winners;
    }

    public Integer getNet_points_won() {
        return net_points_won;
    }

    public void setNet_points_won(Integer net_points_won) {
        this.net_points_won = net_points_won;
    }

    public Integer getUnforced_errors() {
        return unforced_errors;
    }

    public void setUnforced_errors(Integer unforced_errors) {
        this.unforced_errors = unforced_errors;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.player);
        hash = 67 * hash + Objects.hashCode(this.match);
        hash = 67 * hash + Objects.hashCode(this.aces);
        hash = 67 * hash + Objects.hashCode(this.double_faults);
        hash = 67 * hash + Objects.hashCode(this.winners);
        hash = 67 * hash + Objects.hashCode(this.net_points_won);
        hash = 67 * hash + Objects.hashCode(this.unforced_errors);
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
        final PlayerStatistics other = (PlayerStatistics) obj;
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.match, other.match)) {
            return false;
        }
        if (!Objects.equals(this.aces, other.aces)) {
            return false;
        }
        if (!Objects.equals(this.double_faults, other.double_faults)) {
            return false;
        }
        if (!Objects.equals(this.winners, other.winners)) {
            return false;
        }
        if (!Objects.equals(this.net_points_won, other.net_points_won)) {
            return false;
        }
        return Objects.equals(this.unforced_errors, other.unforced_errors);
    }

    @Override
    public String toString() {
        return "PlayerStatistics{" + "player=" + player + ", match=" + match + ", aces=" + aces + ", double_faults=" + double_faults + ", winners=" + winners + ", net_points_won=" + net_points_won + ", unforced_errors=" + unforced_errors + '}';
    }

    @Override
    public String getTableName() {
        return "player_statistics";
    }

    @Override
    public String getColumnNameForInsert() {
        return "playerid,matchid,aces,double_faults,winners,net_points_won,unforced_errors";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(player.getPlayerId()).append(",")
                .append(match.getMatchId()).append(",")
                .append(aces).append(",")
                .append(double_faults).append(",")
                .append(winners).append(",")
                .append(net_points_won).append(",")
                .append(unforced_errors);
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        //
    }

    @Override
    public String getSelectValues() {
        //return "SELECT ps.playerid,ps.matchid,ps.aces,ps.double_faults,ps.winners,ps.net_points_won,ps.unforced_errors FROM player_statistics AS ps INNER JOIN player AS p ON ps.playerid=p.playerid INNER JOIN matchh AS m ON ps.matchid=m.matchid";
        return "SELECT ps.playerid,ps.matchid,ps.aces,ps.double_faults,ps.winners,ps.net_points_won,ps.unforced_errors FROM player_statistics AS ps";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new PlayerStatistics(new Player(rs.getLong("playerid")), new Match(rs.getLong("matchid")), rs.getInt("aces"), rs.getInt("double_faults"), rs.getInt("winners"), rs.getInt("net_points_won"), rs.getInt("unforced_errors"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "playerid=" + ((PlayerStatistics) object).getPlayer().getPlayerId() + " AND matchid=" + ((PlayerStatistics) object).getMatch().getMatchId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        PlayerStatistics stats = (PlayerStatistics) object;
        return "aces=" + stats.getAces() + ", double_faults=" + stats.getDouble_faults() + ", winners=" + stats.getWinners() + ", net_points_won=" + stats.getNet_points_won() + ", unforced_errors=" + stats.getUnforced_errors();
    }
    
}
