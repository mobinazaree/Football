package applauncher;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class FootBallAppAPI {
    
    public static JSONArray getLeagueData(String countryName){
        
        // set LeagueID and seasonYear base on countryName
        int LeagueID = 0;
        int seasonYear = 0;
        
        switch(countryName){
            case "italy":
                LeagueID = 135;
                seasonYear = 2023;
                break;
            case "germany":
                LeagueID = 78;
                seasonYear = 2023;
                break;
            case "iran":
                LeagueID = 290;
                seasonYear = 2023;
                break;
            case "spain":
                LeagueID = 140;
                seasonYear = 2023;
                break; 
            case "france":
                LeagueID = 61;
                seasonYear = 2023;
                break;
            case "england":
                LeagueID = 39;
                seasonYear = 2023;
                break;
            case "world cup":
                LeagueID = 1;
                seasonYear = 2022;
                break;          
        }
       
              
        // build API request URL with LeagueID and seasonYear and status
	String urlString = "https://v3.football.api-sports.io/fixtures?" +
	        "league=" + LeagueID + "&season=" + seasonYear + "&status=FT";
        
        try{
            // call api and get response
	    HttpURLConnection conn = fetchApiResponse(urlString);
            
            // check for response status
	    // 200 - means that the connection was a success
	    if(conn.getResponseCode() != 200){
	        System.out.println("Error: Could not connect to API");
	        return null;
	    }
            
            // store resulting json data
            StringBuilder resultJson = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
	    while(scanner.hasNext()){
	        // read and store into the string builder
	        resultJson.append(scanner.nextLine());
	    }
            
            // close scanner
	    scanner.close();

	    // close url connection
	    conn.disconnect();
            
            // parse through our data
            JSONParser parser = new JSONParser();
	    JSONObject resultJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));
            
            // retrieve response data
            JSONArray LeagueDataArray = (JSONArray) resultJsonObj.get("response");
            
            return LeagueDataArray ;
            
        }catch(Exception e){
	    e.printStackTrace();
	}
        
        return null;
    }
    
    
    private static HttpURLConnection fetchApiResponse(String urlString){
	try{
	    // attempt to create connection
	    URL url = new URL(urlString);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	    // set request method to get
	    conn.setRequestMethod("GET");
            
            // set api key
            conn.setRequestProperty("x-rapidapi-key", "33dfba649a01d537be66c03f8b219c06");
            // set api host
            conn.setRequestProperty("x-rapidapi-host", "v3.football.api-sports.io");
            
	    // connect to our API
	    conn.connect();
	    return conn;
            
	}catch(IOException e){
	    e.printStackTrace();
	}

	// could not make connection
	return null;
    }
    
    
}


