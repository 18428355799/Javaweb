/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int i=0;
  char ch;
  printf("������һ���ַ�");
  while(1){
  	scanf("%c",&ch); 	 
  	if(ch=='\n')
  	break;
  	i++;  	
  }
  printf("һ��%d���ַ�",i); 
}