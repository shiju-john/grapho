CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  email VARCHAR(150),
  PRIMARY KEY (username)
);
CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id)
);


drop table if exists oauth_client_details;
create table oauth_client_details (
	client_id VARCHAR(255) PRIMARY KEY,
	client_secret VARCHAR(255),
	resource_ids VARCHAR(255),
	scope VARCHAR(255),
	authorized_grant_types VARCHAR(255),
	web_server_redirect_uri VARCHAR(255),
	authorities VARCHAR(255),
	access_token_validity INTEGER,
	refresh_token_validity INTEGER,
	additional_information VARCHAR(4096),
	autoapprove VARCHAR(255)
);
