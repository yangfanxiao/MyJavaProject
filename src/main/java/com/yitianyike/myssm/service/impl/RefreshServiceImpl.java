package com.yitianyike.myssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yitianyike.myssm.common.ErrorCode;
import com.yitianyike.myssm.dao.RefreshDao;
import com.yitianyike.myssm.entity.ResponseResult;
import com.yitianyike.myssm.service.RefreshService;
@Service
public class RefreshServiceImpl implements RefreshService{

	@Autowired
	RefreshDao refreshDao;
	@Override
	public ResponseResult insert(String column_name, String column_code) {
		// TODO Auto-generated method stub
		try {
		int num = refreshDao.insertTMS(column_name, column_code);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseResult(ErrorCode.NORMAL_ERRORCODE,"插入失败");
		}
		return new ResponseResult();
	}

}
