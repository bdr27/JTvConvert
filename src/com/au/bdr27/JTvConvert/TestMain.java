/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.bdr27.JTvConvert;

import com.au.bdr27.JTvConvert.Info.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brendan
 */
public class TestMain {
    public static void main(String[] args) {
        AGetShowInfo info = new TvMazeShowInfo("Yu-Gi-Oh!%20Duel%20Monsters");
        try {
            ShowInfo showInfo = info.getShowInfo();
            String phateOfThePharoh2o3;
            phateOfThePharoh2o3 = showInfo.getEpisodeName(4, 12);
            System.out.println(phateOfThePharoh2o3);
            System.out.println("I Got Shows");
            AFolderStructure struct = new FolderPerDisc("E:\\VIDEO", "YU_GI_OH_SEASON[3]_DISC[3-7]");
            ArrayList<FileInfo> files = struct.getFilesToConvert();
            System.out.println("I got files");
        } catch (Exception ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
