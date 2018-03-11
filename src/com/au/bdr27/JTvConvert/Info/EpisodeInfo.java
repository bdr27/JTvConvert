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
public class EpisodeInfo {
    private final long showID;
    private final long season;
    private final long episode;
    private final String name;
    
    public EpisodeInfo(long showID, long season, long episode, String name){
        this.showID = showID;
        this.season = season;
        this.episode = episode;
        this.name = name;
    }
    
    public long getShowID(){
        return showID;
    }
    
    public long getSeason(){
        return season;
    }
    
    public long getEpisode(){
        return episode;
    }
    
    public String getName(){
        return name;
    }
}
