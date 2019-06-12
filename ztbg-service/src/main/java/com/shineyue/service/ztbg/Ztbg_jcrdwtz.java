package com.shineyue.service.ztbg;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shineyue.bean.ztbg.Jcdw_jcrdwtzBean;
import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.bean.ztbg.Jcdwjcrztbg;
import com.shineyue.bean.ztbg.Jcdwjcrztbg_qc;
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.model.xtgl.OptlogBean;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_jcrdwtz {
	private static final Log log = LogFactory.getLog(Ztbg_jcrdwtz.class);		
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人单位调整清册", fwdm = "jcrdwtzqccx", ywdm = "jcrdwtz", fwdz = "jcrdwtz/jcrdwtzqccx.service")
	@RequestMapping(value = "ZTBG/jcrdwtz/jcrdwtzqccx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrdwtz_jcrdwtzqccx(@RequestBody Jcdwjcrztbg gjzf_gr_zzbg) {
		String trace = "";
		DataResult t = new DataResult();
		int count = 0;
		List<Jcdwjcrztbg> l=new ArrayList<Jcdwjcrztbg>();
		try {
			List<Row> lst=DbMethod.makeDbSingleton().Open("Ztbg_Jcrdwtz_jcrdwtzqccx",gjzf_gr_zzbg,
					gjzf_gr_zzbg.getSize(),gjzf_gr_zzbg.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			for (Row row : lst) {
				Jcdwjcrztbg bean = new Jcdwjcrztbg();
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setGrbh(row.getTrimString("grbh"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setZcdwbh(row.getTrimString("zcdwbh"));
				bean.setZcdwmc(row.getTrimString("zcdwmc"));
				bean.setZrdwbh(row.getTrimString("zydwbh"));
				bean.setZrdwmc(row.getTrimString("zydwmc"));
				bean.setId(row.getTrimString("id"));
				bean.setBpmid(row.getDefLong("bpmid"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setBgyy(row.getTrimString("bgyy"));
				bean.setGrzhye(row.getDefDouble("grzhye"));
				l.add(bean);
			}
			t.setData(l);
			OptlogBean ob = new OptlogBean();
			ob.setBlqd("zxb");
			ob.setCzfl(" ");
			ob.setJgbm(gjzf_gr_zzbg.getJgbm());
			ob.setKhbh(gjzf_gr_zzbg.getKhbh());
			ob.setMsg("");
			ob.setUserid(gjzf_gr_zzbg.getUserid());
			ob.setYwczbs(count+"");
			ob.setYwczje(1);
			ob.setYwfl(gjzf_gr_zzbg.getYwfl());
			ob.setYwlb(gjzf_gr_zzbg.getYwlb());
			ob.setYwlsh(gjzf_gr_zzbg.getYwlsh());
			ob.setYwzy("缴存人单位调整清册查询");
			ob.setZhbh("");
			ob.setZxjgbm(gjzf_gr_zzbg.getZxbm());
			try {
				DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", ob);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}catch (Exception e) {
			trace = "<font color='red'> 缴存人单位调整清册查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		}
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人单位调整录入", fwdm = "jcrdwtzlr", ywdm = "jcrdwtz", fwdz = "jcrdwtz/jcrdwtzlr.service")
	@RequestMapping(value = "ZTBG/jcrdwtz/jcrdwtzlr.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrdwtz_jcrdwtzlr(@RequestBody Jcdwjcrztbg gjzf_gr_zzbg) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcrdwtz_jcrdwtzlr",gjzf_gr_zzbg);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人单位调整增加:" + e.getMessage() + "</font>";
			log.error(trace);
			gjzf_gr_zzbg.setMsg(e.getMessage());
		} 
		t.setData(gjzf_gr_zzbg);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人单位调整删除", fwdm = "jcrdwtzsc", ywdm = "jcrdwtz", fwdz = "jcrdwtz/jcrdwtzsc.service")
	@RequestMapping(value = "ZTBG/jcrdwtz/jcrdwtzsc.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrdwtz_jcrdwtzsc(@RequestBody Jcdwjcrztbg_qc gjzf_gr_zzbg_qc) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcrdwtz_jcrdwtzsc",gjzf_gr_zzbg_qc);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人单位调整册删除:" + e.getMessage() + "</font>";
			log.error(trace);
			gjzf_gr_zzbg_qc.setMsg(e.getMessage());
		} 
		t.setData(gjzf_gr_zzbg_qc);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人单位调整打印", fwdm = "jcrdwtzdy", ywdm = "jcrdwtz", fwdz = "jcrdwtz/jcrdwtzdy.service")
	@RequestMapping(value = "ZTBG/jcrdwtz/jcrdwtzdy.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrdwtz_jcrdwtzdy(@RequestBody Jcdw_jcrdwtzBean jcrdwtzBean) {
		DataResult t=new DataResult();
		String trace = "";
		List<Row> lst;
		List<Row> lst2;
		List<Jcdw_jcrdwtzBean> l=new ArrayList<Jcdw_jcrdwtzBean>();
		try{
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcrdwtz_prt",jcrdwtzBean);
			lst2 = DbMethod.makeDbSingleton().Open("Ztbg_Jcrdwtz_prtmx",jcrdwtzBean);
			for (Row row1 : lst2) {
				Row row=lst.get(0);
				Jcdw_jcrdwtzBean bean=new Jcdw_jcrdwtzBean();
				
				bean.setBgrq(row.getDateToString("bgrq"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setSpczy(row.getTrimString("spczy"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setJbrxm(row.getTrimString("jbrxm"));
				bean.setJbrsjhm(row.getTrimString("jbrsjhm"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setRs(row.getDefInt("rs"));
				bean.setZcjce(row.getDefDouble("zcjce"));
				bean.setZydwzh(row.getTrimString("zydwzh"));
				bean.setZydwmc(row.getTrimString("zydwmc"));
				bean.setLrczy(row.getTrimString("lrczy"));
				
				bean.setXingming(row1.getTrimString("xingming"));
				bean.setZjhm(row1.getTrimString("zjhm"));
				bean.setZyje(row1.getDefDouble("zyje"));
				
				l.add(bean);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人单位调整变更凭条打印方法失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人单位调整导入", fwdm = "jcrdwtzdr", ywdm = "jcrdwtz", fwdz = "jcrdwtz/jcrdwtzdr.service")
	@RequestMapping(value = "ZTBG/jcrdwtz/jcrdwtzdr.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrdwtz_jcrdwtzdr(@RequestBody Jcdwjcrztbg gjzf_gr_zzbg) {
		String trace = "";
		DataResult t = new DataResult();
		List<Jcdwjcrztbg> l=new ArrayList<Jcdwjcrztbg>();
		try {
			int count = 0;
			List<Row> list = DbMethod.makeDbSingleton().Open("Ztbg_Jcrdwtz_jcrdwtzdr", gjzf_gr_zzbg);
			if (list.size() == 0) {
				Jcdwjcrztbg cb = new Jcdwjcrztbg();
				cb.setMsg(gjzf_gr_zzbg.getMsg());
				cb.setRet(gjzf_gr_zzbg.getRet());
				l.add(cb);
			} else {
				for(Row row : list){
					Jcdwjcrztbg bean = new Jcdwjcrztbg();
					bean.setGrzh(row.getTrimString("grzh"));
				    bean.setXingming(row.getTrimString("xingming"));
					bean.setMsg(row.getTrimString("msg").trim());
					bean.setCount(count);
					bean.setRet(gjzf_gr_zzbg.getRet());
					bean.setBgyd(gjzf_gr_zzbg.getMsg());//cun
					l.add(bean);
				}
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'> 缴存人单位调整导入：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人单位调整审批查询", fwdm = "jcrdwtzspcx", ywdm = "jcrdwtz", fwdz = "jcrdwtz/jcrdwtzspcx.service")
	@RequestMapping(value = "ZTBG/jcrdwtz/jcrdwtzspcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcrdwtz_jcrdwtzspcx(@RequestBody Jcdwjcrztbg gjzf_gr_zzbg) {
		    String trace = "";
		    DataResult t = new DataResult();
		    int count = 0;
		    List<Jcdwjcrztbg> l=new ArrayList<Jcdwjcrztbg>();
		    try {
		      List<Row> lst=DbMethod.makeDbSingleton().Open("Ztbg_Jcrdwtz_jcrdwtzspcx",gjzf_gr_zzbg,
		          gjzf_gr_zzbg.getSize(),gjzf_gr_zzbg.getPage());
		      count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
		      t.setTotalcount(count);
		      for (Row row : lst) {
		    	  Jcdwjcrztbg bean = new Jcdwjcrztbg();
		        bean.setBpmid(row.getDefLong("bpmid"));
		        bean.setYwlsh(row.getTrimString("ywlsh"));
		        bean.setDwzh(row.getTrimString("dwzh"));
		        bean.setXingming(row.getTrimString("xingming"));
		        bean.setGrbh(row.getTrimString("grbh"));
		        bean.setZjhm(row.getTrimString("zjhm"));
		        bean.setZcdwbh(row.getTrimString("zcdwbh"));
		        bean.setZcdwmc(row.getTrimString("zcdwmc"));
		        bean.setZrdwbh(row.getTrimString("zydwbh"));
		        bean.setZrdwmc(row.getTrimString("zydwmc"));
		        bean.setId(row.getTrimString("id"));
		        bean.setDwbh(row.getTrimString("dwbh"));
		        bean.setBgyy(row.getString("bgyy"));
		        bean.setBgyd(row.getTrimString("bgyd"));
		        bean.setZydwzh(row.getTrimString("zydwzh"));
		        bean.setXdwbh(row.getTrimString("xdwbh"));
		        l.add(bean);
		      }
		      t.setData(l);
		      OptlogBean ob = new OptlogBean();
		      ob.setBlqd("zxb");
		      ob.setCzfl(" ");
		      ob.setJgbm(gjzf_gr_zzbg.getJgbm());
		      ob.setKhbh(gjzf_gr_zzbg.getKhbh());
		      ob.setMsg("");
		      ob.setUserid(gjzf_gr_zzbg.getUserid());
		      ob.setYwczbs(count+"");
		      ob.setYwczje(1);
		      ob.setYwfl(gjzf_gr_zzbg.getYwfl());
		      ob.setYwlb(gjzf_gr_zzbg.getYwlb());
		      ob.setYwlsh(gjzf_gr_zzbg.getYwlsh());
		      ob.setYwzy("缴存人单位调整审批清册查询");
		      ob.setZhbh("");
		      ob.setZxjgbm(gjzf_gr_zzbg.getZxbm());
		      try {
		        DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", ob);
		      } catch (Exception e) {
		        // TODO: handle exception
		        e.printStackTrace();
		      }
		    }catch (Exception e) {
		      trace = "<font color='red'> 缴存人单位调整审批清册查询失败：" + e.getMessage()
		          + "</font>";
		      log.error(trace);
		    }
		    return t;
		  }
}

