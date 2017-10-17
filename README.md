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
<pre>
Service URL : grapho/connector/meta
Request Type: POST
Request Data :
{

"connectorName":"MYSQL connector",
"validationRegEx":"",
"configTemplate":"import MySQLdb \n${{connectionVariable}} = MySQLdb.connect(host=${{host}},user=${{userName}}, 
passwd=${{password}},db=${{dbName}}",
"config":
	"{
	 "userName":"<value>",
	 "password":"<value>",
    	 "host":"<value>",	 
	 "port":"<value>",	 
	 "dbName":"<value>",	 
	 "connectionVariable":"<value>"	 
	}"	
}
</pre>

Curl Request sample : 

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -X POST -d '{"connectorName":"MYSQL 				 connector","validationRegEx":"","configTemplate":"import MySQLdb \n${{connectionVariable}} = MySQLdb.connect(host=${{host}},user=${{userName}}, passwd=${{password}},db=${{dbName}}","config":"{\"userName\":\"<value>\",\"password\":\"<value>\",\"host\":\"<value>\",\"port\":\"<value>\",\"dbName\":\"<value>\",\"connectionVariable\":\"<value>\"}"}' http://192.168.127.82:8080/grapho/connector/meta

#### 1. Read Connector Meta
<pre>
<pre>
Service URL : grapho/connector/meta/{id}
Request Type: GET
{id}        : Meta Id 
</pre>

