
!echo "initiating Load of Data"; 

LOAD DATA LOCAL INPATH '/home/cloudera/workspaces/Lab_Big_Data_Programming/inputs/Datasets/processed_heroes_information.csv' INTO TABLE HERO_INFO;

!echo "Loading Data complete"; 

SELECT * FROM HERO_INFO LIMIT 5;

!echo "printing 5 records for view"; 
