/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.mppee.robot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author phd2014
 */
public class validateAccount {

    public static Boolean validateAccount(String account, BufferedReader reader) throws FileNotFoundException, IOException {
        Boolean valida = true; 
        while(true) {
            String line = reader.readLine();
            if (line == null) {
                    break;
            }else{
                if(line.equals(account)) valida = false;
            }
        }
        return valida;
    }
    
}
