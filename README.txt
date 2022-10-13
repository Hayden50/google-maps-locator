## Overview
In this project, utilized the Google Cloud Application Programming Interface (API)
to provide users with the closest nearby locations of interest given an input latitude and longitude and search radius.
Within the web-app, there is an authentication service with account creation and login
as well as a map visual for the user. This was done using a React frontend and a SpringBoot (SB) backend. 

## Problem Statement
Tourists need an effective way to find points of interest (Hotels, Entertainment, Restaurants, etc.) in the places they travel to.
We need to create software that makes these places easy to find near a given location.  

## Technologies
Front-end​
    -JavaScript using the React framework​
    -HTML​
    -CSS  ​
Backend​
    -Java using Spring Boot ​
    -OAuth 2.0 Authorization with Google Cloud Store Data base ​
    -Maven​
    -Google Maps API, Google Places API ​
VCS​
    -Git and GitHub​
Deployment​
    -Google Cloud Platform​
​



## Installation and Setup -- FOR DEVELOPMENT

-- Make sure that Maven and NodeJS are installed before continuing

1. Create local git repo and pull files
2. cd into frontend folder and run "npm install" in your terminal (this will install all dependencies)
3. While in frontend folder, run "npm run dev" (this starts your frontend server locally)
4. cd back into the main directory
5. run "mvn spring-boot:run"

At this point, the frontend and backend should be working locally. Frontend is active on localhost:3000 with a
proxy to the backend at localhost:3000/api, and the backend is running on localhost:8080.

In order to make changes on the backend, create and edit files in the src/main/java directory. For edits to the 
frontend, make changes in the frontend/src file.
