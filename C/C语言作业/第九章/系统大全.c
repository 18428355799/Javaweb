/* Note:Your choice is C IDE */
#include "stdio.h"
//��������
void niandushouru();
void gerenshui();
void kalaok();
void yinhangyewu();
void main()
{
	int i;
	
	do
	{
	printf("\t\t**********************��*************************\n");
	printf("\t\t*                                               *\n");
	printf("\t\t*              ��   ϵͳ�����ȫ                *\n");
	printf("\t\t*                                               *\n");
	printf("\t\t**********************��*************************\n");
	printf("\n\n");
	printf("\t\t\t��ѡ����������ϵͳ:\n");
	printf("\t\t\t\t1.�������ͳ��ϵͳ\n");
	printf("\t\t\t\t2.��������˰����ϵͳ\n");
	printf("\t\t\t\t3.����OK��������ϵͳ\n");
	printf("\t\t\t\t4.����ҵ��ϵͳ\n");
	printf("\t\t\t\t5.�˳�ϵͳ\n");
	printf("\t\t\t\t��ѡ��:");

	
	scanf("%d",&i);
	if(i==5)
		break;

	switch(i)
	{
	case 1:
		getch();
		system("cls");  //����
		niandushouru();
		printf("\n");
		printf("\t\t\t���س����������˵�:\n");
		fflush(stdin);//������̻���
		break;
	case 2:
		getch();
		system("cls");
		gerenshui();
		printf("\n");
		printf("\t\t\t���س����������˵�:\n");
		fflush(stdin);
		break;
	case 3:
		getch();
		system("cls");
		kalaok();
		printf("\n");
		printf("\t\t\t���س����������˵�:\n");
		fflush(stdin);
		break;
	case 4:
		getch();
		system("cls");
		yinhangyewu();
		printf("\n");
		printf("\t\t\t���س����������˵�:\n");
		fflush(stdin);
		break;
	default:
		printf("\t\t\t�����������1~5��ѡ��\n");
		break;
	}
	}while(1);    
}
//���庯��
//�������
void niandushouru()
{
	int a[12],i,p,t,n=0;
	float sum=0,max=0,min=0;
do{
	printf("\t\t*************************��***************************\n");
	printf("\t\t*                                                    *\n"); 
	printf("\t\t*         XXX��˾2008���������ͳ��ϵͳ              *\n"); 
	printf("\t\t*                                                    *\n");
	printf("\t\t*************************��***************************\n"); 
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
	printf("\t\t\n��%d���µ������������Ϊ%0.2f\n",p+1,max);
	printf("\t\t��%d���µ������������Ϊ%0.2f\n",t+1,min);
	printf("\t\t��˾ƽ������Ϊ%0.2f\n",sum/12);
	printf("\t\t������%0.2f",sum);
	getch();
	system("cls");  
}while(1);   
		
}
//����˰
void gerenshui()
{
	float X,Y,Z,S;
  printf("\t\t**********************��*************************\n"); 
  printf("\t\t*                                               *\n"); 
  printf("\t\t*                                               *\n");
  printf("\t\t*  �����������й�2016����˰ϵͳ                 *\n");
  printf("\t\t*                                               *\n"); 
  printf("\t\t*                                               *\n");
  printf("\t\t**********************��*************************\n");
 
   printf("\t\t\t�����������н����ԪΪ��λ��");
   scanf("%f",&X);
   fflush(stdin);
   printf("\t\t\t�����뵱�������㣨��ԪΪ��λ��");
   scanf("%f",&S);
   printf("\t\t\t�����н%f\n",X);
   Y=X-S;
  	if(Y<=0){
  		printf("\t\t\t��Ĺ���̫�ͣ��ú�׬Ǯ����ȡ��˰\n");
  	}else if(Y>0&&Y<=1500){
		Z=1500*0.03;
	}else if(Y>1500&&Y<=4000){
		Z=1500*0.03+(Y-1500)*0.1;
	}else if(Y>4000&&Y<=8000){
		Z=1500*0.03+4000*0.1+(Y-4000)*0.2;
	}else if(Y>8000&&Y<=20000){
		Z=1500*0.03+3000*0.1+8000*0.2+(Y-8000)*0.25;
	}else if(Y>20000&&Y<=30000){
		Z=1500*0.03+3000*0.1+8000*0.2+20000*0.25+(Y-20000)*0.3;
	}else if(Y>30000&&Y<=80000){
		Z=1500*0.03+3000*0.1+8000*0.25+20000*0.25+30000*0.3+(Y-30000)*0.4;
	}else {
		Z=1500*0.03+3000*0.1+8000*0.25+20000*0.25+30000*0.3+80000*0.4+(Y-80000)*0.5;
	}

	printf("\t\t\t��ĸ�������˰�ǣ�%f\n",Z);	 
	printf("\t\t\t���˰��������ǣ�%f��˰����",X-Z);
	getch();
	system("cls");	  	
	
}
//����ok
void kalaok()
{
	 float a[10],max=0,min=10,sum=0;
    int i;
    printf("\t\t                  ����OK��������ϵͳ              \n");
    printf("\t\t**************************************************\n");
    printf("\t\t*                                                *\n");
    printf("\t\t        ��һ���л���У԰���ֿ���OK������ʼ��      \n");
    printf("\t\t*                                                *\n");
    printf("\t\t**************************************************\n");
    for(i=0;i<10;i++)
    {
    	printf("\t\t\t�������%dλ��ί�ķ���:",i+1);
    	scanf("%f",&a[i]);	
    }
    max=min=a[0];
    for(i=0;i<10;i++)
    {
    	if(max<a[i])
    		max=a[i];
    	if(min>a[i])
    		min=a[i];
		sum += a[i];
    	if(i%5==0)
    		printf("\n");    		
    	printf("%0.2f\t",a[i]);
    }
    
    printf("\t\t\t\nȥ��һ����߷֣�%0.2f\n",max);
    printf("\t\t\tȥ��һ����ͷ�:%0.2f\n",min);
    printf("\t\t\tѡ�ֵ����÷���:%0.2f",(sum-max-min)/8);	
	getch();
	system("cls");
}
//����ҵ��
void yinhangyewu()
{
	int a,i;
	do{
  printf("\t\t**********************��*************************\n"); 
  printf("\t\t*                                               *\n"); 
  printf("\t\t*                                               *\n");
  printf("\t\t*  ����������ӭ�����й�����                   *\n");
  printf("\t\t*                                               *\n"); 
  printf("\t\t*                                               *\n");
  printf("\t\t**********************��*************************\n");
  
  
    
  printf("           ��ѡ����Ҫ�����������\n"); 
  printf("                   1.����\n");  
  printf("                   2.���\n");  
  printf("                   3.ȡ��\n");
  printf("                   4.��ѯ���\n"); 
  printf("                   5.ת��\n");  
  printf("                   6.�˳�\n");  
  printf("\t��������Ҫ�����ҵ��");
  scanf("%d",&a);
 
  switch(a){	
  				case 1:
  					printf("��ѡ���˿���ҵ��");
  					break;
				case 2:
  					printf("��ѡ���˴��ҵ��");
  					break;
				case 3:
  					printf("��ѡ����ȡ��ҵ��");
  					break;
				case 4:
  					printf("��ѡ���˲�ѯ���ҵ��");
  					break;
				case 5:
  					printf("��ѡ����ת��ҵ��");
  					break;
				case 6:
  					printf("��ѡ�����˳�ҵ��");
  					break;
				default :
  					printf("�����������������1-6֮�������");
  					
  			}
	} while(i!=6);
	getch();
	system("cls");
  	
}