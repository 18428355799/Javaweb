--���뺯��
begin
    dbms_output.put_line('Hello World!');
end;
--�ṹ�������
declare
    v_str varchar2(50);
    vboolean boolean:=false;
    v_grade number(5,2);
begin
    if vboolean then
      v_str:='����Ϊ�棬��ʾ�����';
      dbms_output.put_line(v_str);
    else
      dbms_output.put_line('����Ϊ��');
    end if;
    
    v_grade:=69;
    if v_grade>=90 then
       dbms_output.put_line('�ɼ�����');
    else if v_grade>=80 and v_grade<90 then
       dbms_output.put_line('�ɼ�����');
    else if v_grade>=60 and v_grade<80 then
       dbms_output.put_line('�ɼ��ϸ�');
    else
       dbms_output.put_line('������');
    end if;
end;




--����¶ȴ���30�棬����ʾ���¶�ƫ�ߡ�,���벢ִ�����³���
set serveroutput on;
declare 
  v_temprature number(5):=32;
  v_result boolean:=false;
 begin
  v_result:=v_temprature>30;
    if v_result then
       dbms_output.put_line('�¶�'|| v_temprature ||'��,ƫ��');
    end if;
 end;




--�����Ա���ʾ���,���벢ִ�����³���

 declare
     v_sex varchar2(2);
     v_title varchar2(10);
 begin
     v_sex:='��';
     if v_sex='��' then
        v_title:='����';
     else
        v_title:='Ůʿ'; 
     end if;
     dbms_output.put_line(v_title || '���ã�');
 end;
 
 select * from emp;

--ʹ��CASE�ṹʵ��ְ��ת��,���벢ִ�г���
declare 
     v_job varchar2(10);
begin
     select job into v_job from emp where empno=7788;
     case v_job
     when 'PRESIDENT' then
          dbms_output.put_line('��Աְ���ܲ�');
     when 'MANAGER' then
          dbms_output.put_line('��Աְ�񣺾���');
     when 'SALESMAN' then
          dbms_output.put_line('��Աְ������Ա');
     when 'ANALYST' then
          dbms_output.put_line('��Աְ��ϵͳ����Ա');
     when 'CLERK' then
          dbms_output.put_line('��Աְ��ְԱ');
     else
          dbms_output.put_line('��Աְ��δ֪');
     end case;
end;


 declare
     v_job varchar(30);
     v_result varchar(50);
  begin
     select job into v_job from emp where empno=7839;
     v_result := case v_job
          when 'PRESIDENT' then 'ְ���ܲ�'
          when 'MANAGER' then 'ְ�񣺾���'
          when 'SALESMAN' then 'ְ������Ա'
          when 'CLERK' then 'ְ��ְԱ'
          else 'ְ�񣺲�֪��'
          end;   
    dbms_output.put_line(v_result);            
  end;
  
  
  --loopѭ��(��1��100�ĺ�)
  declare
       v_total number(20):=0;
       v_num number(3):=1;
       begin
           loop
               v_total:=v_total+v_num;
               v_num:=v_num+1;
               --�˳�����
               exit when v_num>100;
           end loop;
           dbms_output.put_line('v_total=' || v_total);  
       end;
    
--for ѭ������1��100�ĺͣ�
declare
      v_total number(20):=0;
      v_num number(3):=1;
      begin
            for v_num in 1..100 loop
                v_total:=v_total+v_num;
            end loop;
            dbms_output.put_line('v_total=' || v_total);
      end;

--��ӡͼ��
  declare 
    v_num number(3) :=1;
  begin
    for v_num in 1..8 loop
         dbms_output.put_line(to_char(v_num)||rpad('*',v_num,'*'));
    end loop;
  end;
  
  
--whileѭ�����
declare
    v_total number(20):=0;
    v_num number(3):=1;
begin
    while v_num<=100 loop
          v_total:=v_total+v_num;
          v_num:=v_num+1;
    end loop;
    dbms_output.put_line('v_total='|| v_total);
end;

--��ӡ�žų˷���
set serveroutput on;

declare
    v_i number(2):=1;
    v_j number(2):=1;
begin
    for v_i in 1..9 loop
        for v_j in 1..v_i loop
            dbms_output.put(v_j||'*'||v_i||'='||(v_i*v_j)||'    ');
        end loop;
        --����
        dbms_output.new_line(); 
    end loop;
end;

select * from student;

declare 
  --������ͨ����
  v_name varchar(20);
  --���������ͬʱ���Ը�������ֵ
  v_age number(2) :=20;
  --���ݱ���ֶ������������ʹ���������ͺͱ��е��ֶ����Ͷ�Ӧ
  v_studid student.id%TYPE :=1003;
  --�����¼������
  r_stud student%ROWTYPE;
  --���峣��
  v_pi CONSTANT NUMBER(6,5) :=3.14159;
  --����table���͵����ͣ��Զ�����������ͣ�,��̬��������
  type table_type is table of varchar(20) index by binary_integer;
  --�������
  arr table_type;
begin
  arr(1):='one';
  arr(2):='two';
  arr(3):='three';
  arr(4):='four';
 DBMS_OUTPUT.put_line('arr(2)='||arr(2));
  
 DBMS_OUTPUT.put_line('v_pi='||v_pi);
  v_name := '����';
  DBMS_OUTPUT.put_line('id='||v_studid||';name='||v_name || ';age'|| v_age);
  --����¼������ֵ
  select * into r_stud from student where id=1007;
  --ʹ�ü�¼���� 
  DBMS_OUTPUT.put_line('id='||r_stud.id||';name='||r_stud.name || ';age'|| r_stud.age);
  --�Ѳ�ѯ������浽������
  select id,name,age into v_studid,v_name,v_age from student where id=1002;
  DBMS_OUTPUT.put_line('id='||v_studid||';name='||v_name || ';age'|| v_age);
end; 




--ʹ��case�ı��ʽ�ṹ

declare
    v_grade varchar2(10);
    v_result varchar2(10);
    begin
        v_grade:='B';
        v_result:=case v_grade
        when 'A' then '��'
        when 'B' then '��'
        when 'C' then '��'
        when 'D' then '��'
        else 'δ֪'
    end;
    dbms_output.put_line('���۵ȼ�:'||v_result);
end;



--ʹ��case�������ṹ
select * from emp;

declare
    v_sal number(5);
begin
    select sal into v_sal from emp where empno=7788;
    case
        when v_sal>=3000 then
             dbms_output.put_line('���ʵȼ�����');
        when v_sal>=1500 then
             dbms_output.put_line('���ʵȼ�����');
        else
             dbms_output.put_line('���ʵȼ�����');
        end case;
end;


--��1��+3��+5��+...+15�� ��ֵ
declare
    v_total number(5):=0;
    v_count number(5):=1;
begin
    loop
        v_total:=v_total+v_count**2;
        exit when v_count=15;
        v_count:=v_count+2;
    end loop;
    dbms_output.put_line('v_total='||v_total);
end;


