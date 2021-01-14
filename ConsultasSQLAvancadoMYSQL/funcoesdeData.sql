select curdate();

select currant_time();

select currant_timeStamp();

select year(select currant_timeStamp());

select day(select currant_timeStamp());

select month(select currant_timeStamp());

select monthname(select currant_timeStamp());

select dateDiff(select currant_timeStamp(), '2019-01-01');

select dateDiff(select currant_timeStamp(), '1965-09-04');

select currant_timeStamp() as dia_hoje,
 datesub(select currant_timeStamp(), interval 5 day) as resultado;

 select distincy data_venda, dayname(data_venda) as dia, monthname(data_venda) as 
 mes, year(data_venda) as and from notas_fiscais;