/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{     int a,i;
	do{
  printf("**********************��*************************\n"); 
  printf("*                                               *\n"); 
  printf("*                                               *\n");
  printf("*  ����������ӭ�����й�����                   *\n");
  printf("*                                               *\n"); 
  printf("*                                               *\n");
  printf("**********************��*************************\n");
  
  
    
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
  
  
     
}