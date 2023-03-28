package com.yzh.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzh.project.common.ErrorCode;
import com.yzh.project.exception.BusinessException;
import com.yzh.project.mapper.UserInterfaceInfoMapper;
import com.yzh.project.service.UserInterfaceInfoService;
import com.yzh.yslapicommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author User
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-03-21 11:45:06
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
     Long id = userInterfaceInfo.getId();
     Long userId = userInterfaceInfo.getUserId();
     Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
     Integer totalNum = userInterfaceInfo.getTotalNum();
     Integer leftNum = userInterfaceInfo.getLeftNum();
     Integer status = userInterfaceInfo.getStatus();
     Date createTime = userInterfaceInfo.getCreateTime();
     Date updateTime = userInterfaceInfo.getUpdateTime();
     Integer isDelete = userInterfaceInfo.getIsDelete();

        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空。是校验接口名称的，而这个表没有名称这个字段，校验次数
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId()<=0 || userInterfaceInfo.getUserId() <= 0)  {
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0 ) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于0");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
//        判断。用户每次调用接口成功，次数+1（service)

        if (interfaceInfoId <= 0 || userId <= 0){

            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();

        updateWrapper.eq("interfaceInfoId",interfaceInfoId);
        updateWrapper.eq("userId",userId);
//        updateWrapper.gt("leftNum",0);
        updateWrapper.setSql("leftNum = leftNum -1 ,totalNum = totalNum +1");
        return this.update(updateWrapper);
//        后期添加事物
    }


}




