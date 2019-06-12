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
import com.shineyue.bean.ztbg.Gjzf_gr_zz;
import com.shineyue.bean.ztbg.Jcdwhjhdbean;
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_jcdwjcrxxplbg {
private static final Log log = LogFactory.getLog(Ztbg_jcdwjcrxxplbg.class);		
	
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人批量信息变更清册查询", fwdm = "qccx", ywdm = "jcdwjcrxxplbg", fwdz = "jcdwjcrxxplbg/qccx.service")
	@RequestMapping(value = "ZTBG/jcdwjcrxxplbg/qccx.service", method = RequestMethod.POST)
	
	public DataResult Ztbg_jcdwjcrxxplbg_qccx(@RequestBody Cr_dwBean Cr_dwBean) {
		String trace = "";
		DataResult t = new DataResult();
		int count = 0;
		List<Cr_dwBean> l=new ArrayList<Cr_dwBean>();
		try {
			List<Row> lst=DbMethod.makeDbSingleton().Open("Ztbg_jcdwjcrxxplbg_qccx",Cr_dwBean,Cr_dwBean.getSize(),Cr_dwBean.getPage());
			
			count = lst.size() > 0 ? lst.get(0).getDefInt("count") : 0;
			t.setTotalcount(count);
			for (Row row : lst) {
				Cr_dwBean bean=new Cr_dwBean();
				bean.setJgmc(row.getTrimString("jgmc"));
				bean.setDwzh(row.getTrimString("dwzh"));
				bean.setDwbh(row.getTrimString("dwbh"));
				bean.setDwmc(row.getTrimString("dwmc"));
				bean.setZjlx(row.getTrimString("zjlx"));
				bean.setId1(row.getDefLong("id"));
				bean.setBpmid(row.getDefLong("bpmid"));
				bean.setGrzh(row.getTrimString("grzh"));
				bean.setGrbh(row.getTrimString("grbh"));
				bean.setXingming(row.getTrimString("xingming"));
				bean.setZjhm(row.getTrimString("zjhm"));
				bean.setBgxm(row.getTrimString("bgxm"));
				bean.setYwlsh(row.getTrimString("ywlsh"));
				bean.setLrczy(row.getTrimString("lrczy"));
				bean.setBgrq("".equals(row.getTrimString("bgrq"))? "" :row.getTrimString("bgrq").substring(0, 10));
				bean.setBgqxx(row.getTrimString("bgqxx"));
				bean.setBghxx(row.getTrimString("bghxx"));
				bean.setYwmxlx(row.getTrimString("ywmxlx"));

				l.add(bean);
			}
			t.setData(l);
		}catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'>缴存人批量信息变更清册查询失败：" + e.getMessage()
					+ "</font>";
			log.error(trace);
		}
		return t;
	}
	
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存人信息批量变更导入", fwdm = "jcdwjcrxxplbgdr", ywdm = "jcdwjcrxxplbg", fwdz = "jcdwjcrxxplbg/jcdwjcrxxplbgdr.service")
	@RequestMapping(value = "ZTBG/jcdwjcrxxplbg/jcdwjcrxxplbgdr.service", method = RequestMethod.POST)
	public DataResult Ztbg_jcdwjcrxxplbg_dr(@RequestBody Gjzf_gr_zz Gjzf_gr_zz) {
		String trace = "";
		int count=0;
		DataResult t = new DataResult();
		List<Gjzf_gr_zz> l=new ArrayList<Gjzf_gr_zz>();
		try {
			List<Row> list = DbMethod.makeDbSingleton().Open(
					"Ztbg_jcdwjcrxxplbg_dr", Gjzf_gr_zz);
			if (list.size() == 0) {
				Gjzf_gr_zz cb = new Gjzf_gr_zz();
				cb.setMsg(Gjzf_gr_zz.getMsg());
				cb.setRet(Gjzf_gr_zz.getRet());
				l.add(cb);
			} else {
				for(Row row : list){
					Gjzf_gr_zz bean1 = new Gjzf_gr_zz();
					bean1.setGrzh(row.getTrimString("grzh"));
				    bean1.setXingming(row.getTrimString("xingming"));
					bean1.setMsg(row.getTrimString("msg").trim());
					bean1.setCount(count);
					bean1.setRet1(Gjzf_gr_zz.getRet1());
					l.add(bean1);
				}
			}
			t.setData(l);
			t.setMsg(Gjzf_gr_zz.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			trace = "<font color='red'> 缴存人信息批量变更清册导入：" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		return t;
	}
	
	/**
	 * 清册删除
	 */
	@HttpServiceInfo(qddm = "ZTBG", fwname = " 缴存人信息批量变更清册删除", fwdm = "qcsc", ywdm = "jcdwjcrxxplbg", fwdz = "jcdwjcrxxplbg/qcsc.service")
	@RequestMapping(value = "ZTBG/jcdwjcrxxplbg/qcsc.service", method = RequestMethod.POST)
	public DataResult Ztbg_jcdwjcrxxplbg_sc(@RequestBody Gjzf_gr_zz gjzf_gr_zz) {
		String trace = "";
		DataResult t=new DataResult();
		try {
			DbMethod.makeDbSingleton().Execute("Ztbg_jcdwjcrxxplbg_sc",gjzf_gr_zz);			
		} catch (Exception e) {
			trace = "<font color='red'> 缴存人信息批量变更清册删除：" + e.getMessage()+ "</font>";
			log.error(trace);
		}
		t.setData(gjzf_gr_zz);
		return t;
	}
}

