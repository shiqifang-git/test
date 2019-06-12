package com.shineyue.service.ztbg;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shineyue.bean.ztbg.Cr_dwBean;
import com.shineyue.bean.ztbg.Jcdw_jcrbgztBean;
import com.shineyue.bean.ztbg.Jcdw_plhcBean1;
import com.shineyue.bean.ztbg.Jcdwjcrztbg;
import com.shineyue.bean.ztbg.Jcdwjcrztbg_mx;
import com.shineyue.bean.ztbg.Jcdwjcrztbg_qc;
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.model.xtgl.OptlogBean;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_Czhj {

	private static final Log log = LogFactory.getLog(Ztbg_Czhj.class);
	
	/**
	 * 财政代扣查询
	 * @param obj
	 * @return
	 * @throws CallDbException
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "财政代扣查询", fwdm = "czdkcx", ywdm = "czhj", fwdz = "czhj/czdkcx.service")
	@RequestMapping(value = "ZTBG/czhj/czdkcx.service", method = RequestMethod.POST)
	
	public DataResult ztbg_Czhj_Czdk_Cx(@RequestBody Jcdw_plhcBean1 Jcdw_plhcBean1) {
		DataResult t=new DataResult();
		String trace = " ";
		List<Jcdw_plhcBean1> l=new ArrayList<Jcdw_plhcBean1>();
		int count = 0;
		int id = 0;
		try{
			List<Row> lst = DbMethod.makeDbSingleton().Open("ztbg_Czhj_Czdk_Cx", Jcdw_plhcBean1,
					Jcdw_plhcBean1.getSize(),Jcdw_plhcBean1.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			double yjcehj = lst.size() > 0 ? lst.get(0).getDefDouble("yjcehj") : 0;
			double yjjehj = lst.size() > 0 ? lst.get(0).getDefDouble("yjjehj") : 0;
			double cehj = lst.size() > 0 ? lst.get(0).getDefDouble("cehj") : 0;
			t.setTotalcount(count);
			for(Row row : lst) {
				Jcdw_plhcBean1 pmt1 = new  Jcdw_plhcBean1();
				pmt1.setDwzh(row.getTrimString("dwzh"));//
				pmt1.setDwmc(row.getTrimString("dwmc"));//
				pmt1.setXingming(row.getTrimString("xingming"));//
				pmt1.setGrzh(row.getTrimString("grzh"));//
				pmt1.setYwlsh(row.getTrimString("ywlsh"));//
				pmt1.setJyjg(row.getTrimString("jyjg"));//
				pmt1.setYjce(row.getTrimString("yjce"));//
				pmt1.setYjje(row.getTrimString("yjje"));//
				pmt1.setCe(row.getTrimString("ce"));//
				pmt1.setZjhm(row.getTrimString("zjhm"));//
				pmt1.setYjcehj(yjcehj);
				pmt1.setYjjehj(yjjehj);
				pmt1.setCehj(cehj);
				l.add(pmt1);
			}
			t.setData(l);
		} catch (Exception e) {
			trace = "<font color='red'>财政代扣查询失败:" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	
	/**
	 * 批量核定完成办理
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "财政代扣批量核定完成办理", fwdm = "plwcbl", ywdm = "czhj", fwdz = "czhj/plwcbl.service")
	@RequestMapping(value = "ZTBG/czhj/plwcbl.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Plhdwcbl(@RequestBody Jcdw_plhcBean1 bean) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("ztbg_Czhj_Czdk_Plhdwcbl",bean);
		} catch (Exception e) {
			trace = "<font color='red'>批量核定完成办理:" + e.getMessage() + "</font>";
			log.error(trace);
			bean.setMsg(e.getMessage());
		} 
		t.setData(bean);
		return t;
	}
	
	/**
	 * 批量财政汇缴dellall
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "批量财政汇缴全删", fwdm = "dellall", ywdm = "czhj", fwdz = "czhj/dellall.service")
	@RequestMapping(value = "ZTBG/czhj/dellall.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Dellall(@RequestBody Jcdw_plhcBean1 bean) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("ztbg_Czhj_Czdk_Dellall",bean);
		} catch (Exception e) {
			trace = "<font color='red'>批量财政汇缴dellall:" + e.getMessage() + "</font>";
			log.error(trace);
			bean.setMsg(e.getMessage());
		} 
		t.setData(bean);
		return t;
	}
	
	/**
	 * 批量财政汇缴一键转移
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "批量财政汇缴一键转移", fwdm = "yjzy", ywdm = "czhj", fwdz = "czhj/yjzy.service")
	@RequestMapping(value = "ZTBG/czhj/yjzy.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Yjzy(@RequestBody Jcdw_plhcBean1 bean) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("ztbg_Czhj_Czdk_Yjzy",bean);
		} catch (Exception e) {
			trace = "<font color='red'>批量财政汇缴一键转移:" + e.getMessage() + "</font>";
			log.error(trace);
			bean.setMsg(e.getMessage());
		} 
		t.setData(bean);
		return t;
	}
	
	/**
	 * 批量财政汇缴基数变更
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "批量财政汇缴基数变更", fwdm = "jsbg", ywdm = "czhj", fwdz = "czhj/jsbg.service")
	@RequestMapping(value = "ZTBG/czhj/jsbg.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Jsbg(@RequestBody Jcdw_plhcBean1 bean) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("ztbg_Czhj_Czdk_Jsbg",bean);
		} catch (Exception e) {
			trace = "<font color='red'>批量财政汇缴基数变更:" + e.getMessage() + "</font>";
			log.error(trace);
			bean.setMsg(e.getMessage());
		} 
		t.setData(bean);
		return t;
	}
	
	/**
	 * 批量财政汇缴一键封存启封
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "批量财政汇缴一键封存启封", fwdm = "yjfcqf", ywdm = "czhj", fwdz = "czhj/yjfcqf.service")
	@RequestMapping(value = "ZTBG/czhj/yjfcqf.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Yjfcqf(@RequestBody Jcdw_plhcBean1 bean) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("ztbg_Czhj_Czdk_Yjfcqf",bean);
		} catch (Exception e) {
			trace = "<font color='red'>批量财政汇缴一键封存启封:" + e.getMessage() + "</font>";
			log.error(trace);
			bean.setMsg(e.getMessage());
		} 
		t.setData(bean);
		return t;
	}


	/**
	 * 批量财政汇缴--信息变更
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "批量财政汇缴一键信息变更", fwdm = "yjxxbg", ywdm = "czhj", fwdz = "czhj/yjxxbg.service")
	@RequestMapping(value = "ZTBG/czhj/yjxxbg.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Yjxxbg(@RequestBody Jcdw_plhcBean1 bean) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("ztbg_Czhj_Czdk_Yjxxbg",bean);
		} catch (Exception e) {
			trace = "<font color='red'>批量财政汇缴一键信息变更:" + e.getMessage() + "</font>";
			log.error(trace);
			bean.setMsg(e.getMessage());
		}
		t.setData(bean);
		return t;
	}

	
	/**
	 * 财政代扣核定单位查询
	 * @param obj
	 * @return
	 * @throws CallDbException
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "财政代扣核定单位查询", fwdm = "hddwcx", ywdm = "czhj", fwdz = "czhj/hddwcx.service")
	@RequestMapping(value = "ZTBG/czhj/hddwcx.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Hddwcx(@RequestBody Cr_dwBean jcdw_plhcBean) {
		DataResult t=new DataResult();
		String trace = " ";
		List<Cr_dwBean> l=new ArrayList<Cr_dwBean>();
		int count = 0;
		int id = 0;
		try{
			List<Row> lst = DbMethod.makeDbSingleton().Open("ztbg_Czhj_Czdk_Hddwcx", jcdw_plhcBean,
					jcdw_plhcBean.getSize(),jcdw_plhcBean.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
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
				Cr_dwBean cb = new Cr_dwBean();
				cb.setDwzh(row.getTrimString("dwzh"));
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
				l.add(cb);
				i++;
			}
			t.setData(l);
			t.setTotalcount(count);
		} catch (Exception e) {
			trace = "<font color='red'>财政代扣查询失败:" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}

	/**
	 * 财政数据校验导入
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "财政代扣核定单位查询", fwdm = "hddwcx", ywdm = "czhj", fwdz = "czhj/sjdr.service")
	@RequestMapping(value = "ZTBG/czhj/sjdr.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Dr(@RequestBody Jcdw_plhcBean1 bean) {
		DataResult t=new DataResult();
		String trace = "";
		List<Jcdw_plhcBean1> l=new ArrayList<Jcdw_plhcBean1>();
		try{
			int count = 0;
			List<Row> list = DbMethod.makeDbSingleton().Open("ztbg_Czhj_Czdk_Dr", bean,0,0);
			if (list.size() == 0) {
				Jcdw_plhcBean1 cb = new Jcdw_plhcBean1();
				cb.setRet(bean.getRet());
				cb.setMsg(bean.getMsg());
				cb.setCount(count);
				l.add(cb);
			} else {
				for(Row row : list){
					Jcdw_plhcBean1 bean1 = new Jcdw_plhcBean1();
					bean1.setSbyy(row.getTrimString("msg").trim());
					bean1.setDwzh(row.getTrimString("dwzh"));
					bean1.setDwmc(row.getTrimString("dwmc"));
					bean1.setXingming(row.getTrimString("xingming"));
					bean1.setZjhm(row.getTrimString("zjhm"));
					bean1.setRet(bean.getRet());
					bean1.setMsg(bean.getMsg());
					bean1.setCount(count);
					l.add(bean1);
				}
			}
			t.setData(l);
			t.setMsg(bean.getMsg());
		} catch (Exception e) {
			trace = "<font color='red'>财政代扣 实缴金额核对:" + e.getMessage() + "</font>";
			log.error(trace);
			bean.setMsg(e.getMessage());
		} 
		return t;
	}
	
	@HttpServiceInfo(qddm = "ZTBG", fwname = "财政代扣核定导入结果查询", fwdm = "jgcx", ywdm = "czhj", fwdz = "czhj/jgcx.service")
	@RequestMapping(value = "ZTBG/czhj/jgcx.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Jgcx(@RequestBody Jcdw_plhcBean1 bean) {
		String trace = "";
		DataResult t = new DataResult();
		List<Jcdw_plhcBean1> l=new ArrayList<Jcdw_plhcBean1>();
		try {
			int count = 0;			
			List<Row> list = DbMethod.makeDbSingleton().Open("ztbg_Czhj_Czdk_Jgcx", bean,0,0);
			count = list.size() > 0 ? list.get(0).getDefInt("count") : 0;
			if (list.size() == 0) {
				Jcdw_plhcBean1 cb = new Jcdw_plhcBean1();
				cb.setRet(bean.getRet());
				l.add(cb);
			} else {
				for(Row row : list){
					Jcdw_plhcBean1 bean1 = new Jcdw_plhcBean1();
					bean1.setMsg(row.getTrimString("msg"));
					bean1.setJyjg(row.getTrimString("jyjg"));
					bean1.setRet(row.getDefInt("id"));
					bean1.setCount(count);
					l.add(bean1);
				}
				
			}t.setData(l);			
		} catch (Exception e) {
			trace = "<font color='red'> 财政数据校验导出错误信息：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	/**
	 * 错误信息导出查询
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "财政代扣错误信息导出查询", fwdm = "cwxxdxcx", ywdm = "czhj", fwdz = "czhj/cwxxdxcx.service")
	@RequestMapping(value = "ZTBG/czhj/cwxxdxcx.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Cwxxdccx(@RequestBody Jcdw_plhcBean1 bean) {
		String trace = "";
		DataResult t = new DataResult();
		List<Jcdw_plhcBean1> l=new ArrayList<Jcdw_plhcBean1>();
		try {
			int count = 0;			
			List<Row> list = DbMethod.makeDbSingleton().Open("ztbg_Czhj_Czdk_Cwxxdccx", bean,0,0);
			count = list.size() > 0 ? list.get(0).getDefInt("count") : 0;
			if (list.size() == 0) {
				Jcdw_plhcBean1 cb = new Jcdw_plhcBean1();
				cb.setRet(bean.getRet());
				l.add(cb);
			} else {
				for(Row row : list){
					Jcdw_plhcBean1 bean1 = new Jcdw_plhcBean1();
					bean1.setXingming(row.getTrimString("xingming"));
					bean1.setDwzh(row.getTrimString("dwzh"));
					bean1.setDwmc(row.getTrimString("dwmc"));
				    bean1.setZjhm(row.getTrimString("zjhm"));
					bean1.setSbyy(row.getTrimString("msg"));
					bean1.setCount(count);
					l.add(bean1);
				}
				
			}t.setData(l);			
		} catch (Exception e) {
			trace = "<font color='red'> 财政数据校验导出错误信息：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	/**
	 * 未分配金额导出
	 * @param jcdw_plhcBean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "财政代扣未分配金额导出", fwdm = "wfpjedc", ywdm = "czhj", fwdz = "czhj/wfpjedc.service")
	@RequestMapping(value = "ZTBG/czhj/wfpjedc.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Wfpjedc(@RequestBody Jcdw_plhcBean1 jcdw_plhcBean) {
		DataResult t=new DataResult();
		String trace = " ";
		List<Jcdw_plhcBean1> l=new ArrayList<Jcdw_plhcBean1>();
		int count = 0;
		int id = 0;
		try{
			List<Row> lst = DbMethod.makeDbSingleton().Open("ztbg_Czhj_Czdk_Wfpjedc", jcdw_plhcBean,
					jcdw_plhcBean.getSize(),jcdw_plhcBean.getPage());
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			int i = 0;
			for (Row row : lst) {
				Jcdw_plhcBean1 cb = new Jcdw_plhcBean1();
				cb.setDwzh(row.getTrimString("dwzh"));
				cb.setDwmc(row.getTrimString("dwmc"));
				cb.setHjje(row.getDefDouble("hjje"));
				l.add(cb);
				i++;
			}
			t.setData(l);
			t.setTotalcount(count);
		} catch (Exception e) {
			trace = "<font color='red'>未分配金额导出查询失败:" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}

	/**
	 * 批量核定分配完成办理
	 * @param bean
	 * @return
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = "财政代扣批量核定分配完成办理", fwdm = "plhdfpwcbl", ywdm = "czhj", fwdz = "czhj/plhdfpwcbl.service")
	@RequestMapping(value = "ZTBG/czhj/plhdfpwcbl.service", method = RequestMethod.POST)
	public DataResult ztbg_Czhj_Czdk_Plhdfpwcbl(@RequestBody Jcdw_plhcBean1 bean) {
		DataResult t=new DataResult();
		String trace = "";
		try{
			DbMethod.makeDbSingleton().Execute("ztbg_Czhj_Czdk_Plhdfpwcbl",bean);
		} catch (Exception e) {
			trace = "<font color='red'>批量核定完成办理:" + e.getMessage() + "</font>";
			log.error(trace);
			bean.setMsg(e.getMessage());
		}
		t.setData(bean);
		return t;
	}
}