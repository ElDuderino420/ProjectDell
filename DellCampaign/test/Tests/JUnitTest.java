/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import DataSource.UserMapper;
import Domain.Partner;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David
 */
public class JUnitTest {

    UserMapper um;

    public JUnitTest() {
        um = new UserMapper();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void loginTest() {
        try {
            Assert.assertEquals("D2232", um.fetchDell("D2232", "123"));
            Assert.assertEquals(null, um.fetchDell("D2232", "111"));
            Assert.assertNotSame("D2232", um.fetchDell("D2232", "321"));
            Assert.assertEquals("finans", um.fetchFinance("finans", "123"));
            Assert.assertEquals(null, um.fetchFinance("finans", "111"));
            Assert.assertNotSame("D2232", um.fetchFinance("finans", "321"));
            Assert.assertEquals("P1234", um.fetchPartners("P1234", "123"));
            Assert.assertEquals(null, um.fetchPartners("P1234", "111"));
            Assert.assertNotSame("D2232", um.fetchPartners("P1234", "321"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void partnerTest() {
        try {
            String id = um.getNextPartId();
            String name = "test1";
            String date = "2015-10-26";
            String pass = "pass";
            Partner p = new Partner(id, name, date, pass);
            um.createPartner(p);
            Assert.assertFalse(um.checkPartner(id));        
            Assert.assertEquals(p.toString(), um.getPartner(id).toString());
            
            
            Assert.assertEquals(id, um.fetchPartners(id, pass));
            
            
            p.setEmail("mail@mail.com");
            p.setPhone("123456789");
            um.editPartner(p);
            Assert.assertEquals(p.toString(), um.getPartner(id).toString());
            Assert.assertTrue(um.checkPartner(id));
            
            
            List<Partner> list = um.fetchAllPartners();
            Assert.assertEquals(p.toString(), list.get(list.size()-1));
            
            
            um.deletePart(id);
            Assert.assertNull(um.getPartner(id));
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
