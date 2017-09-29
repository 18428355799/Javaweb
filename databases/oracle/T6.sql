--�鿴��ռ�
select * from v$tablespace;
--�鿴�����ļ�
select * from v$datafile;
--�鿴��־�ļ�
select * from v$logfile;
--�鿴�����ļ�
select * from v$controlfile;
--�������ñ�ռ�
create tablespace "USERS02" datafile 'D:\oracle\product\10.2.0\oradata\orcl\users02.DBF' size 5M
reuse autoextend on next 512k maxsize 10M;

--������ʱ��ռ�
create temporary tablespace "TEMP02"
tempfile 'D:\oracle\product\10.2.0\oradata\orcl\TEMP02.DBF' size 5M
extent management local uniform size 1M;
--������ԭ��ռ�
create undo tablespace "UNDO02"
datafile 'D:\oracle\product\10.2.0\oradata\orcl\UNDO02.DBF' size 5M;

--ϵͳ��ռ䣬��ʱ��ռ䣬��ԭ��ռ䲻�ܸ���Ϊ����״̬

--���ı�Ϊ����״̬
alter tablespace "USERS02" offline normal;
--���ı�Ϊ����״̬
alter tablespace "USERS02" online;
--��user01��ռ�����Ϊֻ��״̬
alter tablespace "USERS" read only;
--��user01��ռ�����Ϊ�ɶ�д״̬
alter tablespace "USERS" read write;

--ɾ����ռ�
drop tablespace "TEMP02" including contents;
drop tablespace "USERS02" including contents;
--ɾ����ռ�������ļ�
drop tablespace "TEMP02" including contents and datafiles;
--�ı������ļ��Ĵ�С
alter database datafile 'D:\oracle\product\10.2.0\oradata\orcl\USERS02.DBF' resize 5M;
--�Զ�
alter database datafile 'D:\oracle\product\10.2.0\oradata\orcl\USERS02.DBF' autoextend on;
--�ڱ�ռ���������ļ�
alter tablespace "USERS02" add datafile  'D:\oracle\product\10.2.0\oradata\orcl\USERS03.DBF' size 5M;

--�Ա�ռ�������ļ�������
alter tablespace "USERS02" 
rename datafile  'D:\oracle\product\10.2.0\oradata\orcl\USERS03.DBF' to 'D:\oracle\product\10.2.0\oradata\orcl\USERS04.DBF'
alter tablespace "USERS02" online;

drop tablespace "USERS02" including contents and datafiles;


--�����û�
create user test identified by test 
--�޸�����
alter user test identified by test;
--ɾ���û�
drop user test;
--��Ȩ
grant create session to test;
grant create user to test with admin option;
grant update(age,sex) on SYS.student to test;
--����test���Ȩ��
grant dba to test;
--����Ȩ��
revoke create table from test;
--�鿴��ǰ�û��Ľ�ɫ
select * from user_role_privs;
--�鿴��ǰ�û���ϵͳȨ�޺ͱ�һ����Ȩ��
select * from user_sys_privs;
select * from user_tab_privs;

select * from dba_sys_privs;
select * from user_sys_privs;

select * from dba_tablespaces;
select * from dba_data_files;
select * from dba_temp_files;
--�鿴�û���Ĭ�ϱ�ռ�
select * from dba_users;


 alter user test account unlock;

 grant create session to test
 

 grant create table to test;

 grant select any table to test;

 grant insert any table to test;

--�·���
select chr(46018) || chr(47049) || chr(49658) ���� from dual;

--��־��
select chr(54520) || chr(54974) || chr(47870) ���� from dual;





--���뵼������

--����sys�û���student��course������
exp scott/123456@study tables=(student,course) file=sys_back_tab.dmp
--����ָ����student������
imp scott/123456@study file=sys_back_tab.dmp fromuser =sys touser=sys tables=(student) ignore=y;
--�����������ݿ�
exp system/123456@study file=study_full.dmp full=y;
--�����������ݿ�
imp system/123456@study file=study_full.dmp ignore=y full=y;


select * from student;

select * from class;
insert into class values(5,'��ͼ16��Ԥ�ư�');
insert into class values(6,'��ͼ16��Ԥ�ư�');



