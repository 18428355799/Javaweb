/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{	int i=1,j=1;
  	
    do{//��ѭ��������
	   	j=1;//��ѭ��ÿѭ��һ�Σ���ѭ����j���������³�ʼ��
    	do{//��ѭ��������
    		printf("*\t");
    		j++;
    	}while(j<=i);
    	i++;
    	//����
    	printf("\n");
    	
    }while(i<=5);  
}