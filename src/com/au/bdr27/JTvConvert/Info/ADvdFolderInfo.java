/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.bdr27.JTvConvert.Info;

import java.util.ArrayList;

/**
 *
 * @author Brendan
 */
public abstract class ADvdFolderInfo {
    private final String folderRoot;
    private final String pattern;
    private ArrayList<FileInfo> filesToConvert;
//Need an object for original name and what to change into to
    
    //Pattern will contrain "season" and "disc" to show where the discs are and seaons are
    public ADvdFolderInfo(String folderRoot, String pattern){
        this.folderRoot = folderRoot;
        this.pattern = pattern;
    }
    
    public abstract void populateFilesToConvert();
    
    public ArrayList<FileInfo> getFilesToConvert(){
        if(filesToConvert == null){
            populateFilesToConvert();
        }
        return filesToConvert;
    }
}
