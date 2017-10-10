/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.mppee.robot;

import java.io.IOException;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author phd2014
 */
public class sendTweet {
    
    public static Twitter getInstance(String account) throws IOException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
            
            readFileProperties properties = new readFileProperties();

            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(properties.getConsumerKey(account+"ConsumerKey"))
                    .setOAuthConsumerSecret(properties.getConsumerSecret(account+"ConsumerSecret"))
                    .setOAuthAccessToken(properties.getAccessToken(account+"AccessToken"))
                    .setOAuthAccessTokenSecret(properties.getAccessTokenSecret(account+"AccessTokenSecret"));          
        
        return new TwitterFactory(cb.build()).getInstance();
    }
    
    public void publishTweet (String account, String text, long id) throws IOException, TwitterException {
            
            Twitter twitterTMP = getInstance(account);
            StatusUpdate su = new StatusUpdate(text);
            su.setInReplyToStatusId(id);
            twitterTMP.updateStatus(su);           
    }
}
