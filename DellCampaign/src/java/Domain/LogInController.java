/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.POEMapper;
import DataSource.UserMapper;

/**
 *
 * @author butwhole
 */
public class LogInController {
    private UserMapper map = new UserMapper();
    
    // FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false
    public String FetchPartners(String id,String pass) throws Exception {
        return map.FetchPartners(id, pass);
    }
    
    // FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false
    public String FetchDell(String id,String pass) throws Exception {
        return map.FetchDell(id, pass);
    }

    // FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false    
    public String FetchFinance(String id,String pass) throws Exception {
        return map.FetchFinance(id, pass);
    }
    
}
