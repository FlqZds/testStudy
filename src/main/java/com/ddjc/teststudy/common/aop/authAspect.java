package com.ddjc.teststudy.common.aop;

import com.aliyuncs.utils.StringUtils;
import com.ddjc.teststudy.beans.userDTO;
import com.ddjc.teststudy.common.Exception.AppException;
import com.ddjc.teststudy.common.JWTutil;
import com.ddjc.teststudy.common.RESTFUL.ResponseEnum;
import com.ddjc.teststudy.common.ano.emPowerment;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Component
@Aspect
public class authAspect {

    @Autowired
    private JWTutil jwtutil;
    @Autowired
    private com.ddjc.teststudy.service.rbacService rbacService;

    // 定义切面 前置增强  对用户的请求进行身份验证
    @Before("@annotation(com.ddjc.teststudy.common.ano.checkLogin)")
    public void beforeJudgeIdentity(JoinPoint joinPoint) {
        // 拿到增强方法的对应request
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest(); // 获取我要的httpRequest对象
//拿到并核对token
        String token = request.getHeader("X-Token");

        if(StringUtils.isEmpty(token)){ // token为空
            throw new AppException(ResponseEnum.TOKEN_NOT_FOUND);
        }

        userDTO front = jwtutil.checkJwt(token);

//        重新传回handler
        Integer roleId = front.getRoleId();
        request.setAttribute("roleId", roleId);
        System.out.println("roleId:" + roleId);
//qq
    }


    // 定义切面 前置增强  对相应角色的行为动作赋予 他身份应有的权限
    @Before("@annotation(com.ddjc.teststudy.common.ano.emPowerment)")
    public void beforeEmpowerment(JoinPoint joinPoint) {
//       拿到当前servlet上下文的request对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();  //拿到HttpServletRequest

        String token = request.getHeader("X-Token");

        if(StringUtils.isEmpty(token)){ // token为空
            throw new AppException(ResponseEnum.TOKEN_NOT_FOUND);
        }

        userDTO userDTO = jwtutil.checkJwt(token);// 核对token


        Integer roleId = userDTO.getRoleId();

        // 根据角色id 查出对应角色的权限码
        List<String> actionCode_List = rbacService.selectActionCodeByRoleID(roleId);

        //拿到请求的权限码
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        emPowerment ano_emPowerment = signature.getMethod().getAnnotation(emPowerment.class);
        String anoCode_value = ano_emPowerment.value();
        // 核对请求的权限码是否在角色的权限码列表中
        if (!actionCode_List.contains(anoCode_value)) {
            throw new AppException(ResponseEnum.USER_ROLE_NOT_ENOUGH); // 权限不足
        }
        // 权限码核对通过
    }

}
