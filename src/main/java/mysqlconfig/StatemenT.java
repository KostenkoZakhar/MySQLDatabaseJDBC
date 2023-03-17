package mysqlconfig;


import dataobjects.Users;
import mysqlconfig.enums.ADRESSFIELDS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StatemenT {
    private Statement statement;

    public StatemenT() {
        try {
            makeStatemenT();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement makeStatemenT() throws SQLException {
        Connectt c = null;

        c = new Connectt();
        Connection conn = c.makeConnection();
        statement = conn.createStatement();
        return statement;
    }

    public Users selectUserNameByID(ADRESSFIELDS adressfields, String data) throws SQLException {
        String select = "SELECT * FROM data1.users WHERE "+adressfields+"='"+data+"'";
        ResultSet resultSet = null;

        resultSet = statement.executeQuery(select);
        resultSet.next();
        System.out.println("User with current ID is = "+resultSet.getString("userName"));
        return new Users(resultSet);
    }

    public  List<Users> selectListTablesMail(ADRESSFIELDS adressfields, String data) throws SQLException {
        String select = "SELECT * FROM data1.users where "+adressfields+" like '%"+data+"'";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        List<Users> adressTableList=new ArrayList<>();
        while (resultSet.next()){
            adressTableList.add(new Users(resultSet));
        }
        return adressTableList;
    }

    public Set<String> selectUniqueNames(ADRESSFIELDS adressfields, String data) throws SQLException {
        String select = "SELECT * FROM data1.users WHERE "+adressfields+"!='"+data+"'";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        Set<String> set=new HashSet<>();
        while (resultSet.next()){
            set.add(resultSet.getString("userName"));
        }
        return set;
    }
}
