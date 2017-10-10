/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.mppee.robot;

import com.datastax.driver.core.Row;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author phd2014
 */
public class clasificar {

    public static void clasificar(List<Row> rs) throws IOException {
        List<Row> result = null;
        FileWriter file = null;
        PrintWriter writer = null;
        
        try{
            file = new FileWriter("/home/mppee/robot/respuestasRobot.txt",true);
            writer = new PrintWriter(file); 
            BufferedReader reader = new BufferedReader(new FileReader("/home/mppee/robot/cuentasExcluidas.txt"));
            for(Row row : rs){
                if(validateAccount.validateAccount(row.getString("name"),reader)){
                   
                    int rand = (int)(Math.random()*9);
                
                    switch(rand){
                        case 0: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"Buenos días, nos podría indicar si en este momento se encuentra el sector sin servicio eléctrico por favor."+" | neutral");
                        break;
                        case 1: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"Podría indicarnos mayor detalle del sector: calle, Av. Parroquia. Municipio. Estado. para verificar estatus, Gracias. @LMOTTAD"+" | neutral");
                        break;
                        case 2: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"Personal operativo tomando medidas para solucionar a la brevedad posible. Ofrecemos Disculpas. @LMOTTAD"+" | neutral");
                        break;
                        case 3: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"Estimado le invitamos a visitar nuestras oficina comerciales para atencion de su requerimiento. Gracias. @LMOTTAD"+" | neutral");
                        break;
                        case 4: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"Gracias por notificarnos. En CORPOELEC trabajamos para usted. Feliz día. @LMOTTAD"+" | neutral");
                        break;
                        case 5: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"Gracias por notificarnos. En CORPOELEC trabajamos para usted. Feliz tarde. @LMOTTAD"+" | neutral");
                        break;
                        case 6: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"Gracias por notificarnos. Su información es muy valiosa para nosotros, En CORPOELEC trabajamos para usted.. Feliz noche. @LMOTTAD"+" | neutral");
                        break;
                        case 7: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"Buenos días ¿presenta inconveniente en el servicio en estos momentos?"+" | neutral");
                        break;
                        case 8: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"Existe avería reportada para el sector. Ofrecemos disculpas por molestias causadas."+" | neutral");
                        break;
                        case 9: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+"A la brevedad sera Solucionado el inconveniente para el sector. Ofrecemos disculpas por molestias causadas."+" | neutral");
                        break;
                        case 10: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 11: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 12: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 13: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 14: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 15: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 16: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 17: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 18: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 19: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 20: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 21: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 22: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 23: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 24: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 25: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 26: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 27: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 28: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 29: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 30: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        break;
                        case 31: 
                                writer.println(row.getString("name")+" | "+row.getString("text")+" | "+""+" | neutral");
                        }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != file) file.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }    
    }
}
