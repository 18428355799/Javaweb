/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  //1.����һ�������ж����Ƿ�Ϊ5��7�ı������û�����ѭ���������ֽ����жϣ�ֱ������'n'��������
  int a;  	
  while(1){
  	printf("������һ������");
  	scanf("%d",&a);
  	if((a=getchar())=='n'){
  		break;  		
  	}
  	if(a%5==0 || a%7==0){
  		
  		printf("������5��7�ı���\n");	
  		
  	}else{
  		printf("��������5��7�ı���\n");  	
  	}
  	       	
  }  
}