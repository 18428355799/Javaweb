/* Note:Your choice is C IDE */
#include "stdio.h"
//��������
void nianshouru();
void main()
{	

		nianshouru();
}
void nianshouru()
{
	float X,Y,Z,S;
do{	 
		 
		printf("**********************��*************************\n"); 
		printf("*                                               *\n"); 
		printf("*                                               *\n");
		printf("*  �����������й�2016����˰ϵͳ                 *\n");
		printf("*                                               *\n"); 
		printf("*                                               *\n");
		printf("**********************��*************************\n");
		printf("\t�����������н����ԪΪ��λ��");
		scanf("%f",&X);
		fflush(stdin);
		printf("\t�����뵱�������㣨��ԪΪ��λ��");
		scanf("%f",&S);
		printf("\t�����н%f\n",X);
		Y=X-S;
		if(Y<=0){
			printf("�㹤��Ҳ̫���˰ɣ���û�н�˰���ʸ񣬺ú�׬Ǯ\n");
		}else if(Y>0&&Y<=1500){
			Z=45;
		}else if(Y>1500&&Y<=4000){
			Z=45+(Y-1500)*0.1;
		}else if(Y>4000&&Y<=8000){
			Z=445+(Y-4000)*0.2;
		}else if(Y>8000&&Y<=20000){
			Z=1945+(Y-8000)*0.25;
		}else if(Y>20000&&Y<=30000){
			Z=6945+(Y-20000)*0.3;
		}else if(Y>30000&&Y<=80000){
			Z=15945+(Y-30000)*0.4;
		}else {
			Z=51945+(Y-80000)*0.5;
		}
		
		printf("\t��ĸ�������˰�ǣ�%0.2f\n",Z);	 
		printf("\t���˰��������ǣ�%0.2f��˰����\n",X-Z);
		printf("\n");
		printf("��Ҫ���������𣿼�������������˳���1\n");
		getch();
		system("cls");	
		  
}while(1);
		
	
	
}
