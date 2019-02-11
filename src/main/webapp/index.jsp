<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="za.co.josiahthobejane.josipweb.worker"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JosIP | Your IP Address and GeoLocation information</title>
        
        <link rel="stylesheet" href="https://github.com/Wikiki/bulma-pageloader/blob/master/dist/css/bulma-pageloader.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">     
        <link rel="stylesheet" href="assets/css/style.css">
        
    </head>
    
    <body>
        <div class="pageloader is-right-to-left"></div>
        <!--
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
        </nav> -->
        
        <div class="container">
            <div class="center-vertical">
                <div class="card z-depth">
                    <div class="card-content">
                        <div class="content">
                            <div class="has-text-centered">
                                <p class="subtitle text-color-light">Your public IP Address</p>
                                <p class="title text-color">${IpAddress}</p>
                            </div>
                            <hr class="line-color-light">

                            <div class="level">

                                <div class="level-item ">
                                    <div>
                                        <p class="heading text-color-light">Country</p>                                        
                                        <img src="${CountryFlag}" alt="country flag">
                                    </div>
                                </div>
                                <div class="level-item ">
                                    <div>
                                        <p class="heading text-color-light">Province</p>
                                        <p class="title text-color">${UserProvince}</p>
                                    </div>
                                </div>
                                <div class="level-item ">
                                    <div>
                                        <p class="heading text-color-light">City</p>
                                        <p class="title text-color">${UserCity}</p>
                                    </div>
                                </div>
                                <div class="level-item ">
                                    <div>
                                        <p class="heading text-color-light">Postal Code</p>
                                        <p class="title text-color">${postalCode}</p>
                                    </div>
                                </div>
                            </div>

                            <hr class="line-color-light"><!-- The Technicals Part -->
                            <div class="level">
                                <div class="level-item">
                                    <div>
                                        <p class="heading text-color-light">Latitude</p>
                                        <p class="title text-color">${UserLat}</p>
                                    </div>
                                </div>
                                <div class="level-item">
                                    <div>
                                        <p class="heading text-color-light">Longitude</p>
                                        <p class="title text-color">${UserLng}</p>
                                    </div>
                                </div>
                                <div class="level-item">
                                    <div>
                                        <p class="heading text-color-light">Time Zone</p>
                                        <p class="title text-color">${timezone}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="level">
                                <div class="level-item">
                                    <div>
                                        <a href="${googleMapsLink}" target="_blank" class="button is-info google-maps-button">See in Google Maps</a>
                                    </div>
                                </div>
                                <div class="level-item">
                                    <div>
                                        <a href="https://github.com/JosiahThobejane/JosIP" target="_blank" class="button is-info google-maps-button">GitHub</a>
                                    </div>
                                </div>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </body>
</html>
