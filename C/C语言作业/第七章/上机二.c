/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //��д�������û�����20��������ͳ����20�������ж��ٸ����������ٸ�ż���������
    int a[20];
    int i,n=0,c=0;
    printf("������20������\n");
    for(i=0;i<20;i++)
    {	
    	scanf("%d",&a[i]);
    	 	     	
    }	
	for(i=0;i<20;i++)
	{	
		
		if(i%5==0)
	    {
	    	printf("\n");
	    }
	    printf("%d ",a[i]);
	    if(a[i]%2==0)
	    {
	    	n++;	
	    }else
	    {
	    	c++;
	    }
	   
	} 
	 printf("\n������ż��һ����%d��,������%d��\n",n,c); 
}