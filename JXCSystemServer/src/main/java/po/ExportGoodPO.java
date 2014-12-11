package po;

import java.io.Serializable;

public class ExportGoodPO implements Serializable{
	
	CommodityPO commodity;
	int number;
	int price;  	//这里是商品的单价，人工输入
	int money;		//这里是这个商品出库列表的总价
	String ps;
	
	public ExportGoodPO(CommodityPO commodity,int number,int price,int money,String ps){
		this.commodity=commodity;
		this.number=number;
		this.price=price;
		this.money=money;
		this.ps=ps;
	}
	
	
	public CommodityPO getCommodity(){
		return commodity;
	}
	public int getNumber(){
		return number;
	}
	public int getPrice(){
		return price;
	}
	public int getMoney(){
		return money;
	}
	public String getPs(){
		return ps;
	}
	
	public ExportGoodPO copy(){
		return new ExportGoodPO(commodity.copy(),number,price,money,ps);
	}
	

}
