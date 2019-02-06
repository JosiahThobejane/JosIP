/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.josiahthobejane.josipweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


import za.co.josiahthobejane.josipweb.App;
/**
 *
 * @author Josiah Thobejane
 */
public class worker extends HttpServlet {

    public UserLocationData user = null;
    public Location location;
    String googleMapsLink;
    
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
            this.googleMapsLink = MAP_link;
            }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public String getClientIp(HttpServletRequest request)
    {
        String userIpAddress = "";
        
        if(request != null)
        {
            userIpAddress = request.getHeader("X-FORWARDED-FOR");
            if(userIpAddress == null || "".equals(userIpAddress))
            {
                userIpAddress = request.getRemoteAddr();
            }
        }
        
        return userIpAddress;
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        getUserDetails(getClientIp(request));
        try {
            request.setAttribute("IpAddress", request.getRemoteAddr());
            request.setAttribute("UserCountry", location.getCountry());
            request.setAttribute("UserProvince", location.getRegion());
            request.setAttribute("UserCity", location.getCity());
            request.setAttribute("UserLat", location.getLat());
            request.setAttribute("UserLng", location.getLng());
            request.setAttribute("googleMapsLink", this.googleMapsLink);
          
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
            
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
