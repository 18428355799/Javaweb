/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int a[10];
	int n=0,i,num;
	printf("ԭʼ�������£�\n");
	printf("������10������");
	for(i=0;i<10;i++)
	{
		scanf("%d",&a[i]);
		if(i%5==0)
			printf("\n");
		printf("%d\t ",a[i]);
	}
	printf("\n");
	printf("������Ҫ���ҵ�����");
	scanf("%d",&num);
	for(i=0;i<10;i++)
	{
		if(num==a[i])
		{
			printf("�������еĵ�%d��λ���ҵ���%d",i+1,num);	
			n++;
		}	
		
	}
	if(i==10)
		printf("������û�и�����");
	printf("\n");
	printf("������%d��%d��",num,n);
	    
}