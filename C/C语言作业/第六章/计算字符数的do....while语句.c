/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int i=0;
  char ch;
  printf("������һ���ַ�");
  do{
  	scanf("%c",&ch); 	 
  	if(ch=='\n')
  	break;
  	i++;  	
  }while(1);
  printf("һ��%d���ַ�",i); 
}