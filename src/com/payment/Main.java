package com.payment;

public class Main {

	public static void main(String[] args) {
		boolean isByAgent=true;//是否客户付手续费
		boolean isByPlat=true;//是否经平台
		boolean agentEnough=true;//客户金额是否充足 TODO 开始就查询
		boolean tradeEnough=true;//企业金额是否充足
		Object dto=new Object();//第一次初始化
		int a=0,b=0,c=0,d=0;
		if(isByAgent){
			a=8;
		}else{
			//TODO 查询企业账户余额
			if(tradeEnough) d=1;
		}
		if(isByPlat) b=4;
		if(agentEnough) c=2;
		Fectory.initObje(dto, a+b+c+d);
	}
}
