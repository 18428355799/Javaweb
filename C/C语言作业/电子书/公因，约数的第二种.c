/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int m,n;//m,nΪ�������ֵ
   int a,b,i;//aΪ���Լ����bΪ��С��������iΪ����
   printf("������������ֵ");
   scanf("%d,%d",&m,&n);
   if(m<n){
   		a=m;
   		m=n;
   		n=a;   	 	
   	}for(i=1;i<=n;i++){
   	if(m%i==0&&n%i==0)
   		a=i;
   	}
   printf("��С�������ǣ�%d\n",a);
   b=(m*n)/a;
   printf("��С�������ǣ�%d",b); 
}