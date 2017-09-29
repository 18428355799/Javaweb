--------------------------------������ϰ--------------------------------------------------------

--����DDL������
create trigger DDLTrigger
	on database
for
	drop_table,alter_table,create_table
as
	print '������test��ɾ�����޸ģ������κα�'
	rollback transaction
go

--ɾ��DDL������
drop trigger DDLTrigger on database


--����һ��DML Insert ������
create trigger InsertTrigger
	on account
for
	insert
as
	if(select balance from inserted)<0
	begin
		print '����ʧ��'
		rollback transaction
	end
go

--ɾ��DWL������
drop trigger InsertTrigger


select * from stud;
select * from course;
select * from inserted;

--ѡ�α�
select * from selectCourse

create table selectCourse
(
	selectCourseId int identity(1,1) primary key,
	studid int not null,
	courseid int not null
)

--��ѧ�����д���������,��ѧ������������¼ʱ�ᴥ��

create trigger studAdd on stud for insert
as
	declare @studid int,@courseid int;
	--��inserted���л�ȡ������ѧ�����
	select @studid=studid from inserted;
	declare cur cursor for select courseid from course;
	open cur;
	fetch next from cur into @courseid;
	while @@fetch_status=0
	begin
		insert into selectCourse values(@studid,@courseid);
		fetch next from cur into @courseid;
	end
	close cur;
	deallocate cur;
go

select * from stud;
select * from selectCourse;
insert into stud values(1007,'С��','Ů','362426199801170013',1,23);


--ɾ��ѧ�����ϵĴ���������ִ��ɾ��ѧ�����¼ʱ��ѡ�α��и�ѧ����ѡ�μ�¼ȫ��ɾ��

create trigger studDel on stud for delete
as
	declare @studid int
	select @studid=studid from deleted
	if @studid=1007
	begin
		rollback transaction
		print '����ɾ��ѧ��Ϊ1007��ѧ������Ϣ'
	end
	else
	begin
		delete selectCourse where @studid=studid
	end
go

select * from stud;
select * from selectCourse;
delete selectCourse where studid=1008;
insert into stud values(1008,'����','��','362426197801170013',1,40);


--�޸�ѧ������ʱ���������޸����֤����
--update�����ж�ָ�����ֶε�ֵ�Ƿ��޸ģ�������޸ķ����棬���򷵻ؼ�

create trigger studUpdate on stud with encryption for update
as
	--update����ֻ���ڴ�������ʹ��
	if update(cardid)
	begin
		rollback transaction
		print 'ѧ�������֤��Ϣ�������޸�'
	end
	else
	begin
		print '�޸�ѧ��������Ϣ�ɹ�'	
	end
go

select * from stud;

update stud set age=22 where studid=1001;
update stud set cardid=362426199801160013 where studid=1001;

--�������������ã����������ѭ��
--ɾ��������
drop trigger studUpdate;

select * from sys.triggers;
select * from sys.trigger_events;

--����(enable)���߽��ô�����(disable)
disable trigger all on stud;
enable trigger all on stud;
disable trigger studAdd on stud;



-----------------------�ϻ��ĵ���ϰ---------------------------------------

select * from salarymoney;

insert into salarymoney values('����',800);
insert into salarymoney values('����',500);

--ʹ�ô�����
create trigger salary on salarymoney
	for insert
as
	if(select salary from inserted)<1000
	begin
		print '���ʲ��ܵ���1000'
		rollback transaction --�ع��������������
	end
	else
		print '����ɹ�'
	
drop trigger salary
insert into salarymoney values('С��',1000);


--�޸Ĵ�����
alter trigger salary on salarymoney
	for insert,update
as
	if(select salary from inserted)<1000 
	begin
		print '���ʲ��ܵ���1000'
		rollback transaction
	end
	else if(select salary from inserted)>10000
	begin
		print '���ʲ��ܸ���10000'
		rollback transaction
	end
	else
		print '����ɹ�'

select * from salarymoney;
insert into salarymoney values('����',800);

--����Ա����
create table yuangong
(
	deptid int,
	name varchar(20)
)
select * from yuangong;

insert into yuangong values(1,'����');
insert into yuangong values(2,'����');
insert into yuangong values(3,'������');

create trigger deletedept on yuangong
for
	delete 
as
	declare @deptid int
	set @deptid=(select deptid from deleted)
	if(select count(*) from yuangong where deptid=@deptid)>0
	begin
		print '�ò����»���Ա��'
		rollback transaction
	end
go

drop trigger deletedept
delete from yuangong where deptid=2


select * from account;

--�ڴ洢�������׳��ǲ����쳣

create proc InsertAccount
	@usr varchar(20),
	@pwd varchar(6),
	@balance decimal(12, 2)
as
	begin try
		if @balance<0
			raiserror('�˻������Ǹ���', 16,  1)
		else
			insert into account values(@usr, @pwd, @balance)
	end try
	begin catch
		declare @errMessage varchar(200)
		declare @errSeverity int
		declare @errState int

		select @errMessage=error_message(), @errSeverity=error_severity(), @errState=error_state()
			
		print '�׳��쳣��Ϣ��'+@errMessage
	end catch
go

--ɾ���洢����
drop procedure InsertAccount;
--ִ�д洢����
exec InsertAccount '����', '1234',1200

select * from classes;
select * from stud;
alter table classes add studCnt int;

--1.������ʵ����ѧ���İ༶����ɾ��
create trigger delclass on classes for delete
as
	if (select count(*) from stud where classid=(select classid from deleted))>0
	begin
		print '�ð���ѧ��������ɾ��'
		rollback transaction
	end
	else
		print 'ɾ���ɹ�'
go

drop trigger delClass;

delete classes where classid=4;

--2.������ʵ�ֵ����롢ɾ��ѧ��ʱ�޸İ༶���ж�Ӧ�༶������
create trigger studAdd on stud for insert,delete
as
	declare @classid int
	set @classid=0
	select @classid=classid from inserted
	if @classid>0
	begin
		declare cur cursor for select classid from inserted
		open cur
		fetch next from cur into @classid
		while @@fetch_status=0
		begin
			update classes set studcnt=studcnt+1 where classid=@classid
			fetch next from cur into @classid
		end	
		close cur
		deallocate cur
	end
	if @classid<=0
	begin
		declare cur cursor for select classid from deleted
		open cur
		fetch next from cur into @classid
		while @@fetch_status=0
		begin
			update classes set studcnt=studcnt-1 where classid=@classid
			fetch next from cur into @classid
		end
		close cur
		deallocate cur
	end
go

select * from classes;
select *  from stud order by classid;
select * from stud2;
insert into stud2 values(1003,'С��','Ů','123456789123456791',2,18);
insert into stud2 values(1004,'����','Ů','123456789123456792',3,18);

insert into stud select * from stud2;


delete stud2 where sex='��'

drop trigger studAdd

------------------------------�ϻ��ĵ�������ϰ---------------------------------


--1.����insert������,���Ա�����ظ������ܲ���
select * from employ;

--����һ
create trigger tg_insertemp on employ for insert
as
	declare @empname varchar(20)
	select @empname=empname from inserted
	if (select count(*) from employ where empname=@empname)!=1
	begin
		print '���ǳ��Ѵ��ڣ�'
		rollback transaction
	end
	else
	begin
		print '����ɹ���'
	end

--������
select * from employ;

create trigger empAdd on employ for insert
as
	if (select count(*) from employ where empname in(select empname from inserted))>1
	begin
		print 'Ա������������ͬ������ʧ��'
		rollback transaction
	end
go


drop trigger empAdd 
insert into employ values('Smith','��',1000,getdate(),'��ְ')
delete employ
update employ set joindate='2010-01-1'


--2.����update������,���Ա����ְ����30���£����ʲ��ܵ���2000
select * from employ;
--��һ�ַ���
create trigger tg_updatemoney on employ for update 
as 
	declare @time varchar(20),@name varchar(20),@salary int 
	select @name=empname,@salary=salary from inserted
	set @time=(select joindate from employ where empname=@name)
	if(datediff(mm,@time,getdate())>30)
	begin
		if(@salary<2000)
		begin
			print '����30�����ϵ���н���ܵ���2000'
			rollback transaction
		end
		else
			print '�޸ĳɹ���'
	end
	else
		print '�޸ĳɹ�'	
go



drop trigger tg_updatemoney

--�ڶ��ַ���
select * from employ;

drop trigger empUpdate

create trigger empUpdate on employ for update
as
	declare @empid int,@salary decimal(18,2),@joindate datetime
	declare cur cursor for select empid,salary,joindate from inserted
	open cur 
	fetch next from cur into @empid,@salary,@joindate
	while @@fetch_status=0
	begin
		if datediff(month,@joindate,getdate())>30 or @salary<2000
		begin
			print '����30���µ�Ա�����ʲ��ܵ���2000���޸�ʧ��'
			rollback transaction
		end
		fetch next from cur into @empid,@salary,@joindate
	end
	close cur
	deallocate cur
go

update employ set salary=2640 where empid=3
update employ set joindate='2008-3-4' where empid=3


--3.Ա�����д���delete��������δ��ְ��Ա������ɾ��
select * from employ;

alter table employ add status varchar(10)
update employ set status='��ְ'
update employ set status='��ְ' where empid=16;

create trigger empDelete on employ for delete
as
	declare @empid int,@status varchar(10)
	declare cur cursor for select empid,status from deleted
	open cur 
	fetch next from cur into @empid,@status
	while @@fetch_status=0
	begin
		if @status!='��ְ'
		begin
			print 'ֻ����ְԱ������ɾ��'
			rollback transaction
		end
		fetch next from cur into @empid,@status
	end
	close cur
	deallocate cur
go


select * from employ;
delete employ where empid=1;
delete employ where empid=16;
drop trigger empDelete


------------------------------------�ϻ��ĵ�������ϰ--------------------------------------------------
--��Ʒ��
create table product(
	proid int identity(1,1) primary key ,
	proname varchar(20) not null,
	price float not null,
	num int not null	
)
insert into product values('java�Ծ�','100',10)
insert into product values('jsp�Ծ�','70',12)
insert into product values('sql�Ծ�','80',13)
--������
create table orders(
	orderid int identity(1,1) primary key,
	ordername varchar(30) not null,
	ordertel varchar(30) not null,
	ordermoney float not null 
)
drop table orders
insert into orders values('����','123456789',1000)
insert into orders values('����','123456783',1000)
insert into orders values('����','123456781',1000)
insert into orders values('����','123456782',1000)
go
--���������
create table orderitems(
	id int identity(1,1) primary key ,
	orderid int foreign key  references orders(orderid) ,
	proid int  foreign key  references product(proid),
	ordernum int not null,
	price float not null,
	ordermoney float not null
	
)
drop table orderitems
select * from product;
select * from orders;
select * from orderitems;

/*
	��Ʒ��product��������������Ʒ���ơ���Ʒ�۸񡢿���ֶ�
	������orders)���������������š��ͻ������ͻ��绰�������ܽ���ֶ�
	�����orderitems����������������id����Ʒid�����������������۸񡢽��
	���=��������*�����۸�
	�����ܽ��Ϊ�ö����µ����ж�����Ľ��ĺ�
	ʹ�ô�����ʵ�֣�����ӡ�ɾ����������޸Ķ�����������ʱ��ͨ���������޸Ķ����ܽ��
*/


create trigger addmoney on orderitems for insert,update,delete
as
	declare @price float,@summoney float,@ordernum int,@proid int,@orderid int,@name varchar(20),@tel varchar(30),@i int
	select @proid=proid from inserted
	select @i=id from deleted
	if(@i!=0 and @proid='')
	begin
		--�ò���Ϊɾ��
		print 'ɾ������'
		select @price=price,@summoney=ordermoney,@ordernum=ordernum,@proid=proid,@orderid=orderid from deleted
		update orders set ordermoney=isnull((ordermoney-@summoney),0) where orderid=@orderid
	end	
	else if(@proid!='')
	begin
		print '�������޸Ĳ���'
		select @price=price,@summoney=ordermoney,@ordernum=ordernum,@proid=proid,@orderid=orderid from inserted
		set @name=(select ordername from orders where orderid=@orderid)
		set @tel=(select ordertel from orders where orderid=@orderid)
		if(update(ordernum))
		begin
			update orderitems set ordernum=@ordernum,ordermoney=(@ordernum*(select price from orderitems where orderid=@orderid and proid=@proid))  where orderid=@orderid and proid=@proid
			update orders set ordermoney=(select ordermoney from orderitems  where orderid=@orderid and proid=@proid ) where orderid=@orderid
		end
		else 
		begin
			insert into orderitems values(@proid,@orderid,@ordernum,@price,@summoney)
			update orders set ordermoney=(select ordermoney from orderitems where proid=@proid) where orderid=@orderid
		end
	end
	else
	begin
		print '�ö��������ڣ�'
		rollback tran
	end
insert into orderitems values(4,3,10,80,600)
update orderitems set ordernum=3 where proid=3
delete orderitems where orderid=1
select * from product;
select * from orders;
select * from  orderitems;
drop trigger addmoney;







--------------------------------------�ϻ��ĵ����ý���------------------------------------------


/*
6.2.	��������
��Ʒ��Product��������������Ʒ���ơ���Ʒ�۸񡢿���ֶ�
������Orders)���������������š��ͻ������ͻ��绰�������ܽ���ֶ�
�����OrderItems����������������ID����ƷID�����������������۸񡢽��
���=��������*�����۸�
�����ܽ��Ϊ�ö����µ����ж�����Ľ��ĺ�

*/

--��Ʒ��
create table Product1
(
	prodid varchar(20) not null primary key,
	prodname varchar(30),
	price decimal(18,2), 
	storeCount int
);
--������
create table Orders2
(
	orderid varchar(12) primary key,
	custname varchar(20),
	totalMoney decimal(18,2)
);
--������
create table OrderItem
(
	itemsid int identity(1,1) primary key,
	orderid varchar(12),prodid varchar(20),
	ordercount int,
	orderprice decimal(18,2),
	totalMoney decimal(18,2)
);

select * from Product1;
select * from Orders2;
select * from OrderItem;
insert into product1 values('P1001','�����',28.5,100);
insert into product1 values('P1002','�������',60,100);
insert into product1 values('P1003','ʯ�ǰ���',33,100);

truncate table orders2
truncate table orderitem

insert into orders2 values('201703170001','����',0);
insert into orderitem values('201703170001','P1001',8,28.5,8*28.5);
insert into orderitem values('201703170001','P1002',8,60,8*60);
insert into orderitem values('201703170001','P1003',8,33,8*3)


update orderitem set ordercount=7;
delete orderitem where  itemsid=4;

create trigger calcMoney on OrderItem for insert,update,delete
as
	declare @orderid varchar(12)
	select @orderid=orderid from inserted
	if @orderid is null or @orderid=''
	begin
		select @orderid=orderid from deleted
	end
	select @orderid
	declare @prodid varchar(20),@ordercount int,@orderprice decimal(18,2),@totalmoney decimal(18,2)
	set @totalmoney=0
	declare cur cursor for select prodid,ordercount,orderprice from orderitem where orderid=@orderid
	open cur
	fetch next from cur into @prodid,@ordercount,@orderprice
	while @@fetch_status=0
	begin
		set @totalmoney = @totalmoney + @ordercount*@orderprice
		update orderitem set totalmoney = @ordercount*@orderprice where current of cur
		fetch next from cur into @prodid,@ordercount,@orderprice
	end
	--���¶�������ܽ��
	update Orders2 set totalmoney =@totalmoney where orderid=@orderid
	close cur
	deallocate cur
go

