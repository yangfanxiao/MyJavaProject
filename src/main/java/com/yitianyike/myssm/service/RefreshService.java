package com.yitianyike.myssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yitianyike.myssm.entity.FestivalPojo;
import com.yitianyike.myssm.entity.ResponseResult;
import com.yitianyike.myssm.entity.UserPojo;


public interface RefreshService {
	public ResponseResult insert(String  column_name,String column_code);
}
