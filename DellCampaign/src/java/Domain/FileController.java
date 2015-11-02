/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.File;

/**
 *
 * @author butwhole
 */
public class FileController {

    public void CreateFolder(String id) {

    }

    public void CheckFolder(String id) {

    }

    private void createDirectoryIfNeeded(String directoryName,String id) {
        File theDir = new File(directoryName);
            http://localhost:8080/DellCampaign/
        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + directoryName);
            theDir.mkdir();
        }
    }
}
