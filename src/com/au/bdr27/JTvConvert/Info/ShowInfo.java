/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.bdr27.JTvConvert.Info;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brendan
 */
public class ShowInfo {
    private final long id;
    private final String name;
    private ArrayList<EpisodeInfo> episodes;
    
    public ShowInfo(long id, String name){
        this.id = id;
        this.name = name;
    }
    
    public List<EpisodeInfo> getEpisodes(){
        return episodes;
    }
    
    public void setEpisodes(ArrayList<EpisodeInfo> episodes){
        this.episodes = episodes;
    }
    
    public long getID(){
        return id;
    }
    
    public String getname(){
        return name;
    }
    
    public String getEpisodeName(long season, long episodeNumber){
        String episodeName = "";
        for(EpisodeInfo episodeInfo : episodes){
            if(episodeInfo.getSeason() == season && episodeInfo.getEpisode() == episodeNumber){
                episodeName = episodeInfo.getName();
                break;
            }
        }
        return episodeName;
    }
}
