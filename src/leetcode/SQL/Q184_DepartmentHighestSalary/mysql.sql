create table if not exists Employee(
    `Id` int(4) not null auto_increment,
    `Name` varchar(20) not null,
    `Salary` int(20) not null,
    `DepartmentId` int(4) not null,
    primary key(`Id`)
)

create table if not exists Department(
    `Id` int(4) not null auto_increment,
    `Name` varchar(20) not null,
    primary key(`Id`)
)

insert into Department(`Name`) values ('It'),('Sales');
insert into Employee(`Name`,`Salary`,`DepartmentId`) values ('Joe','70000','1'),('Jim','90000','1'),('Henry','80000','2'),('Sam','60000','2'),('Max','90000','1');

select * from Employee;
select * from Department;

SELECT D.Name AS Department, E.Name AS Employee, E.Salary
FROM Employee E, Department D, (
    SELECT E.DepartmentId, MAX(E.Salary) AS max_sal_in_dep
    FROM Employee E, Department D
    WHERE E.DepartmentId = D.Id
    GROUP BY E.DepartmentId) ED
WHERE E.DepartmentId = ED.DepartmentId
  AND E.Salary = ED.max_sal_in_dep
  AND E.DepartmentId = D.Id;

drop table Employee;
drop table Department;