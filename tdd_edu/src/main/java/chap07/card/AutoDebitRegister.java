package chap07.card;

import java.time.LocalDateTime;

import chap07.card.dto.AutoDebitReq;
import chap07.card.dto.RegisterResult;
import chap07.card.model.AutoDebitInfo;
import chap07.card.repository.AutoDebitInfoRepository;
import chap07.card.validate.CardNumberValidator;
import chap07.card.validate.CardValidity;

public class AutoDebitRegister {
	private CardNumberValidator validator;
	private AutoDebitInfoRepository repository;
	
	public AutoDebitRegister(CardNumberValidator validator, AutoDebitInfoRepository repository) {
		this.validator = validator;
		this.repository = repository;
	}
	
	public RegisterResult register(AutoDebitReq req) {
		CardValidity validity = validator.validate(req.getCardNumber());
		
		if(validity != CardValidity.VALID) {
			return RegisterResult.error(validity);
		}
		
		AutoDebitInfo info = repository.findOne(req.getUserId());
		if(info != null) {
			info.changeCardNumber(req.getCardNumber());
		}else {
			AutoDebitInfo newInfo = new AutoDebitInfo(req.getUserId(), req.getCardNumber(), LocalDateTime.now());
			repository.save(newInfo);
		}
		return RegisterResult.success();
	}
}
