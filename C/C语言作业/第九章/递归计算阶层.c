/* Note:Your choice is C IDE */
#include "stdio.h"
int jiechen(int n);//��������
void main()
{
	int n,s;
	printf("������һ������");
	scanf("%d",&n);
	s=jiechen(n);
	printf("%d�Ľײ�=%d",n,s);	    
}
int jiechen(int n)//���庯��
{
	if(n==0||n==1)
		return 1;
	return jiechen(n-1)*n;//jiechen�����Լ������Լ� 		
	
}