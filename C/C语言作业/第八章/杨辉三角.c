/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	//�������
	int a[10]={1,1};
	int i,j;
	printf("1\n");//�̶�����Ϊ1
	printf("1\t1\n");
	for(i=2;i<10;i++)
	{
		for(j=i-1;j>0;j--)//�Ӻ���ǰ����
		{
			a[j]=a[j]+a[j-1];	
		}
		a[i]=1;//���һ��Ϊ1����ӡ����1
		for(j=0;j<=i;j++)
    	{
    		printf("%d\t",a[j]);
    	}
    	printf("\n");
	}
	    
}