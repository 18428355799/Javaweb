/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{	/*
	���磺a+aa+aaa+aaaa......=p
	���Ϊt
	
	*/
	int a,n,i=1;
	int p=0;//pΪ�����tΪ������ʽ
	int t=0;
	printf("������������ֵ");
	scanf("%d,%d",&a,&n);
	while(i<=n){
			t=t+a;//�����ʽ����������ֵ֮�ͣ�a+aa+aaa......
			p=p+t;//�����ʽ���������������
			a=a*10;//�����ʽ�������и�ֵ���㣺
			i++;
	}
	printf("%d\n",p);
}