INSERT INTO
	event_outcomes (Description)
VALUES
	('Alive'),
	('Injured'),
	('Critically Wounded'),
	('Death'),
	('Injured & Death');
	
	
INSERT INTO
	event_status (Description)
VALUES
	('Solved'),
	('Unsolved'),
	('Under Investigation'),
	('Closed');
	
INSERT INTO
	event_types (Description)
VALUES
	('Fire'),
	('Crime'),
	('Accident'),
	('Emergency Medical Situation'),
	('Natural Disaster'),
	('Other Emergency Condition');
	
INSERT INTO
	events (Event_Name, Event_From_Date, Event_To_Date, Event_Result, 
	Street, Locality, State, City, Country, Event_Description, 
	Other_Details, Outcome_Code, Status_Code, Type_Code)

VALUES
	('Forest Fire', '2001-02-05', '2001-02-06', 'Extinguised', 
	'Cemetery Road', 'Akron', 'Old Line State', 'Ohio', 'United States',
	'Cause of smoking', '2 people were damaged because of smoke', 
	(SELECT Outcome_Code FROM event_outcomes WHERE Description = 'Alive'), 
	(SELECT Status_Code FROM event_status WHERE Description = 'Under Investigation'), 
	(SELECT Type_Code FROM event_types WHERE Description = 'Fire'));
	
VALUES
	('Accident on Village Road', '2002-05-06', '2002-05-07', 'Hospitalisation', 
	'Route 41', 'The Evergreen', 'Massacehusetts', 'Boston', 'United States',
	'Improperly passing', '3 Cars in accident', 
	(SELECT Outcome_Code FROM event_outcomes WHERE Description = 'Injured & Death'), 
	(SELECT Status_Code FROM event_status WHERE Description = 'Closed'), 
	(SELECT Type_Code FROM event_types WHERE Description = 'Accident'));
	
	
VALUES
	('Bank Robbery', '2003-01-06', '2002-07-07', 'Arrest of the offender', 
	'Union Street', 'Beehive', 'Nevada', 'Las Vegas', 'United States',
	'Kleptomania', 'Other_Details1', 
	(SELECT Outcome_Code FROM event_outcomes WHERE Description = 'Alive'), 
	(SELECT Status_Code FROM event_status WHERE Description = 'Closed'), 
	(SELECT Type_Code FROM event_types WHERE Description = 'Crime'));
	
VALUES
	('Hate Crime', '2004-05-06', '2008-02-07', 'Discrimination', 
	'Colonial Avenue', 'Silver', 'Minnesota', 'St. Paul', 'United States',
	'Clash of ideas', 'Other_Details2', 
	(SELECT Outcome_Code FROM event_outcomes WHERE Description = 'Injured & Death'), 
	(SELECT Status_Code FROM event_status WHERE Description = 'Unsolved'), 
	(SELECT Type_Code FROM event_types WHERE Description = 'Crime'));
	
VALUES
	('Earthquake in Harrisburg', '1998-08-17', '1998-09-10', 'Become permanently disabled and human lost', 
	'Eagle Road', 'Prairie', 'Pennsylvania', 'Harrisburg', 'United States',
	'Fault line fractures', 'Other_Details3', 
	(SELECT Outcome_Code FROM event_outcomes WHERE Description = 'Injured & Death'), 
	(SELECT Status_Code FROM event_status WHERE Description = 'Closed'), 
	(SELECT Type_Code FROM event_types WHERE Description = 'Natural Disaster'));

VALUES
	('Have a cerebral hemorrhage', '2010-01-06', '2010-01-07', 'Be in intensive care unit', 
	'Poplar Street', 'Cornhusker', 'California', 'Sacramento', 'United States',
	'Receive a blow to the head', 'Other_Details4', 
	(SELECT Outcome_Code FROM event_outcomes WHERE Description = 'Critically Wounded'), 
	(SELECT Status_Code FROM event_status WHERE Description = 'Unsolved'), 
	(SELECT Type_Code FROM event_types WHERE Description = 'Emergency Medical Situation'));
	
VALUES
	('Construction accident', '2003-01-06', '2003-07-07', 'Be buried in the wreckage', 
	'School Street', 'Hoosier', 'Texas', 'Austin', 'United States',
	'Inattention', 'Other_Details5', 
	(SELECT Outcome_Code FROM event_outcomes WHERE Description = 'Injured & Death'), 
	(SELECT Status_Code FROM event_status WHERE Description = 'Unsolved'), 
	(SELECT Type_Code FROM event_types WHERE Description = 'Accident'));
	
	
