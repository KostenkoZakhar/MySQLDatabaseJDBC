package dataobjects;

import mysqlconfig.enums.ADRESSFIELDS;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {
 public    int id;
 public    String userName, userSurname, email, country;

    public Users(int id, String userName, String userSurname, String email, String country) {
        this.id = id;
        this.userName = userName;
        this.userSurname = userSurname;
        this.email = email;
        this.country = country;
    }

    public Users(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt(ADRESSFIELDS.ID.getFieldName());
            this.userName = resultSet.getString(ADRESSFIELDS.USERNAME.getFieldName());
            this.userSurname = resultSet.getString(ADRESSFIELDS.USERSURNAME.getFieldName());
            this.email = resultSet.getString(ADRESSFIELDS.EMAIL.getFieldName());
            this.country = resultSet.getString(ADRESSFIELDS.COUNTRY.getFieldName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "name = "+userName+" surname = "+userSurname;
    }
}
