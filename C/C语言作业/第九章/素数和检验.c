/* Note:Your choice is C IDE */
#include "stdio.h"
void sushu();
void jianyan();
void main()
{
	printf("�������£�\n");
	sushu();
	printf("\n"); 
	jianyan();   
}
//���庯��
void sushu()
{
	int i,j,n=0,num;
	for(i=2;i<100;i++)
	{
		n=0;
		for(j=2;j<i;j++)
		{
			if(i%j==0)
			{
				n=1;
				break;	
				
			}	
			
		}
		if(n==0)
		{
			printf("%d\t",i);	
			
		}
		
		
	}

}
void jianyan()
{
	int i,j,n=0,num;
	printf("\n");
	printf("���Ͻ�������⣿����Լ��Ӵ��\n");
	printf("������һ����");
	scanf("%d",&num);
	for(i=2;i<num;i++)
	{
		if(num%i==0)
		{
			n=1;
			break;	
		}
	}
	if(n==0)
	{
		printf("����������");	
	}
	if(n==1)
	{
		printf("������������");	
	}
		
	
}