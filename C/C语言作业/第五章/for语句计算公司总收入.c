/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{  int a,n;
   float sum;
   n=0;
   sum=0;
   printf("*************************��***************************\n");
   printf("*                                                    *\n"); 
   printf("*         XXX��˾2008���������ͳ��ϵͳ              *\n"); 
   printf("*                                                    *\n");
   printf("*************************��***************************\n");
   for(n=1;n<=12;n++){
   		printf("\t\t�������%d���µ�������",n);
   		scanf("%d",&a);
   		sum+=a;
   	
   }
   printf("\t\tXXX��˾2008���������Ϊ��%0.3f",sum);
}