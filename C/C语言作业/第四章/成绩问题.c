/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int grade;
    printf("��������ķ���");
    scanf("%d",&grade);
    if(grade<60){printf("��ĳɼ���E���ɲ�Ҫ����Ϸ�ˣ�Ŭ��Ŷ��");}
    else if(grade>=60&&grade<70){printf("��ĳɼ���D��Ŭ��Ŷ��");}
    else if(grade>=70&&grade<80){printf("��ĳɼ���c��Ŭ������B��");}
    else if(grade>=80&&grade<90){printf("��ĳɼ���B��Ŭ������A��");}
    else {printf("����һ��A����������");}
	
  
}