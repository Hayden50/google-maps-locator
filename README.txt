## Overview

## Installation and Setup -- FOR DEVELOPMENT

1. Create local git repo and pull files
2. cd into frontend folder and run "npm install" in your terminal (this will install all dependencies)
3. While in frontend folder, run "npm run dev" (this starts your frontend server locally)
4. cd back into the main directory
5. run springboot in your terminal (this starts the backend server locally)

At this point, the frontend and backend should be working locally. Frontend is active on localhost:3000 with a
proxy to the backend at localhost:3000/api, and the backend is running on localhost:8080.

In order to make changes on the backend, create and edit files in the src/main/java directory. For edits to the 
frontend, make changes in the frontend/src file.
