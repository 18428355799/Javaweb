/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 9
//�žų˷���
void jiujiuchenfabiao();
//�žų�����
void jiujiuchufabiao();
//�žżӷ���
void jiujiujiafabiao();
//�žżӷ���
void jiujiujianfabiao();
void main()
{
	jiujiuchenfabiao();
	printf("\n\n");
	jiujiuchufabiao();
	printf("\n\n");
	jiujiujiafabiao();
	printf("\n\n");
	jiujiujianfabiao();	
}
//�žų˷���
void jiujiuchenfabiao()
{
	int i,j,sum=1;
	for(i=1;i<=N;i++)
	{	sum=1;
		for(j=1;j<=i;j++)
		{
			sum=i*j;
			printf("%d*%d=%d\t",j,i,i*j);	
		}
		printf("\n");
		
	}	
}
//�žų�����
void jiujiuchufabiao()
{
	int i,j,sum=1;
	for(i=1;i<=N;i++)
	{	sum=1;
		for(j=1;j<=i;j++)
		{
			sum=i/j;
			printf("%d/%d=%d\t",j,i,i/j);	
		}
		printf("\n");
		
	}	
}
//�žżӷ���
void jiujiujiafabiao()
{
	int i,j,sum=1;
	for(i=1;i<=N;i++)
	{	sum=1;
		for(j=1;j<=i;j++)
		{
			sum=i+j;
			printf("%d+%d=%d\t",j,i,i+j);	
		}
		printf("\n");
		
	}		
}
//�žż�����
void jiujiujianfabiao()
{
	int i,j,sum=1;
	for(i=1;i<=N;i++)
	{	sum=1;
		for(j=1;j<=i;j++)
		{
			sum=i-j;
			printf("%d-%d=%d\t",j,i,i-j);	
		}
		printf("\n");
		
	}		
}