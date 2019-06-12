package com.shineyue.calldb.business.impl.ztbg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.shineyue.bean.ztbg.Gjzf_Gr_Jcbz;
import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.bean.ztbg.JcdwhjhdExcelbean;
import com.shineyue.bean.ztbg.Jcdwhjhdbean;
import com.shineyue.calldb.CallDbException;
import com.shineyue.calldb.SqlParameterExt;
import com.shineyue.calldb.business.AbstractDbInterface;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.sql.value.DoubleValue;
import com.shineyue.calldb.sql.value.IntValue;
import com.shineyue.calldb.sql.value.LongValue;
import com.shineyue.calldb.sql.value.ShortValue;
import com.shineyue.calldb.sql.value.StringValue;
import com.shineyue.calldb.util.XTool;
import com.shineyue.service.ztbg.common.ExcelUtil;

public class Ztbg_jcdwjcrjstzImpl extends AbstractDbInterface{
	private Logger logger = Logger.getLogger(this.getClass());
	public Ztbg_jcdwjcrjstzImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	public List<Row> openZtbg_Jcdwjcrjstz_jcrjsbgqccx(Object obj,int size,int page) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String sql=" select a.id ids,a.lrczy,a.grzh,b.xingming,b.zjhm,a.grjcjs,a.bgyd,(a.gryjce+a.dwyjce+a.czybte+a.bcyjce) yjce, "+
				" a.gryjce,a.dwyjce,d.mc jcblbm,e.mc tzhjcblbm,a.tzhjcjs,(a.tzhgryjce+a.tzhdwyjce+a.tzhczybte+a.tzhbcyjce) tzhyjce,"+
				" a.tzhgryjce,a.tzhdwyjce,a.ywlsh,a.bpmid,f.dwbh dwbh,"+
				" (a.tzhgryjce+a.tzhdwyjce+a.tzhczybte+a.tzhbcyjce)-(a.gryjce+a.dwyjce+a.czybte+a.bcyjce) yjcece ,a.bgcs"+
				" from gjzf_gr_zzbg_jc_qc a  "+
				" inner join gjzf_gr_zz c on a.grzh=c.grzh "+
				" inner join cr_gr b on b.grbh=c.grbh "+
				" left join bm_gz_jcbl d on d.bm=a.jcblbm and d.jgbm like '"+XTool.TransactSQLInjection(pmt.getZxbm())+"%'"+
				" left join bm_gz_jcbl e on e.bm=a.tzhjcblbm and e.jgbm like '"+XTool.TransactSQLInjection(pmt.getZxbm())+"%'"+
				" left join gjzf_dw_zz f on f.dwzh=c.dwzh "+
				" where a.dwzh='" +
				XTool.TransactSQLInjection(pmt.getDwzh()) +
				"' and  a.spzt in ('0','3')  ";//and a.lrczyid = '"+pmt.getUserid()+"' ";
		
			if (!pmt.getGrzh().trim().equals("")) {
				sql = sql + " and a.grzh like replace ('"+XTool.TransactSQLInjection(pmt.getGrzh()) +"',' ','%') ";
			}
			sql = sql +" order by a.id ";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setHjParameter("grjcjs,yjce,dwyjce,gryjce,tzhyjce,tzhjcjs,tzhgryjce,tzhdwyjce,yjcece");
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrjstz_jcrjsbgqccx]出错"
					+ e.getMessage());
		}
	}
	
	public void executeZtbg_Jcdwjcrjstz_jcrjsbgqclr(Object obj) throws CallDbException {
		SqlParameterExt spx = null;
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String msg="录入失败！";
		short ret=99;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh()));//1
			spx.add(new StringValue(pmt.getGrzh()));
			spx.add(new StringValue(pmt.getXingming()));
			spx.add(new DoubleValue(pmt.getJine()));//4
			spx.add(new StringValue(pmt.getJcblbm()==null?" ":pmt.getJcblbm().trim()));
			spx.add(new StringValue(pmt.getYwlsh()));
			spx.add(new LongValue(pmt.getBpmidx()));
			spx.add(new IntValue(pmt.getBglb()));
			spx.add(new StringValue(pmt.getBlqd()));
			spx.add(new IntValue(pmt.getUserid()));
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//10
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//11
		}catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
		String s = "p_hfb_jcdw_jcjsbgqc_add(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(11).getString());
			pmt.setRet(String.valueOf(spx.get(12).getShort()));

		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
	}
	
	public void executeZtbg_Jcdwjcrjstz_jcrjsbgqcdel(Object obj) throws CallDbException {
		SqlParameterExt spx = null;
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String msg="删除失败！";
		short ret=99;
		String only = "";
		
		String ids[] = pmt.getIds().split(",");
		
		try {
			spx = new SqlParameterExt();
			String id ="";
			String s = "p_hfb_jcdw_jcrjsbgqc_del(?,?,?,?,?,?,?)";
			
			spx.add(new StringValue(""));//1. 单位账号
			spx.add(new StringValue(""));  //2. 操作记录唯一id
			spx.add(new IntValue(pmt.getUserid())); //3.用户代码
			spx.add(new ShortValue(VL_ZERO));   //4.结束标记（等于 1 时为结束)
			spx.add(new StringValue(only), SqlParameterExt.SQL_INPUT_OUTPUT);  //5 唯一值（等于''时为第一条记录）
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//6返回信息 
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//7返回值
			for (int i = 0; i < ids.length; i++) {
				id = ids[i].trim();
				spx.set(1, new StringValue(pmt.getDwzh()));
				spx.set(2, new StringValue(ids[i]));
		
				bo.setSqlParameterExt(spx);
				bo.executeProcedure(s);
				only = spx.get(5).getString();
				ret = spx.get(7).getShort();
				if (ret != 0) {
					throw new CallDbException("唯一值[" + id + "]循环不成功!");
				}
				bo.closestmt();
			}
			spx.set(4, new ShortValue(VL_ONE));
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(6).getString());
			pmt.setRet(String.valueOf(spx.get(7).getShort()));

		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException(e.getMessage());
		}
	}
	public void executeZtbg_Jcdwjcrjstz_jcrjsbgqcdelall(Object obj) throws CallDbException {
		Jcdwhjhdbean pmt = (Jcdwhjhdbean) obj;
		SqlParameterExt spx = null;
		String sql = "";
		String msg = "";
		String only = "";
		short ret = 99;
		String [] grzhArr = pmt.getGrzh().split(",");
		
		try{
			spx = new SqlParameterExt();
			spx.add(new DoubleValue(pmt.getBpmid()));//1--业务流水id
			spx.add(new StringValue(pmt.getGrzh().trim()));//2--个人账号
			spx.add(new StringValue(pmt.getBlqd().trim()));//3--办理渠道
			spx.add(new IntValue(pmt.getUserid()));//4--用户代码
			spx.add(new ShortValue((short)0));//5--结束标记（等于 1 时为结束)
			spx.add(new StringValue(only), SqlParameterExt.SQL_INPUT_OUTPUT);//6--唯一值（等于''时为第一条记录）
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//7--返回信息
			spx.add(new ShortValue(ret),SqlParameterExt.SQL_INPUT_OUTPUT);//8--返回值 0成功99失败
			
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcdwjcrjstz_jcrjsbgqcdelall]出错" + err.getMessage());
		}
		sql = "p_hfb_jcdw_jcrjsbgqc_delAll(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8)";
		try {
			for(int i=0; i<grzhArr.length; i++) {
				spx.set(2, new StringValue(grzhArr[i]));
				
				bo.setSqlParameterExt(spx);
				bo.executeProcedure(sql);
				
				only = spx.get(6).getString();
				bo.closestmt();
			}
			
			spx.set(5, new ShortValue((short)1));
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(sql);
			msg = spx.get(7).getString();
			ret = spx.get(8).getShort();
			pmt.setOnly(only);
			pmt.setMsg(msg);
			pmt.setRet(String.valueOf(ret));
		} catch (Exception err) {
			throw new CallDbException("执行方法[executeZtbg_Jcdwjcrjstz_jcrjsbgqcdelall]出错" + err.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcdwjcrjstz_jcrjsbgqcdr(Object obj,int pagesize,int pagenum) throws CallDbException {
		SqlParameterExt spx = null;
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String only = "";
		String msg="";
		short ret=99;
		try {
			
			String sql = "insert into tmp_gz_table(sure_id, value1,value4,value6,value7,value8,value9) values(?,?,?,?,?,?,?)";
			String[] grzhArr = pmt.getGrzh().split(",");
		    String[] xingmingArr = pmt.getXingming().split(",");
		    String[] zjhmArr = pmt.getZjhm().split(",");
		    String[] xhArr = pmt.getXh().split(",");
		    String[] jineArr = pmt.getBgyd().split(",");
		    System.out.println("======pmt.getDwjclarr().split========"+pmt.getDwjclarr());
		    String[] dwjclArr  = pmt.getDwjclarr().split(",");

		    System.out.println("======pmt.getGrjcl().split========"+pmt.getGrjcl());
		    String[] grwjclArr = pmt.getGrjcl().split(",");
		    
		    List<SqlParameterExt> l = new ArrayList<SqlParameterExt>();
	        long time=System.currentTimeMillis(); 
	        for (int i = 0; i < grzhArr.length; i++) {
	            SqlParameterExt spx1 = new SqlParameterExt(false); // 类型转化
	            spx1.add(new StringValue(pmt.getYwlsh()));
				spx1.add(new StringValue(grzhArr[i].trim()));
				spx1.add(new StringValue(xingmingArr[i].trim()));
				spx1.add(new StringValue(jineArr[i].trim()));
				spx1.add(new StringValue(dwjclArr[i].trim()));
				spx1.add(new StringValue(grwjclArr[i].trim())); 
				spx1.add(new StringValue(zjhmArr[i].trim()));
	            l.add(spx1);
	        }
	        System.out.println("123==============time0>"+(System.currentTimeMillis()-time));
	        System.out.println("==============>"+l.size());
	        bo.setSqlParameterExtArr(l);
	        System.out.println("123==============time1>"+(System.currentTimeMillis()-time));
	        int[] arrs=  bo.executeInsertBatch(sql);
	        System.out.println("==="+arrs.length);
	        
	        
	        
			String s = "p_hfb_jcdw_jcjsbgqc_dr(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh()));//p1 单位账号
			spx.add(new StringValue(" "));//p2 个人账号
			spx.add(new StringValue(" "));//p3姓名
			spx.add(new StringValue(" "));//证件号码
			spx.add(new DoubleValue(0));//p4月存金额合计/基数
			spx.add(new StringValue(" "));
			spx.add(new IntValue(1));
			spx.add(new IntValue(pmt.getBglb()));//p5变更类别   1-基数  2-缴存额
			spx.add(new StringValue(pmt.getYwlsh()));//p6业务流水号
			spx.add(new StringValue(pmt.getBpmids()));//p7业务流程编号
			spx.add(new StringValue(pmt.getBlqd()));//p8办理渠道
			spx.add(new IntValue(pmt.getUserid()));//p9操作员id
			spx.add(new ShortValue(VL_ONE));//p10结束标记（等于 1 时为结束)
			spx.add(new StringValue(pmt.getYwlsh()), SqlParameterExt.SQL_INPUT_OUTPUT);//p11唯一值（等于''时为第一条记录）
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//p12返回信息
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//p12返回信息

			
			bo.setSqlParameterExt(spx);
			String tableName = "tmp_gjzf_jcdw_jcryjgz_chg";
			String queryStatement = "select grzh,xingming,msg from tmp_gjzf_jcdw_jcryjgz_chg ";
			List<Row> list = bo.queryProcedureToList(s, tableName, queryStatement, pagesize, pagenum);
			msg = spx.get(15).getString();
			pmt.setMsg(msg);
			pmt.setRet(String.valueOf(spx.get(16).getShort()));
			return list;	
		}catch (Exception e) {
			e.printStackTrace();
			pmt.setRet(msg);
			throw new CallDbException("缴存单位的缴存人缴存基数调整清册导入失败！" + e.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcdwjcrjstz_jcrjsbgdypt(Object obj,int size,int page) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String sql="select case when trim(a.spczy) is null then a.fhczy else a.spczy end spczy,a.dwzh,"
				+"c.dwmc,"
				+"case when trim(a.lrczy) is null then a.fhczy else a.lrczy end lrczy,"
				+"c.jbrxm,trunc(a.bgrq) ywrq,a.grzh,"
				+"e.xingming ,"
				+"e.zjhm ,"
				+"c.jbrsjhm,"
				+"a.bglbbm,"
				+"（case when a.bglbbm='01' then '个人缴存基数' when a.bglbbm='02' then '月缴存额' else '缴存比例' end） bglb,"
				+"a.grjcjs,"
				+"a.tzhjcjs,"
				+"(a.gryjce+a.dwyjce+a.bcyjce+a.czybte) yjce,"
				+"(a.tzhgryjce+a.tzhdwyjce) tzhyjce,f.mc jcblbm,g.mc tzhjcblbm from"
				+" gjzf_gr_zzbg_jc  a inner join gjzf_dw_zz b on "
				+" a.dwzh=b.dwzh inner join cr_dw c on "
				+" b.dwbh=c.dwbh inner join gjzf_gr_zz d on "
				+" a.grzh=d.grzh inner join cr_gr      e "
				+" on d.grbh=e.grbh " +
				" left join bm_gz_jcbl f on f.bm=a.jcblbm and f.jgbm like '"+XTool.TransactSQLInjection(pmt.getZxbm())+"%'"+
				" left join bm_gz_jcbl g on g.bm=a.tzhjcblbm and g.jgbm like '"+XTool.TransactSQLInjection(pmt.getZxbm())+"%'"+
//				"where  a.ywlsh='"+XTool.TransactSQLInjection(pmt.getYwlsh())+"' and a.grzh like '"+XTool.TransactSQLInjection(pmt.getGrzh().trim())+"%'";
				"where  a.ywlsh='"+XTool.TransactSQLInjection(pmt.getYwlsh())+"'" ;
				if (!pmt.getGrzh().trim().equals("")) {
					sql = sql +"  and a.grzh like '"+XTool.TransactSQLInjection(pmt.getGrzh().trim())+"%'";
				}
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setHjParameter("grjcjs,yjce,tzhyjce,tzhjcjs");
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrjstz_jcrjsbgdypt]出错"
					+ e.getMessage());
		}
	}
	public List<Row> openZtbg_Jcdwjcrjstz_jcrjsbgspqccx(Object obj,int size,int page) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String bpmid=XTool.TransactSQLInjection((null==pmt.getBpmids() || "".equals(pmt.getBpmids().trim()))?"%":pmt.getBpmids().trim());
		String dwzh=XTool.TransactSQLInjection((null==pmt.getDwzh() || "".equals(pmt.getDwzh().trim()))?"%":pmt.getDwzh().trim());
		String ywlsh=XTool.TransactSQLInjection((null==pmt.getYwlsh() || "".equals(pmt.getYwlsh().trim()))?"%":pmt.getYwlsh().trim());
		String sql=" select a.id ids,a.grzh,b.xingming,b.zjhm,a.grjcjs,a.bgyd,(a.gryjce+a.dwyjce+a.czybte+a.bcyjce) yjce, "+
				" a.gryjce,a.dwyjce,f.mc jcblbm,e.mc tzhjcblbm,a.tzhjcjs,(a.tzhgryjce+a.tzhdwyjce+a.tzhczybte+a.tzhbcyjce) tzhyjce,a.tzhgryjce,a.tzhdwyjce,a.ywlsh,a.bpmid,c.dwzh,d.dwbh,d.dwmc  "+
				" from gjzf_gr_zzbg_jc_qc a  "+
				" inner join gjzf_gr_zz c on a.grzh=c.grzh "+
				" inner join cr_gr b on b.grbh=c.grbh "+
				" inner join gjzf_dw_zz g on g.dwzh=a.dwzh "+
				" inner join cr_dw d on d.dwbh = g.dwbh "+
				" left join bm_gz_jcbl f on f.bm=a.jcblbm and f.jgbm like '"+XTool.TransactSQLInjection(pmt.getZxbm())+"%'"+
				" left join bm_gz_jcbl e on e.bm=a.tzhjcblbm and e.jgbm like '"+pmt.getZxbm()+"%'"+
				" where a.dwzh like '" + dwzh +"' and a.bpmid = '"+bpmid+"' and a.ywlsh like '"+ywlsh+"' and a.spzt in (1,2,3)"/*+
				" union all"+
				" select a.id ids,a.grzh,b.xingming,b.zjhm,a.grjcjs,a.bgyd,(a.gryjce+a.dwyjce+a.czybte+a.bcyjce) yjce, "+
				" a.gryjce,a.dwyjce,f.mc jcblbm,e.mc tzhjcblbm,a.tzhjcjs,(a.tzhgryjce+a.tzhdwyjce+a.tzhczybte+a.tzhbcyjce) tzhyjce,a.tzhgryjce,a.tzhdwyjce,a.ywlsh,a.bpmid,c.dwzh,d.dwbh,d.dwmc  "+
				" from gjzf_gr_zzbg_jc a  "+
				" inner join gjzf_gr_zz c on a.grzh=c.grzh "+
				" inner join cr_gr b on b.grbh=c.grbh "+
				" inner join gjzf_dw_zz g on g.dwzh=a.dwzh "+
				" inner join cr_dw d on d.dwbh = g.dwbh "+
				" left join bm_gz_jcbl f on f.bm=a.jcblbm and f.jgbm like '"+XTool.TransactSQLInjection(pmt.getZxbm())+"%'"+
				" left join bm_gz_jcbl e on e.bm=a.tzhjcblbm and e.jgbm like '"+pmt.getZxbm()+"%'"+
				" where a.dwzh like '" + dwzh +"' and a.bpmid = '"+bpmid+"' and a.ywlsh like '"+ywlsh+"' and a.spzt in (1,2,3)"*/;
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setHjParameter("yjce,tzhyjce");
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrjstz_jcrjsbgspqccx]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 缴存上下限设置查询
	 */
	public List<Row> openZtbg_Jcdwjcrjstz_Jcbzsz_Cx(Object obj,int pagesize,int pagenum) throws CallDbException {
		try {
			Gjzf_Gr_Jcbz pmt = (Gjzf_Gr_Jcbz) obj;
			String jgbm = XTool.TransactSQLInjection(pmt.getJgbm().trim());

			String sql = " select id,jgbm,zxgrjcjs,zdgrjcjs,zxyjce,zdyjce,ksqyny,jssyny from gjzf_gr_jcbz where jgbm = '"+jgbm.trim()+"' ";
			
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,pagesize,pagenum);		
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrjstz_Jcbzsz_Cx]出错" + e.getMessage());
		}
	}
	
	/**
	 * 缴存上下限设置 增加
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeZtbg_Jcdwjcrjstz_Jcbzsz_add(Object obj) throws CallDbException {
		Gjzf_Gr_Jcbz pmt = (Gjzf_Gr_Jcbz) obj;	
		int userid = pmt.getUserid();
		String zxbm = pmt.getZxbm().trim();
		String blqd = pmt.getBlqd().trim();
		SqlParameterExt spx = null;
		try {
			spx = new SqlParameterExt();			
			spx.add(new StringValue(zxbm)); 
			spx.add(new DoubleValue(pmt.getZxgrjcjs())); 
			spx.add(new DoubleValue(pmt.getZdgrjcjs())); 
			spx.add(new DoubleValue(pmt.getZxyjce())); 
			spx.add(new DoubleValue(pmt.getZdyjce())); 
			spx.add(new StringValue(pmt.getKsqyny()));
			spx.add(new StringValue(pmt.getJssyny()));
			spx.add(new StringValue(blqd)); //办理渠道
			spx.add(new IntValue(userid)); // 操作员代码
			spx.add(new StringValue("默认msg"), SqlParameterExt.SQL_INPUT_OUTPUT); // 
			spx.add(new ShortValue((short)99), SqlParameterExt.SQL_INPUT_OUTPUT); //
			
			String s = "p_hfb_jcdw_jcbzsz_add(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10," +
					"?p11)";
			
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(10).getString());
			pmt.setRet(spx.get(11).getShort());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException(e.getMessage());
		}
	}
	
	/**
	 * 缴存上下限设置 删除
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeZtbg_Jcdwjcrjstz_Jcbzsz_del(Object obj) throws CallDbException {
		Gjzf_Gr_Jcbz pmt = (Gjzf_Gr_Jcbz) obj;	
		
		int userid = pmt.getUserid();
		String zxbm =  pmt.getZxbm().trim();
		String id = pmt.getId();
		SqlParameterExt spx = null;
		try {
			spx = new SqlParameterExt();			
			spx.add(new StringValue(zxbm));
			spx.add(new StringValue(id)); 
			spx.add(new IntValue(userid)); // 操作员代码
			spx.add(new StringValue("默认msg"), SqlParameterExt.SQL_INPUT_OUTPUT); // 
			spx.add(new ShortValue((short)99), SqlParameterExt.SQL_INPUT_OUTPUT); //
			
			String s = "p_hfb_jcdw_jcbzsz_del(?p1,?p2,?p3,?p4,?p5)";
			
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(4).getString());
			pmt.setRet(spx.get(5).getShort());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException(e.getMessage());
		}
	}
	
	/**
	 * 缴存上下限设置 修改
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeZtbg_Jcdwjcrjstz_Jcbzsz_chg(Object obj) throws CallDbException {
		Gjzf_Gr_Jcbz pmt = (Gjzf_Gr_Jcbz) obj;	
		int userid = pmt.getUserid();
		String zxbm =  pmt.getZxbm().trim();
		String blqd = pmt.getBlqd().trim();
		String id = pmt.getId();
		SqlParameterExt spx = null;
		try {
			spx = new SqlParameterExt();			
			spx.add(new StringValue(zxbm)); 
			spx.add(new DoubleValue(pmt.getZxgrjcjs())); 
			spx.add(new DoubleValue(pmt.getZdgrjcjs())); 
			spx.add(new DoubleValue(pmt.getZxyjce())); 
			spx.add(new DoubleValue(pmt.getZdyjce())); 
			spx.add(new StringValue(pmt.getKsqyny()));
			spx.add(new StringValue(pmt.getJssyny()));
			spx.add(new StringValue(blqd)); //办理渠道
			spx.add(new StringValue(id)); 
			spx.add(new IntValue(userid)); // 操作员代码
			spx.add(new StringValue("默认msg"), SqlParameterExt.SQL_INPUT_OUTPUT); // 
			spx.add(new ShortValue((short)99), SqlParameterExt.SQL_INPUT_OUTPUT); //
			
			String s = "p_hfb_jcdw_jcbzsz_chg(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10," +
					"?p11,?p12)";
			
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(11).getString());
			System.out.println(spx.get(12)+"----------"+spx.get(12).getShort());
			pmt.setRet(spx.get(12).getShort());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException(e.getMessage());
		}
	}
	/**
	 * 导入结果查询
	 */
	public List<Row> openZtbg_Jcdwjcrjstz_jcrjsbgqcdrJgcx(Object obj,int pagesize,int pagenum) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String  sql="select  * from  gjzf_jcdw_jcryjgz_chg_dr_jgb where  userid="+pmt.getUserid();
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,pagesize,pagenum);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrjstz_jcrjsbgqcdrJgcx]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 导入错误查询
	 */
	public List<Row> openZtbg_Jcdwjcrjstz_jcrjsbgqcdrCwcx(Object obj,int pagesize,int pagenum) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String  sql="select grzh,xingming,zjhm,jine,msg from  tmp_gjzf_jcdw_jcryjgz_chg_dr where  userid="+pmt.getUserid()+"  and sure_id='"+pmt.getYwlsh()+"'";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,pagesize,pagenum);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrjstz_jcrjsbgqcdrCwcx]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 新导入
	 */
	public   List<Row>   openZtbg_Jcdwjcrjstz_jcrjsbgqcdrNew(Object obj,int pagesize,int pagenum) throws CallDbException {
		SqlParameterExt spx = null;
		JcdwhjhdExcelbean pmt=(JcdwhjhdExcelbean)obj;
		String only = "";
		String msg="";
		short ret=99;
		try {
			logger.info("缴存人基数导入插入临时表开始时间--- > " + new Date());
			String sql = "insert into tmp_gz_table(sure_id, value1,value4,value6,value7,value8,value9) values(?,?,?,?,?,?,?)";
		    JstzExcelRead  jstzExcelRead=new JstzExcelRead();
		    jstzExcelRead.setYwlsh(pmt.getYwlsh());
		    logger.info("导入数据Excel的二进制数据大小-----"+pmt.getFiles().length);
		    
		   /**-----------读取Excel 并封装为List<SqlParameterExt>对象---------------*/ 
		    jstzExcelRead.readExcel2007(pmt.getFiles());    
		    List<SqlParameterExt> l = jstzExcelRead.getLst(); 
		    /**-----------------------------------------------------------------------*/    
		    
	        bo.setSqlParameterExtArr(l);
	        int[] arrs=  bo.executeInsertBatch(sql);
	        logger.info("缴存人基数导入插入临时表结束时间--- > " + new Date());
	        logger.info("缴存人基数导入执行存储开始时间--- > " + new Date());
			String s = "p_hfb_jcdw_jcjsbgqc_dr_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh()));//p1 单位账号
			spx.add(new StringValue(" "));//p2 个人账号
			spx.add(new StringValue(" "));//p3姓名
			spx.add(new StringValue(" "));//证件号码
			spx.add(new DoubleValue(0));//p4月存金额合计/基数
			spx.add(new StringValue(" "));
			spx.add(new IntValue(1));
			spx.add(new IntValue(pmt.getBglb()));//p5变更类别   1-基数  2-缴存额
			spx.add(new StringValue(pmt.getYwlsh()));//p6业务流水号
			spx.add(new StringValue(pmt.getBpmids()));//p7业务流程编号
			spx.add(new StringValue(pmt.getBlqd()));//p8办理渠道
			spx.add(new IntValue(pmt.getUserid()));//p9操作员id
			spx.add(new ShortValue(VL_ONE));//p10结束标记（等于 1 时为结束)
			spx.add(new StringValue(pmt.getYwlsh()), SqlParameterExt.SQL_INPUT_OUTPUT);//p11唯一值（等于''时为第一条记录）
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//p12返回信息
			spx.add(new ShortValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//p12返回信息
			bo.setSqlParameterExt(spx);
			String tableName = "tmp_gjzf_jcdw_jcryjgz_chg";
			String queryStatement = "select grzh,xingming,zjhm,jine,msg from tmp_gjzf_jcdw_jcryjgz_chg ";
			List<Row> list = bo.queryProcedureToList(s, tableName, queryStatement, pagesize, pagenum);
			 logger.info("缴存人基数导入执行存储结束时间--- > " + new Date());
			msg = spx.get(15).getString();
			pmt.setMsg(msg);
			pmt.setRet(String.valueOf(spx.get(16).getShort()));
			pmt.setRet1(spx.get(16).getShort());
			return list;	
		}catch (Exception e) {
			e.printStackTrace();
			pmt.setRet("导入异常!!!");
			pmt.setRet1(99);
			throw new CallDbException("缴存单位的缴存人缴存基数调整清册导入失败！" + e.getMessage());
		}
	}
}
//自定义基数调整Excel读取类, 覆写optRow方法, 获取基数调整需要的Excel数据 放进 ===>>  List<SqlParameterExt> 对象
class JstzExcelRead  extends ExcelUtil{  //继承ExcelUtil  覆写optRow(自定义获取Excel数据方法)
	private  String ywlsh; 
	private     List<SqlParameterExt> lst = new ArrayList<SqlParameterExt>(); //获取excel数据同时返回业务存储需要的数据类型
	public String getYwlsh() {
		return ywlsh;
	}
	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}
	public List<SqlParameterExt> getLst() {
		return lst;
	}
	public void setLst(List<SqlParameterExt> lst) {
		this.lst = lst;
	}
	
	/**
	 *  curRow: 代表excel中的行
	 *  rowList:  代表excel中每行的数据集合(A-Z中值的集合)
	 */
	@Override
    public void optRow(int sheetIndex, int curRow, List<String> rowList) { 
         if (curRow>0) {  //不要表头,从第一行数据开始读取(根据自己业务需要,自行判断)
	            SqlParameterExt spx1 = new SqlParameterExt(false);   
	            spx1.add(new StringValue(ywlsh));//业务变更基数  传ywlsh
	            int  readNums=rowList.size();    // 读取的行集合中不包含空数据   (对于空数据处理,证件号码 个人账号和姓名为空,基数为0)
	            if (readNums>1) {
	            	spx1.add(new StringValue(rowList.get(1))); // 含有excel个人账号 
				}else{
					spx1.add(new StringValue(" ")); //否则为空
				}
	            if (readNums>2) {
	            	spx1.add(new StringValue(rowList.get(2)));  // 含有excel  姓名
				}else{
					spx1.add(new StringValue(" ")); //否则为空
				}
	            if (readNums>4) {
	            	spx1.add(new StringValue(rowList.get(4)));  // 含有excel  基数
				}else{
					spx1.add(new StringValue("0")); //默认传0
				}
				spx1.add(new StringValue("0")); //业务变更基数,缴存比例传0
				spx1.add(new StringValue("0")); //业务变更基数,缴存比例传0
	            if (readNums>3) {
	            	spx1.add(new StringValue(rowList.get(3)));  // 含有excel  证件号
				}else{
					spx1.add(new StringValue(" ")); //否则为空
				}
	            lst.add(spx1);
		}    
    }
}	