/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaspard.data;

import java.io.Serializable;
import static javax.swing.text.html.parser.DTDConstants.ANY;

/**
 *
 * @author gaspard
 */
public class handcheck implements Serializable {
       public String user;
    public String password; // in shasha 256
    
   public long handcheck; // 0 to check password // 1 to send data // 2 to read data and resend it //3 to delete
   public add filepayload;
      public getfile searchfile;
   public delete delfile;

   static final long serialVersionUID = 42L;

    public delete getDelfile() {
        return delfile;
    }

    public void setDelfile(delete delfile) {
        this.delfile = delfile;
    }

    public getfile getSearchfile() {
        return searchfile;
    }

    public void setSearchfile(getfile searchfile) {
        this.searchfile = searchfile;
    }

    public add getFilepayload() {
        return filepayload;
    }

    public void setFilepayload(add filepayload) {
        this.filepayload = filepayload;
    }

   
   
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getHandcheck() {
        return handcheck;
    }

    public void setHandcheck(long handcheck) {
        this.handcheck = handcheck;
    }
   
   
   
}
