package com.yitianyike.myssm.control;



import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yitianyike.myssm.common.DynamicDataSource;
import com.yitianyike.myssm.common.ErrorCode;
import com.yitianyike.myssm.entity.ResponseResult;
import com.yitianyike.myssm.service.RefreshService;


@Controller
@RequestMapping(value = "refresh")
public class RefreshController {

    @Autowired
    private RefreshService refreshServiceImpl;
    
	
	@RequestMapping(value = "refresh",method ={RequestMethod.POST})
	@ResponseBody
	public  ResponseResult create(HttpServletRequest request){
		DynamicDataSource.setCustomerType(DynamicDataSource.DATASOURCE_B);
		try{
		    return refreshServiceImpl.insert("lilianjie", "3");
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseResult(ErrorCode.NORMAL_ERRORCODE,"创建失败");
		}
	}
}
