select 'cross join',e.first_name,e.salary,d.department_name from employees e cross join departments d;  ---Cross Join

select e.first_name,e.salary,d.department_name from employees e inner join departments d where e.department_id=d.department_id;
select e.first_name,e.last_name,d.department_name,l.city,l.state_province from employees e join departments d on e.department_id=d.department_id join locations l on d.location_id=l.location_id; --Inner Join

select e.first_name,e.last_name,e.department_id,d.department_name from employees e join departments d on e.department_id=d.department_id where e.department_id=80 or e.department_id=40 order by first_name ASC;

select first_name,last_name from employees where first_name like '%z%';

select e.first_name,e.last_name,d.department_id,d.department_name from departments d left join employees e on d.department_id=e.department_id;