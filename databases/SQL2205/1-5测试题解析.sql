create table �ɼ���
(
	oid int identity(1,1) primary key,
	name varchar(20) not null,
	kecheng varchar(20) not null,
	fenshu int 
)
create table �����ɼ���
(
	oid int identity(1,1) primary key,
	name varchar(20) not null,
	kecheng varchar(20) not null,
	fenshu int 
)
truncate table �ɼ���;

insert into  �ɼ��� values('����','����',81);
insert into  �ɼ��� values('����','��ѧ',59);
insert into  �ɼ��� values('����','����',99);
insert into  �ɼ��� values('����','��ѧ',90);
insert into  �ɼ��� values('����','����',56);
insert into  �ɼ��� values('����','��ѧ',30);
insert into  �ɼ��� values('����','Ӣ��',90);


insert into  �����ɼ��� values('����','��ѧ',80);
insert into  �����ɼ��� values('����','����',88);
insert into  �����ɼ��� values('����','��ѧ',90);

select * from �ɼ���

select * from �����ɼ���
--1��	��ѯ�ɼ����е�4����6�ļ�¼
select top 3 * from �ɼ��� where oid not in(select top 3 oid from �ɼ���);


--2��	��ѯ�ɼ�������ɼ���0-60��֮�䣬��ʾ���ϲ���ɼ���60-80��֮�䣬��ʾ�����á����ɼ���80-100��֮�䣬��ʾ�����㡯

select oid,name,kecheng,
case fenshu 
	when 90 then '����' 
	when 88 then '�ϲ�' 
	when 80 then '�ϲ�' 
end 
from �����ɼ���


select oid,name,kecheng,
case when fenshu<60  then '�ϲ�' 
	 when fenshu>=60 and fenshu<80 then '����' 
	 when fenshu between 80 and 100 then '����' end fenshu
from �ɼ���
--4��	���羭�����ݿγ����ƺͷ�����ѯ�����ڷ��ֲ�ѯ�ٶȺ���������Ӧ����ô���������⣿��д��ʵ�ִ���
create index idx_kecheng on �ɼ���(kecheng,fenshu);
--5��	ͳ�Ƴɼ����ƽ�����������ƽ���ɼ�����80�֣���ô�µ�������ֱ��ƽ������С��80��Ϊֹ��
while (select avg(fenshu) from �ɼ���)>=80
begin
	update �ɼ��� set fenshu=fenshu-1
end

while (select avg(fenshu) from �����ɼ���)>80
begin
	update �����ɼ��� set fenshu=fenshu-1
	print 'update'
end

select * from �����ɼ���;
--6��	������������һ���ɼ���һ�������ɼ�����ΰѲ����ɼ����µ��ɼ����У�
insert into �ɼ��� select name,kecheng,fenshu from �����ɼ���

delete �ɼ��� where oid>7;

select * from �ɼ���
update �ɼ���  set fenshu=(select fenshu from �����ɼ��� where kecheng=�ɼ���.kecheng and name=�ɼ���.name ) 
where exists (select fenshu from �����ɼ��� where kecheng=�ɼ���.kecheng and name=�ɼ���.name)


--7��	��ѯ���ϸ��µ����һ�죿
select dateadd(ms,-3,dateadd(mm,datediff(mm,0,getdate()),0));
--8��	��ѯ�����������ڼ���
select datepart(dw,getdate());
select datename(dw,getdate());
--9��	���ַ�����hello world��������дT-SQL��䣬��hello�س�������ӡ��������10�֣�
select substring('hello world!',1,5);

declare @str varchar(20);
set @str = 'hello world!';
set @str = substring('hello world!',1,5);
print @str





