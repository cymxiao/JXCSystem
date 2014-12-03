package ui.sales.impanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.MyButton;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class ImBackPanel extends ImInPanel {

	public ImBackPanel(JFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame, url, controller, salesUIController);
	}

	public void addButton() {
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(back);
		this.add(forward);
		back.addMouseListener(new MouListener());
		forward.addMouseListener(new MouListener());
	}

	class MouListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == back) {
				salesUIController.backPanel(ImBackPanel.this);
			} else if (e.getSource() == forward) {
				SalesblService salesBlService = new SalesController();
				// TODO
			}
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	
	}
}
