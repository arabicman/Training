BEGIN
declare x int;
set x=N-1;
RETURN (
           # Write your MySQL query statement below.
           SELECT IFNULL(
                          (SELECT DISTINCT Salary
                           FROM Employee
                           ORDER BY Salary DESC
                           LIMIT 1 OFFSET x),
                          NULL)
       );
END