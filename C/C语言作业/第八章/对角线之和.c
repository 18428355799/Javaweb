/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	//�Խ��ߵĺ�
	int  a[3][3]={
			{1,2,3},
			{4,7,9},
			{8,0,9}
		};
	int i,j,sum=0;
	//���������涨�õ�����
	printf("�������£�\n");
	for(i=0;i<3;i++)
	{	
		printf("\n");
		for(j=0;j<3;j++)
		{
			printf("%d\t",a[i][j]);	
		}
	} 
	//��Խ���������֮��
	/*
		 (i,j)
		1(0,0)  	2(0,1)  	3(0,2)
		
		4(1,0)  	7(1,1)  	9(1,2)
		
		8(2,0)  	0(2,1)  	9(2,2)
	*/
	for(i=0;i<3;i++)//������
	{
		for(j=0;j<3;j++)//������
		{
			if(i==j||i+j==2)
				sum+=a[i][j];	
			
		}		
		
	}
	printf("\n");
	printf("�����еĶԽ��ߺ�Ϊ%d",sum);
	
}