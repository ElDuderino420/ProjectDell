/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DBFacade;
import DataSource.UserMapper;

/**
 *
 * @author butwhole
 */
public class LogInController {
    private DBFacade dbf = new DBFacade();
    
    // FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false
    public String fetchPartners(String id,String pass) throws Exception {
        return dbf.fetchPartners(id, pass);
    }
    
    // FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false
    public String fetchDell(String id,String pass) throws Exception {
        return dbf.fetchDell(id, pass);
    }

    // FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false    
    public String fetchFinance(String id,String pass) throws Exception {
        return dbf.fetchFinance(id, pass);
    }
    
}
