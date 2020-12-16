create table `Person`(
                         `Id` int(4) not null auto_increment,
                         `Email` varchar(50) not null,
                         primary key(`Id`)
);
show tables;
insert into Person(`Email`) values ('john@example.com'),('bob@example.com'),('john@example.com');
select * from Person;

delete from Person
    where Id not in (
        select A.Id from (
            select min(Id) as Id from Person group by Email
            ) A
        );

select * from Person
