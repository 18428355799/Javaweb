/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a,f;
   char b;
   printf("������һ��������һ���ַ����ö��Ÿ�����");
   scanf("%d,%c",&a,&b);
   printf("����ǰ��a=%d,b=%c\n",a,b); 
   f=a;
   a=b;
   b=f;
   
   printf("������a=%d,b=%c\n",a,b);    
}