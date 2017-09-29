--oracle���ú������÷�

--(��ȡ��ǰʱ��)����ת��Ϊ�ַ���
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')as nowTime from dual;
--��ȡʱ�����
select to_char(sysdate,'yyyy')as nowYear from dual;
--��ȡʱ�����
select to_char(sysdate,'mm') as nowMonth from dual;
--��ȡʱ�����
select to_char(sysdate,'dd')as nowDay from dual;
--��ȡʱ���ʱ
select to_char(sysdate,'hh24')as nowHour from dual;
--��ȡʱ��ķ�
select to_char(sysdate,'mi')as nowMinute from dual;
--��ȡʱ�����
select to_char(sysdate,'ss')as nowSecond from dual;


--�����β
select TRUNC(TO_DATE('2017-04-13 10��15','yyyy-mm-dd hh:mi'),'yyyy') from dual;
--���½�β
select TRUNC(TO_DATE('2017-04-13 10:15','yyyy-mm-dd hh:mi'),'mm') from dual;
--���ս�β
select TRUNC(TO_DATE('2017-04-13 10:15','yyyy-mm-dd hh:mi'),'dd') from dual;
--��ʱ��β
select TRUNC(TO_DATE('2017-04-13 10:15','yyyy-mm-dd hh:mi'),'hh') from dual;
--���ֽ�β
select TRUNC(TO_DATE('2017-04-13 10:15','yyyy-mm-dd hh:mi'),'mi') from dual;

--��ĳ�������ڼ�
select to_char(to_date('2017-04-13','yyyy-mm-dd'),'day') from dual;
--����һ      
select to_char(to_date('2017-04-13','yyyy-mm-dd'),'day','NLS_DATE_LANGUAGE = American') from dual;      
--��������֮�������
select floor(sysdate-to_date('20160607','yyyymmdd')) from dual;

--�����·����������İ취
select to_char(add_months(last_day(sysdate) +1, -2), 'yyyymmdd'),last_day(sysdate) from dual;
--�ҳ����������
select add_months(trunc(sysdate,'year'),12)-trunc(sysdate,'year') from dual;
--��ͬʱ����ʱ�䴦��
select to_char( NEW_TIME( sysdate, 'GMT','EST'), 'dd/mm/yyyy hh:mi:ss') ,sysdate from dual; 
--5����һ�����,sssss��ʾ5λ����
select TO_DATE(FLOOR(TO_CHAR(sysdate,'SSSSS')/300) * 300,'SSSSS') ,TO_CHAR(sysdate,'SSSSS') from dual 

--һ��ĵڼ���
select to_char(sysdate,'ddd'),sysdate from dual;
--����Сʱ���֣���,����
 select      
     Days,      
     A,      
     TRUNC(A*24) Hours,      
     TRUNC(A*24*60 - 60*TRUNC(A*24)) Minutes,      
     TRUNC(A*24*60*60 - 60*TRUNC(A*24*60)) Seconds,      
     TRUNC(A*24*60*60*100 - 100*TRUNC(A*24*60*60)) mSeconds      
    from      
    (      
     select      
     trunc(sysdate) Days,      
     sysdate - trunc(sysdate) A      
     from dual      
   )    
   
--�����µĵ�һ��,���һ��
 SELECT Trunc(Trunc(SYSDATE, 'MONTH') - 1, 'MONTH') First_Day_Last_Month,
   Trunc(SYSDATE, 'MONTH') - 1 / 86400 Last_Day_Last_Month,
   Trunc(SYSDATE, 'MONTH') First_Day_Cur_Month,
   LAST_DAY(Trunc(SYSDATE, 'MONTH')) + 1 - 1 / 86400 Last_Day_Cur_Month
FROM dual;
   
--1.����ʱ���
--ע:oracleʱ�����������Ϊ��λ,���Ի��������,��
-- ʱ���-��
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))/365) as spanYears from dual;
--ʱ���-��
select ceil(months_between(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))) as spanMonths from dual;   
-- ʱ���-��     
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))) as spanDays from dual;            
-- ʱ���-ʱ
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))*24) as spanHours from dual;        
--ʱ���-��
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))*24*60) as spanMinutes from dual;    
--ʱ���-��
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))*24*60*60) as spanSeconds from dual; 

--2.����ʱ��
--ע:oracleʱ��Ӽ���������Ϊ��λ,��ı���Ϊn,���Ի��������,��
-- �ı�ʱ��-��
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n*365,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;     
--�ı�ʱ��-��  
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),add_months(sysdate,n) as newTime from dual;                     
--�ı�ʱ��-��            
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;       
-- �ı�ʱ��-ʱ     
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n/24,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;      
-- �ı�ʱ��-��  
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n/24/60,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;     
--�ı�ʱ��-��
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n/24/60/60,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;   

----�ַ��������÷���

--�ַ����Ľ�ȡ
select substr('abcdefg',1,3) from dual;
--�����Ӵ���λ��
select instr('abcdefg','fg') from dual;
--�ַ�������
select 'hello' || 'hello world' from dual;

--������ĸ��ASCIIֵ
select ascii('a') from dual;
--����ASCIIֵ��Ӧ����ĸ
select chr(122) from dual;
--�����ַ����ĳ���
select length('abcdefg') from dual;

----���ֺ���
--ȡ������(ceil ����ȡ��,floor����ȡ��)
select ceil(66.6)N1,floor(66.6)N2 from dual;
--ȡ��(power) �� ��ƽ����(sqrt)
select power(3,2) N1,sqrt(9) N2 from dual;
--����
select mod(9,5) from dual;



