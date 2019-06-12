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
public class Ztbg_jcdwzx {
	private static final Log log = LogFactory.getLog(Ztbg_jcdwzx.class);		
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位注销", fwdm = "bgxxcx", ywdm = "jcdwzx", fwdz = "jcdwzx/bgxxcx.service")
	@RequestMapping(value = "ZTBG/jcdwzx/bgxxcx.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwzx_bgxxcx(@RequestBody Jcdwhjbean gjzf_dw_jcbg) {
		DataResult t=new DataResult();
		String trace = "";
		Jcdwhjbean cb = new  Jcdwhjbean();
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwzx_bgxxcx",gjzf_dw_jcbg);
			List <Jcdwhjbean> l=new ArrayList<Jcdwhjbean>();
			if("gt".equals(gjzf_dw_jcbg.getBlqd())){
				if (lst.size() > 0) {
					Row row = lst.get(0);
					cb.setDwzh(row.getString("dwzh"));
					cb.setDwbh(row.getTrimString("dwbh"));
					cb.setDwmc(row.getString("dwmc"));
					cb.setJbrxm(row.getString("jbrxm"));
					cb.setJbrgddhhm(row.getString("jbrgddhhm"));
					cb.setDwdz(row.getString("dwdz"));
					cb.setYjce(row.getDefDouble("yjcze"));
					cb.setDwfcrs(row.getDefInt("dwfcrs"));
					cb.setDwjcrs(row.getDefInt("dwjcrs"));
					cb.setDwzhye(row.getDefDouble("dwzhye"));
					cb.setBgsqrq(row.getString("bgsqrq"));
					cb.setBgsqyy(row.getString("bgsqyy"));
					cb.setBpmid(row.getDefLong("bpmid"));		
					cb.setSpzt(row.getTrimString("spzt"));
					cb.setYwlsh(row.getTrimString("ywlsh"));
					cb.setCzyid(row.getTrimString("czyid"));
					l.add(cb);
				}
				t.setData(l);
				t.setTotalcount(lst.size());
			}else{
				if (lst.size() > 0) {
					Row row = lst.get(0);
					cb.setDwzh(row.getString("dwzh"));
					cb.setDwbh(row.getTrimString("dwbh"));
					cb.setDwmc(row.getString("dwmc"));
					cb.setJbrxm(row.getString("jbrxm"));
					cb.setJbrgddhhm(row.getString("jbrgddhhm"));
					cb.setDwdz(row.getString("dwdz"));
					cb.setYjce(row.getDefDouble("yjcze"));
					cb.setDwfcrs(row.getDefInt("dwfcrs"));
					cb.setDwjcrs(row.getDefInt("dwjcrs"));
					cb.setDwzhye(row.getDefDouble("dwzhye"));
					cb.setBgsqrq(row.getString("bgsqrq"));
					cb.setBgsqyy(row.getString("bgsqyy"));
					cb.setBpmid(row.getDefLong("bpmid"));		
					cb.setSpzt(row.getTrimString("spzt"));
					cb.setYwlsh(row.getTrimString("ywlsh"));
					cb.setCzyid(row.getTrimString("czyid"));
				}
				t.setData(cb);
		//		DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", gjzf_dw_jcbg);
				
			}
			
			//DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", gjzf_dw_jcbg);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位注销信息查询:" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		
		return t;
	}
	@HttpServiceInfo(qddm = "ZTBG", fwname = "缴存单位注销", fwdm = "bgxxprint", ywdm = "jcdwzx", fwdz = "jcdwzx/bgxxprint.service")
	@RequestMapping(value = "ZTBG/jcdwzx/bgxxprint.service", method = RequestMethod.POST)
	public DataResult Ztbg_Jcdwzx_bgxxprint(@RequestBody Jcdwhjbean gjzf_dw_jcbg) {
		DataResult t=new DataResult();
		String trace = "";
		List<Jcdwhjbean> l=new ArrayList<Jcdwhjbean>();
		try {
			List<Row> lst = DbMethod.makeDbSingleton().Open("Ztbg_Jcdwzx_bgxxprint",gjzf_dw_jcbg);
			if (lst.size() > 0) {
				Row row = lst.get(0);
				Jcdwhjbean cb = new  Jcdwhjbean();
				cb.setDwzh(row.getString("dwzh"));
				cb.setDwmc(row.getString("dwmc"));
				cb.setJbrxm(row.getString("jbrxm"));
				cb.setJbrsjhm(row.getString("jbrsjhm"));
				cb.setDwjcrs(row.getDefInt("dwjcrs"));
				cb.setYjcze(row.getTrimString("yjcze"));
				cb.setBgsqrq(row.getTrimString("bgsqrq"));
				cb.setBgsqyy(row.getTrimString("bgsqyy"));
				cb.setYwlsh(row.getTrimString("ywlsh"));
				cb.setBgsxczy(row.getTrimString("bgsxczy"));
				cb.setBgsqczy(row.getTrimString("bgsqczy"));
				cb.setCsyj(row.getTrimString("csyj"));	
				cb.setJzny(row.getTrimString("jzny"));
				cb.setBpmid(row.getDefLong("bpmid"));
				cb.setSpczy(row.getTrimString("spczy"));
				
				cb.setSp(row.getTrimString("spczy"));
				
				System.out.println("+____________+_spczy"+row.getTrimString("spczy"));
				l.add(cb);
			}
			DbMethod.makeDbSingleton().Execute("WaCommon_OPTLOG_ADD_CX", gjzf_dw_jcbg);
		} catch (Exception e) {
			trace = "<font color='red'>缴存单位注销信息查询:" + e.getMessage() + "</font>";
			log.error(trace);
		} 
		t.setData(l);
		return t;
	}
}

