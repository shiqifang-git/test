package com.shineyue.calldb.business.impl.ztbg;

import java.util.ArrayList;
import java.util.List;

import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.bean.ztbg.Jcdwhjhdbean;
import com.shineyue.bean.ztbg.Jcdwhjhddy;
import com.shineyue.calldb.CallDbException;
import com.shineyue.calldb.SqlParameterExt;
import com.shineyue.calldb.business.AbstractDbInterface;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.sql.value.DoubleValue;
import com.shineyue.calldb.sql.value.IntValue;
import com.shineyue.calldb.sql.value.StringValue;
import com.shineyue.calldb.util.XTool;

public class Ztbg_jcdwjcrbjImpl extends AbstractDbInterface{
	public Ztbg_jcdwjcrbjImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	public List<Row> openZtbg_Jcdwjcrbj_bgxxcs(Object obj) throws CallDbException {
		Jcdwhjbean pmt = (Jcdwhjbean) obj;
		
		String sql = "Select value1 cs from bm_xtcs where " 
				
				+" bm2='0301' and bm1='01' and bm3='03010601' and bm='01'" ;
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrbj_bgxxcs]出错"+ e.getMessage());
		}
	}
	public void executeZtbg_Jcdwjcrbj_jcrbjqcadd(Object obj) throws CallDbException {
		SqlParameterExt spx = null;
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String msg="";
		int ret=0;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwxz()));//单位选择，出钱的单位
			spx.add(new StringValue(pmt.getDwzh()));//1
			spx.add(new StringValue(pmt.getGrzh()));
			spx.add(new StringValue(pmt.getBjyy()));
			spx.add(new StringValue(pmt.getHbjksny()));
			spx.add(new StringValue(pmt.getHbjjsny()));
			spx.add(new DoubleValue(pmt.getDwbjje()));
			spx.add(new DoubleValue(pmt.getGrbjje()));
			spx.add(new DoubleValue(pmt.getHbjje()));//8
			spx.add(new StringValue(pmt.getYwlsh()));
			spx.add(new StringValue(pmt.getBpmids()));
			spx.add(new StringValue(pmt.getBlqd()));
			spx.add(new IntValue(pmt.getUserid()));
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//12
			spx.add(new IntValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//13
		}catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
		String s = "p_hfb_jcdw_jcrbjqc_add(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11,?p12,?p13,?p14,?p15)";
		try {
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(14).getString());
			pmt.setRet(spx.get(15).getString());
		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcdwjcrbj_jcrbjqccx(Object obj,int size,int page) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String dwzh=XTool.TransactSQLInjection(pmt.getDwzh().trim());
		String v_zxbm=XTool.TransactSQLInjection(pmt.getZxbm());
		int spzt = pmt.getSpzt();
		String sql=" select a.id,a.dwzh,a.grzh,c.xingming,c.zjhm,d.mc bjyy,a.dwbjje,a.grbjje, "+
				" a.hbjje bjje,a.hbjksny,a.hbjjsny,a.ywlsh,a.bpmid,a.lrrq,a.lrczy,a.lrczyid,a.jgbm,f.dwmc,f.dwbh,a.yhsjfsbz,a.bjcs  "+
				" from gjzf_gr_bj  a "+
				" inner join gjzf_gr_zz b on a.grzh=b.grzh  "+
				" inner join cr_gr c on b.grbh=c.grbh   "+
				" left join bm_gz_bjyy d on a.bjyybm=d.bm and d.jgbm='"+v_zxbm+"' " +
				" inner join gjzf_dw_zz e on a.dwzh=e.dwzh inner join cr_dw f on e.dwbh=f.dwbh " +
				" where a.dwzh ='" +dwzh +"' and a.spzt='"+spzt+"' and a.dzrq is null and a.bjyybm<>'01' order by lrrq desc ";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setHjParameter("dwbjje,grbjje,bjje");
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrbj_jcrbjqccx]出错"
					+ e.getMessage());
		}
	}
	
	public void executeZtbg_Jcdwjcrbj_jcrbjqcdel(Object obj) throws CallDbException {
		SqlParameterExt spx = null;
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		int end=0;
		String only=" ";
		String msg=" ";
		int ret=0;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh()));//1
			spx.add(new StringValue(" "));//2
			spx.add(new DoubleValue(0));//3
			spx.add(new IntValue(pmt.getUserid()));//4
			spx.add(new IntValue(end));//5
			spx.add(new StringValue(only),SqlParameterExt.SQL_INPUT_OUTPUT);//6
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//7
			spx.add(new IntValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//8
		}catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
		String s = "p_hfb_jcdw_jcrbjqc_del(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8)";
		try {
			String[] grzharr = pmt.getGrzh().split(",");
			String[] idarr = pmt.getIds().split(",");
			for(int i=0;i<grzharr.length;i++){
				spx.set(2, new StringValue(grzharr[i]));
				spx.set(3, new StringValue(idarr[i]));			
				bo.setSqlParameterExt(spx);
				bo.executeProcedure(s);
				if(spx.get(8).getInt() == 0){
					only=spx.get(6).getString();
				}
				bo.closestmt();
			}
			spx.set(5, new IntValue(1));
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(7).getString());
			pmt.setRet(spx.get(8).getString());
		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
	}
	public List<Row> openZtbg_Jcdwjcrbj_jcrbjptdy(Object obj) throws CallDbException {
		Jcdwhjhddy pmt=(Jcdwhjhddy)obj;
		String sql=" select max(trunc(lrrq)) ywrq,max(a.ywlsh) ywlsh,max(a.lrczy)lrczy,max(a.spczy)spczy,max(a.dwzh) dwzh,max(c.dwmc) dwmc,count(a.grzh) fsrs,sum(a.hbjje) fse,case when min(hbjksny)=max(hbjjsny) then min(hbjksny)||'-'||max(hbjjsny) else min(hbjksny)||'-'||max(hbjjsny) end hbjny,max(b.dwjcrs) dwjcrs,max(d.gryjce+d.dwyjce) yjcze,max(c.jbrxm) jbrxm,max(c.jbrsjhm) jbrsjhm " +
				"from gjzf_gr_bj a inner join gjzf_dw_zz b on a.dwzh=b.dwzh inner join cr_dw c on b.dwbh=c.dwbh " +
				"inner join (select dwzh,sum(gryjce) gryjce,sum(dwyjce) dwyjce from gjzf_gr_zz where  grzhzt='01' group by dwzh) d on a.dwzh=d.dwzh where a.ywlsh='" +				
				XTool.TransactSQLInjection(pmt.getYwlsh().trim())+
				"' group by a.ywlsh ";
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrbj_jcrbjptdy]出错"
					+ e.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcdwjcrbj_jcrbjptdy2(Object obj) throws CallDbException {
		Jcdwhjhddy pmt=(Jcdwhjhddy)obj;
		String sql=" select gr.xingming,gr.zjhm,a.hbjje bjje,a.hbjksny||'-'||a.hbjjsny  qzny from gjzf_gr_bj a　left join  gjzf_gr_zz b  on a.grzh=b.grzh " +
				" left join cr_gr gr on gr.grbh=b.grbh " +
				"where a.ywlsh='" +				
				XTool.TransactSQLInjection(pmt.getYwlsh().trim())+
				"'  ";
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrbj_jcrbjptdy2]出错"
					+ e.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcdwjcrbj_jcrbjdr(Object obj) throws CallDbException {
		Jcdwhjhdbean pmt = (Jcdwhjhdbean) obj;
		int end = 0;
		String only = " ";
		String tableName = "tmp_gjzf_gr_bjqc_add_dr";
		String queryStatement = "select grzh,xingming,msg from tmp_gjzf_gr_bjqc_add_dr";
		SqlParameterExt spx = null;
		String msg="初始msg";
		try {
			
			String sql = "insert into tmp_gz_table(sure_id, value1,value2,value3,value4,value5,value6,value7,value8) values(?,?,?,?,?,?,?,?,?)";
			String[] grzhArr = pmt.getGrzh().split(",");
			String[] xingmingArr = pmt.getXingming().split(",");
			String[] zjhmArr = pmt.getZjhm().split(",");
			String[] bjyyarr = pmt.getBjyy().split(",");
			String[] qznyArr = pmt.getQzny().split(",");
			String[] grbjeArr = pmt.getGrbjjes().split(",");
			String[] dwbjeArr = pmt.getDwbjjes().split(",");
			String[] HbjjesArr = pmt.getHbjjes().split(",");
			
			List<SqlParameterExt> l = new ArrayList<SqlParameterExt>();
			
			long time=System.currentTimeMillis(); 
	        for (int i = 0; i < xingmingArr.length; i++) {
	            SqlParameterExt spx1 = new SqlParameterExt(false); // 类型转化
	            	  spx1.add(new StringValue(pmt.getYwlsh()));
					  spx1.add(new StringValue(grzhArr[i]));
					  spx1.add(new StringValue(xingmingArr[i]));
					  spx1.add(new DoubleValue(0));
					  spx1.add(new DoubleValue(0));
					  spx1.add(new DoubleValue(Double.parseDouble(HbjjesArr[i])));
					  spx1.add(new StringValue(qznyArr[i]));
					  spx1.add(new StringValue(bjyyarr[i]));
					  spx1.add(new StringValue(zjhmArr[i]));

	            l.add(spx1);
	        }
	        System.out.println("123==============time0>"+(System.currentTimeMillis()-time));
	        System.out.println("==============>"+l.size());
	        bo.setSqlParameterExtArr(l);
	        System.out.println("123==============time1>"+(System.currentTimeMillis()-time));
	        int[] arrs=  bo.executeInsertBatch(sql);
	        System.out.println("==="+arrs.length);
			
			

			spx = new SqlParameterExt(); // 
			spx.add(new StringValue(pmt.getDwxz()));//1
			spx.add(new StringValue(pmt.getDwzh()));//2
			spx.add(new StringValue(" "));//3 
			spx.add(new StringValue(" "));//4
			spx.add(new StringValue(" "));//5
			spx.add(new StringValue(" "));
			spx.add(new StringValue(" "));//6
			spx.add(new DoubleValue(0));//7
			spx.add(new DoubleValue(0));//8	
			spx.add(new DoubleValue(0));//9
			spx.add(new StringValue(pmt.getYwlsh()));//10
			spx.add(new StringValue(pmt.getBpmids()));//11
			spx.add(new StringValue(pmt.getBlqd()));//12办理渠道
			spx.add(new IntValue(pmt.getUserid()));//13 操作员ID
			spx.add(new IntValue(1)); // 结束标记（等于 1 时为结束)//14
			spx.add(new StringValue(pmt.getYwlsh()), SqlParameterExt.SQL_INPUT_OUTPUT); //15 唯一值（等于''时为第一条记录）
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT); // 16
			spx.add(new IntValue(0), SqlParameterExt.SQL_INPUT_OUTPUT);//17
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法数据库出错" + e.getMessage());
		}
		
		String sql = "p_hfb_jcdw_jcrbjqc_dr(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11,?p12,?p13,?p14,?p15,?p16,?p17,?p18)";
		
			try {
				bo.setSqlParameterExt(spx);
				//bo.executeProcedure(sql);
				List<Row> list = bo.queryProcedureToList(sql, tableName, queryStatement, 0, 0);
				// 获取返回值
				pmt.setMsg(spx.get(17).getString());
				pmt.setRet(spx.get(18).getString());
				return list;

			} catch (Exception err) {
				err.printStackTrace();
				throw new CallDbException(err.getMessage());
			}
	}
	
	public void executeZtbg_Jcdwjcrbj_jcrbjdelall(Object obj) throws CallDbException {
		SqlParameterExt spx = null;
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String msg="";
		int ret=0;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getBpmids()));
			spx.add(new IntValue(pmt.getUserid()));
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//12
			spx.add(new IntValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//13			
			
		}catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
		String s = "p_hfb_jcdw_jcrbjqc_del_all(?p1,?p2,?p3,?p4)";
		try {
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(3).getString());
			pmt.setRet(spx.get(4).getString());
		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcdwjcrbj_jcrbjqcplcx(Object obj,int size,int page) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String dwzh=XTool.TransactSQLInjection(pmt.getDwzh().trim());
		String sql=" select a.id,a.grzh,c.xingming,c.zjhm,a.gryjce,a.dwyjce,(a.gryjce+a.dwyjce) yjce from gjzf_gr_zz a " +
				   " inner join cr_gr c on a.grbh=c.grbh" +
				   " where  a.dwzh='"+dwzh+"' and  " +
				   " a.grzh  not in (select grzh from gjzf_gr_bj where trim(dzrq) is null and dwzh='"+dwzh+"' and bjyybm<>'01') " +
				   	"and a.grzhzt in ('01','02') and a.grzh not in (select grzh from  gjzf_gr_tq where trim(tqrq) is null  and dwzh='"+dwzh+"' " +
				   			"and (tqyybm<>'0301' or substr(tqyybm,0,2)<>'02')) order by grzh";

		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setHjParameter("dwyjce,gryjce,yjce");
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrbj_jcrbjqcplcx]出错"
					+ e.getMessage());
		}
	}
	
	public void executeZtbg_Jcdwjcrbj_jcrbjplcp(Object obj) throws CallDbException {
		SqlParameterExt spx = null;
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String msg="";
		int ret=0;
		String only="";
		int end=0;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwxz()));//1
			spx.add(new StringValue(pmt.getDwzh()));//1
			spx.add(new StringValue(""));
			spx.add(new IntValue(pmt.getJsbs()));
			spx.add(new StringValue(pmt.getJsgs()));
			spx.add(new StringValue(pmt.getBjyy()));
			spx.add(new StringValue(pmt.getHbjksny()));
			spx.add(new StringValue(pmt.getHbjjsny()));//7
			
			spx.add(new DoubleValue(pmt.getHbjje()));
			spx.add(new DoubleValue(pmt.getGrbjje()));
			spx.add(new DoubleValue(pmt.getDwbjje()));
			spx.add(new StringValue(pmt.getYwlsh()));
			spx.add(new StringValue(pmt.getBpmids()));
			spx.add(new StringValue(pmt.getBlqd()));//9
			spx.add(new IntValue(pmt.getUserid()));
			spx.add(new IntValue(end));
			spx.add(new StringValue(only),SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);
			spx.add(new IntValue(ret),SqlParameterExt.SQL_INPUT_OUTPUT);//14
			
		}catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
		String s = "p_hfb_jcdw_jcrbjqc_pl_add(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			String[] grzharr = pmt.getGrzh().split(",");
			for(int i=0;i<grzharr.length;i++){
				spx.set(3, new StringValue(grzharr[i]));
				bo.setSqlParameterExt(spx);
				bo.executeProcedure(s);
				if(spx.get(19).getInt()==0){
					only=spx.get(17).getString();
				}
				bo.closestmt();
			}
			spx.set(16, new IntValue(1));
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(18).getString());
			pmt.setRet(spx.get(19).getString());
		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
	}
	
	public List<Row> openZtbg_Jcdwjcrbj_jcrbjspqccx(Object obj,int size,int page) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String v_zxbm=XTool.TransactSQLInjection(pmt.getZxbm());
		String v_bpmid=XTool.TransactSQLInjection(pmt.getBpmids());
		String sql=" select a.id,a.dwzh,a.cqdwzh,dw1.dwmc cqdwmc,a.grzh,c.xingming,c.zjhm,d.mc bjyy," +
				"a.dwbjje,a.grbjje,a.hbjje bjje,a.hbjksny,a.hbjjsny,a.ywlsh,a.bpmid,a.lrrq," +
				"a.lrczyid,a.jgbm,f.dwmc,f.dwbh " +
				"from gjzf_gr_bj  a  inner join gjzf_gr_zz b on a.grzh=b.grzh " +
				"inner join gjzf_dw_zz dwzz1 on dwzz1.dwzh=a.cqdwzh " +
				"inner join cr_dw dw1 on dw1.dwbh=dwzz1.dwbh " +
				"inner join cr_gr c on b.grbh=c.grbh " +
				"left join bm_gz_bjyy d on a.bjyybm=d.bm and d.jgbm='"+v_zxbm+"' " +
				"inner join gjzf_dw_zz e on a.dwzh=e.dwzh inner join cr_dw f on e.dwbh=f.dwbh " +
				" where a.bpmid='" +v_bpmid+"'";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setHjParameter("dwbjje,grbjje,bjje");
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,size,page);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrbj_jcrbjspqccx]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 缴存人补缴清册保存
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeZtbg_Jcdwjcrbj_jcrbjqc_Rz(Object obj) throws CallDbException {
		SqlParameterExt spx = null;
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String msg="";
		int ret=0;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(pmt.getDwzh()));//1
			spx.add(new StringValue(pmt.getDwxz()));//2
			spx.add(new StringValue(pmt.getYwlsh()));//3
			spx.add(new StringValue(pmt.getBlqd()));//4
			spx.add(new IntValue(pmt.getUserid()));//5
			spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT);//6
			spx.add(new IntValue(ret), SqlParameterExt.SQL_INPUT_OUTPUT);//7
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException(e.getMessage());
		}
		String s = "p_hfb_jcdw_jcrbjqc_rz(?,?,?,?,?,?,?)";
		try {
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			pmt.setMsg(spx.get(6).getString());
			pmt.setRet(spx.get(7).getString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CallDbException(e.getMessage());
		}
	}
	
	/**
	 * 获取单位付款账户
	 * @param obj
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openZtbg_Jcdwjcrbj_Dwfkzh_Cx(Object obj) throws CallDbException {
		Jcdwhjhdbean pmt=(Jcdwhjhdbean)obj;
		String sql=" select a.dwbh,c.yhhh,c.yhzhhm,c.yhzhmc,c.sszh from gjzf_dw_zz a "+
					"inner join cr_dw b on a.dwbh =b.dwbh "+
					"left join im_zhsz_dw c on b.dwbh  =c.khbh where dwzh ='"+XTool.TransactSQLInjection(pmt.getDwzh().trim())+"' ";
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);
			
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrbj_Dwfkzh_Cx]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 缴存单位汇（补）缴分配查询网厅
	 * @param obj
	 * @return
	 * @throws CallDbException
	 */
	public List<Row> openZtbg_Jcdwjcrbj_hjfp_Cx_Wt(Object obj) throws CallDbException {
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
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrbj_hjfp_Cx_Wt]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 缴存人账户核定明细查询
	 * 
	 * @param bmbean
	 * @return
	 */
	public List<Row> openZtbg_Jcdwjcrbj_Jcrzhmx_Hdcx(Object obj, int pagesize,
			int pagenum) throws CallDbException {
		try {
			Jcdwhjhdbean pmt = (Jcdwhjhdbean) obj;
			String v_dwzh = XTool.TransactSQLInjection(pmt.getDwzh().trim());
			String v_jcyd = XTool.TransactSQLInjection(pmt.getJcyd().trim());
			String sql = "select a.grzh,c.xingming,c.zjhm,a.grjcjs,a.gryjce,a.dwyjce,a.gryjce+a.dwyjce yjce  "
					+ " from gjzf_gr_jchd a left join gjzf_gr_zz b on a.grzh=b.grzh "
					+ " left join cr_gr c on b.grbh=c.grbh "
					+ " where a.dwzh='"
					+ v_dwzh
					+ "' and a.bgyd='"
					+ v_jcyd
					+ "' and a.grzhzt='01' order by a.grzh";
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql, pagesize, pagenum); // 如果没有分页，直接去掉这两个参数；
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZtbg_Jcdwjcrbj_Jcrzhmx_Hdcx]出错"
					+ e.getMessage());
		}
	}
	
	/**
	 * 汇缴核定删除
	 * swhao
	 */
	public void executeZtbg_Jcdwjcrbj_Jcdwywls_Sc(Object obj) throws CallDbException {
		Jcdwhjhdbean in = (Jcdwhjhdbean) obj;
		SqlParameterExt spx = null;
		try {
			spx = new SqlParameterExt();
			spx.add(new StringValue(in.getDwzh().trim()));//单位账号varchar输入
			spx.add(new StringValue(in.getHbjny().trim()));//业务流水号varchar输入
			spx.add(new IntValue(in.getUserid()));//用户操作员idint输入
			spx.add(new StringValue(in.getMsg().trim()),SqlParameterExt.SQL_INPUT_OUTPUT);//返回信息varchar输入输出
			spx.add(new IntValue(99),SqlParameterExt.SQL_INPUT_OUTPUT);//返回值int输入输出0 成功 99 失败
			
			String s = "p_hfb_jcdw_hjhd_jcrd_del(?p1,?p2,?p3,?p4,?p5)";
			bo.setSqlParameterExt(spx);
			bo.executeProcedure(s);
			in.setMsg(spx.get(4).getString());
			in.setRet(spx.get(5).getString());
		} catch (Exception e) {
			throw new CallDbException(e.getMessage());
		}
	}
}
