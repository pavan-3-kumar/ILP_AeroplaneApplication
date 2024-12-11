create table User(
 User_Id varchar(15) primary key,
 User_name varchar(30),
 Password varchar(30),
 Role varchar(20) check(Role in ( "Admin" ,"Customer")),
 Category varchar(20) check(Category in ("Silver","Gold" ,"Platinum")),
 Phone varchar(20),
 Email_id varchar(20),
 Address varchar(20),
 City varchar(20),
 State varchar(20),
 Country varchar(20),
 Zipcode varchar(15),
 Date varchar(20)
);

create table Pavan(
name varchar(20),
age int
);

select * from Carrier;
 
create table Carrier(
Carrier_id INTEGER primary key autoincrement,
Carrier_name varchar(20),
Discount_Thirty_AdvanceBooking  int,
Discount_Sixty_AdvanceBooking  int , 
Discount_Nintey_AdvanceBooking  int , 
Bulk_dis  int,
Refund_twodays_TravelDate  int,
Refund_tendays_TravelDate int,
Refund_twentydays_TravelDate int,
Silver_dis  int,
Gold_dis   int,
Platinum_dis int
);
drop table Flight;

insert into Carrier values
(201,"Air India",10,15,20,15,60,70,80,12,20,25);

insert into Carrier values
(202,"IndiGo",11,16,21,14,61,71,82,13,21,26);

insert into Carrier values
(203,"Spice Jet",12,17,22,16,62,72,82,14,22,28);

insert into Carrier values
(204,"Air Asia",10,16,23,15,60,70,80,13,20,30);

insert into Carrier values
(205,"Vitara",11,16,22,16,61,72,82,15,22,29);

select * from Flight;

create table Flight(
    Flight_id  INTEGER primary key autoincrement,
	Carrier_id int references Carrier(Carrier_id),
	 Origin varchar(20),
	 Destination varchar(20),
	 AirFare int,
	Seat_cap_Economy int,
	 Seat_cap_Business int,
	Seat_cap_Executive int,
     check (Seat_cap_Economy >= 20 and Seat_cap_Business >= 10 and Seat_cap_Executive >= 5)
);


insert into Flight values
(101,201,"HYD","BAN",10000,30,15,10);
insert into Flight values
(102,201,"HYD","MGR",40000,36,14,10);
insert into Flight values
(103,202,"HYD","BAN",12000,30,15,10);
insert into Flight values
(104,202,"HYD","DEL",40000,40,18,10);
insert into Flight values
(105,203,"BOM","MGR",25000,30,16,20);
insert into Flight values
(106,203,"HYD","MGR",20000,30,15,10);
insert into Flight values
(107,204,"HYD","MGR",20000,40,24,10);
insert into Flight values
(108,204,"HYD","MGR",20000,30,16,10);
insert into Flight values
(109,205,"HYD","KOL",30000,30,15,10);
insert into Flight values
(110,205,"GOA","BAN",5000,30,14,10);


delete from Flight;

select * from Flight;

create table FlightSchedule(
FlightScheduleID int primary key,
FlightID int references Flight(Flight_id), 
DateOfTravel varchar(20),
BusinessClassBookedCount int default 0,
EconomyClassBookedCount int default 0,
ExecutiveClassBookedCount int default 0
);

insert into FlightSchedule(FlightScheduleID , FlightID,DateOfTravel) values
(1001,101,"10-09-2024");
insert into FlightSchedule(FlightScheduleID , FlightID,DateOfTravel) values
(1002,103,"10-09-2024");
insert into FlightSchedule(FlightScheduleID , FlightID,DateOfTravel) values
(1003,109,"11-09-2024");
insert into FlightSchedule(FlightScheduleID , FlightID,DateOfTravel) values
(1004,104,"12-09-2024");
insert into FlightSchedule(FlightScheduleID , FlightID,DateOfTravel) values
(1005,106,"11-09-2024");
insert into FlightSchedule(FlightScheduleID , FlightID,DateOfTravel) values
(1006,107,"11-09-2024");
insert into FlightSchedule(FlightScheduleID , FlightID,DateOfTravel) values
(1007,108,"11-09-2024");
insert into FlightSchedule(FlightScheduleID , FlightID,DateOfTravel) values
(1008,102,"11-09-2024");

select * from FlightSchedule;


select * from Flight f JOIN  FlightSchedule fs
on f.Flight_id = fs.FlightID
where f.Origin = "HYD" and 
f.Destination = "BAN" and fs.DateOfTravel = "10-09-2024";



create table Flight_booking(
Booking_id int  primary key, 
Flight_id int  references Flight(Flight_id), 
User_id varchar(15) references User(User_Id),  
Num_of_seats int ,
Date_of_travel varchar(20),
Booking_status varchar(20) ,
Booking_Amount int ,
economyclassseats int , 
businessclassseats int ,
executiveclassseats int , 
check (Booking_status= "Booked" or Booking_status="TravelCompleted" or Booking_status="Cancelled")
);


select * from Flight_booking;


drop table FlightSchedule;


