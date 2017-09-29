--��ͼ�Ĵ����Ͳ�ѯ
create table class
(
	classno int not null,
	classname varchar(20)
)
create table student
(
	stuno int not null,
	stuname varchar(10) not null,
	classno int not null,
	sex varchar(4) ,
	age int
)
drop table student
create table courses
(
	cno int not null,
	cname varchar(20) not null
)
create table studentcourse
(
	stuno int not null,
	cno int,
	score int
)
SELECT * FROM CLASS;

insert into class values(200801,'ST0801');
insert into class values(200802,'ST0802');
insert into class values(200803,'ST0803');

select * from student;

insert into student values(20080801,'����',200801,'��',19);
insert into student values(20080802,'����',200801,'��',18);
insert into student values(20080201,'����',200802,'��',20);

select * from courses;

insert into courses values(201,'C����');
insert into courses values(202,'java');
insert into courses values(203,'jsp');

select * from studentcourse;

insert into studentcourse values(20080101,201,71);
insert into studentcourse values(20080102,201,80);
insert into studentcourse values(20080101,202,65);
insert into studentcourse values(20080102,202,56);
insert into studentcourse values(20080101,203,45);


--�鿴�Ƿ�������
sp_helpindex studentcourse;
--�ж���ͼ�Ƿ���ڣ�������ɾ��
if exists(select * from sysobjects where name='v_studentscore' and type='v')begin drop view v_studentscore end 
--��ѯѧ����������ѧ�ţ��ɼ�,�γ�����
select s.studid,studname,coursename,scores from stud s 
inner join score ss on s.studid=ss.studid
inner join course c on ss.courseid=c.courseid;

select * from stud;
select * from classes;
select * from course;
select * from score;

--������ͼ
create view vstudentscore as 
select s.studid,studname,coursename,scores from stud s
inner join score ss on s.studid=ss.studid
inner join course c on ss.courseid=c.courseid where scores>=80;


create view vscore as 
select studid,courseid,scores from score 
where scores>=80;

--�޸���ͼ
alter view vstudentscore as 
select s.studid,studname,coursename,scores from stud s
inner join score ss on s.studid=ss.studid
inner join course c on ss.courseid=c.courseid where scores>=60;

select * from vstudentscore
select * from score;
--ɾ����ͼ
drop view vstudentscore;
drop view vscore;

--ʹ����ͼ,����ͼ���Ƶ�ǰ���ݱ�ʹ��
--��ͼ����������
--��ͼ����������
--��ͼ���ܰ���order by�Ӿ�
--��ͼ�в���ʹ��distinct��compute,compute by,union���
select * from vstudentscore

--������ͼ
create view vscore as 
select c.courseid,coursename,credit from course c
inner join score s on s.courseid=c.courseid
select * from vscore;
select * from course;

--�޸���ͼ
alter view vscore as 
select * from score where scores>=60 with check option;

--ɾ����ͼ
drop view vscore;

--�ô洢���̴�����¼
sp_addlogin 'zzh','1234';
--�ô洢����ɾ����¼
sp_droplogin 'zzh'
--����ɫ����û�
sp_addsrvrolemember

--���������¼����
create login zzh with password='1234';
--������ɾ����¼����
drop login zzh;

--�����û���һ����¼���ƶ�Ӧһ���û���
create user zzh for login zzh;

--���û���Ӧ����Ȩ
grant select on stud(studid,studname) to zzh;
grant select on stud to zzh;
grant insert on stud to zzh;
grant delete on stud to zzh;
grant update on stud to zzh;

--ȡ����Ȩ
revoke delete on stud from zzh;
revoke select on stud from zzh;
revoke insert on stud from zzh;
revoke update on stud from zzh;

