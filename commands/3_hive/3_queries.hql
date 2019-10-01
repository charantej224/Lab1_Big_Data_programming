
!echo "Query1 : Querying Super HERO with no Hair!";

SELECT * FROM HERO_INFO WHERE upper(physical_details.hair_colour) like "%NO%"; 

!echo "Query2 : Hero having weight greater than average in their gender";

select HI.hero_name,HI.gender 
from HERO_INFO HI
join (SELECT gender,avg(physical_details.weight) as avg_weight FROM HERO_INFO group by gender) G_HI 
on HI.gender = G_HI.gender
where HI.physical_details.weight > G_HI.avg_weight;

!echo "Query3 : Differenet types of eye colours present within Super heros";

SELECT distinct physical_details.eye_colour from HERO_INFO;

!echo "Query4 : Publishers sorted with highest number of heros";

SELECT physical_details.publisher, count(*) as number_of_heros from HERO_INFO
group by physical_details.publisher
order by number_of_heros desc;

!echo "Query5 : count of Different races in each publisher in sorted order";
																																																																					SELECT physical_details.publisher,physical_details.race,count(*) as count_race from HERO_INFO 
group by physical_details.publisher,physical_details.race 
order by count_race desc;

!echo "Query6 : top 5 tallest super heros in male";
																																																																					SELECT HI.hero_name as hero_name,HI.physical_details.height as height from HERO_INFO HI
where upper(HI.gender) = "MALE"
order by height desc
limit 5;

!echo "Query7 : top 5 tallest super heros in Female";
																																																																					SELECT HI.hero_name as hero_name,HI.physical_details.height as height from HERO_INFO HI
where upper(HI.gender) = "FEMALE"
order by height desc
limit 5;

!echo "Query8 : top 5 tallest super heros not in Male and Female";
																																																																					SELECT HI.hero_name as hero_name,HI.physical_details.height as height from HERO_INFO HI
where upper(HI.gender) NOT IN ("MALE","FEMALE")
order by height desc
limit 5;

!echo "Query9 : top 5 tallest heros from Male, Female and others.";

select * from 
(
SELECT HI.hero_name as hero_name,HI.physical_details.height as height from HERO_INFO HI
where upper(HI.gender) = "MALE"
order by height desc
limit 5
UNION ALL
SELECT HI.hero_name as hero_name,HI.physical_details.height as height from HERO_INFO HI
where upper(HI.gender) = "FEMALE"
order by height desc
limit 5
UNION ALL
SELECT HI.hero_name as hero_name,HI.physical_details.height as height from HERO_INFO HI
where upper(HI.gender) NOT IN ("MALE","FEMALE")
order by height desc
limit 5
) combined_table;

!echo "Query10 : top 5 tallest heros from Male, Female and others.";

select * from HERO_INFO WHERE UPPER(physical_details.race) NOT IN ("HUMAN");

