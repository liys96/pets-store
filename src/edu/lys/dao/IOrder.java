package edu.lys.dao;

import java.util.List;

import edu.lys.entity.Appraise;
import edu.lys.entity.Commodity;
import edu.lys.entity.Customer;
import edu.lys.entity.OrderVO;
import edu.lys.entity.OrdercommodityVO;
import edu.lys.entity.Page;

public interface IOrder {

	//查找订单模糊
	public List<OrderVO> searchAllOrder(Page<OrderVO> page);
	
	//查询总记录数
	public int searchCount(Page<OrderVO> page);
	
	//根据订单id查找订单详情
	public OrderVO searchOrderInfo(int id);
	
	//根据订单id查找对应商品
	public List<OrdercommodityVO> searchOrderCommodity(int id);
	
	//根据订单商品id查找库存中商品数量
	public int searchInventryAmount(int id);
	
	//发货退货(库存商品数量变化)
	public boolean changeInventryAmount(int amount,int id);
	
	//发货(状态为1)
	public boolean sendOrder(int id);
	
	//退货(状态为5)
	public boolean backOrder(int id);
	
	//生成订单编号
	public StringBuffer serialNumber();
	
	//订单总数
	public int orderCount();
	
	//前台查看对应客户订单
	public List<OrderVO> searchcOrder(int id,Page<OrderVO> page);
	
	//查询总记录数
	public int searchcOrderCount(int id,Page<OrderVO> page);
	
	//取消订单(6)
	public boolean cancelOrder(int id);
	
	//确认收货(2)
	public boolean receiveOrder(int id);
	
	//发起退货(4)
	public boolean returnOrder(int id);
		
	//添加评价
	public boolean addAppraise(Appraise appraise);
	
	//完成订单(7)
	public boolean finishOrder(int id);
	
	
}
