package edu.lys.dao;

import java.util.List;

import edu.lys.entity.Order;
import edu.lys.entity.OrdercommodityVO;
import edu.lys.entity.Shopcart;
import edu.lys.entity.ShopcartVO;

public interface ICart {

	//添加购物车
	public boolean addCart(Shopcart cart);
	
	//根据客户id查询购物车中商品数量及金额
	public int[]  searchCartAmount(int id );
	
	//根据客户id查看购物车详情
	public List<ShopcartVO> searchCartInfo(int id);
	
	//删除购物车
	public boolean deleteCart(int cartId);
	
	//清空购物车
	public boolean clearCart(int cusId );
	
	//根据客户id验证支付密码
	public String checkPayWord(int id);
	
	//查找下一个订单id序列
	public int selectNextOrderId();
	
	//添加订单
	public boolean addcOrder(int id,Order order);
	
	//添加订单商品
	public boolean addcOrderCommodity(int id,OrdercommodityVO commodity);
}
