package com.yitianyike.myssm.utils;

import java.io.IOException;
import java.io.StringWriter;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**  
 * @Description: json转换工具类
 */
public class JsonUtil {
	private static JsonFactory jf = new JsonFactory();
	private static ObjectMapper mapper;
	private JsonUtil(){}
	
	private static ObjectMapper getMapper() {
		if(mapper==null) {
			mapper = new ObjectMapper();
		}
		return mapper;
	}
	
	public static String obj2json(Object obj) {
		
		if(obj == null) {
			return "";
		}
		
		if(obj instanceof String) {
			return obj.toString();
		}
		
		JsonGenerator jg = null;
		try {
			mapper = getMapper();
			StringWriter out = new StringWriter();
			jg = jf.createGenerator(out);
			mapper.writeValue(jg, obj);
			return out.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(jg!=null) jg.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Object json2obj(String json,Class<?> clz) {
		
		try {
			
			if(StringUtils.isEmpty(json)) {
				return null;
			}
			
			mapper = getMapper();
			return mapper.readValue(json,clz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
