/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a[10];
  int i;
  printf("������Ҫ���������\n");
  for(i=0;i<10;i++)
  {
		printf("�������%d����:",i+1);
		scanf("%d",&a[i]); 
				
  }
  printf("����������ǣ�\n");
  for(i=0;i<10;i++){
  	if(i%5==0)
		{
			printf("\n");
		}					
		printf("%d ",a[i]);
		
			
		} 	  	
  printf("\n��Щ������\n");
}