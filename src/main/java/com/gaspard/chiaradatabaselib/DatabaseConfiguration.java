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

import java.net.InetAddress;
import org.apache.commons.codec.digest.DigestUtils;

/**This class allow  you to config the username and password needed to acces to ChiaraDatabase
 *
 * @author gaspard
 */
public class DatabaseConfiguration {
        public String user;
    public String password; // in shasha 256
    public InetAddress serverip;

    /**
     * This function allow you to set the ip adress of chiaradatabase server 
     * 
     * 
     * @param InetAddress ip 
     */
     public void setServerip (InetAddress ip) {
    this.serverip = ip;
    

            
    }
    
    
    /**
     * This function allow to get the ip adress of chiaradatabase server
     * 
     * @return Inetadress object
     */
    public InetAddress getServerip () {
    
    
    return this.serverip;
    
    }
    /**
     * This function allow you to get the username
    * @author gaspard
    * @param 
    */
    
    public String getUser() {
        return user;
    }
     /**
     * This function allow you to set the username
    * @author gaspard
    * @param String user
    */

    public void setUser(String user) {
        this.user = user;
    }
     /**
     * This function allow you to get the password encrypted in shasha256
    * @author gaspard
    * 
    */


    public String getPassword() {
        return password;
    }

         /**
     * This function allow you to set the password
     * Don't set a already encrypted pass, This function encrypt for you !
    * @author gaspard
    * @param String password
    */

    public void setPassword(String password) {
        this.password = DigestUtils.sha256Hex(password);
    }
    
    
}
