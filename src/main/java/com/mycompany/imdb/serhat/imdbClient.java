
package com.mycompany.imdb.serhat;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.net.URLEncoder;


public class imdbClient {

    String api = "https://rapidapi.p.rapidapi.com/";
    
    
    public String movieBringerByName(String name) throws Exception{
        String query = String.format("s=%s", URLEncoder.encode(name, "UTF-8"));
        HttpResponse<JsonNode> response = Unirest.get(api + "?" + query)
            .header("x-rapidapi-key", "3be21e509cmshec29680c1ce058ep10f903jsn29ff68d59ba0")
            .header("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
            .asJson();
        
        String veriGönder = response.getBody().getObject().getJSONArray("Search").getJSONObject(0).getString("imdbID");
        return veriGönder;
    }
    
    
    public HttpResponse<JsonNode> movieBringerByID(String id) throws Exception{
        String query = String.format("i=%s", id);
        HttpResponse<JsonNode> response = Unirest.get(api + "?" + query)
            .header("x-rapidapi-key", "3be21e509cmshec29680c1ce058ep10f903jsn29ff68d59ba0")
            .header("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
            .asJson();
        return response;
    }
   
    
}
