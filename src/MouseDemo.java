import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MouseDemo
{
    //�����ͼ������������������
    private Frame f;
    private Button bt; 
    
    //����
   MouseDemo()//���췽��
    {
        madeFrame();
    }
    
    public void madeFrame()
    {
        f = new Frame("My Frame");
        
        //��Frame���л������á�
        f.setBounds(300,100,600,500);//�Կ�ܵ�λ�úʹ�С��������
        f.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));//��Ʋ���
        
        bt = new Button("My Button");
        
        //�������ӵ�Frame��
        f.add(bt);
        
        //����һ�´����ϵ��¼�
        myEvent();
        
        //��ʾ����
        f.setVisible(true);
    }
    
    private void myEvent()
    {
        f.addWindowListener(new WindowAdapter()//���ڼ���
        {
            public void windowClosing(WindowEvent e)
            {
                System.out.println("����ִ�йرգ�");
                System.exit(0);
            }
        });

        bt.addActionListener(new ActionListener()//��ť����
        {
            public void actionPerformed(ActionEvent e)
            {
                 System.out.println("��ť��ˣ�");
            }
        });
        bt.addMouseListener(new MouseAdapter()//������
        {
            private int count = 1; 
            private int mouseCount = 1;
            public void mouseEntered(MouseEvent e)
            {
                System.out.println("������"+count++);
            }
            public void mouseClicked(MouseEvent e)
            {
                if(e.getClickCount()==2)
                   System.out.println("��걻˫����");
                else System.out.println("��걻���"+mouseCount++);
            }
        });
    }
    
    public static void main(String[] agrs)
    {
        new MouseDemo();
    }
}