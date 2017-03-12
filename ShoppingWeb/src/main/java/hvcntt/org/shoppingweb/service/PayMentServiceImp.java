package hvcntt.org.shoppingweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hvcntt.org.shoppingweb.model.PayMent;
import hvcntt.org.shoppingweb.repository.PayMentRepository;
@Service
public class PayMentServiceImp implements PayMentService {
	@Autowired
	PayMentRepository paymentRepository;
	@Override
	public PayMent create(PayMent payMent) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payMent);
	}

}
