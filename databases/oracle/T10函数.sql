
--����һ��ѧ�ţ�����ѧ�����ܷ�
create or replace function fun_staticsScore(p_studid score.id%TYPE)

return NUMBER

as
       total number(5,2);
begin
       select sum(score) into total from score where id=p_studid;
       return nvl(total,-1);
Exception 
       when NO_DATA_FOUND THEN
            dbms_output.put_line('ѧ�Ų�����1');
            return 0;
       when OTHERS then
            dbms_output.put_line('ѧ�Ų�����2');
            return 0;
end fun_staticsScore;   

--���ú���
select fun_staticsScore('1001') from dual;
select distinct id from score;

--�鿴����
select name,text from user_source where type='FUNCTION' AND NAME='FUN_STATICSSCORE';
    
select * from user_source where type='FUNCTION' AND NAME='FUN_STATICSSCORE';

--���±���
alter function fun_staticsScore compile;

--ɾ������
drop function fun_staticsScore
--�鿴�洢����
select name,text from user_source where type='PROCEDURE'

select * from student;
select * from class;
select * from score;
select * from course;

declare 
       v_classid student.classid%TYPE:=1;
       v_course course.courseid%TYPE:=2;
       v_score score.score%TYPE;
begin
       PRO_CLASSAVGSCORE(v_classid,v_course,v_score);
       dbms_output.put_line('v_score='||v_score);
end;




