package com.shineyue.calldb.business.impl.ztbg;

import java.util.List;

import com.shineyue.bean.ztbg.Im_Gryhzh;
import com.shineyue.bean.ztbg.Jcdw_DwxxbgBean;
import com.shineyue.bean.ztbg.Jcdw_jcrtsqyBean;
import com.shineyue.bean.ztbg.ZtbgHjhdBean;
import com.shineyue.calldb.CallDbException;
import com.shineyue.calldb.SqlParameterExt;
import com.shineyue.calldb.business.AbstractDbInterface;
import com.shineyue.calldb.sql.Row;
import com.shineyue.calldb.sql.value.IntValue;
import com.shineyue.calldb.sql.value.ShortValue;
import com.shineyue.calldb.sql.value.StringValue;
import com.shineyue.calldb.util.XTool;

public class Ztbg_HjhdImpl extends AbstractDbInterface{
	public Ztbg_HjhdImpl() {
		super();
	}
	public String toString() {
		return getClass().getName();
	}
	
	/**
	 * 缴存单位汇缴核定信息查询
	 */
	public List<Row> openZTBG_Hjhd_Jcrd_Cx(Object obj, int pagesize,int pagenum) throws CallDbException {

		ZtbgHjhdBean pmt = (ZtbgHjhdBean) obj;
		
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
			throw new CallDbException("执行方法[openjcdw_Hjhd_Jcrd_Cx]出错"+ e.getMessage());
		}

	}
	/*缴款银行账号信息查询*/
	public List<Row> openZTBG_Hjhd_Wtjkyhzhxxcx(Object obj) throws CallDbException {
		try {
			Im_Gryhzh pmt = (Im_Gryhzh) obj;
			
			//String blqd	= pmt.getBlqd().trim();	
			//int userid = pmt.getUserid();
			String sql = "";
			if("03".equals(XTool.TransactSQLInjection(pmt.getCxlx().trim()))){
				String yhzh = XTool.TransactSQLInjection(pmt.getYhzh().trim());
				sql= " select a.yhzhhm,a.yhzhmc,a.yhhh,a.yhmc"+
						" from im_zhsz_dw a left join gjzf_dw_zz b on a.khbh = b.dwbh  "+
						" where a.yhzhhm = '"+yhzh+"' order by a.id desc ";
			}else{
				String dwzh = XTool.TransactSQLInjection(pmt.getDwzh().trim());		
				sql= " select a.yhzhhm,a.yhzhmc,a.yhhh,a.yhmc from im_zhsz_dw a "+
						" left join gjzf_dw_zz b on a.khbh = b.dwbh "+
						" where b.dwzh = '"+dwzh+"' order by a.id desc ";
			}
			
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql);		
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZTBG_Hjhd_Jkyhzhxxcx]出错" + e.getMessage());
		}
	}
	
	/**
	 *缴存单位托收 检验是否交款
	 * @param obj
	 * @throws CallDbException
	 */
	public void executeZTBG_Hjhd_Wtsfjkcx(Object obj) throws CallDbException {
		Jcdw_jcrtsqyBean pmt = (Jcdw_jcrtsqyBean) obj;
		SqlParameterExt spx = null;
		String ywlsh = "";
		String yhbm = "";
		String s = "p_hfb_jcdw_dwtsqc_add_auto_wt(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9,?p10,?p11,?p12,?p13,?p14)";
		try {
			String msg = "";
			short ret = 0;
			String dwzh = pmt.getDwzh().trim();
			String blqd = pmt.getBlqd().trim();
			String userid = pmt.getUserid()+"";
			String bpmid = pmt.getBpmid();
			String ksyd = pmt.getKsyd();
			String jsyd = pmt.getJsyd();
			String yhzhhm = pmt.getYhzhhm();
			String yhmc = pmt.getYhmc();
			String yhzhmc = pmt.getYhzhmc();
			String yhhh = pmt.getYhhh();
			
			spx = new SqlParameterExt();
			spx.add(new StringValue(dwzh));
			spx.add(new StringValue(ksyd));
			spx.add(new StringValue(jsyd));
			spx.add(new StringValue(userid)); 
			spx.add(new StringValue(bpmid));
			spx.add(new StringValue(blqd));
			spx.add(new StringValue(yhmc));
			spx.add(new StringValue(yhzhmc));
			spx.add(new StringValue(yhzhhm));
			spx.add(new StringValue(yhhh));
			spx.add(new StringValue(ywlsh), SqlParameterExt.SQL_OUTPUT);
			spx.add(new StringValue(yhbm), SqlParameterExt.SQL_OUTPUT);
  			spx.add(new StringValue(msg), SqlParameterExt.SQL_OUTPUT);
  			spx.add(new ShortValue(ret), SqlParameterExt.SQL_OUTPUT);
  			bo.setSqlParameterExt(spx);
  			bo.executeProcedure(s);
  			if (spx.get(14).getShort() == 0) {
				ywlsh = spx.get(11).getString();
				yhbm = spx.get(12).getString();
				msg = spx.get(13).getString();
				pmt.setRet("0");
				pmt.setYwlsh(ywlsh);
				pmt.setYhbm(yhbm);
				pmt.setMsg(msg);
			} else {
				pmt.setRet("99");
				msg = spx.get(13).getString();
				pmt.setMsg(msg);
			}
			bo.closestmt();
			
		} catch (Exception e) {
			e.printStackTrace();
			pmt.setMsg("缴存单位托收 检验是否交款失败！");
			pmt.setRet("99");
			throw new CallDbException("缴存单位托收 检验是否交款失败！" + e.getMessage());
		}

	}
	
	public List<Row>  openZTBG_Hjhd_Wtjkspxxcx(Object obj,int pagesize,
			int pagenum) throws CallDbException {
		Jcdw_DwxxbgBean pmt = (Jcdw_DwxxbgBean) obj;
		String v_bpmid = XTool.TransactSQLInjection(pmt.getBpmid());
		
		/*String sql =" select a.id,a.bpmid,a.ywlsh ,substr(f_hfsc_ywjdzt_im_tx(a.id,a.ywlsh),instr(f_hfsc_ywjdzt_im_tx(a.id,a.ywlsh),'||',-1)+2) sbyy," 
				+" substr(f_hfsc_ywjdzt_im_tx(a.id,a.ywlsh),0,1) fszt,a.dwzh,c.dwmc dwmc,a.jcyd,d.yhbm,a.hdrq lrrq " 
				+" from gjzf_dw_dwtsxx a inner join gjzf_dw_zz b on a.dwzh=b.dwzh " 
				+" inner join cr_dw c on b.dwbh=c.dwbh " 
				+" inner join gjzf_dw_wtxy d on a.dwzh=d.dwzh and d.qyzt='01' "
				+" where a.bpmid='"+v_bpmid+"' order by dwzh,jcyd " ;*/
		String sql =" select a.id,a.bpmid,a.ywlsh ,nvl(a1.jyzt,0)||'||'||nvl(b1.mc,'未发送')||'||'||nvl(a1.RtnMessage,'数据未发送') sbyy,a1.jyzt fszt," 
				+" a.dwzh,c.dwmc dwmc,a.jcyd,a.yhbm,a.hdrq lrrq " 
				+" from gjzf_dw_dwtsxx_wt a inner join gjzf_dw_zz b on a.dwzh=b.dwzh " 
				+" inner join cr_dw c on b.dwbh=c.dwbh " 
				+"   left join im_tx_zjjsjy_zjb a1 on a1.pcid=a.ywlsh "
				+" left join bm_zjjylx b1 on a1.jyzt=b1.bm "
				+" where a.bpmid='"+v_bpmid+"' order by dwzh,jcyd " ;
		
		try {
			SqlParameterExt spx = new SqlParameterExt();
			bo.setSqlParameterExt(spx);
			return bo.queryToList(sql,pagesize, pagenum);
		} catch (Exception e) {
			throw new CallDbException("执行方法[openZTBG_Hjhd_Dwtsdsfs_jkspcx]出错"+ e.getMessage());
		}
	}
}
