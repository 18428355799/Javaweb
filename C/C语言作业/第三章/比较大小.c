/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a,z,x,big;
   printf("�����������������ÿո������");
   scanf("%d,%d,%d",&a,&z,&x);
   big=a>z?a:z;
   big=big>x?big:x;
   printf("%d,%d,%d������һ���ǣ�%d\n",a,z,x,big); 
}