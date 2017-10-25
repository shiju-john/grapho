INSERT INTO users(username,password,enabled) VALUES ('reader','reader', true);
INSERT INTO users(username,password,enabled) VALUES ('writer','writer', true);
INSERT INTO users(username,password,enabled) VALUES ('executer','executer', true);
INSERT INTO user_roles (username, role) VALUES ('reader', 'read');
INSERT INTO user_roles (username, role) VALUES ('writer', 'write');
INSERT INTO user_roles (username, role) VALUES ('executer', 'execute');
INSERT INTO oauth_client_details 
(client_id,resource_ids,client_secret,scope,authorized_grant_types,web_server_redirect_uri,authorities,access_token_validity, refresh_token_validity, autoapprove) 
VALUES('grapho','job','grapho','read','implicit,refresh_token,client_credentials,password,authorization_code', 'www.flytxt.com','read,write,execute',0,0, 'true');
INSERT INTO config_data(cd_key,cd_value,cd_type) VALUES ('ZeppelinUrl','url', 'Zeppelin');
INSERT INTO config_data(cd_key,cd_value,cd_type) VALUES ('ZeppelinPort','port', 'Zeppelin');
INSERT INTO config_data(cd_key,cd_value,cd_type) VALUES ('ZeppelinAuthUrl','AuthReporstUrl', 'Zeppelin');
