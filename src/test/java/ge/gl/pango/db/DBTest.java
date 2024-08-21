package ge.gl.pango.db;

import ge.gl.pango.db.model.AddUser;
import ge.gl.pango.db.model.GetUser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DBTest {
    DataFromSQL dataFromSQL;

    @BeforeTest
    public void startDBInLocalMemory() {
        dataFromSQL = new DataFromSQL();
        dataFromSQL.initializeDb();
    }

    @AfterTest
    public void cleanupDbFromLocalMemory() {
        dataFromSQL.cleanupDb();
    }

    @Test
    public void addUserDBTest() {
        String testName = "GL";
        String testJobTitle = "Physician";
        AddUser user = new AddUser(testName, testJobTitle);
        dataFromSQL.addUser(user);
        GetUser getUser = dataFromSQL.getUserWithName(testName);
        Assert.assertEquals(getUser.getName(), testName);

    }

    @Test(dependsOnMethods = "addUserDBTest")
    public void updateDBTest() {
        String testName = "GL";
        String testNewName = "WW";
        dataFromSQL.updateUser(testName, testNewName);
        dataFromSQL.getUserWithName(testNewName);
        GetUser getUser = dataFromSQL.getUserWithName(testNewName);
        Assert.assertEquals(getUser.getName(), testNewName);
    }

    @Test(dependsOnMethods = {"updateDBTest", "addUserDBTest"})
    public void deleteUserDBTest() {
        String testName = "WW";
        dataFromSQL.deleteUser(testName);
        dataFromSQL.getUserWithName(testName);
        Assert.assertFalse(dataFromSQL.checkUSerWithName(testName));
    }


}

