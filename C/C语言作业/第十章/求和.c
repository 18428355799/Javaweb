/* Note:Your choice is C IDE */
#include "stdio.h"
int qiuhe(int n);//��������
void main()
{
	//�ݹ���ͷ���
	int n,s;
	printf("������һ������");
	scanf("%d",&n);
	s=qiuhe(n);
	printf("1��%d�ĺ�=%d",n,s);	    
}
int qiuhe(int n)//���庯��
{
	if(n==0||n==1)
		return 1;
	return qiuhe(n-1)+n;//jiechen�����Լ������Լ� 		
	
}