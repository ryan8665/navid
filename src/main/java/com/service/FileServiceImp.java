/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author ryan
 */
public class FileServiceImp implements FileService{

    @Override
    public String copyStream(InputStream is, String i) throws FileNotFoundException, IOException {
        File file = new File(i + ".png");
        FileOutputStream os = new FileOutputStream(file);
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (;;) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1) {
                    break;
                }
                os.write(bytes, 0, count);

            }

        } catch (Exception ex) {
        } finally {
            os.close();
        }
        return file.getAbsolutePath();
    }
    @Override
    public String copyStream(InputStream is, String i,String type) throws FileNotFoundException, IOException {
        File file = new File(i + "."+type);
        FileOutputStream os = new FileOutputStream(file);
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (;;) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1) {
                    break;
                }
                os.write(bytes, 0, count);

            }

        } catch (Exception ex) {
        } finally {
            os.close();
        }
        return file.getAbsolutePath();
    }
    
}
