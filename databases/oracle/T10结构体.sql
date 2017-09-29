create or replace package pkg_userinfoService
as
   --�����û��Ľṹ��
   type userInfo is record (
        id number,
        name varchar2(20),
        sex number,
        age number,
        sal number
   );
   returnVal int;
   --����û�
   function addUser(ui in userInfo)
   return number;
   --�����û���
   procedure createUserTable;
   --ɾ���û�
   function delUser(id number) 
   return number;
   --����������
   function delUser(name varchar2)
   return number;
   --�����û���Ϣ
   function updateUser(ui in userInfo)
   return number;
end pkg_userinfoService;
--��������

create or replace package body pkg_userinfoService
as
   --����û�
   function addUser(ui in userInfo)
     return number
   as
   begin
     pkg_userinfoService.createUserTable();
     execute immediate 'insert into TB_USERINFO values('''||ui.id||''','''||ui.name||''','''||ui.sex||''','''||ui.age||''','''||ui.sal||''')';
     commit;
     return 1;
   end;


   --�����û���
   procedure createUserTable as
     ifExist number;
     begin
         select count(*) into ifExist from tab where tname='TB_USERINFO';
         if ifExist=0 then 
            execute immediate 'create table TB_USERINFO(id number,--�û�id
                                    name varchar2(20),
                                    sex number,
                                    age number,
                                    sal number)';
         end if;
     end;
     
   --ɾ���û�
   function delUser(id number)
   return number
   as
   begin
      pkg_userinfoService.createUserTable();
      execute immediate ' delete from TB_USERINFO where id='||id;
      commit;
      return 1;
   end;
   --ɾ���û�����������
   function delUser(name varchar2)
   return number
   as
   begin
      pkg_userinfoService.createUserTable();
      execute immediate ' delete from TB_USERINFO where name='''||name ||'''';
      commit;
      return 1;
   end;

   --�����û���Ϣ
   function updateUser(ui in userInfo)
   return number
   as
   begin
      pkg_userinfoService.createUserTable();
      execute immediate ' update TB_USERINFO set name='''||ui.name||''',sex='''||ui.sex||''',age='''||ui.age||''',sal='''||ui.sal||''' where id='''||ui.id;
      commit;      
      return 1;
   end;
   
begin
   --���ĳ�ʼ����������ڸò���,ֻ������һ��
   returnVal :=10;
end pkg_userinfoService;

--Ȩ�޲���
grant connect,resource to scott;
grant create table to scott;

--���÷�ʽ
declare  
    ui pkg_userinfoService.userInfo;
    rest number;
begin
  ui.id:=3;
  ui.name:='������';
  ui.sex:=1;
  ui.age:=60;
  ui.sal:=20000;
  dbms_output.put_line('returnVal='||pkg_userinfoservice.returnVal);
  rest:=pkg_userinfoService.addUser(ui);
  rest:=pkg_userinfoservice.delUser('����');
end;
select * from TB_USERINFO;
drop table TB_USERINFO;


select * from user_role_privs;



--�����ĳ�����
create or replace package pkg_varTest

as
      age number :=0;
      procedure pro_setAge(v_age number);
      procedure pro_getAge(v_age out number);
end pkg_varTest;
create or replace package body pkg_varTest
as
       procedure pro_setAge(v_age number)
       as
       begin
            pkg_varTest.age := v_age;     
       end pro_setAge;

       procedure pro_getAge(v_age out number)
       as
       begin
                 v_age := pkg_varTest.age;
       end pro_getAge;
end pkg_varTest;

--���԰��б���ֵ�ı仯
declare 
    v_age number :=10;
begin
    dbms_output.put_line('pkg_varTest.age='||pkg_varTest.age);
end;


declare 
    
begin
    dbms_output.put_line('pkg_varTest.age='||scott.pkg_varTest.age);
end;

create or replace package pkg_test3
as
       --���Ĵ��л�
       PRAGMA SERIALLY_REUSABLE;
       cursor c_emp is select * from emp;
       procedure printEmp;
end pkg_test3;
create or replace package body pkg_test3
as
       --���Ĵ��л�
       PRAGMA SERIALLY_REUSABLE;
       procedure printEmp
       as
       singleEmp Emp%ROWTYPE;        
       begin
          if not c_emp%isopen then
             open c_emp;
          end if;
          fetch c_emp into singleEmp;
          dbms_output.put_line('empname='||singleEmp.ENAME);
       end printEmp;
end pkg_test3;

begin
    pkg_test3.printEmp;
end;
select * from emp;
--�鿴��
select name,text from user_source where type='PACKAGE';
select name,text from user_source where type='PACKAGE BODY';

--���±����ͷ
alter package pkg_test3 compile specification;
--���±������
alter package pkg_test3 compile body;
--ɾ����
drop package pkg_test3;
drop package body pkg_test3 ;


