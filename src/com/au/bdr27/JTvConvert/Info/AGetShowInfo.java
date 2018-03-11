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
public abstract class AGetShowInfo {
    protected String config;
    protected ShowInfo showInfo;
    
    public AGetShowInfo(String config){
        this.config = config;
    }
    
    public abstract void updateShowInfo() throws Exception;
    
    public ShowInfo getShowInfo() throws Exception{
        if(showInfo == null){
            updateShowInfo();
        }
        return showInfo;
    }
}
