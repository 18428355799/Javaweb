/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int ge,shi,qian,wan;
   int X;
   printf("������һ����λ������ֵ");
   scanf("%d",&X);
   wan=X/10000%10;
   qian=X/1000%10;
   shi=X/10%10;
   ge=X/1%10;
   if(ge==wan&&shi==qian){printf("�����ǻ�����");}
    else{printf("�������ǻ�����");}
    if(ge==shi==qian==wan){printf("�����ǻ�����");}
    
    
}