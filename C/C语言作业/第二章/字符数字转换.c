/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a;
  char b;
  float c;
  double d;//������ת�����ַ�
  printf("������һ������");
  scanf("%d",&a);
  printf("a=%d,a=%c\n",a,a);
  
   
  fflush(stdin); //���ַ�ת�������� 
  printf("������һ���ַ�");
  scanf("%c",&b);
  printf("b=%d,b=%c\n",b,b); 
  a=b;
  printf("a=%d,a=%c",a,a);
}