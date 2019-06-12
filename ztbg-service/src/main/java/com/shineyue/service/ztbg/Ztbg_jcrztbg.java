package com.shineyue.service.ztbg;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shineyue.bean.ztbg.Jcdw_jcrbgztBean;
import com.shineyue.bean.ztbg.Jcdwjcrztbg;
import com.shineyue.bean.ztbg.Jcdwjcrztbg_mx;
import com.shineyue.bean.ztbg.Jcdwjcrztbg_qc;
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.model.xtgl.OptlogBean;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_jcrztbg {

	private static final Log log = LogFactory.getLog(Ztbg_jcrztbg.class);
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更录入", fwdm = "jcrbgztadd", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztadd.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztadd.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztadd(@RequestBody Jcdwjcrztbg gjzf_gr_zzbg) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcrztbg_jcrbgztadd",gjzf_gr_zzbg);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人变更状态录入:" + e.getMessage() + "</font>";
			log.error(trace);
			gjzf_gr_zzbg.setMsg(e.getMessage());
		} 
		t.setData(gjzf_gr_zzbg);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更清册查询", fwdm = "jcrbgztqccx", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztqccx.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztqccx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztqccx(@RequestBody Jcdwjcrztbg_qc gjzf_gr_zzbg_qc) {
		DataResult t=new DataResult();
		String trace = "";
		List<Jcdwjcrztbg_qc> l = new ArrayList<Jcdwjcrztbg_qc>();
		int count = 0;
		try{
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcrztbg_jcrbgztqccx",
					gjzf_gr_zzbg_qc, gjzf_gr_zzbg_qc.getSize(), gjzf_gr_zzbg_qc.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			double grjcjshj=lst.size() > 0 ? lst.get(0).getDefDouble("grjcjshj") : 0;
			double yjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("yjcehj") : 0;
			System.out.println("========grjcjshj======="+grjcjshj);
			t.setTotalcount(count);
			for(Row row : lst) {
				Jcdwjcrztbg_qc bean = new Jcdwjcrztbg_qc();
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setDwbh(row.getTrimString("dwbh"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setGrjcjs(row.getDefDouble("grjcjs"));
				bean.setYjce(row.getDefDouble("yjce"));
				bean.setBglb(row.getTrimString("bglb"));
				bean.setBgyy(row.getTrimString("bgyy"));
				bean.setBgrq(row.getDateToString("bgrq"));
				bean.setId(row.getTrimString("id"));
				bean.setBglbbm(row.getTrimString("bglbbm"));
				bean.setBpmid(row.getDefLong("bpmid"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setBgyd(row.getTrimString("bgyd"));
				bean.setLrczy(row.getTrimString("lrczy"));
				
				bean.setCount(count);
				bean.setGrjcjshj(grjcjshj);
				bean.setYjcehj(yjcehj);
				l.add(bean);
			}
			t.setData(l);
			OptlogBean ob = new OptlogBean();
			ob.setBlqd("zxb");
			ob.setCzfl("05");
			ob.setJgbm(gjzf_gr_zzbg_qc.getJgbm());
			ob.setKhbh(gjzf_gr_zzbg_qc.getKhbh());
			ob.setMsg("");
			ob.setUserid(gjzf_gr_zzbg_qc.getUserid());
			ob.setYwczbs(count+"");
			ob.setYwczje(1);
			ob.setYwfl(gjzf_gr_zzbg_qc.getYwfl());
			ob.setYwlb(gjzf_gr_zzbg_qc.getYwlb());
			ob.setYwlsh("");
			ob.setYwzy("缴存人状态变更清册查询");
			ob.setZhbh("");
			ob.setZxjgbm(gjzf_gr_zzbg_qc.getZxbm());
			try {
				DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", ob);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} catch (Exception e) {
			trace = "<font color='red'>缴存人状态变更清册查询:" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更清册删除", fwdm = "jcrbgztqcdel", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztqcdel.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztqcdel.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztqcdel(@RequestBody Jcdwjcrztbg_qc gjzf_gr_zzbg_qc) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcrztbg_jcrbgztqcdel",gjzf_gr_zzbg_qc);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人状态变更清册删除:" + e.getMessage() + "</font>";
			log.error(trace);
			gjzf_gr_zzbg_qc.setMsg(e.getMessage());
		} 
		t.setData(gjzf_gr_zzbg_qc);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更清册全删", fwdm = "jcrbgztqcdelall", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztqcdelall.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztqcdelall.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztqcdelall(@RequestBody Jcdwjcrztbg_qc gjzf_gr_zzbg_qc) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcrztbg_jcrbgztqcdelall",gjzf_gr_zzbg_qc);
		} catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>缴存人状态变更清册删除:" + e.getMessage() + "</font>";
			log.error(trace);
			gjzf_gr_zzbg_qc.setMsg(e.getMessage());
		} 
		t.setData(gjzf_gr_zzbg_qc);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更导入", fwdm = "jcrbgztdr", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztdr.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztdr.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztdr(@RequestBody Jcdwjcrztbg gjzf_gr_zzbg) {
		String trace = "";
		DataResult t = new DataResult();
		List<Jcdwjcrztbg> l=new ArrayList<Jcdwjcrztbg>();
		try {
			List<Row> list = DbMethod.makeDbSingleton().Open("Ztbg_Jcrztbg_jcrbgztdr", gjzf_gr_zzbg);
			if (list.size() == 0) {
				Jcdwjcrztbg cb = new Jcdwjcrztbg();
				cb.setRet(gjzf_gr_zzbg.getRet());
				cb.setMsg(gjzf_gr_zzbg.getMsg());
				l.add(cb);
			} else {
				for(Row row : list){
					Jcdwjcrztbg bean = new Jcdwjcrztbg();
					bean.setGrzh(row.getTrimString("grzh"));
					bean.setXingming(row.getTrimString("xingming"));
					bean.setSbyy(row.getTrimString("msg"));
					System.out.println("=======================123123==msg================"+row.getTrimString("msg"));
					bean.setMsg(gjzf_gr_zzbg.getMsg());
					bean.setOnly(gjzf_gr_zzbg.getOnly());
					bean.setRet(gjzf_gr_zzbg.getRet());
					l.add(bean);
				}
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'> 缴存人变更状态导入：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更打印清册", fwdm = "jcrbgztdyqc", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztdyqc.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztdyqc.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztdyqc(@RequestBody Jcdw_jcrbgztBean jcrbgztBean) {
		DataResult t=new DataResult();
		String trace = "";
		List<Row> lst;
		List<Jcdw_jcrbgztBean> l=new ArrayList<Jcdw_jcrbgztBean>();
		try{
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcrztbg_jcrbgztdyqc",jcrbgztBean);
			for (Row row : lst) {
				Jcdw_jcrbgztBean bean=new Jcdw_jcrbgztBean();
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setBgrq(row.getDateToString("bgrq"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setJbrxm(row.getTrimString("jbrxm"));
				bean.setJbrsjhm(row.getTrimString("jbrsjhm"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setGrzhzt(row.getTrimString("grzhzt"));
				bean.setBgqgrzhzt(row.getTrimString("bgqgrzhzt"));
				bean.setBghgrzhzt (row.getTrimString("bghgrzhzt"));
				
				bean.setBgyd(row.getTrimString("bgyd"));
				bean.setYjce(row.getDefDouble("yjce"));
				bean.setYjcze(row.getDefDouble("yjcze"));
				
				
				bean.setLrczy(row.getTrimString("lrczy"));
				bean.setSpczy(row.getTrimString("spczy"));
				
				
				l.add(bean);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位客户变更信息打印方法失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更批量查询", fwdm = "jcrbgztplcx", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztplcx.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztplcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztplcx(@RequestBody Jcdw_jcrbgztBean jcrbgztBean) {
		DataResult t=new DataResult();
		String trace = "";
		List<Row> lst;
		int count = 0;
		List<Jcdw_jcrbgztBean> l=new ArrayList<Jcdw_jcrbgztBean>();
		try{
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcrztbg_jcrbgztplcx",jcrbgztBean, jcrbgztBean.getSize(), jcrbgztBean.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			for (Row row : lst) {
				Jcdw_jcrbgztBean bean=new Jcdw_jcrbgztBean();
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setYjcze(row.getDefDouble("yjce"));
				bean.setBgyymc(row.getTrimString("bgyymc"));
				bean.setBgyymc1(row.getTrimString("bgyymc1"));
				
				l.add(bean);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人状态变更-批量勾选查询：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更批量存盘", fwdm = "jcrbgztplcp", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztplcp.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztplcp.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztplcp(@RequestBody Jcdwjcrztbg gjzf_gr_zzbg) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcrztbg_jcrbgztplcp",gjzf_gr_zzbg);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人变更状态批量勾选录入:" + e.getMessage() + "</font>";
			log.error(trace);
			gjzf_gr_zzbg.setMsg(e.getMessage());
		} 
		t.setData(gjzf_gr_zzbg);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更审批查询", fwdm = "jcrbgztspcx", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztspcx.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztspcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztspcx(@RequestBody Jcdwjcrztbg_qc gjzf_gr_zzbg_qc) {
		DataResult t=new DataResult();
		String trace = "";
		List<Jcdwjcrztbg_qc> l = new ArrayList<Jcdwjcrztbg_qc>();
		int count = 0;
		try{
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcrztbg_jcrbgztspcx",
					gjzf_gr_zzbg_qc, gjzf_gr_zzbg_qc.getSize(), gjzf_gr_zzbg_qc.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			for(Row row : lst) {
				Jcdwjcrztbg_qc bean = new Jcdwjcrztbg_qc();
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setDwbh(row.getTrimString("dwbh"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setGrjcjs(row.getDefDouble("grjcjs"));
				bean.setYjce(row.getDefDouble("yjce"));
				bean.setBglb(row.getTrimString("bglb"));
				bean.setBgyy(row.getTrimString("bgyy"));
				bean.setBgrq(row.getDateToString("bgrq"));
				bean.setId(row.getTrimString("id"));
				bean.setBglbbm(row.getTrimString("bglbbm"));
				bean.setBpmid(row.getDefLong("bpmid"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setDwmc(row.getTrimString("dwmc"));
				
				bean.setCount(count);
				l.add(bean);
			}
			t.setData(l);
			OptlogBean ob = new OptlogBean();
			ob.setBlqd("zxb");
			ob.setCzfl(" ");
			ob.setJgbm(gjzf_gr_zzbg_qc.getJgbm());
			ob.setKhbh(gjzf_gr_zzbg_qc.getKhbh());
			ob.setMsg("");
			ob.setUserid(gjzf_gr_zzbg_qc.getUserid());
			ob.setYwczbs(count+"");
			ob.setYwczje(1);
			ob.setYwfl(gjzf_gr_zzbg_qc.getYwfl());
			ob.setYwlb(gjzf_gr_zzbg_qc.getYwlb());
			ob.setYwlsh("");
			ob.setYwzy("");
			ob.setZhbh("");
			ob.setZxjgbm(gjzf_gr_zzbg_qc.getZxbm());
			try {
				DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", ob);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} catch (Exception e) {
			trace = "<font color='red'>缴存人状态变更审批查询:" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人状态变更原因清册查询", fwdm = "jcrbgztyyqccx", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgztyyqccx.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgztyyqccx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgztyyqccx(@RequestBody Jcdwjcrztbg_mx  gjzf_dw_mx) {
		String trace = "";
		int count=0;
		DataResult t = new DataResult();
		List <Jcdwjcrztbg_mx> l=new ArrayList<Jcdwjcrztbg_mx>();
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcrztbg_jcrbgztyyqccx",
					gjzf_dw_mx,gjzf_dw_mx.getSize(),gjzf_dw_mx.getPage());
			count = lst.size()>0 ? lst.get(0).getDefInt("count") : 0;
			double grjcjs  = lst.size() > 0 ? lst.get(0).getDefDouble("grjcjshj"):0;
			double dwyjce  = lst.size() > 0 ? lst.get(0).getDefDouble("dwyjcehj"):0;
			double gryjce  = lst.size() > 0 ? lst.get(0).getDefDouble("gryjcehj"):0;
			double yjce  = lst.size() > 0 ? lst.get(0).getDefDouble("yjcehj"):0;
			double grzhye  = lst.size() > 0 ? lst.get(0).getDefDouble("grzhyehj"):0;
			t.setTotalcount(count);
		
			for (Row row : lst) {
				Jcdwjcrztbg_mx cb = new Jcdwjcrztbg_mx();
				cb.setId(row.getTrimString("id"));
				cb.setDwzh(row.getTrimString("dwzh"));
				cb.setDwbh(row.getTrimString("dwbh"));
				cb.setGrbh(row.getTrimString("grbh"));
				cb.setGrzh(row.getTrimString("grzh"));
				cb.setXingming(row.getTrimString("xingming"));
				cb.setZjhm(row.getTrimString("zjhm"));
				cb.setGrjcjs(row.getDefDouble("grjcjs"));
				cb.setYjce(row.getDefDouble("yjce"));
				cb.setDwyjce(row.getDefDouble("dwyjce"));
				cb.setGryjce(row.getDefDouble("gryjce"));
				cb.setGrzhye(row.getDefDouble("grzhye"));
				cb.setBgyy(row.getTrimString("bgyy"));
				if(!row.getTrimString("bgrq").trim().equals("")){
					cb.setJzrq(row.getTrimString("bgrq").substring(0,10));
				}else{
					cb.setJzrq(row.getTrimString("bgrq"));
				}
				cb.setYwlsh(row.getTrimString("ywlsh"));
				
				cb.setGrjcjshj(grjcjs);
				cb.setDwyjcehj(dwyjce);
				cb.setGryjcehj(gryjce);
				cb.setYjcehj(yjce);
				cb.setGrzhyehj(grzhye);
				l.add(cb);
			}
			
				t.setData(l);
			
				OptlogBean bean = new OptlogBean();
				bean.setBlqd("zxb");
				bean.setCzfl("019902");
				bean.setJgbm(gjzf_dw_mx.getJgbm());
				bean.setKhbh(gjzf_dw_mx.getKhbh());
				bean.setMsg("");
				bean.setUserid(gjzf_dw_mx.getUserid());
				bean.setYwczbs (count+"");
				bean.setYwczje(0);
				bean.setYwlb(gjzf_dw_mx.getYwlb());
				bean.setYwfl(gjzf_dw_mx.getYwfl());
				bean.setYwlsh(gjzf_dw_mx.getYwlsh());
				bean.setYwzy("封存原因变更查询清册");
				bean.setZhbh(gjzf_dw_mx.getZhbh()+"");
				bean.setZxjgbm(gjzf_dw_mx.getZxbm());
			try {
				DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", bean);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			trace = "<font color='red'>封存原因变更查询清册：" + e.getMessage() + "</font>";
			log.error(trace);
	}
		return t;
}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人封存变更", fwdm = "jcrfcbg", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrfcbg.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrfcbg.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrfcbg(@RequestBody Jcdwjcrztbg gjzf_gr_zzbg) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcrztbg_jcrfcbg",gjzf_gr_zzbg);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人封存变更:" + e.getMessage() + "</font>";
			log.error(trace);
			gjzf_gr_zzbg.setMsg(e.getMessage());
		} 
		t.setData(gjzf_gr_zzbg);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人变更确认", fwdm = "jcrbgqr", ywdm = "jcrztbg", fwdz = "jcrztbg/jcrbgqr.service")
	@RequestMapping(value = "ZTBG/jcrztbg/jcrbgqr.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrztbg_jcrbgqr(@RequestBody Jcdwjcrztbg gjzf_gr_zzbg) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcrztbg_jcrbgqr",gjzf_gr_zzbg);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人状态变更确认:" + e.getMessage() + "</font>";
			log.error(trace);
			gjzf_gr_zzbg.setMsg(e.getMessage());
		} 
		t.setData(gjzf_gr_zzbg);
		return t;
	}
}
