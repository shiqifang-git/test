package com.shineyue.calldb.business.impl.ztbg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shineyue.bean.ztbg.CommonBean;
import com.shineyue.bean.ztbg.Jcdw_jcrbgztBean;
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

public class Ztbg_jcrztbgImpl extends AbstractDbInterface{
	public Ztbg_jcrztbgImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	public void executeZtbg_Jcrztbg_jcrbgztadd(Object obj) throws CallDbException {
		Jcdwjcrztbg pmt = (Jcdwjcrztbg) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		short ret = 99;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getGrzh().trim()));//1--个人账号
			spx.add(new StringValue(pmt.getBglb().trim()));//2--变更类别
			spx.add(new StringValue(pmt.getBgyy().trim()));//3--变更原因编码
			spx.add(new StringValue(pmt.getBgyd()));//4--变更月度
			spx.add(new StringValue(pmt.getYwlsh()));
			spx.add(new StringValue(pmt.getBlqd()));//5--办理渠道
			spx.add(new LongValue(pmt.getBpmid()));//业务流程ID
			spx.add(new IntValue(pmt.getUserid()));//6--操作员id
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//7--返回信息
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//8--返回值 0-成功，1-职工已存在封存清册,2-职工账户已销户或调出, 99-不成功
		} catch (Exception err) {
			throw new CallDbException("执行方法[executejcdw_jcrbgzt_add]出错" + err.getMessage());
		}
		try {
			sql = "p_hfb_jcdw_jcrbgzt_add(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10)";
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			msg = spx.get(9).getString();
			ret = spx.get(10).getShort();
			pmt.setMsg(msg);
			pmt.setRet(ret);
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcrztbg_jcrbgztadd]出错" + err.getMessage());
		}
	}
	public List<Row> openZtbg_Jcrztbg_jcrbgztqccx(Object obj, int pagesize,
			int pagenum) throws CallDbException {
		SqlParameterExt spx = null;
		try {
			spx = new SqlParameterExt();
			Jcdwjcrztbg_qc pmt = (Jcdwjcrztbg_qc)obj;
			String sql = "select a.lrczy,b.dwbh,a.dwzh,a.grzh,d.xingming,d.zjhm,a.tzhjcjs grjcjs,a.tzhgryjce+a.tzhdwyjce+a.tzhbcyjce+a.tzhczybte yjce,"
					+ "  a.bglbbm,a.bgyy,a.bgrq,a.bgyd,a.id,e.mc bglb,a.bpmid,a.ywlsh "		//case when '"+pmt.getBglb()+"'='05' then '封存' else '启封' end bglb,
					+ " from gjzf_gr_zzbg_qc a inner join gjzf_dw_zz b on a.dwzh=b.dwzh"
					+ " inner join gjzf_gr_zz c on a.grzh=c.grzh" 
					+ " inner join cr_gr d on  c.grbh=d.grbh inner join bm_gz_ywlx e on a.bglbbm = e.bm where a.spzt=0 and a.bglbbm='"+XTool.TransactSQLInjection(pmt.getBglb())+"'"
					+ " and a.dwzh = '"+XTool.TransactSQLInjection(pmt.getDwzh())+"' order by a.grzh";//and a.bgyd<=b.jzny
			bo.setSqlParameterExt(spx);
			bo.setHjParameter("grjcjs,yjce");
			return bo.queryToList(sql, pagesize, pagenum);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcrztbg_jcrbgztqccx]出错"
					+ e.getMessage());
		}
	}
	public void executeZtbg_Jcrztbg_jcrbgztqcdel(Object obj) throws CallDbException {
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
			throw new CallDbException("执行方法[executejcdw_jcrbgztqc_del]出错" + err.getMessage());
		}
		sql = "p_hfb_jcdw_jcrbgzt_del(?p1,?p2,?p3,?p4,?p5,?p6,?p7)";
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
			throw new CallDbException("执行方法[executeZtbg_Jcrztbg_jcrbgztqcdel]出错" + err.getMessage());
		}
	}
	
	public void executeZtbg_Jcrztbg_jcrbgztqcdelall(Object obj) throws CallDbException {
		Jcdwjcrztbg_qc pmt = (Jcdwjcrztbg_qc) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		short ret = 99;
		try {
			sql = "p_hfb_jcdw_jcrbgzt_delAll(?p1,?p2,?p3,?p4,?p5)";
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getYwlsh()));//1唯一记录id
			spx.add(new StringValue(pmt.getBlqd().trim()));//2--办理渠道
			spx.add(new IntValue(pmt.getUserid()));//3--操作员id
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//4--返回信息
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//5
			
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			msg = spx.get(4).getString();
			ret = spx.get(5).getShort();  
			pmt.setMsg(msg);
			pmt.setRet(ret);
		} catch (Exception err) {
			err.printStackTrace();
			throw new CallDbException("执行方法[executeZtbg_Jcrztbg_jcrbgztqcdelall]出错" + err.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcrztbg_jcrbgztdr(Object obj) throws CallDbException {
		Jcdwjcrztbg pmt = (Jcdwjcrztbg) obj;
		String only = "";
		String msg = "";
		
		SqlParameterExt spx = null;
		short ret = 99;
		try {
			
			String sql = "insert into tmp_gz_table(sure_id,value1,value2,value3) values(?,?,?,?)";
			
			String[] bgyyArr = pmt.getBgyy().split(",");
			String[] grzhArr = pmt.getGrzh().split(",");
			String[] xingmingArr = pmt.getXingming().split(",");
			
			List<SqlParameterExt> l = new ArrayList<SqlParameterExt>();
			
			long time=System.currentTimeMillis(); 
	        for (int i = 0; i < xingmingArr.length; i++) {
	            SqlParameterExt spx1 = new SqlParameterExt(false); // 类型转化
	            	  spx1.add(new StringValue(pmt.getYwlsh()));
	            	  spx1.add(new StringValue(grzhArr[i].trim().replace(",", "")));
	            	  spx1.add(new StringValue(xingmingArr[i].trim().replace(",", "")));
	            	  spx1.add(new StringValue(bgyyArr[i].trim().replace(",", "")));

	            l.add(spx1);
	        }
	        System.out.println("123==============time0>"+(System.currentTimeMillis()-time));
	        System.out.println("==============>"+l.size());
	        bo.setSqlParameterExtArr(l);
	        System.out.println("123==============time1>"+(System.currentTimeMillis()-time));
	        int[] arrs=  bo.executeInsertBatch(sql);
	        System.out.println("==="+arrs.length);
			
			
			spx = new SqlParameterExt(); // 类型转化
			spx.add(new StringValue(pmt.getDwzh()));//1--单位账号
			spx.add(new StringValue(pmt.getBglb()));//2-变更类别(04启封05封存)
			spx.add(new StringValue(" "));//3--封存/启封原因
			spx.add(new StringValue(pmt.getYwlsh()));//4业务流水号
			spx.add(new LongValue(pmt.getBpmid()));//5流程业务流水号
			spx.add(new StringValue(" "));//6--职工账号
			spx.add(new StringValue(" "));//7--职工姓名
			spx.add(new StringValue(pmt.getBlqd()));//8--办理渠道
			spx.add(new LongValue(pmt.getUserid()));//9--操作员id
			spx.add(new IntValue(1)); //10--结束标记（等于 1 时为结束)
			spx.add(new StringValue(pmt.getYwlsh()), SqlParameterExt.SQL_OUTPUT); //11--唯一值（等于''时为第一条记录）
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT); //12--返回值
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);
	
			String s = "p_hfb_jcdw_jcrbgzt_pldr(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11,?p12,?p13)";
			String tableName = "tmp_gz_table";
			String queryStatement = "select grzh,xingming,msg from tmp_hfb_jcrbgzt_add_pldr where sure_id = '"+pmt.getYwlsh()+"'";
			
			
			
			bo.setSqlParameterExt(spx);
			List<Row> list = bo.queryProcedureToList(s, tableName, queryStatement, 0, 0);
			// 获取返回值
			pmt.setOnly(spx.get(11).getString());
			pmt.setMsg(spx.get(12).getString());
			pmt.setRet(spx.get(13).getShort());
			return list;

		
		} catch (Exception e) {
			pmt.setMsg(e.getMessage());
			pmt.setRet(99);
			throw new CallDbException("执行方法[openZtbg_Jcrztbg_jcrbgztdr]出错"+ e.getMessage());
		}
	}
	public List<Row> openZtbg_Jcrztbg_jcrbgztdyqc(Object obj) throws CallDbException {
		Jcdw_jcrbgztBean pmt=(Jcdw_jcrbgztBean)obj;
		String grzh=XTool.TransactSQLInjection(pmt.getGrzh());
		String sql1="";
		if(!"".equals(grzh)){
			sql1=" and a.grzh='"+grzh+"' ";
		}
		//提交审批后 打印清册
		String sql="select a.grzh, a.spczy,a.bgyd, a.lrczy,d.dwyjce+d.gryjce  yjce,a.lrrq bgrq,a.ywlsh,b.dwzh,c.dwmc,c.jbrxm,c.jbrsjhm,e.xingming,e.zjhm,d.grzhzt,"
				+" case when a.bglbbm = '04' then '封存' else '正常' end bgqgrzhzt,"
				+" case when a.bglbbm = '04' then '正常' else '封存' end bghgrzhzt, a.bgyd, "
	      // 	+" from gjzf_gr_zzbg_qc a"
	       	    +" (select sum(d.dwyjce+d.gryjce) from gjzf_gr_zzbg a inner join gjzf_gr_zz d on a.grzh = d.grzh " 
	       	    +" where a.ywlsh='" +XTool.TransactSQLInjection(pmt.getYwlsh()) +"') yjcze "
	      		+" from gjzf_gr_zzbg a"
				+" inner join gjzf_dw_zz b on a.dwzh = b.dwzh"
				+" inner join cr_dw c on b.dwbh = c.dwbh"
				+" inner join gjzf_gr_zz d on a.grzh = d.grzh"
				+" inner join cr_gr e on d.grbh = e.grbh"
				+" inner join bm_gz_grzhzt f on d.grzhzt = f.bm"
				+" inner join gjzf_gr_zz z on z.grzh =a.grzh"
				+" inner join bm_gz_grzhzt x on z.grzhzt = x.bm" 
				+" where a.bglbbm in ('04','05')  and a.ywlsh='" +
				XTool.TransactSQLInjection(pmt.getYwlsh())
				//"' order by a.grzh ";
				+"' "+sql1+" union all "
		        +" select a.grzh, a.spczy,a.bgyd, a.lrczy,d.dwyjce+d.gryjce  yjce,a.lrrq bgrq,a.ywlsh,b.dwzh,c.dwmc,c.jbrxm,c.jbrsjhm,e.xingming,e.zjhm,d.grzhzt,"
				+" case when a.bglbbm = '04' then '封存' else '正常' end bgqgrzhzt,"
				+" case when a.bglbbm = '04' then '正常' else '封存' end bghgrzhzt, a.bgyd, "
	      // 	+" from gjzf_gr_zzbg_qc a"
	       	    +" (select sum(d.dwyjce+d.gryjce) from gjzf_gr_zzbg_qc a inner join gjzf_gr_zz d on a.grzh = d.grzh " 
	       	    +" where a.ywlsh='" +XTool.TransactSQLInjection(pmt.getYwlsh()) +"') yjcze "
	      		+" from gjzf_gr_zzbg_qc a"
				+" inner join gjzf_dw_zz b on a.dwzh = b.dwzh"
				+" inner join cr_dw c on b.dwbh = c.dwbh"
				+" inner join gjzf_gr_zz d on a.grzh = d.grzh"
				+" inner join cr_gr e on d.grbh = e.grbh"
				+" inner join bm_gz_grzhzt f on d.grzhzt = f.bm"
				+" inner join gjzf_gr_zz z on z.grzh =a.grzh"
				+" inner join bm_gz_grzhzt x on z.grzhzt = x.bm" 
				+" where a.bglbbm in ('04','05')  and a.ywlsh='" +
				XTool.TransactSQLInjection(pmt.getYwlsh()) +
				"' "+sql1+" order by grzh ";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcrztbg_jcrbgztdyqc]出错"
					+ e.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcrztbg_jcrbgztplcx(Object obj,int pagesize,
			int pagenum) throws CallDbException {
		Jcdw_jcrbgztBean pmt=(Jcdw_jcrbgztBean)obj;
		System.out.println("------------------------zxbm----------------"+pmt.getZxbm());
		String v_grzhzt = XTool.TransactSQLInjection(pmt.getGrzhzt());
		
		String sql="select bgyy.bm bgyymc,bgyy.mc bgyymc1,a.grzh,gr.xingming,gr.zjhm,a.dwzh,dw.dwmc,a.grbh,dwyjce+gryjce+bcyjce+czybte yjce "+
				" from gjzf_gr_zz a inner join cr_gr gr on gr.grbh=a.grbh "+
				" inner join gjzf_dw_zz b on b.dwzh=a.dwzh "+
				" inner join cr_dw dw on dw.dwbh=b.dwbh "+
				" left join bm_bgyy_gr bgyy on bgyy.jgbm like '"+XTool.TransactSQLInjection(pmt.getJgbm()).substring(0, 2)+"%'"+
				" where  a.dwzh='"+XTool.TransactSQLInjection(pmt.getDwzh())+"'"+
				" and  bgyy.bm ='"+XTool.TransactSQLInjection(pmt.getBgyybm())+"' " +
				" and bgyy.bm1='"+XTool.TransactSQLInjection(pmt.getBglb())+"' " ;
		if(pmt.getGrzh()!=null&&!"".equals(XTool.TransactSQLInjection(pmt.getGrzh()))){
			sql += " and (a.grzh like '"+XTool.TransactSQLInjection(pmt.getGrzh())+"%' or gr.xingming like '"+XTool.TransactSQLInjection(pmt.getGrzh())+"%' ) ";
		}
		if(v_grzhzt=="06"||"06".equals(v_grzhzt)){
			sql += " and a.zhsfdj=1 ";
		}else{
			sql += " and a.grzhzt='"+v_grzhzt+"'";
		}
		if(pmt.getZjhm()!=null&&!"".equals(XTool.TransactSQLInjection(pmt.getZjhm()))){
			sql += " and gr.zjhm like upper('"+XTool.TransactSQLInjection(pmt.getZjhm())+"')||'%' ";
		}
		if(pmt.getXingming()!=null&&!"".equals(XTool.TransactSQLInjection(pmt.getXingming()))){
			sql += " and gr.xingming like '"+XTool.TransactSQLInjection(pmt.getXingming())+"%' ";
		}

		sql+=" order by a.grzh,gr.xingming ";

		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,pagesize, pagenum);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[Ztbg_Jcrztbg_jcrbgztplcx]出错"
					+ e.getMessage());
		}
	}
	
	public void executeZtbg_Jcrztbg_jcrbgztplcp(Object obj) throws CallDbException {
		Jcdwjcrztbg pmt = (Jcdwjcrztbg) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		short ret = 99;
		String[] grzh = null;
		String[] bgyy = null;
		String[] bgyd = null;
		grzh = pmt.getGrzh().split(",");
		bgyy = pmt.getBgyy().split(",");
        bgyd = pmt.getBgyd().split(",");
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(grzh[0]));//1--个人账号
			spx.add(new StringValue(pmt.getBglb().trim()));//2--变更类别
			spx.add(new StringValue(bgyy[0]));//3--变更原因编码
			spx.add(new StringValue(bgyd[0]));//4--变更月度
			spx.add(new StringValue(pmt.getYwlsh()));
			spx.add(new StringValue(pmt.getBlqd()));//5--办理渠道
			spx.add(new LongValue(pmt.getBpmid()));//业务流程ID
			spx.add(new IntValue(pmt.getUserid()));//6--操作员id
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//7--返回信息
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//8--返回值 0-成功，1-职工已存在封存清册,2-职工账户已销户或调出, 99-不成功
		} catch (Exception e) {
			pmt.setRet((short) 99);
			throw new CallDbException("缴存人变更状态批量勾选录入参数设置出错！" + e.getMessage());
		}
		try {
			sql = "p_hfb_jcdw_jcrbgzt_add_plgx(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10)";
			for (int i = 0; i < grzh.length; i++) {
				spx.set(1, new StringValue(grzh[i]));
				spx.set(2, new StringValue(pmt.getBglb().trim())); // p1 职工账号
				spx.set(3, new StringValue(bgyy[i] == null
						||bgyy[i].trim().equals("") ? "" : bgyy[i].trim())); // p2
				spx.set(4, new StringValue(bgyd[i])); // 03
				spx.set(5, new StringValue(pmt.getYwlsh())); //5
				spx.set(6,new StringValue(pmt.getBlqd()));//6--办理渠道
				spx.set(7,new LongValue(pmt.getBpmid()));//业务流程ID
				spx.set(8,new IntValue(pmt.getUserid()));//7--操作员id
				spx.set(9,new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//8--返回信息
				spx.set(10,new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//9--返回值 0-成功，1-职工已存在封存清册,2-职工账户已销户或调出, 99-不成功
				bo.setSqlParameterExt(spx);
				bo.executeProcedure(sql);
				msg = spx.get(9).getString();
				ret = spx.get(10).getShort();
				pmt.setMsg(msg);
				pmt.setRet(ret);
				bo.closestmt();
			}
			
		} catch (Exception e) {
			throw new CallDbException("缴存人变更状态批量勾选录入出错！" + e.getMessage());
		}
	}
	public List<Row> openZtbg_Jcrztbg_jcrbgztspcx(Object obj, int pagesize,
		      int pagenum) throws CallDbException {
		Jcdwjcrztbg_qc pmt = (Jcdwjcrztbg_qc) obj;
		    
		    String sql=" select b.dwbh,a.dwzh,f.dwmc,a.grzh,d.xingming,d.zjhm,a.tzhjcjs grjcjs,"
		    		+  " a.tzhgryjce+a.tzhdwyjce+a.tzhbcyjce+a.tzhczybte yjce,"
		    		+  " a.bglbbm,a.bgyy,a.bgrq,a.id,e.mc bglb,a.bpmid,a.ywlsh　"
		    		+  " from gjzf_gr_zzbg_qc a inner join gjzf_dw_zz b on a.dwzh=b.dwzh " 
		    		+  " inner join gjzf_gr_zz c on a.grzh=c.grzh inner join cr_gr d on  c.grbh=d.grbh"
		    		+  " inner join bm_gz_ywlx e on a.bglbbm = e.bm"
		    		+  " left join cr_dw f on f.dwbh = b.dwbh "
		            +  " where a.bpmid= '"+pmt.getBpmid()+"' " 
		         	+  " union all " 
				    +  " select b.dwbh,a.dwzh,f.dwmc,a.grzh,d.xingming,d.zjhm,a.tzhjcjs grjcjs, " 
				    +  " a.tzhgryjce+a.tzhdwyjce+a.tzhbcyjce+a.tzhczybte yjce,　a.bglbbm,a.bgyy," 
				    +  " a.bgrq,a.id,e.mc bglb,a.bpmid,a.ywlsh " 
				    +  " from gjzf_gr_zzbg a inner join gjzf_dw_zz b on a.dwzh = b.dwzh " 
				    +  " inner join gjzf_gr_zz c on a.grzh=c.grzh " 
				    +  " inner join cr_gr d on  c.grbh=d.grbh inner join bm_gz_ywlx e on a.bglbbm = e.bm " 
				    +  " left join cr_dw f on f.dwbh = b.dwbh  where a.bpmid= '"+pmt.getBpmid()+"' " ;
		    try {
		      SqlParameterExt spx = new SqlParameterExt();
		      bo.setSqlParameterExt(spx);
		      return bo.queryToList(sql,pagesize,pagenum);
		      
		    } catch (Exception e) {
		      throw new CallDbException("执行方法[openZtbg_Jcrztbg_jcrbgztspcx]出错"
		          + e.getMessage());
		    }
		  }
	public List<Row> openZtbg_Jcrztbg_jcrbgztyyqccx(Object obj, int pagesize,
			int pagenum) throws CallDbException {
		try {

		Jcdwjcrztbg_mx pmt = (Jcdwjcrztbg_mx) obj;
		String sql = "";
		String sql1="";
		String dwzh = XTool.TransactSQLInjection(pmt.getDwzh().trim());
		String grzh = XTool.TransactSQLInjection(pmt.getGrzh().trim());
		if(dwzh.equals("")||dwzh.equals(null)){
			dwzh="%";
		}
		if(grzh.equals("")||grzh.equals(null)){
			grzh="%";
		}
		//int userid = pmt.getUserid();
		sql1=" a.dwzh like '"+dwzh+"' and a.grzh like'"+grzh+"' order by a.grzh ";
		//不启用通存通兑查询begin
		String v_qx_sql = "";
		//Hfb_common common = new Hfb_common();
		CommonBean commonbean = new CommonBean();
		commonbean.setQxlb("02");
		commonbean.setTabname("f");
		commonbean.setUserid(pmt.getUserid());
		//v_qx_sql =common.hfb_Common_Bqytctd_Cx(commonbean);
		v_qx_sql =Common_Bqytctd_Cx(commonbean);
		System.out.println("v_qx_sql==========="+v_qx_sql);
		//不启用通存通兑查询end
		sql = " select  (select ywlsh from gjzf_gr_zzbg where id in (select max(id) from gjzf_gr_zzbg e where e.grzh = a.grzh  and e.bglbbm = '05' "+
				" )) ywlsh,(select bgyy from gjzf_gr_zzbg where id in (select max(id) from gjzf_gr_zzbg e where e.grzh = a.grzh  and e.bglbbm = '05' "+
				" )) bgyy,(select bgrq from gjzf_gr_zzbg where id in (select max(id) from gjzf_gr_zzbg e where e.grzh = a.grzh  and e.bglbbm = '05' "+
				")) bgrq,a.dwzh,a.id,a.grzh,b.xingming,b.zjhm,a.grjcjs,a.dwyjce+a.gryjce yjce,a.dwyjce,a.gryjce, f_hfsc_get_value(a.grzh,'grzhye') grzhye,a.grbh,c.dwbh " 
				 +" from gjzf_gr_zz a " 
			     +" inner join cr_gr b on a.grbh=b.grbh" 
			     +" inner join gjzf_dw_zz c on a.dwzh=c.dwzh"
				 
				 +" where "+v_qx_sql+ " and  a.grzhzt='02' and c.jzfcbz<>2 and c.jzfcbz<>5 and ";
		sql+=sql1;
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			bo.setHjParameter("grjcjs,yjce,dwyjce,gryjce,grzhye");
			return bo.queryToList(sql, pagesize, pagenum);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcrztbg_jcrbgztyyqccx]出错"
					+ e.getMessage());
		}
	}
	public void executeZtbg_Jcrztbg_jcrfcbg(Object obj) throws CallDbException {
		Jcdwjcrztbg pmt = (Jcdwjcrztbg) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		String only = "";
		String pzbh = "";
		short ret = 99;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh().trim()));//1
			spx.add(new StringValue(pmt.getBlqd()));//2--办理渠道
			spx.add(new IntValue(pmt.getUserid()));//3--操作员id
			spx.add(new StringValue(" "));//4 个人账号
			spx.add(new StringValue(pmt.getFcyy().trim()));  //5封存原因
			spx.add(new StringValue(" ")); //6  清册查询业务流水号
			spx.add(new ShortValue((short)0));//7--结束标记（等于 1 时为结束)
			spx.add(new StringValue(only), SqlParameterExt.SQL_INPUT_OUTPUT);//8--唯一值（等于''时为第一条记录
			spx.add(new StringValue(pmt.getBgywlsh()));//9  新生成业务流水号
			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);//10--返回信息
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//11 --返回值 0-成功，1-已存盘完毕, 99-不成功
		
			sql = "p_hfb_jcdw_jcrfcbg(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11)";
			String[] pzidArr = pmt.getPzid().split(",");
			String[] grzhArr = pmt.getGrzh().split(",");
			String[] ywlshArr=pmt.getYwlshArr().split(",");
			System.out.println(">>>>>>>>>>>>><<<<<<<<<"+Arrays.toString(ywlshArr));
			for(int i=0; i<pzidArr.length; i++) {
					spx.set(4, new StringValue(grzhArr[i]));
					spx.set(6, new StringValue(ywlshArr[i]));
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+ywlshArr[i]);
					bo.setSqlParameterExt(spx);
					bo.executeProcedure(sql);
					bo.closestmt();
			}
			
			spx.set(7, new ShortValue((short)1));
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			only = spx.get(8).getString();
			pzbh = spx.get(9).getString();
			msg = spx.get(10).getString();
			ret = spx.get(11).getShort();
			pmt.setOnly(only);
			pmt.setPzbh(pzbh);
			pmt.setMsg(msg);
			pmt.setRet(ret);
		} catch (Exception err) {
			err.printStackTrace();
			throw new CallDbException("执行方法[executeZtbg_Jcrztbg_jcrfcbg]出错" + err.getMessage());
		}
	}
	public   String  Common_Bqytctd_Cx(Object obj) throws CallDbException {
		CommonBean pmt = (CommonBean) obj;
		String qxlb = XTool.TransactSQLInjection(pmt.getQxlb());
		String tabname = XTool.TransactSQLInjection(pmt.getTabname());
		int userid = pmt.getUserid();
		String sql = " select f_hfsc_get_user_sjqx('"+qxlb+"','"+tabname+"','"+userid+"') qx_sql from dual ";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			List<Row> lst = bo.queryToList(sql);
			String sql2="";
			if (lst.size() > 0) {
				Row row = lst.get(0);
				sql2=row.getTrimString("qx_sql");
			}
			return  sql2;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[Common_Bqytctd_Cx]出错" + e.getMessage());
		}
	}
	public void executeZtbg_Jcrztbg_jcrbgqr(Object obj) throws CallDbException {
		Jcdwjcrztbg pmt = (Jcdwjcrztbg) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		String only = "";
		String pzbh = "";
		short ret = 99;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh()));//1--单位账号
			spx.add(new StringValue(" "));//2--操作记录唯一id
			spx.add(new DateValue(XTool.Str2Date(" ")));//3--封存/启封日期
			spx.add(new StringValue(pmt.getBlqd()));//4--办理渠道
			spx.add(new StringValue(" "));//5--变更类别(04启封05封存)
			spx.add(new DoubleValue(0));//6--月缴存金额
			spx.add(new IntValue(Integer.parseInt(pmt.getUseridArr())));//7--操作员id
			spx.add(new ShortValue((short)0));//8--结束标记（等于 1 时为结束)
			spx.add(new StringValue(only), SqlParameterExt.SQL_INPUT_OUTPUT);//9--唯一值（等于''时为第一条记录
			spx.add(new StringValue(pmt.getPzbh()));//10--流水号
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//11--返回信息
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//12
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcrztbg_jcrbgqr]出错" + err.getMessage());
		}
		sql = "p_hfb_jcdw_jcrbgzt_save(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11,?p12)";
		String[] pzidArr = pmt.getPzid().split(",");
		String[] bgrqArr = pmt.getBgrq().split(",");
		String[] bglbArr = pmt.getBglb().split(",");
		String[] jcjeArr = pmt.getYcjeArr().split(",");
		//String[] useridArr = pmt.getUseridArr().split(",");
		//String[] pzbhArr = pmt.getPzbh().split(",");
		//System.out.println("***************888********"+pzbhArr);
		try {
			for(int i=0; i<pzidArr.length; i++) {
				spx.set(2, new StringValue(pzidArr[i]));
				spx.set(3, new DateValue(XTool.Str2Date(bgrqArr[i])));
				spx.set(5, new StringValue(bglbArr[i]));
				spx.set(6, new DoubleValue(Double.parseDouble(jcjeArr[i])));
				//spx.set(7, new IntValue(Integer.parseInt(useridArr[i])));
				//spx.set(10, new StringValue(pzbhArr[i]), SqlParameterExt.SQL_INPUT_OUTPUT);
				bo.setSqlParameterExt(spx);
				bo.executeProcedure(sql);
				bo.closestmt();
			}
			spx.set(8, new ShortValue((short)1));
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			only = spx.get(9).getString();
			pzbh = spx.get(10).getString();
			msg = spx.get(11).getString();
			pmt.setOnly(only);
			pmt.setPzbh(pzbh);
			pmt.setMsg(msg);
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcrztbg_jcrbgqr]出错" + err.getMessage());
		}
	}
}
