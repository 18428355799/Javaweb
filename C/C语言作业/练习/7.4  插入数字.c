/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	//��������
	int a[10]={4,5,7,8,9,54,65,66,99};
	int i,num,c=9;
	printf("����ǰ�����ݣ�\n");
	for(i=0;i<9;i++)
	
		printf("%d\t",a[i]);
	printf("\n");
	printf("������һ����");	
	scanf("%d",&num);
		
	
	for(i=0;i<9;i++){
		if(num<=a[i])
		{
			c=i;
			break;		
		}
	}
	for(i=9;i>=c;i--)
	{
		a[i]=a[i-1];		
		
	}
	a[c]=num;
	printf("���������ݣ�\n");
	for(i=0;i<10;i++)
	
		printf("%d\t",a[i]);
	printf("\n");	
		
	
}