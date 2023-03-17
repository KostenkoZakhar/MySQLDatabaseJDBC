import dataobjects.Users;
import mysqlconfig.StatemenT;
import mysqlconfig.enums.ADRESSFIELDS;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class TestDB {
    static StatemenT statemenT;
    @BeforeClass
    public static void b(){
        statemenT=new StatemenT();
    }


    // select userName by ID
    @Test
    public void testSelectUserByID() throws SQLException {
        statemenT.selectUserNameByID(ADRESSFIELDS.ID,"3");
    }

    //select all users with email given
    @Test
    public void testSelectUsersWithTheSameEmail() throws SQLException {
        for (Users l:statemenT.selectListTablesMail(ADRESSFIELDS.EMAIL,"test1@gmail.com")){
            System.out.println(l);
        }
    }

    //select all users with unique names
    @Test
    public void testSelectUsersWithUniqueNames() throws SQLException {
        for (String l:statemenT.selectUniqueNames(ADRESSFIELDS.ID,null)){
            System.out.println(l);
        }
    }
}
