package com.shineyue.service.ztbg;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shineyue.bean.ztbg.CommonBean;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_control {
	
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-单位信息变更",fwdm = "dwxxbg.service",ywdm = "control",fwdz ="control/dwxxbg.service")
	@RequestMapping(value = "ZTBG/control/dwxxbg.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_dwxxbg(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-基数调整",fwdm = "jstz.service",ywdm = "control",fwdz ="control/jstz.service")
	@RequestMapping(value = "ZTBG/control/jstz.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_jstz(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-汇缴",fwdm = "hj.service",ywdm = "control",fwdz ="control/hj.service")
	@RequestMapping(value = "ZTBG/control/hj.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_hj(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-补缴",fwdm = "bj.service",ywdm = "control",fwdz ="control/bj.service")
	@RequestMapping(value = "ZTBG/control/bj.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_bj(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-单位信息查询",fwdm = "dwxxcx.service",ywdm = "control",fwdz ="control/dwxxcx.service")
	@RequestMapping(value = "ZTBG/control/dwxxcx.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_dwxxcx(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-缴存人登记",fwdm = "jcrdj.service",ywdm = "control.service",fwdz ="control/jcrdj.service")
	@RequestMapping(value = "ZTBG/control/jcrdj.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_jcrdj(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-缴存人信息变更",fwdm = "jcrxxbg.service",ywdm = "control",fwdz ="control/jcrxxbg.service")
	@RequestMapping(value = "ZTBG/control/jcrxxbg.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_jcrxxbg(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-缴存人状态变更",fwdm = "jcrztbg.service",ywdm = "control",fwdz ="control/jcrztbg.service")
	@RequestMapping(value = "ZTBG/control/jcrztbg.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_jcrztbg(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-缴存人调动",fwdm = "jcrdd.service",ywdm = "control",fwdz ="control/jcrdd.service")
	@RequestMapping(value = "ZTBG/control/jcrdd.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_jcrdd(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-缴存人信息查询",fwdm = "jcrxxcx.service",ywdm = "control",fwdz ="control/jcrxxcx.service")
	@RequestMapping(value = "ZTBG/control/jcrxxcx.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_jcrxxcx(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-单位部门管理",fwdm = "dwbmgl.service",ywdm = "control",fwdz ="control/dwbmgl.service")
	@RequestMapping(value = "ZTBG/control/dwbmgl.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_dwbmgl(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-缴存人单位调整",fwdm = "jcrdwtz.service",ywdm = "control",fwdz ="control/jcrdwtz.service")
	@RequestMapping(value = "ZTBG/control/jcrdwtz.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_jcrdwtz(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	
	@HttpServiceInfo(qddm="ZTBG",fwname="网厅-功能控制-单位缓缴",fwdm = "dw_jcdwhjjc.service",ywdm = "control",fwdz ="control/dw_jcdwhjjc.service")
	@RequestMapping(value = "ZTBG/control/dw_jcdwhjjc.service", method = RequestMethod.POST)
	@ResponseBody
	public DataResult ZTBG_control_dw_jcdwhjjc(@RequestBody CommonBean p) {
		DataResult t = new DataResult();
		t.setSuccess(true);
		return t;
	}
	
}
