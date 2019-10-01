!echo "Dropping table if exists"; 

DROP TABLE IF EXISTS HERO_INFO;

!echo "Creating table if not exists";
 
CREATE TABLE IF NOT EXISTS HERO_INFO(
  hero_id int,
  hero_name String,
  gender String,
  physical_details struct<eye_colour:String,race:String,hair_colour:String,height:Float,publisher:String,skin_colour:String,alignment:String,weight:Float>
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
COLLECTION ITEMS TERMINATED BY '#'
LINES TERMINATED BY '\n'
STORED AS TEXTFILE;

ALTER TABLE HERO_INFO SET TBLPROPERTIES ("skip.header.line.count"="1");

!echo "Describing table"; 

DESCRIBE HERO_INFO;
