#include "stdio.h"

void main()
{
	int a,b;
	char ch;
	do
	{
		printf("��������Ҫ�������������");
		scanf("%d,%d",&a,&b);

		printf("%d+%d=%d\n",a,b,a+b);

		printf("��Ҫ�����𣿣�����n���˳���������������\n");

		fflush(stdin);//������̻��棨������ӻ����ʲô�������

		scanf("%c",&ch); //�����û���ѡ��
	}while(ch!='n'); //��"n"�˳�
}
