/* Note:Your choice is C IDE */
#include "stdio.h"
//�������к���
double jia(double a,double b);
double jian(double a,double b);
double chen(double a,double b);
int chu(int a,int b);
void main()
{	
	double a,b,p=0;
	printf("��������������"); 
	scanf("%lf,%lf",&a,&b);
	printf("�������ĺ͵�ֵ���£�\n"); 
	p=jia(a,b);
	printf("%0.2lf+%0.2lf=%0.2lf",a,b,p);
	printf("\n");
	
	printf("�������Ĳ��ֵ���£�\n"); 
	p=jian(a,b);
	printf("%0.2lf-%0.2lf=%0.2lf",a,b,p);
	printf("\n");
	
	printf("�������ĳ˵�ֵ���£�\n"); 
	p=chen(a,b);
	printf("%0.2lf*%0.2lf=%0.2lf",a,b,p);
	printf("\n");
	
	printf("�������ĳ���ֵ���£�\n");
	p=chu(a,b); 
	printf("%0.2lf/%0.2lf=%0.2lf",a,b,p);
	printf("\n");
}
double jia(double a,double b)
{
	 	
	return a+b;	
	
}
double jian(double a,double b)
{

	return a-b;
		
}
double chen(double a,double b)
{
	
	return a*b;	
	
}
int chu(int a,int b)
{
	
	return a/b;	
	
}