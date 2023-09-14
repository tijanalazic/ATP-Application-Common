package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Match implements GenericEntity{
    
    private Long matchId;
    private Tournament tournament;
    private LocalDate date;
    private Player player1;
    private Player player2;
    private Stadium stadium;

    public Match() {
    }

    public Match(Long matchId, Tournament tournament, LocalDate date, Player player1, Player player2, Stadium stadium) {
        this.matchId = matchId;
        this.tournament = tournament;
        this.date = date;
        this.player1 = player1;
        this.player2 = player2;
        this.stadium = stadium;
    }

    public Match(Long matchId) {
        this.matchId = matchId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.matchId);
        hash = 41 * hash + Objects.hashCode(this.tournament);
        hash = 41 * hash + Objects.hashCode(this.date);
        hash = 41 * hash + Objects.hashCode(this.player1);
        hash = 41 * hash + Objects.hashCode(this.player2);
        hash = 41 * hash + Objects.hashCode(this.stadium);
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
        final Match other = (Match) obj;
        if (!Objects.equals(this.matchId, other.matchId)) {
            return false;
        }
        if (!Objects.equals(this.tournament, other.tournament)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.player1, other.player1)) {
            return false;
        }
        if (!Objects.equals(this.player2, other.player2)) {
            return false;
        }
        return Objects.equals(this.stadium, other.stadium);
    }

    @Override
    public String toString() {
        return player1 + " VS " + player2;
    }

    @Override
    public String getTableName() {
        return "matchh";
    }

    @Override
    public String getColumnNameForInsert() {
        return "matchid,tournamentid,player1id,player2id,date,stadiumid";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(matchId).append(",")
                .append(tournament.getTournamentID()).append(",")
                .append(player1.getPlayerId()).append(",")
                .append(player2.getPlayerId()).append(",")
                .append("'").append(date).append("',")
                .append(stadium.getStadiumID());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        setMatchId(id);
    }

    @Override
    public String getSelectValues() {
        //return "SELECT ";
        return "SELECT m.matchid,m.tournamentid,m.date,m.player1id,m.player2id,m.stadiumid FROM matchh AS m INNER JOIN tournament AS t ON m.tournamentid=t.tournamentid INNER JOIN player AS p ON m.player1id=p.playerid INNER JOIN player AS pp ON m.player2id=pp.playerid INNER JOIN stadium AS s ON m.stadiumid=s.stadiumid";
        //return "SELECT matchid,tournamentid,date,player1id,player2id,stadiumid FROM match";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Match(rs.getLong("matchid"), new Tournament(rs.getLong("tournamentid")), rs.getDate("date").toLocalDate(), new Player(rs.getLong("player1id")), new Player(rs.getLong("player2id")), new Stadium(rs.getLong("stadiumid")));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "matchid=" + ((Match) object).getMatchId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Match match = (Match) object;
        return "tournamentid=" + match.getTournament().getTournamentID() + ", player1id=" + match.getPlayer1().getPlayerId() + ", player2id=" + match.getPlayer2().getPlayerId() + ", date=" + "'" + match.getDate() + "'" + ", stadiumid=" + match.getStadium().getStadiumID();
    }

    
}