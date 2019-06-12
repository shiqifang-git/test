package com.shineyue.service.ztbg.common;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class Ztbg_common {
	
	private static final Log log = LogFactory.getLog(Ztbg_common.class);
	
	private static Ztbg_common uniqueInstance = null;
	
	public static Ztbg_common getInstance() {
	       if (uniqueInstance == null) {
	           uniqueInstance = new Ztbg_common();
	       }
	       return uniqueInstance;
	}
	
}
