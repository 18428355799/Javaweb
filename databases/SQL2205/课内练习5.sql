----ʹ���α�Ļ�������

--�����α�
select * from stud;
declare stud_cursor cursor dynamic for select studid,studname,sex,cardid,classid,age from stud;
--���α�
open stud_cursor;
--���α���ץȡ����
fetch next from stud_cursor;
--�ر��α�
close stud_cursor;
--ɾ���α�
deallocate stud_cursor;

--ʹ���α�
begin 
	declare @studid int,@studname varchar(20),@sex varchar(4),@cardid varchar(18),@classid int,@age int
	declare stud_cursor cursor dynamic for select studid,studname,sex,cardid,classid,age from stud;
	--���α�
	open stud_cursor;
	
	fetch next from stud_cursor into @studid,@studname,@sex,@cardid,@classid,@age;
	print 'studid:'+ltrim(str(@studid))+' studname:'+@studname+'sex:'+@sex+'cardid:'+@cardid+'classid:'+ltrim(str(@classid))+'age:'+ltrim(str(@age));
	while @@fetch_status=0
		begin
			fetch next from stud_cursor into @studid,@studname,@sex,@cardid,@classid,@age;
			print 'studid:'+ltrim(str(@studid))+' studname:'+@studname+'sex:'+@sex+'cardid:'+@cardid+'classid:'+ltrim(str(@classid))+'age:'+ltrim(str(@age));
		end
	--�ر��α�
	close stud_cursor;
	--ɾ���α�
	deallocate stud_cursor;
end


--ֻ���α�
declare stud_cursor cursor for select * from stud--ֻ���αֻ꣬����fetch next���в���
open stud_cursor--���α�
fetch next from stud_cursor 
while @@fetch_status=0
begin 
	fetch next from stud_cursor
end
close stud_cursor

--��̬�α�
select * from stud;

declare stud_cursor cursor static for select * from stud--��̬�α�
open stud_cursor
fetch last from stud_cursor--��ȡ���һ��
insert into stud values('1007','С��','Ů','362426198901160013',1,28)--����һ����¼
fetch last from stud_cursor--�޷���ȡ������������¼
close stud_cursor;

--��̬�α�

declare stud_cursor cursor dynamic for select * from stud--��̬�α�
open stud_cursor
	fetch last from stud_cursor--��ȡ���һ����¼
		insert into stud values('1007','С��','Ů','362426198901160013',1,28)
	fetch last from stud_cursor--���Ի�ȡ�����ӵ�������¼
close stud_cursor;

--�����α�
select * from stud;

declare stud_cursor cursor keyset for select * from stud
open stud_cursor
fetch last from stud_cursor
	insert into stud values('1007','С��','Ů','362426198901160013',1,28)
fetch last from stud_cursor--�޷���ȡ�����ӵ�������¼
fetch absolute 2 from stud_cursor
update stud set sex='��' where current of stud_cursor
fetch absolute 2 from stud_cursor--���Է�ӳ���µ�������¼
close stud_cursor;




--����һ�����ʱ�,����ʮ����¼��Ȼ�������α����޸Ĺ��ʵ�ֵ
--���ʵ���2000�ģ�����800
--������2000��3000�ģ�����500
--������3000��4000�ģ�����200
--���ʸ���4000�ģ�����100
create table pay
(
	userid int identity(1,1) primary key,
	username varchar(20) not null,
	pay int not null
)

select * from pay;

insert into pay values('��־��',10000);
insert into pay values('���½�',7000);
insert into pay values('��Ⱥ��',6500);
insert into pay values('���ǲ�',6000);
insert into pay values('̷����',6400);
insert into pay values('�·���',9500);
insert into pay values('����',7000);
insert into pay values('���ڽ�',8500);
insert into pay values('���黪',8100);
insert into pay values('��¶',9800);


--�����α�
declare pay_cursor cursor dynamic for select userid,username,pay from pay;
--���α�
open pay_cursor;
--���α���ץȡ����
fetch next from pay_cursor;
--�ر��α�
close pay_cursor;
--ɾ���α�
deallocate pay_cursor;





select *from pay;
--�޸Ĺ���
declare pay_cursor Cursor for select userid,pay from pay 
declare @userid int,@pay int
open pay_cursor --���α�
fetch next from pay_cursor into @userid,@pay
while @@fetch_status=0
begin
	if(@pay<2000)
	begin
		update pay set pay=(select pay from pay where userid=@userid)+800 where  current of pay_cursor
	end
	else if(@pay<3000 and @pay>2000)
	begin
		update pay set pay=(select pay from pay where userid=@userid)+500 where  current of pay_cursor
	end
	else if(@pay<4000 and @pay>3000)
	begin
		update pay set pay=(select pay from pay where userid=@userid)+200 where  current of pay_cursor
	end
	else if(@pay>4000)
	begin
		update pay set pay=(select pay from pay where userid=@userid)-100 where  current of pay_cursor
	end
	fetch next from pay_cursor into @userid,@pay
end
close pay_cursor--�ر��α�
--ɾ���α�
deallocate pay_cursor





--ʹ���α��ѯgrade��
select * from grade;

begin
	declare @gradeid int,@gradeName varchar(30),@username varchar(20),@sex varchar(4),@age int
	declare grade_cursor cursor dynamic for select gradeid,gradeName,username,sex,age from grade;
	open grade_cursor
	fetch next from grade_cursor into @gradeid,@gradeName,@username,@sex,@age;
	
	print 'gradeid:'+ltrim(str(@gradeid))+'gradeName:'+@gradeName+'username:'+@username+'sex:'+@sex+'age:'+ltrim(str(@age));
	while @@fetch_status=0
		begin
			fetch next from grade_cursor into @gradeid,@gradeName,@username,@sex,@age;
			print 'gradeid:'+ltrim(str(@gradeid))+'gradeName:'+@gradeName+'username:'+@username+'sex:'+@sex+'age:'+ltrim(str(@age));
		end
	close grade_cursor;
	deallocate grade_cursor;
end

--����class��
select * from class;

begin
	declare class_cursor cursor for select classno,classname from class
	declare @classno int,@classname varchar(20)
	open class_cursor
	fetch next from class_cursor into @classno,@classname
	print 'classno:'+ltrim(str(@classno))+'classname:'+@classname
	while @@fetch_status=0
		begin
			fetch next from class_cursor into @classno,@classname
			print 'classno:'+ltrim(str(@classno))+'classname:'+@classname
		end
		close class_cursor
		deallocate class_cursor
end

--ʹ���α����emp��
select * from emp;
begin
	declare emp_cursor cursor for select empid,empname,sex,salary from emp;
	declare @empid int,@empname varchar(10),@sex varchar(4),@salary int;
	open emp_cursor;
	fetch next from emp_cursor into @empid,@empname,@sex,@salary;
	print 'empid:'+ltrim(str(@empid))+'empname:'+@empname+'sex:'+@sex+'salary:'+ltrim(str(@salary))
	while @@fetch_status=0
		begin
			fetch next from emp_cursor into @empid,@empname,@sex,@salary
			print 'empid:'+ltrim(str(@empid))+'empname:'+@empname+'sex:'+@sex+'salary:'+ltrim(str(@salary))
		end
		close emp_cursor;
		deallocate emp_cursor;
end;

select * from pay;
--ʹ���α����pay��
begin
	declare @userid int,@username varchar(20),@pay int;
	declare pay_cursor cursor dynamic for select userid,username,pay from pay;
	open pay_cursor;
	fetch next from pay_cursor into @userid,@username,@pay;

	print 'userid:'+ltrim(str(@userid))+'username:'+@username+'pay:'+ltrim(str(@pay));
	while @@fetch_status=0
		begin
			fetch next from pay_cursor into @userid,@username,@pay;
			print 'userid:'+ltrim(str(@userid))+'username:'+@username+'pay:'+ltrim(str(@pay));
		end
		close pay_cursor;
		deallocate pay_cursor;
end;

select * from score;

select avg(scores) from score;

select @@rowcount
select * from employee;
--�޸ĸ����ŵĹ���,���ʵ���2000�ģ�����800,������2000��3000�ģ�����500
--�����α�
declare employee_cursor cursor for select work_no,salary from employee
declare @work_no varchar(6),@salary int;
--���α�
open employee_cursor;
fetch next from employee_cursor into @work_no,@salary;
while @@fetch_status=0
begin
	if(@salary<2000)
	begin
		update employee set salary=(select salary from employee where @work_no=work_no)+800 where current of employee_cursor
	end
	else if(@salary>2000 and @salary<3000)
	begin
		update employee set salary=(select salary from employee where @work_no=work_no)+500 where current of employee_cursor
	end
	fetch next from employee_cursor into @work_no,@salary
end
--�ر��α�
close employee_cursor;
--ɾ���α�
deallocate employee_cursor;




--�޸�ѧ���������
select * from stud;
declare stud_cursor cursor for select studid,studname,sex,cardid,classid,age from stud;
declare @studid int,@studname varchar(20),@sex varchar(4),@cardid varchar(18),@classid int,@age int;
open stud_cursor;
fetch next from stud_cursor into @studid,@studname,@sex,@cardid,@classid,@age;
while @@fetch_status=0
begin
	if @age=20
	begin
		update stud set age=21 where current of stud_cursor
	end
	else if(@age=28)
	begin
		update stud set age=25 where current of stud_cursor
	end
	fetch next from stud_cursor into @studid,@studname,@sex,@cardid,@classid,@age;
end
close stud_cursor;
deallocate stud_cursor;


select * from emp;
create table emp
(
	empid int identity(1,1) primary key,
	empName varchar(10) not null,
	sex varchar(4) not null,
	salary int not null
)

insert into emp values('John','M',100);
insert into emp values('Tom','M',55);
insert into emp values('Eff','F',200);
--ѭ��������Ա���Ĺ�����10%��ֱ����߹�������͹��ʵ�����Ϊֹ

declare @max int,@min int,@sum int
	set @max=(select max(salary) from emp);
	set @min=(select min(salary) from emp);
	while @min<@max
	begin
		if(@max=(@min*2))
		begin
			print 'ѭ����ֹ��߹���Ϊ��'+convert(varchar(30),@max)+'��͹���Ϊ��'+convert(varchar(30),@min)
			break;
		end
		else if(@max!=(@min*2))
		begin
			update emp set salary=(select salary from emp where empid=1)*(1.1) where empid=1;
			update emp set salary=(select salary from emp where empid=2)*(1.1) where empid=2;
			update emp set salary=(select salary from emp where empid=3)*(1.1) where empid=3;
		end
		set @max=(select max(salary) from emp);
		set @min=(select min(salary) from emp);
		print @max;
		print @min;
		print @sum;
	end


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
select datename(dw,0) '1900�����յ�����'
select convert(varchar(30),getdate(),103)
--11��2017��6��1�����ڼ�
select datename(dw,dateadd(mm,datediff(mm,0,getdate())+3,0)) '2017�����յ�����'
--12����ѯ���������ڼ�
select datepart(weekday,getdate()),datename(weekday,getdate());
--13���жϽ����Ƿ�Ϊ����
select  case  day(dateadd(mm,  2,  dateadd(ms,-3,dateadd(yy,  datediff(yy,0,getdate()),  0))))  when  28  then  'ƽ��'  else  '����'  end  '�Ƿ�Ϊ����'


declare @year int,@day int
	set @year=(select datename(yy,getdate())-1)--������ԼӼ��������������ڼ��ź���ı����ֵ�Ϳ���
	set @day=(select datediff(dd,dateadd(mm,1,dateadd(yy,(@year-1900),0)),dateadd(mm,2,dateadd(yy,(@year-1900),0))))
	while 1<2--��ѭ��
		begin
			if(@year%4=0 or @year%400=0)
				begin
					print convert(varchar(10),@year)+'��2����'+convert(varchar(10),@day)+'�죬����'+convert(varchar(10),@year)+'��������';
					break;
				end
			else
				begin
					print convert(varchar(10),@year)+'��2����'+convert(varchar(10),@day)+'�죬����'+convert(varchar(10),@year)+'�겻������';
					break;
				end
		end
