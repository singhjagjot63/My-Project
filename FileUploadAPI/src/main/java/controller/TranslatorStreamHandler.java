package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jagjot Singh
 */
public class TranslatorStreamHandler extends Thread{

    private InputStream is;
    private String type;
    private boolean logger;

    public TranslatorStreamHandler(InputStream is, String type, boolean logger) {
        this.is = is;
        this.type = type;
        this.logger = logger;
    }

    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            if (logger) {
                while ((line = br.readLine()) != null) {
                    System.out.println(type + ">" + line);
                }
            } else {
                while ((line = br.readLine()) != null) {
                    //Consume
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
