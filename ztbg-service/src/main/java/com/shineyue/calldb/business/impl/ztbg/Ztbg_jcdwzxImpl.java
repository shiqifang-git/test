package com.shineyue.calldb.business.impl.ztbg;

import java.util.List;

import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.calldb.CallDbException;
import com.shineyue.calldb.SqlParameterExt;
import com.shineyue.calldb.business.AbstractDbInterface;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.XTool;

public class Ztbg_jcdwzxImpl extends AbstractDbInterface{
	public Ztbg_jcdwzxImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	public List<Row> openZtbg_Jcdwzx_bgxxcx(Object obj) throws CallDbException {
		Jcdwhjbean pmt = (Jcdwhjbean) obj;
		Long v_bpmid = pmt.getBpmid();		
		String sql =  "select a.dwzh,b.dwbh ,c.dwmc,c.jbrxm,c.jbrgddhhm,c.dwdz,nvl((d.gryjce+d.dwyjce+d.bcyjce+d.czybte),0) yjcze,a.ywlsh, " +
				"b.dwfcrs,b.dwjcrs, f_hfsc_get_value(b.dwzh,'dwzhye') dwzhye,a.bgdjrq bgsqrq, a.bgyy bgsqyy,a.bpmid,a.spzt,a.BGDJCZYID czyid  " 
		+" from gjzf_dw_zzbg a inner join gjzf_dw_zz b on a.dwzh = b.dwzh" 
		+" inner join cr_dw c on b.dwbh = c.dwbh"  
		+" left join gjzf_gr_zz d on d.dwzh=b.dwzh and d.grzhzt='01' "
		+" where a.bglbbm = '79' and  a.bpmid = "+v_bpmid;
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwzx_bgxxcx]出错"+ e.getMessage());
		}
	}
	public List<Row> openZtbg_Jcdwzx_bgxxprint(Object obj) throws CallDbException {
		Jcdwhjbean pmt = (Jcdwhjbean) obj;
		Long v_bpmid = pmt.getBpmid();	
		String zxbm = pmt.getZxbm();
		String sql =  "select a.spczy,a.dwzh ,c.dwmc,c.jbrxm,c.jbrsjhm,b.dwjcrs,nvl((d.gryjce+d.dwyjce+d.bcyjce+d.czybte),0) yjcze,"
				+"a.bgdjrq bgsqrq,e.mc bgsqyy,a.bpmid,a.ywlsh,a.spczy bgsxczy,a.bgdjczy bgsqczy,'同意' csyj,case when b.qjny>b.dwjzny then ' ' else b.dwjzny end jzny,a.bpmid " 
				+" from gjzf_dw_zzbg a inner join gjzf_dw_zz b on a.dwzh = b.dwzh" 
				+" inner join cr_dw c on b.dwbh = c.dwbh"  
				+" left join gjzf_gr_zz d on d.dwzh=b.dwzh and d.grzhzt='01' "
				+" inner join bm_gz_dwxhyy e on e.bm=a.bgyy and e.jgbm='"+zxbm+"' "
				+" where a.bglbbm = '79' and  a.bpmid = "+v_bpmid;
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwzx_bgxxprint]出错"+ e.getMessage());
		}
	}
}
