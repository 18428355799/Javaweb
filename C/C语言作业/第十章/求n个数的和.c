/* Note:Your choice is C IDE */
#include "stdio.h"
double sum=0;//����ȫ�ֱ������������в����б��������򽫻Ḳ��
//��������
void qiuhe(int n);
void main()
{
	//��ĿҪ����һ���޷��أ��в����ĺ���,���������������ͬ��
	int n;
	printf("������һ������Ҫ��͵����ֵ");
	scanf("%d",&n);
	qiuhe(n);
	printf("1~%d�ĺ�=%lf",n,sum);

}
void qiuhe(int n)
{
	int i;
	for(i=1;i<=n;i++)
	{
		sum+=i;	
	}
}
