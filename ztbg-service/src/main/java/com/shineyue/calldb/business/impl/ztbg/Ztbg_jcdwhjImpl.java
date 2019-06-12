package com.shineyue.calldb.business.impl.ztbg;

import java.util.List;

import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.calldb.CallDbException;
import com.shineyue.calldb.SqlParameterExt;
import com.shineyue.calldb.business.AbstractDbInterface;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.util.XTool;

public class Ztbg_jcdwhjImpl extends AbstractDbInterface{
	public Ztbg_jcdwhjImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	/**
	 * 缴存单位缓缴/解除缓缴变更信息查询
	 * @param obj
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openZtbg_Jcdwhj_Bgxx_Cx(Object obj) throws CallDbException {
		Jcdwhjbean pmt = (Jcdwhjbean) obj;
		String v_dwzh = XTool.TransactSQLInjection(pmt.getDwzh());
		Long v_bpmid = pmt.getBpmid();
		String v_cxfl = XTool.TransactSQLInjection(pmt.getCxfl());
		String sql = "";
		if(v_cxfl.equals("01")){
			sql = " select a.dwzh,b.dwbh ,c.dwmc,c.jbrxm,c.jbrsjhm,b.dwjcrs,b.yjcze,b.dwjcbl,b.grjcbl,a.bgsqrq," 
					+"a.bgksny,a.bgjsny,a.bgsqyy,a.ywlsh,b.jzny,a.bgsqczy,a.bpmid,a.bglbmc,a.spzt,a.bgsqczyid czyid " 
					+" from gjzf_dw_jcbg a inner join gjzf_dw_zz b on a.dwzh = b.dwzh" 
					+" inner join cr_dw c on b.dwbh = c.dwbh " 
					+" where a.bglb = '13' and a.bpmid = '"+v_bpmid+"'";
		} else if (v_cxfl.equals("02")){
			sql = " select a.dwzh,b.dwbh ,c.dwmc,c.jbrxm,c.jbrsjhm,b.dwjcrs,b.yjcze,b.dwjcbl,b.grjcbl,a.bgsqrq," +
					"a.bgksny,a.bgjsny,a.bgsqyy,a.ywlsh,b.jzny,a.bgsqczy,a.bpmid,a.bglbmc,a.spzt,a.bgsqczyid czyid " 
					+" from gjzf_dw_jcbg a inner join gjzf_dw_zz b on a.dwzh = b.dwzh" 
					+" inner join cr_dw c on b.dwbh = c.dwbh " 
					+" where a.bglb = '13' and a.dwzh = '"+v_dwzh+"' and a.bgsprq is not null order by a.bgsqsj desc ";
		} else if (v_cxfl.equals("03")){
			sql = "select a.dwzh ,b.dwbh,c.dwmc,c.jbrxm,c.jbrsjhm,b.dwjcrs,b.yjcze,b.dwjcbl,b.grjcbl,a.bgsqrq bgsqrq," +
					" a.bgksny,a.bgjsny,a.bgsqyy bgsqyy, a.ywlsh,b.jzny,a.bgsqczy bgsqczy,a.bglbmc bglbmc,a.bpmid,a.spzt,a.bgsqczyid czyid " +
					" from gjzf_dw_jcbg a inner join gjzf_dw_zz b on a.dwzh = b.dwzh " +
					" inner join cr_dw c on b.dwbh = c.dwbh  "+ 
					" where a.bglb = '13' and a.bpmid = '"+v_bpmid+"'";
		} else {
			sql =" ";
		}
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openJcdw_Dwhjjchj_Bgxx_Cx]出错"+ e.getMessage());
		}
	}
	/**
	 * 缴存单位缓缴/解除缓缴变更信息查询
	 * @param obj
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openZtbg_Jcdwhj_Dypt(Object obj) throws CallDbException {
		Jcdwhjbean pmt = (Jcdwhjbean) obj;
		Long v_bpmid = pmt.getBpmid();
		String v_cxfl = XTool.TransactSQLInjection(pmt.getCxfl());
		String sql = "";
		if(v_cxfl.equals("01")){
			sql = " select max(us.f_caption) spczy,max(a.dwzh) dwzh,max(c.dwmc) dwmc,max(c.jbrxm) jbrxm,max(c.jbrsjhm) jbrsjhm,max(b.dwjcrs) dwjcrs," 
					+" nvl(sum(d.gryjce+d.dwyjce+d.bcyjce+d.czybte),0) yjcze,max(b.dwjcbl) dwjcbl,max(b.grjcbl) grjcbl,max(a.bgsqrq) bgsqrq," 
					+" max(a.bgksny) bgksny,max(a.bgjsny) bgjsny,max(a.bgsqyy) bgsqyy,max(a.ywlsh) ywlsh,case when max(b.qjny)>max(b.dwjzny) then ' ' else max(b.dwjzny) end jzny," 
					+" max(a.bgsqczy) bgsqczy,max(a.bpmid) bpmid,max(a.bglbmc) bglbmc,max(a.spzt) spzt " 
					+" from gjzf_dw_jcbg a inner join gjzf_dw_zz b on a.dwzh = b.dwzh" 
					+" inner join cr_dw c on b.dwbh = c.dwbh " 
					+" left join gjzf_gr_zz d on d.dwzh=b.dwzh and d.grzhzt='01' "
					+"   left join  t_mk_sys_user  us on a.bgspczyid =us.id "
					+" where a.bglb = '13' and a.bpmid = '"+v_bpmid+"'"
					+" group by a.dwzh ";  
		} else if (v_cxfl.equals("03")){
			sql = "select  max(us.f_caption) spczy,max(a.bgksny) bgksny, max(a.bgsqrq) bgsqrq,max(a.bgjsny) bgjsny,max(a.bgsqyy) bgsqyy,max(a.dwzh) dwzh,max(c.dwmc) dwmc,max(c.jbrxm) jbrxm,max(c.jbrsjhm) jbrsjhm,max(b.dwjcrs) dwjcrs," +
					" nvl(sum(d.gryjce+d.dwyjce+d.bcyjce+d.czybte),0) yjcze,max(b.dwjcbl) dwjcbl,max(b.grjcbl) grjcbl,max(a.bgsqrq) bgsqrq," +
					" max(a.bgksny) bgksny,max(a.bgjsny) bgjsny,max(a.bgsqyy) bgsqyy, max(a.ywlsh) ywlsh,case when max(b.qjny)>max(b.dwjzny) then ' ' else max(b.dwjzny) end jzny,max(a.bgsqczy) bgsqczy,max(a.bglbmc) bglbmc,max(a.bpmid) bpmid,max(a.spzt) spzt " +
					" from gjzf_dw_jcbg a inner join gjzf_dw_zz b on a.dwzh = b.dwzh " +
					" inner join cr_dw c on b.dwbh = c.dwbh  "+ 
					" left join gjzf_gr_zz d on d.dwzh=b.dwzh and d.grzhzt='01' "+
					"   left join  t_mk_sys_user  us on a.bgspczyid =us.id "+
					" where a.bglb = '13' and a.bpmid = '"+v_bpmid+"'"
					+" group by a.dwzh ";  
		} else {
			sql =" ";
		}	
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwhj_Dypt]出错"+ e.getMessage());
		}
	}
}
