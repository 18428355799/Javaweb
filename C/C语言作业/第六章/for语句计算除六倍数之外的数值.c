/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   /*
   		1����д�������1~100�з�6�ı��������֣�Ҫ����whileѭ��ʵ�֣�ÿ�����8����
		2����д����ͳ���û�������ַ��������س���������
		3����д�������һ�����Σ�Ҫ����Ƕ��forѭ��ʵ�֣�


   */
   int i,n;
   for(i=1;i<=100;i++){
   		if(i%6==0)
   			continue;
    printf("%d\t",i);
    	n++;
    	if(n%8==0)
    	printf("\n");	
   }
   	
}