package com.shineyue.service.ztbg;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.bean.ztbg.Jcdwhjhdbean;
import com.shineyue.bean.ztbg.Jcdwhjhddy;
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.model.xtgl.OptlogBean;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_jcdwjcrbj {
	private static final Log log = LogFactory.getLog(Ztbg_jcdwjcrbj.class);		
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴变更次数", fwdm = "bgxxcs", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/bgxxcs.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/bgxxcs.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_bgxxcs(@RequestBody Jcdwhjbean gjzf_dw_jcbg) {
		DataResult t=new DataResult();
		String trace = "";
		Jcdwhjbean cb = new  Jcdwhjbean();
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrbj_bgxxcs",gjzf_dw_jcbg);
			List <Jcdwhjbean> l=new ArrayList<Jcdwhjbean>();
				if (lst.size() > 0) {
					Row row = lst.get(0);
					cb.setCs(row.getString("cs"));
		
					l.add(cb);
				}
				t.setData(l);
				t.setTotalcount(lst.size());
			
		} catch (Exception e) {
			trace = "<font color='red'>最大次数:" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴清册录入", fwdm = "jcrbjqcadd", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/jcrbjqcadd.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/jcrbjqcadd.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjqcadd(@RequestBody Jcdwhjhdbean cr_dwBean) {
		String trace = "";
		DataResult t = new DataResult();
	
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrbj_jcrbjqcadd",cr_dwBean);
			
		}catch (Exception e) {
			trace = e.getMessage();
			cr_dwBean.setMsg(trace);
			cr_dwBean.setRet("99");
			log.error(e.getMessage());
		}
		t.setData(cr_dwBean);
		return t;
	}
	private void index(String blqd,String czfl,String jgbm,String khbh,String msg,int userid,String ywczbs,
			double ywczje,String ywfl,String ywlb,String ywlsh,String ywzy,String zhbh,String zxjgbm){
		OptlogBean bean = new OptlogBean();		
		bean.setBlqd(blqd);
		bean.setCzfl(czfl);
		bean.setJgbm(jgbm);
		bean.setKhbh(khbh);
		bean.setMsg(msg);
		bean.setUserid(userid);
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
		}
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴清册查询", fwdm = "jcrbjqccx", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/jcrbjqccx.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/jcrbjqccx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjqccx(@RequestBody Jcdwhjhdbean cr_dwBean) {
		String trace = "";
		DataResult t = new DataResult();
		int count = 0;
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> lst=DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrbj_jcrbjqccx",cr_dwBean,cr_dwBean.getSize(),cr_dwBean.getPage());
			String blqd = cr_dwBean.getBlqd();
			String czfl = " ";
			String jgbm = cr_dwBean.getJgbm();
			String khbh = cr_dwBean.getKhbh();
			String msg = "";
			int userid = cr_dwBean.getUserid();
			String ywczbs = "1";
			double ywczje = 0.0;
			String ywfl = cr_dwBean.getYwfl();
			String ywlb = cr_dwBean.getYwlb();
			String ywlsh = cr_dwBean.getYwlsh();
			String zhbh = cr_dwBean.getZhbh();
			String ywzy = "缴存人补缴清册查询";
			String zxjgbm = cr_dwBean.getZxbm();
			index( blqd, czfl, jgbm, khbh, msg, userid, ywczbs, ywczje, ywfl, ywlb, ywlsh, ywzy, zhbh, zxjgbm);
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			double dwbjjehj=lst.size() > 0 ? lst.get(0).getDefDouble("dwbjjehj") : 0;
			double grbjjehj=lst.size() > 0 ? lst.get(0).getDefDouble("grbjjehj") : 0;
			double bjjehj=lst.size() > 0 ? lst.get(0).getDefDouble("bjjehj") : 0;
			for (Row row : lst) {
				Jcdwhjhdbean bean=new Jcdwhjhdbean();
				bean.setIds(row.getTrimString("id"));
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setBjyy(row.getTrimString("bjyy"));
				bean.setDwbjje(row.getDefDouble("dwbjje"));
				bean.setGrbjje(row.getDefDouble("grbjje"));
				bean.setBjje(row.getTrimString("bjje"));
				bean.setHbjksny(row.getTrimString("hbjksny"));
				bean.setHbjjsny(row.getTrimString("hbjjsny"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setLrsj(row.getDateToString("lrrq"));
				bean.setLrczyid(row.getTrimString("lrczyid"));
				bean.setLrczy(row.getTrimString("lrczy"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setDwbh(row.getTrimString("dwbh"));
				bean.setJgbm(row.getTrimString("jgbm"));
				bean.setBpmids(row.getTrimString("bpmid"));
				bean.setYhsjfsbz(row.getTrimString("yhsjfsbz"));
				bean.setBjcs(row.getDefInt("bjcs"));
				bean.setBjrs(count);
				bean.setDwbjjehj(dwbjjehj);
				bean.setGrbjjehj(grbjjehj);
				//String v_bjjehj = bjjehj+"";
				bean.setBjjehj(bjjehj);
				l.add(bean);
			}
			t.setData(l);
		}catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>缴存人补缴清册查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		}
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴清册删除", fwdm = "jcrbjqcdel", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/jcrbjqcdel.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/jcrbjqcdel.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjqcdel(@RequestBody Jcdwhjhdbean cr_dwBean) {
		String trace = "";
		DataResult t = new DataResult();
	
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrbj_jcrbjqcdel",cr_dwBean);
			
		}catch (Exception e) {
			trace = e.getMessage();
			cr_dwBean.setMsg(trace);
			log.error(e.getMessage());
		}
		t.setData(cr_dwBean);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴凭条打印", fwdm = "jcrbjptdy", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/jcrbjptdy.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/jcrbjptdy.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjptdy(@RequestBody Jcdwhjhddy bean15) {
		DataResult t=new DataResult();
		String trace = "";
		List<Row> lst;
		List<Row> lst2;
		List<Jcdwhjhddy> l=new ArrayList<Jcdwhjhddy>();

		String blqd = "" + bean15.getBlqd() == null? "" : bean15.getBlqd() ;
		String czfl = "010205";
		String jgbm = "" + bean15.getJgbm() == null? "" : bean15.getJgbm() ;
		String khbh = "" + bean15.getKhbh() == null? "" : bean15.getKhbh() ;
		String msg = " ";
		int userid = 0 + bean15.getUserid() <= 0? 0 : bean15.getUserid();
		String ywczbs = "0" ;
		double ywczje = 0 ;
		String ywfl = "" + bean15.getYwfl() == null? "" : bean15.getYwfl() ;
		String ywlb = "" + bean15.getYwlb() == null? "" : bean15.getYwlb() ;
		String ywlsh = "" + bean15.getYwlsh() == null? "" : bean15.getYwlsh() ;
		String ywzy = "" + bean15.getYwzy() == null? "" : bean15.getYwzy() ;
		String zhbh = "" + bean15.getZhbh() == null? "" : bean15.getZhbh() ;
		String zxjgbm = "" + bean15.getZxbm() == null? "" : bean15.getZxbm() ;

		OptlogBean bean1 = new OptlogBean();
			
		bean1.setBlqd(blqd);
		bean1.setCzfl(czfl);
		bean1.setJgbm(jgbm);
		bean1.setKhbh(khbh);
		bean1.setMsg(msg);
		bean1.setUserid(userid);
		bean1.setYwczbs(ywczbs);
		bean1.setYwczje(ywczje);
		bean1.setYwfl(ywfl);
		bean1.setYwlb(ywlb);
		bean1.setYwlsh(ywlsh);
		bean1.setYwzy("缴存人补缴凭条打印");
		bean1.setZhbh(zhbh);
		bean1.setZxjgbm(zxjgbm);
		try {
			DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", bean1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try{
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrbj_jcrbjptdy",bean15);
			
			
			lst2 = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrbj_jcrbjptdy2",bean15);
			for (Row row : lst2) {
				Jcdwhjhddy bean=new Jcdwhjhddy();
				Row row1=lst.get(0);
				bean.setYwrq(row1.getDateToString("ywrq"));
				bean.setYwlsh(row1.getDefString("ywlsh"));
				bean.setDwmc(row1.getDefString("dwmc"));
				bean.setDwzh(row1.getDefString("dwzh"));
				bean.setJbrxm(row1.getDefString("jbrxm"));
				bean.setJbrsjhm(row1.getDefString("jbrsjhm"));
				bean.setDwjcrs(Integer.parseInt(row1.getDefString("dwjcrs")));
				bean.setYjcze(row1.getDefDouble("yjcze"));
				bean.setBjrs(Integer.parseInt(row1.getDefString("fsrs")));
				bean.setBjje(row1.getDefDouble("fse"));
				bean.setKsyd(row1.getDefString("hbjny"));//hbjny	
				
				bean.setXingming(row.getDefString("xingming"));
				bean.setZjhm(row.getDefString("zjhm"));
				bean.setBj(row.getDefDouble("bjje"));
				bean.setJcyd(row.getDefString("qzny"));
				bean.setSpczy(row1.getDefString("spczy"));
				bean.setLrczy(row1.getDefString("lrczy"));
				l.add(bean);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人补缴凭条打印失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴导入", fwdm = "jcrbjdr", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/jcrbjdr.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/jcrbjdr.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjdr(@RequestBody Jcdwhjhdbean Cr_dwBean) {
		String trace = "";
		int count=0;
		DataResult t = new DataResult();
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
//			int count = 0;
			List<Row> list = DbMethod.makeDbSingleton().Open(
					"Ztbg_Jcdwjcrbj_jcrbjdr", Cr_dwBean);
			if (list.size() == 0) {
				Jcdwhjhdbean cb = new Jcdwhjhdbean();
				cb.setMsg(Cr_dwBean.getMsg());
				cb.setRet(Cr_dwBean.getRet());
				l.add(cb);
			} else {
				for(Row row : list){
					Jcdwhjhdbean bean1 = new Jcdwhjhdbean();
					bean1.setGrzh(row.getTrimString("grzh"));
				    bean1.setXingming(row.getTrimString("xingming"));
					bean1.setMsg(row.getTrimString("msg").trim());
					bean1.setCount(count);
					bean1.setRet(Cr_dwBean.getRet());
					l.add(bean1);
				}
			}
			t.setData(l);
			t.setMsg(Cr_dwBean.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'> 缴存人补缴清册导入：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴全删", fwdm = "jcrbjdelall", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/jcrbjdelall.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/jcrbjdelall.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjdelall(@RequestBody Jcdwhjhdbean cr_dwBean) {
		String trace = "";
		DataResult t = new DataResult();
	
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrbj_jcrbjdelall",cr_dwBean);
			
		}catch (Exception e) {
			trace = e.getMessage();
			cr_dwBean.setMsg(trace);
			log.error(e.getMessage());
		}
		t.setData(cr_dwBean);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴批量查询", fwdm = "jcrbjqcplcx", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/jcrbjqcplcx.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/jcrbjqcplcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjqcplcx(@RequestBody  Jcdwhjhdbean cr_dwBean) {
		String trace = "";
		int count=0;
		DataResult t = new DataResult();
		List <Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrbj_jcrbjqcplcx",
					cr_dwBean,cr_dwBean.getSize(),cr_dwBean.getPage());
			String blqd = cr_dwBean.getBlqd();
			String czfl = "010208";
			String jgbm = cr_dwBean.getJgbm();
			String khbh = cr_dwBean.getKhbh();
			String msg = "";
			int userid = cr_dwBean.getUserid();
			String ywczbs = "0";
			double ywczje = 0.0;
			String ywfl = cr_dwBean.getYwfl();
			String ywlb = cr_dwBean.getYwlb();
			String ywlsh = cr_dwBean.getYwlsh();
			String zhbh = cr_dwBean.getZhbh();
			String ywzy = "缴存人补缴批量录入清册查询";
			String zxjgbm = cr_dwBean.getZxbm();
			index( blqd, czfl, jgbm, khbh, msg, userid, ywczbs, ywczje, ywfl, ywlb, ywlsh, ywzy, zhbh, zxjgbm);
			count = lst.size()>0 ? lst.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			double dwyjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("dwyjcehj") : 0;
			double gryjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("gryjcehj") : 0;
			double yjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("yjcehj") : 0;
			int i = 0;
			for (Row row : lst) {
				Jcdwhjhdbean cb = new Jcdwhjhdbean();
				cb.setIds(row.getTrimString("id"));
				cb.setGrzh(row.getTrimString("grzh"));
				cb.setXingming(row.getTrimString("xingming"));
				cb.setZjhm(row.getTrimString("zjhm"));
				cb.setDwyjce(row.getDefDouble("dwyjce"));
				cb.setGryjce(row.getDefDouble("Gryjce"));
				cb.setYjce(row.getDefDouble("yjce"));
				cb.setDwyjcehj(dwyjcehj);
				cb.setGryjcehj(gryjcehj);
				cb.setYjcehj(yjcehj);
				l.add(cb);
				 
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>缴存人补缴批量录入清册查询失败：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴批量存盘", fwdm = "jcrbjplcp", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/jcrbjplcp.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/jcrbjplcp.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjplcp(@RequestBody Jcdwhjhdbean cr_dwBean) {
		String trace = "";
		DataResult t = new DataResult();
	
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrbj_jcrbjplcp",cr_dwBean);
			
		}catch (Exception e) {
			trace = e.getMessage();
			cr_dwBean.setMsg(trace);
			log.error(e.getMessage());
		}
		t.setData(cr_dwBean);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人补缴审批清册查询", fwdm = "jcrbjspqccx", ywdm = "jcdwjcrbj", fwdz = "jcdwjcrbj/jcrbjspqccx.service")
	@RequestMapping(value = "ZTBG/jcdwjcrbj/jcrbjspqccx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjspqccx(@RequestBody Jcdwhjhdbean cr_dwBean) {
		String trace = "";
		DataResult t = new DataResult();
		int count = 0;
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> lst=DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrbj_jcrbjspqccx",cr_dwBean,cr_dwBean.getSize(),cr_dwBean.getPage());
			String blqd = cr_dwBean.getBlqd();
			String czfl = " ";
			String jgbm = cr_dwBean.getJgbm();
			String khbh = cr_dwBean.getKhbh();
			String msg = "";
			int userid = cr_dwBean.getUserid();
			String ywczbs = "1";
			double ywczje = 0.0;
			String ywfl = cr_dwBean.getYwfl();
			String ywlb = cr_dwBean.getYwlb();
			String ywlsh = cr_dwBean.getYwlsh();
			String zhbh = cr_dwBean.getZhbh();
			String ywzy = "缴存人补缴审批清册查询";
			String zxjgbm = cr_dwBean.getZxbm();
			index( blqd, czfl, jgbm, khbh, msg, userid, ywczbs, ywczje, ywfl, ywlb, ywlsh, ywzy, zhbh, zxjgbm);
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			System.out.println("++++++++++++++++++++++++++++-count"+count);
			t.setTotalcount(count);
			double dwbjjehj=lst.size() > 0 ? lst.get(0).getDefDouble("dwbjjehj") : 0;
			double grbjjehj=lst.size() > 0 ? lst.get(0).getDefDouble("grbjjehj") : 0;
			double bjjehj=lst.size() > 0 ? lst.get(0).getDefDouble("bjjehj") : 0;
			for (Row row : lst) {
				Jcdwhjhdbean bean=new Jcdwhjhdbean();
				bean.setIds(row.getTrimString("id"));
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setBjyy(row.getTrimString("bjyy"));
				bean.setDwbjje(row.getDefDouble("dwbjje"));
				bean.setGrbjje(row.getDefDouble("grbjje"));
				bean.setBjje(row.getTrimString("bjje"));
				bean.setHbjksny(row.getTrimString("hbjksny"));
				bean.setHbjjsny(row.getTrimString("hbjjsny"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setLrsj(row.getDateToString("lrrq"));
				bean.setLrczyid(row.getTrimString("lrczyid"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setDwbh(row.getTrimString("dwbh"));
				bean.setJgbm(row.getTrimString("jgbm"));
                bean.setDwzh(row.getTrimString("dwzh"));
                bean.setDwxz(row.getTrimString("cqdwzh"));
                bean.setCqdwmc(row.getTrimString("cqdwmc"));
                bean.setBpmids(row.getTrimString("bpmid"));
                bean.setBjrs(count);
                bean.setDwbjjehj(dwbjjehj);
				bean.setGrbjjehj(grbjjehj);
				bean.setBjjehj(bjjehj);
				l.add(bean);
			}

			t.setData(l);
		}catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>缴存人补缴审批查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		}
		return t;
	}
	
	@HttpServiceInfo(qddm="ZTBG",fwname="缴存人补缴清册保存",fwdm="jcrbjqc_rz",ywdm="jcdwjcrbj",fwdz="jcdwjcrbj/jcrbjqc_rz.service")
	@RequestMapping(value="ZTBG/jcdwjcrbj/jcrbjqc_rz.service",method=RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_jcrbjqc_Rz(@RequestBody Jcdwhjhdbean cr_dwBean) {
		String trace = "";
		DataResult t = new DataResult();
	
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrbj_jcrbjqc_Rz",cr_dwBean);
		}catch (Exception e) {
			e.printStackTrace();
			trace = e.getMessage();
			cr_dwBean.setMsg(trace);
			log.error(e.getMessage());
		}
		t.setData(cr_dwBean);
		return t;
	}	
	
	/**
	 * 获取单位付款账户信息
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm="ZTBG",fwname="单位付款账户信息",fwdm="dwfkzhcx",ywdm="jcdwjcrbj",fwdz="jcdwjcrbj/dwfkzhcx.service")
	@RequestMapping(value="ZTBG/jcdwjcrbj/dwfkzhcx.service",method=RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_Dwfkzh_Cx(@RequestBody Jcdwhjhdbean bean) {
		DataResult t = new DataResult();
		String trace = "";
		List<Jcdwhjhdbean> l = new ArrayList<Jcdwhjhdbean>();
		
		int count = 0;
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open(
					"Ztbg_Jcdwjcrbj_Dwfkzh_Cx", bean);
			count = lst.size() > 0 ? lst.size() : 0;
			t.setTotalcount(count);
			for (int i = 0;i<lst.size();i++) {
				Jcdwhjhdbean cb = new Jcdwhjhdbean();
				Row row = lst.get(i);
				cb.setFkmc(row.getTrimString("yhzhmc"));
				cb.setFkzh(row.getTrimString("yhzhhm"));
				cb.setSszh(row.getTrimString("sszh"));
				l.add(cb);
			}
			
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>获取单位付款账户信息失败：" + e.getMessage() + "</font>";
			log.error(trace);
		}
		return t;
	}
	
	/**
	 * 缴存单位汇（补）缴分配查询网厅
	 * @param cr_dwBean
	 * @return
	 */
	@HttpServiceInfo(qddm="ZTBG",fwname="缴存单位汇（补）缴分配查询网厅",fwdm="hjfpcx_wt",ywdm="jcdwjcrbj",fwdz="jcdwjcrbj/hjfpcx_wt.service")
	@RequestMapping(value="ZTBG/jcdwjcrbj/hjfpcx_wt.service",method=RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_hjfp_Cx_Wt(@RequestBody Jcdwhjhdbean cr_dwBean) {
		DataResult t=new DataResult();
		String trace = "";
		int count;
		List<Row> lst;
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try{
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrbj_hjfp_Cx_Wt",cr_dwBean);
			for (Row row : lst) {
				Jcdwhjhdbean bean=new Jcdwhjhdbean();
				bean.setJcyd(row.getTrimString("jcyd"));
				bean.setSyrs(row.getDefInt("syrs"));
				bean.setSyje1(row.getDefDouble("syje"));
				bean.setZjrs(row.getDefInt("zjrs"));
				bean.setZjje(row.getDefDouble("zjje"));
				bean.setJsrs(row.getDefInt("jsrs"));
				bean.setJsje(row.getDefDouble("jsje"));
				bean.setHjrs(row.getDefInt("hjrs"));
				bean.setHjje(row.getDefDouble("hjje"));	
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setYhsjfsbz(row.getTrimString("yhsjfsbz"));
				l.add(bean);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位汇（补）缴分配网厅查询方法失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		return t;
	}
	
	/**
	 * 缴存人账户核定明细查询
	 * 
	 * @param bmbean
	 * @return
	 */
	@HttpServiceInfo(qddm="ZTBG",fwname="缴存单位汇（补）缴分配查询网厅",fwdm="Jcrzhmx_dcx",ywdm="jcdwjcrbj",fwdz="jcdwjcrbj/Jcrzhmx_dcx.service")
	@RequestMapping(value="ZTBG/jcdwjcrbj/Jcrzhmx_dcx.service",method=RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_Jcrzhmx_Hdcx(@RequestBody Jcdwhjhdbean  bmbean) {
		String trace = "";
		int count = 0;
		DataResult t = new DataResult();
		List<Jcdwhjhdbean> l = new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open(
					"Ztbg_Jcdwjcrbj_Jcrzhmx_Hdcx", bmbean, bmbean.getSize(),
					bmbean.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			for (Row row : lst) {
				Jcdwhjhdbean cb = new Jcdwhjhdbean();
				cb.setGrzh(row.getTrimString("grzh"));
				cb.setXingming(row.getTrimString("xingming"));
				cb.setZjhm(row.getTrimString("zjhm"));
				cb.setGrjcjs(row.getDefDouble("grjcjs"));
				cb.setYjce(row.getDefDouble("yjce"));
				cb.setDwyjce(row.getDefDouble("dwyjce"));
				cb.setGryjce(row.getDefDouble("gryjce"));
				l.add(cb);
			}
			t.setData(l);
			t.setTotalcount(count);
			OptlogBean bean = new OptlogBean();
			bean.setBlqd("zxb");
			bean.setCzfl("019905");
			bean.setJgbm(bmbean.getJgbm());
			bean.setKhbh(bmbean.getKhbh());
			bean.setMsg("");
			bean.setUserid((int) bmbean.getUserid());
			bean.setYwczbs(count + "");
			bean.setYwczje(0);
			bean.setYwlb(bmbean.getYwlb());
			bean.setYwfl(bmbean.getYwfl());
			bean.setYwlsh(" ");
			bean.setYwzy("缴存人账户明细查询");
			bean.setZhbh(bmbean.getZhbh() + "");
			bean.setZxjgbm(bmbean.getZxbm());
			try {
				DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX",
						bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			trace = "<font color='red'>缴存人账户明细查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		}
		return t;
	}
	
	/**
	 * 汇缴核定删除
	 */
	 @HttpServiceInfo(qddm="ZTBG",fwname="缴存单位业务流水冲账",fwdm="jcdwywlscz",ywdm="jcdwjcrbj",fwdz="jcdwjcrbj/jcdwywlscz.service")
	 @RequestMapping(value="ZTBG/jcdwjcrbj/jcdwywlscz.service",method=RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrbj_Jcdwywls_Sc(@RequestBody Jcdwhjhdbean in) {
		String trace = "";
		DataResult t = new DataResult();
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrbj_Jcdwywls_Sc", in);
			t.setData(in);
		} catch (Exception e) {
			trace = "<font color='red'>汇缴核定删除失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		}
		return t;
	}
}

