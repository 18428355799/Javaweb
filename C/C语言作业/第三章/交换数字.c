/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a,b,f;
   printf("�����������������ö��Ÿ�����");
   scanf("%d,%d",&a,&b);
   printf("����ǰ��a=%d,b=%d\n",a,b); 
   f=a;
   a=b;
   b=f;
   
   printf("������a=%d,b=%d\n",a,b); 
}