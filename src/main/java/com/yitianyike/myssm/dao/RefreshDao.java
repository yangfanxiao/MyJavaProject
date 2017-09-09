package com.yitianyike.myssm.dao;


import org.apache.ibatis.annotations.Param;

public interface RefreshDao {
	int insertTMS(@Param(value="column_name")String column_name,@Param(value ="column_code")String column_code);
}
