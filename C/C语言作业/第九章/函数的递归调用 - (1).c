/* Note:Your choice is C IDE */
#include "stdio.h"
/*
   	�����ĵݹ����
   		1.�����Լ������Լ�
   		2.����һ����һ�����ڣ�
	
	�ݹ������һ�ֶ�ջԭ������ȳ�
*/
int jiechen(int n);
//����n�Ľ׳ˣ��ݹ麯������
int jiechen(int n)
{
	if(n==0||n==1)
		return 1;
	return jiechen(n-1)*n;
}
void main()
{
	int s;
	int n;
	printf("������һ����������");
	scanf("%d",&n);
	s=jiechen(n);
	printf("%d�Ľ׳�=%d",n,s);
}