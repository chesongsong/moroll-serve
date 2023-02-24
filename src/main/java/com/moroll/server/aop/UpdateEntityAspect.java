package com.moroll.server.aop;

import com.moroll.server.entity.BaseEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-20 22:40
 */
@Aspect
@Component
public class UpdateEntityAspect {

    /**
     * 前置增强，在插入数据前设置创建时间、创建人、更新时间和更新人
     */
    public void setCreateInfo(JoinPoint point) {
        Object[] args = point.getArgs();
        for (Object arg : args) {
            if (arg instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) arg;
                entity.setCreateTime(new Date());
                entity.setCreateBy(
                        getCurrentUser());
                entity.setUpdateTime(entity.getCreateTime());
                entity.setUpdateBy(entity.getCreateBy());
            }
        }
    }

    /**
     * 前置增强，在更新数据前设置更新时间和更新人
     */
//    @Before("execution(* com.moroll.server)")
    public void setUpdateInfo(JoinPoint point) {
        Object[] args = point.getArgs();
        for (Object arg : args) {
            if (arg instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) arg;
                entity.setUpdateTime(new Date());
                entity.setUpdateBy(getCurrentUser());
            }
        }
    }

    /**
     * 获取当前用户，此处仅作示例
     */
    private String getCurrentUser() {
        return "admin";
    }
}