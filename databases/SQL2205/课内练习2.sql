----���ں���
select getdate()
--���µĵ�һ��
select dateadd(mm,datediff(mm,0,getdate()),0);
--���ܵ�����һ
select dateadd(wk,datediff(wk,0,getdate()),0);
--һ��ĵ�һ��
select dateadd(yy,datediff(yy,0,getdate()),0);
--���ȵĵ�һ��
select dateadd(qq,datediff(qq,0,getdate()),0);
--�ϸ��µ����һ��
select dateadd(ms,-3,dateadd(mm,datediff(mm,0,getdate()),0)) �ϸ��µ����һ��;
--ȥ������һ��
select dateadd(ms,-3,dateadd(yy,datediff(yy,0,getdate()),0));
--���µ����һ��
select dateadd(ms,-3,dateadd(mm,datediff(m,0,getdate())+1,0));
--���µĵ�һ������һ
select dateadd(wk,datediff(wk,0,dateadd(dd,6-datepart(day,getdate()),getdate())),0) ���µĵ�һ������һ;
--��������һ��
select dateadd(ms,-3,dateadd(yy,datediff(yy,0,getdate())+1,0));
--1�����ж�����
select datediff(dd,dateadd(yy,datediff(yy,0,getdate()),0),dateadd(yy,datediff(yy,0,getdate())+1,0))  '2017�������'
--2�����һ�����ж�����
select datediff(dd,dateadd(mm,datediff(mm,0,getdate()),0),dateadd(mm,datediff(mm,0,getdate())+1,0))  '2017��ĵ�һ���µ�����'
--3����ڶ������ж�����
select datediff(dd,dateadd(mm,datediff(mm,0,getdate())-1,0),dateadd(mm,datediff(mm,0,getdate()),0))  '2017��ĵڶ����µ�����'
--4�����һ�������ж�����
select datediff(dd,dateadd(qq,datediff(qq,0,getdate()),0),dateadd(qq,datediff(qq,0,getdate())+1,0))  '2017��ĵ�һ�����ȵ�����'
--5����ڶ��������ж�����
select datediff(dd,dateadd(qq,datediff(qq,0,getdate())+1,0),dateadd(qq,datediff(qq,0,getdate())+2,0))  '2017��ĵڶ������ȵ�����'
select dateadd(qq,datediff(qq,0,getdate())+1,0)
--6��������������ж�����
select datediff(dd,dateadd(qq,datediff(qq,0,getdate())+2,0),dateadd(qq,datediff(qq,0,getdate())+3,0))  '2017��ĵ��������ȵ�����'
--7������ĸ������ж�����
select datediff(dd,dateadd(qq,datediff(qq,0,getdate())+3,0),dateadd(qq,datediff(qq,0,getdate())+4,0))  '2017��ĵ��ĸ����ȵ�����'
--8�����ϰ����ж�����
select datediff(dd,dateadd(qq,datediff(qq,0,getdate()),0),dateadd(qq,datediff(qq,0,getdate())+2,0))  '2017����ϰ��������'
select dateadd(qq,datediff(qq,0,getdate()),0)
--9�����°����ж�����
select datediff(dd,dateadd(qq,datediff(qq,0,getdate())+2,0),dateadd(qq,datediff(qq,0,getdate())+4,0))  '2017����°��������'
--10�����������ڼ�
select datename(dw,117) '1900�����յ�����'
select convert(varchar(30),getdate(),111)
--11��2017��6��1�����ڼ�
select datename(dw,dateadd(mm,datediff(mm,0,getdate())+3,0)) '2017�����յ�����'
--12����ѯ���������ڼ�
select datepart(weekday,getdate()),datename(weekday,getdate());

select 'hello world', left('hello world',5)
Select datename(dw,getdate())
--��ȡϵͳ�ĵ�ǰʱ��
select  getdate();
--dateadd���ڼӼ�����
select  dateadd(dd,10,getdate()) ��10��,dateadd(mm,10,getdate()) ��10����,dateadd(hour,1000,getdate()) ��1000��Сʱ
select  dateadd(minute,888,getdate()) ��888����,dateadd(qq,-10,getdate()) ��10������
--datepart��ȡ���ڵ�һ����
select getdate(),datepart(year,getdate()),datepart(mm,getdate()),datepart(dd,getdate()),datepart(hh,getdate()),datepart(mi,getdate()),datepart(qq,getdate());
--datediff2������֮����бȽ�
select getdate() ϵͳʱ��,'2017-2-5' ����,datediff(mm,'2017-2-5',getdate()) �����·�,datediff(dd,'2017-2-5',getdate()) ��������
--��ʾ�������1��1��,0����1900��0ʱ0��0��
select dateadd(year,datediff(year,0,getdate()),0) �����1��1��;

--��ǰ��ݵڶ����ȵ�һ�������ڼ�
select  datepart(dw,dateadd(qq,1,dateadd(year,datediff(year,0,getdate()),0)));
select year(getdate()),month(getdate()),day(getdate());

----��ѧ����
select pi() Բ����,power(3,3) ��������,sin(pi()/2) sin90��,log(10),log10(10);
--rand����0~1֮��������
select rand()
--round�󾫶ȣ�����С�����3λ����������ԭ��
select round(pi(),3);
--ceiling���ش��ڸ�������С����,floor����С�ڸ������������,sign�źź���
select ceiling(10.8),ceiling(-10.8),floor(10.33),sign(10),sign(0),sign(-11);
--degrees�����Ի��ȶ�Ӧ�ǵĶ���
select degrees(pi()/2) ���ػ��ȶ�Ӧ�ĽǶ�,radians(60) ���ؽǶȶ�Ӧ�Ļ���
--sqrtƽ����
select sqrt(9) ƽ����,square(8) ƽ��
--�ַ���������ʹ��
--Сдת��Ϊ��д����дת��ΪСд
select UPPER('abcd') Сдת��Ϊ��д,LOWER('ABCD') ��дת��ΪСд
select ascii('A') ���ַ�ת��Ϊascii,char('97') ��ascii��ת��Ϊ�ַ�
select 'administrator',left('administrator',5) ȡǰ5���ַ�,right('administrator',5) ȡ��5���ַ�,substring('administrator',2,6) �ӵڶ����ַ���ʼȡ6���ַ�
select 'administrator',charindex('s','administrator',1) �����ַ����ַ����е�����,charindex('a','administrator',1),charindex('a','administrator',2)
select difference('a','aaaba');
select len('admin') �ַ�������,reverse('admin') �ַ�����ת,replace('   admin  ',' ','#') �ѿո��滻Ϊ#,replace('   admin  ',' ','') �ѿո�ɾ��
select ltrim('   admin   ') ɾ����߿�ͷ�Ŀո�,rtrim('   admin       ') ɾ���ұߵĿո�,ltrim(rtrim('    admin    ')) ɾ����ͷ�Ŀո�


create table employee
(
	depart_time varchar(10),--����
	work_no varchar(6),--����
	salary int--����
)
select * from employee;

insert into employee values('����',200001,2000);
insert into employee values('����',200002,2500);
insert into employee values('����',200004,2500);
insert into employee values('��չ��',300002,2000);
insert into employee values('��չ��',300009,1800);
insert into employee values('��չ��',300014,2000);
insert into employee values('�ۺϲ�',400001,1800);
insert into employee values('�ۺϲ�',400005,2000);
insert into employee values('�ۺϲ�',400009,2500);
insert into employee values('������',500008,2500);
insert into employee values('������',500099,1800);
insert into employee values('������',500102,2700);
--�����ʴӵ͵��߽�������
select  row_number() over(order by salary)as id,dense_rank()over(order by salary desc)as ��������1,rank() 
over(order by salary desc)as ��������2,*from employee;
--�ֲ��Ű����ʴӵ͵��߽�������
select row_number() over(partition by depart_time order by salary)as ��������,*from employee;

create table money
(
	work_no varchar(6),--���
	money_type varchar(10),--��Ǯ����
	num int --����
)
select * from money;

insert into money values('100001','HKD',100);
insert into money values('100001','HKD',200);
insert into money values('100001','USD',300);
insert into money values('200020','HKD',50);
insert into money values('200020','RMB',5000);
insert into money values('200020','USD',500);

insert into money values('400078','HKD',80);
insert into money values('400078','HKD',90);
insert into money values('400078','RMB',800);
insert into money values('400078','RMB',900);
insert into money values('400078','USD',90);
insert into money values('400078','USD',800);

--ͳ��ÿ��Ա����ͬ���ֵĽ��
--sql2000д��
select work_no,
sum(case when money_type='HKD' then num else 0 end)as '�۱�',
sum(case when money_type='USD' then num else 0 end)as '��Ԫ',
sum(case when money_type='RMB' then num else 0 end)as '�����'
from money group by work_no;
--sql2005д��
select  work_no,[HKD]as �۱�,[USD]as ��Ԫ,[RMB]as ����� from money pivot(sum(num)for money_type in([HKD],[USD],[RMB]))as pvt;
--����(�ۼ��������Ǿۼ�����)
select * from sysindexes;

----��������
create table [dbo].[emp]
(
	[empid][int] identity(1,1) not null,
	[empName][varchar](10) null,
	[sex][varchar](2) null,
	[salary] decimal(18,2) null,
	[joindate][datetime] null
)
drop table emp;
select * from emp;
insert into emp select empname,sex,salary,joindate from emp ;
insert into emp values('��־��','��','10000',getdate());
insert into emp values('���½�','��','7400',getdate());
insert into emp values('��Ⱥ��','��','7100',getdate());
insert into emp values('���ǲ�','��','6700',getdate());
insert into emp values('���ڽ�','��','7600',getdate());
insert into emp values('���黪','��','8400',getdate());
insert into emp values('����','��','7800',getdate());
insert into emp values('�·���','��','9500',getdate());
insert into emp values('С��','Ů','5600',getdate());
insert into emp values('С¶','Ů','9000',getdate());

--����һ��Ψһ�ۼ�����
create unique clustered index index_empid on Emp(empid)
--ִ�в�ѯ��֤�Ƿ�ʹ��������
go
set showplan_text on
go 
select * from emp where salary>3000
go
set showplan_text off
go
--�鿴�������
sp_helpindex stud;
sp_helpindex score;
sp_helpindex emp;
--ָ�������Ĳ���
create unique clustered index index_empid on emp(empid) with pad_index,fillfactor=10,ignore_dup_key,drop_existing,statistics_norecompute on [primary]
--����һ����������
create index index_id_name on emp(empid,empname) with pad_index,fillfactor=50 on [primary]
--ִ������������֤�Ƿ�ʹ��������
go
set showplan_text on
go 
select * from emp where empid>10 and empName='��־��'
go
set showplan_text off
go
--ɾ������
--������һ���Ǿۼ����������Ǿۼ�����һ��������
drop index emp.index_empid;
drop index index_id_name on emp;
create table grade
(
	gradeid int identity(1,1) primary key,--�༶���
	gradeName varchar(30) not null,--�༶����
	username varchar(20) not null,--�û���
	sex varchar(4) not null,--�Ա�
	age int --����
)
select * into new from grade;
select * from grade;
drop table grade;
select * from grade;
sp_helpindex grade;


insert into grade values('��ͼ1601��','��־��','��',20);
insert into grade values('��ͼ1601��','���½�','��',20);
insert into grade values('��ͼ1601��','��Ⱥ��','��',20);
insert into grade values('��ͼ1601��','���ǲ�','��',20);
insert into grade values('��ͼ1601��','�·���','��',20);
insert into grade values('��ͼ1601��','���黪','��',20);
insert into grade values('��ͼ1601��','���ڽ�','��',20);
insert into grade values('��ͼ1601��','̷����','Ů',20);
insert into grade values('��ͼ1601��','����','��',20);
insert into grade values('��ͼ1601��','������','��',20);
insert into grade values('��ͼ1601��','�ŷ��M','��',20);
insert into grade values('��ͼ1601��','�ɺ�','��',20);
insert into grade values('��ͼ1601��','��ɣ��','��',20);
insert into grade values('��ͼ1601��','����','��',20);
insert into grade values('��ͼ1601��','���ո�','��',20);
insert into grade values('��ͼ1601��','���','��',20);
insert into grade values('��ͼ1601��','������','��',20);
insert into grade values('��ͼ1601��','лɽ��','��',20);
insert into grade values('��ͼ1601��','������','��',20);
insert into grade values('��ͼ1601��','�˹���','Ů',20);
insert into grade values('��ͼ1601��','����Ƽ','Ů',20);
insert into grade values('��ͼ1601��','����','��',20);
insert into grade values('��ͼ1601��','лѧ��','��',20);
insert into grade values('��ͼ1601��','����','��',20);



insert into grade select gradeid,gradename,username,sex,age from grade;

declare @time datetime 
select @time=getdate()
select * from grade where gradename='��־��'
select getdate()-@time
--����һ����������
create index index_gradename on grade(gradeid,gradename) with pad_index,fillfactor=50 on [primary]

sp_helpindex grade;
--����һ��Ψһ�ۼ�����
create  index index_gradename on grade(gradename)
drop index index_gradename on grade;
--����һ����������
create index index_gradeid on grade(gradeid,gradename) with pad_index,fillfactor=50 on [primary]
--ִ������������֤�Ƿ�ʹ��������
--���ϵͳ��־
dump transaction test with no_log;
delete new

select * from score;
select top 3 * from score where studid  not in(select   top 3   studid  from score order by studid )
