create database DellCampaigns;
use DellCampaigns;
drop table if exists POEDetails;
drop table if exists Campaign;
drop table if exists CampaignDetails;
drop table if exists Partner;
drop table if exists Dell;

CREATE TABLE Partner(
id varchar(8) not null,
primary key(id),
Pname varchar(30) not null,
DateCreated date not null,
pass varchar(20) not null,
email varchar(50) not null,
phone varchar(30) not null
); 

create table Dell(
id varchar(8) not null,
primary key(id),
Dname varchar(30) not null,
HireDate date not null,
pass varchar(20) not null
);

create table CampaignDetails(
id varchar(8) not null,
primary key(id),
DateCreated date not null,
ContactName varchar(30) not null,
CompanyName varchar(30) not null,
CompanyAddress varchar(60) not null,
ContactEmail varchar(60) not null,
ContactPhone varchar(20) not null,
ProgramDate date not null,
StartTime time not null,
EndTime time not null,
EstimatedAttendees int not null,
VenueName varchar(30) not null,
VenueAddress varchar(60) not null,
FaceToFace boolean,
TradeShows boolean,
MultiTouch boolean,
DoorOpener boolean,
ThirdParty boolean,
DirectMail boolean,
Blitz boolean,
ProgramDescription text not null,
SC4000 boolean,
PS4210 boolean,
DellStorageSol boolean,
FlashPriceDisk boolean,
FluidCache boolean,
DataProtection boolean,
PowerEdgeServers boolean,
WindowsServer boolean,
X86Server boolean,
PowerEdgeVRTX boolean,
SDN boolean,
UserCentric boolean,
CloudClientComputing boolean,
InfrastructureHardware boolean,
BladeDataCenter boolean,
OptimizedEnterprize boolean,
PowerEdgeFX boolean,
SDS boolean,
SoftwareComponent text,
SMB boolean,
LE boolean,
PUB boolean,
TotalProjectedCost int not null,
MDFRequest int not null,
ReimbursementMethod varchar(30) not null,
TechnologyPartners varchar(60) not null,
TotalMDFContribution int not null,
EstimatedOpportunities int not null,
EstimatedRevenue int not null
);

create table Campaign(
id varchar(8) not null,
primary key(id),
foreign key(id) references CampaignDetails(id), 
LastChange date not null,
CampApproved varchar(30) not null,
POEApproved varchar(30) not null,
PartnerId varchar(8),
foreign key(PartnerId) references Partner(id),
DellId varchar(8),
foreign key(DellId) references Dell(id),
dismissed boolean not null,
CampComment text

);

create table POEDetails(
DL varchar(100),
primary key(DL),
Cid varchar(8),
foreign key(Cid) references CampaignDetails(id),
FileType varchar(30)
);




INSERT INTO Partner VALUES ('P1234','steffan','2015-10-26','polio','steffan@mail.dk','55556655'),
('P1322','alex','2015-10-26','ebola','ebola@mail.dk','55556655'),
('P3324','david','1971-01-23','420blazeit','blazeit@mail.dk','42056655'),
('P4432','marco','2015-10-26','pass1234','marco@mail.dk','55556655'),
('P8899','palle','1889-04-20','heil','hell@mail.dk','55556655');

INSERT INTO Dell VALUES ('D2232','bob hansen','2015-11-11','123'),
('D4223','gege','2015-11-11','345'),
('D7657','david hansen','2015-11-11','132'),
('D9721','marcus hansen','2015-11-11','321');

INSERT INTO CampaignDetails VALUES ('C1','2015-10-29','sdfghj','sdfghj','sdfghj','whatever','123456','2015-10-29','10:10:10','10:10:10',34567,'wertyuji','Dron. margrethesvej 22 2th',0,0,0,0,0,0,0,'ertyuik',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,1234567,123456,'sdfghujik','wsedfgh',123456,123456,1234567),
								   ('C2','2015-10-29','sdfghj','sdfghj','dfghjgf','cfghjkl','dfvghjk','2015-10-29','10:10:10','10:10:10',34567,'sdfghjk','fdghjk',1,0,0,1,0,1,0,'sdfgh',1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,'sdfgh',1,0,0,234567,34567,'sxdfgh','12345',23456,3456,23456);

Insert into Campaign values ('c1','2015-11-03','pending','N/A',null,null,false,null),
							('c2','2015-11-03','pending','N/A',null,null,false,null)



