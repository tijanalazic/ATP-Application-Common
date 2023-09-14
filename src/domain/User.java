package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class User implements GenericEntity {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String password;

    public User() {
    }

    public User(Long expertId, String firstName, String lastName, String password) {
        this.id = expertId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public User(Long expertId) {
        this.id = expertId;
    }

    public Long getExpertId() {
        return id;
    }

    public void setExpertId(Long expertId) {
        this.id = expertId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.firstName);
        hash = 13 * hash + Objects.hashCode(this.lastName);
        hash = 13 * hash + Objects.hashCode(this.password);
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
        final User other = (User) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getColumnNameForInsert() {
        return "id,firstname,lastname,password";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(firstName).append("',")
                .append(lastName).append(",")
                .append(password);
        return sb.toString();
    }


    @Override
    public String getSelectValues() {
        return "SELECT u.id,u.firstname,u.lastname,u.password FROM user AS u";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new User(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("password"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "id=" + ((User) object).getExpertId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        User user = (User) object;
        return "firstname=" + "'" + user.getFirstName() + "'" + ", lastname=" + user.getLastName() + ", password=" + user.getPassword();
    }

    @Override
    public void setId(Long id) {
        setExpertId(id);
    }
    
}
