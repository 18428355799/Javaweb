/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
 
   float f;
   float c;
   
   printf("�����������¶�ֵ");
   scanf("%f,%f",&c,&f);
   f=9.0/5*c+32;
   printf("c=%f,f=%f\n",c,f); 
   fflush(stdin);   
   printf("�����뻪���¶�ֵ");
   scanf("%f,%f",&f,&c);
   c=5.0/9.0*(f-32);

   printf("f=%f,c=%f",f,c); 
}