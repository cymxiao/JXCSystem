package ui.manager;

import ui.FatherPanel;
import ui.ManagerPanel;
import ui.UIController;
import ui.account.AccountDetailPanel;
import ui.account.accBasic.AddAccountPanel;
import ui.account.accBasic.ChangeAccountPanel;
import ui.account.accBasic.ConfirmAccPanel;
import ui.account.accBasic.DelAccountPanel;
import ui.account.accBasic.FindAccountPanel;
import ui.account.list.AllBillsPanel;
import ui.account.list.OpeConPanel;
import ui.account.list.SalesListPanel;
import ui.setting.MyFrame;
import ui.setting.SetBack;
import ui.setting.Button.LogOutButton;
import ui.setting.Button.MyButton;
import vo.AccountVO;
import vo.SendGiftVO;
import vo.promotion.DiscountVO;
import vo.promotion.ProGiftVO;
import vo.promotion.VoucherVO;
/**
 * 控制Manager模块所有界面及控制器的跳转
 * @author ZYC
 *
 */
public class ManagerAllUIController extends UIController{
	private MyFrame frame;
	private UIController uiController;
	
	private FindAccountPanel findAccountPanel;
	private AddAccountPanel addAccountPanel;
	private DelAccountPanel delAccountPanel;
	private ChangeAccountPanel changeAccountPanel;
	private ConfirmAccPanel confirmAccPanel;
	private AccountDetailPanel accountDetailPanel;
	
	
	private SalesListPanel salesListPanel;
	private AllBillsPanel allBillsPanel;
	private OpeConPanel opeConPanel;
	
	private SetProPanel setProPanel;
	private ConfirmProPanel confirmProPanel;
	private CheckProPanel checkProPanel;
	
	private SendGiftPanel sendGiftPanel;
	FatherPanel prePanel;
	public static ManagerAllUIController controller;
	
	MyButton backButton;
	
	public ManagerAllUIController(UIController uiController,MyFrame frame){
		this.frame = frame;
		this.uiController = uiController;
		addMainPanel();
		controller = ManagerAllUIController.this;
	}

	private void addMainPanel() {
		new ManagerUIController(this, frame);
		frame.repaint();
	}
	
	public void findAccount(){
		findAccountPanel = new FindAccountPanel(frame,"Image/Manager/查找账户.jpg",this,"manager");
		frame.setPanel(findAccountPanel);
		frame.repaint();
	}
	
	public void logOut(ManagerPanel managerPanel){
		new LogOutButton(frame, managerPanel, "manager", uiController);
	}
	
	public void addAccount(){
		addAccountPanel = new AddAccountPanel(frame, "Image/Manager/增加账户.jpg", this,"manager");
		
		frame.setPanel(addAccountPanel);
		frame.repaint();
	}
	
	public void delAccount() {
		delAccountPanel = new DelAccountPanel(frame,"Image/Manager/删除账户.jpg", this,"manager");
		frame.setPanel(delAccountPanel);
		frame.repaint();
	}
	
	public void changeAccount(){
		changeAccountPanel = new ChangeAccountPanel(frame,"Image/Manager/修改账户.jpg", this,"manager");
		frame.setPanel(changeAccountPanel);
		frame.repaint();
	}
	

	public void confirmAcc(AccountVO acc,String ope){
		//	confirmAccPanel = new ConfirmAccPanel(frame, "Image/Account/确认账户信息.jpg", this,acc,ope);
		confirmAccPanel = new ConfirmAccPanel(frame, "Image/Manager/确认账户信息.jpg",this,acc,ope,"manager");
		frame.setPanel(confirmAccPanel);
		frame.repaint();
	}
	
	public void confirmAcc(AccountVO acc,String ope,AccountVO newAcc){
		confirmAccPanel = new ConfirmAccPanel(frame, "Image/Manager/确认账户信息.jpg", this,acc,ope,"manager",newAcc);
		frame.setPanel(confirmAccPanel);
		frame.repaint();
	}
	
	public void accountDetail(AccountVO foundAcc){
//		System.out.println("OUY");
		accountDetailPanel = new AccountDetailPanel(frame, "Image/Manager/accDetail.jpg", this ,foundAcc);
		frame.setPanel(accountDetailPanel);
		frame.repaint();
	}

	public void salesList(){
		salesListPanel = new SalesListPanel(frame, "Image/Manager/销售明细_查询_背景.jpg", this,"manager");
		frame.setPanel(salesListPanel);
		frame.repaint();
	}
	
	public void allBills(){
		allBillsPanel = new AllBillsPanel(frame, "Image/Manager/经营历程_查询_背景.jpg", this,"manager");
		frame.setPanel(allBillsPanel);
		frame.repaint();
	}
	
	public void opeCon(){
		opeConPanel = new OpeConPanel(frame, "Image/Manager/经营情况_查询_背景.jpg", this,"manager");
		frame.setPanel(opeConPanel);
		frame.repaint();
	}
	
	public void setPro(){
		setProPanel = new SetProPanel(frame, "Image/Manager/promotion/proDo.jpg", this);
		frame.setPanel(setProPanel);
		frame.repaint();
	}
	
	public void checkPro() {
		checkProPanel = new CheckProPanel(frame,"Image/Manager/promotion/promotionAll.jpg" , this);
		frame.setPanel(checkProPanel);
		frame.repaint();
	}
	
	public void confirmProDis(DiscountVO discount){
		confirmProPanel = new ConfirmProPanel(frame, "Image/Manager/promotion/proDoConfirm.jpg", this, discount);
		frame.setPanel(confirmProPanel);
		frame.repaint();
	}
	public void confirmProGift(ProGiftVO gift) {
		confirmProPanel = new ConfirmProPanel(frame,"Image/Manager/promotion/proDoConfirm.jpg" , this, gift);
		frame.setPanel(confirmProPanel);
		frame.repaint();
	}
	public void confirmProVou(VoucherVO voucher) {
		confirmProPanel = new ConfirmProPanel(frame, "Image/Manager/promotion/proDoConfirm.jpg", this, voucher);
		frame.setPanel(confirmProPanel);
		frame.repaint();
	}
	
	public void sendGiftBill(SendGiftVO gift){
		sendGiftPanel = new SendGiftPanel(frame,"Image/Manager/snedGift.jpg", this, gift);
		frame.setPanel(sendGiftPanel);
		frame.repaint();
	}
	
	public void setBack_first(FatherPanel prePanel){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_first();
	}

	public void setBack_second(FatherPanel prePanel,int x,int y){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_second(x, y);
	}

	public void setBack_third(FatherPanel prePanel) {
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_third();
		
	}
	
	


}
