package com.shineyue.calldb.business.impl.ztbg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shineyue.bean.ztbg.CommonBean;
import com.shineyue.bean.ztbg.Cr_dwBean;
import com.shineyue.bean.ztbg.Jcdw_jcrbgztBean;
import com.shineyue.bean.ztbg.Jcdw_plhcBean1;
import com.shineyue.bean.ztbg.Jcdwjcrztbg;
import com.shineyue.bean.ztbg.Jcdwjcrztbg_mx;
import com.shineyue.bean.ztbg.Jcdwjcrztbg_qc;
import com.shineyue.calldb.CallDbException;
import com.shineyue.calldb.SqlParameterExt;
import com.shineyue.calldb.business.AbstractDbInterface;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.sql.value.DateValue;
import com.shineyue.calldb.sql.value.DoubleValue;
import com.shineyue.calldb.sql.value.IntValue;
import com.shineyue.calldb.sql.value.LongValue;
import com.shineyue.calldb.sql.value.ShortValue;
import com.shineyue.calldb.sql.value.StringValue;
import com.shineyue.calldb.util.XTool;
import org.apache.poi.util.SystemOutLogger;

public class Ztbg_CzhjImpl extends AbstractDbInterface{
	public Ztbg_CzhjImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	/**
	 * 财政数据校验查询
	 * @param obj
	 * @param size
	 * @param page
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openztbg_Czhj_Czdk_Cx(Object obj,int size,int page) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		String jcyd=XTool.TransactSQLInjection(pmt.getJcyd()==null?"":pmt.getJcyd().trim());
		String czdwzh=XTool.TransactSQLInjection(pmt.getCzdwzh()==null?"":pmt.getCzdwzh().trim());
		String jyjg=XTool.TransactSQLInjection(pmt.getJyjg());
		String sfjytg=XTool.TransactSQLInjection(pmt.getSfjytg());
		String sql="select a.dwzh,a.xingming,a.zjhm,a.ywlsh,a.jyjg,a.grzh,a.dwmc,yjje,yjce,yjje-yjce ce " 
				    +" from gjzf_dw_czsjjy_jg a where a.jcyd='"+jcyd+"' and a.czdwzh='"+czdwzh+"'";
		if(!sfjytg.equals("全部")){
			sql+=" and a.sfjytg ='"+sfjytg+"' ";
		}
		if(!jyjg.equals("全部")){
			sql+=" and a.jyjg like '"+jyjg+"%' ";
		}
		sql+=" order by a.dwzh ";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setHjParameter("yjce,yjje,ce");
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openztbg_Czhj_Czdk_Cx]出错"
					+ e.getMessage());
		}
	}
	
	public void executeztbg_Czhj_Czdk_Plhdwcbl(Object obj) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		String czdwzh = pmt.getCzdwzh();
		String jcyd = pmt.getJcyd();
		String ywlsh = pmt.getYwlsh();
		String ywlx = pmt.getYwlx();
		String blqd = pmt.getBlqd();
		int userid = pmt.getUserid();
		SqlParameterExt spx = null;
		String s = "";
		int ret=99;
		String msg="";
		try{
			spx = new SqlParameterExt();
			spx.add(new StringValue(czdwzh));
			spx.add(new StringValue(jcyd));
			spx.add(new StringValue(ywlsh));
			spx.add(new StringValue(ywlx));
			spx.add(new StringValue(blqd));
			spx.add(new IntValue(userid));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);
			
			s = "p_hfb_jcdw_czhj_jcrd(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8)";
			
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			msg = spx.get(7).getString();
			ret= Integer.parseInt(spx.get(8).getString());
			pmt.setRet(ret);
			pmt.setMsg(msg);
		} catch (Exception err) {
			throw new CallDbException("批量核定完成办理!" + err.getMessage());
		}
	}
	
	/**
	 * 批量财政汇缴dellall
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeztbg_Czhj_Czdk_Dellall(Object obj) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		String czdwzh = pmt.getCzdwzh();
		String jcyd = pmt.getJcyd();
		String blqd = pmt.getBlqd();
		int userid = pmt.getUserid();
		SqlParameterExt spx = null;
		String s = "";
		int ret=99;
		String msg="";
		try{
			spx = new SqlParameterExt();
			spx.add(new StringValue(czdwzh));
			spx.add(new StringValue(jcyd));
			spx.add(new StringValue(blqd));
			spx.add(new IntValue(userid));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);
			
			s = "p_hfb_jcdw_czhj_del_all(?p1,?p2,?p3,?p4,?p5,?p6)";
			
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			msg = spx.get(5).getString();
			ret= Integer.parseInt(spx.get(6).getString());
			pmt.setRet(ret);
			pmt.setMsg(msg);
		} catch (Exception err) {
			throw new CallDbException("批量财政汇缴dellall!" + err.getMessage());
		}
	}
	
	/**
	 * 批量财政汇缴一键转移
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeztbg_Czhj_Czdk_Yjzy(Object obj) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		String czdwzh = pmt.getCzdwzh();
		String jcyd = pmt.getJcyd();
		String blqd = pmt.getBlqd();
		String ywlsh = pmt.getYwlsh();
		String bpmid = pmt.getBpmid();
		int userid = pmt.getUserid();
		SqlParameterExt spx = null;
		String s = "";
		int ret=99;
		String msg="";
		try{
			spx = new SqlParameterExt();
			spx.add(new StringValue(czdwzh));
			spx.add(new StringValue(jcyd));
			spx.add(new StringValue(ywlsh));
			spx.add(new StringValue(bpmid));
			spx.add(new StringValue(blqd));
			spx.add(new IntValue(userid));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);
			
			s = "p_hfb_jcdw_czhj_jcrdwtz_save(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8)";
			
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			msg = spx.get(7).getString();
			ret= Integer.parseInt(spx.get(8).getString());
			pmt.setRet(ret);
			pmt.setMsg(msg);
		} catch (Exception err) {
			throw new CallDbException("批量财政汇缴一键转移" + err.getMessage());
		}
	}
	
	/**
	 * 批量财政汇缴基数变更
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeztbg_Czhj_Czdk_Jsbg(Object obj) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		String czdwzh = pmt.getCzdwzh();
		String jcyd = pmt.getJcyd();
		String blqd = pmt.getBlqd();
		String ywlsh = pmt.getYwlsh();
		String bpmid = pmt.getBpmid();
		int userid = pmt.getUserid();
		SqlParameterExt spx = null;
		String s = "";
		int ret=99;
		String msg="";
		try{
			spx = new SqlParameterExt();
			spx.add(new StringValue(czdwzh));
			spx.add(new StringValue(jcyd));
			spx.add(new StringValue(ywlsh));
			spx.add(new StringValue(bpmid));
			spx.add(new StringValue(blqd));
			spx.add(new IntValue(userid));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);
			
			s = "p_hfb_jcdw_czhj_jcjsbgqc_save(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8)";
			
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			msg = spx.get(7).getString();
			ret= Integer.parseInt(spx.get(8).getString());
			pmt.setRet(ret);
			pmt.setMsg(msg);
		} catch (Exception err) {
			throw new CallDbException("批量财政汇缴基数变更" + err.getMessage());
		}
	}
	
	/**
	 * 批量财政汇缴一键封存启封
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeztbg_Czhj_Czdk_Yjfcqf(Object obj) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		String czdwzh = pmt.getCzdwzh();
		String jcyd = pmt.getJcyd();
		String blqd = pmt.getBlqd();
		String ywlsh = pmt.getYwlsh();
		String bpmid = pmt.getBpmid();
		String bglb = pmt.getBglb();
		int userid = pmt.getUserid();
		SqlParameterExt spx = null;
		String s = "";
		int ret=99;
		String msg="";
		try{
			spx = new SqlParameterExt();
			spx.add(new StringValue(czdwzh));
			spx.add(new StringValue(jcyd));
			spx.add(new StringValue(bglb));
			spx.add(new StringValue(ywlsh));
			spx.add(new StringValue(bpmid));
			spx.add(new StringValue(blqd));
			spx.add(new IntValue(userid));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);
			
			s = "p_hfb_jcdw_czhj_jcrbgzt_save(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9)";
			
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			msg = spx.get(8).getString();
			ret= Integer.parseInt(spx.get(9).getString());
			pmt.setRet(ret);
			pmt.setMsg(msg);
		} catch (Exception err) {
			throw new CallDbException("批量财政汇缴一键封存启封" + err.getMessage());
		}
	}



	/**
	 * 批量财政汇缴一键信息变更
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeztbg_Czhj_Czdk_Yjxxbg(Object obj) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		String czdwzh = pmt.getCzdwzh();
		String jcyd = pmt.getJcyd();
		String blqd = pmt.getBlqd();
		String ywlsh = pmt.getYwlsh();
		String bpmid = pmt.getBpmid();
		String bglb = pmt.getBglb();
		int userid = pmt.getUserid();
		SqlParameterExt spx = null;
		String s = "";
		int ret=99;
		String msg="";
		try{
			spx = new SqlParameterExt();
			spx.add(new StringValue(czdwzh));
			spx.add(new StringValue(jcyd));

			spx.add(new StringValue(ywlsh));
			spx.add(new StringValue(bpmid));
			spx.add(new StringValue(blqd));
			spx.add(new IntValue(userid));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);

			s = "p_hfb_jcdw_czhj_jcrxxbg_save(?p1,?p2,?p4,?p5,?p6,?p7,?p8,?p9)";

			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			msg = spx.get(7).getString();
			ret= Integer.parseInt(spx.get(8).getString());
			pmt.setRet(ret);
			pmt.setMsg(msg);
		} catch (Exception err) {
			throw new CallDbException("批量财政汇缴一键信息变更" + err.getMessage());
		}
	}


	/**
	 * 财政数据校验核定单位查询
	 * @param obj
	 * @param size
	 * @param page
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openztbg_Czhj_Czdk_Hddwcx(Object obj,int size,int page) throws CallDbException {

		Cr_dwBean pmt = (Cr_dwBean) obj;
		
		String czdwzh = pmt.getCzdwzh();
		String jcyd = pmt.getJcyd();
		String ywlsh = pmt.getYwlsh();
		String ywlx = pmt.getYwlx();
		String blqd = pmt.getBlqd();
		
		int userid = pmt.getUserid();
		
		SqlParameterExt spx = null;
		String s = "p_hfb_jcdw_czhj_jcrd(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8)";
		String tableName = "tmp_jcdw_hjhd_jcrd_czhj_cx";
		String sql = "select  dwzh,jcyd,syje,syrs,zjrs,zjje,jsrs,jsje,hjrs,hjje,zckye from "
				+" tmp_jcdw_hjhd_jcrd_czhj_cx where ywlsh = '"+pmt.getYwlsh()+"' order by dwzh,jcyd";
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(czdwzh));
			spx.add(new StringValue(jcyd));
			spx.add(new StringValue(ywlsh));
			spx.add(new StringValue(ywlx));
			spx.add(new StringValue(blqd));
			spx.add(new IntValue(userid));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);
		} catch (Exception e) {
			throw new CallDbException("参数不合法!" + e.getMessage());
		}
		
		try {
			bo.setSqlParameterExt(spx);
			bo.setHjParameter("syje,syrs,zjrs,zjje,jsrs,jsje,hjrs,hjje,zckye");
			List<Row> list = bo.queryProcedureToList(s, tableName, sql, size, page);
			pmt.setMsg(spx.get(7).getString());
			pmt.setRet(spx.get(8).getString());
			return list;
		} catch (Exception e) {
			throw new CallDbException("执行方法[openjcdw_Hjhd_Jcrd_Cx]出错"+ e.getMessage());
		}

	}
	
	/**
	 * 
	 * 财政数据校验导入
	 * @param obj
	 * @param pagesize
	 * @param pagenum
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openztbg_Czhj_Czdk_Dr(Object obj,int pagesize,int pagenum) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		int v_end = 0;
		String v_only = "";
		String msg ="";
		short ret = 0;
		SqlParameterExt spx = null;
		try {
		String sql = "insert into tmp_gz_table(sure_id,value1,value2,value3,value4,value5,value6,value7) values(?,?,?,?,?,?,?,?)";
		String[] dwzhArr = pmt.getDwzh().split(",");
		String[] dwmcArr = pmt.getDwmc().split(",");
		String[] xingmingArr = pmt.getXingming().split(",");
		String[] zjhmArr = pmt.getZjhm().split(",");
		String[] dwyjceArr = pmt.getDwyjceArr().split(",");
		String[] gryjceArr = pmt.getGryjceArr().split(",");
		List<SqlParameterExt> l = new ArrayList<SqlParameterExt>();
        for (int i = 0; i < xingmingArr.length; i++) {
            SqlParameterExt spx1 = new SqlParameterExt(false); // 类型转化
            spx1.add(new StringValue(pmt.getYwlsh()));
        	spx1.add( new StringValue(dwzhArr[i].trim().replace(",", "")));
        	spx1.add( new StringValue(dwmcArr[i].trim().replace(",", "")));
        	spx1.add( new StringValue(xingmingArr[i].trim().replace(",", "")));
			spx1.add( new StringValue(zjhmArr[i].trim().replace(",", "")));
			spx1.add( new StringValue(gryjceArr[i].trim().replace(",", "")));
			spx1.add( new StringValue(dwyjceArr[i].trim().replace(",", "")));
			spx1.add(new IntValue(i));
            l.add(spx1);
        }
        bo.setSqlParameterExtArr(l);
        int[] arrs=  bo.executeInsertBatch(sql);
        String s = "p_hfb_jcdw_czhj_czsjjy_dr(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11,?p12,?p13,?p14,?p15)";
		spx = new SqlParameterExt(); // 类型转化
		spx.add(new StringValue(pmt.getCzdwzh()));//1
		spx.add(new StringValue(pmt.getJcyd()));//5姓名
		spx.add(new StringValue(" "));//单位账号
		spx.add(new StringValue(" "));//单位名称
		spx.add(new StringValue(" "));//姓名
		spx.add(new StringValue(" "));//证件号码	
		spx.add(new DoubleValue(0));//个人月缴存额
		spx.add(new DoubleValue(0));//单位月缴存额
		spx.add(new StringValue(pmt.getYwlsh()));//ywlsh
		spx.add(new StringValue(pmt.getBlqd()));//12职业
		spx.add(new IntValue(pmt.getUserid()));//13职称
		spx.add(new IntValue(1)); // 结束标记（等于 1 时为结束)26
		spx.add(new StringValue(pmt.getYwlsh()), SqlParameterExt.SQL_OUTPUT); // 结束标记（等于 1 时为结束)26
		spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT); //28 返回值 0存盘成功16
		spx.add(new ShortValue(ret), SqlParameterExt.SQL_OUTPUT);//29
		// 98部分账号导入不成功
		// 99存盘失败
			bo.setSqlParameterExt(spx);
			String tableName = "tmp_gjzf_dw_czsjjy_jg";
		    String queryStatement = "select xingming,zjhm,dwzh,dwmc,msg from tmp_gjzf_dw_czsjjy_jg";
			List<Row> list = bo.queryProcedureToList(s, tableName, queryStatement,pagesize,pagenum);			
			pmt.setMsg(spx.get(14).getString());
			pmt.setRet(spx.get(15).getShort());
			return list;
		}catch(Exception e){
			pmt.setMsg("导入失败！");
			throw new CallDbException("执行方法[openztbg_Czhj_Czdk_Dr]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 导入结果查询
	 * @param obj
	 * @param pagesize
	 * @param pagenum
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openztbg_Czhj_Czdk_Jgcx(Object obj,int pagesize,
			int pagenum) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		int userid = pmt.getUserid();
		String ywlsh = pmt.getYwlsh();
		String sql = "select count(id) id,max(jyjg) jyjg,max(msg) msg from gjzf_dw_czsjjy_jg_jgb "
				+" where userid ='"+userid+"' and ywlsh ='"+ywlsh+"'";
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,pagesize, pagenum);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openztbg_Czhj_Czdk_Jgcx]出错"+ e.getMessage());
		}
	}
	
	/**
	 * 错误信息导出
	 * @param obj
	 * @param pagesize
	 * @param pagenum
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openztbg_Czhj_Czdk_Cwxxdccx(Object obj,int pagesize,
			int pagenum) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		int userid = pmt.getUserid();
		String sql = "select a.dwzh,a.xingming,a.zjhm,a.dwmc,a.msg  from tmp_gjzf_dw_czsjjy_jg_1 a "
				+" where a.userid='"+userid+"'";
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,pagesize, pagenum);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openztbg_Czhj_Czdk_Dc]出错"+ e.getMessage());
		}
	}
	/**
	 * 未分配金额导出
	 * @param obj
	 * @param pagesize
	 * @param pagenum
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openztbg_Czhj_Czdk_Wfpjedc(Object obj,int pagesize,
			int pagenum) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		int userid = pmt.getUserid();
		String sql = "select  dwzh,dwmc,hjje from  tmp_jcdw_hjhd_jcrd_czhj_cx where czyid = '"+userid+"' ";
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,pagesize, pagenum);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openztbg_Czhj_Czdk_Wfpjedc]出错"+ e.getMessage());
		}
	}

	public void executeztbg_Czhj_Czdk_Plhdfpwcbl(Object obj) throws CallDbException {
		Jcdw_plhcBean1 pmt = (Jcdw_plhcBean1) obj;
		String czdwzh = pmt.getCzdwzh();
		System.out.println("czdwzhczdwzhczdwzhczdwzhczdwzhczdwzhczdwzhczdwzhczdwzh"+czdwzh);
		String jcyd = pmt.getJcyd();
		String ywlsh = pmt.getYwlsh();
		String ywlx = pmt.getYwlx();
		String blqd = pmt.getBlqd();
		int userid = pmt.getUserid();
		SqlParameterExt spx = null;
		String s = "";
		int ret=99;
		String msg="";
		try{
			spx = new SqlParameterExt();
			spx.add(new StringValue(czdwzh));
			spx.add(new StringValue(jcyd));
			spx.add(new StringValue(ywlsh));
			spx.add(new StringValue(ywlx));
			spx.add(new StringValue(blqd));
			spx.add(new IntValue(userid));
			spx.add(new StringValue("初始msg"),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new ShortValue((short)99),SqlParameterExt.SQL_INPUT_OUTPUT);

			s = "p_hfb_jcdw_czhj_jcdwhdfp(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8)";

			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			msg = spx.get(7).getString();
			ret= Integer.parseInt(spx.get(8).getString());
			pmt.setRet(ret);
			pmt.setMsg(msg);
		} catch (Exception err) {
			throw new CallDbException("批量核定完成办理!" + err.getMessage());
		}
	}
}
