/* Note:Your choice is C IDE */
#include "stdio.h"
int jia(int a,int b);//��
int jian(int a,int b);//��
int cheng(int a,int b);//��
int chu(int a,int b);//��

void main()
{
    int a,b,c,c1,c2,c3;//c...c3�ֱ����ӡ������ˡ�����
    printf("�������һ��������");
    scanf("%d",&a);
    printf("������ڶ���������");
    scanf("%d",&b);
    c=jia(a,b);
    c1=jian(a,b);
    c2=cheng(a,b);
    c3=chu(a,b);
    printf("�����������Ӽ��˳���Ľ���ֱ�Ϊ%d\t%d\t%d\t%d%",c,c1,c2,c3);
}
int jia(int a,int b)
{	//int a,b;
	return a+b;
}
int jian(int a,int b)
{
	return a-b;
}
int cheng(int a,int b)
{
	return a*b;
}
int chu(int a,int b)
{
	return a/b;
}