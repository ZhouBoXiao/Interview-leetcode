# use test;
select * from actor;

set profiling =  1;

show variables like '%profiling%';

show profiles;

show profile cpu, block io for QUERY 11;

show variables like '%autocommit%';

show engines;

show variables like 'sql_mode';