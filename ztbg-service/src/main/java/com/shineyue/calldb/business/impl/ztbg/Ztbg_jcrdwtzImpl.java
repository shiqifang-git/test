package com.shineyue.calldb.business.impl.ztbg;

import java.util.List;

import com.shineyue.bean.ztbg.Jcdw_jcrdwtzBean;
import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.bean.ztbg.Jcdwjcrztbg;
import com.shineyue.bean.ztbg.Jcdwjcrztbg_qc;
import com.shineyue.calldb.CallDbException;
import com.shineyue.calldb.SqlParameterExt;
import com.shineyue.calldb.business.AbstractDbInterface;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.sql.value.IntValue;
import com.shineyue.calldb.sql.value.LongValue;
import com.shineyue.calldb.sql.value.ShortValue;
import com.shineyue.calldb.sql.value.StringValue;
import com.shineyue.calldb.util.XTool;

public class Ztbg_jcrdwtzImpl extends AbstractDbInterface{
	public Ztbg_jcrdwtzImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	public List<Row> openZtbg_Jcrdwtz_jcrdwtzqccx(Object obj, int pagesize,
			int pagenum) throws CallDbException {
		Jcdwjcrztbg pmt = (Jcdwjcrztbg) obj;
		
		String sql=" select b.dwzh, c.xingming,b.grzh grbh,c.zjhm,d.dwzh zcdwbh,e.dwmc zcdwmc, "
				 + " f.dwzh zydwbh,j.dwmc zydwmc,a.id,a.bpmid,a.ywlsh,a.bgyy bgyy,f_hfsc_get_value(b.grzh,'grzhye') grzhye  "
				 + " from gjzf_gr_zzbg_qc a inner join gjzf_gr_zz b on a.grzh=b.grzh "
				 + " inner join cr_gr c on b.grbh=c.grbh  "
				 + " inner join gjzf_dw_zz d on a.dwzh=d.dwzh "
				 + " inner join cr_dw e on e.dwbh=d.dwbh "
				 + " inner join gjzf_dw_zz f on a.zydwzh=f.dwzh "
				 + " inner join cr_dw j on j.dwbh=f.dwbh "
				 + " where a.spzt=0 and a.zydwzh= '"+XTool.TransactSQLInjection(pmt.getDwzh())+"'" ;
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,pagesize,pagenum);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcrdwtz_jcrdwtzqccx]出错"
					+ e.getMessage());
		}
	}
	public void executeZtbg_Jcrdwtz_jcrdwtzlr(Object obj) throws CallDbException {
		Jcdwjcrztbg pmt = (Jcdwjcrztbg) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		short ret = 99;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getGrzh().trim()));//1--个人账号
			spx.add(new StringValue(pmt.getXdwzh().trim()));//2--新单位账号
			spx.add(new StringValue(pmt.getBgyy().trim()));//2--新单位账号
			spx.add(new StringValue(pmt.getBlqd()));//3--办理渠道
			spx.add(new StringValue(pmt.getPzbh()));//4--流水号
			spx.add(new LongValue(pmt.getBpmid()));//11--业务流水id
			spx.add(new IntValue(pmt.getUserid()));//5--操作员id
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//6--返回信息
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//7--返回值：0-成功，1-相同id号存储 ，99-不成功
			
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcrdwtz_jcrdwtzlr]出错" + err.getMessage());
		}
		try {
			sql = "p_hfb_jcdw_jcrdwtzqc_add(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9)";
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			msg = spx.get(8).getString();
			ret = spx.get(9).getShort();
			pmt.setMsg(msg);
			pmt.setRet(ret);
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcrdwtz_jcrdwtzlr]出错" + err.getMessage());
		}
	}
	
	public void executeZtbg_Jcrdwtz_jcrdwtzsc(Object obj) throws CallDbException {
		Jcdwjcrztbg_qc pmt = (Jcdwjcrztbg_qc) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		String only = "";
		String idArr[] = pmt.getId().split(",");
		short ret = 99;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getId()));//1唯一记录id
			spx.add(new StringValue(pmt.getBlqd().trim()));//2--办理渠道
			spx.add(new IntValue(pmt.getUserid()));//3--操作员id
			spx.add(new ShortValue((short)0));//4--结束标记（等于 1 时为结束)
			spx.add(new StringValue(only), SqlParameterExt.SQL_OUTPUT);//5--唯一值（等于''时为第一条记录
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//6--返回信息
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcrdwtz_jcrdwtzsc]出错" + err.getMessage());
		}
		sql = "p_hfb_jcdw_jcrdwtzqc_del(?p1,?p2,?p3,?p4,?p5,?p6,?p7)";
		try {
			for(int i=0; i<idArr.length; i++) {
				spx.set(1, new StringValue(idArr[i]));
				bo.setSqlParameterExt(spx);
				bo.executeProcedure(sql);
				bo.closestmt();
			}
			spx.set(4, new ShortValue((short)1));
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			//only = spx.get(5).getString();
			msg = spx.get(6).getString();
			ret = spx.get(7).getShort();
			pmt.setOnly(only);
			pmt.setMsg(msg);
			pmt.setRet(ret);
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcrdwtz_jcrdwtzsc]出错" + err.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcrdwtz_prt(Object obj) throws CallDbException {
		Jcdw_jcrdwtzBean pmt=(Jcdw_jcrdwtzBean)obj;
		String sql="select count(a.grzh) rs,max(a.fhczy) spczy,abs(sum(a.dsgrzhye)) zcjce,"+
				"max(a.bgrq) bgrq, max(a.ywlsh) ywlsh, "+
				"case when max(d.dwzh) = max(a.dwzh) then max(a.zydwzh) else max(a.dwzh) end dwzh, "+
				"case when max(d.dwzh) = max(a.dwzh) then max(g.dwmc) else max(c.dwmc) end  dwmc, "+ 
				"case when max(d.dwzh) = max(a.dwzh) then max(a.dwzh) else max(a.zydwzh) end zydwzh,"+
				"case when max(d.dwzh) = max(a.dwzh) then max(c.dwmc) else  max(g.dwmc) end zydwmc,"+
				"case when max(d.dwzh) = max(a.dwzh) then max(g.jbrxm) else max(c.jbrxm) end jbrxm,"+
				"case when max(d.dwzh) = max(a.dwzh) then max(g.jbrsjhm) else max(c.jbrsjhm) end jbrsjhm,"+
				"max(e.xingming) xingming,"+
				"max(a.lrczy) lrczy from gjzf_gr_zzbg a "+
				"inner join gjzf_dw_zz b on a.dwzh = b.dwzh "+
				"inner join cr_dw c on b.dwbh = c.dwbh "+
				"inner join gjzf_dw_zz f on a.zydwzh = f.dwzh "+
				"inner join cr_dw g on f.dwbh = g.dwbh "+
				"inner join gjzf_gr_zz d on a.grzh = d.grzh "+
				"inner join cr_gr e on d.grbh = e.grbh "+
				//"inner join gjzf_dw_zz h on d.dwzh = h.dwzh "+
				//"inner join cr_dw i on f.dwbh = i.dwbh  "+
				"where a.ywlsh='"+XTool.TransactSQLInjection(pmt.getYwlsh())+"' " +
				//"and (a.zcjce+a.zczlx+a.zcjbj) <= 0 " +
				" and a.dwzh='"+pmt.getDwzh()+"' "+
				"group by a.ywlsh union all " +
				"select count(a.grzh) rs,max(a.spczy) spczy,abs(sum(a.dsgrzhye)) zcjce,max(a.lrrq) bgrq, max(a.ywlsh) ywlsh, max(a.dwzh) dwzh, max(c.dwmc) dwmc, "+ 
				"max(a.zydwzh) zydwzh,max(g.dwmc) zydwmc, "+
				"max(c.jbrxm) jbrxm,max(c.jbrsjhm) jbrsjhm,max(e.xingming) xingming, max(a.lrczy) lrczy from gjzf_gr_zzbg_qc a "+
				"inner join gjzf_dw_zz b on a.dwzh = b.dwzh "+
				"inner join cr_dw c on b.dwbh = c.dwbh "+
				"inner join gjzf_dw_zz f on a.zydwzh = f.dwzh "+
				"inner join cr_dw g on f.dwbh = g.dwbh "+
				"inner join gjzf_gr_zz d on a.grzh = d.grzh "+
				"inner join cr_gr e on d.grbh = e.grbh "+
				"where a.ywlsh='"+XTool.TransactSQLInjection(pmt.getYwlsh())+"' " +
				//"and (a.zcjce+a.zczlx+a.zcjbj) <= 0 " +
				" and a.dwzh='"+pmt.getDwzh()+"' "+
				"group by a.ywlsh";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcrdwtz_prt]出错"
					+ e.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcrdwtz_prtmx(Object obj) throws CallDbException {
		Jcdw_jcrdwtzBean pmt=(Jcdw_jcrdwtzBean)obj;
		String sql="select c.xingming,c.zjhm,abs(a.dsgrzhye) zyje from gjzf_gr_zzbg a "+
				" inner join gjzf_gr_zz b on a.grzh=b.grzh inner join cr_gr c on c.grbh=b.grbh  "+
				" where a.ywlsh='"+XTool.TransactSQLInjection(pmt.getYwlsh())+"' " +
				" and a.dwzh='"+pmt.getDwzh()+"' and a.bglbbm='06' "+
				" union all "+
				" select c.xingming,c.zjhm,abs(a.dsgrzhye) zyje"+
				" from gjzf_gr_zzbg_qc a inner join gjzf_gr_zz b on a.grzh=b.grzh"+
				" inner join cr_gr c on c.grbh = b.grbh  where a.ywlsh= '"+XTool.TransactSQLInjection(pmt.getYwlsh())+"'"+
				" and a.dwzh='"+pmt.getDwzh()+"' and a.bglbbm='06' ";
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcrdwtz_prtmx]出错"
					+ e.getMessage());
		}
	}
	public List<Row> openZtbg_Jcrdwtz_jcrdwtzdr(Object obj)
			throws CallDbException {
		Jcdwjcrztbg pmt = (Jcdwjcrztbg) obj;
		String only = "";
		String msg = "";
		short ret = 99;
		String tableName = "tmp_hfb_jcrdwtz_add_pldr";
		String queryStatement = "select grzh,xingming,zjhm,msg  from tmp_hfb_jcrdwtz_add_pldr";
		SqlParameterExt spx = null;
		try {

			spx = new SqlParameterExt(); // 类型转化
			spx.add(new StringValue(pmt.getDwzh()));//1--原单位账号
			spx.add(new StringValue(" "));//2--职工账号
			spx.add(new StringValue(" "));//3--职工姓名
			spx.add(new StringValue(" "));//4--证件号码
			spx.add(new StringValue(pmt.getXdwzh()));//5--新单位账号
			spx.add(new StringValue(pmt.getBgyy()));// 变更原因
			spx.add(new StringValue(pmt.getBlqd().trim()));//6--办理渠道
			spx.add(new LongValue(pmt.getBpmid()));//7--流程业务流水号
			spx.add(new LongValue(pmt.getUserid()));//8--操作员id
			spx.add(new StringValue(pmt.getPzbh()));//9--业务流水号
			spx.add(new IntValue((short)0)); //10 结束标记（等于 1 时为结束)
			spx.add(new StringValue(only), SqlParameterExt.SQL_OUTPUT); //11 唯一值（等于''时为第一条记录）
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT); //12返回值  msg
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//13--返回值：0-成功，98-部分职工存盘不成功，99-不成功

		} catch (Exception e) {
			throw new CallDbException("openZtbg_Jcrdwtz_jcrdwtzdr" + e.getMessage());
		}
		String sql = "p_hfb_jcdw_jcrdwtz_pldr(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11,?p12,?p13,?p14)";
		try {
			String grzhArr[] = pmt.getGrzh().split(",");
			String xingmingArr[] = pmt.getXingming().split(",");
			String zjhmArr[] = pmt.getZjhm().split(",");
			
			for (int i = 0; i < grzhArr.length; i++) {
				spx.set(2, new StringValue(grzhArr[i].trim().replace(",", "")));
				spx.set(3, new StringValue(xingmingArr[i].trim().replace(",", "")));
				spx.set(4, new StringValue(zjhmArr[i].trim().replace(",", "").toUpperCase()));
				bo.setSqlParameterExt(spx);
				bo.executeProcedure(sql);
				if (spx.get(13).getString().trim().equals("")) {
					only = spx.get(12).getString();
				}
				bo.closestmt();
			}
			spx.set(11, new IntValue(1));

			try {
				bo.setSqlParameterExt(spx);
				List<Row> list = bo.queryProcedureToList(sql, tableName, queryStatement, 0, 0);
				// 获取返回值
				pmt.setMsg(spx.get(13).getString());
				pmt.setRet(spx.get(14).getShort());
				return list;

			} catch (Exception err) {
				pmt.setMsg(err.getMessage());
				throw new CallDbException(err.getMessage());
			}
		} catch (Exception e) {
			pmt.setMsg(e.getMessage());
			throw new CallDbException("执行方法[openZtbg_Jcrdwtz_jcrdwtzdr]出错"
					+ e.getMessage());
		}
	}
	
	 public List<Row> openZtbg_Jcrdwtz_jcrdwtzspcx(Object obj, int pagesize,
		      int pagenum) throws CallDbException {
		 Jcdwjcrztbg pmt = (Jcdwjcrztbg) obj;
		    
		    String sql=" select a.bpmid,a.ywlsh,b.dwzh, c.xingming,b.grzh grbh,c.zjhm,d.dwzh zcdwbh,e.dwmc zcdwmc, "
		         + " f.dwzh zydwbh,j.dwmc zydwmc,a.id,d.dwbh,a.bgyy bgyy,a.bgyd,a.zydwzh zydwzh,f.dwbh xdwbh "
		         + " from gjzf_gr_zzbg_qc a inner join gjzf_gr_zz b on a.grzh=b.grzh "
		         + " inner join cr_gr c on b.grbh=c.grbh  "
		         + " inner join gjzf_dw_zz d on a.dwzh=d.dwzh "
		         + " inner join cr_dw e on e.dwbh=d.dwbh "
		         + " inner join gjzf_dw_zz f on a.zydwzh=f.dwzh "
		         + " inner join cr_dw j on j.dwbh=f.dwbh "
		         + " where a.bpmid= '"+pmt.getBpmid()+"'" ;
		    sql+="union all select a.bpmid,a.ywlsh,b.dwzh, c.xingming,b.grzh grbh,c.zjhm,d.dwzh zcdwbh,e.dwmc zcdwmc, "
			         + " f.dwzh zydwbh,j.dwmc zydwmc,a.id,d.dwbh ,a.bgyy bgyy,a.bgyd,a.zydwzh zydwzh,f.dwbh xdwbh "
			         + " from gjzf_gr_zzbg a inner join gjzf_gr_zz b on a.grzh=b.grzh "
			         + " inner join cr_gr c on b.grbh=c.grbh  "
			         + " inner join gjzf_dw_zz d on a.dwzh=d.dwzh "
			         + " inner join cr_dw e on e.dwbh=d.dwbh "
			         + " inner join gjzf_dw_zz f on a.zydwzh=f.dwzh "
			         + " inner join cr_dw j on j.dwbh=f.dwbh "
			         + " where a.bpmid= '"+pmt.getBpmid()+"'" ;
		    try {
		      SqlParameterExt spx = new SqlParameterExt();
		      bo.setSqlParameterExt(spx);
		      return bo.queryToList(sql,pagesize,pagenum);
		      
		    } catch (Exception e) {
		      throw new CallDbException("执行方法[openZtbg_Jcrdwtz_jcrdwtzspcx]出错"
		          + e.getMessage());
		    }
		  }
}
