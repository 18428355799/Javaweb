/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  //1.����һ�������ж����Ƿ�Ϊ5��7�ı������û�����ѭ���������ֽ����жϣ�ֱ������'n'��������
  int a,b;
  do{
	  	printf("������һ������");
	  	scanf("%d",&a);
	  if('n'==(getchar()))
	  	break;
	  if(a%5==0 && a%7==0)
	  	printf("������������\n");
	  
	  else{
	  	printf("��������������\n");
	  }
  }while(1);
  	
  
}