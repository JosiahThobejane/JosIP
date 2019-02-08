<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="za.co.josiahthobejane.josipweb.worker"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JosIP | Your IP Address and GeoLocation information</title>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
        
    </head>
    <body>
        <nav class="navbar is-dark is-fluid ">
            <div class="container">
                <div class="navbar-brand">
                        <a class="navbar-item" href="/">JosIP</a>
                </div>
                <div class="navbar-menu" id="navMenu">
                    <div class="navbar-end">			
                        <div class="navbar-item">
                            <p class="control"><a class="button is-white" href="#"><span>Say Hello</span></a></p>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        
    
        <section class="hero is-light is-small is-bold has-text-centered">
            <div class="hero-body">
                <div class="container">
                    <div class="columns is-centered">
                        <div class="column">
                            <h1 class="title is-spaced is-size-1-desktop is-size-2-tablet is-size-3-mobile">GeoLocation &amp;</h1>
                            <h2 class="subtitle is-size-4-desktop">All the things you need to know, <%= request.getRemoteAddr()  
                            %></h2>
                        </div>
                    </div>
                </div>
            </div>						
	    </section>
                        
        <section class="container">
            <ul class="is-4-desktop">
                <li>
                    <p class="is-4 is-bold">Ip Address: ${IpAddress}</p>
                </li>
                <li>
                    <p class="is-4 is-bold">Country: ${UserCountry}</p>
                </li>
                <li>
                    <p class="is-4 is-bold">Province: ${UserProvince}</p>
                </li>
                <li>
                    <p class="is-4 is-bold">City: ${UserCity}</p>
                </li>
                <li>
                    <p class="is-4 is-bold">Latitude: ${UserLat}</p>
                </li>
                <li>
                    <p class="is-4 is-bold">Longitude: ${UserLng}</p>
                    <a href="${googleMapsLink}" target="_blank" class="button has-background-info has-text-white is-normal">Open In Google Maps</a>
                </li>
                
            </ul>
        </section>
        
    </body>
</html>
