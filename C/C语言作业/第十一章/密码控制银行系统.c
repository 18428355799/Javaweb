/* Note:Your choice is C IDE */
#include "stdio.h"
#include "string.h"
#define N 50
//�ṹ��
//���д��룬���������룬���
struct bank
{
	int num;
	char name[20];
	char password[20];
	double money;  	
}people[N];
int i=0;
//��������
//���뺯��
void denglujiemian();
//����
void kaihu();
//����
int dengru();//�з��ؽ��
//���
void cunkuan();
//ȡ��
void qukuan();
//��ѯ
void chaxun();
//ת��
void zhuanzhang();
//�˳�
void tuichu();
//������
void main()
{
	int num;
	denglujiemian();
	do{
		printf("\t\t*******************************************************\n");
		printf("\t\t*                                                     *\n");
		printf("\t\t*                 ��ӭ�����й�����ϵͳ                *\n");
		printf("\t\t*                                                     *\n");
		printf("\t\t*******************************************************\n");
		printf("\t\t\t��ѡ����Ҫ�����ҵ��\n");
		printf("\t\t\t\t1.������\n");
		printf("\t\t\t\t2.��\n");
		printf("\t\t\t\t3.ȡ�\n");
		printf("\t\t\t\t4.��ѯ��\n");
		printf("\t\t\t\t5.ת�ˣ�\n");
		printf("\t\t\t\t6.�˳���\n");
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
				chaxun();
				break;
			case 5://ת��
				zhuanzhang();	
				break;
			case 6:
				break;
		}
		printf("�����������......\n");
		getch();
		system("cls");
	}while(num!=6);

}
//����
//�������
void denglujiemian()
{
	char user[20]={"chenfeilong"};//�����û��ַ���
	char password[20]={"cfl1997"}; //���������ַ��� 
	char ustr[20],pwstr[20]; 
	int i=0;
	while(i<3) 
	{
		printf("\t\t\t�������й�����Ա���û�����\n");
		gets(ustr);
		printf("\t\t\t�������й�����Ա���û��������룺\n");
		gets(pwstr);
		if(strcmp(user,ustr))
		{
			printf("\t\t\t������������û���������\n");	
		}else{
		
			if(strcmp(password,pwstr))
			{
				printf("\t\t\t�����ַ���������,���������룡\n");	
				
			}else{
				printf("\t\t\t��ӭ��������ϵͳ��\n");
				break;
			
			}
		
		}
		i++;
		
	}
	if(i==3)
	{
		printf("��������������Σ��˺Ŵ��ڷ��գ��������ж��ᣬ��Ѱ���ܲý��и�������\n");	
	}
	return 0;
		
}


//����
void kaihu()
{
		printf("����ҵ��ʼ��\n");
		printf("������������л���:");
		scanf("%s",&people[i].name);
		printf("������������п���:");
		scanf("%d",&people[i].num);
		printf("�����������л���������:");
		scanf("%s",&people[i].password);
		printf("����������Ҫ�����д���Ľ��");
		scanf("%lf",&people[i].money);
		printf("������п�����:%d\n��������˻�����:%s\n������н����:%lf\n\n",people[i].num,people[i].name,people[i].money);
		i++;
		printf("������ɣ������Ʊ�����Ϣ����Ŷ��\n");
}
//����
int dengru()//���ؽ��
{
	int n;//���һ������õĲ���
	int f_num;//������Ҫ��������ƣ���Ҫ��ԭ���Ľ��бȽϣ����¶���	
	char f_password[20];//������Ҫ��������룬��Ҫ��ԭ���Ľ��бȽϣ����¶���	
	int fanhuizhi=-1;//���صĲ���
	printf("�����뿨�ź�����");
	scanf("%d,%s",&f_num,&f_password);
	for(n=0;n<i;n++)
	{
		if(f_num==people[n].num && strcmp(people[n].password,f_password)==0)
		{
			fanhuizhi=n;
			break;	
		}
		
	}
	return fanhuizhi;

}
//���
void cunkuan()
{
	double amoney;
	int hedui;

	hedui=dengru();
	if(hedui>=0)
	{
		printf("��������Ҫ���Ľ��");
		scanf("%lf",&amoney);
		people[hedui].money+=amoney;
		printf("������%lfԪ,����%lfԪ",amoney,people[hedui].money);
	}
	else
	{
		printf("������Ŀ��Ż�����������˶Ժ�������");
	}	
}
//ȡ��
void qukuan()
{
	double amoney;
	int hedui;

	hedui=dengru();
	if(hedui>=0)
	{
		printf("��������Ҫȡ��Ľ��");
		scanf("%lf",&amoney);
		if(people[hedui].money-amoney>=0)
		{
			people[hedui].money-=amoney;
			printf("������%lfԪ,����%lfԪ",amoney,people[hedui].money);
		}else{
			printf("�������㣡");
		}
	}
	else
	{
		printf("������Ŀ��Ż�����������˶Ժ�������");
	}			
}
//��ѯ
void chaxun()
{
	int hedui;
	hedui=dengru();
	if(hedui>=0)
	{
		printf("�����Ϲ���%lfԪ",people[hedui].money);	
	}
	else
	{
		printf("������Ŀ��Ż�����������˶Ժ�������");
	}
			
}

//ת��
void zhuanzhang()
{
	double amoney;
	int hedui;
	int duifangzhanghao;
	int t,p=-1;
	hedui=dengru();
	if(hedui>=0)
	{
		printf("������Է����ţ�");
		scanf("%d",&duifangzhanghao);
		for(t=0;t<i;t++)
		{
			if(duifangzhanghao==people[t].num)
			{
				p=t; //��ʾ�Է����˺���Ϣ��Ӧ���±�
				printf("������ת����");
				scanf("%lf",&amoney);
				if(people[hedui].money-amoney>=0)
				{
					people[hedui].money-=amoney;//�Լ��˻���Ǯ
					people[p].money+=amoney;//�Է��˻���Ǯ
					printf("��ϲ��ת�˳ɹ���ת��%0.2lfԪ��������ʣ��%0.2lfԪ",amoney,people[hedui].money);	
				}
				else
				{
					printf("ת��ʧ�ܣ��������㣡");
				}
				break;
							
			}
			
		}
		if(p==-1)
		{
			printf("ת��ʧ�ܣ��Է����Ų�����\n");
		}
		
	}else{
		printf("������Ŀ��Ż��������\n");
	}	
}
