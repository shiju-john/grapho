# grapho
This is the back end service for the dynamic chart.
## Services 
Following are the different services avilable in this project 
### A. OAuth2 Service
#### 1. Authorization Token service 
Service url : grapho/oauth/token

Request Structure : curl -u <client_id>:<client_secret> http://<IP>:<port>/<context-root>/oauth/token -d "grant_type=password&username=<userName>&password=<Password>"

Response JSON string contains access_token. Using this authorization token to acces the services.
### B. Connector MetaData services 
#### 1. Create Connector Meta

Service url : grapho/connector/meta
Request Type: POST
Request Data :

"{

"connectorName":"MYSQL connector",

"validationRegEx":"",

"configTemplate":"import MySQLdb \n${{connectionVariable}} = MySQLdb.connect(host=${{host}},user=${{userName}}, 
passwd=${{password}},db=${{dbName}}",

"config":

	"{"userName":"<value>",
	
	 "password":"<value>",
	 
    	 "host":"<value>",
	 
	 "port":"<value>",
	 
	 "dbName":"<value>",
	 
	 "connectionVariable":"<value>"
	 
	}"
	
}"



