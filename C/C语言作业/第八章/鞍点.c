/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int a[][4]={
		
			{1,2,3,4},
			{5,7,9,10},
			{7,9,12,15},
			{15,34,47,904}
	
		};
	int i,j,t=0,max,min,t2=0;
	printf("�����������£�\n");
	
	for(i=0;i<4;i++)
	{
		for(j=0;j<4;j++)
		
			printf("%d\t",a[i][j]);
			printf("\n");	
	
	} 
	for(i=0;i<4;i++)//���е����ֵ
	{
		t=0;
		max=a[i][0];
		
		for(j=0;j<4;j++)
		{
			if(max<a[i][j])
			{
				max=a[i][j];
				t=j;	
			}	
		}	
		t2=0;
		min=a[i][0];
		for(j=0;j<4;j++)//���е���Сֵ
		{
				
			if(min>a[i][j])
			{
				min=a[i][j];
				t2=j;	
				
			}	
			
		}
		if(i==t2)
		{
    		printf("��%d�еĵ�%d�е�%d�ǰ���",t2+1,t+1,a[t2][t]);	
    	}	
	
		
	}
}