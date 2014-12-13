package ui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.UserVO;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserblService;

public class ConfirmUserPanel extends FatherPanel implements ActionListener{
	protected MyButton forwardButton;
	protected ResultPanelController resController;
	protected AdminAllUIController adminAllUIController;
	protected UserVO user;
	protected String type;
	protected UserblService userblService;
	
	protected MyLabel[] infoLabels = new MyLabel[3]; 
	
	public ConfirmUserPanel(MyFrame frame, String url, AdminAllUIController controller,
			UserVO user,String type) {
		super(frame, url, controller);
		
		this.type = type;
		this.user = user;
		this.adminAllUIController = controller;
		
		setForward();
		setInfoLabel();
		
		userblService = new UserController();
	}
	
	private void setForward() {
		ForwardButton forward = new ForwardButton(270, 300);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	private void addCloseLabel(){
		
	}
	
	private void addMinLabel(){
		
	}
/**
 * 将待确认信息加到label上
 */
	private void setInfoLabel(){
		for(int i = 0;i < infoLabels.length;i++){
			infoLabels[i] = new MyLabel(101, 89+72*i, 212, 35);
			this.add(infoLabels[i]);
			infoLabels[i].setForeground(new ColorFactory().greyFont);
		//	infoLabels[i].setText(""+i);
		}
		infoLabels[0].setText(user.id);
		infoLabels[1].setText(user.name);
		String userDuty = "";
		switch(user.duty){
		case 0:
			userDuty = "管理员";
			break;
		case 1:
			userDuty = "库存人员";
			break;
		case 2:
			userDuty = "销售人员";
			break;
		case 3:
			userDuty = "销售经理";
			break;
		case 4:
			userDuty = "财务人员";
			break;
		case 5:
			userDuty = "财务经理";
			break;
		case 6:
			userDuty = "总经理";
			break;
		default:
			userDuty = "";
			break;
		}
		infoLabels[2].setText(userDuty);
		this.repaint();
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == forwardButton){
			switch(userblService.addUser_up(user)){
			case 0:
				adminAllUIController.setResult(type);
				break;
			}
		}
	}
	
}
