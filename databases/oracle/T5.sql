select * from student;
--������ͨ��ͼ
create view vstudent as select * from student where age>20;
--����һ��ֻ����ͼ
create view vstudent as select * from student where age>20 with read only;
--����һ���ܼ���ͼ
create view vstudent as select * from student where age>20 with check option;
--ɾ����ͼ
drop view vstudent;

select * from emp;

--distinct�����ظ�����
select distinct name from student;
--��ҳ����
select rownum,s.* from student s where rownum>5;
select * from (select rownum rn,x.* from student x) s where s.rn>5
--�������޸���ͼ
create or replace view vstudent 
as 
select id,name,age,classid,sex,major,time from student;
--with read only  �������޸���ͼ
create or replace view vstudent
as 
select id,name,age,classid,sex,major,time from student
with read only;

--ʹ����ͼ
select * from vstudent;
update vstudent set age=18 where id=1001;

--with check option 
create or replace view vstudent as 
select id,name,age,classid,sex,major,cardno,time from student where age>20 with check option;

--ɾ����ͼ
drop view vstudent;

--��������
create index index_id on student(id);
--����Ψһ����
create unique index index_cardno on student(cardno);
--����λͼ����
create bitmap index index_sex on student(sex);
--ɾ������
drop index index_sex;

--�鿴ϵͳ����
select * from user_indexes;
select * from user_ind_columns;

/*
       ͬ��ʣ�������ȡ����
       ����ͬ��ʣ�public synonym;��ϵͳ����Ա����
       ˽��ͬ��ʣ��ɶ���Ĵ����ߴ�����ֻ���Լ�ʹ�ã�
*/


--����˽��ͬ���
create synonym student for scott.student;
select * from student;
--�������е�ͬ���
create public synonym stud for scott.student;
select * from student;

--ɾ��ͬ���
drop synonym student;
drop public synonym stud;
--�鿴��ǰ�û���ͬ���
select * from user_synonyms;
--�鿴���е�ͬ���
select * from all_synonyms where synonym_name='stud';
select * from dba_synonyms where synonym_name='stud';

--��������
create sequence seq_orderid
increment by 1
start with 10000000
maxvalue 99999999
minvalue 10000000
nocycle 
cache 20
noorder

--ʹ������
select seq_orderid.nextval from dual;
select seq_orderid.currval from dual;

--������
create table orders
(
  orderid int primary key,
  custid number(8) not null,
  remark varchar2(100)
);
select * from orders;
insert into orders values(seq_orderid.nextval,seq_orderid.nextval,'��˵��');

drop table orders;

--�鿴��ǰ�û����е�����
select * from user_sequences;

select * from all_sequences;

select * from dba_sequences;

--ɾ������
drop sequence seq_orderid;


--��������
create sequence seq_id
increment by 1
start with 1
minvalue 1
maxvalue 9999999999
nocycle
cache 20;

--ʹ�����л�ȡ��ǰֵ
select seq_id.nextval from dual;
--��ȡ��һ��ֵ
select seq_id.currval from dual;

create table major 
(
  majorid number(11) not null,
  majorname varchar2(20) not null,
  constraint pk_majorid
  primary key(majorid)
);

drop table major;
commit;
select * from major;
insert into major values(seq_id.nextval,'�������');
insert into major values(seq_id.nextval,'�����Ӧ��');

select * from course;
insert into course values(seq_id.nextval,'struts');
insert into course values(seq_id.nextval,'Hibernate');
insert into course values(seq_id.nextval,'Spring');
insert into course values(seq_id.nextval,'MyBatis');
insert into course values(seq_id.nextval,'json');
insert into course values(seq_id.nextval,'SpringMVC');
insert into course values(seq_id.nextval,'jbpm');
insert into course values(seq_id.nextval,'Ajax');
insert into course values(seq_id.nextval,'jQuery');
insert into course values(seq_id.nextval,'easyUI');
delete course where courseid=7;

--ɾ������
drop sequence seq_id;

select * from user_sequences;
select * from all_sequences;

select * from student;
select * from class;


select * from emp;
--�鿴ϵͳ������
select * from user_indexes;


