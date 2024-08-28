package com.lowLevelDesign.designPatterns.rest_api;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CompletionWinnerGoalsCalculator {

    public static void main(String[] args) throws IOException {

        String url1 = "https://jsonmock.hackerrank.com/api/football_competitions?name=%s&year=%s";
        String winner = getWinner(url1,"UEFA Champions League","2011");
        System.out.println(winner);
        String url2 = "https://jsonmock.hackerrank.com/api/football_matches?competition=%s&year=%s&team1=%s&page=%s";
        String url3 = "https://jsonmock.hackerrank.com/api/football_matches?competition=%s&year=%s&team2=%s&page=%s";
        Long total = 0L;
        int currPage = 1;
        int total_page = 1;
        do{
            Res result = getGoals(url2,"UEFA Champions League","2011",winner,currPage);
            total+= result.team1;
            total_page = result.total_page;
            currPage++;
        }while(currPage<=total_page);
        currPage=1;total_page=1;
        do{
            Res result = getGoals(url3,"UEFA Champions League","2011",winner,currPage);
            total+= result.team2;
            total_page = result.total_page;
            currPage++;
        }while(currPage<=total_page);
        System.out.println(total);
    }


    public static class Page{
     List<Data> data;
    }

    public static class Data{
        String name;
        int year;
        String winner;
        String runnerup;
    }

    public static class Pg{
        int page;
        int total_pages;
        List<D> data;
    }
    public static class D{
        String team1goals;
        String team2goals;
    }

    public static class Res{
        long team1;
        long team2;
        int page;
        int total_page;
    }

    public static String getWinner(String url,String name, String year) throws IOException {
        String eName = URLEncoder.encode(String.valueOf(name), StandardCharsets.UTF_8.toString());
        String eYear = URLEncoder.encode(String.valueOf(year), StandardCharsets.UTF_8.toString());
        eName = eName.replace("+","%20");
        url = String.format(url,eName,eYear);

        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(url).openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String str=null;
        while((str=bufferedReader.readLine())!=null){
            sb.append(str);
        }
        Gson gson = new Gson();
        Page page = gson.fromJson(sb.toString(),Page.class);
        return page.data.stream().findFirst().get().winner;
    }

    public static Res getGoals(String url,String name,String year,  String team, int pageNo) throws IOException {
        String eName = URLEncoder.encode(String.valueOf(name), StandardCharsets.UTF_8.toString());
        String eYear = URLEncoder.encode(String.valueOf(year), StandardCharsets.UTF_8.toString());
        String eTeam = URLEncoder.encode(String.valueOf(team), StandardCharsets.UTF_8.toString());
        eName = eName.replace("+","%20");
        eTeam = eTeam.replace("+","%20");
        url = String.format(url,eName,eYear,eTeam,String.valueOf(pageNo));

        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(url).openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String str=null;
        while((str=bufferedReader.readLine())!=null){
            sb.append(str);
        }
        Gson gson = new Gson();
        Pg page = gson.fromJson(sb.toString(),Pg.class);
        Res result = new Res();
        result.team1 = page.data.stream().mapToLong(data-> Long.parseLong(data.team1goals)).sum();
        result.team2 = page.data.stream().mapToLong(data-> Long.parseLong(data.team2goals)).sum();
        result.page = page.page;
        result.total_page = page.total_pages;
        return result;
    }


}
