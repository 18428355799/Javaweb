/* Note:Your choice is C IDE */
#include "stdio.h"
#include "string.h"
void main()
{
    char c1[20]={'H','e','l','l','o',','};
    char c2[]="World!";
    
    //���Ӻ���strcat(����1������2�����Ѳ���2���������ӵ�����1��ԭ���ݵĺ���
    //ע���������1��һ���ַ����飬��ô����ʱҪȷ������1�ĳ��ȱ������2���ַ����ַ������ĳ���
    strcat(c1,c2);
    puts(c1);
}