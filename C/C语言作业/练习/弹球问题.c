/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a;
   float h=100,sum=100;
   for(a=1;a<=9;a++){
   		sum+=h;
   		h=h/2;
   	
   }
   printf("һ���߹���%0.2f(��)\n",sum);
   printf("�������%0.3f(��)",h);
}