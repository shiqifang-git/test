package com.shineyue.calldb.business.impl.ztbg;

import java.util.List;

import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.bean.ztbg.Jcdwhjhdbean;
import com.shineyue.bean.ztbg.Jcdwhjhddy;
import com.shineyue.bean.ztbg.Jcdwhjhdtsqy;
import com.shineyue.calldb.CallDbException;
import com.shineyue.calldb.SqlParameterExt;
import com.shineyue.calldb.business.AbstractDbInterface;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.sql.value.IntValue;
import com.shineyue.calldb.sql.value.ShortValue;
import com.shineyue.calldb.sql.value.StringValue;
import com.shineyue.calldb.util.XTool;

public class Ztbg_jcdwhjhdImpl extends AbstractDbInterface{
	public Ztbg_jcdwhjhdImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	public List<Row> openZtbg_Jcdwhjhd_jcrdcx(Object obj, int pagesize,int pagenum) throws CallDbException {

		Jcdwhjhdbean pmt = (Jcdwhjhdbean) obj;
		
		String dwzh = pmt.getDwzh();
		String jcyd_end = pmt.getJcyd_end();
		int userid = pmt.getUserid();
		
		SqlParameterExt spx = null;
		String s = "p_hfb_jcdw_hjhd_jcrd_cx(?p1,?p2,?p3,?p4,?p5)";
		String tableName = "tmp_jcdw_hjhd_jcrd_cx";
		String sql = "Select  jcyd,syje,syrs,zjrs,zjje,jsrs,jsje,hjrs,hjje,zckye " +
				"from  tmp_jcdw_hjhd_jcrd_cx order by dwzh,jcyd";
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(dwzh));
			spx.add(new StringValue(jcyd_end));
			spx.add(new IntValue(userid));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);
			
		} catch (Exception e) {
			throw new CallDbException("参数不合法!" + e.getMessage());
		}
		
		try {
			bo.setSqlParameterExt(spx);
			bo.setHjParameter("syje,syrs,zjrs,zjje,jsrs,jsje,hjrs,hjje,zckye");
			List<Row> list = bo.queryProcedureToList(s, tableName, sql, pagesize, pagenum);
			pmt.setMsg(spx.get(4).getString());
			pmt.setRet(spx.get(5).getString());
			return list;
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwhjhd_jcrdcx]出错"+ e.getMessage());
		}

	}
	public List<Row> openZtbg_Jcdwhjhd_jcrdchk(Object obj,int size,int page) throws CallDbException {

		Jcdwhjhdbean pmt = (Jcdwhjhdbean) obj;
		
		String dwzh = pmt.getDwzh();
		
		SqlParameterExt spx = null;
		String s = "p_hfb_jcdw_hjhd_jcrd_chk(?p1,?p2,?p3)";
		String tableName = "tmp_jcdw_hjhd_jcrd_chk";
		String sql = "Select grzh,xingming,dwzh,dwmc,grjcjs,gryjce,dwyjce,msg  " +
				"from tmp_jcdw_hjhd_jcrd_chk order by dwzh,grzh";
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(dwzh));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);
		} catch (Exception e) {
			throw new CallDbException("参数不合法!" + e.getMessage());
		}
		
		try {
			bo.setSqlParameterExt(spx);
			List<Row> list = bo.queryProcedureToList(s, tableName, sql,size,page);
			pmt.setMsg(spx.get(2).getString());
			pmt.setRet(spx.get(3).getString());
			return list;
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwhjhd_jcrdchk]出错"+ e.getMessage());
		}

	}
	
	public void executeZtbg_Jcdwhjhd_jcrdadd(Object obj) throws CallDbException {
		Jcdwhjhdbean pmt = (Jcdwhjhdbean) obj;
		String dwzh = pmt.getDwzh().trim();
		String jcyd_end = pmt.getJcyd_end().trim();
		String blqd = pmt.getBlqd().trim();
		String ywlsh = pmt.getYwlsh().trim();
		int userid = pmt.getUserid();
		
		SqlParameterExt spx = null;
		try {
			spx = new SqlParameterExt();

			spx.add(new StringValue(dwzh)); //
			spx.add(new StringValue(jcyd_end)); //
			spx.add(new StringValue(blqd)); //
			spx.add(new StringValue(ywlsh)); //
			spx.add(new IntValue(userid)); // 
			spx.add(new StringValue("初始msg"), SqlParameterExt.SQL_INPUT_OUTPUT); // p5返回值：
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);
		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
		String s = "p_hfb_jcdw_hjhd_jcrd_add(?p1,?p2,?p3,?p4,?p5,?p6,?p7)";
		try {
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(6).getString());
			pmt.setRet(spx.get(7).getString());
		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcdwhjhd_jcbgqc(Object obj, int pagesize,int pagenum) throws CallDbException {

		Jcdwhjhdbean pmt = (Jcdwhjhdbean) obj;
		
		String dwzh = XTool.TransactSQLInjection(pmt.getDwzh());
		String jcyd_begin = XTool.TransactSQLInjection(pmt.getJcyd_begin());
		String jcyd_end = XTool.TransactSQLInjection(pmt.getJcyd_end());
		int userid = pmt.getUserid();
		SqlParameterExt spx = null;
	    String sql = "select bgyd,dwzh,dwmc,jbrxm, "+
				" jbrsjhm,dwjcrs,yjcze,gryjce,xingming,zjhm,ywlb,dsgrzhye,grzh from  "+
				" ( "+
				" select a.grzh,a.bgyd,a.dwzh,c.dwmc,c.jbrxm, "+
				" c.jbrsjhm,b.dwjcrs,(d.gryjce +d.dwyjce) gryjce,(g.gryjce+g.dwyjce) yjcze,e.xingming,e.zjhm,f.mc ywlb,a.tzhgryjce+a.tzhdwyjce dsgrzhye from  "+
				" gjzf_gr_zzbg a inner join gjzf_dw_zz b "+
				" on a.dwzh=b.dwzh inner join cr_dw c on b.dwbh=c.dwbh  "+
				" inner join gjzf_gr_zz d on a.grzh=d.grzh inner join cr_gr e on d.grbh=e.grbh "+
				" inner join bm_gz_ywlx f on  a.bglbbm=f.bm "+
				" inner join (select dwzh,sum(gryjce) gryjce,sum(dwyjce) dwyjce from gjzf_gr_zz where dwzh= '"+dwzh+"'  and grzhzt='01' group by dwzh) g on a.dwzh=g.dwzh "+
				" where a.bglbbm in('03','04','05') and a.bgyd between '"+jcyd_begin+"' and  '"+jcyd_end+"'  "+
				" and a.dwzh= '"+dwzh+"'  "+
				" union all "+
				" select a.grzh,a.bgyd,a.dwzh,c.dwmc,c.jbrxm, "+
				" c.jbrsjhm,b.dwjcrs,(d.gryjce +d.dwyjce) gryjce,(g.gryjce+g.dwyjce) yjcze,e.xingming,e.zjhm,'基数调整' ywlb,a.tzhgryjce+a.tzhdwyjce-(a.gryjce+a.dwyjce) dsgrzhye from  "+
				" gjzf_gr_zzbg_jc a inner join gjzf_dw_zz b "+
				" on a.dwzh=b.dwzh  inner join cr_dw c on b.dwbh=c.dwbh  "+
				" inner join gjzf_gr_zz d on a.grzh=d.grzh inner join cr_gr e on d.grbh=e.grbh "+
				" inner join bm_gz_ywlx f on  a.bglbbm=f.bm "+
				" inner join (select dwzh,sum(gryjce) gryjce,sum(dwyjce) dwyjce from gjzf_gr_zz where dwzh= '"+dwzh+"'  and grzhzt='01' group by dwzh) g on a.dwzh=g.dwzh "+
				" where  a.bgyd between '"+jcyd_begin+"' and  '"+jcyd_end+"'  "+
				" and a.dwzh= '"+dwzh+"'   ) order by grzh";
		try {
			bo.setSqlParameterExt(spx);
			List<Row> list = bo.queryToList(sql, pagesize, pagenum);
			return list;
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwhjhd_jcbgqc]出错"+ e.getMessage());
		}

	}
	public List<Row> openZtbg_Jcdwhjhd_hbjptprt(Object obj) throws CallDbException {
		Jcdwhjhddy pmt=(Jcdwhjhddy)obj;
		String dwzh=XTool.TransactSQLInjection(pmt.getDwzh());
		String ksyd=XTool.TransactSQLInjection(pmt.getKsyd());
		String jsyd=XTool.TransactSQLInjection(pmt.getJsyd());
		String sql="  select case when trim(max(a.hjrq)) is null then max(a.hdrq)  else max(a.hjrq) end hjrq,max(a.hdczy)hdczy,max(a.ywlsh) ywlsh,max(c.dwmc) dwmc,max(b.dwzh) dwzh,max(c.jbrxm) jbrxm, "+
				//" max(a.syrs) syrs,sum(a.syje) syje," +
				"   max(c.jbrsjhm) jbrsjhm,max(b.dwjcrs) dwjcrs,max(b.yjcze) yjcze,  max((select max(syrs) from gjzf_dw_jcrd where dwzh = '"+dwzh+"' and jcyd ='"+ksyd+"')) syrs,    " +
				"  max((select sum(syje) from gjzf_dw_jcrd where dwzh = '"+dwzh+"' and jcyd ='"+ksyd+"')) syje, max(a.zjrs) zjrs,sum(a.zjje) zjje,max(a.jsrs) jsrs,   sum(a.jsje) jsje,max(hjrs) hjrs,sum(hjje) hjje,max(a.bjje) bjje,max(a.bjrs) bjrs, " +
				"  max(a.jkczy) jkczy,min(a.jcyd) ksyd, case when min(a.jcyd)<>max(a.jcyd) then min(a.jcyd)||'-'||max(a.jcyd) else  max(a.jcyd) end jsyd, max((select sum(gryjce+dwyjce+czybte+bcyjce) " +
				" from gjzf_gr_jchd where grzhzt ='01'  and bgyd  ='"+ksyd+"'  and dwzh  = '"+dwzh+"')) yjcze1 from gjzf_dw_jcrd a inner join gjzf_dw_zz b on  a.dwzh=b.dwzh inner join cr_dw c on b.dwbh=c.dwbh " +
				"  where a.dwzh= '"+dwzh+"' and jcyd between '"+ksyd+"' and '"+jsyd+"'   order by a.jcyd  " ;
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwhjhd_hbjptprt]出错"
					+ e.getMessage());
		}
	}
	public void executeZtbg_Jcdwhjhd_hjfprz(Object obj) throws CallDbException {
		SqlParameterExt spx = null;
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		int ret = 0;
		try {
			spx = new SqlParameterExt();
			/*spx.add(new StringValue(pmt.getDwzh()));
			spx.add(new StringValue(pmt.getJcyd_begin()));
			spx.add(new StringValue(pmt.getJcyd_end()));
			spx.add(new StringValue(pmt.getHjxz()));
			spx.add(new DoubleValue(pmt.getYhjje()));
			spx.add(new StringValue(pmt.getBjywlsh()));
			spx.add(new StringValue(pmt.getDwxz()));*/
			spx.add(new StringValue(pmt.getHbjywlsh()));
			spx.add(new StringValue(pmt.getBlqd()));
			spx.add(new IntValue(pmt.getUserid())); // 
			spx.add(new StringValue(pmt.getMsg()), SqlParameterExt.SQL_INPUT_OUTPUT); //10
			spx.add(new IntValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//11
		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
		String s = "p_hfb_jcdw_hbjfp_hjfp_rz(?,?,?,?,?)";
		try {
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(4).getString());
			pmt.setRet(spx.get(5).getString());
		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
	}
	
	public void executeZtbg_Jcdwhjhd_dwtsqysfjk(Object obj) throws CallDbException {
		Jcdwhjhdtsqy pmt = (Jcdwhjhdtsqy) obj;
		SqlParameterExt spx = null;
		String ywlsh = "";
		String yhbm = "";
		String s = "p_hfb_jcdw_dwtsqc_add_auto_ds(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8)";
		try {
			String msg = "";
			short ret = 0;
			String dwzh = pmt.getDwzh().trim();
			String blqd = pmt.getBlqd().trim();
			String userid = pmt.getUserid()+"";
			String bpmid = pmt.getBpmid();
			
			spx = new SqlParameterExt();
			spx.add(new StringValue(dwzh));
			spx.add(new StringValue(userid)); 
			spx.add(new StringValue(bpmid));
			spx.add(new StringValue(blqd));
			spx.add(new StringValue(ywlsh), SqlParameterExt.SQL_OUTPUT);
			spx.add(new StringValue(yhbm), SqlParameterExt.SQL_OUTPUT);
  			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);
  			spx.add(new ShortValue(ret), SqlParameterExt.SQL_OUTPUT);
  			bo.setSqlParameterExt(spx);
  			bo.executeProcedure(s);
  			
  			if (spx.get(8).getShort() == 0) {
				ywlsh = spx.get(5).getString();
				yhbm = spx.get(6).getString();
				msg = spx.get(7).getString();
				pmt.setRet("0");
				pmt.setYwlsh(ywlsh);
				pmt.setYhbm(yhbm);
			} else {
				pmt.setRet("99");
				msg = spx.get(7).getString();
			}
			bo.closestmt();
			
		} catch (Exception e) {
			e.printStackTrace();
			pmt.setMsg("缴存单位托收 检验是否交款失败！");
			pmt.setRet("99");
			throw new CallDbException("缴存单位托收 检验是否交款失败！" + e.getMessage());
		}

	}
	public List<Row> openZtbg_Jcdwhjhd_hjfpcxwt(Object obj) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String sql=" select jcyd,max(syrs) syrs,sum(syje) syje,max(zjrs) zjrs,sum(zjje) zjje,max(jsrs) jsrs,"+
				   " sum(jsje) jsje,max(hjrs) hjrs,sum(hjje) hjje,max(ywlsh) ywlsh,max(yhsjfsbz) yhsjfsbz "+
				   " from gjzf_dw_jcrd where dwzh='"+XTool.TransactSQLInjection(pmt.getDwzh())+"' "+
				   " and jcyd between '" +XTool.TransactSQLInjection(pmt.getJcyd_begin()) +"' and '" +	XTool.TransactSQLInjection(pmt.getJcyd_end()) +"' "+
				   " and hdrq is not null and hjrq is null "+
				   " group by jcyd order by jcyd";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwhjhd_hjfpcxwt]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 缴存单位打印住房公积金管理中心汇(补)缴凭条
	 * @param obj
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openZtbg_Jcdwhjhd_Hbjpt_Prt28(Object obj) throws CallDbException {
		Jcdwhjhddy pmt=(Jcdwhjhddy)obj;
		//连续汇缴多个月时，上月人数和上月金额取第一个的上月人数和上月金额
			String sql=" select case when trim(max(a.hjrq)) is null then max(a.hdrq)  else max(a.hjrq) end hjrq,max(a.hdczy)hdczy,max(a.ywlsh) ywlsh,max(c.dwmc) dwmc,max(b.dwzh) dwzh,max(c.jbrxm) jbrxm,max(c.jbrsjhm) jbrsjhm,max(b.dwjcrs) dwjcrs,max(b.yjcze) yjcze, "+
				//" max(a.syrs) syrs,sum(a.syje) syje," +
				" max((select max(syrs) from gjzf_dw_jcrd where ywlsh= '" +	XTool.TransactSQLInjection(pmt.getHbjywlsh()) +	"' and jcyd =(select min(jcyd) from gjzf_dw_jcrd where ywlsh= '" +	XTool.TransactSQLInjection(pmt.getHbjywlsh()) +	"'))) syrs," +
				" max((select sum(syje) from gjzf_dw_jcrd where ywlsh= '" +	XTool.TransactSQLInjection(pmt.getHbjywlsh()) +	"' and jcyd =(select min(jcyd) from gjzf_dw_jcrd where ywlsh= '" +	XTool.TransactSQLInjection(pmt.getHbjywlsh()) +	"'))) syje," +
				" max(a.zjrs) zjrs,sum(a.zjje) zjje,max(a.jsrs) jsrs,sum(a.jsje) jsje,max(hjrs) hjrs,sum(hjje) hjje,max(a.bjje) bjje,max(a.bjrs) bjrs,max(a.jkczy) jkczy,min(a.jcyd) ksyd," +
				" case when min(a.jcyd)<>max(a.jcyd) then min(a.jcyd)||'-'||max(a.jcyd) else  max(a.jcyd) end jsyd," +
				" max((select sum(gryjce+dwyjce+czybte+bcyjce) from gjzf_gr_jchd where grzhzt ='01' " +
				" and bgyd = (select min(jcyd) from gjzf_dw_jcrd where ywlsh= '" +XTool.TransactSQLInjection(pmt.getHbjywlsh()) +	"') " +
				" and dwzh = (select min(dwzh) from gjzf_dw_jcrd where ywlsh= '" +	XTool.TransactSQLInjection(pmt.getHbjywlsh()) +	"'))) yjcze1"+  //新增yjcze1  因为网厅是核定完就可以打凭条，中心版是分配完后更新gjzf_dw_zz表中字段，所以新增字段。
				" from gjzf_dw_jcrd a inner join gjzf_dw_zz b on "+ 
				" a.dwzh=b.dwzh inner join cr_dw c on b.dwbh=c.dwbh where a.ywlsh= '" +	XTool.TransactSQLInjection(pmt.getHbjywlsh()) +	"' " +
				" order by a.jcyd "; 
			/*	String dwzh=XTool.TransactSQLInjection(pmt.getDwzh());
				String ksyd=XTool.TransactSQLInjection(pmt.getKsyd());
				String jsyd=XTool.TransactSQLInjection(pmt.getJsyd());
				String sql="  select case when trim(max(a.hjrq)) is null then max(a.hdrq)  else max(a.hjrq) end hjrq,max(a.hdczy)hdczy,max(a.ywlsh) ywlsh,max(c.dwmc) dwmc,max(b.dwzh) dwzh,max(c.jbrxm) jbrxm, "+
				//" max(a.syrs) syrs,sum(a.syje) syje," +
				"   max(c.jbrsjhm) jbrsjhm,max(b.dwjcrs) dwjcrs,max(b.yjcze) yjcze,  max((select max(syrs) from gjzf_dw_jcrd where dwzh = '"+dwzh+"' and jcyd ='"+ksyd+"')) syrs,    " +
				"  max((select sum(syje) from gjzf_dw_jcrd where dwzh = '"+dwzh+"' and jcyd ='"+ksyd+"')) syje, max(a.zjrs) zjrs,sum(a.zjje) zjje,max(a.jsrs) jsrs,   sum(a.jsje) jsje,max(hjrs) hjrs,sum(hjje) hjje,max(a.bjje) bjje,max(a.bjrs) bjrs, " +
				"  max(a.jkczy) jkczy,min(a.jcyd) ksyd, case when min(a.jcyd)<>max(a.jcyd) then min(a.jcyd)||'-'||max(a.jcyd) else  max(a.jcyd) end jsyd, max((select sum(gryjce+dwyjce+czybte+bcyjce) " +
				" from gjzf_gr_jchd where grzhzt ='01'  and bgyd  ='"+ksyd+"'  and dwzh  = '"+dwzh+"')) yjcze1 from gjzf_dw_jcrd a inner join gjzf_dw_zz b on  a.dwzh=b.dwzh inner join cr_dw c on b.dwbh=c.dwbh " +
				"  where a.dwzh= '"+dwzh+"' and jcyd between '"+ksyd+"' and '"+jsyd+"'   order by a.jcyd  " ;
		*/
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwhjhd_Hbjpt_Prt28]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 打印住房公积金管理中心汇(补)缴凭条zj 单位汇缴核定
	 * @param obj
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openZtbg_Jcdwhjhd_Hbjpt_Prt29(Object obj) throws CallDbException {
		Jcdwhjhddy pmt=(Jcdwhjhddy)obj;
		//连续汇缴多个月时，上月人数和上月金额取第一个的上月人数和上月金额
			String sql=" select case when trim(max(a.hjrq)) is null then max(a.hdrq)  else max(a.hjrq) end hjrq,max(a.hdczy)hdczy,max(a.ywlsh) ywlsh,max(c.dwmc) dwmc,max(b.dwzh) dwzh,max(c.jbrxm) jbrxm,max(c.jbrsjhm) jbrsjhm,max(b.dwjcrs) dwjcrs,max(b.yjcze) yjcze, "+
				" max((select max(syrs) from gjzf_dw_jcrd where dwzh='" +	XTool.TransactSQLInjection(pmt.getDwzh()) +	"' and jcyd>='" +	XTool.TransactSQLInjection(pmt.getKsyd()) +	"'and jcyd<='" + XTool.TransactSQLInjection(pmt.getJsyd()) +	"' " +
				" and trim(hdrq) is not null and jcyd =(select min(jcyd) from gjzf_dw_jcrd where dwzh='" +	XTool.TransactSQLInjection(pmt.getDwzh()) +	"' and jcyd>='" +	XTool.TransactSQLInjection(pmt.getKsyd()) +	"'and jcyd<='" +	XTool.TransactSQLInjection(pmt.getJsyd()) +	"'))) syrs," +
				" max((select sum(syje) from gjzf_dw_jcrd where dwzh='" +	XTool.TransactSQLInjection(pmt.getDwzh()) +	"' and jcyd>='" +	XTool.TransactSQLInjection(pmt.getKsyd()) +	"'and jcyd<='" +	XTool.TransactSQLInjection(pmt.getJsyd()) +	"' and jcyd =(select min(jcyd) from gjzf_dw_jcrd where dwzh='" +	XTool.TransactSQLInjection(pmt.getDwzh()) +	"' and jcyd>='" +	XTool.TransactSQLInjection(pmt.getKsyd()) +	"'and jcyd<='" +	XTool.TransactSQLInjection(pmt.getJsyd()) +	"'))) syje," +
				" max(a.zjrs) zjrs,sum(a.zjje) zjje,max(a.jsrs) jsrs,sum(a.jsje) jsje,max(hjrs) hjrs,sum(hjje) hjje,max(a.bjje) bjje,max(a.bjrs) bjrs,max(a.jkczy) jkczy,min(a.jcyd) ksyd," +
				" case when min(a.jcyd)<>max(a.jcyd) then min(a.jcyd)||'-'||max(a.jcyd) else  max(a.jcyd) end jsyd," +
				" max((select sum(gryjce+dwyjce+czybte+bcyjce) from gjzf_gr_jchd where grzhzt ='01' " +
				" and bgyd = (select min(jcyd) from gjzf_dw_jcrd where dwzh='" +	XTool.TransactSQLInjection(pmt.getDwzh()) +	"' and jcyd>='" +	XTool.TransactSQLInjection(pmt.getKsyd()) +	"'and jcyd<='" +	XTool.TransactSQLInjection(pmt.getJsyd()) +	"') " +
				" and dwzh = (select min(dwzh) from gjzf_dw_jcrd where dwzh='" +	XTool.TransactSQLInjection(pmt.getDwzh()) +	"' and jcyd>='" +	XTool.TransactSQLInjection(pmt.getKsyd()) +	"'and jcyd<='" +	XTool.TransactSQLInjection(pmt.getJsyd()) +	"'))) yjcze1"+  
				" from gjzf_dw_jcrd a inner join gjzf_dw_zz b on "+ 
				" a.dwzh=b.dwzh inner join cr_dw c on b.dwbh=c.dwbh where a.dwzh='" +	XTool.TransactSQLInjection(pmt.getDwzh()) +	"' and a.jcyd>='" +	XTool.TransactSQLInjection(pmt.getKsyd()) +	"'and a.jcyd<='" +	XTool.TransactSQLInjection(pmt.getJsyd()) +	"'and trim(hdrq) is not null " +
				" order by a.jcyd "; 
			
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwhjhd_Hbjpt_Prt29]出错"
					+ e.getMessage());
		}
	}
}
