
CREATE TABLE IF NOT EXISTS event_outcomes (
	Outcome_Code		INT				NOT NULL	AUTO_INCREMENT,
	Description			VARCHAR(150)	NOT NULL,
	PRIMARY KEY (Outcome_Code)
);

ALTER TABLE event_outcomes AUTO_INCREMENT = 10;

CREATE TABLE IF NOT EXISTS event_status (
	Status_Code			INT				NOT NULL	AUTO_INCREMENT,
	Description			VARCHAR(150)	NOT NULL,
	PRIMARY KEY (Status_Code)
);

ALTER TABLE event_status AUTO_INCREMENT = 10;

CREATE TABLE IF NOT EXISTS event_types (
	Type_Code			INT				NOT NULL	AUTO_INCREMENT,
	Description			VARCHAR(150)	NOT NULL,
	PRIMARY KEY (Type_Code)
);

ALTER TABLE event_types AUTO_INCREMENT = 10;

CREATE TABLE IF NOT EXISTS events (
	Event_ID			INT				NOT NULL	AUTO_INCREMENT,
	Event_Name 			VARCHAR(50)		NOT NULL,
	Event_From_Date		DATE			NOT NULL,
	Event_To_Date		DATE			NOT NULL,
	Event_Result		VARCHAR(50)		NOT NULL,
	Street				VARCHAR(50)		NOT NULL,
	Locality			VARCHAR(50)		NOT NULL,
	State				VARCHAR(50)		NOT NULL,
	City				VARCHAR(50)		NOT NULL,
	Country				VARCHAR(50)		NOT NULL,
	Event_Description	VARCHAR(150)	NOT NULL,
	Other_Details		VARCHAR(150)	NOT NULL,
	Outcome_Code		INT				NOT NULL,
	Status_Code			INT				NOT NULL,
	Type_Code			INT				NOT NULL,
	PRIMARY KEY (Event_ID),
	FOREIGN KEY (Outcome_Code) REFERENCES event_outcomes (Outcome_Code) ON DELETE CASCADE,
	FOREIGN KEY (Status_Code) REFERENCES event_status (Status_Code) ON DELETE CASCADE,
	FOREIGN KEY (Type_Code) REFERENCES event_types (Type_Code) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS vehicle_types (
	Vehicle_Type_Code	INT				NOT NULL	AUTO_INCREMENT,
	Description			VARCHAR(150)	NOT NULL,
	PRIMARY KEY (Vehicle_Type_Code)
);

ALTER TABLE vehicle_types AUTO_INCREMENT = 10;

CREATE TABLE IF NOT EXISTS vehicles (
	Vehicle_ID			INT				NOT NULL	AUTO_INCREMENT,
	Vehicle_Type_Code	INT				NOT NULL,
	PRIMARY KEY (Vehicle_ID),
	FOREIGN KEY (Vehicle_Type_Code) REFERENCES vehicle_types  (Vehicle_Type_Code) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS event_have_vehicles (
	Event_ID			INT				NOT NULL,
	Vehicle_ID			INT				NOT NULL,
	Time				INT				NOT NULL,	
	PRIMARY KEY (Event_ID, Vehicle_ID),
	FOREIGN KEY (Event_ID) REFERENCES events (Event_ID) ON DELETE CASCADE,
	FOREIGN KEY (Vehicle_ID) REFERENCES vehicles (Vehicle_ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS organisation_types (
	Org_Type_Code		INT				NOT NULL	AUTO_INCREMENT,
	Description			VARCHAR(150)	NOT NULL,
	PRIMARY KEY (Org_Type_Code)
);

ALTER TABLE organisation_types AUTO_INCREMENT = 10;

CREATE TABLE IF NOT EXISTS organisations (
	Org_ID 				INT				NOT NULL	AUTO_INCREMENT,
	Org_Name			VARCHAR(50)		NOT NULL,
	Org_Phone			INT				NOT NULL,
	Street				VARCHAR(50)		NOT NULL,
	Locality			VARCHAR(50)		NOT NULL,
	State				VARCHAR(50)		NOT NULL,
	City				VARCHAR(50)		NOT NULL,
	Country				VARCHAR(50)		NOT NULL,
	Org_Description		VARCHAR(150)	NOT NULL,
	Other_Details		VARCHAR(150)	NOT NULL,
	Super_Org_ID		INT				NOT NULL,
	Org_Type_Code		INT				NOT NULL,
	PRIMARY KEY (Org_ID),
	UNIQUE KEY (Org_Name, Org_Phone),
	FOREIGN KEY (Super_Org_ID) REFERENCES organisations (Org_ID) ON DELETE CASCADE,
	FOREIGN KEY (Org_Type_Code) REFERENCES organisation_types (Org_Type_Code) ON DELETE CASCADE	
);

CREATE TABLE IF NOT EXISTS event_own_organisation (
	Event_ID			INT				NOT NULL,
	Org_ID				INT				NOT NULL,
	PRIMARY KEY (Event_ID, Org_ID),
	FOREIGN KEY (Event_ID) REFERENCES events (Event_ID) ON DELETE CASCADE,
	FOREIGN KEY (Org_ID) REFERENCES organisations (Org_ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS people (
	People_ID 			INT				NOT NULL	AUTO_INCREMENT,
	First_Name			VARCHAR(50)		NOT NULL,
	Middle_Name			VARCHAR(50)		NOT NULL,
	Last_Name			VARCHAR(50)		NOT NULL,
	Gender				ENUM ('M', 'F')	NOT NULL,
	Date_of_Birth		DATE			NOT NULL,
	Street				VARCHAR(50)		NOT NULL,
	Locality			VARCHAR(50)		NOT NULL,
	State				VARCHAR(50)		NOT NULL,
	City				VARCHAR(50)		NOT NULL,
	Country				VARCHAR(50)		NOT NULL,
	Other_Details		VARCHAR(150)	NOT NULL,
	PRIMARY KEY (People_ID)
);

CREATE TABLE IF NOT EXISTS roles (
	Role_Code			INT				NOT NULL	AUTO_INCREMENT,
	Description			VARCHAR(150)	NOT NULL,
	PRIMARY KEY (Role_Code)
);

ALTER TABLE roles AUTO_INCREMENT = 100;

CREATE TABLE IF NOT EXISTS event_inside_people (
	Event_ID			INT				NOT NULL,
	People_ID			INT				NOT NULL,
	Role_Code			INT				NOT NULL,
	PRIMARY KEY (Event_ID, People_ID),
	FOREIGN KEY (Event_ID) REFERENCES events (Event_ID) ON DELETE CASCADE,
	FOREIGN KEY (People_ID) REFERENCES people (People_ID) ON DELETE CASCADE,
	FOREIGN KEY (Role_Code) REFERENCES roles (Role_Code) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS people_works_for_organisation (
	People_ID 			INT				NOT NULL,
	Org_ID 				INT				NOT NULL,
	Role_Code 			INT				NOT NULL,
	Work_From_Date		DATE			NOT NULL,
	Work_To_Date		DATE			NOT NULL,
	PRIMARY KEY(People_ID),
	FOREIGN KEY (People_ID) REFERENCES people (People_ID) ON DELETE CASCADE,
	FOREIGN KEY (Org_ID) REFERENCES organisations (Org_ID) ON DELETE CASCADE,
	FOREIGN KEY (Role_Code) REFERENCES roles (Role_Code) ON DELETE CASCADE
);