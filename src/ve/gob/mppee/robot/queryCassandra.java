/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.mppee.robot;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SocketOptions;
import java.util.List;

/**
 *
 * @author phd2014
 */
public class queryCassandra {
    
    public static ResultSet getData (String host, String keyspace, String user, String pass){
        
        Cluster cluster = null;
        ResultSet rs,ws;
        try {
            cluster = Cluster.builder().addContactPoint(host)
                        .withQueryOptions(new QueryOptions().setFetchSize(100000)
                        .setConsistencyLevel(ConsistencyLevel.ONE))
                        .withSocketOptions(new SocketOptions()
                        .setReadTimeoutMillis(999999999)
                        .setConnectTimeoutMillis(999999999))
                        .withCredentials(user,pass).build();
            
            Session session = cluster.connect(keyspace);

            rs = session.execute("SELECT id, text, origen, name FROM tweets WHERE procesado = false ALLOW FILTERING;");
            
        } finally {
            if (cluster != null) {
                cluster.close();
            }
        }
        
        return rs;
    }
    
    public static void updateData (String host, String keyspace, String user, String pass, List <Row> rs){
        
        Cluster cluster = null;
        ResultSet ws = null;
        try {
            cluster = Cluster.builder().addContactPoint(host)
                        .withQueryOptions(new QueryOptions().setFetchSize(100000)
                        .setConsistencyLevel(ConsistencyLevel.ONE))
                        .withSocketOptions(new SocketOptions()
                        .setReadTimeoutMillis(999999999)
                        .setConnectTimeoutMillis(999999999))
                        .withCredentials(user,pass).build();
            
            Session session = cluster.connect(keyspace);
            
            for (Row row : rs) {
                 ws = session.execute("UPDATE tweets SET procesado = TRUE WHERE id = '"+row.getString("id")+"';");
            }
        } finally {
            if (cluster != null) {
                cluster.close();
            }
        }
    }
}
