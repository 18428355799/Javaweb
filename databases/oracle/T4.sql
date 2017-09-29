--Ա����
create table emp
(
       deptno int primary key,
       job varchar2(20) not null,
       sal int not null
)

select * from emp;
insert into emp values(1,'������',6000);
insert into emp values(2,'���Բ�',7000);
insert into emp values(3,'Ӫ����',8000);

--�༶��
create table class
(
       classid int primary key not null,
       classname varchar(20)
);

select * from class;
--ѧ����
create table student
(
       id varchar2(12) not null,
       name varchar2(20) not null,
       age number(3) default 0,
       classid int,
       sex varchar2(2),
       cardno varchar2(18) not null,
       major varchar2(20),
       nation varchar(30),
       time date
)
select * from student;
drop table student;
--�����ֶ�
alter table student add sex varchar2(2);
alter table student add cardno varchar2(18) not null;
alter table student add major varchar2(20);
alter table student add nation varchar(30);
alter table student add time date;
alter table student add aaaa varchar(30);

--ɾ���ֶ�
alter table student drop column aaaa;

--�޸��ֶ�
alter table student modify major varchar2(30);
--�鿴��ṹ
desc student;

--��������
alter table student add constraint pk_stud primary key(id);
--ΨһԼ��
alter table student add constraint un_cardno unique(cardno);
--�����⽨
alter table student add constraint fk_stud foreign key(classid) references class(classid);

--�γ̱�
create table course
(
       courseid number(2) not null,
       coursename varchar2(30) not null,
       primary key(courseid)
)

select * from course;
--�ɼ���

create table score
(
       id varchar2(12) not null,
       courseid number(2) not null,
       score number(5,2),
       constraint pk_score primary key (id,courseid)
)

select * from score;

insert into class values(1,'��ͼ1601��');
insert into class values(2,'��ͼ1602��');
insert into class values(3,'��ͼ1603��');
insert into class values(4,'��ͼ1604��');
select * from class;

insert into course values(1,'html');
insert into course values(2,'sql2005');
insert into course values(3,'java');
insert into course values(4,'jsp');
insert into course values(5,'oracle');
select * from course;

insert into student values(1001,'����',20,1,'��','123456789012345678','�������','����',sysdate);
insert into student values(1002,'����',22,1,'��','123456789012345679','�������','����',sysdate);
insert into student values(1003,'����',24,1,'��','123456789012345680','�������','����',sysdate);
insert into student values(1004,'С��',18,1,'Ů','123456789012345681','�������','����',sysdate);
insert into student values(1005,'��С��',30,1,'��','123456789012345682','�������','����',sysdate);
insert into student values(1006,'����',19,1,'Ů','123456789012345683','�������','����',sysdate);
insert into student values(1007,'СС',19,4,'Ů','123456789012345685','�������','����',sysdate);
select * from student;

select * from score;
insert into score values(1001,1,88);
insert into score values(1001,2,78);
insert into score values(1001,3,68);
insert into score values(1001,4,99);
insert into score values(1001,5,54);
commit;
insert into score values(1002,1,88);
insert into score values(1002,2,78);
insert into score values(1002,3,68);
insert into score values(1002,4,99);
insert into score values(1002,5,54);
insert into score values(1003,1,88);
insert into score values(1003,2,78);
insert into score values(1003,3,68);
insert into score values(1003,4,99);
insert into score values(1003,5,54);
insert into score values(1004,1,88);
insert into score values(1004,2,78);
insert into score values(1004,3,68);
insert into score values(1004,4,99);
insert into score values(1004,5,54);
insert into score values(1005,1,88);
insert into score values(1005,2,78);
insert into score values(1005,3,68);
insert into score values(1005,4,99);
insert into score values(1005,5,54);
insert into score values(1006,1,88);
insert into score values(1006,2,78);
insert into score values(1006,3,68);
insert into score values(1006,4,99);
insert into score values(1006,5,54);

select * from score;
commit;

--������
select * from student s inner join class b on s.classid=b.classid;
select s.*,b.classname from student s inner join class b on s.classid=b.classid;
select id,name,age,sex,major,classname  from student s inner join class  b on s.classid=b.classid;

--�������ӵȼ۵����
select * from student s,class b where s.classid = b.classid;

----������
--������
select * from student s left join class b on s.classid = b.classid;
--������
select * from student s right join class b on s.classid = b.classid;
--��ȫ����
select * from student s full join class b on s.classid = b.classid;
--��������
select * from student cross join class;

select s.id,s.name,b.classname,k.coursename,c.score from student s
inner join class b on s.classid = b.classid
inner join score c on c.id=s.id
inner join course k on k.courseid=c.courseid
order by s.id,k.courseid;

--�Ӳ�ѯ
select * from student where classid=(select classid from class where classname='��ͼ1601��');
select s.id,s.name,
(select score from score where courseid=1 and id=s.id)html,
(select score from score where courseid=2 and id=s.id)sql2005,
(select score from score where courseid=3 and id=s.id)java,
(select score from score where courseid=4 and id=s.id)jsp,
(select score from score where courseid=5 and id=s.id)oracle
from student s;


--������ѯ
select * from student;
--����ʱ�����ʹ��to_date����ת����ʽ
update student set time = to_date('2016-06-23','yyyy-mm-dd')where id=1001;
update student set time = to_date('2016-07-23','yyyy-mm-dd')where id=1002;
update student set time = to_date('2016-08-23','yyyy-mm-dd')where id=1003;
update student set time = to_date('2017-06-23','yyyy-mm-dd')where id=1004;
update student set time = to_date('2017-07-23','yyyy-mm-dd')where id=1005;
update student set time = to_date('2017-08-23','yyyy-mm-dd')where id=1006;
update student set time = to_date('2015-08-08','yyyy-mm-dd')where id=1007;
select sysdate from dual;

--between and
select * from student where time between to_date('2016-01-01','yyyy-mm-dd')and to_date('2016-12-31','yyyy-mm-dd');
--in ,not in
select * from student where id not in(1001,1003,1005);
--exists
select * from student s where exists(select * from class where classname='��ͼ1601��' and s.classid=classid);


--���Ʊ����Ʊ�Ľṹ�����ݣ����ǲ��Ḵ�Ʊ���������������飬Ψһ��Լ��

select * from student;
--����ѧ����ı�ṹ��ͬʱ�������еļ�¼
create table student2 as select * from student;
--����ѧ����Ĳ����ֶΣ�ͬʱ�������еļ�¼
create table student2 as select id,name ,cardno,major from student;
--����ѧ����ı�ṹ�����ǲ�������¼
create table student3 as select * from student where 1=2;
select * from student3;
--����������¼
insert into student3 select * from student
insert into student2 select id,name,cardno,major from student
select * from student2
--ɾ������
delete student2
truncate table  student2;
alter table student2 add constraint pk_stud2 primary key(id);
--�����û����û���lgr,����lgr;
create user lgr identified by lgr;
--����lgr�û���¼��Ȩ��
grant create session to lgr;
--����lgr���в�ѯscott�û�emp���Ȩ��
 grant select on emp to lgr;
 --�����û���ѯscott.emp���Ȩ��
revoke select on emp from lgr;

select * from dept where loc is not null;

--ģ����ѯlike
select * from student where name like '%С';
select * from student where name like 'С%';
select * from student where name like '%С%';
select * from student where name like 'С_';

select * from student where cardno like '%8_';
select table_name from user_tables;
select * from EMPLOYEES;


select count(*) from student;
select sum(age),avg(age),max(age),min(age) from student;

select id,sum(score) from score group by id;
select * from emp;
select deptno,job,sum(sal) from emp group by deptno,job;
--Rollupʵ��	���������پۺ�
select deptno,job,sum(sal) from emp group by rollup(deptno,job);
--Cube�����γ�rollup�Ľ�������ᰴ�෴�ķ����γɽ��
select deptno,job,sum(sal) from emp group by cube(deptno,job);
--group by sets�൱��union����2��������group by ���Ľ����ʾ����;
select deptno,job,mgr,sum(sal) from emp group by grouping sets((deptno,job),(job,mgr)) order by deptno;
--�൱������2��ͳ�ƽ���ĺ�
select deptno,job,sum(sal) from emp group by deptno,job;
select job,mgr,sum(sal) from emp group by job,mgr ;

--�߼��Ӳ�ѯ���ɶԱȽ�
--Where�־��е��Ӳ�ѯ,��ѯ���ʱȲ���ƽ�����ʸߵ�Ա��
Select a.empno,a.ename,a.deptno,a.sal,b.avg_sal
	from emp a, (select deptno,avg(sal) avg_sal from emp
			group by deptno) b
	where a.deptno = b.deptno and a.sal > b.avg_sal
--�����Ӳ�ѯ
select empno,ename,sal, (
	case
	when sal>4000 then '����'
	when sal>2000 then '����'
	else '����'
	end)  ��н�ײ�
  from emp;

select ѧ��,����,
case �Ա�
when '��' then '˧��'
when 'Ů' then '��Ů'
end �ǳ� from ѧ����;

--��ѯԱ������������������
select empno,ename from emp e order by (select dname from dept d where e.deptno=d.deptno)


--With��䶨��һ����������ʾһ����䣬ͨ�����ñ����������Ӿ䣬ʵ�����ã����Ч��,��ѯ�����ܹ��ʴ������в��Ź��ʵ�ƽ��ֵ�Ĳ���

with 
dept_costs AS(
   select deptno,sum(sal) as dept_total
   from emp
   group by deptno),
avg_cost AS(
   select sum(dept_total)/count(*) as dept_avg
   from dept_costs)
select * from dept_costs where dept_total>(select dept_avg from avg_cost) order by deptno


--������ͼ
create view vstudent as select * from student where age>22;
--ʹ����ͼ
select * from vstudent;
--�޸���ͼ,with check option�涨������ͼֻ�ܲ�ѯ�������24��ѧ�����ϣ�ֻ���������޸ģ�ɾ���������24��ѧ������
create or replace view vstudent as select * from student where age>24;
with check option;

--ֻ����ͼ
create or replace view vstudent as select * from student where age<30 with read only;

--ɾ����ͼ
drop view vstudent;

select * from user_views;
