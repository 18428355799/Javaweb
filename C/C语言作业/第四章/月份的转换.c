/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int month,day;
	printf("������һ���·ݣ�");
	scanf("%d",&month);
	switch(month)
	{
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:day=31;	break;
	case 4:
	case 6:
	case 9:
	case 11:day=30;	break;
	case 2:day=29;	break;
	default:day=-1;
	}
	if(day==-1) 
	 {  printf("��������·ݱ�����1~12֮������֣�\n");
	 }
	else  {  printf("2008��%d����%d�졣\n",month,day);}

}