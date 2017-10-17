# Grapho
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

#### 2. Read Connector Meta
<pre>
Service URL : grapho/connector/meta/{id}
Request Type: GET
{id}        : Meta Id
Response Data: 
{
"connectorMetaId":"1",
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

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" http://192.168.127.82:8080/grapho/connector/meta/{id}

#### 3. Update Connector Meta
<pre>
Service URL : grapho/connector/meta
Request Type: PUT
Request Data :
{
"connectorMetaId":"1",
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
curl request sample 

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json"  -X PUT -d '{"connectorMetaId":"2","connectorName":"MYSQL Connector meta ","validationRegEx":"","configTemplate":"import MySQLdb \n${{connectionVariable}} = MySQLdb.connect(host=${{host}},user=${{userName}}, passwd=${{password}},db=${{dbName}}","config":"{\"userName\":\"<value>\",\"password\":\"<value>\",\"host\":\"<value>\",\"port\":\"<value>\",\"dbName\":\"<value>\",\"connectionVariable\":\"<value>\"}"}' http://192.168.127.82:8080/grapho/connector/meta
	
#### 4. Delete Connector Meta
<pre>
Service URL : grapho/connector/meta/{id}
Request Type: DELETE
{id}        : Meta Id

Response Data :
{
"connectorMetaId":"1",
}
</pre>
curl request Sample 
curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -X DELETE  http://192.168.127.82:8080/grapho/connector/meta/{id}

#### 5. Find All Connector Meta
<pre>
Service URL  : grapho/connector/meta
Request Type : GET
Response Data: Collection of Connector Meta
</pre>

curl request Sample 

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" http://192.168.127.82:8080/grapho/connector/meta
