package com.lowLevelDesign.designPatterns.rest_api;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FootballMatchCalculator {

    public static void main(String[] args) throws IOException {

        long answer = 0;
        for(int i=0;i<=10;i++){
            answer += invoke(2011,i,1);
        }
        System.out.println(answer);
    }


    public static class Page{
        int page;
        int total;
        int per_page;
        int total_pages;
        List<Data> data;
    }

    public static class Data{
        int year;
        String team1goals;
        String team2goals;
    }


    public static  long invoke(int year,int goal,int pageNo) throws IOException{

        String urlTemplate = "https://jsonmock.hackerrank.com/api/football_matches?year=%s&team1goals=%s&team2goals=%s&page=%s";

        // URL-encode the parameters
        String encodedYear = URLEncoder.encode(String.valueOf(year), StandardCharsets.UTF_8.toString());
        String encodedTeam1Goals = URLEncoder.encode(String.valueOf(goal), StandardCharsets.UTF_8.toString());
        String encodedTeam2Goals = URLEncoder.encode(String.valueOf(goal), StandardCharsets.UTF_8.toString());
        String encodedPageNo = URLEncoder.encode(String.valueOf(pageNo), StandardCharsets.UTF_8.toString());

        // Prepare the URL by replacing the placeholders with actual values
        String formattedURL = String.format(urlTemplate, encodedYear, encodedTeam1Goals, encodedTeam2Goals, encodedPageNo);


        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)new URL(formattedURL).openConnection();
        httpsURLConnection.setRequestMethod("GET");
        InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String response = null;
        while((response=bufferedReader.readLine())!=null){
            sb.append(response);
        }
        Gson gson = new Gson();
        Page page = gson.fromJson(sb.toString(),Page.class);
        return page.total;
    }


}
