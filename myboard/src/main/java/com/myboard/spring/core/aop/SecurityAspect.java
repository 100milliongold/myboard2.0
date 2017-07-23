package com.myboard.spring.core.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.myboard.spring.core.annotation.SigninRequired;

@Aspect // AOP 선언
@Order(20) // AOP 적용 순위 20
@Component // 빈 자동 등록
public class SecurityAspect {

	@Around("@annotation(com.myboard.spring.core.annotation.SigninRequired)")
	public Object checkSignIn(ProceedingJoinPoint pjp) throws Throwable{
		
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		// 요청읽어오기
		HttpServletRequest req = requestAttributes.getRequest();
		// 응답읽어오기
		HttpServletResponse res = requestAttributes.getResponse();
		
		// AOP에서 클레스 읽어오기
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Class returnType = signature.getReturnType();
		
		HttpSession session = req.getSession();
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		
		if(isLogin == null || !isLogin) {
			throw new SecurityException("로그인이 필요합니다.");
		}else{ //로그인시 권한체크
			SigninRequired signinRequired = signature.getMethod().getAnnotation(SigninRequired.class);
			String[] roles = signinRequired.value();
			String role = (String) session.getAttribute("role");
			
			//권한이 없거나 일치하는게 없을때
			if(roles.length > 0 && !ArrayUtils.contains(roles, role)){
				throw new SecurityException("권한이 없습니다.");
			}
		}
		return pjp.proceed();
	}
}
