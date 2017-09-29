select * from student;
--��ѯ���������ڼ�
select to_char(sysdate,'dy')from dual;

--����������
create or replace trigger tr_updateStud
before insert or update or delete on student
begin
     if to_char(sysdate,'dy','nls_date_language=american')='tue' then       
         raise_application_error(-20000,'�ܶ����ܸ���ѧ������');
         dbms_output.put_line('�ܶ����ܸ���ѧ������');
     end if;
end tr_updateStud;

--ɾ��������
drop trigger tr_updateStud;

update student set age=23 where id=1009;
delete student where id='1001';

select to_char(sysdate,'dy','nls_date_language=american') from dual;

-------------------------------------
--������������ֹ����Ϣ�ոı��Ա����Ϣ
create or replace trigger tri_emp_weekend
before insert or update or delete on emp
begin
     if to_char(sysdate,'dy','nls_date_language=american') in ('sat','sun');
        then
        raise_application_error(-20000,'��������ĩ�޸Ĺ�Ա����Ϣ');
     end if;
end tri_emp_weekend;

drop trigger tri_emp_weekend;


---------------------------------------
--Ϊemp����һ������������ִ�в������ʱ��ͳ�Ʋ�����Ա����������ִ�и��¹��ʲ���ʱ��ͳ�Ƹ��º�Ա��ƽ�����ʣ�
--��ִ��ɾ������ʱ��ͳ��ɾ����������ŵ�����

create or replace trigger trg_emp_dml
after insert or update or delete on emp
declare
     v_count number,
     v_sal number(6,2);
begin
     if inserting then 
         select count(*)into v_count from emp;
         dbms_output.put_line(v_count);
     elsif updating then 
         select avg(sal) into v_sal from emp;
         dbms_output.put_line(v_sal);
     else 
         for v_dept in(select deptno,count(*)num from emp group by deptno);
         loop
             dbms_output.put_line(v_dept.deptno||''||v_dept.num);
         end loop;
      end if;
end trg_emp_dml;


drop trigger trg_emp_dml;


-------------------------------------
select * from course;



create or replace trigger tr_test
after insert or update on course
for each row
begin
    if inserting then
       dbms_output.put_line('�������ݼ�¼ǰ:�γ̱��='||:old.courseid||',�γ����ƣ�'||:old.coursename);
       dbms_output.put_line('�������ݼ�¼��:�γ̱��='||:new.courseid||',�γ����ƣ�'||:new.coursename);
    elsif updating then
       dbms_output.put_line('�޸����ݼ�¼ǰ:�γ̱��='||:old.courseid||',�γ����ƣ�'||:old.coursename);
       dbms_output.put_line('�޸����ݼ�¼��:�γ̱��='||:new.courseid||',�γ����ƣ�'||:new.coursename);
    elsif deleting then
       dbms_output.put_line('ɾ�����ݼ�¼ǰ:�γ̱��='||:old.courseid||',�γ����ƣ�'||:old.coursename);
       dbms_output.put_line('ɾ�����ݼ�¼��:�γ̱��='||:new.courseid||',�γ����ƣ�'||:new.coursename);
    end if;
end tr_test;

select * from course order by courseid;
insert into course values(6,'xml');
update course set coursename='mysql' where courseid=6;
delete course where courseid=6;

drop trigger tr_test;


--�����޸�ĳ�е�ֵ�������һ������
--�����޸�Ա������ʱ���޸ĺ�Ĺ��ʱ�����޸�ǰ��Ҫ��
create or replace trigger tri_updateEmpSal
before update of sal on emp
for each row
begin
    if :old.sal>:new.sal then
       raise_application_error(-20001,'Ա�����ʱ�����޸�֮ǰ�ĸ���');
    end if;
end tri_updateEmpSal;

select * from emp;


update emp set sal = 899 where empno=7369;

--ɾ��
drop trigger tri_updateEmpSal;

------------------------------------------------
create table syslog
(
     username varchar(20),
     logtime date     
);

drop table syslog;

select * from syslog;

create or replace trigger tri_login
after logon on database
begin
     insert into syslog values(user,sysdate);
end tri_login;

drop trigger tri_login;


----------------------------

create table createObjectRec
(
    user_id varchar2(30),
    object_type varchar2(20),
    object_name varchar2(30),
    object_owner varchar2(30),
    creation_date date
);

select * from createObjectRec;
drop table createObjectRec;

-----------------------------------
create or replace trigger tri_createObjectLog
after create or drop on database
begin
      insert into createObjectRec values(ora_login_user,ora_dict_obj_type,ora_dict_obj_name,ora_dict_obj_owner,sysdate);
end tri_createObjectLog;

--------------------------------------------

create table test22(id number(8) not null primary key,name varchar2(30));

select * from createObjectRec;
drop table test22;


--------------------------------

create or replace procedure pro_test222
as
begin
       dbms_output.put_line('�����洢����');
end pro_test222;


-------------------------------------------
create or replace package pkg_sharePool
as
       v_num number;
end pkg_sharePool;

select count(*) from emp group by deptno;
select * from emp where deptno=30;

drop trigger pkg_sharePool;

--�м��Ĵ���������ȡ���ű��
create or replace trigger tri_deptno
before insert or update on emp
for each row
begin
    pkg_sharePool.v_num := :new.deptno;
end;

drop trigger pkg_sharePool;

----------------------------------
create or replace trigger tri_addEmp
after insert or update on emp
declare 
      v_total number(2);
begin
      select count(*) into v_total from emp where deptno=pkg_sharePool.v_num;
      if v_total>=8 then
         raise_application_error(-20001,'�����������ܳ���8��');
      end if;
end tri_addEmp;


drop trigger tri_addEmp;

insert into emp values(1,'����','developer',7698,sysdate,8000,0,30);
insert into emp values(2,'С��','developer',7698,sysdate,8000,0,30);
insert into emp values(3,'����','developer',7698,sysdate,8000,0,30);
insert into emp values(4,'����','developer',7698,sysdate,8000,0,30);
select * from emp where deptno=30;
delete emp where empno=1;

/*
       1.�������в���ʹ����������䣻
       2.���ܶ�ȡ�����޸ı�����������������ΨһԼ���ֶε�ֵ�������Ҫ���붨��ȫ�ֵİ�������ͨ���м����������浽�����У�
       3.�������в�����������ȡlong,long raw�����ֶε�ֵ��
       4.�������Ĵ�С���ܳ���32K��
*/
--���ô�����
alter trigger tri_addEmp disable;
--�������
alter trigger tri_addEmp enable;
--�������д�����
alter table emp enable all triggers;
--�������д�����
alter table emp disable all triggers;
--���±���
alter trigger tri_addEmp compile;
--�鿴������Դ��
select * from user_triggers;



