/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.bdr27.JTvConvert.Info;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 *
 * @author Brendan
 */
public class FolderPerDisc extends AFolderStructure {

    File directory;

    public FolderPerDisc(String folderRoot, String pattern) {
        super(folderRoot, pattern);
        directory = new File(folderRoot);
    }

    //This method needs to be rethinked
    @Override
    public void populateFilesToConvert() throws IOException {
        filesToConvert = new ArrayList<>();
        FileFilter fileFilter = (file) -> file.isDirectory() && file.getName().matches(pattern);
        File[] directories = directory.listFiles(fileFilter);
        for (File f : directories) {//        File f = directories[0];
            System.out.println("Name: " + f.getName());
            System.out.println("Path: " + f.getPath());
            System.out.println("absolute: " + f.getAbsolutePath());
            System.out.println("Parent: " + f.getParent());
            System.out.println("Canonical: " + f.getCanonicalPath());
            String[] test = f.getName().split("-?\\d+");
            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher(f.getName());
            while (m.find()){
                System.out.println(m.group());
            }
            System.out.println("I am now here");
        }
        System.out.println("HEre we Go");
    }
}
