/*
 * Copyright (c) 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ve.gob.mppee.robot;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.SequenceFile.Writer;
import org.apache.hadoop.io.Text;

/**
 * http://www.chimpler.com
 */
public class TweetTSVToSeq {
	public static void tweetTSVtoSeq() throws Exception {


		Configuration configuration = new Configuration();
                configuration.addResource(new Path("/home/phd2014/hadoop/etc/hadoop/conf/core-site.xml")); // Replace with actual path
                configuration.addResource(new Path("/home/phd2014/hadoop/etc/hadoop/conf/hdfs-site.xml")); // Replace with actual path
		FileSystem fs = FileSystem.get(configuration);
		Writer writer = new SequenceFile.Writer(fs, configuration, new Path("/home/phd2014/tweets-seq"),
				Text.class, Text.class);
		
		BufferedReader reader = new BufferedReader(new FileReader("/home/phd2014/dataDeEntrenamiento.tsv"));
		Text key = new Text();
		Text value = new Text();
		while(true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			}
			String[] tokens = line.split("\t", 2);
			if (tokens.length != 2) {
				continue;
			}
			String category = tokens[0];
			String message = tokens[1];
			key.set("/" + category);
			value.set(message);
			writer.append(key, value);
                        System.out.println("Imprimio");
		}
		reader.close();
		writer.close();
	}
}
