package com.lowLevelDesign.designPatterns.rest_api;

import com.google.gson.Gson;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import javax.net.ssl.*;

public class PulseChecker {

    public static void main(String[] args) throws IOException {
        long totalValue = 0;
        long totalCount = 0;
        int currPage = 1;
        int totalPage = 1;
        do{
            Result result = invoke(currPage,"Pulmonary embolism",2);
            totalValue += result.value;
            totalCount += result.count;
            totalPage = result.totalPages;
            currPage++;
        }while(currPage<=totalPage);

        System.out.println(totalValue/totalCount);

    }


    public static class Page{
        int page;
        int total;
        int per_page;
        int total_pages;
        List<Data> data;
    }

    public static class Result{
        int pageNo;
        long value;
        long count;
        int totalPages;
    }

    public static class Data{
        Diagnosis diagnosis;
        Vitals vitals;
        Doctor doctor;
    }

    public static class Diagnosis{
        String name;
    }

    public static class Doctor{
        int id;
    }


    public static class Vitals{
        int pulse;
    }



    public static Result invoke(int pageNo, String disease, int doctorId) throws IOException {
        String baseUrl = "https://jsonmock.hackerrank.com/api/medical_records?page=";
        HttpsURLConnection connection = (HttpsURLConnection) new URL(baseUrl+pageNo).openConnection();
        connection.setRequestMethod("GET");
        InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStream);
        StringBuilder sb = new StringBuilder();
        String str=null;
        while((str=bufferedReader.readLine())!=null){
            sb.append(str);
        }
        Gson gson = new Gson();
        Page page = gson.fromJson(sb.toString(), Page.class);
        long total=0;
        long val = 0;
        if(StringUtils.hasText(disease)){
             val = page.data.stream().filter(data -> data.diagnosis.name.equals(disease) && (data.doctor.id==doctorId)).mapToInt(data->data.vitals.pulse).sum();
             total = page.data.stream().filter(data -> data.diagnosis.name.equals(disease) && (data.doctor.id==doctorId) ).count();
        }
        System.out.println(page);
        Result result = new Result();
        result.value = val;
        result.count = total;
        result.pageNo= page.page;
        result.totalPages = page.total_pages;
        return result;
    }




}
