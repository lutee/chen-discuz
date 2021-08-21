package cn.chenyuxian.discuz.core.validator.constraint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import cn.chenyuxian.discuz.core.enums.PasswordStrategy;
import cn.chenyuxian.discuz.core.validator.annotion.PasswordValid;

/**
 * 密码验证
 *
 * @author chenyuxian
 * @date 2021-08-20
 */
public class PasswordValidator implements ConstraintValidator<PasswordValid, String> {

	private PasswordStrategy strategy;
	
	@Override
	public void initialize(PasswordValid constraintAnnotation) {
		this.strategy = constraintAnnotation.strategy();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(strategy != null) {
			if(StringUtils.isEmpty(strategy.getValue())) {
				return true;
			}
			Pattern pattern = Pattern.compile(strategy.getValue());
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		}
		return false;
	}

}