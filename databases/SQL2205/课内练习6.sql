create table account(
	id int identity(1, 1) primary key,
	cardid varchar(20),
	money float check(money>=0)
);

select * from account;

insert into account values('100001',4000);
insert into account values('100002',6000);
insert into account values('100004',8000);
insert into account values('100005',10000);

--����

begin
	begin tran;
	declare @errorsum int;
	set @errorsum=0;
	update account set money=money+200 where cardid='100001';
	update account set money=money-200 where cardid='100002';
	set @errorsum=@errorsum+@@error;

    if @errorsum>0
		begin
			print 'ת��ʧ��';
			rollback tran;
		end
	else
		begin
			print 'ת�˳ɹ�';
			commit tran;
		end
end;

create table zhanghu
(
	id int identity(1, 1) primary key,
	kahao varchar(20),
	yue decimal(12, 2)
)

select *from zhanghu;

alter table zhanghu add constraint dayu_zero check(yue>=0);


insert into zhanghu(kahao,yue) values('100000001', 2000);
insert into zhanghu(kahao, yue) values('100000002', 0);

--ת�˲�����ͬһ�������д���
begin tran
	declare @errorsum int
	set @errorsum=0
	update zhanghu set yue=yue-2500 where kahao='100000001'
	set @errorsum=@errorsum+@@error
	update zhanghu set yue=yue+2500 where kahao='100000002'
	set @errorsum=@errorsum+@@error

	print '�鿴ת�˽��'
	if @errorsum>0
	begin
		print 'ת��ʧ��'
		rollback tran
	end
	else
	begin
		print 'ת�˳ɹ�'
		commit tran
	end

--���ñ����
begin transaction
	update zhanghu set yue=yue-1000 where kahao='100000001'
	save tran bcd1
	update zhanghu set yue=yue+500 where kahao='100000002'
	save tran bcd2
	rollback transaction bcd1
	commit transaction
end

--�������
set deadlock_priority normal

set lock_timeout 18000

--��������ĸ��뼶��
set tran isolation level read committed

select datepart(weekday,getdate()),datename(weekday,getdate())
set datefirst 1
select '����'+case  when cast(datepart(dw,getdate()) as char(1))= 7 then '��' else cast(datepart(dw,getdate()) as char(1)) end


--�쳣�����������
--������Ҫô���ɹ���Ҫô��ʧ��
select * from stud;

begin try
	begin transaction
	insert into stud values(1007,'������','��','123456789123456794',4,17);
	insert into stud values(1008,'С��','Ů','123456789123456795',4,18);
	--�ύ����
	commit transaction
end try
begin catch
	--�ع�����
	rollback
	print '����ʧ��'
end catch


create table test
(
	age int not null,--����
	major varchar(10) not null,--�ص� 
	sex varchar(4) not null,--�Ա�
	hobit varchar(10) not null,--����
	money int not null--���
)

select * from test;

--(ʹ��try catch�ع�)
begin try
	begin transaction
	insert into test values(16,'aa','Ů','aa',2000);
	insert into test values(17,'aa','Ů','aa',2000);
	save transaction save1 --���ñ����
	insert into test values(16,'aa','Ů','aa',2000);
	insert into test values(18,'aa','Ů','aa',2000);
	commit transaction
	end try
	begin catch
		rollback transaction save1--�ع��������
	end catch

--(ʹ�ô����@@error���лع�)
begin transaction
	declare @err int;
	set @err=0;
	insert into test values(16,'aa','Ů','aa',2000);
	set @err=@err+@@error
	insert into test values(17,'aa','Ů','aa',2000);
	set @err=@err+@@error
	save transaction save1--���ñ����
	insert into test values(16,'aa','Ů','aa',2000);
	set @err=@err+@@error
	insert into test values(18,'aa','Ů','aa',2000);
	set @err=@err+@@error
	commit transaction 
	if @err>0
	begin
		print 'ʧ��'
		rollback transaction save1
	end

	begin transaction
	insert into test values(40,'ww','��','daf',4000);
	save transaction mysave
	delete from test where age=40
	select * from test
	rollback transaction mysave
	commit transaction
	go
	select * from test
	go


select * from test;

--------------------------------------------------------------------------------------
create table salarymoney(
	moneyname varchar(10) primary key ,
	salary int not null

)
truncate table salarymoney
insert into salarymoney values('����',10000)
insert into salarymoney values('����',10000)
delete salarymoney
select * from salarymoney
select @@rowcount



--ת������
begin tran
		declare @error int,@num int,@num2 int
		set @error=0
		set @num=0
		set @num2=0
		update salarymoney set salary=salary-1000 where moneyname='����'
		set @num=@num+@@rowcount
		update salarymoney set salary=salary+1000 where moneyname='����'
		set @num2=@num2+@@rowcount
		if(@error!=0)
		begin
			if(@num=0)
				begin
					print '����ʧ��,������㣬����������ǳ�����'
					rollback tran
				end
			else if(@num2=0)
				begin
					print '����ʧ��,�տ�ǳ������޷�ת�ˣ�'
					rollback tran
				end
			print '����ʧ��'
			rollback tran
		end
		else if(@error=0)
		begin
			if(@num=0)
				begin
					print '����ʧ��,������㣬����������ǳ�����'
					rollback tran
				end
			else if(@num2=0)
				begin
					print '����ʧ��,�տ�ǳ������޷�ת�ˣ�'
					rollback tran
				end
			else
				begin
					print '���׳ɹ�'
					commit tran
				end
		end

select *from salarymoney;
select * from stud;


--------------------------------�ϻ��ĵ�������ϰ--------------------------------------------------


--ת��������

create table account
(
	username varchar(10) not null,--�û���
	password int not null,--����
	balance decimal(18,2) default 0 --
)
create table book
(
	bookid int identity(1,1) primary key,--���
	bookname varchar(20) not null,--����
	authorname varchar(20) not null,--����
	price float not null,--�۸�
	discount float not null,--�ۿ�
	inventory int default '0'     --���
)
create table orders
(
	orderid  int identity(1,1) primary key,--������
	customername varchar(20) not null,--����
	createdate datetime,--����ʱ��
	status varchar(2) check(status='c' or status='p')--״̬
)
create table orderitem
(
	itemid int identity(1,1) primary key,
	orderid int not null ,
	bookid int not null,
	quantity int not null default '0',--����
	price float not null --�۸�
)
drop table book
drop table orders
drop table orderitem
drop table account
insert into account values('����',1234,1000.50)
insert into account values('����',6666,260.20)
-------------------------------------------------
insert into book values('java','���Ļ�',100.00,0.85,10)
insert into book values('jsp','̷��ǿ',80.00,0.75,1)
insert into book values('���ݽṹ','���Ļ�',30.00,0.75,5)
-----------------------------------------------------
insert into  orders values('����',getdate(),'c')
insert into  orders values('�廪it',getdate(),'p')
insert into  orders values('����',getdate(),'p')
----------------------------------------------------
select * from account
select * from orderitem
select * from orders
select * from book

delete orderitem
delete book
delete  orders
/*
	��������Ҫ����2��java��2��jsp��дһ�δ��뱣��ö������ο��������£�
	1.��������
	2.���涩����¼
	3.���涩�����¼
	4.�ӿͻ����ʻ��п۳���������Ʒ�Ľ�������������ǰ�����Ĳ���
	5.�۳�ͼ���棬����治��������ǰ�������Ĳ���
	6.�ύ����
*/
begin tran
	declare @money float,@sumcount int,@sumcount1 int,@sumerror int;
	set @money=(select balance from account where username='����');
	set @sumcount=(select inventory from book where bookname='jsp');
	set @sumcount1=(select inventory from book where bookname='java');
	set @sumerror=@sumerror+@@error
	save tran save1;
	--���붩����
	insert into orders values('����',getdate(),'p');
	insert into orders values('����',getdate(),'p');
	save tran save2;
	--���붩��
	insert into orderitem values(1,1,2,100.00)
	insert into orderitem values(2,2,2,80.00)
	save tran save3;
	if(@money<360)
	begin
		print '���㣬����ʧ�ܣ�'
		--�ص������
		rollback tran save2;
	end
	if(@sumcount<2 or @sumcount1<2)
	begin
		print '��治��������ʧ�ܣ�'
		--�ص������
		rollback tran save1;
	end
	else
	begin
		update book set inventory=inventory-2 where bookname in('jsp','java')--���ٿ��
		update account set balance=balance-360 where username='����'--��ȥ������
		print '���׳ɹ���'
		commit tran
	end	
	






