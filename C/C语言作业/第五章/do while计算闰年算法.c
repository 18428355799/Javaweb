/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a;
   a=1900;
   printf("1900~2016�е������У�\n");
   do{
   		if(a%4==0&&a%100!=0||a%400==0){
   			printf("%d\t",a);	
   			
   		}
   	
   		a++;
   	
   	}while(a<=2016); 
}