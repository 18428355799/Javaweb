/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{  int a,n;
   float sum;
  
   printf("*************************��***************************\n");
   printf("*                                                    *\n"); 
   printf("*         XXX��˾2008���������ͳ��ϵͳ              *\n"); 
   printf("*                                                    *\n");
   printf("*************************��***************************\n");
   n=1;
   sum=0;
   while(n<=12){
   		printf("\t\t�������%d���µ�����",n);
   		scanf("%d",&a);
   		n++;
   		sum+=a;
   }
   printf("\t\tXXX��˾2008���������Ϊ��%0.3f\n",sum);
   
}