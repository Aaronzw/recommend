package LoginFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class getComponent {
	public static void setButtonGroup
	(
		ButtonGroup buttonSex, 
		JRadioButton buttonMale,
		JRadioButton buttonFamale
	){
		buttonMale.setSelected(true);
		buttonMale.setFont(new Font("", Font.BOLD, 15));
		buttonFamale.setFont(new Font("", Font.BOLD, 15));
		buttonSex.add(buttonMale);
		buttonSex.add(buttonFamale);
		buttonMale.setOpaque(false);
		buttonFamale.setOpaque(false);
	}
	public static void setComboBox
	(
		JComboBox<String> comboBoxCollege,
		JComboBox<String> comboBoxMajor,
		Vector<String> collegeContent, 
		Vector<Vector<String>> majorContent
	){
		collegeContent.clear();
		majorContent.clear();
//		comboBoxCollege.removeAllItems();
//		comboBoxMajor.removeAllItems();
		Vector<String> BufferContent1 = new Vector<String>();
		Vector<String> BufferContent2 = new Vector<String>();
		Vector<String> BufferContent3 = new Vector<String>();
		Vector<String> BufferContent4 = new Vector<String>();
		Vector<String> BufferContent5 = new Vector<String>();
		Vector<String> BufferContent6 = new Vector<String>();
		Vector<String> BufferContent7 = new Vector<String>();
		Vector<String> BufferContent8 = new Vector<String>();
		comboBoxCollege.setFont(new Font("宋体", Font.BOLD, 15));
		comboBoxMajor.setFont(new Font("宋体", Font.BOLD, 15));
		comboBoxMajor.setBackground(Color.WHITE);
		comboBoxCollege.setBackground(Color.WHITE);
		collegeContent.add("信息学院");
		collegeContent.add("文法学院");
		collegeContent.add("体育学院");
		collegeContent.add("艺术设计学院");
		collegeContent.add("外国语学院");
		collegeContent.add("交通学院");
		collegeContent.add("经济管理学院");
		collegeContent.add("矿业与安全工程学院");
		
		BufferContent1.add("软件工程");
		BufferContent1.add("网络工程");
		BufferContent1.add("物联网工程");
		BufferContent1.add("计算机科学");
		BufferContent1.add("信息管理");
		BufferContent1.add("数字媒体");
		majorContent.add(BufferContent1);
		for(int i = 0; i < BufferContent1.size(); i++)
		comboBoxMajor.addItem(BufferContent1.get(i));
		comboBoxMajor.setPreferredSize(new Dimension(135, 30));
		BufferContent2.add("法学系");
		BufferContent2.add("公共管理");
		BufferContent2.add("广告学");
		BufferContent2.add("中文系");
		majorContent.add(BufferContent2);
		BufferContent3.add("体育");
		majorContent.add(BufferContent3);
		BufferContent4.add("工业设计");
		BufferContent4.add("环境设计");
		BufferContent4.add("视觉传达");
		BufferContent4.add("音乐");
		majorContent.add(BufferContent4);
		BufferContent5.add("英语");
		BufferContent5.add("日语");
		BufferContent5.add("韩语");
		majorContent.add(BufferContent5);
		BufferContent6.add("车辆工程");
		BufferContent6.add("物流工程");
		BufferContent6.add("交通工程");
		BufferContent6.add("交通运输");
		majorContent.add(BufferContent6);
		BufferContent7.add("会计系");
		BufferContent7.add("管理科学");
		BufferContent7.add("财政金融系");
		BufferContent7.add("经贸");
		BufferContent7.add("工商管理");
		majorContent.add(BufferContent7);
		BufferContent8.add("采矿工程");
		BufferContent8.add("安全工程");
		BufferContent8.add("工程力学");
		BufferContent8.add("工业工程");
		BufferContent8.add("理论与应用力学");
		majorContent.add(BufferContent8);
		
		for(int i = 0; i < collegeContent.size(); i++)
			comboBoxCollege.addItem(collegeContent.get(i));
		comboBoxCollege.setPreferredSize(new Dimension(135, 30));
	}
	
}
