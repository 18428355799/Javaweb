/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int z,x,c,v,b,n,m,f;
   printf("�������������ö��Ÿ�����");
   scanf("%d,%d,%d,%d,%d,%d,%d,%d",&z,&x,&c,&v,&b,&n,&m);
   printf("����ǰ��z=%d\n,x=%d\n,c=%d\n,v=%d\n,b=%d\n,n=%d\n,m=%d\n",z,x,c,v,b,n,m); 
   f=z;
   z=x;
   x=c;
   c=v;   
   v=b;
   b=n;
   n=m;   
   m=f;
   
   printf("������z=%d\n,x=%d\n,c=%d\n,v=%d\n,b=%d\n,n=%d\n,m=%d\n",z,x,c,v,b,n,m);     
}