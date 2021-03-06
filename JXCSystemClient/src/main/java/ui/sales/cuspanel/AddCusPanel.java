package ui.sales.cuspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyStopButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldFilled;
import ui.setting.TextField.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class AddCusPanel extends FatherPanel {

	/*
	 * 添加客户的界面
	 */
	protected MyTextFieldTrans cusName, cusTel, cusAdd, cusEBox, cusCode, cusShouldPay;
	protected int infoX1 = 495, infoX2 = 534, infoY = 170, infoInter = 41, infoWidth1 = 237, infoWidth2 = 190,
			infoHeight = 31;
	protected int levelX = 105, levelY = 328, levelInter = 42;
	protected MyStopButton supplierButton, sellerButton;
	protected MyButton secondCusBack, forward;
	protected MyStopButton level1,level2,level3,level4,level5;
	protected MyTextFieldFilled salesManField;
	protected MyLabel idField,failLabel;
	private ButtonListener buttonListener;
	private MyFrame frame;
	private UIController controller;
	protected int level = 0;
	protected String id;
	protected boolean classification = true;
	protected boolean isLevel = false,isSupplier = false;
	SalesUIController salesUIController;
	SalesblService salesblService;
	
	
	public AddCusPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame,url,controller);
		buttonListener = new ButtonListener();
		salesblService = new SalesController();
		this.frame = frame;
		this.controller = controller;
		this.salesUIController = salesUIController;
		this.addIdButton();
		this.addLevelButton();
		this.addTextField();
		this.addRestButton();
		setID();
	}

	/*
	 * 设置客户id
	 */
	public void setID(){
		idField = new MyLabel(105, 173, 222, 36);
		this.add(idField);
		idField.setText(salesblService.getCustomerNote_up());
		failLabel = new MyLabel(418,550,204,35);
		this.add(failLabel);
	}
	/*
	 * 添加textfield
	 */
	public void addTextField() {
		cusName = new MyTextFieldTrans(infoX1, infoY, infoWidth1, infoHeight);
		cusTel = new MyTextFieldTrans(infoX1, infoY + infoInter, infoWidth1, infoHeight);
		cusAdd = new MyTextFieldTrans(infoX1, infoY + 2 * infoInter, infoWidth1, infoHeight);
		cusEBox = new MyTextFieldTrans(infoX1, infoY + 3 * infoInter, infoWidth1, infoHeight);
		cusCode = new MyTextFieldTrans(infoX1, infoY + 4 * infoInter, infoWidth1, infoHeight);
		cusShouldPay = new MyTextFieldTrans(infoX1, infoY + 5 * infoInter, infoWidth1, infoHeight);
		salesManField = new MyTextFieldFilled(418, 485, 204, 36);
		this.add(cusName);
		this.add(cusTel);
		this.add(cusAdd);
		this.add(cusEBox);
		this.add(cusCode);
		this.add(cusShouldPay);
		this.add(salesManField);
	}
/*
 * 添加供应商和销售商的button
 */
	public void addIdButton() {
		supplierButton = new MyStopButton("Image/Sales/对话框/images/供货商_ori.png", 105, 255,
				"Image/Sales/对话框/images/供货商_ori.png");
		sellerButton = new MyStopButton("Image/Sales/对话框/images/销售商_ori.png", 220, 255,
				"Image/Sales/对话框/images/销售商_ori.png");
		this.add(supplierButton);
		this.add(sellerButton);
		supplierButton.addMouseListener(buttonListener);
		sellerButton.addMouseListener(buttonListener);
	}

	public void addLevelButton() {
		level1 = new MyStopButton("Image/Sales/对话框/images/level1_ori.png",levelX,levelY,"Image/Sales/对话框/images/level1_ori.png");
		level2 = new MyStopButton("Image/Sales/对话框/images/level2_ori.png",levelX,levelY+levelInter,"Image/Sales/对话框/images/level2_ori.png");
		level3 = new MyStopButton("Image/Sales/对话框/images/level3_ori.png",levelX,levelY+2*levelInter,"Image/Sales/对话框/images/level3_ori.png");
		level4 = new MyStopButton("Image/Sales/对话框/images/level4_ori.png",levelX,levelY+3*levelInter,"Image/Sales/对话框/images/level4_ori.png");
		level5 = new MyStopButton("Image/Sales/对话框/images/level5_ori.png",levelX,levelY+4*levelInter,"Image/Sales/对话框/images/level5_ori.png");
		this.add(level1);
		this.add(level2);
		this.add(level3);
		this.add(level4);
		this.add(level5);
		level1.addMouseListener(buttonListener);
		level2.addMouseListener(buttonListener);
		level3.addMouseListener(buttonListener);
		level4.addMouseListener(buttonListener);
		level5.addMouseListener(buttonListener);
		
	}

	public void addRestButton() {
		secondCusBack = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 680, 458, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(secondCusBack);
		this.add(forward);
		secondCusBack.addMouseListener(buttonListener);
		forward.addMouseListener(buttonListener);
	}

	class ButtonListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == secondCusBack) {
				salesUIController.backPanel(AddCusPanel.this);
			}else if(e.getSource() == supplierButton){
				isSupplier = true;
				//false代表进货商，true代表销售商
				supplierButton.setIcon(new ImageIcon("Image/Sales/对话框/images/供应商_press_on_03.png"));
				sellerButton.setIcon(new ImageIcon("Image/Sales/对话框/images/销售商_ori.png"));
				classification = false;
			}else if(e.getSource() == sellerButton){
				isSupplier = true;
				sellerButton.setIcon(new ImageIcon("Image/Sales/对话框/images/销售商_press_on_05.png"));
				supplierButton.setIcon(new ImageIcon("Image/Sales/对话框/images/供货商_ori.png"));
				classification = true;
			}else if(e.getSource() == level1){
				isLevel = true;
				level1.setIcon(new ImageIcon("Image/Sales/对话框/images/level1_press_on.png"));
				level2.setIcon(new ImageIcon("Image/Sales/对话框/images/level2_ori.png"));
				level3.setIcon(new ImageIcon("Image/Sales/对话框/images/level3_ori.png"));
				level4.setIcon(new ImageIcon("Image/Sales/对话框/images/level4_ori.png"));
				level5.setIcon(new ImageIcon("Image/Sales/对话框/images/level5_ori.png"));
				level = 1;
			}else if(e.getSource() == level2){
				isLevel = true;
				level2.setIcon(new ImageIcon("Image/Sales/对话框/images/level2_press_on.png"));
				level1.setIcon(new ImageIcon("Image/Sales/对话框/images/level1_ori.png"));
				level3.setIcon(new ImageIcon("Image/Sales/对话框/images/level3_ori.png"));
				level4.setIcon(new ImageIcon("Image/Sales/对话框/images/level4_ori.png"));
				level5.setIcon(new ImageIcon("Image/Sales/对话框/images/level5_ori.png"));
				level = 2;
			}else if(e.getSource() == level3){
				isLevel = true;
				level3.setIcon(new ImageIcon("Image/Sales/对话框/images/level3_press_on.png"));
				level2.setIcon(new ImageIcon("Image/Sales/对话框/images/level2_ori.png"));
				level1.setIcon(new ImageIcon("Image/Sales/对话框/images/level1_ori.png"));
				level4.setIcon(new ImageIcon("Image/Sales/对话框/images/level4_ori.png"));
				level5.setIcon(new ImageIcon("Image/Sales/对话框/images/level5_ori.png"));
				level = 3;
			}else if(e.getSource() == level4){
				isLevel = true;
				level2.setIcon(new ImageIcon("Image/Sales/对话框/images/level2_ori.png"));
				level3.setIcon(new ImageIcon("Image/Sales/对话框/images/level3_ori.png"));
				level1.setIcon(new ImageIcon("Image/Sales/对话框/images/level1_ori.png"));
				level5.setIcon(new ImageIcon("Image/Sales/对话框/images/level5_ori.png"));
				level4.setIcon(new ImageIcon("Image/Sales/对话框/images/level4_press_on.png"));
				level = 4;
			}else if(e.getSource() == level5){
				isLevel = true;
				level2.setIcon(new ImageIcon("Image/Sales/对话框/images/level2_ori.png"));
				level3.setIcon(new ImageIcon("Image/Sales/对话框/images/level3_ori.png"));
				level4.setIcon(new ImageIcon("Image/Sales/对话框/images/level4_ori.png"));
				level1.setIcon(new ImageIcon("Image/Sales/对话框/images/level1_ori.png"));
				level5.setIcon(new ImageIcon("Image/Sales/对话框/images/level5_press_on.png"));
				level = 5;
			}else if (e.getSource() == forward) {
				//CustomerVO(String id,boolean classification,int level,String cusName,String tel,String address,String zipCode,String ezipCode,double mostOwe,double shouldGet,double shouldPay,String person){
				//编号、分类（供应商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员
		//false代表供应商，true代表销售商
				//false代表进货商，true代表销售商
//				String ID = idField.getText();
				String name = cusName.getText();
				String tel = cusTel.getText();
				String add = cusAdd.getText();
				String code = cusCode.getText();
				String eBox = cusEBox.getText();
				String person = salesManField.getText();
				if(name.equals("")||tel.equals("")||add.equals("")||code.equals("")||eBox.equals("")||
						person.equals("")||(isLevel == false)||(isSupplier == false)){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,AddCusPanel.this);
					salesResult.failed("存在输入或选择为空！", "addCusFailed");
				}else{
					
					try{
						double mostOwe = Double.parseDouble(cusShouldPay.getText());
						double shouldGet = 0;
						double shouldPay = 0;
				CustomerVO customerVO = new CustomerVO(idField.getText(),classification,level,name,tel,add,code,eBox,mostOwe,shouldGet,shouldPay,person);
				frame.remove(AddCusPanel.this);
				frame.setPanel(new MakeSureAddInfo(frame,"Image/Sales/对话框/二次确认/客户确认信息.jpg",controller,salesUIController,customerVO,AddCusPanel.this));
				}catch(Exception e2){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,AddCusPanel.this);
					salesResult.failed("请重新确认输入信息！", "addCusFailed");
				}
				}
				frame.repaint();
			} 
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {
		}

	}
}
