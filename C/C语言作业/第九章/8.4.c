/* Note:Your choice is C IDE */
#include "stdio.h"
//��������
void jiaohuan();
void main()
{
//дһ��������3x3���������н���
	jiaohuan();//���ú���    
}
//���庯��
void jiaohuan()
{
	int a[3][3];
	int i,j;
	printf("ԭʼ�������£�\n");
	printf("�������������е�����");
	for(i=0;i<3;i++)
	{
		
		for(j=0;j<3;j++)
		{
			
			scanf("%d",&a[i][j]);
			printf("%d\t",a[i][j]);
		}
		
		printf("\n");
	}
	printf("����������ݣ�\n");
	for(i=0;i<3;i++)
	{
		
		for(j=0;j<3;j++)
		{
			
			printf("%d\t",a[j][i]);
		}
		
		printf("\n");
	}
}