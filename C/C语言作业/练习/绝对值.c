/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a,b;
  printf("������һ����");
  scanf("%d,%d",&a,&b);
  if(a>=0){ 	
  			b=a;
  }else{
  			b=0-a;
  } 
  printf("a=%d,�����ľ���ֵb=%d",a,b);  
}