/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.mppee.robot;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author phd2014
 */
public class readFileProperties {
    

    static Properties p = new Properties();
    static Properties estatus = new Properties();
    
    public readFileProperties() throws FileNotFoundException, IOException {      
//        estatus.load(new FileReader("/home/phd2014/estatusRobot.properties"));
//        p.load(new FileReader("/home/phd2014/conexionRobot.properties"));
        estatus.load(new FileReader("/home/mppee/tomcat/conf/estatusRobot.properties"));
        p.load(new FileReader("/home/mppee/tomcat/conf/conexionRobot.properties"));
        
    }

    public String getHost() {
        return (p.getProperty("host"));
    }

    public String getKeyspace() {
        return (p.getProperty("keyspace"));
    }

    public String getUser() {
        return (p.getProperty("user"));
    }

    public String getPass() {
        return (p.getProperty("pass"));
    }

    public Boolean getStatus() {
        return (Boolean.parseBoolean(estatus.getProperty("estado")));
    }
    
    public String getConsumerKey(String nameAccount) {
        return (p.getProperty(nameAccount+"ConsumerKey"));
    }
    
    public String getConsumerSecret(String nameAccount) {
        return (p.getProperty(nameAccount+"ConsumerSecret"));
    }
    
    public String getAccessToken(String nameAccount) {
        return (p.getProperty(nameAccount+"AccessToken"));
    }
    
    public String getAccessTokenSecret(String nameAccount) {
        return (p.getProperty(nameAccount+"AccessTokenSecret"));
    }
    
}
