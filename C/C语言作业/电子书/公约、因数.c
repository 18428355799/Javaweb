/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int x,y;
   int m,i,a=1;//aΪ��Լ����mΪ��󹫱���
   printf("������������ֵ");
   scanf("%d,%d",&x,&y);
   m=x;
   if(x<y){
   		x=y;
   		y=m;  	
   }for(i=1;i<=y;i++){
   	if(x%i==0&&y%i==0)
   		a=i; 	
   }
   printf("��������������ǣ�%d\n",a);
   		m=(x*y)/a;
   printf("��������󹫱����ǣ�%d",m);
   		
}