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
       sid varchar(12) :='1008';
       sname varchar(20) :='С¶';
       age int :=48;
       cid int :=1;
       sex varchar(2) :='Ů';
       cardno varchar(18) :='362426199705130351';
       major varchar(30) :='�������';
       nation varchar(20) :='����';
       sdate date :=sysdate;
begin
       pro_AddStud(sid,sname,age,cid,sex,cardno,major,nation,sdate);
end;

drop procedure pro_AddStud;


select * from student;
select * from score where id=1008;


----------------------------------------------------------------------------------------------------

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

-----------------------------------------------------------------------------------------------


--ʹ���α��ѯѧ���ĳɼ���html+5,sql2005+10,java+15,jsp-5,oracle -10
--�ɼ���
select * from score;
--�γ̱�
select * from course;
--ѧ����
select * from student;

declare 
       v_courseid course.courseid%type;
       v_grade score.score%type;
       v_name student.name%type;
       v_studid student.id%type;
       cursor v_score is select c.id,c.score,c.courseid,s.name from score c inner join student s on c.id=s.id;      
begin  
       open v_score;
       loop
              fetch v_score into v_studid,v_grade,v_courseid,v_name;
              exit when v_score%notfound;
              dbms_output.put_line('�޸�֮ǰ��id='||v_studid||',name='||v_name||',score='||v_grade);             
              if v_courseid=1 then
                 v_grade := v_grade+5;
                 update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              elsif v_courseid=2 then
                     v_grade := v_grade+10;
                    update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              elsif v_courseid=3 then
                     v_grade := v_grade+15;
                    update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              elsif v_courseid=4 then
                     v_grade := v_grade-5;
                    update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              elsif v_courseid=5 then
                     v_grade := v_grade-10;
                    update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              end if; 
              commit;
              dbms_output.put_line('�޸�֮��id='||v_studid||',name='||v_name||',score='||v_grade);             
       end loop;
       close v_score;
end;









