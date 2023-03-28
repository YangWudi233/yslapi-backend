package com.yzh.yslapicommon.service;

import com.yzh.yslapicommon.model.entity.InterfaceInfo;

/**
* @author User
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-03-18 00:06:59
*/
public interface InnerInterfaceInfoService {
   InterfaceInfo getInterfaceInfo(String path, String method);
}
