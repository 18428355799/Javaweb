/* Note:Your choice is C IDE */
#include "stdio.h"
//��������
#define N 10
char zifu();
void main()
{
//дһ����������ַ��ĵ�����  
	zifu();  
}
//���庯��
char zifu()
{
	char c[N],t;
	int i;
	printf("������һ���ַ�");
	for(i=0;i<N;i++)
	{
		scanf("%c",&c[i]);
		printf("%c\t",c[i]);;
	}
	for(i=0;i<N/2;i++)
	{
		t=c[i];
		c[i]=c[(N-1)-i];
		c[(N-1)-i]=t;	
	}
	printf("\n");
	printf("��������ַ����£�\n"); 
	for(i=0;i<N;i++)
	{
		
		printf("%c\t",c[i]);;
	}
}