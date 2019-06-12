package com.shineyue.service.ztbg;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shineyue.bean.ztbg.Jcdwdwbmgl_gr;
import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.model.xtgl.OptlogBean;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_jcdwbmgl {
	private static final Log log = LogFactory.getLog(Ztbg_jcdwbmgl.class);		
	
private void index(Jcdwdwbmgl_gr cBean){
		
		OptlogBean bean = new OptlogBean();
		
		String blqd = "" + cBean.getBlqd() == null? "" : cBean.getBlqd() ;
		String czfl = "" ;
		String jgbm = "" + cBean.getJgbm() == null? "" : cBean.getJgbm() ;
		String khbh = "" + cBean.getKhbh() == null? "" : cBean.getKhbh() ;
		String msg = "" + cBean.getMsg() == null? "" : cBean.getMsg() ;
		long userid = 0 + cBean.getUserid() <= 0? 0 : cBean.getUserid();
		String ywczbs = "0";
		double ywczje = 0  ;
		String ywfl = "" + cBean.getYwfl() == null? "" : cBean.getYwfl() ;
		String ywlb = "" + cBean.getYwlb() == null? "" : cBean.getYwlb() ;
		String ywlsh = "" + cBean.getYwlsh() == null? "" : cBean.getYwlsh() ;
		String ywzy = "" ;
		String zhbh = "" + cBean.getZhbh() == null? "" : cBean.getZhbh() ;
		String zxjgbm = "" ;
		
		bean.setBlqd(blqd);
		bean.setCzfl(czfl);
		bean.setJgbm(jgbm);
		bean.setKhbh(khbh);
		bean.setMsg(msg);
		bean.setUserid((int)userid);
		bean.setYwczbs(ywczbs);
		bean.setYwczje(ywczje);
		bean.setYwfl(ywfl);
		bean.setYwlb(ywlb);
		bean.setYwlsh(ywlsh);
		bean.setYwzy(ywzy);
		bean.setZhbh(zhbh);
		bean.setZxjgbm(zxjgbm);
		try {
			DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", bean);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("<font color='red'> 查询日志增加操作失败"
			+ e.getMessage() + "</font>");
		}
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位部门增加", fwdm = "bmbmszadd", ywdm = "jcdwbmgl", fwdz = "jcdwbmgl/bmbmszadd.service")
	@RequestMapping(value = "ZTBG/jcdwbmgl/bmbmszadd.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwbmgl_bmbmszadd(@RequestBody Jcdwdwbmgl_gr cr_gr) {
		String trace = "";
		DataResult t=new DataResult();
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwbmgl_bmbmszadd",cr_gr);
		} catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>部门编码设置增加：" + e.getMessage()+ "</font>";
			log.error(trace);
			cr_gr.setMsg(trace);
		}
		t.setData(cr_gr);
		return t;
}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位部门撤销", fwdm = "bmbmszdel", ywdm = "jcdwbmgl", fwdz = "jcdwbmgl/bmbmszdel.service")
	@RequestMapping(value = "ZTBG/jcdwbmgl/bmbmszdel.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwbmgl_bmbmszdel(@RequestBody Jcdwdwbmgl_gr cr_gr) {
		String trace = "";
		DataResult t=new DataResult();
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwbmgl_bmbmszdel",cr_gr);
		} catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>部门编码设置删除：" + e.getMessage()+ "</font>";
			log.error(trace);
			cr_gr.setMsg(trace);
		}
		t.setData(cr_gr);
		return t;
}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位部门修改", fwdm = "bmbmszchg", ywdm = "jcdwbmgl", fwdz = "jcdwbmgl/bmbmszchg.service")
	@RequestMapping(value = "ZTBG/jcdwbmgl/bmbmszchg.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwbmgl_bmbmszchg(@RequestBody Jcdwdwbmgl_gr cr_gr) {
		String trace = "";
		DataResult t=new DataResult();
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwbmgl_bmbmszchg",cr_gr);
		} catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>部门编码设置修改：" + e.getMessage()+ "</font>";
			log.error(trace);
			cr_gr.setMsg(trace);
		}
		t.setData(cr_gr);
		return t;
}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位部门清册查询", fwdm = "bmbmszqccx", ywdm = "jcdwbmgl", fwdz = "jcdwbmgl/bmbmszqccx.service")
	@RequestMapping(value = "ZTBG/jcdwbmgl/bmbmszqccx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwbmgl_bmbmszqccx(@RequestBody Jcdwdwbmgl_gr cr_gr) {
		String trace = "";
        int count = 0;
		DataResult t = new DataResult();
		List<Jcdwdwbmgl_gr> l=new ArrayList<Jcdwdwbmgl_gr>();
		List<Row> lst;
		try {
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwbmgl_bmbmszqccx",cr_gr);
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
            t.setTotalcount(count);
			
				for(Row row : lst){
					Jcdwdwbmgl_gr bean=new Jcdwdwbmgl_gr();
					bean.setGrzh(row.getTrimString("grzh"));
					bean.setXingming(row.getTrimString("xingming"));
					bean.setZjhm(row.getTrimString("zjhm"));
					bean.setSzbm(row.getTrimString("szbm"));
					bean.setYjce(row.getDefDouble("yjce"));
					bean.setDwyjce(row.getDefDouble("dwyjce"));
					bean.setGryjce(row.getDefDouble("gryjce"));
					bean.setGrzhye(row.getDefDouble("grzhye"));
					bean.setGrzhzt(row.getTrimString("grzhzt"));
					bean.setSzbmbm(row.getTrimString("szbmbm"));
					bean.setTotalcount(count);
					l.add(bean);
				}
			
			this.index(cr_gr);     
			t.setTotalcount(count);
			t.setData(l);
			
		}catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>缴存人部门调动查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位部门调动存盘", fwdm = "bmbmddadd", ywdm = "jcdwbmgl", fwdz = "jcdwbmgl/bmbmddadd.service")
	@RequestMapping(value = "ZTBG/jcdwbmgl/bmbmddadd.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwbmgl_bmbmddadd(@RequestBody Jcdwdwbmgl_gr cr_gr) {
		String trace = "";
		DataResult t=new DataResult();
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwbmgl_bmbmddadd",cr_gr);
		} catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>缴存人部门调动存盘：" + e.getMessage()+ "</font>";
			log.error(trace);
			cr_gr.setMsg(trace);
		}
		t.setData(cr_gr);
		return t;
}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位部门调动查询", fwdm = "bmbmddcx", ywdm = "jcdwbmgl", fwdz = "jcdwbmgl/bmbmddcx.service")
	@RequestMapping(value = "ZTBG/jcdwbmgl/bmbmddcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwbmgl_bmbmddcx(@RequestBody Jcdwdwbmgl_gr cr_gr) {
		String trace = "";
        int count = 0;
		DataResult t = new DataResult();
		List<Jcdwdwbmgl_gr> l=new ArrayList<Jcdwdwbmgl_gr>();
		List<Row> lst;
		try {
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwbmgl_bmbmddcx",cr_gr);
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
            t.setTotalcount(count);
			
				for(Row row : lst){
					Jcdwdwbmgl_gr bean=new Jcdwdwbmgl_gr();
					bean.setZcbmbm(row.getTrimString("zcbmbm"));
					bean.setZcbmmc(row.getTrimString("zcbmmc"));
					bean.setZrbmbm(row.getTrimString("zrbmbm"));
					bean.setZrbmmc(row.getTrimString("zrbmmc"));
					bean.setGrzh(row.getTrimString("grzh"));
					bean.setXingming(row.getTrimString("xingming"));
					bean.setZjhm(row.getTrimString("zjhm"));
					bean.setYjce(row.getDefDouble("yjce"));
					bean.setDwyjce(row.getDefDouble("dwyjce"));
					bean.setGryjce(row.getDefDouble("gryjce"));
					bean.setGrzhye(row.getDefDouble("grzhye"));
					bean.setGrzhzt(row.getTrimString("grzhzt"));
					bean.setTotalcount(count);
					l.add(bean);
				}
			
			this.index(cr_gr);     
			t.setTotalcount(count);
			t.setData(l);
			
		}catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>缴存人部门调动查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位部门设置查询", fwdm = "bmbmszcx", ywdm = "jcdwbmgl", fwdz = "jcdwbmgl/bmbmszcx.service")
	@RequestMapping(value = "ZTBG/jcdwbmgl/bmbmszcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwbmgl_bmbmszcx(@RequestBody Jcdwdwbmgl_gr cr_gr) {
		String trace = "";
        int count = 0;
		DataResult t = new DataResult();
		List<Jcdwdwbmgl_gr> l=new ArrayList<Jcdwdwbmgl_gr>();
		List<Row> lst;
		try {
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwbmgl_bmbmszcx",cr_gr);
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
            t.setTotalcount(count);
			
				for(Row row : lst){
					Jcdwdwbmgl_gr bean=new Jcdwdwbmgl_gr();
					bean.setSzbmbm(row.getTrimString("bm"));
					bean.setSzbm(row.getTrimString("mc"));
					bean.setDwzh(row.getTrimString("dwzh"));
					bean.setTotalcount(count);
					l.add(bean);
				}
			
			this.index(cr_gr);     //jiaye 2016-11-21
			t.setTotalcount(count);
			t.setData(l);
			
		}catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>部门编码设置查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		
		return t;
	}
	
}

