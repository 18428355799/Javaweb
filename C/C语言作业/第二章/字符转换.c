/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   char a,f;
   char b;
   printf("������һ��������һ���ַ����ö��Ÿ�����");
   scanf("%c,%c",&a,&b);
   printf("����ǰ��a=%c,b=%c\n",a,b); 
   f=a;
   a=b;
   b=f;
   
   printf("������a=%c,b=%c\n",a,b);   
}