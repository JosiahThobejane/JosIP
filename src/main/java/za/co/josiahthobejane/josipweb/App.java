package za.co.josiahthobejane.josipweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
//import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.google.gson.Gson;
import java.util.Scanner;

public class App {

    public UserLocationData user = null;
    public Location location;
   
    /*
    public static void main(String[] args) {
        App run = new App();
        run.getUserDetails("102.250.4.28");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to open your location in Google Maps?");
        int decider = scanner.nextInt();

        if(decider == 1){
            run.launchOnGoogleMaps(run.location.getLng(), run.location.getLat());
        }
    } */

    public void setValues() {
        // set all the values
        location.setCountry(user.userLocation.get("country"));
        location.setRegion(user.userLocation.get("region"));
        location.setCity(user.userLocation.get("city"));
        location.setLat(Double.parseDouble(user.userLocation.get("lat")));
        location.setLng(Double.parseDouble(user.userLocation.get("lng")));
        location.setPostalCode(user.userLocation.get("postalCode"));
        location.setTimezone(user.userLocation.get("timezone"));
    }

    public void getUserDetails(String userIP) {
        location = new Location();

        String API_KEY = "at_RaqDV0AgbNJzNFZpYzdPQWLBW3lQe";
        String API_URL = "https://geo.ipify.org/api/v1?";
        // the full api link
        String URL = API_URL + "apiKey=" + API_KEY + "&ipAddress=" + userIP;

        try {
            URL apiURL = new URL(URL);
            URLConnection conn = apiURL.openConnection();

            BufferedReader rr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            user = new Gson().fromJson(rr, UserLocationData.class);
            rr.close();
            // set values of our user
            setValues();

            // print the values of our user
            System.out.println("Hey there: " + System.getProperty("os.user") + "Your IP Address: " + userIP
                    + "\nYour Country: " + location.getCountry() + "\nYour Province/Region: " + location.getRegion()
                    + "\nYour City: " + location.getCity() + "\nYour Latitude: " + location.getLat()
                    + "\nYour Longitude: " + location.getLng() + "\nYour Postal Code: " + location.getPostalCode()
                    + "\nYour Time Zone: " + location.getTimezone());

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void launchOnGoogleMaps(double latitude, double longitude) {
        String googleMapsLink = "https://www.google.com/maps/search/?api=1&query=";
        String parameters = Double.toString(latitude) + "," + Double.toString(longitude);
        
        
         try {
            String MAP_link = googleMapsLink + URLEncoder.encode(parameters, "UTF-8");
            
            Runtime.getRuntime().exec(new String[] {"cmd", "/c","start chrome " + URI.create(MAP_link)});
		} catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
