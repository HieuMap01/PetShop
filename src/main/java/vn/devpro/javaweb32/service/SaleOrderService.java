package vn.devpro.javaweb32.service;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb32.model.SaleOrder;

@Service
public class SaleOrderService extends BaseService<SaleOrder> {
	@Override
	public Class<SaleOrder> clazz() {
		// TODO Auto-generated method stub
		return SaleOrder.class;
	}

}
