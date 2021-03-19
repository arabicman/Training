use leetcode;
create table if not exists `Employee`(
    `Id` int(4) not null auto_increment comment 'Employee ID',
    `Salary` int(20) not null comment 'Employee Salary',
    primary key(`Id`)
    );
insert into Employee(`Salary`) values ('100'),('200'),('300'),('400');
describe Employee;
select * from Employee;