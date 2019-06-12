package com.shineyue.service.ztbg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shineyue.bean.ztbg.Gjzf_Gr_Jcbz;
import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.bean.ztbg.JcdwhjhdExcelbean;
import com.shineyue.bean.ztbg.Jcdwhjhdbean;
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.model.xtgl.OptlogBean;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_jcdwjcrjstz {
	private static final Log log = LogFactory.getLog(Ztbg_jcdwjcrjstz.class);		
	private Logger logger = Logger.getLogger(this.getClass());
      private void index(Jcdwhjhdbean cBean){
		
		OptlogBean bean = new OptlogBean();
		
		String blqd = "" + cBean.getBlqd() == null? "" : cBean.getBlqd() ;
		String czfl = "" ;
		String jgbm = "" + cBean.getJgbm() == null? "" : cBean.getJgbm() ;
		String khbh = "" + cBean.getKhbh() == null? "" : cBean.getKhbh() ;
		String msg = "" + cBean.getMsg() == null? "" : cBean.getMsg() ;
		int userid = 0 + cBean.getUserid() == 0? 0 : cBean.getUserid();
		String ywczbs = "0" ;
		double ywczje = 0 ;
		String ywfl = "" + cBean.getYwfl() == null? "" : cBean.getYwfl() ;
		String ywlb = "" + cBean.getYwlb() == null? "" : cBean.getYwlb() ;
		String ywlsh = "" + cBean.getYwlsh() == null? "" : cBean.getYwlsh() ;
		String ywzy = "" + cBean.getYwzy() == null? "" : cBean.getYwzy() ;
		String zhbh = "" + cBean.getZhbh() == null? "" : cBean.getZhbh() ;
		String zxjgbm = "" ;
		
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
			System.out.println("<font color='red'> 查询日志增加操作失败"
			+ e.getMessage() + "</font>");
		}
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数调整清册查询", fwdm = "jcrjsbgqccx", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcrjsbgqccx.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcrjsbgqccx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgqccx(@RequestBody Jcdwhjhdbean cr_dwBean) {
		DataResult t = new DataResult();
		int count = 0;
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> lst=DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrjstz_jcrjsbgqccx",cr_dwBean,
					cr_dwBean.getSize(),cr_dwBean.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			double grjcjshj=lst.size() > 0 ? lst.get(0).getDefDouble("grjcjshj") : 0;
			double yjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("yjcehj") : 0;
			double dwyjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("dwyjcehj") : 0;
			double gryjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("gryjcehj") : 0;
			double tzhyjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("tzhyjcehj") : 0;
			double tzhjcjshj=lst.size() > 0 ? lst.get(0).getDefDouble("tzhjcjshj") : 0;
			double tzhgryjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("tzhgryjcehj") : 0;
			double tzhdwyjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("tzhdwyjcehj") : 0;
			double yjcecehj =lst.size() > 0 ? lst.get(0).getDefDouble("yjcecehj") : 0;
			for (Row row : lst) {
				Jcdwhjhdbean bean=new Jcdwhjhdbean();
				bean.setIds(row.getTrimString("ids"));
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setLrczy(row.getTrimString("lrczy"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setGrjcjs(row.getDefDouble("grjcjs"));
				bean.setBgyd(row.getTrimString("bgyd"));
				bean.setYjce(row.getDefDouble("yjce"));
				bean.setGryjce(row.getDefDouble("gryjce"));
				bean.setDwyjce(row.getDefDouble("dwyjce"));
				bean.setJcblbm(row.getTrimString("jcblbm"));
				bean.setTzhjcblbm(row.getTrimString("tzhjcblbm"));
				bean.setTzhjcjs(row.getDefDouble("tzhjcjs"));
				bean.setTzhyjce(row.getDefDouble("tzhyjce"));
				bean.setTzhgryjce(row.getDefDouble("tzhgryjce"));
				bean.setTzhdwyjce(row.getDefDouble("tzhdwyjce"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setBpmids(row.getTrimString("bpmid"));
				bean.setDwbh(row.getTrimString("dwbh"));
				bean.setYjcece(row.getDefDouble("yjcece"));
				bean.setBgcs(row.getDefInt("bgcs"));
				bean.setGrjcjshj(grjcjshj);
				bean.setYjcehj(yjcehj);
				bean.setGryjcehj(gryjcehj);
				bean.setDwyjcehj(dwyjcehj);
				bean.setTzhyjcehj(tzhyjcehj);
				bean.setTzhjcjshj(tzhjcjshj);
				bean.setTzhgryjcehj(tzhgryjcehj);
				bean.setTzhdwyjcehj(tzhdwyjcehj);
				bean.setYjcecehj(yjcecehj);
				l.add(bean);
			}
			t.setData(l);
			cr_dwBean.setYwzy("缴存人基数调整清册查询");
			this.index(cr_dwBean);   
		}catch (Exception e) {
			e.printStackTrace();
			String trace = "<font color='red'>缴存单位的缴存人缴存基数调整清册查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		}
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数调整清册录入", fwdm = "jcrjsbgqclr", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcrjsbgqclr.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcrjsbgqclr.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgqclr(@RequestBody Jcdwhjhdbean cr_dwBean) {
		DataResult t = new DataResult();
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrjstz_jcrjsbgqclr",cr_dwBean);
			t.setMsg(cr_dwBean.getMsg());
		}catch (Exception e) {
			e.printStackTrace();
			t.setMsg("录入失败！");
			cr_dwBean.setMsg("录入失败！");
			log.error(e.getMessage());
		}
		t.setData(cr_dwBean);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数调整清册删除", fwdm = "jcrjsbgqcdel", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcrjsbgqcdel.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcrjsbgqcdel.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgqcdel(@RequestBody Jcdwhjhdbean cr_dwBean) {
		DataResult t = new DataResult();
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrjstz_jcrjsbgqcdel",cr_dwBean);
		}catch (Exception e) {
			e.printStackTrace();
			cr_dwBean.setMsg("删除失败！");
			log.error(e.getMessage());
		}
		t.setMsg(cr_dwBean.getMsg());
		t.setData(cr_dwBean);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数调整清册全删", fwdm = "jcrjsbgqcdelall", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcrjsbgqcdelall.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcrjsbgqcdelall.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgqcdelall(@RequestBody Jcdwhjhdbean cr_dwBean) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrjstz_jcrjsbgqcdelall",cr_dwBean);
		} catch (Exception e) {
			trace = "<font color='red'>基数调整删除:" + e.getMessage() + "</font>";
			log.error(trace);
			cr_dwBean.setMsg(e.getMessage());
		}
		t.setMsg(cr_dwBean.getMsg());
		t.setData(cr_dwBean);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数调整清册导入", fwdm = "jcrjsbgqcdr", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcrjsbgqcdr.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcrjsbgqcdr.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgqcdr(@RequestBody Jcdwhjhdbean bean) {
		String trace = "";
		DataResult t = new DataResult();
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			int count = 0;
			System.out.println("======bean.getGrjclarr().split========"+bean.getGrjclarr());
			List<Row> list = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrjstz_jcrjsbgqcdr", bean,0,0);
			count = list.size() > 0 ? list.get(0).getDefInt("count") : 0;
			if (list.size() == 0) {
				Jcdwhjhdbean cb = new Jcdwhjhdbean();
				cb.setRet(bean.getMsg());
				cb.setRet1(Integer.parseInt(bean.getRet()));
				cb.setCount(count);
				l.add(cb);
			} else {
				for(Row row : list){
					Jcdwhjhdbean bean1 = new Jcdwhjhdbean();
					bean1.setMsg(row.getTrimString("msg").trim());
					bean1.setGrzh(row.getTrimString("grzh"));
					bean1.setXingming(row.getTrimString("xingming"));
					bean1.setRet(bean.getMsg());
					bean1.setRet1(Integer.parseInt(bean.getRet()));
					bean1.setCount(count);
					l.add(bean1);
				}
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'> 缴存单位的缴存人缴存基数调整清册导入：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数调整打印凭条", fwdm = "jcrjsbgdypt", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcrjsbgdypt.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcrjsbgdypt.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgdypt(@RequestBody Jcdwhjhdbean cr_dwBean) {
		DataResult t = new DataResult();
		int count = 0;
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> lst=DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrjstz_jcrjsbgdypt",cr_dwBean,
					cr_dwBean.getSize(),cr_dwBean.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			
			for (Row row : lst) {
				Jcdwhjhdbean bean=new Jcdwhjhdbean();
//				bean.setIds(row.getTrimString("ids"));
				bean.setBlqd(row.getTrimString("bglb"));
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setGrjcjs(row.getDefDouble("grjcjs"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setYjce(row.getDefDouble("yjce"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setJcblbm(row.getTrimString("jcblbm"));
				bean.setTzhjcblbm(row.getTrimString("tzhjcblbm"));
				bean.setTzhjcjs(row.getDefDouble("tzhjcjs"));
				bean.setTzhyjce(row.getDefDouble("tzhyjce"));
				bean.setJbrxm(row.getTrimString("jbrxm"));
				bean.setJbrsjhm(row.getTrimString("jbrsjhm"));
				bean.setYwrq(row.getTrimString("ywrq"));
				bean.setLrczy(row.getTrimString("lrczy"));
				bean.setSpczy(row.getTrimString("spczy"));
				System.out.println("========================"+bean.getYwrq());
				l.add(bean);
			}
			t.setData(l);
		}catch (Exception e) {
			String trace = "<font color='red'>缴存单位的缴存人缴存基数调整清册打印失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		}
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数调整审批清册查询", fwdm = "jcrjsbgspqccx", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcrjsbgspqccx.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcrjsbgspqccx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgspqccx(@RequestBody Jcdwhjhdbean cr_dwBean) {
		String trace = "";
		DataResult t = new DataResult();
		int count = 0;
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> lst=DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrjstz_jcrjsbgspqccx",cr_dwBean,
					cr_dwBean.getSize(),cr_dwBean.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			double yjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("yjcehj") : 0;
			double tzhyjcehj=lst.size() > 0 ? lst.get(0).getDefDouble("tzhyjcehj") : 0;
			t.setTotalcount(count);
			for (Row row : lst) {
				Jcdwhjhdbean bean=new Jcdwhjhdbean();
				bean.setIds(row.getTrimString("ids"));
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setGrjcjs(row.getDefDouble("grjcjs"));
				bean.setBgyd(row.getTrimString("bgyd"));
				bean.setYjce(row.getDefDouble("yjce"));
				bean.setGryjce(row.getDefDouble("gryjce"));
				bean.setDwyjce(row.getDefDouble("dwyjce"));
				bean.setJcblbm(row.getTrimString("jcblbm"));
				bean.setTzhjcblbm(row.getTrimString("tzhjcblbm"));
				bean.setTzhjcjs(row.getDefDouble("tzhjcjs"));
				bean.setTzhyjce(row.getDefDouble("tzhyjce"));
				bean.setTzhgryjce(row.getDefDouble("tzhgryjce"));
				bean.setTzhdwyjce(row.getDefDouble("tzhdwyjce"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setBpmids(row.getTrimString("bpmid"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setDwbh(row.getTrimString("dwbh"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setYjcece(row.getDefDouble("tzhyjce")-row.getDefDouble("yjce"));
				bean.setTzhyjcehj(tzhyjcehj);
				bean.setYjcehj(yjcehj);
				l.add(bean);
			}
			t.setData(l);
		}catch (Exception e) {
			trace = "<font color='red'>缴存单位的缴存人缴存基数调整清册查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		}
		return t;
	}
	
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存上下限设置", fwdm = "jcsxxsz", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcsxxsz.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcsxxsz.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_Jcbzsz_Cx(@RequestBody Gjzf_Gr_Jcbz bm) {
		String trace = "";
		int count = 0;
		DataResult t = new DataResult();
		List<Gjzf_Gr_Jcbz> l=new ArrayList<Gjzf_Gr_Jcbz>();
		try {
			List<Row> lst1 = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrjstz_Jcbzsz_Cx", bm,bm.getSize(),bm.getPage());
			count = lst1.size() > 0 ? lst1.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			
			for (Row row : lst1) {
				Gjzf_Gr_Jcbz cb = new Gjzf_Gr_Jcbz();
				cb.setZdgrjcjs(row.getDefDouble("zdgrjcjs"));
				cb.setZxgrjcjs(row.getDefDouble("zxgrjcjs"));
				cb.setZdyjce(row.getDefDouble("zdyjce"));
				cb.setZxyjce(row.getDefDouble("zxyjce"));
				cb.setKsqyny(row.getTrimString("ksqyny"));
				cb.setJssyny(row.getTrimString("jssyny"));
				cb.setId(row.getTrimString("id"));
				cb.setCount(count);
				 l.add(cb);
			}
			t.setData(l);
		
		} catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>缴存上下限设置查询：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
//		this.index(bm);
		return t;
	}
	
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存上下限设置 增加", fwdm = "jcsxxsz_add", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcsxxsz_add.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcsxxsz_add.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_Jcbzsz_add(@RequestBody Gjzf_Gr_Jcbz bm){
		DataResult t = new DataResult();
		String trace = "";
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrjstz_Jcbzsz_add", bm);
		} catch (Exception e) {
			trace = "<font color='red'>缴存上下限设置增加：" + e.getMessage() + "</font>";
			log.error(trace);
			bm.setMsg("缴存上下限设置增加失败！");
			bm.setRet((short)99);
		}
		t.setData(bm);
		return t;

	}
	
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存上下限设置 删除", fwdm = "jcsxxsz_del", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcsxxsz_del.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcsxxsz_del.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_Jcbzsz_del(@RequestBody Gjzf_Gr_Jcbz bm){
		DataResult t = new DataResult();
		String trace = "";
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrjstz_Jcbzsz_del", bm);
		} catch (Exception e) {
			trace = "<font color='red'>缴存上下限设置删除：" + e.getMessage() + "</font>";
			log.error(trace);
			bm.setMsg("缴存上下限删除失败！");
			bm.setRet((short)99);
		}
		t.setData(bm);
		return t;

	}
	
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存上下限设置 修改", fwdm = "jcsxxsz_chg", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcsxxsz_chg.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcsxxsz_chg.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_Jcbzsz_chg(@RequestBody Gjzf_Gr_Jcbz bm){
		DataResult t = new DataResult();
		String trace = "";
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwjcrjstz_Jcbzsz_chg", bm);
		} catch (Exception e) {
			trace = "<font color='red'>缴存上下限设置修改：" + e.getMessage() + "</font>";
			e.printStackTrace();
			log.error(trace);
			bm.setMsg("缴存上下限修改失败！");
			bm.setRet((short)99);
		}
		t.setData(bm);
		return t;

	}
	/**
	 * 导入查询结果
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数导入结果查询", fwdm = "jcrjsbgqcdr_jgcx", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcrjsbgqcdr_jgcx.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcrjsbgqcdr_jgcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgqcdrJgcx(@RequestBody Jcdwhjhdbean bean) {
		String trace = "";
		DataResult t = new DataResult();
		try {
			List<Row> list = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrjstz_jcrjsbgqcdrJgcx", bean,0,0);
			if (list.size() == 0) {
				t.setMsg("未查询到导入结果!");
				t.setTotalcount(999); 
			} else {
			    Row row=list.get(0);
			    t.setMsg(row.getTrimString("msg").trim());
			    t.setTotalcount(row.getDefInt("jyjg"));
			    t.setMsg("查询导入结果成功");
			}
		} catch (Exception e) {
			trace = "<font color='red'> 缴存人基数导入结果查询失败!!!!：" + e.getMessage() + "</font>";
			log.error(trace);
			t.setTotalcount(999);
			t.setMsg("查询导入结果发生异常!!!!");
		} 
		logger.info(bean.getUserid()+"正在查询基数调整超时 的导入结果信息为>>>>>"+t.getMsg());
		return t;
	}
	/**
	 * 导入错误查询
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数导入错误查询", fwdm = "jcdwjcrjstzdr_newdrcw", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcdwjcrjstzdr_newdrcw.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcdwjcrjstzdr_newdrcw.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgqcdrCwcx(@RequestBody Jcdwhjhdbean bean) {
		String trace = "";
		DataResult t = new DataResult();
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> list = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrjstz_jcrjsbgqcdrCwcx", bean,0,0);
			if (list.size() == 0) {   
		          t.setTotalcount(99);  
		          t.setMsg("未查询到错误结果");
			} else {     
				for(Row row : list){
					Jcdwhjhdbean bean1 = new Jcdwhjhdbean();
					bean1.setMsg(row.getTrimString("msg").trim());
					bean1.setGrzh(row.getTrimString("grzh"));
					bean1.setXingming(row.getTrimString("xingming"));
					bean1.setZjhm(row.getTrimString("zjhm"));
					bean1.setJine(row.getDefDouble("jine"));
					l.add(bean1);
				}
				t.setMsg("查询错误结果成功");
			}
			t.setData(l);
			t.setTotalcount(0);  
		} catch (Exception e) {
			trace = "<font color='red'> 缴存人基数导入错误查询失败!!!!：" + e.getMessage() + "</font>";
			log.error(trace);
			t.setTotalcount(99);  // 查询错误结果  异常
			t.setMsg("查询错误结果发生异常!!!!");
		} 
		logger.info("查询基数调整错误结果信息为>>>>>"+t.getMsg());
		return t;
	}
	/**
	 * 新导入
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人基数调整新Excel导入", fwdm = "jcrjsbgqcdr_new", ywdm = "jcdwjcrjstz", fwdz = "jcdwjcrjstz/jcrjsbgqcdr_new.service")
	@RequestMapping(value = "ZTBG/jcdwjcrjstz/jcrjsbgqcdr_new.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwjcrjstz_jcrjsbgqcdrNew(@RequestBody JcdwhjhdExcelbean bean) {
		String trace = "";
		DataResult t = new DataResult();
		logger.info("缴存人基数导入后台开始时间--- > " + new Date());
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			int count = 0;
			List<Row> list = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwjcrjstz_jcrjsbgqcdrNew", bean,0,0);
			count = list.size() > 0 ? list.get(0).getDefInt("count") : 0;
			if (list.size() == 0) {
				Jcdwhjhdbean cb = new Jcdwhjhdbean();
				cb.setRet(bean.getMsg());
				cb.setRet1(Integer.parseInt(bean.getRet()));
				cb.setCount(count);
				l.add(cb);
			} else {
				for(Row row : list){
					Jcdwhjhdbean bean1 = new Jcdwhjhdbean();
					bean1.setMsg(row.getTrimString("msg").trim());
					bean1.setGrzh(row.getTrimString("grzh"));
					bean1.setXingming(row.getTrimString("xingming"));
					bean1.setZjhm(row.getTrimString("zjhm"));
					bean1.setJine(row.getDefDouble("jine"));
					bean1.setRet(bean.getMsg());
					bean1.setRet1(Integer.parseInt(bean.getRet()));
					bean1.setCount(count);
					l.add(bean1);
				}
			}
			t.setData(l);
			t.setTotalcount(bean.getRet1()); //使用totalcount记录存储执行结果
		} catch (Exception e) {
			trace = "<font color='red'> 缴存单位的缴存人缴存基数调整清册导入：" + e.getMessage() + "</font>";
			log.error(trace);
			t.setTotalcount(99);
			t.setMsg("数据库执行异常");
		} 
		logger.info("缴存人基数导入后台结束时间--- > " + new Date());
		logger.info("缴存人基数导入返回参数--- > " + t.getTotalcount());
		return t;
	}
}

