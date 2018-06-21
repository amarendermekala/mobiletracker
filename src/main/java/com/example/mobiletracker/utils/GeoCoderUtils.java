package com.example.mobiletracker.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeoCoderUtils {

    private static final String GOOGLE_API_URL = "http://maps.googleapis.com/maps/api/geocode/json";

    public static String getAddressByGpsCoordinates(String lat, String lng)
            throws IOException {

        URL url = new URL(GOOGLE_API_URL + "?latlng="+ lat + "," + lng + "&sensor=true");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        String formattedAddress = "";

        try {
            InputStream in = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String response, line = reader.readLine();
            response = line;
            while ((line = reader.readLine()) != null) {
                response += line;
            }
            JSONParser parser = new JSONParser();
            JSONObject allResults = (JSONObject) parser.parse(response);

            if (allResults.containsKey("results")) {
                JSONArray results = (JSONArray) allResults.get("results");
                for(Object result: results) {
                    JSONObject data = (JSONObject) result;
                    JSONArray types = (JSONArray) data.get("types");
                    if(types.contains("street_address")) {
                        formattedAddress = (String) data.get("formatted_address");
                        System.out.println("Street Address " + types + formattedAddress);
                    } else {
                        System.out.println("Other Types " + types + data.get("formatted_address"));
                    }
                }
            }
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }
        finally {
            urlConnection.disconnect();
            return formattedAddress;
        }

    }
}
