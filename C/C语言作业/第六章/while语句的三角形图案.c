/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   //��д�������һ�����Σ�Ҫ����Ƕ��forѭ��ʵ�֣�
   int a=0,b=0;
   
  while(a<=5){
  		b=1;
   		while(b<=a){													 
   			printf("*\t");
   			b++; 			 			
   		}
   		a++;
   		printf("\n");
   }
}