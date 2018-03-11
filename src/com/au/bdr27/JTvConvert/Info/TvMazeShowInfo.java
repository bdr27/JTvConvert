/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.bdr27.JTvConvert.Info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
        /**
         *
         * @author Brendan
         */

public class TvMazeShowInfo extends AGetShowInfo {
    
    public TvMazeShowInfo(String config) {
        super(config);
    }

    @Override
    public void updateShowInfo() throws IOException, ParseException {
        populateShowInfo();
        populateEpisodeInfo();
    }
    
    private void populateEpisodeInfo() throws IOException, ParseException{
        JSONArray episodeArry = getJsonArray(String.format("http://api.tvmaze.com/shows/%d/episodes", showInfo.getID()));
        ArrayList<EpisodeInfo> episodesInfo = new ArrayList<>();
        for(int i = 0; i < episodeArry.size(); i++){
            //showid, season, episode, name
            long showID = showInfo.getID();
            JSONObject jsonEpisode = (JSONObject)episodeArry.get(i);
            long season = (long)jsonEpisode.get("season");
            long episode = (long)jsonEpisode.get("number");
            String name = (String)jsonEpisode.get("name");
            EpisodeInfo episodeInfo = new EpisodeInfo(showID, season, episode, name);
            episodesInfo.add(episodeInfo);
        }
        showInfo.setEpisodes(episodesInfo);
    }
    
    private void populateShowInfo() throws IOException, ParseException{
            JSONArray showArray = getJsonArray(String.format("http://api.tvmaze.com/search/shows?q=%s", config));//(JSONArray) parser.parse(jsonText);
            JSONObject showJson = (JSONObject) showArray.get(0);
            JSONObject showDetails = (JSONObject) showJson.get("show");
            String name = (String) showDetails.get("name");
            long id = (long) showDetails.get("id");
            showInfo = new ShowInfo(id, name);
    }
    
    private JSONArray getJsonArray(String url)throws IOException, ParseException{
        JSONArray showArray;
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);            
            JSONParser parser = new JSONParser();
            showArray = (JSONArray) parser.parse(jsonText);
        }
        return showArray;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
