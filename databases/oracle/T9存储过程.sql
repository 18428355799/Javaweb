--�����洢����
create or replace procedure proc_emp is
begin
    dbms_output.put_line('Hello World!');
end;
--ִ�д洢����
begin
    proc_emp();
end;

call proc_emp();
--ɾ���洢����
drop procedure proc_emp;



create or replace procedure p_stud(
       v_date out varchar2
)
is 
begin
      select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss day') into v_date from dual;
      dbms_output.put_line('�û������ɹ���');
end p_stud;


declare v_date varchar2(50);
begin 
    p_stud(v_date);
    dbms_output.put_line('�û������ɹ���' || v_date);
end;


--�����洢����
create or replace procedure pro_test
is
begin
       declare
          v_studname student.name%type;
          v_cardno student.cardno%type;
       begin
          select name,cardno into v_studname,v_cardno from student where id=1001;
          dbms_output.put_line('�洢����ִ�гɹ�');
          dbms_output.put_line('id=1001��ѧ����name��'||v_studname||',cardno��'||v_cardno);
       end;
end pro_test;

--ִ�д洢����
begin
    pro_test();
end;
--ɾ���洢����
drop procedure pro_test;


/*
    �������Ĵ洢����
    in �������
    out �������
    in out �����������
*/
select * from score;

create or replace procedure pro_studscore(studid in varchar2,studscore out number)
as
begin
       select sum(score) into studscore from score where id=studid;
       dbms_output.put_line('id='||studid||'���ܷ�Ϊ:'||studscore);
end pro_studscore;
--ִ��
declare
    studid varchar2(12):=&studid;
    studscore number(5,2);
begin
    pro_studscore(studid,studscore);
    dbms_output.put_line('studscore='||studscore);
end;
--ɾ��
drop procedure pro_studscore;


--ͳ��1601��ָ���γ̵�ƽ����

create or replace procedure pro_ClassAvgScore(v_classid number,v_courseid number,v_avgscore out number)
as
begin
       declare 
          v_classname varchar(50);       
          v_coursename varchar(50);
       begin
          select classname into v_classname from class where classid=v_classid;
          select coursename into v_coursename from course where courseid=v_courseid;
          select avg(score) into v_avgscore from score where courseid=v_courseid and id in (select id from student where classid=v_classid);
          dbms_output.put_line(v_classname||'��'||v_coursename ||'ƽ������:' ||v_avgscore );
       end;
end pro_ClassAvgScore;

select * from class;
select * from score;
select * from course;
--ִ��
declare
    v_classid number(5) :=&classid;
    v_courseid number(5) := &courseid;
    v_avgscore number(5,2);
begin
     pro_ClassAvgScore(v_classid,v_courseid,v_avgscore);
     dbms_output.put_line('ƽ������:'||v_avgscore);
end;
--ɾ��
drop procedure pro_classavgscore;





--�洢�������α꣬ѭ����䣬�����������Ľ��Ӧ��

create or replace procedure pro_ModifyScore(classid number)
as
begin
       declare
          v_courseid course.courseid%TYPE;
          cursor c_course is select courseid from course;
       begin
          open c_course;
          loop
               fetch c_course into v_courseid;
               exit when c_course%NOTFOUND;
               if v_courseid=1 then
                  update score set score=score-5 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=2 then
                 update score set score=score-10 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=3 then
                  update score set score=score-15 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=4 then
                  update score set score=score+5 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=5 then
                   update score set score=score+10 where courseid=v_courseid and  id in(select id from student where classid=classid);
               end if;
               commit;               
          end loop;
          close c_course;
       end;
end pro_ModifyScore;
--ִ��
declare 
       v_classid number(5) :=&classid;
begin
    pro_ModifyScore(v_classid);   
end;

--ɾ��
drop procedure pro_ModifyScore;

select * from score where id in(select id from student where classid=1) order by id;


select * from student;
select * from score;
select * from course;


--�쳣��������
--����һ��ѧ�����ϣ�ͬʱ���ɼ�����������5����¼
create or replace procedure pro_AddStud
(
       sid varchar,
       sname varchar,
       age int,
       cid int,
       sex varchar,
       cardno varchar,
       major varchar,
       nation varchar,
       sdate date
)
as
begin
       declare 
             v_courseid int;
             cursor c_course is select courseid from course;
       begin
             insert into student values(sid,sname,age,cid,sex,cardno,major,nation,sdate);
             open c_course;
             loop
                  fetch c_course into v_courseid;
                  exit when c_course%notfound;
                  insert into score values(sid,v_courseid,dbms_random.value*100);
             end loop;
             close c_course;
             commit;
             exception
                 when dup_val_on_index then
                      rollback;
                      dbms_output.put_line('Ψһ�����ظ�����');
                 when others then
                      rollback;
           
       end;
end pro_AddStud;
--�������
select * from student;
select dbms_random.value from dual;
declare
       sid varchar(12) :='1009';
       sname varchar(20) :='С��';
       age int :=21;
       cid int :=1;
       sex varchar(2) :='��';
       cardno varchar(18) :='362426199705130352';
       major varchar(30) :='�������';
       nation varchar(20) :='����';
       sdate date :=sysdate;
begin
    pro_AddStud(sid,sname,age,cid,sex,cardno,major,nation,sdate);
end;
--ɾ��
drop procedure pro_AddStud;

select * from class;
select * from student;
select * from score where id=1009;




