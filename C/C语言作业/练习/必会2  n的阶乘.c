/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  //2��n�Ľ׳�,�磺10!=10*9*8*....*2*1 
  int n,i;
  double sum=1;
  printf("������һ������");
  scanf("%d",&n);
  for(i=1;i<=n;i++){
  	sum*=i;
  	if(i!=n){
 	 printf("%d*",i);	 
  }
  if(i==n){
 	 printf("%d",i);	 
  }  	
  }
  
  printf("=%0.2lf",sum);
}