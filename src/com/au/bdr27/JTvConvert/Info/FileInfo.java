/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.bdr27.JTvConvert.Info;

/**
 *
 * @author Brendan
 */
public class FileInfo {
    private final String originalLocation;
    private final String newLocation;
    
    public FileInfo(String originalLocation, String newLocation){
        this.originalLocation = originalLocation;
        this.newLocation = newLocation;
    }
    
    public String GetOriginalLocation(){
        return originalLocation;
    }
    
    public String GetNewLocation(){
        return newLocation;
    }
}
