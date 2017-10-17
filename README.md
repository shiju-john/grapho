# Grapho
This is the back end service for the dynamic chart. Service side is written on top of Spring JPA. Which includes the JWT based Authorization using Asymmetrical Encryption.
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

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -X POST -d '{"connectorName":"MYSQL 				 connector","validationRegEx":"","configTemplate":"import MySQLdb \n${{connectionVariable}} = MySQLdb.connect(host=${{host}},user=${{userName}}, passwd=${{password}},db=${{dbName}}","config":"{\"userName\":\"<value>\",\"password\":\"<value>\",\"host\":\"<value>\",\"port\":\"<value>\",\"dbName\":\"<value>\",\"connectionVariable\":\"<value>\"}"}' http://system:port/grapho/connector/meta

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

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" http://system:port/grapho/connector/meta/{id}

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

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json"  -X PUT -d '{"connectorMetaId":"2","connectorName":"MYSQL Connector meta ","validationRegEx":"","configTemplate":"import MySQLdb \n${{connectionVariable}} = MySQLdb.connect(host=${{host}},user=${{userName}}, passwd=${{password}},db=${{dbName}}","config":"{\"userName\":\"<value>\",\"password\":\"<value>\",\"host\":\"<value>\",\"port\":\"<value>\",\"dbName\":\"<value>\",\"connectionVariable\":\"<value>\"}"}' http://system:port/grapho/connector/meta
	
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

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -X DELETE  http://system:port/grapho/connector/meta/{id}

#### 5. Find All Connector Meta
<pre>
Service URL  : grapho/connector/meta
Request Type : GET
Response Data: Collection of Connector Meta
</pre>

curl request Sample 

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" http://system:port/grapho/connector/meta

### C. Connector MetaData Instance services 
#### 1. Create Connector Instance 
<pre>
Service URL : grapho/connector
Request Type: POST
Request Data :
{
"instanceName"	   :"MYSQL connector",
"connectorRefId"   :"1",
"scriptType"       :"Python",
"instanceConfig"   :
	"{"userName":"USER",
	 "password":"PWD",
	 "host":"SYSTEM",
	 "port":"PORT VALUE",
	 "dbName":"TEST",
	 "connectionVariable":"CON"
	}"
}
</pre>

Curl Request sample : 

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -X POST -d '{"instanceName":"MYSQL Connector","connectorRefId":"1","instanceConfig":"{\"userName\":\"USER\",\"password\":\"JAVA@123\",\"host\":\"localhost\",\"port\":\"3039\",\"dbName\":\"TEST_DB\",\"connectionVariable\":\"conn\"}","scriptType":"Python"}' http://192.168.127.82:8080/grapho/connector

#### 2. Read Connector Instance
<pre>
Service URL : grapho/connector/{id}
Request Type: GET
{id}        : Instance Id
Response Data: 
{
"instanceId"	   :"100"	
"instanceName"	   :"MYSQL connector",
"connectorRefId"   :"1",
"scriptType"       :"Python",
"instanceConfig"   :
	"{"userName":"USER",
	 "password":"PWD",
	 "host":"SYSTEM",
	 "port":"PORT VALUE",
	 "dbName":"TEST",
	 "connectionVariable":"CON"
	}"
}
</pre>
Curl Request sample : 

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" http://system:port/grapho/connector/{id}

#### 3. Update Connector Meta
<pre>
Service URL : grapho/connector
Request Type: PUT
Request Data :
{
"instanceId"	   :"100"	
"instanceName"	   :"MYSQL connector",
"connectorRefId"   :"1",
"scriptType"       :"Python",
"instanceConfig"   :
	"{"userName":"USER",
	 "password":"PWD",
	 "host":"SYSTEM",
	 "port":"PORT VALUE",
	 "dbName":"TEST",
	 "connectionVariable":"CON"
	}"
}
</pre>
curl request sample 

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -X PUT -d '{"instanceName":"MYSQL Connector","connectorRefId":"1","instanceConfig":"{\"userName\":\"USER\",\"password\":\"JAVA@123\",\"host\":\"localhost\",\"port\":\"3039\",\"dbName\":\"TEST_DB\",\"connectionVariable\":\"conn\"}","scriptType":"Python"}' http://192.168.127.82:8080/grapho/connector
	
#### 4. Delete Connector Meta
<pre>
Service URL : grapho/connector/{id}
Request Type: DELETE
{id}        : Instance Id

Response Data :
{
"instanceId":"1",
}
</pre>
curl request Sample 

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -X DELETE  http://system:port/grapho/connector/{id}

#### 5. Find All Connector Meta
<pre>
Service URL  : grapho/connector
Request Type : GET
Response Data: Collection of Connector Instance
</pre>

curl request Sample 

curl  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" http://system:port/grapho/connector

