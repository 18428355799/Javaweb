---------------------------------������ϰ--------------------------------------------

--�洢����
--����һ���򵥵Ĵ洢����
create proc chaxunacc
	@cardid varchar(20) 
as
    select * from account where cardid=@cardid
--ִ�д洢����
exec chaxunacc @cardid=100001
exec chaxunacc 4200

--ɾ���洢����
drop proc chaxunacc;

--����һ���򵥵Ĳ��������Ĵ洢����
select * from stud;
create procedure up_findstud
as
	select * from stud
--ִ�д洢���̵İ취
execute up_findstud;
exec up_findstud;
up_findstud;

--�������Ĵ洢����
create proc up_findstudbyclassid
	--�������,�������֮���ö��ŷָ�
	@classid int,
	@sex varchar(2)
as
	if @sex =''
	begin
		select * from stud where classid=@classid
	end
	else 
	begin
		select * from stud where classid=@classid  and sex=@sex
	end

up_findstudbyclassid 1,'��'
up_findstudbyclassid @classid=1,@sex='��'

--�޸Ĵ洢����ͨ��encryption�ؼ���,�Դ洢���̵�Դ������м���
alter proc up_findstudbyclassid
	@classid int,
	@sex varchar(2)
	with encryption
as
	if @sex=''
	begin
		select * from stud where classid=@classid 
	end
	else
	begin
		select * from stud where classid=@classid and sex=@sex
	end
--ɾ���洢����
drop proc up_findstudbyclassid

--�洢���̷����α�
create proc getAllstud
	--�α�������������
	@myCursor cursor varying output
as
	set @myCursor=cursor forward_only static for select * from stud
	open @myCursor
go
--ִ�д洢����
declare @myCur cursor;
	exec getAllstud @myCursor=@myCur output
	fetch next from @myCur
	while @@fetch_status=0
	begin
		fetch next from @myCur
	end	
	close @myCur
	deallocate @myCur

create proc getAllStud1
as
	declare  myCursor cursor forward_only static for select * from stud
	open myCursor
	fetch next from myCursor 
	while @@fetch_status=0
	begin
		fetch next from myCursor 
	end
	close myCursor
	deallocate myCursor
go

getAllStud1

--������
select * from sys.messages where message_id=208;

raiserror('where there is will,there is way',16,1);

--��Ӵ�����Ϣ��messages����
/*
	sp_addmessage�洢������Ӵ�����Ϣ
	1.��Ӵ�����Ϣ��id�����50001��ʼ��
	2.��Ӵ�����Ϣʱ���������Ӣ�İ�Ĵ�����Ϣ����������İ�Ĵ�����Ϣ��
	3.�ڳ�������Ҫ����ĵط���raiserror�������ø�id����
*/
use master
EXEC sp_addmessage 50001, 16, 
   N'Percentage expects a value between 20 and 100. 
   Please reexecute with a more appropriate value.','us_english'

EXEC sp_addmessage 50001, 16, 
   N'Percentage expects a value between 20 and 100. 
   ��ȷ���ٷֱ���20��100֮��',null,false,'replace'

select * from sys.messages where message_id=50001;
--����raiserror��������
raiserror(50001,16,1);



-------------------------------������ϰ--------------------------------------------------------------


--����洢���̵����ã����������ͬ�û����ļ�¼���ʹ�ӡ�Ѵ��ڣ�����ִ�в������
create proc weihuacc
	@cardid varchar(20),
	@money float
as
    declare @count int
	set @count=0
	select @count=count(*) from account where money=@money
	if @count>=0
		print '�Ѵ�����ͬ���û�'
	else
		insert into account values(@cardid,@money)
go
--ִ�д洢����
exec weihuacc @cardid=100003,@money=6000

--ɾ���洢����
drop proc weihuacc

--��дһ���洢���̣�����ĳ�����ж�����
create proc monthdays
	@month int,
	@days int output
as
	if @month%2=1
	begin
		set @days=31
		print '�������31��'
	end
	else if @month=2
	begin
		set @days=28
		print '�������28��'
	end
	else 
	begin
		set @days=30
		print '�������30��'
	end
go
declare @days int
exec monthdays 2,@days output
--ɾ���洢����
drop proc monthdays


--��д�洢���̣��ж��Ƿ�Ϊ����
CREATE PROC MONTHDAYS 
	@YEAR INT OUTPUT,@MONTH INT OUTPUT,@DAYS INT OUTPUT
AS
	--�������
	IF(@YEAR%4=0 OR @YEAR%400=0)
	BEGIN
		IF @MONTH%2=1
			SET @DAYS=31
		ELSE IF @MONTH=2
			SET @DAYS=29
		ELSE
			SET @DAYS=30
		PRINT CONVERT(VARCHAR(10),@YEAR)+'��������,����'+CONVERT(VARCHAR(10),@MONTH)+'����'+CONVERT(VARCHAR(10),@DAYS)+'��'
	END 
	--ƽ�����
	ELSE
		BEGIN
			IF @MONTH%2=1
				SET @DAYS=31
			ELSE IF @MONTH=2
				SET @DAYS=28
			ELSE
				SET @DAYS=30
			PRINT CONVERT(VARCHAR(10),@YEAR)+'�겻������,����'+CONVERT(VARCHAR(10),@MONTH)+'��ֻ��'+CONVERT(VARCHAR(10),@DAYS)+'��'
		END 
GO
DECLARE @YEAR INT ,@DAYS INT,@MONTH INT
EXEC MONTHDAYS 2017,2,@DAYS OUTPUT
DROP PROC MONTHDAYS--ɾ���洢����


--�ж�1900�������ж��ٸ�����
DECLARE @YEARSUM INT ,@YEAR VARCHAR(20),@I INT,@STR VARCHAR(1000)
	SET @YEARSUM=1900
	SET @I=0
	SET @STR=''
	WHILE @YEARSUM<(SELECT DATEPART(YY,GETDATE()))
	BEGIN
		IF(@YEARSUM%4=0 OR @YEARSUM%400=0)
			BEGIN
				SET @I=@I+1
				SET @STR=@STR+SPACE(4)+CONVERT(VARCHAR(10),@YEARSUM)
				IF(@I%10=0)
				BEGIN
					PRINT @STR
					SET @STR=''
				END
			END
			SET @YEARSUM=@YEARSUM+1
	END
			PRINT '1900�굽���ڹ���'+CONVERT(VARCHAR(10),@I)+'������'
			

--��ѯ�κ�һ����κ�һ���µ�����
create function sumday(@year int,@month int)
returns int
as
begin
	declare @day int
	set @day=(datepart(dd,dateadd(dd,-1,dateadd(mm,@month,dateadd(yy,(@year-1900),0)))))
	return @day
end
--�����ǵ���ʾ����
select dbo.sumday(2017,3) '������'

--ɾ������ֵ����
drop function sumday



-----------------------------------�ϻ��ĵ���ҵ----------------------------------------------

create table employ
(
	empid int identity(1,1) primary key not null,
	empname varchar(20) not null,
	sex varchar(4) not null,
	salary decimal(18,2) not null,
	joindate datetime
)

insert into employ values('John','��',4000,getdate());
insert into employ values('Tom','��',1800,getdate());
insert into employ values('John','Ů',2400,getdate());
insert into employ values('Petter','��',2200,getdate());
insert into employ values('Carter','Ů',2100,getdate());
insert into employ values('John','��',2500,getdate());
select * from employ;
---��дһ��������Ա����н10%�Ĺ��̣���֮������Ѿ���Ӷ�ù�Ա����60���£�����������н2000
create proc SalaryAdd
as
	update employ set salary=salary*(1+0.1)

	declare @empid int, @joindate datetime
	declare @cur cursor
	set @cur=cursor forward_only static for
		select empid, joindate from employ
	open @cur
	declare @i int
	set @i=0
	while @i<@@cursor_rows
	begin
		fetch next from @cur into @empid, @joindate
		if datediff(month, @joindate, getdate())>60
			update employ set salary=(salary+2000) where empid=@empid
		set @i=@i+1
	end
	close @cur
go

exec SalaryAdd
--ɾ���洢����
drop proc salaryadd;



----дһ���Զ���ŵĴ洢���̣���:200408010001

create table orderss(orderid varchar(12) primary key)

select * from orderss;



create procedure up_orderid2
as
	declare @str varchar(12)
	declare @cnt int
	select @str=convert(varchar(8),getdate(),112);
	select @cnt = count(*)+1 from orderss where orderid like @str+'%'
	if @cnt<10
	begin
		set @str = @str + '000'+ convert(varchar(1),@cnt)
	end
	else if @cnt<100 and @cnt>=10
	begin
		set @str = @str + '00'+ convert(varchar(2),@cnt)
	end
	else if @cnt<1000 and @cnt>=100
	begin
		set @str = @str + '0'+ convert(varchar(3),@cnt)
	end
	else
	begin
		set @str = @str + convert(varchar(4),@cnt)
	end
	insert into orderss values(@str);
	select @str
go
up_orderid2
select * from orderss;
select replicate('1',4);


alter proc up_orderid2
	@str varchar(12) output
as
	declare @cnt int
	select @str=convert(varchar(8),getdate(),112);
	select @cnt = count(*)+1 from orderss where orderid like @str+'%'
	if @cnt<10
	begin
		set @str = @str + '000'+ convert(varchar(1),@cnt)
	end
	else if @cnt<100 and @cnt>=10
	begin
		set @str = @str + '00'+ convert(varchar(2),@cnt)
	end
	else if @cnt<1000 and @cnt>=100
	begin
		set @str = @str + '0'+ convert(varchar(3),@cnt)
	end
	else
	begin
		set @str = @str + convert(varchar(4),@cnt)
	end
	insert into orderss values(@str);
go

declare @orderid varchar(12)
exec up_orderid2 @orderid output
select @orderid
select * from orderss;





--��������Ĭ��ֵ�Ĵ洢����
select * from account;

create proc WeiHuAcc2
	@usr varchar(20),
	@pwd varchar(4),
	@balance decimal(18, 2)=1500
as
	declare @count int
	set @count=0
	select @count=count(*) from account where username=@usr
	if @count>=1
		print '�Ѵ�����ͬ���û�'
	else
		insert into account values(@usr, @pwd, @balance)
go

exec WeiHuAcc2 @usr='����', @pwd='1234'

--ͨ���û�����������Ĵ洢����
create procedure FindAccPwd
	@usr varchar(20),
	@pwd varchar(4) output
as
	select @pwd=password from account where username=@usr
go
drop procedure FindAccPwd
--ִ�д��з��ز����Ĵ洢����
declare @pwd varchar(4)
exec FindAccPwd '����', @pwd output
print @pwd
 

--����һ�������α�Ĵ洢����
create procedure FindAllAcc
	@cur cursor varying output
as
	set @cur=cursor forward_only static for select * from account
	open @cur
go

--ִ�з����α�Ĵ洢����
declare @mycur cursor
	exec FindAllAcc @cur=@mycur output
	declare @i int
	set @i=0
	while @i<@@cursor_rows
	begin
		declare @usr varchar(20),@pwd varchar(4),@balance decimal(18,2)
		fetch next from @mycur into @usr,@pwd,@balance
		print '�û�����'+@usr+'���룺'+@pwd+'��'+convert(varchar(12),@balance)
		set @i=@i+1
	end
close @mycur
deallocate @mycur

--���±���洢����
exec sp_recompile FindAllAcc


--�޸Ĵ洢����
alter procedure FindAllAcc
	@cur cursor varying output
as
	set @cur=cursor forward_only static for select * from account
	open @cur
go

--ɾ���洢����
drop procedure FindAllAcc



--��дһ�����̣���Emp�����Ա�����������ͬ����Ա�������޸�
use ��ϰ
go
CREATE TABLE [dbo].[Emp](
	[empid] [int] IDENTITY(1,1) NOT NULL,
	[empName] [varchar](10) NULL,
	[sex] [char](10) NULL,
	[salary] [decimal](18, 2) NULL,
	[joindate] [datetime] NULL
) ON [PRIMARY]

select * from emp;

insert into emp values('����','��',3500,getdate());
insert into emp values('����','��',4600,getdate());
insert into emp values('С¶','Ů',4000,getdate());

create procedure up_emp
	@ename varchar(20),
	@sex char(1),
	@sal decimal(18,2),
	@jdate datetime
as
	insert into emp values(@ename,@sex,@sal,@jdate)
go


--���ô洢����
execute up_emp 
execute up_emp 'zhang','F',1200,'2007-10-10'

--�޸Ĵ洢����

drop procedure up_emp
GO
create procedure up_emp 
	@name nvarchar(20),
	@sex char(1),
	@sal decimal(18,2),
	@jdate datetime,
	@outname varchar(20) output
as 
select @outname =empname from Emp where empname =@name

if @outname is not NULL 
	print '���û��Ѿ�����'
else
	insert into emp values(@name,@sex,@sal,@jdate)
select * from emp;

--���ô洢����
declare @name varchar(20)
execute up_emp 'dd','F',1200,'2007-10-10',@name output
print @name






/*
	��֪�����ݣ�
	����  ���   ���� 

	����  100   1998/4/8 
	����  10    1998/7/4 
	��˹  20.5  1999/8/9 
	����  10    1999/8/7 
	����  30.5  1998/1/1 
	����  22.5  2000/8/4 
	��˹  30    2001/8/9 
	����  2     2002/8/4 
	����  14    2000/2/21 
	����  52    1999/12/9 
	����  33    2005/8/9 
	����  20    2007/8/9
	����  100	2007/10/21

*/

CREATE TABLE MONEYS(
	EMPID INT IDENTITY(1,1) PRIMARY KEY,
	EMPNAME VARCHAR(20) NOT NULL,
	SALARY INT NOT NULL,
	EMPTIME VARCHAR(30) NOT NULL
)
DROP TABLE MONEYS
SELECT * FROM MONEYS
INSERT INTO MONEYS VALUES('����',100,'1998/7/4')
INSERT INTO MONEYS VALUES('��˹',205,'1999/8/9')
INSERT INTO MONEYS VALUES('����',100,'1999/8/7')
INSERT INTO MONEYS VALUES('����',305,'1998/1/1')
INSERT INTO MONEYS VALUES('����',225,'2000/8/4')
INSERT INTO MONEYS VALUES('��˹',300,'2001/8/9')
INSERT INTO MONEYS VALUES('����',200,'2002/8/4')
INSERT INTO MONEYS VALUES('����',170,'2000/2/21')
INSERT INTO MONEYS VALUES('����',500,'1999/12/9')
INSERT INTO MONEYS VALUES('����',360,'2005/8/9')
INSERT INTO MONEYS VALUES('����',200,'2007/8/9')
INSERT INTO MONEYS VALUES('����',150,'2007/10/21')
/*
	��д�洢���̣�ͳ��������ÿһ����ܽ��磺
	����	1998���ܽ��	1999���ܽ��	������	2007���ܽ��
	����	10				62						100
	��˹	������������
	����������(����Ա����Ϣ)

*/
SELECT * FROM MONEYS WHERE EMPNAME='����'
SELECT DISTINCT(EMPNAME) FROM MONEYS
--ʹ�ô洢����
CREATE PROC UP_EMP 
AS 
	DECLARE @CURSOR_EMP CURSOR,@EMPNAME VARCHAR(30),@YEAR INT,@SUM VARCHAR(1000),@SUM1 VARCHAR(1000),@MAXYEAR INT,@MINYEAR INT,@I INT,@STRING VARCHAR(1000),@NUM INT
		SET @CURSOR_EMP=CURSOR FOR SELECT DISTINCT(EMPNAME) FROM MONEYS
		SET @YEAR=(SELECT LEFT(MIN(EMPTIME),4) FROM MONEYS)
		SET @SUM=''
		SET @SUM1=''
		SET @I=0
		SET @STRING='����'+SPACE(6)
		SET @MAXYEAR=(SELECT LEFT(MAX(EMPTIME),4) FROM MONEYS)
		SET @MINYEAR=(SELECT LEFT(MIN(EMPTIME),4) FROM MONEYS)
		OPEN @CURSOR_EMP
		FETCH NEXT FROM @CURSOR_EMP INTO @EMPNAME
		WHILE @I<=(@MAXYEAR-@MINYEAR)
		BEGIN
			SET @STRING=@STRING+CONVERT(VARCHAR(10),(@MINYEAR+@I))+'�ܶ�'+SPACE(6)
			SET @I=@I+1
		END
		PRINT @STRING
		WHILE @@FETCH_STATUS=0
		BEGIN
			SET @YEAR=@MINYEAR
			WHILE @YEAR<=@MAXYEAR
			BEGIN
				SET @SUM1=@SUM1+SPACE(11)+CONVERT(VARCHAR(30),ISNULL(CONVERT(VARCHAR(30),(SELECT SUM(SALARY) FROM MONEYS WHERE EMPNAME=@EMPNAME AND (SUBSTRING(EMPTIME,1,4)=@YEAR))),0.0))
				SET @YEAR=@YEAR+1
			END
			SET @SUM=''
			SET @SUM=@EMPNAME
			PRINT ''
			PRINT @SUM+@SUM1
			SET @SUM1=''
			FETCH NEXT FROM @CURSOR_EMP INTO @EMPNAME 
		END
--��ѯ�洢����
EXEC UP_EMP
--ɾ���洢����
DROP PROC UP_EMP



















