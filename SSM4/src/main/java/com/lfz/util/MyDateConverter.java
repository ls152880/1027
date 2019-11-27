package com.lfz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;





public class MyDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String arg0) {
		SimpleDateFormat sf = getSimpleDateFormat(arg0);
		
//			将时间字符串类型转换为Date类型
			
			try {
				Date d = sf.parse(arg0);
				return d;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   return null;
	}
	
	/**
	 *匹配时间格式
	 * @param source
	 * @return
	 */
	private  SimpleDateFormat getSimpleDateFormat(String source){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)){
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		}else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", source)){
		sdf = new SimpleDateFormat("yyyy/MM/dd");
		} else if(Pattern.matches("^\\d{4}\\d{2}\\d{2}$", source)){
		sdf = new SimpleDateFormat("yyyyMMdd");
		}
		return sdf;
		}
}



	
	

