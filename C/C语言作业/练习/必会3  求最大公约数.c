/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
 
	/* 
	  ����������a��b�������Լ��,(���Լ�����ܱ�a��b�������������) 
	*/
	int a,b,n,i,p=0,t;
	printf("��������������");
	scanf("%d,%d",&a,&b);
	if(a<b){
		t=b;
		b=a;
		a=t;	
		
	}
	for(i=1;i<a;i++){
		if(a%i==0 && b%i==0){
			p=i;
			
		}			
	}
	printf("%d",p);	
}