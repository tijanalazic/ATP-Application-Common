package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public interface GenericEntity extends Serializable{
    
    String getTableName();
    
    String getColumnNameForInsert();
    
    String getInsertValues();
    
    void setId(Long id);
    
    String getSelectValues();
    
    GenericEntity getNewObject(ResultSet rs) throws SQLException;

    String getDeleteAndUpdateCondition(Object object);

    String getUpdateSetValues(Object object);
}
