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
import com.shineyue.calldb.DbMethod;
import com.shineyue.calldb.model.xtgl.OptlogBean;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.HttpServiceInfo;
import com.shineyue.calldb.util.bean.DataResult;

@RestController
public class Ztbg_jcdwhj {
	private static final Log log = LogFactory.getLog(Ztbg_jcdwhj.class);		
	
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位缓缴变更信息查询", fwdm = "bgxxcx", ywdm = "jcdwhj", fwdz = "jcdwhj/bgxxcx.service")
	@RequestMapping(value = "ZTBG/jcdwhj/bgxxcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhj_Bgxx_Cx(@RequestBody Jcdwhjbean jcdwhjbean) {
		DataResult t=new DataResult();
		String trace = "";
		Jcdwhjbean cb = new  Jcdwhjbean();
		try {
			
			System.out.println("++++++++++++++++++进入新加方法++++++++++++++++++++++++++++");
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwhj_Bgxx_Cx",jcdwhjbean);
			int count = lst.size();
			t.setTotalcount(count);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++lst:"+lst.size());
			if (lst.size() > 0) {
				Row row = lst.get(0);
				if(row.getString("bglbmc").equals("缓缴")){
					cb.setDwzh(row.getString("dwzh"));
					cb.setDwmc(row.getString("dwmc"));
					cb.setDwbh(row.getString("dwbh"));
					cb.setJbrxm(row.getString("jbrxm"));
					cb.setJbrsjhm(row.getTrimString("jbrsjhm"));
					cb.setDwjcrs(row.getDefInt("dwjcrs"));
					cb.setYjcze(row.getTrimString("yjcze"));
					cb.setDwjcbl(row.getTrimString("dwjcbl"));
					cb.setGrjcbl(row.getTrimString("grjcbl"));
					cb.setBgsqrq(row.getString("bgsqrq"));
					cb.setBgksny(row.getString("bgksny"));
					cb.setBgjsny(row.getString("bgjsny"));
					cb.setBgsqyy(row.getString("bgsqyy"));	
					cb.setYwlsh(row.getString("ywlsh"));
					cb.setJzny(row.getTrimString("jzny"));
					cb.setBgsqczy(row.getTrimString("bgsqczy"));
					cb.setBpmid(row.getDefLong("bpmid"));
					cb.setBglb(row.getString("bglbmc"));
					cb.setCzyid(row.getTrimString("czyid"));
					cb.setSpzt(row.getTrimString("spzt"));
				} else {
					cb.setDwzh(row.getString("dwzh"));
					cb.setDwmc(row.getString("dwmc"));
					cb.setDwbh(row.getString("dwbh"));
					cb.setJbrxm(row.getString("jbrxm"));
					cb.setJbrsjhm(row.getTrimString("jbrsjhm"));
					cb.setDwjcrs(row.getDefInt("dwjcrs"));
					cb.setYjcze(row.getTrimString("yjcze"));
					cb.setDwjcbl(row.getTrimString("dwjcbl"));
					cb.setGrjcbl(row.getTrimString("grjcbl"));
					cb.setBgsqrq(row.getString("bgsqrq"));
					cb.setBgsqyy(row.getString("bgsqyy"));
					cb.setYwlsh(row.getString("ywlsh"));
					cb.setJzny(row.getTrimString("jzny"));
					cb.setBgsqczy(row.getTrimString("bgsqczy"));
					cb.setBglb(row.getString("bglbmc"));
					cb.setBpmid(Long.parseLong("0"));
					cb.setCzyid(row.getTrimString("czyid"));
					cb.setSpzt(row.getTrimString("spzt"));
					cb.setBgksny(row.getString("bgksny"));
					cb.setBgjsny(row.getString("bgjsny"));
				}
			}
			OptlogBean bean = new OptlogBean();
			bean.setBlqd(jcdwhjbean.getBlqd());
			bean.setCzfl(jcdwhjbean.getCxfl());
			bean.setJgbm(jcdwhjbean.getJgbm());
			bean.setKhbh(jcdwhjbean.getKhbh());
			bean.setMsg("单位缓缴");
			bean.setUserid(jcdwhjbean.getUserid());
			bean.setYwczbs("1");
			bean.setYwczje(0);
			bean.setYwfl(jcdwhjbean.getYwfl());
			bean.setYwlb(jcdwhjbean.getYwlb());
			bean.setYwlsh(jcdwhjbean.getYwlsh());
			bean.setYwzy("缓缴处理信息查询");
			bean.setZhbh(jcdwhjbean.getZhbh());
			bean.setZxjgbm(jcdwhjbean.getZxbm());
			DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", bean);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位缓缴/解除缓缴变更信息查询 :" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		t.setData(cb);
		return t;
	}

	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位缓缴打印凭条", fwdm = "dypt", ywdm = "jcdwhj", fwdz = "jcdwhj/dypt.service")
	@RequestMapping(value = "ZTBG/jcdwhj/dypt.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwhj_Dypt(@RequestBody Jcdwhjbean jcdwhjbean) {
		DataResult t=new DataResult();
		String trace = "";
		List<Jcdwhjbean> list = new  ArrayList<Jcdwhjbean>();
		try {
			System.out.println("______++++++++++走进方法__________________++++++++++++++++++++++++");
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwhj_Dypt",jcdwhjbean);
			if (lst.size() > 0) {
				Jcdwhjbean cb = new  Jcdwhjbean();
				Row row = lst.get(0);
				if(row.getString("bglbmc").equals("缓缴")){
					cb.setDwzh(row.getString("dwzh"));
					cb.setDwmc(row.getString("dwmc"));
					cb.setJbrxm(row.getString("jbrxm"));
					cb.setJbrsjhm(row.getTrimString("jbrsjhm"));
					cb.setDwjcrs(row.getDefInt("dwjcrs"));
					cb.setYjcze(row.getTrimString("yjcze"));
					cb.setDwjcbl(row.getTrimString("dwjcbl"));
					cb.setGrjcbl(row.getTrimString("grjcbl"));
					cb.setBgsqrq(row.getString("bgsqrq"));
					cb.setBgksny(row.getString("bgksny"));
					cb.setBgjsny(row.getString("bgjsny"));
					cb.setBgsqyy(row.getString("bgsqyy"));	
					cb.setYwlsh(row.getString("ywlsh"));
					cb.setJzny(row.getTrimString("jzny"));
					cb.setBgsqczy(row.getTrimString("bgsqczy"));
					cb.setBpmid(row.getDefLong("bpmid"));
					cb.setBglb(row.getString("bglbmc"));
					cb.setSpzt(row.getTrimString("spzt"));
					
					
					cb.setBgksny(row.getTrimString("bgksny"));
					cb.setBgsqrq(row.getTrimString("bgsqrq"));
					cb.setBgjsny(row.getTrimString("bgjsny"));
					cb.setBgsqyy(row.getTrimString("bgsqyy"));
					cb.setSpczy(row.getTrimString("spczy"));
					
				} else {
					cb.setDwzh(row.getString("dwzh"));
					cb.setDwmc(row.getString("dwmc"));
					cb.setJbrxm(row.getString("jbrxm"));
					cb.setJbrsjhm(row.getTrimString("jbrsjhm"));
					cb.setDwjcrs(row.getDefInt("dwjcrs"));
					cb.setYjcze(row.getTrimString("yjcze"));
					cb.setDwjcbl(row.getTrimString("dwjcbl"));
					cb.setGrjcbl(row.getTrimString("grjcbl"));
					cb.setBgsqrq(row.getString("bgsqrq"));
					cb.setBgsqyy(row.getString("bgsqyy"));
					cb.setYwlsh(row.getString("ywlsh"));
					cb.setJzny(row.getTrimString("jzny"));
					cb.setBgsqczy(row.getTrimString("bgsqczy"));
					cb.setBglb(row.getString("bglbmc"));
					cb.setBpmid(Long.parseLong("0"));
					cb.setSpzt(row.getTrimString("spzt"));
					cb.setBgksny(row.getString("bgksny"));
					cb.setBgjsny(row.getString("bgjsny"));
					cb.setSpczy(row.getTrimString("spczy"));
				}
				list.add(cb);
			}
			OptlogBean bean = new OptlogBean();
			bean.setBlqd(jcdwhjbean.getBlqd());
			bean.setCzfl(jcdwhjbean.getCxfl());
			bean.setJgbm(jcdwhjbean.getJgbm());
			bean.setKhbh(jcdwhjbean.getKhbh());
			bean.setMsg("");
			bean.setUserid(jcdwhjbean.getUserid());
			bean.setYwczbs("1");
			bean.setYwczje(0);
			bean.setYwfl(jcdwhjbean.getYwfl());
			bean.setYwlb(jcdwhjbean.getYwlb());
			bean.setYwlsh(jcdwhjbean.getYwlsh());
			bean.setYwzy(jcdwhjbean.getYwzy());
			bean.setZhbh(jcdwhjbean.getZhbh());
			bean.setZxjgbm(jcdwhjbean.getZxbm());
			DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", bean);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位缓缴/解除缓缴变更信息查询 :" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		t.setData(list);
		return t;
	}
}

