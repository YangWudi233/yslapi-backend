package com.yzh.yslapicommon.service;



/**
* @author User
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-03-21 11:45:06
*/
public interface InnerUserInterfaceInfoService {
    /**
     * 接口调用统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId,long userId);






}
