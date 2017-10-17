# grapho
This is the back end service for the dynamic chart.
## Services 
Following are the different services avilable in this project 
### A. OAuth2 Service
#### 1. Authorization Token service 
Service url : grapho/oauth/token

Request Structure : curl -u <client_id>:<client_secret> http://<IP>:<port>/<context-root>/oauth/token -d "grant_type=password&username=<userName>&password=<Password>"

Response JSON string contains access_token. Set this authorization token to acces the services.

