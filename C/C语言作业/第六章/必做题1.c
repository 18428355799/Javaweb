/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a;
  
  do{	
  			printf("������һ������");
  			scanf("%d",&a);
  		if(getchar()=='n')
  			break;
  		if(a%5==0&&a%7==0)
  			printf("������������\n");  			
  		
  		
  		else{
  			printf("������������\n");
  		}	 		
  }while(getchar()!='n');
   
}