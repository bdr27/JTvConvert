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
public abstract class AFolderStructure {
    protected final String folderRoot;
    protected final String pattern;
    protected ArrayList<FileInfo> filesToConvert;
//Need an object for original name and what to change into to
    
    //Pattern will contrain "season" and "disc" to show where the discs are and seaons are
    public AFolderStructure(String folderRoot, String pattern){
        this.folderRoot = folderRoot;
        this.pattern = pattern;
    }
    
    public abstract void populateFilesToConvert() throws Exception;
    
    public ArrayList<FileInfo> getFilesToConvert() throws Exception{
        if(filesToConvert == null){
            populateFilesToConvert();
        }
        return filesToConvert;
    }
}
