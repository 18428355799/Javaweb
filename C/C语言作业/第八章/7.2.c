/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	//����
	int a[10];	
	int i,j,t,k;
	printf("����ǰ������\n");
	printf("������10������");
	for(i=0;i<10;i++)
	{
		scanf("%d",&a[i]);
		if(i%5==0)
			printf("\n");-
		printf("%d\t",a[i]);	
		
	}
	//��ʼ����
	for(i=0;i<10;i++)
	{
		printf("\n");
		printf("i=%d,��%d�֣�\n",i,i+1);
		for(j=i+1;j<=9;j++)//�ص�Ϊi+1��һ������ǰһ�������н���
		{
			if(a[i]>a[j])
				{	
					t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
			for(k=0;k<10;k++)
			printf("%d\t",a[k]);
			printf("\n");
		}	
		
	}
	//���������
	printf("\n");
	printf("���������\n");
	for(i=0;i<10;i++)
	{	
		if(i%5==0)
			printf("\n");
		printf("%d\t",a[i]);
		
		
	}
	
	
    
}