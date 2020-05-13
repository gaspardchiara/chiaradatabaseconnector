/*
 * Copyright (C) 2020 gaspard
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.gaspard.chiaradatabaselib;

import com.gaspard.data.add;
import com.gaspard.data.delete;
import com.gaspard.data.getfile;
import com.gaspard.data.getfilerespond;
import com.gaspard.data.handcheck;
import com.gaspard.data.respond;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.UUID;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * This class allow to interact with the Database
 * @author gaspard
 * @version 1.0
 */
public class DatabaseAction {
    
    /**
     * This function is used to check if you don't let empty field in database configuration struct
     * @param The databaseconfig struct
     * @return boolean
     */
        private boolean checkconfigstruct (DatabaseConfiguration config) {
        if(config.getPassword() == null && config.user == null) {
        System.err.println("Please check the password and username and retry");
        return false;
        
        }
            
            
            
        return true;
        
        }

    
   /**
    * This function allow you to add data into ChiaraDatabase
    * @param DatabaseConfiguration structure
    * @param Name of the file 
    * @param UUID of the file
    * @param  byte[]the file
    * 
    * @return true = ok false = problem 
    */
    
    
    public boolean adddata (DatabaseConfiguration config,String Name,UUID Id,byte[] thefile) throws UnknownHostException, IOException, ClassNotFoundException {
    
          
    Socket monsocket = new Socket(config.getServerip(),7895);
     
    handcheck envoie = new handcheck();
    envoie.setHandcheck(1);
    envoie.setUser(config.getUser());
    envoie.setPassword(config.getPassword());
    ObjectOutputStream in = new ObjectOutputStream(monsocket.getOutputStream());
    
    add testfile = new add();
testfile.setUser(config.getUser());
testfile.setPassword(config.getPassword());
testfile.setId(Id);
testfile.setName("gaspard");

testfile.setFile(thefile);
envoie.setFilepayload(testfile);
    in.writeObject(envoie);
    in.flush();
//   
    
          ObjectInputStream object = new   ObjectInputStream(monsocket.getInputStream());
respond reponse = (respond) object.readObject();

in.close();
monsocket.close();

if(reponse.status == 1) {
System.err.println("The database failed to write data, check the database stacktrace and try again");
return false;

}
        
    
    return true;
    }
    
       /**
    * This function allow you to get data from ChiaraDatabase
    * @param DatabaseConfiguration structure
    *
    * @param UUID of the file
    * 
    * @return a array of byte[] represent file 
    */
    
    public byte[] getdata (DatabaseConfiguration config,UUID id) throws IOException, ClassNotFoundException {
      Socket monsocket = new Socket(config.getServerip(),7895);
      
      handcheck envoie = new handcheck();
    envoie.setHandcheck(2);
    envoie.setUser(config.getUser());
    envoie.setPassword(config.getPassword());
    getfile fichierdemander =new getfile();
   fichierdemander.setPassword(config.getPassword());
    fichierdemander.setUser(config.getUser());
    fichierdemander.setId(id);
        envoie.setSearchfile(fichierdemander);

        ObjectOutputStream in = new ObjectOutputStream(monsocket.getOutputStream());

        
          in.writeObject(envoie);
    in.flush();
    
ObjectInputStream object = new   ObjectInputStream(monsocket.getInputStream());
getfilerespond reponse = (getfilerespond) object.readObject();

 in.close();

    monsocket.close();
        

        
    
    return reponse.getData();
    
    }
    
    
    
       /**
    * This function allow you to delete file from ChiaraDatabase
    * @param DatabaseConfiguration structure
    * 
    * @param UUID of the file
    * 
    * @return  boolean true = ok false = problem 
    */
    public boolean deletefile(DatabaseConfiguration config,UUID id) throws IOException, ClassNotFoundException {
    
    Socket monsocket = new Socket(config.getServerip(),7895);
      handcheck envoie = new handcheck();
    envoie.setHandcheck(3);
    envoie.setUser(config.getUser());
    envoie.setPassword(config.getPassword());
        delete del = new delete();

   del.setPassword(config.getPassword());
    del.setUser(config.getUser());
    del.setId(id);
        envoie.setDelfile(del);

        ObjectOutputStream in = new ObjectOutputStream(monsocket.getOutputStream());

        
          in.writeObject(envoie);
    in.flush();
//   
    
          ObjectInputStream object = new   ObjectInputStream(monsocket.getInputStream());
respond reponse = (respond) object.readObject();

 in.close();

    monsocket.close();
      
    if(reponse.status==1) {
    
    return false;
    
    }
    
    
    
    
    return true;
    }
    
}
