Create database cricketworldcup;

Use cricketworldcup;

Create Table Teams(team_id int not null auto_increment primary key,
country varchar(30) not null, noOfMatches int default 0,
noOfWins int default 0,noOfLosses int Default 0 );

Create Table player(player_id int not null auto_increment primary key,playerName varchar(30),totalRuns int default 0, totalWickets int default 0,team_id int, foreign key(team_id) references teams(team_id) );

create table matchBetween (match_id int not null auto_increment primary key, team1_id int not null check(team1_id>0), team2_id int not null check(team2_id>0), team1stat int not null, team2stat int not null)	;

create table Teamstats(stat_id int not null unique primary key auto_increment,
team_id int not null,match_id int not null, score int default 0, 
wickets int default 0, foreign key(team_id) references teams(team_id),
foreign key(match_id) references matchbetween(match_id));

create table if not exists playerPointTable(point_id int not null unique primary key auto_increment,
player_id int check(player_id>0), match_id int check(match_id>0),
runsScored int not null default 0, wicketsTaken int not null default 0,
foreign key(player_id) references player(player_id), 
foreign key(match_id) references matchbetween(match_id));

insert into teams values(1,'India',0,0,0);
insert into teams values(2,'Australia',0,0,0);
insert into teams values(3,'West Indies',0,0,0);
insert into teams values(4,'New Zealand',0,0,0);

insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(1,'Sachin',1,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(2,'Sehwag',1,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(3,'Pandya',1,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(4,'Jadeja',1,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(5,'Bumrah',1,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(6,'Warner',2,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(7,'Watson',2,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(8,'Smith',2,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(9,'Hayden',2,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(10,'Mitchell',2,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(11,'Lara',3,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(12,'Gayle',3,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(13,'Pollard',3,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(14,'Bravo',3,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(15,'Holder',3,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(16,'Williamson',4,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(17,'Guptill',4,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(18,'Taylor',4,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(19,'Neesham',4,0,0);
insert into player(player_id,playerName,team_id,totalRuns,totalWickets) values(20,'Boult',4,0,0);

drop trigger if exists incre;
drop trigger if exists winstat2;

drop trigger if exists winstat1;

delimiter $$

create trigger winstat1
after insert on matchbetween
for each row
begin
if new.team1stat=1 then
	update teams
	set noOfWins=noOfWins+1
    where team_id=new.team1_id;
else
	update teams
	set noOfLosses=noOfLosses+1
	where team_id=new.team1_id;
end if;
end$$
delimiter ;


delimiter $$

create trigger incre
after insert on matchbetween
for each row
begin
update teams set noOfMatches=noOfMatches+1
where team_id in (new.team1_id,new.team2_id);
end$$

delimiter ;

delimiter $$

create trigger winstat2
after insert on matchbetween
for each row
begin
if new.team2stat=1 then
	update teams
	set noOfWins=noOfWins+1
    where team_id=new.team2_id;
else
	update teams
	set noOfLosses=noOfLosses+1
	where team_id=new.team2_id;
end if;
end$$
delimiter ;

insert into matchbetween values(1,1,2,1,0);
insert into matchbetween values(2,2,3,0,1);
insert into matchbetween values(3,1,4,1,0);
insert into matchbetween values(4,3,4,0,1);

insert into teamstats values(1,1,1,220,4);
insert into teamstats values(2,2,1,193,2);
insert into teamstats values(3,2,2,245,3);
insert into teamstats values(4,3,2,247,7);
insert into teamstats values(5,1,3,289,6);
insert into teamstats values(6,4,3,270,9);
insert into teamstats values(7,3,4,320,6);
insert into teamstats values(8,4,4,321,5);

drop trigger if exists playerIncre;

delimiter $$

create trigger playerIncre
after insert on playerpointtable
for each row
begin
update player set totalRuns=totalRuns+new.runsScored, totalWickets=totalWickets+new.wicketsTaken
where player_id=new.player_id;
end$$

delimiter ;


insert into playerpointtable values(1,1,1,90,0);
insert into playerpointtable values(2,2,1,70,0);
insert into playerpointtable values(3,3,1,60,1);
insert into playerpointtable values(4,4,1,0,2);
insert into playerpointtable values(5,5,1,0,1);
insert into playerpointtable values(6,6,1,55,0);
insert into playerpointtable values(7,7,1,70,0);
insert into playerpointtable values(8,8,1,15,0);
insert into playerpointtable values(9,9,1,30,2);
insert into playerpointtable values(10,10,1,23,0);
insert into playerpointtable values(11,6,2,100,0);
insert into playerpointtable values(12,7,2,70,0);
insert into playerpointtable values(13,8,2,40,2);
insert into playerpointtable values(14,9,2,30,1);
insert into playerpointtable values(15,11,2,130,2);
insert into playerpointtable values(16,12,2,70,1);
insert into playerpointtable values(17,14,2,47,4);
insert into playerpointtable values(18,1,3,91,0);
insert into playerpointtable values(19,2,3,73,1);
insert into playerpointtable values(20,4,3,65,3);
insert into playerpointtable values(21,3,3,60,2);
insert into playerpointtable values(22,16,3,70,0);
insert into playerpointtable values(23,17,3,98,1);
insert into playerpointtable values(24,19,3,77,2);
insert into playerpointtable values(25,20,3,25,6);
insert into playerpointtable values(26,11,4,160,1);
insert into playerpointtable values(27,13,4,100,2);
insert into playerpointtable values(28,15,4,60,3);
insert into playerpointtable values(29,16,4,126,0);
insert into playerpointtable values(30,17,4,94,2);
insert into playerpointtable values(31,18,4,78,1);
insert into playerpointtable values(32,19,4,23,2);

select playerName as Batsmens, totalRuns as RunsScored from player
order by totalRuns Desc limit 5;

select playerName as Bowlers, totalWickets as WicketsTaken from player
order by totalWickets Desc limit 5;

select teams.country as Country, avg(teamstats.score) as AverageScore
from teams 
inner join teamstats on teams.team_id=teamstats.team_id
group by teamstats.team_id;

update player set totalRuns=totalRuns+10
where team_id=(select team_id from teamstats group by team_id order by avg(score) limit 1);

DELIMITER $$

DROP PROCEDURE IF EXISTS HighestScore$$
CREATE PROCEDURE HighestScore(variable varchar(30), out runs int)
BEGIN
    SELECT max(score) into runs from teamstats group by team_id having team_id=(select team_id from teams where country=variable);
END$$

DELIMITER ;

CALL HighestScore('New Zealand',@runs);
SELECT @runs as HighestScore;















