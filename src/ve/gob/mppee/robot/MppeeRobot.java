/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.mppee.robot;

import java.io.IOException;
import com.datastax.driver.core.Row;
import java.util.List;
/**
 *
 * @author phd2014
 */
public class MppeeRobot {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        mppeeRobot();
    }
    
    public static void mppeeRobot() throws IOException, Exception{
        readFileProperties properties = new readFileProperties();
        List <Row> actual = null;
        if(properties.getStatus()){
            actual = (queryCassandra.getData(properties.getHost(), 
                                                  properties.getKeyspace(), 
                                                  properties.getUser(), 
                                                  properties.getPass())).all();
            //clasificar.clasificar(actual);
            TweetTSVToSeq.tweetTSVtoSeq();
            queryCassandra.updateData(properties.getHost(), 
                                    properties.getKeyspace(), 
                                    properties.getUser(), 
                                    properties.getPass(),
                                    actual);
        }
    }
}
