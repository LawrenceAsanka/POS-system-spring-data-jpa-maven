package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.OrderBO;
import lk.ijse.dep.entity.CustomEntity;
import lk.ijse.dep.repository.CustomerRepository;
import lk.ijse.dep.repository.ItemRepository;
import lk.ijse.dep.repository.OrderDetailRepository;
import lk.ijse.dep.repository.OrderRepository;
import lk.ijse.dep.entity.Item;
import lk.ijse.dep.entity.Order;
import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.util.OrderDetailTM;
import lk.ijse.dep.util.OrderTM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class OrderBOImpl implements OrderBO {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public String getNewOrderId() throws Exception {
        String lastOrderId = orderRepository.getFirstLastOrderIdByOrderByIdDesc().getId();
        if (lastOrderId == null) {
            return "OD001";
        } else {
            int maxId = Integer.parseInt(lastOrderId.replace("OD", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "OD00" + maxId;
            } else if (maxId < 100) {
                id = "OD0" + maxId;
            } else {
                id = "OD" + maxId;
            }
            return id;
        }
    }

    public void placeOrder(OrderTM order, List<OrderDetailTM> orderDetails) throws Exception {
        orderRepository.save(new Order(order.getOrderId(),
                Date.valueOf(order.getOrderDate()),
                customerRepository.findById(order.getCustomerId()).get()));

        for (OrderDetailTM orderDetail : orderDetails) {
            orderDetailRepository.save(new OrderDetail(
                    order.getOrderId(), orderDetail.getCode(),
                    orderDetail.getQty(), BigDecimal.valueOf(orderDetail.getUnitPrice())
            ));
            Item item = itemRepository.findById(orderDetail.getCode()).get();
            item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
            itemRepository.save(item);

        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrderTM> getAllOrders() throws Exception {
        List<CustomEntity> allOrderDetails = orderRepository.getAllOrderDetails2();
        List<OrderTM> orderDetailsList = new ArrayList<>();
        for (CustomEntity orderDetails : allOrderDetails) {
            BigDecimal total = orderDetails.getTotal();
            orderDetailsList.add(new OrderTM(orderDetails.getOrderId(), orderDetails.getOrderDate().toLocalDate(), orderDetails.getCustomerId(),
                    orderDetails.getCustomerName(), Double.parseDouble(total.toString())));
        }
        return orderDetailsList;
    }
}
