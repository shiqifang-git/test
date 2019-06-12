package com.shineyue.calldb.business.impl.ztbg;

import java.util.ArrayList;
import java.util.List;

import com.shineyue.bean.ztbg.Gjzf_gr_zz;
import com.shineyue.bean.ztbg.Jcdwhjbean;
import com.shineyue.bean.ztbg.Cr_dwBean;
import com.shineyue.bean.ztbg.Jcdwhjhdbean;
import com.shineyue.bean.ztbg.Jcdwhjhddy;
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

public class Ztbg_jcdwjcrxxplbgImpl extends AbstractDbInterface{public Ztbg_jcdwjcrxxplbgImpl() {
	super();
}
public String toString() {
	return getClass().getName();
}

/**
 * 缴存人信息批量变更
 * @param obj
 * @param size
 * @param page
 * @return
 * @throws CallDbException
 */
public List<Row> openZtbg_jcdwjcrxxplbg_qccx(Object obj,int size,int page) throws CallDbException {
	Cr_dwBean pmt=(Cr_dwBean)obj;
	String cxlx=pmt.getCxlx();
	System.out.println("----------------------------cxlx:"+cxlx);
	String sql = "";
	if("01".equals(cxlx)){//01是查询申请页面清册，02是审批和退回页面清册
		String dwzh=XTool.TransactSQLInjection(pmt.getDwzh().trim());
		String grzh=XTool.TransactSQLInjection(pmt.getGrzh().trim());
		
		sql=" select jg.mc jgmc,u.dwzh ,t.dwmc,lx.mc zjlx,a.id,a.bpmid,c.grzh,c.grbh,b.xingming,b.zjhm,a.bgxm,a.ywlsh,t.dwbh, "+
				" a.bgdjczy lrczy,a.bgdjrq bgrq,a.bgxm bgsx,  case a.bgxmdm when 'zjlx' then d.mc else  case a.bgxmdm when 'xingbie' "+
				" then e.mc else  case a.bgxmdm when 'grlbbm' then f.mc else  case a.bgxmdm when 'zhiwu' then g.mc else  case a.bgxmdm "+
				" when 'zhiye' then h.mc else  case a.bgxmdm when 'zhichen' then i.mc else  case a.bgxmdm when 'xueli' then j.mc else  "+
				" case a.bgxmdm when 'hyzk' then k.mc else case a.bgxmdm when 'szbm' then bm1.mc else  a.bgqxx end end end end end end end end end bgqxx,"+
				" case a.bgxmdm when 'zjlx' then l.mc else  case a.bgxmdm when 'xingbie' then m.mc else case a.bgxmdm when 'grlbbm' then n.mc else  "+
				" case a.bgxmdm when 'zhiwu' then o.mc else case a.bgxmdm when 'zhiye' then p.mc else  case a.bgxmdm when 'zhichen' then q.mc else "+
				" case a.bgxmdm when 'xueli' then r.mc else  case a.bgxmdm when 'hyzk' then s.mc else case a.bgxmdm when 'szbm' then bm2.mc else  "+
				" a.bghxx end end end end end end end end end bghxx,'98' ywmxlx from cr_jbxx_bg a  "+
				" inner join cr_gr b on a.crbh=b.grbh  inner join gjzf_gr_zz c on c.grbh=b.grbh and a.crzh = c.grzh   inner join gjzf_dw_zz u on u.dwzh=c.dwzh "+
				" inner join cr_dw t on t.dwbh=u.dwbh  left join bm_grzjlx d on d.bm=a.bgqxx  left join bm_xb e on e.bm=a.bgqxx  "+
				" left join bm_grlb f on f.bm=a.bgqxx  left join bm_zgzw g on g.bm=a.bgqxx and g.jgbm='01' "+
				" left join bm_zgzy h on h.bm=a.bgqxx and h.jgbm='01'  left join bm_zgzc i on i.bm=a.bgqxx and i.jgbm='01' "+
				" left join bm_zgxl j on j.bm=a.bgqxx and j.jgbm='01'  left join bm_hyzk k on k.bm=a.bgqxx "+
				" left join bm_zjlx l on l.bm=a.bghxx  left join bm_xb m on m.bm=a.bghxx   left join bm_grlb n on n.bm=a.bghxx  "+
				" left join bm_zgzw o on o.bm=a.bghxx and o.jgbm='01'  left join bm_zgzy p on p.bm=a.bghxx and p.jgbm='01'  left join bm_zgzc q on q.bm=a.bghxx and q.jgbm='01' "+
				" left join bm_zgxl r on r.bm=a.bghxx and r.jgbm='01'  left join bm_hyzk s on s.bm=a.bghxx   left join bm_khjg jg on jg.bm = a.jgbm  "+
				" left join bm_grzjlx lx on lx.bm = b.zjlx   left join bm_gz_ssbm bm1 on bm1.bm= a.bgqxx and bm1.dwzh=u.dwzh  "+
				" left join bm_gz_ssbm bm2 on bm2.bm= a.bghxx and bm2.dwzh=u.dwzh   "+
				" where a.spzt=0 and a.jgbm like '01%'  and a.dwzh = '"+dwzh+"' ";
		
				if(!"".equals(grzh)){
					sql += " and a.crzh= '"+grzh+"'";
				}
					sql += " order by c.dwzh,c.grzh ";
	}else if("02".equals(cxlx)){
		String bpmid=XTool.TransactSQLInjection(pmt.getBpmid1().trim());
		sql = " select jg.mc jgmc,u.dwzh ,t.dwmc,lx.mc zjlx,a.id,a.bpmid,c.grzh,c.grbh,b.xingming,b.zjhm,a.bgxm,a.ywlsh,t.dwbh, "+
				" a.bgdjczy lrczy,a.bgdjrq bgrq,a.bgxm bgsx,  case a.bgxmdm when 'zjlx' then d.mc else  case a.bgxmdm when 'xingbie' "+
				" then e.mc else  case a.bgxmdm when 'grlbbm' then f.mc else  case a.bgxmdm when 'zhiwu' then g.mc else  case a.bgxmdm "+
				" when 'zhiye' then h.mc else  case a.bgxmdm when 'zhichen' then i.mc else  case a.bgxmdm when 'xueli' then j.mc else  "+
				" case a.bgxmdm when 'hyzk' then k.mc else case a.bgxmdm when 'szbm' then bm1.mc else  a.bgqxx end end end end end end end end end bgqxx,"+
				" case a.bgxmdm when 'zjlx' then l.mc else  case a.bgxmdm when 'xingbie' then m.mc else case a.bgxmdm when 'grlbbm' then n.mc else  "+
				" case a.bgxmdm when 'zhiwu' then o.mc else case a.bgxmdm when 'zhiye' then p.mc else  case a.bgxmdm when 'zhichen' then q.mc else "+
				" case a.bgxmdm when 'xueli' then r.mc else  case a.bgxmdm when 'hyzk' then s.mc else case a.bgxmdm when 'szbm' then bm2.mc else  "+
				" a.bghxx end end end end end end end end end bghxx,'98' ywmxlx from cr_jbxx_bg a  inner join cr_gr b on a.crbh=b.grbh "+
				" inner join gjzf_gr_zz c on c.grbh=b.grbh and a.crzh = c.grzh inner join gjzf_dw_zz u on u.dwzh=c.dwzh "+
				" inner join cr_dw t on t.dwbh=u.dwbh left join bm_grzjlx d on d.bm=a.bgqxx left join bm_xb e on e.bm=a.bgqxx  "+
				" left join bm_grlb f on f.bm=a.bgqxx left join bm_zgzw g on g.bm=a.bgqxx and g.jgbm='01' left join bm_zgzy h on h.bm=a.bgqxx and h.jgbm='01' "+
				" left join bm_zgzc i on i.bm=a.bgqxx and i.jgbm='01' left join bm_zgxl j on j.bm=a.bgqxx and j.jgbm='01' left join bm_hyzk k on k.bm=a.bgqxx "+
				" left join bm_zjlx l on l.bm=a.bghxx left join bm_xb m on m.bm=a.bghxx left join bm_grlb n on n.bm=a.bghxx  "+
				" left join bm_zgzw o on o.bm=a.bghxx and o.jgbm='01' left join bm_zgzy p on p.bm=a.bghxx and p.jgbm='01' left join bm_zgzc q on q.bm=a.bghxx and q.jgbm='01' "+
				" left join bm_zgxl r on r.bm=a.bghxx and r.jgbm='01' left join bm_hyzk s on s.bm=a.bghxx left join bm_khjg jg on jg.bm = a.jgbm  "+
				" left join bm_grzjlx lx on lx.bm = b.zjlx  left join bm_gz_ssbm bm1 on bm1.bm= a.bgqxx and bm1.dwzh=u.dwzh  "+
				" left join bm_gz_ssbm bm2 on bm2.bm= a.bghxx and bm2.dwzh=u.dwzh  "+
				" where a.bpmid='"+bpmid+"'";
	}
	try {
		SqlParameterExt spx = new SqlParameterExt();
		bo.setSqlParameterExt(spx);
		return bo.queryToList(sql,size,page);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new CallDbException("执行方法[openZtbg_jcdwjcrxxplbg_qccx]出错"
				+ e.getMessage());
	}
}

public List<Row> openZtbg_jcdwjcrxxplbg_dr(Object obj) throws CallDbException {
	Gjzf_gr_zz pmt = (Gjzf_gr_zz) obj;
	int end = 0;
	String only = " ";
	String tableName = "tmp_hfb_jcdw_jcrxxbg_dr";
	String queryStatement = "select grzh,xingming,msg from tmp_hfb_jcdw_jcrxxbg_dr";
	SqlParameterExt spx = null;
	String msg="初始msg";
	try {
		System.out.println("----------------------进入方法-------");
		String sql = "insert into tmp_gz_table(sure_id, value1,value2,value3,value4,value5,value6,value7,value8,value9,value10,value11) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String[] grzhArr = pmt.getGrzh().split(",");
		String[] xingmingArr = pmt.getXingming().split(",");
		String[] zjhmArr = pmt.getZjhm().split(",");
		String[] hyzkArr = pmt.getHyzk().split(",");
		String[] sjhmArr = pmt.getSjhm().split(",");
		String[] jtysrArr = pmt.getJtysr1().split(",");
		String[] zhwArr = pmt.getZhw().split(",");
		String[] zhyArr = pmt.getZhy().split(",");
		String[] zhcArr = pmt.getZhc().split(",");
		String[] xulArr = pmt.getXul().split(",");
		String[] jtzzArr = pmt.getJtzz().split(",");
		
		List<SqlParameterExt> l = new ArrayList<SqlParameterExt>();
		
        for (int i = 0; i < xingmingArr.length; i++) {
            SqlParameterExt spx1 = new SqlParameterExt(false); // 类型转化
            	  spx1.add(new StringValue(pmt.getYwlsh()));
				  spx1.add(new StringValue(grzhArr[i]));
				  spx1.add(new StringValue(xingmingArr[i]));
				  spx1.add(new StringValue(zjhmArr[i]));
				  spx1.add(new StringValue(hyzkArr[i]));
				  spx1.add(new StringValue(sjhmArr[i]));
				  spx1.add(new StringValue(jtysrArr[i]));
				  spx1.add(new StringValue(zhwArr[i]));
				  spx1.add(new StringValue(zhyArr[i]));
				  spx1.add(new StringValue(zhcArr[i]));
				  spx1.add(new StringValue(xulArr[i]));
				  spx1.add(new StringValue(jtzzArr[i]));
				  
            l.add(spx1);
        }
       
        bo.setSqlParameterExtArr(l);
        int[] arrs=  bo.executeInsertBatch(sql);
        System.out.println("==="+arrs.length);
        
		spx = new SqlParameterExt(); 
		spx.add(new StringValue(pmt.getDwzh()));//1单位账号
		spx.add(new StringValue(" "));//2个人账号
		spx.add(new StringValue(" "));//3 姓名
		spx.add(new StringValue(" "));//4证件号码
		spx.add(new StringValue(" "));//5婚姻状况
		spx.add(new StringValue(" "));//6 手机号码
		spx.add(new StringValue(" "));//7 家庭月收入
		spx.add(new StringValue(" "));//8 职务
		spx.add(new StringValue(" "));//9 职业
		spx.add(new StringValue(" "));//10 职称
		spx.add(new StringValue(" "));//11 学历
		spx.add(new StringValue(" "));//12 家庭住址
		spx.add(new StringValue(pmt.getYwlsh()));//13
		spx.add(new LongValue(pmt.getBpmid()));//14
		spx.add(new StringValue(pmt.getBlqd()));//15
		spx.add(new IntValue(pmt.getUserid()));//16 操作员ID
		spx.add(new IntValue(1)); //17 结束标记（等于 1 时为结束)
		spx.add(new StringValue(pmt.getYwlsh()), SqlParameterExt.SQL_OUTPUT); // 18
		spx.add(new StringValue(msg), SqlParameterExt.SQL_INPUT_OUTPUT); // 19
		spx.add(new IntValue(0), SqlParameterExt.SQL_INPUT_OUTPUT);//20
	
	} catch (Exception e) {
		e.printStackTrace();
		throw new CallDbException("执行方法数据库出错" + e.getMessage());
	}
	String sql = "p_hfb_jcdw_jcrxxbg_dr(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11,?p12,?p13,?p14,?p15,?p16,?p17,?p18,?p19,?p20)";
	
		try {
			bo.setSqlParameterExt(spx);
			List<Row> list = bo.queryProcedureToList(sql, tableName, queryStatement, 0, 0);
			// 获取返回值
			pmt.setMsg(spx.get(19).getString());
			pmt.setRet1(spx.get(20).getString());
			return list;

		} catch (Exception err) {
			err.printStackTrace();
			throw new CallDbException(err.getMessage());
		}
	}

/**
 *缴存人信息批量变更清册删除
 * @param obj
 * @throws CallDbException
 */
public void executeZtbg_jcdwjcrxxplbg_sc(Object obj) throws CallDbException {
	Gjzf_gr_zz pmt = (Gjzf_gr_zz) obj;
	SqlParameterExt spx = null;
	String s = "";
    String mret = "";
    int ret = 0;
    s = "p_hfb_jcdw_jcrxxbg_del(?,?,?,?,?,?)";
	try {
		spx = new SqlParameterExt();
		spx.add(new LongValue(pmt.getId1()));
		spx.add(new IntValue(Integer.parseInt(pmt.getSfqb())));
		spx.add(new StringValue(pmt.getBlqd()));
		spx.add(new IntValue(pmt.getUserid()));	
		spx.add(new StringValue(mret), SqlParameterExt.SQL_OUTPUT);	
		spx.add(new IntValue(ret), SqlParameterExt.SQL_OUTPUT);	
		
		bo.setSqlParameterExt(spx);
		bo.executeProcedure(s);
		
		mret = spx.get(5).getString();
		ret = spx.get(6).getInt();
		pmt.setMsg(mret);
		pmt.setRet(ret);
		
	} catch (Exception err) {
		throw new CallDbException("执行方法[executeZtbg_jcdwjcrxxplbg_sc]出错" + err.getMessage());
	}
}
}
