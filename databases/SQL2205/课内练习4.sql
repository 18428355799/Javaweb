--���������
use Test
select * from grade where gradename='��ͼ1601��'
go

--T_SQL�е�ע��
--����ע��
select * from grade where gradename='��ͼ1601��';

use Test
select * from grade where gradename='��ͼ1601��';/*����ע��*/
--@@ERROR������һ�����ִ�еĴ�����Ϣ��0��ʾû�д���
select @@error
--���ݿ�ϵͳ�İ汾@@servion
select @@version;
--��ѯ��һ�����ִ�еļ�¼��@@rowcount
select * from stud;
select @@rowcount;
--��ȡ���ݿ�ķ���������
select @@servername;
--��ȡ����
select @@language;
--��������
select @@servicename;
--���ӵ�������
select @@max_connections

--��ӡ�žų˷���
print space(30)+ '�žų˷���'
declare @i int,@j int,@string varchar(1000)
	set @i=1
while @i<=9
	begin 
		set @j=1;
		set @string=''
while @j<=@i
	begin 
		select @string=@string+convert(varchar(10),@j)+'*'+convert(varchar(10),@i)+'='+convert(varchar(20),@i*@j)+space(2) 
		set @j=@j+1--��������
	end
		print @string
		set @i=@i+1
	end


declare @i int,@j int,@sum int
	set @i=1;
	set @j=1;
	set @sum=1;
		while @i<=9
		begin
			set @j=1
			while(@j<=@i)
			begin
				set @sum=@i*@j;
				print cast(@j as varchar(2)) + '*' + cast(@i as varchar(2))+'='+convert(varchar(2),@sum);
				set @j=@j+1;
			end
			set @i=@i+1;
		end	



--ˮ�ɻ���
declare @num int ,@ge int ,@shi int ,@bai int 
set @num=100
while @num<1000
	begin 
		set @bai=@num/100
		set @shi=@num/10%10
		set @ge=@num%10
		if(@bai*@bai*@bai+@shi*@shi*@shi+@ge*@ge*@ge=@num)
		print @num
		set @num=@num+1
	end	



--����
print '��������'
declare @a int,@i int,@j int
	set @i=6
	set @a=0
	while @i<1000
		begin
			set @a=0
			set @j=2
			while @j<=@i
				begin
					if(@i%@j=0)
					set @a=@a+(@i/@j)
					set @j=@j+1
				end
				if(@i=@a)
				print @i
				set @i=@i+1
		end
			print '������'




--����ӵ����ִ���500ʱ�Զ�ֹͣ
declare @sum int,@i int
	set @i=0
	set @sum=0
	while @sum<=500
	begin
		set @sum=@sum+@i
		set @i=@i+1
	end
		print @sum



--1��100��Щ�����Ա�3��7����

declare @num int ,@i int
	set @i=1
	while @i<=100
		begin
			if(@i%3=0 and @i%7=0)
				begin
					print @i
				end	
			set @i=@i+1 --�������ʽ
		end

--ʹ��swtich case ���ж����������磬���磬����

declare @time int,@fen int,@miao int
	set @time=(select datepart(hh,getdate()));--ʱ
	set @fen=(select datepart(mi,getdate()));--��
	set @miao=(select datepart(second,getdate()));--��
		begin
			print case 
			when @time>0 and @time<=12 then  '����������ʱ��   '+convert(varchar(30),@time)+':'+convert(varchar(10),@fen)+':'+convert(varchar(10),@miao)
			when @time>12 and @time<=18 then '����������ʱ��   '+convert(varchar(30),@time)+':'+convert(varchar(10),@fen)+':'+convert(varchar(10),@miao)
			when @time>18 and @time<=24 then '����������ʱ��   '+convert(varchar(30),@time)+':'+convert(varchar(10),@fen)+':'+convert(varchar(10),@miao)
		end
end



--��ӡ����
print '15�е�����'
declare @a int,@b int
	set @a=1 set @b=15
	if(@b%2!=1)
		print '���ֱ��붼������'
	else
	while(@a<=@b)
		begin
			if(@a%2=1)
				print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
				set @a=@a+1
		end
			set @a=@a-2
			while (@a<=@b)
		begin
			if(@a%2=1)
				print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
				set @a=@a-1    
			if (@a<0)
				break
		end





--��ӡ����
declare @a int,@b int
set @a=7 set @b=21
if(@a%2=1)
	while(@a<@b)
	begin
		print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
		set @a=@a+2
	end





--��ӡ������
declare @a int
declare @b int
declare @c nvarchar(100)
	set @a=1
	set @b=1
	set @c=''
	while (@a<=8)
	begin
	   while (@b<15)
			begin 
				set @c=@c+'*'
				set @b=@b+1
			end
				print @c 
				set @a=@a+1
	end



--��ӡֱ��������
declare @a int 
	set @a=1
	while(@a<11)
	begin
		print replace(space(@a),' ','*')
		set @a=@a+1
	end



--��ӡԲ��
declare @a int,@b int
set @a=9 set @b=13

while (@a<=@b)
begin
if(@a%2=1)
print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
set @a=@a+1
end
set @a=@a-1
begin
print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
end
while (@a<=@b)
begin
if(@a%2=1)
print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
set @a=@a-1
if(@a<10)
break
end
set @a=@a-2
begin
print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
end




--��a,b,c�����������ֵ
declare  @a int,@b int,@c int,@max  int
set @a=1 set @b=2 set @c=3 
if  @a>@b               
   set  @max=@a
else
   set  @max=@b
if  @max<@c
   set  @max=@c      
print   @max



--��1��100֮�������
declare @i int ,@j int ,@num int 
	set @i=1
	set @num=0
	while @i<100
		begin 
			set @num=0
			set @j=2
			while @j<@i
				begin 
					if(@i%@j=0)
						set @num=1
						set @j=@j+1
				end 
					if(@num=0)
						print @i
					set @num=0
					set @i=@i+1
		end


--��Ԫ�ټ�

declare @i int
declare @j int
declare @k int
set @i=1
while @i<=(100/5)
 begin
   set @j=1
   while @j<=(100/3)
    begin
      set @k=100-@i-@j
       if @i*5+@j*3+(@k/3.0)=100 --���λ�õ�3.0���ܻ���3,�����������
         begin
           print '����:'+cast(@i as varchar)+' ĸ��:'+cast(@j as varchar)+' С��:'+cast(@k as varchar)
         end
         set @j=@j+1
     end
    set @i=@i+1
  end



--ѡ������ʹ��
--if..else����ʹ��
declare  @i int;
	set @i=2
	if @i=1
begin
	goto x
end
else
begin
	print '���ܲ�ѯ'
end
x:print'��ѯ�ɹ�'


begin
	declare @cnt int;
	set @cnt =(select count(*) from stud where age<18);
	if @cnt>0
	begin
		print '��δ������'
	end
else
	begin
		print 'û��δ������'
	end
end;


--while����ʹ��
declare @i int
	set @i=1;
	while @i<1
begin
	print @i;
	set @i=@i+1
end
print '@i'



--ѭ������ʹ��
begin
	declare @i int;
	set @i=0;
	while @i<10
		begin
			print @i;
			set @i=@i+1;
		end;
end;



--1�ӵ�100��ֵ

begin
	declare @i int,@sum int;
	set @i=1;
	set @sum=0;
	while @i<=100
		begin 
		  set @sum=@sum+@i;
		  set @i=@i+1;
		end;
	print @sum;
	print '1+2+3....+100�ĺ�='+cast(@sum as varchar(100));
end;	 





select * from stud;
--case���
select studname,case age
	when 19 then '19'
	when 21 then '21'
	end 
	as ����
from stud;

select * from grade;

select gradeid,
sum(case when sex='��' then num else 0 end) as M,
sum(case when sex='Ů' then num else 0 end) as F
from grade
group by gradeid

select * from stud;

--while��ʹ��continue
while(select avg(age) from stud)<25
begin 
	update stud set age=age+1
	if(select max(age) from stud)>20
		 break
	else 
		begin
			continue
			print '�Ѿ�����'--˵����continue�������䲻�ᱻִ��
		end
end

--goto��ʹ��
declare @a int
	set @a=100
	goto mylab
	set @a=200
	mylab: set @a=@a/10
	print @a


--when��ʹ��
declare @t tinyint
	set @t=20;
	print case
		when @t>=7 and @t<11 then '����'
		when @t>=11 and @t<13 then '����'
		when @t>=13 and @t<17 then '����'
	else '����'
end
waitfor time '10:10';
select * from stud --�ȵ����ʱ��ִ��
waitfor delay '4:10';--�ӳ�4��Сʱִ��
select * from stud ;

delete from stud where studid=1006;


waitfor delay '00:00:10'--�ӳ�10����ִ��
insert into stud values(1006,'С��','��','362426199601160013',1,21);
waitfor time '15:25:00'--��ָ����ʱ��ִ�и����



--try...catch�쳣�����������
begin try
	begin tran
		insert into stud(studid,studname,sex,cardid,classid,age) values(1006,'С��','��','362426199501160013',1,22);
		commit tran
		print 'commited'
	end try
	begin catch
		rollback
		print 'rollback'
	end catch


begin try
	begin transaction 
	insert into stud values(1006,'С��','��','362426199501160013',1,22);
	insert into stud values(1007,'С��','Ů','362426199701160013',1,21);
	commit transaction
end try
begin catch
	--�ع�����
	rollback
	print '����ʧ��'
end catch

select * from stud;
