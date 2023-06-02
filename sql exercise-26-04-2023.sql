1.From the following table, write a SQL query to find those employees who receive a higher salary than the employee with ID 163. Return first name, last name.
=>select employee_id,first_name,last_name from employees where salary > (select salary from employees where employee_id=163);

2. From the following table, write a SQL query to find out which employees have the same designation as the employee whose ID is 169. Return first name, last name, department ID and job ID.
=>select e.first_name,e.last_name,e.department_id,e.job_id
 from employees e
 where job_id = (select job_id from employees where employee_id=169);

3. From the following table, write a SQL query to find those employees whose salary matches the lowest salary of any of the departments. Return first name, last name and department ID. 
=>select e.first_name,e.last_name,e.department_id
 from employees e
 where salary IN (select min(salary) from employees group by(department_id));

4.From the following table, write a SQL query to find those employees who earn more than the average salary. Return employee ID, first name, last name.
=>select e.employee_id,e.first_name,e.last_name
 from employees e
 where salary > (select avg(salary) from employees);

5. From the following table, write a SQL query to find those employees who report to that manager whose first name is ‘Payam’. Return first name, last name, employee ID and salary.
=>select e.employee_id,e.first_name,e.last_name,e.salary
 from employees e
 join employees e1 on e.manager_id=e1.employee_id
 where  e1.first_name= 'Payam';

6.From the following tables, write a SQL query to find all those employees who work in the Finance department. Return department ID, name (first), job ID and department name. 
=>select e.first_name name,d.department_id,d.department_name,e.job_id
 from employees e
 join departments d using (department_id)
 where d.department_name= 'Finance';

7. From the following table, write a SQL query to find the employee whose salary is 3000 and reporting person’s ID is 121. Return all fields. 
=>select * from employees 
 where salary=3000 and manager_id=121;

8. From the following table, write a SQL query to find those employees whose ID matches any of the numbers 134, 159 and 183. Return all the fields.
=>select * from employees 
 where employee_id IN (134, 159,183);  

9. From the following table, write a SQL query to find those employees whose salary is in the range of 1000, and 3000 (Begin and end values have included.). Return all the fields.
=>select * from employees 
  where salary between 1000 and 3000;

10.From the following table and write a SQL query to find those employees whose salary falls within the range of the smallest salary and 2500. Return all the fields.
=>select * from employees 
  where salary between (select min(salary) from employees) and 2500;

11. From the following tables, write a SQL query to find those employees who do not work in the departments where managers’ IDs are between 100 and 200 (Begin and end values are included.). Return all the fields of the employees.
=>select * from employees 
  where department_id 
  NOT IN (select department_id from departments where manager_id between 100 and 200);

12. From the following table, write a SQL query to find those employees who get second-highest salary. Return all the fields of the employees. 
=>select * from employees where  
	salary =(select max(salary) from employees 
		where salary < (select max(salary) from employees));

13. From the following tables, write a SQL query to find those employees who work in the same department as ‘Clara’. Exclude all those records where first name is ‘Clara’. Return first name, last name and hire date.
=>select first_name,last_name,hire_date from employees
 where department_id IN (select department_id from employees where first_name='Clara')
 and first_name !='Clara';

14. From the following tables, write a SQL query to find those employees who work in a department where the employee’s first name contains the letter 'T'. Return employee ID, first name and last name.
=>select employee_id,first_name,last_name from employees
 where department_id IN (select department_id from employees where first_name like '%T%');

15. From the following tables, write a SQL query to find those employees who earn more than the average salary and work in the same department as an employee whose first name contains the letter 'J'. Return employee ID, first name and salary. 
=>select employee_id,first_name,last_name,salary from employees
where department_id IN (
			select department_id from employees where first_name like '%J%'
        )
and salary > (select avg(salary) from employees);

16. From the following table, write a SQL query to find those employees whose department is located at ‘Toronto’. Return first name, last name, employee ID, job ID.  
=>select e.employee_id,e.first_name,e.last_name,e.job_id from employees e
join departments d on e.department_id=d.department_id
join locations l on d.location_id=l.location_id
where city='Toronto';

17. From the following table, write a SQL query to find those employees whose salary is lower than that of employees whose job title is ‘MK_MAN’. Return employee ID, first name, last name, job ID.
=>select e.employee_id,e.first_name,e.last_name,e.job_id from employees e
where salary< ANY (select salary from employees where job_id='MK_MAN')

18. From the following table, write a SQL query to find those employees whose salary is lower than that of employees whose job title is "MK_MAN". Exclude employees of Job title ‘MK_MAN’. Return employee ID, first name, last name, job ID. 
=>select e.employee_id,e.first_name,e.last_name,e.job_id from employees e
where salary < ANY (select salary from employees where job_id='MK_MAN')
and job_id <> 'MK_MAN';

19. From the following table, write a SQL query to find those employees whose salary exceeds the salary of all those employees whose job title is "PU_MAN". Exclude job title ‘PU_MAN’. Return employee ID, first name, last name, job ID. 
=>select e.employee_id,e.first_name,e.last_name,e.job_id from employees e
where salary > ANY (select salary from employees where job_id='PU_MAN')
and job_id <> 'PU_MAN';

20. From the following table, write a SQL query to find those employees whose salaries are higher than the average for all departments. Return employee ID, first name, last name, job ID.  
=>select e.employee_id,e.first_name,e.last_name,e.job_id from employees e
where e.salary > ALL (select avg(salary) from employees group by department_id);

21. From the following table, write a SQL query to check whether there are any employees with salaries exceeding 3700. Return first name, last name and department ID. 
=>select e.employee_id,e.first_name,e.last_name,e.department_id from employees e
where e.salary > 3700;

22. From the following table, write a SQL query to calculate total salary of the departments where at least one employee works. Return department ID, total salary.
=>select d.department_id,result.total from departments d,
(select department_id,sum(salary) total from employees group by department_id) result
where d.department_id=result.department_id; 

23. Write a query to display the employee id, name ( first name and last name ) and the job id column with a modified title SALESMAN for those employees whose job title is ST_MAN and DEVELOPER for whose job title is IT_PROG.
=>
