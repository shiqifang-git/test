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
import com.shineyue.bean.ztbg.Jcdwhjhdtsqy;
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.model.xtgl.OptlogBean;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_jcdwhjhd {
	private static final Log log = LogFactory.getLog(Ztbg_jcdwhjhd.class);		
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位汇缴核定查询", fwdm = "jcrdcx", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/jcrdcx.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/jcrdcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_jcrdcx(@RequestBody Jcdwhjhdbean bmbean) {
		String trace = "";
		int count=0;
		DataResult t = new DataResult();
		List <Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwhjhd_jcrdcx",bmbean, bmbean.getSize() , bmbean.getPage());
			count = lst.size()>0 ? lst.get(0).getDefInt("count") : 0;
			double syjehj = lst.size() > 0 ? lst.get(0).getDefDouble("syjehj") : 0;
			System.out.println("+_________+_+_)+_)_+)+_)+)+syje"+syjehj);
			double zjrshj = lst.size() > 0 ? lst.get(0).getDefDouble("zjrshj") : 0;
			double jsrshj = lst.size() > 0 ? lst.get(0).getDefDouble("jsrshj") : 0;
			double hjrshj = lst.size() > 0 ? lst.get(0).getDefDouble("hjrshj") : 0;
			double syrshj = lst.size() > 0 ? lst.get(0).getDefDouble("syrshj") : 0;
			double zjjehj = lst.size() > 0 ? lst.get(0).getDefDouble("zjjehj") : 0;
			double jsjehj = lst.size() > 0 ? lst.get(0).getDefDouble("jsjehj") : 0;
			double hjjehj = lst.size() > 0 ? lst.get(0).getDefDouble("hjjehj") : 0;
			double zckyehj = lst.size() > 0 ? lst.get(0).getDefDouble("zckyehj") : 0;
			int j =1;
			
			int i = 0;
			for (Row row : lst) {
				Jcdwhjhdbean cb = new Jcdwhjhdbean();
				cb.setJcrd(row.getTrimString("jcyd"));
				cb.setSyje1(row.getDefDouble("syje"));
				cb.setSyje(row.getDefInt("syje"));
				
				cb.setZjrs(row.getDefInt("zjrs"));
				cb.setJsrs(row.getDefInt("jsrs"));
				cb.setHjrs(row.getDefInt("hjrs"));
				cb.setZckye(row.getDefDouble("zckye"));
				cb.setSyrs(row.getDefDouble("syrs"));
				cb.setZjje(row.getDefDouble("zjje"));
				cb.setJsje(row.getDefDouble("jsje"));
				cb.setHjje(row.getDefDouble("hjje"));

				cb.setSyje1hj(syjehj);
				cb.setZjrshj(zjrshj);
				cb.setJsrshj(jsrshj);
				cb.setHjrshj(hjrshj);
				cb.setSyrshj(syrshj);
				cb.setZjjehj(zjjehj);
				cb.setJsjehj(jsjehj);
				cb.setHjjehj(hjjehj);
				cb.setZckyehj(zckyehj);
				cb.setMsg(bmbean.getMsg());
				cb.setRet(bmbean.getRet());
				l.add(cb);
				i++;
				 System.out.println("msg2====================="+bmbean.getMsg()+i);
			}
			t.setData(l);
			t.setTotalcount(count);
			t.setMsg(bmbean.getMsg());
			OptlogBean ob = new OptlogBean();
			ob.setBlqd("zxb");
			ob.setCzfl(" ");
			ob.setJgbm(bmbean.getJgbm());
			ob.setKhbh(bmbean.getKhbh());
			ob.setMsg("");
			ob.setUserid(bmbean.getUserid());
			ob.setYwczbs(count+"");
			ob.setYwczje(1);
			ob.setYwfl(bmbean.getYwfl());
			ob.setYwlb(bmbean.getYwlb());
			ob.setYwlsh(bmbean.getYwlsh());
			ob.setYwzy("缴存单位汇缴核定信息查询");
			ob.setZhbh(bmbean.getZhbh());
			ob.setZxjgbm(bmbean.getZxbm());
			try {
				DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", ob);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			j++;
			System.out.println("msg3=================================="+bmbean.getMsg()+j+i);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位汇缴核定信息查询失败：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位汇缴核定检查", fwdm = "jcrdchk", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/jcrdchk.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/jcrdchk.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_jcrdchk(@RequestBody Jcdwhjhdbean bmbean) {
		String trace = "";
		int count=0;
		DataResult t = new DataResult();
		List <Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwhjhd_jcrdchk",bmbean,bmbean.getSize(),bmbean.getPage());
			count = lst.size()>0 ? lst.get(0).getDefInt("count") : 0;
			if(count==0){
				Jcdwhjhdbean cb1 = new Jcdwhjhdbean();
				cb1.setRet(bmbean.getRet());
				l.add(cb1);
			}else{
				for (Row row : lst) {
					Jcdwhjhdbean cb = new Jcdwhjhdbean();
					cb.setGrzh(row.getTrimString("grzh"));
					cb.setXingming(row.getTrimString("xingming"));
					cb.setDwzh(row.getTrimString("dwzh"));
					cb.setDwmc(row.getTrimString("dwmc"));
					cb.setGrjcjs(row.getDefDouble("grjcjs"));
					cb.setDwyjce(row.getDefDouble("dwyjce"));
					cb.setGryjce(row.getDefDouble("gryjce"));
					cb.setMsgcx(row.getTrimString("msg"));
					cb.setMsg(bmbean.getMsg());
					cb.setRet(bmbean.getRet());
					l.add(cb);
				}
			}
			t.setData(l);
			t.setTotalcount(count);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位汇缴核定办理检查失败：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位汇缴核定办理", fwdm = "jcrdadd", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/jcrdadd.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/jcrdadd.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_jcrdadd(@RequestBody Jcdwhjhdbean bmbean) {

		DataResult t = new DataResult();
		String trace = "";
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwhjhd_jcrdadd", bmbean);
			t.setData(bmbean);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位汇缴核定办理完成失敗：" + e.getMessage() + "</font>";
			log.error(trace);
		}
		return t;

	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位缴存变更清册", fwdm = "jcbgqc", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/jcbgqc.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/jcbgqc.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_jcbgqc(@RequestBody Jcdwhjhdbean in) {
		String trace = "";
		int count = 0;
		DataResult t = new DataResult();
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		
		
		try {
			List<Row> lst1 = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwhjhd_jcbgqc", in,in.getSize(),in.getPage());
			
			count = lst1.size() > 0 ? lst1.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
	
			for (Row row : lst1) {
				Jcdwhjhdbean out = new Jcdwhjhdbean();
				out.setBgyd(row.getTrimString("bgyd"));//null输出
				out.setDwzh(row.getTrimString("dwzh"));//null输出
				out.setDwmc(row.getTrimString("dwmc"));//null输出
				out.setJbrxm(row.getTrimString("jbrxm"));//null输出
				out.setJbrsjhm(row.getTrimString("jbrsjhm"));//null输出
				out.setDwjcrs(row.getDefInt("dwjcrs"));//null输出
				out.setYjcze(row.getDefDouble("yjcze"));//null输出
				out.setGryjce(row.getDefDouble("gryjce"));
				out.setXingming(row.getTrimString("xingming"));//null输出
				out.setZjhm(row.getTrimString("zjhm"));//null输出
				out.setYwlb(row.getTrimString("ywlb"));//null输出
				out.setDsgrzhye(row.getDefDouble("dsgrzhye"));//null输出
				out.setGrzh(row.getTrimString("grzh"));//null输出
				l.add(out);
			}
			t.setData(l);
			
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位打印缴存变更清册失败：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位缴存变更清册", fwdm = "hbjptprt", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/hbjptprt.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/hbjptprt.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_hbjptprt(@RequestBody Jcdwhjhddy cr_dwBean) {
		DataResult t=new DataResult();
		String trace = "";
//		int count;
		List<Row> lst;
		List<Jcdwhjhddy> l=new ArrayList<Jcdwhjhddy>();
		try{
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwhjhd_hbjptprt",cr_dwBean);
//			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
//			t.setTotalcount(count);
			for (Row row : lst) {
				Jcdwhjhddy bean=new Jcdwhjhddy();
				
				bean.setHjrq(row.getDateToString("hjrq"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setJbrxm(row.getTrimString("jbrxm"));
				bean.setJbrsjhm(row.getTrimString("jbrsjhm"));
				bean.setDwjcrs(row.getDefInt("dwjcrs"));
				bean.setYjcze(row.getDefDouble("yjcze"));
				bean.setSyrs(row.getDefInt("syrs"));
				bean.setSyje(row.getDefDouble("syje"));
				bean.setZjrs(row.getDefInt("zjrs"));
				bean.setZjje(row.getDefDouble("zjje"));
				bean.setJsrs(row.getDefInt("jsrs"));
				bean.setJsje(row.getDefDouble("jsje"));
				bean.setHjrs(row.getDefInt("hjrs"));
				bean.setHjje(row.getDefDouble("hjje"));
				bean.setBjje(row.getDefDouble("bjje"));
				bean.setBjrs(row.getDefInt("bjrs"));
				bean.setJkczy(row.getTrimString("jkczy"));
				bean.setKsyd(row.getTrimString("ksyd"));
				bean.setJsyd(row.getTrimString("jsyd"));
				bean.setYjcze1(row.getDefDouble("yjcze1"));
				bean.setHdczy(row.getTrimString("hdczy"));
				System.out.println("...............row.getDefDouble(yjcze1)="+row.getDefDouble("yjcze1"));
				
				l.add(bean);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位打印住房公积金管理中心汇(补)缴凭条方法失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位汇缴分配入账", fwdm = "hjfprz", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/hjfprz.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/hjfprz.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_hjfprz(@RequestBody Jcdwhjhdbean cr_dwBean) {
		String msg = "";
		DataResult t = new DataResult();
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwhjhd_hjfprz",
					cr_dwBean);
		} catch (Exception e) {
			msg = e.getMessage();
			cr_dwBean.setMsg(msg);
			log.error(e.getMessage());
		} 
		t.setData(cr_dwBean);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位托收是否交款", fwdm = "dwtsqysfjk", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/dwtsqysfjk.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/dwtsqysfjk.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_dwtsqysfjk(@RequestBody Jcdwhjhdtsqy jcdwbean){
		DataResult t = new DataResult();
		String trace = "";
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_Jcdwhjhd_dwtsqysfjk", jcdwbean);
			
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位托收检验是否交款失败：" + e.getMessage() + "</font>";
			log.error(trace);
			jcdwbean.setMsg("缴存单位托收检验是否交款失败");
			jcdwbean.setRet("99");
		}
		t.setData(jcdwbean);
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位汇（补）缴分配网厅查询方法", fwdm = "hjfpcxwt", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/hjfpcxwt.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/hjfpcxwt.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_hjfpcxwt(@RequestBody Jcdwhjhdbean cr_dwBean) {
		DataResult t=new DataResult();
		String trace = "";
		int count;
		List<Row> lst;
		List<Jcdwhjhdbean> l=new ArrayList<Jcdwhjhdbean>();
		try{
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwhjhd_hjfpcxwt",cr_dwBean);
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
	 * 缴存单位打印住房公积金管理中心汇(补)缴凭条zj
	 * @param cr_dwBean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位汇（补）缴分配网厅查询方法", fwdm = "hbjptprt28", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/hbjptprt28.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/hbjptprt28.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_Hbjpt_Prt28(@RequestBody Jcdwhjhddy cr_dwBean) {
		DataResult t=new DataResult();
		String trace = "";
		List<Row> lst;
		List<Jcdwhjhddy> l=new ArrayList<Jcdwhjhddy>();
		try{
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwhjhd_Hbjpt_Prt28",cr_dwBean);
			for (Row row : lst) {
				Jcdwhjhddy bean=new Jcdwhjhddy();
				
				bean.setHjrq(row.getDateToString("hjrq"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setJbrxm(row.getTrimString("jbrxm"));
				bean.setJbrsjhm(row.getTrimString("jbrsjhm"));
				bean.setDwjcrs(row.getDefInt("dwjcrs"));
				bean.setYjcze(row.getDefDouble("yjcze"));
				bean.setSyrs(row.getDefInt("syrs"));
				bean.setSyje(row.getDefDouble("syje"));
				bean.setZjrs(row.getDefInt("zjrs"));
				bean.setZjje(row.getDefDouble("zjje"));
				bean.setJsrs(row.getDefInt("jsrs"));
				bean.setJsje(row.getDefDouble("jsje"));
				bean.setHjrs(row.getDefInt("hjrs"));
				bean.setHjje(row.getDefDouble("hjje"));
				bean.setBjje(row.getDefDouble("bjje"));
				bean.setBjrs(row.getDefInt("bjrs"));
				bean.setJkczy(row.getTrimString("jkczy"));
				bean.setKsyd(row.getTrimString("ksyd"));
				bean.setJsyd(row.getTrimString("jsyd"));
				bean.setYjcze1(row.getDefDouble("yjcze1"));
				bean.setHdczy(row.getTrimString("hdczy"));
				System.out.println("...............row.getDefDouble(yjcze1)="+row.getDefDouble("yjcze1"));
				
				l.add(bean);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位打印住房公积金管理中心汇(补)缴凭条方法失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		return t;
	}
	
	/**
	 * 打印住房公积金管理中心汇(补)缴凭条zj 单位汇缴核定
	 * @param cr_dwBean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位汇（补）缴分配网厅查询方法", fwdm = "hbjptprt29", ywdm = "jcdwhjhd", fwdz = "jcdwhjhd/hbjptprt29.service")
	@RequestMapping(value = "ZTBG/jcdwhjhd/hbjptprt29.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhjhd_Hbjpt_Prt29(@RequestBody Jcdwhjhddy cr_dwBean) {
		DataResult t=new DataResult();
		String trace = "";
		List<Row> lst;
		List<Jcdwhjhddy> l=new ArrayList<Jcdwhjhddy>();
		try{
			lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwhjhd_Hbjpt_Prt29",cr_dwBean);
			for (Row row : lst) {
				Jcdwhjhddy bean=new Jcdwhjhddy();
				
				bean.setHjrq(row.getDateToString("hjrq"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setJbrxm(row.getTrimString("jbrxm"));
				bean.setJbrsjhm(row.getTrimString("jbrsjhm"));
				bean.setDwjcrs(row.getDefInt("dwjcrs"));
				bean.setYjcze(row.getDefDouble("yjcze"));
				bean.setSyrs(row.getDefInt("syrs"));
				bean.setSyje(row.getDefDouble("syje"));
				bean.setZjrs(row.getDefInt("zjrs"));
				bean.setZjje(row.getDefDouble("zjje"));
				bean.setJsrs(row.getDefInt("jsrs"));
				bean.setJsje(row.getDefDouble("jsje"));
				bean.setHjrs(row.getDefInt("hjrs"));
				bean.setHjje(row.getDefDouble("hjje"));
				bean.setBjje(row.getDefDouble("bjje"));
				bean.setBjrs(row.getDefInt("bjrs"));
				bean.setJkczy(row.getTrimString("jkczy"));
				bean.setKsyd(row.getTrimString("ksyd"));
				bean.setJsyd(row.getTrimString("jsyd"));
				bean.setYjcze1(row.getDefDouble("yjcze1"));
				bean.setHdczy(row.getTrimString("hdczy"));
				
				l.add(bean);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>打印住房公积金管理中心汇(补)缴凭条zj 单位汇缴核定 方法失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		} 
		return t;
	}
}

