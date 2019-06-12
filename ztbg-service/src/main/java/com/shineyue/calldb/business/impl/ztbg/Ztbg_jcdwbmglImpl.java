package com.shineyue.calldb.business.impl.ztbg;

import java.util.List;

import com.shineyue.bean.ztbg.Jcdwdwbmgl_gr;
import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.calldb.CallDbException;
import com.shineyue.calldb.SqlParameterExt;
import com.shineyue.calldb.business.AbstractDbInterface;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.sql.value.IntValue;
import com.shineyue.calldb.sql.value.LongValue;
import com.shineyue.calldb.sql.value.ShortValue;
import com.shineyue.calldb.sql.value.StringValue;
import com.shineyue.calldb.util.XTool;

public class Ztbg_jcdwbmglImpl extends AbstractDbInterface{
	public Ztbg_jcdwbmglImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	public void executeZtbg_Jcdwbmgl_bmbmszadd(Object obj) throws CallDbException {
		Jcdwdwbmgl_gr pmt = (Jcdwdwbmgl_gr) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		short ret = 99;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh().trim()));//1--单位账号
			spx.add(new StringValue(pmt.getSzbmbm().trim()));//2--部门编码
			spx.add(new StringValue(pmt.getSzbm().trim()));//3--部门名称
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//4--返回值 0-成功，99-不成功
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//5--返回信息
		} catch (Exception err) {
			throw new CallDbException("执行方法[Ztbg_Jcdwbmgl_bmbmszadd]出错" + err.getMessage());
		}
		try {
			sql = "p_hfb_jcdw_bmsz_add(?p1,?p2,?p3,?p4,?p5)";
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			ret = spx.get(4).getShort();
			msg = spx.get(5).getString();
			pmt.setMsg(msg);
			pmt.setRet(ret);
		} catch (Exception err) {
			throw new CallDbException("执行方法[Ztbg_Jcdwbmgl_bmbmszadd]出错" + err.getMessage());
		}
	} 
	
	public void executeZtbg_Jcdwbmgl_bmbmszdel(Object obj) throws CallDbException {
		Jcdwdwbmgl_gr pmt = (Jcdwdwbmgl_gr) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		short ret = 99;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh().trim()));//1--单位账号
			spx.add(new StringValue(pmt.getSzbmbm().trim()));//2--部门编码
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//3--返回值 0-成功，99-不成功
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//4--返回信息
			
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcdwbmgl_bmbmszdel]出错" + err.getMessage());
		}
		try {
			sql = "p_hfb_jcdw_bmsz_del(?p1,?p2,?p3,?p4)";
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			ret = spx.get(3).getShort();
			msg = spx.get(4).getString();		
			pmt.setMsg(msg);
			pmt.setRet(ret);
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcdwbmgl_bmbmszdel]出错" + err.getMessage());
		}
	} 
	public void executeZtbg_Jcdwbmgl_bmbmszchg(Object obj) throws CallDbException {
		Jcdwdwbmgl_gr pmt = (Jcdwdwbmgl_gr) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		short ret = 99;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh().trim()));//1--单位账号
			spx.add(new StringValue(pmt.getSzbmbm().trim()));//2--部门编码
			spx.add(new StringValue(pmt.getSzbm().trim()));//3--部门名称
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//8--返回值 0-成功, 99-不成功
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//7--返回信息
			
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcdwbmgl_bmbmszchg]出错" + err.getMessage());
		}
		try {
			sql = "p_hfb_jcdw_bmsz_chg(?p1,?p2,?p3,?p4,?p5)";
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			ret = spx.get(4).getShort();
			msg = spx.get(5).getString();
		
			pmt.setMsg(msg);
			pmt.setRet(ret);
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcdwbmgl_bmbmszchg]出错" + err.getMessage());
		}
	} 
	public List<Row> openZtbg_Jcdwbmgl_bmbmszqccx(Object obj) throws CallDbException {
		Jcdwdwbmgl_gr pmt=(Jcdwdwbmgl_gr)obj;
		int page  = pmt.getPage();
		int size = pmt.getSize();
		String v_grzh=XTool.TransactSQLInjection(pmt.getGrzh().trim()==null?"":pmt.getGrzh().trim());
		String v_dwzh=XTool.TransactSQLInjection(pmt.getDwzh().trim()==null?"":pmt.getDwzh().trim());
		String v_szbmbm=XTool.TransactSQLInjection(pmt.getSzbmbm().trim()==null?"":pmt.getSzbmbm().trim());
		String sql = "select a.grzh,b.xingming,b.zjhm,c.mc szbm,(a.gryjce+a.dwyjce) yjce,a.gryjce,a.dwyjce,f_hfsc_get_value(a.grzh,'grzhye') grzhye,d.mc grzhzt,b.szbmbm " +
					" from gjzf_gr_zz a  inner join cr_gr b on a.grbh=b.grbh "
				    +"  left join bm_gz_ssbm c on b.szbmbm=c.bm and a.dwzh=c.dwzh inner join bm_gz_grzhzt d on a.grzhzt=d.bm "
					+" where a.dwzh ='"+v_dwzh+"' and a.grzhzt in ('01','02') ";
		if (!v_grzh.equals("")){
			sql+=" and a.grzh='"+v_grzh+"' ";
		}
		if (!v_szbmbm.equals("")){
			sql+=" and b.szbmbm='"+v_szbmbm+"' ";
		}
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcdwbmgl_bmbmszqccx]出错"
					+ e.getMessage());
		}
   	} 
	public void executeZtbg_Jcdwbmgl_bmbmddadd(Object obj) throws CallDbException {
		Jcdwdwbmgl_gr pmt = (Jcdwdwbmgl_gr) obj;
		SqlParameterExt spx = null;
		String s = "";
		int end=0;
		String only="";
		int ret=99;
		String msg="";
		try{
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh()));//1--单位账号
			spx.add(new StringValue(" ")); //2
			spx.add(new StringValue(" ")); //3
			spx.add(new StringValue(pmt.getZrbmbm().trim()));//4
			spx.add(new IntValue(pmt.getSfqb()));//5
			spx.add(new StringValue(pmt.getYwlsh()));//6
			spx.add(new StringValue(pmt.getBlqd()));//7
			spx.add(new LongValue(pmt.getUserid()));//8
			spx.add(new IntValue(end));//9
			spx.add(new StringValue(only),SqlParameterExt.SQL_INPUT_OUTPUT);//10
			spx.add(new IntValue(ret),SqlParameterExt.SQL_INPUT_OUTPUT);//11
			spx.add(new StringValue(msg),SqlParameterExt.SQL_INPUT_OUTPUT);//12
		} catch (Exception err) {
			throw new CallDbException("参数个数不对或参数类型不合法!" + err.getMessage());
		}
		try {
			s = "p_hfb_jcdw_jcrbmdd_add(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11,?p12)";
			String[] grzhArr = pmt.getGrzh().split(",");
			String[] zcbmbmArr = pmt.getZcbmbm().split(",");
			for (int i = 0; i < grzhArr.length; i++) {
				spx.set(2, new StringValue(grzhArr[i].trim().replace(",", "")));
				spx.set(3, new StringValue(zcbmbmArr[i].trim().replace(",", "")));
				bo.setSqlParameterExt(spx);
				bo.executeProcedure(s);
				if (spx.get(11).getInt() == 0) {
					only = spx.get(10).getString();
				}
				bo.closestmt();
			}
			spx.set(9, new IntValue(1));
			
			bo.setSqlParameterExt(spx);
			
			bo.executeProcedure(s);
			msg = spx.get(12).getString();
			ret=spx.get(11).getInt();
			pmt.setRet(ret);
			pmt.setMsg(msg);
		} catch (Exception err) {
			throw new CallDbException("缴存人部门调动存盘!" + err.getMessage());
		}
	}
	public List<Row> openZtbg_Jcdwbmgl_bmbmddcx(Object obj) throws CallDbException {
		Jcdwdwbmgl_gr pmt=(Jcdwdwbmgl_gr)obj;
		int page  = pmt.getPage();
		int size = pmt.getSize();
		String v_grzh=XTool.TransactSQLInjection(pmt.getGrzh().trim()==null?"":pmt.getGrzh().trim());
		String v_dwzh=XTool.TransactSQLInjection(pmt.getDwzh().trim()==null?"":pmt.getDwzh().trim());
		String v_szbmbm=XTool.TransactSQLInjection(pmt.getSzbmbm().trim()==null?"":pmt.getSzbmbm().trim());
		String sql = "select a.bgqxx zcbmbm,b.mc zcbmmc,a.bghxx zrbmbm,c.mc zrbmmc,a.crzh grzh,d.xingming,d.zjhm,e.gryjce+e.dwyjce yjce,e.dwyjce,e.gryjce,f_hfsc_get_value(e.grzh,'grzhye') grzhye,e.grzhzt " +
					"  from cr_jbxx_bg a inner join gjzf_gr_zz e on a.crzh=e.grzh left join bm_gz_ssbm b on a.bgqxx=b.bm and e.dwzh=b.dwzh "
				    +"  left join bm_gz_ssbm c on a.bghxx=c.bm and e.dwzh=c.dwzh left join cr_gr d on  a.crbh=d.grbh  "
					+" where a.bgxm='所在部门' and e.dwzh='"+v_dwzh+"' ";
		if (!v_grzh.equals("")){
			sql+=" and a.crzh='"+v_grzh+"' ";
		}
		if (!v_szbmbm.equals("")){
			sql+=" and d.szbmbm='"+v_szbmbm+"' ";
		}
		sql += " order by a.id ";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcdwbmgl_bmbmddcx]出错"
					+ e.getMessage());
		}
   	}
	public List<Row> openZtbg_Jcdwbmgl_bmbmszcx(Object obj) throws CallDbException {
		Jcdwdwbmgl_gr pmt=(Jcdwdwbmgl_gr)obj;
		int page  = pmt.getPage();
		int size = pmt.getSize();
		String v_dwzh=XTool.TransactSQLInjection(pmt.getDwzh().trim()==null?"":pmt.getDwzh().trim());
		String v_szbm=XTool.TransactSQLInjection(pmt.getSzbmbm().trim()==null?"":pmt.getSzbmbm().trim());
		String sql = "select dwzh,bm,mc from bm_gz_ssbm " +
					" where  dwzh like '%"+v_dwzh.trim()+"%' ";
		if (v_szbm.equals("")){
			sql+=" order by bm ";
		}else{
			sql+=" and (bm like '"+v_szbm+"%' or mc like '"+v_szbm+"%') order by bm ";
		}
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcdwbmgl_bmbmszcx]出错"
					+ e.getMessage());
		}
   	}
}
