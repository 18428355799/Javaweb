/* Note:Your choice is C IDE */
#include "stdio.h"
#include "string.h"
//����ȫ�ֱ���
char name[20]; //����
char password[20];//��¼����
int cardno; //����
double money; //�������
//�������к���
//����
void kaihu();
//���
void cunkuan();
//ȡ��
void qukuan();
void main()
{
	int num;
	do{
		printf("\t\t\t*******************************************************\n");
		printf("\t\t\t*                                                     *\n");
		printf("\t\t\t*                 ��ӭ�����й�����ϵͳ                *\n");
		printf("\t\t\t*                                                     *\n");
		printf("\t\t\t*******************************************************\n");
		printf("\t\t\t\t��ѡ����Ҫ�����ҵ��\n");
		printf("\t\t\t\t\t1.������\n");
		printf("\t\t\t\t\t2.��\n");
		printf("\t\t\t\t\t3.ȡ�\n");
		printf("\t\t\t\t\t4.��ѯ��\n");
		printf("\t\t\t\t\t5.ת�ˣ�\n");
		printf("\t\t\t\t\t6.�˳���\n");
		scanf("%d",&num);
		switch(num)
		{
			case 1://����
				kaihu();
				break;
			case 2://���
				cunkuan();
				break;
			case 3: //ȡ��
				qukuan();
				break;
			case 4://��ѯ
				break;
			case 5://ת��	
				break;
			case 6:
				break;
		}
		printf("�����������......\n");
		getch();//��ͣ
		system("cls");
	}while(num!=6);
    
}
//���庯��
//����
void kaihu()
{
	printf("����������������");
	scanf("%s",name);//�ַ����鸳ֵ
	printf("�����뿨�ţ�");
	scanf("%d",&cardno);
	printf("���������룺");
	scanf("%s",password);
	printf("�����뿪����");
	scanf("%lf",&money);
	printf("��ϲ�㿪���ɹ��������Ʊ������ĸ�����Ϣ����ϸ��Ϣ���£�\n");
	printf("���������ǣ�%s,���Ŀ����ǣ�%d,���������ǣ�%s,�������������:%0.2lf\n",name,cardno,password,money);	
}
//���
void cunkuan()
{
	int m_cardno;
	char m_password[20];
	double m_money;
	printf("�����뿨�ź�����");
	scanf("%d,%s",&m_cardno,m_password);
	if(m_cardno==cardno && !strcmp(m_password,password))
	{
		printf("��������Ҫ���Ľ�");
		scanf("%lf",&m_money);
		printf("���֮ǰ������������ǣ�%0.2lf\n",money);
		money += m_money;
		printf("���%0.2lfԪ��������������ǣ�%0.2lf\n",m_money,money);
		
	}else{
		printf("������Ŀ��Ż��������\n");
	}
}
void qukuan()
{
	int p_cardno;
	char p_password[20];
	double p_money;
	printf("�����뿨�ź�����");
	scanf("%d,%s",&p_cardno,p_password);
	if(p_cardno==cardno && !strcmp(p_password,password))
	{
		printf("��������Ҫȡ��Ľ�");
		scanf("%lf",&p_money);
		printf("���֮ǰ������������ǣ�%0.2lf\n",money);
		money -= p_money;
		printf("ȡ��%0.2lfԪ��������������ǣ�%0.2lf\n",p_money,money);
		printf("���պ���Ľ��\n");
		
	}else{
		printf("������Ŀ��Ż��������\n");
	}	
}