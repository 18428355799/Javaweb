/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int a[12],i,p,t,n=0;
	float sum=0,max=0,min=0;
do{
	printf("*************************��***************************\n");
	printf("*                                                    *\n"); 
	printf("*         XXX��˾2008���������ͳ��ϵͳ              *\n"); 
	printf("*                                                    *\n");
	printf("*************************��***************************\n"); 
	for(i=0;i<12;i++)
	{
		printf("\t\t�������%d���µ�������",i+1);
		scanf("%d",&a[i]);	
	}
	max=min=a[0];
	sum=0;
	for(i=0;i<12;i++)
	{
		if(max<a[i])
		{
			max=a[i];
			p=i;	
		}
		if(min>a[i])
		{
			min=a[i];
			t=i;
		}
		sum+=a[i];
		if(i%6==0)
			printf("\n");
		printf("%d\t",a[i]);
	
	}
	printf("\n��%d���µ������������Ϊ%0.2f\n",p+1,max);
	printf("��%d���µ������������Ϊ%0.2f\n",t+1,min);
	printf("��˾ƽ������Ϊ%0.2f\n",sum/12);
	printf("������%0.2f",sum);
	getch();
	system("cls");  
}while(1);   
	
	
}