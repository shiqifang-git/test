package com.shineyue.service.ztbg;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shineyue.bean.ztbg.Im_Gryhzh;
import com.shineyue.bean.ztbg.Jcdw_DwxxbgBean;
import com.shineyue.bean.ztbg.Jcdw_jcrtsqyBean;
import com.shineyue.bean.ztbg.ZtbgHjhdBean;
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.model.xtgl.OptlogBean;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_Hjhd {

	private static final Log log = LogFactory.getLog(Ztbg_Hjhd.class);
	
	/**
	 * 缴存单位汇缴核定信息查询
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位汇缴核定信息查询", fwdm = "hjhdchk", ywdm = "hjhd", fwdz = "hjhd/hjhdchk.service")
	@RequestMapping(value = "ZTBG/hjhd/hjhdchk.service", method = RequestMethod.POST)
	public DataResult ZTBG_Hjhd_Jcrd_Cx(@RequestBody ZtbgHjhdBean bmbean) {
		String trace = "";
		int count=0;
		DataResult t = new DataResult();
		List <ZtbgHjhdBean> l=new ArrayList<ZtbgHjhdBean>();
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open("ZTBG_Hjhd_Jcrd_Cx",bmbean, bmbean.getSize() , bmbean.getPage());
			count = lst.size()>0 ? lst.get(0).getDefInt("count") : 0;
			double syjehj = lst.size() > 0 ? lst.get(0).getDefDouble("syjehj") : 0;
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
				ZtbgHjhdBean cb = new ZtbgHjhdBean();
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
	/**
	 * 缴款银行账号信息查询
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "网厅缴款银行账号信息查询", fwdm = "wtjkyhzhxxcx", ywdm = "hjhd", fwdz = "hjhd/wtjkyhzhxxcx.service")
	@RequestMapping(value = "ZTBG/hjhd/wtjkyhzhxxcx.service", method = RequestMethod.POST)
	public DataResult ZTBG_Hjhd_Wtjkyhzhxxcx(@RequestBody Im_Gryhzh bean33) {
		String trace = "";
		DataResult t = new DataResult();
		List<Im_Gryhzh> l=new ArrayList<Im_Gryhzh>();
		//Im_Gryhzh cb1 = new Im_Gryhzh();
		try {
			List<Row> lst1 = DbMethod.makeDbSingleton().Open("ZTBG_Hjhd_Wtjkyhzhxxcx", bean33);
			for (Row row : lst1) {
				Im_Gryhzh cb = new Im_Gryhzh();
				cb.setYhzhhm(row.getTrimString("yhzhhm"));
				cb.setYhzhmc(row.getTrimString("yhzhmc"));
				cb.setYhhh(row.getTrimString("yhhh"));
				cb.setYhmc(row.getTrimString("yhmc"));
				l.add(cb);
			}
			//cb1.setYhzh("使用新银行卡");
			// l.add(cb1);
			t.setData(l);
			
		} catch (Exception e) {
			trace = "<font color='red'>缴款银行账号信息查询失败：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	
	
	/**
	 * 是否缴款查询
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "网厅缴款是否缴款查询", fwdm = "wtsfjkcx", ywdm = "hjhd", fwdz = "hjhd/wtsfjkcx.service")
	@RequestMapping(value = "ZTBG/hjhd/wtsfjkcx.service", method = RequestMethod.POST)
	public DataResult ZTBG_Hjhd_Wtsfjkcx(@RequestBody Jcdw_jcrtsqyBean jcdwbean) {
		DataResult t = new DataResult();
		String trace = "";
		try {
			DbMethod.makeDbSingleton().Execute("ZTBG_Hjhd_Wtsfjkcx", jcdwbean);
			
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位托收检验是否交款失败：" + e.getMessage() + "</font>";
			log.error(trace);
			jcdwbean.setMsg("缴存单位托收检验是否交款失败");
			jcdwbean.setRet("99");
		}
		t.setData(jcdwbean);
		return t;
	}
	
	/**
	 * 缴款审批查询
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "网厅缴款审批信息查询", fwdm = "wtjkspxxcx", ywdm = "hjhd", fwdz = "hjhd/wtjkspxxcx.service")
	@RequestMapping(value = "ZTBG/hjhd/wtjkspxxcx.service", method = RequestMethod.POST)
	public DataResult ZTBG_Hjhd_Wtjkspxxcx(@RequestBody Jcdw_DwxxbgBean  jcdw_dwxxbgbean ) {
		DataResult t=new DataResult();
		String trace = "";		
		List<Jcdw_DwxxbgBean> l = new ArrayList<Jcdw_DwxxbgBean>();
		int count = 0;
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open(
					"ZTBG_Hjhd_Wtjkspxxcx", jcdw_dwxxbgbean, Integer.valueOf(jcdw_dwxxbgbean.getSize()),Integer.valueOf(jcdw_dwxxbgbean.getPage()));
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			for (Row row : lst) {
				Jcdw_DwxxbgBean bean = new Jcdw_DwxxbgBean();
				bean.setId(row.getTrimString("id"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setSbyy(row.getTrimString("sbyy"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setJcyd(row.getTrimString("jcyd"));
				bean.setLrrq(row.getTrimString("lrrq").substring(0, 10));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setFszt(row.getTrimString("fszt"));
				bean.setBpmid(row.getTrimString("bpmid"));
				bean.setYhbm(row.getTrimString("yhbm"));
				
				l.add(bean);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>单位托收定时发送清册查询失败:" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		jcdw_dwxxbgbean.setYwzy("单位托收定时发送清册查询");
		this.index(jcdw_dwxxbgbean);   //jiaye 2016-11-21
		return t;
	}
	/**
	 * 查询类增加操作日志
	 * jiaye 2016-11-21
	 * WaCommon_OPTLOG_ADD_CX
	 */
	private void index(Jcdw_DwxxbgBean cBean){
		
		OptlogBean bean = new OptlogBean();
		
		String blqd = "" + cBean.getBlqd() == null? "" : cBean.getBlqd() ;
		String czfl = "" ;
		String jgbm = "" + cBean.getJgbm() == null? "" : cBean.getJgbm() ;
		String khbh = "" + cBean.getKhbh() == null? "" : cBean.getKhbh() ;
		String msg = "单位信息变更" ;//+ cBean.getMsg() == null? "" : cBean.getMsg() ;
		int userid = 0 + cBean.getUserid() <= 0? 0 : cBean.getUserid();
		String ywczbs = "0" ;
		double ywczje = 0 ;
		String ywfl = ""+ cBean.getYwfl() == null? "" : cBean.getYwfl() ;
		String ywlb = "" + cBean.getYwlb() == null? "" : cBean.getYwlb() ;
		String ywlsh = "" + cBean.getYwlsh() == null? "" : cBean.getYwlsh() ;
		String ywzy = ""+ cBean.getYwzy() == null? "" : cBean.getYwzy() ;
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
}
