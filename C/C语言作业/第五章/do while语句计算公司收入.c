/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{  int a,n;
   float sum;
   n=1;
   sum=0;
   printf("*************************��***************************\n");
   printf("*                                                    *\n"); 
   printf("*         XXX��˾2008���������ͳ��ϵͳ              *\n"); 
   printf("*                                                    *\n");
   printf("*************************��***************************\n");
   do{
   		printf("\t\t�������%d���µ�������",n);
   		scanf("%d",&a);
   		n++;
   		sum+=a;
   	
   	
   }while(n<=12);
   printf("\t\tXXX��˾2008�����������Ϊ��%0.3f",sum);
}