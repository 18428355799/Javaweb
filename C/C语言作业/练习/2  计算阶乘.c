/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   //n�Ľ׳�,�磺10!=10*9*8*....*2*1 
   int sum=1,i,n,j=1;
   printf("��������Ҫ����Ľײ���ֵ");
   scanf("%d",&n);
   for(i=1;i<=n;i++){
   		sum*=i;
   		
   	
   }
   printf("%d",sum);
}