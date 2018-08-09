/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author ryan
 */
public interface FileService {
    

    public String copyStream(InputStream is, String i) throws FileNotFoundException, IOException;
    
    public String copyStream(InputStream is, String i,String type) throws FileNotFoundException, IOException;
    
}
