/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  /* 
	  ѭ������5��ѧ���ĳɼ������������߷֡���ͷ֡�ƽ����
	*/
	int a,i;
	float max,min,sum=0;
	max=0;
	min=100;
	for(i=1;i<=5;i++){
		printf("�������%d��ѧ���ķ���",i);
		scanf("%d",&a);		
		if(max<a){
			max=a;
			
		}
		if(min>a){
			min=a;			
		}
		sum+=a;		
	}
	printf("���ֵΪ��%f,��СֵΪ��%f,ƽ����Ϊ��%f",max,min,sum/5);
}