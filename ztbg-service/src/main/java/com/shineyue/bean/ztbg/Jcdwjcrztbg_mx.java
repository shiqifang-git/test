package com.shineyue.bean.ztbg;


public class Jcdwjcrztbg_mx {
	private String ffbm;//服务分类编码varchar(2)输入传‘01’
	private String zxbm;//中心编号varchar(2)输入Api传值
	private String jgbm;//机构编号varchar(50)输入Api传值
	private String khbh;//客户idvarchar(12)输入传单位客户编号
	private String zhbh;//账户idvarchar(40)输入传单位账号
	private String ywfl;//业务分类varchar(20)输入传‘01’
	private String ywlb;//业务类别varchar(2)输入传‘99’
	private String blqd;//办理渠道varchar(20)输入传’zxb’
	private int userid;//操作员idint输入
	private String dwzh;//单位账号varchar(20)输入
	private String begindate;//查询开始日期date输入
	private String enddate;//查询结束日期date输入
	private int ywlx;//业务类型int输入
	private String grzh;
	private String xingming;
	private String czy;
	private int czyid;
	private String dwbh;
	private String ywbm;
	
	public String getYwbm() {
		return ywbm;
	}
	public void setYwbm(String ywbm) {
		this.ywbm = ywbm;
	}
	private int page;
	private int size;
	private double qcye;
	private double bqzj;
	private double bqjs;
	private double dwwfpje;
	private String zxjgbm;
    private String Zjbzxbm;
    private String grbh;
    private String tqyybm;
    private String bpmid;
    private String id;
    private String bgrq;
    private String bgsx;
    private String bgqxx;
    private String bghxx;
    private String zjhm;
    private String bgyd;
    private double bgqgrjcjs;
    private double bghgrjcjs;
    private double bgqyjce;
    private double bghyjce;
    private double dwyjce;
    private double gryjce;
    private String dwjjlx;
    private String zzjgdm;
    private String dwdz;
    private String yjny;
    private String jcbl;
    private String jbzhkhyh;
    private String jbzhyhzh;
    private String styhmc;
    private String tqyy;
    private double grjcjs;
    private double yjce;
    private double grzhye;
    private String bgyy;
    private String bjyybm;
    private String sfywlscx;  
    private double snjzfse;
    private double bnhj;
    private double bnbj;
    private String dkzh;//合同编号
    private String hkqc;//还款其次
    private double hkbj;//还款本金
    private double hklx;//还款利息
    private double hkfx;//罚息
    private double wyj;//违约金
    private double gjjzqe;// 公积金提取额
    private String hklb;
    private String  pksjrq; //批扣日期
   
	private String  sfpk;
    private String hzlx;
    private String xmbh;
    private String xmmc;
    private double qmje;
    
    private double qcyeHj ;
    private double qmjeHj ;
    private double bqzjHj ;
    private double bqjsHj ;
    private double dwwfpjeHj ;
    private double qcfsehj;
    private double fsehjhj;
    private double hkbjhj;
    private double hklxhj;
    private double hkfxhj;
    private double wyjhj;
    private double gjjzqehj;
    private double bgqgrjcjshj;
    private double bghgrjcjshj;
    private double bgqyjcehj;
    private double bghyjcehj;
    private double dwyjcehj;
    private double gryjcehj;
    private double grjcjshj;
    private double yjcehj;
    private double grzhyehj;
    private double snjzfsehj;
    private double bnhjhj;
    private double bnbjhj;
    private double bnzqhj;
    private double snjzhj;
    private double zrjcehj;
    private double bnjsfslxehj;
    
    private int qjrs;
    private double yqje;
    private double qjje;
    private int rs;
    
    private String jzny;
    private double zckye;
    private String dwfrdbxm;
    private String dwfrdblxdh;
    private String jbrxm;
    private String jbrsjhm;
    private String jbrgddhhm;
    private String czyd;
    private String ks;
    private String js;
    
    private double qjrsHj;
    private double qjjeHj;
    private double yqjeHj;
    private double zckyeHj;
    
    private String wtskxyh;//委托收款协议号
    private String qyrlxdh;//签约人联系电话
    private String jbzhkhmc;//托收单位户名
    private String ydtsrq;//约定托收日期
    private String khyhh;//开户银行行号
    private String qyrq;//签约日期
    private String qyzt;//签约状态
    private String qyztmc;
    private String bgqqyzt;//变更前签约状态
    private String bgqqyztmc;//变更前签约状态名称
    private String bgqqyrlxdh;//变更前签约人联系电话
    private String bgqydtsrq;//变更前约定托收日期
    private String bgywlsh;//对应业务表的业务流水号
    private String jbzhyhdm;//个人存款账户开户银行代码
    private String grtsxyh;//个人托收协议号
    
    private double dwzhye;//单位账户余额
    private int dwjcrs;
    private int dwfcrs;
    private String id1;
    private String cxlb;
    
    private double tqje;
    private double tqjehj;
    
    
    
    public double getTqje() {
		return tqje;
	}
	public void setTqje(double tqje) {
		this.tqje = tqje;
	}
	public double getTqjehj() {
		return tqjehj;
	}
	public void setTqjehj(double tqjehj) {
		this.tqjehj = tqjehj;
	}
	public String getCxlb() {
		return cxlb;
	}
	public void setCxlb(String cxlb) {
		this.cxlb = cxlb;
	}
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public int getDwjcrs() {
    	return dwjcrs;
    }
	public void setDwjcrs(int dwjcrs) {
    	this.dwjcrs = dwjcrs;
    }
	public int getDwfcrs() {
    	return dwfcrs;
    }
	public void setDwfcrs(int dwfcrs) {
    	this.dwfcrs = dwfcrs;
    }
	public double getDwzhye() {
    	return dwzhye;
    }
	public void setDwzhye(double dwzhye) {
    	this.dwzhye = dwzhye;
    }
	public String getWtskxyh() {
    	return wtskxyh;
    }
	public void setWtskxyh(String wtskxyh) {
    	this.wtskxyh = wtskxyh;
    }
	public String getQyrlxdh() {
    	return qyrlxdh;
    }
	public void setQyrlxdh(String qyrlxdh) {
    	this.qyrlxdh = qyrlxdh;
    }
	public String getJbzhkhmc() {
    	return jbzhkhmc;
    }
	public void setJbzhkhmc(String jbzhkhmc) {
    	this.jbzhkhmc = jbzhkhmc;
    }
	public String getYdtsrq() {
    	return ydtsrq;
    }
	public void setYdtsrq(String ydtsrq) {
    	this.ydtsrq = ydtsrq;
    }
	public String getKhyhh() {
    	return khyhh;
    }
	public void setKhyhh(String khyhh) {
    	this.khyhh = khyhh;
    }
	public String getQyrq() {
    	return qyrq;
    }
	public void setQyrq(String qyrq) {
    	this.qyrq = qyrq;
    }
	public String getQyzt() {
    	return qyzt;
    }
	public void setQyzt(String qyzt) {
    	this.qyzt = qyzt;
    }
	public String getQyztmc() {
    	return qyztmc;
    }
	public void setQyztmc(String qyztmc) {
    	this.qyztmc = qyztmc;
    }
	public String getBgqqyzt() {
    	return bgqqyzt;
    }
	public void setBgqqyzt(String bgqqyzt) {
    	this.bgqqyzt = bgqqyzt;
    }
	public String getBgqqyztmc() {
    	return bgqqyztmc;
    }
	public void setBgqqyztmc(String bgqqyztmc) {
    	this.bgqqyztmc = bgqqyztmc;
    }
	public String getBgqqyrlxdh() {
    	return bgqqyrlxdh;
    }
	public void setBgqqyrlxdh(String bgqqyrlxdh) {
    	this.bgqqyrlxdh = bgqqyrlxdh;
    }
	public String getBgqydtsrq() {
    	return bgqydtsrq;
    }
	public void setBgqydtsrq(String bgqydtsrq) {
    	this.bgqydtsrq = bgqydtsrq;
    }
	public String getBgywlsh() {
    	return bgywlsh;
    }
	public void setBgywlsh(String bgywlsh) {
    	this.bgywlsh = bgywlsh;
    }
	public String getJbzhyhdm() {
    	return jbzhyhdm;
    }
	public void setJbzhyhdm(String jbzhyhdm) {
    	this.jbzhyhdm = jbzhyhdm;
    }
	public String getGrtsxyh() {
    	return grtsxyh;
    }
	public void setGrtsxyh(String grtsxyh) {
    	this.grtsxyh = grtsxyh;
    }
	public double getZckyeHj() {
		return zckyeHj;
	}
	public void setZckyeHj(double zckyeHj) {
		this.zckyeHj = zckyeHj;
	}
	public double getYqje() {
		return yqje;
	}
	public void setYqje(double yqje) {
		this.yqje = yqje;
	}
	public double getQjrsHj() {
		return qjrsHj;
	}
	public void setQjrsHj(double qjrsHj) {
		this.qjrsHj = qjrsHj;
	}
	public double getQjjeHj() {
		return qjjeHj;
	}
	public void setQjjeHj(double qjjeHj) {
		this.qjjeHj = qjjeHj;
	}
	public double getYqjeHj() {
		return yqjeHj;
	}
	public void setYqjeHj(double yqjeHj) {
		this.yqjeHj = yqjeHj;
	}
	public String getCzyd() {
		return czyd;
	}
	public void setCzyd(String czyd) {
		this.czyd = czyd;
	}
	public String getKs() {
		return ks;
	}
	public void setKs(String ks) {
		this.ks = ks;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public int getQjrs() {
		return qjrs;
	}
	public void setQjrs(int qjrs) {
		this.qjrs = qjrs;
	}
	public double getQjje() {
		return qjje;
	}
	public void setQjje(double qjje) {
		this.qjje = qjje;
	}
	public int getRs() {
		return rs;
	}
	public void setRs(int rs) {
		this.rs = rs;
	}
	public String getJzny() {
		return jzny;
	}
	public void setJzny(String jzny) {
		this.jzny = jzny;
	}
	public double getZckye() {
		return zckye;
	}
	public void setZckye(double zckye) {
		this.zckye = zckye;
	}
	public String getDwfrdbxm() {
		return dwfrdbxm;
	}
	public void setDwfrdbxm(String dwfrdbxm) {
		this.dwfrdbxm = dwfrdbxm;
	}
	public String getDwfrdblxdh() {
		return dwfrdblxdh;
	}
	public void setDwfrdblxdh(String dwfrdblxdh) {
		this.dwfrdblxdh = dwfrdblxdh;
	}
	public String getJbrxm() {
		return jbrxm;
	}
	public void setJbrxm(String jbrxm) {
		this.jbrxm = jbrxm;
	}
	public String getJbrsjhm() {
		return jbrsjhm;
	}
	public void setJbrsjhm(String jbrsjhm) {
		this.jbrsjhm = jbrsjhm;
	}
	public String getJbrgddhhm() {
		return jbrgddhhm;
	}
	public void setJbrgddhhm(String jbrgddhhm) {
		this.jbrgddhhm = jbrgddhhm;
	}
	public double getQmjeHj() {
		return qmjeHj;
	}
	public void setQmjeHj(double qmjeHj) {
		this.qmjeHj = qmjeHj;
	}
	public double getSnjzfsehj() {
		return snjzfsehj;
	}
	public void setSnjzfsehj(double snjzfsehj) {
		this.snjzfsehj = snjzfsehj;
	}
	public double getBnhjhj() {
		return bnhjhj;
	}
	public void setBnhjhj(double bnhjhj) {
		this.bnhjhj = bnhjhj;
	}
	public double getBnbjhj() {
		return bnbjhj;
	}
	public void setBnbjhj(double bnbjhj) {
		this.bnbjhj = bnbjhj;
	}
	public double getBnzqhj() {
		return bnzqhj;
	}
	public void setBnzqhj(double bnzqhj) {
		this.bnzqhj = bnzqhj;
	}
	public double getSnjzhj() {
		return snjzhj;
	}
	public void setSnjzhj(double snjzhj) {
		this.snjzhj = snjzhj;
	}
	public double getZrjcehj() {
		return zrjcehj;
	}
	public void setZrjcehj(double zrjcehj) {
		this.zrjcehj = zrjcehj;
	}
	public double getBnjsfslxehj() {
		return bnjsfslxehj;
	}
	public void setBnjsfslxehj(double bnjsfslxehj) {
		this.bnjsfslxehj = bnjsfslxehj;
	}
	public double getGrjcjshj() {
		return grjcjshj;
	}
	public void setGrjcjshj(double grjcjshj) {
		this.grjcjshj = grjcjshj;
	}
	public double getYjcehj() {
		return yjcehj;
	}
	public void setYjcehj(double yjcehj) {
		this.yjcehj = yjcehj;
	}
	public double getGrzhyehj() {
		return grzhyehj;
	}
	public void setGrzhyehj(double grzhyehj) {
		this.grzhyehj = grzhyehj;
	}
	public double getBgqgrjcjshj() {
		return bgqgrjcjshj;
	}
	public void setBgqgrjcjshj(double bgqgrjcjshj) {
		this.bgqgrjcjshj = bgqgrjcjshj;
	}
	public double getBghgrjcjshj() {
		return bghgrjcjshj;
	}
	public void setBghgrjcjshj(double bghgrjcjshj) {
		this.bghgrjcjshj = bghgrjcjshj;
	}
	public double getBgqyjcehj() {
		return bgqyjcehj;
	}
	public void setBgqyjcehj(double bgqyjcehj) {
		this.bgqyjcehj = bgqyjcehj;
	}
	public double getBghyjcehj() {
		return bghyjcehj;
	}
	public void setBghyjcehj(double bghyjcehj) {
		this.bghyjcehj = bghyjcehj;
	}
	public double getDwyjcehj() {
		return dwyjcehj;
	}
	public void setDwyjcehj(double dwyjcehj) {
		this.dwyjcehj = dwyjcehj;
	}
	public double getGryjcehj() {
		return gryjcehj;
	}
	public void setGryjcehj(double gryjcehj) {
		this.gryjcehj = gryjcehj;
	}
	public double getHkbjhj() {
		return hkbjhj;
	}
	public void setHkbjhj(double hkbjhj) {
		this.hkbjhj = hkbjhj;
	}
	public double getHklxhj() {
		return hklxhj;
	}
	public void setHklxhj(double hklxhj) {
		this.hklxhj = hklxhj;
	}
	public double getHkfxhj() {
		return hkfxhj;
	}
	public void setHkfxhj(double hkfxhj) {
		this.hkfxhj = hkfxhj;
	}
	public double getWyjhj() {
		return wyjhj;
	}
	public void setWyjhj(double wyjhj) {
		this.wyjhj = wyjhj;
	}
	public double getGjjzqehj() {
		return gjjzqehj;
	}
	public void setGjjzqehj(double gjjzqehj) {
		this.gjjzqehj = gjjzqehj;
	}
	public double getQcfsehj() {
		return qcfsehj;
	}
	public void setQcfsehj(double qcfsehj) {
		this.qcfsehj = qcfsehj;
	}
	public double getFsehjhj() {
		return fsehjhj;
	}
	public void setFsehjhj(double fsehjhj) {
		this.fsehjhj = fsehjhj;
	}
	public double getQcyeHj() {
		return qcyeHj;
	}
	public void setQcyeHj(double qcyeHj) {
		this.qcyeHj = qcyeHj;
	}
	public double getBqzjHj() {
		return bqzjHj;
	}
	public void setBqzjHj(double bqzjHj) {
		this.bqzjHj = bqzjHj;
	}
	public double getBqjsHj() {
		return bqjsHj;
	}
	public void setBqjsHj(double bqjsHj) {
		this.bqjsHj = bqjsHj;
	}
	public double getDwwfpjeHj() {
		return dwwfpjeHj;
	}
	public void setDwwfpjeHj(double dwwfpjeHj) {
		this.dwwfpjeHj = dwwfpjeHj;
	}
    public String getXmbh() {
		return xmbh;
	}
	public void setXmbh(String xmbh) {
		this.xmbh = xmbh;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public double getQmje() {
		return qmje;
	}
	public void setQmje(double qmje) {
		this.qmje = qmje;
	}
    
    public String getHzlx() {
		return hzlx;
	}
	public void setHzlx(String hzlx) {
		this.hzlx = hzlx;
	}
	public String getSfpk() {
		return sfpk;
	}
	public void setSfpk(String sfpk) {
		this.sfpk = sfpk;
	}
	public String getDkzh() {
		return dkzh;
	}
	public void setDkzh(String dkzh) {
		this.dkzh = dkzh;
	}
	public String getHkqc() {
		return hkqc;
	}
	public void setHkqc(String hkqc) {
		this.hkqc = hkqc;
	}
	public double getHkbj() {
		return hkbj;
	}
	public void setHkbj(double hkbj) {
		this.hkbj = hkbj;
	}
	public double getHklx() {
		return hklx;
	}
	public void setHklx(double hklx) {
		this.hklx = hklx;
	}
	public double getHkfx() {
		return hkfx;
	}
	public void setHkfx(double hkfx) {
		this.hkfx = hkfx;
	}
	public double getWyj() {
		return wyj;
	}
	public void setWyj(double wyj) {
		this.wyj = wyj;
	}
	public double getGjjzqe() {
		return gjjzqe;
	}
	public void setGjjzqe(double gjjzqe) {
		this.gjjzqe = gjjzqe;
	}
	public String getHklb() {
		return hklb;
	}
	public void setHklb(String hklb) {
		this.hklb = hklb;
	}
	public String getPksjrq() {
		return pksjrq;
	}
	public void setPksjrq(String pksjrq) {
		this.pksjrq = pksjrq;
	}
	public double getSnjzfse() {
		return snjzfse;
	}
	public void setSnjzfse(double snjzfse) {
		this.snjzfse = snjzfse;
	}
	public double getBnhj() {
		return bnhj;
	}
	public void setBnhj(double bnhj) {
		this.bnhj = bnhj;
	}
	public double getBnbj() {
		return bnbj;
	}
	public void setBnbj(double bnbj) {
		this.bnbj = bnbj;
	}
	public double getBnzq() {
		return bnzq;
	}
	public void setBnzq(double bnzq) {
		this.bnzq = bnzq;
	}
	public double getSnjz() {
		return snjz;
	}
	public void setSnjz(double snjz) {
		this.snjz = snjz;
	}
	public double getZrjce() {
		return zrjce;
	}
	public void setZrjce(double zrjce) {
		this.zrjce = zrjce;
	}
	public double getBnjsfslxe() {
		return bnjsfslxe;
	}
	public void setBnjsfslxe(double bnjsfslxe) {
		this.bnjsfslxe = bnjsfslxe;
	}
	private double bnzq;
    private double snjz;
    private double zrjce;
    private double bnjsfslxe;
    
    
    
    
    public String getSfywlscx() {
		return sfywlscx;
	}
	public void setSfywlscx(String sfywlscx) {
		this.sfywlscx = sfywlscx;
	}
	public String getBjyybm() {
		return bjyybm;
	}
	public void setBjyybm(String bjyybm) {
		this.bjyybm = bjyybm;
	}
	public String getBjyymc() {
		return bjyymc;
	}
	public void setBjyymc(String bjyymc) {
		this.bjyymc = bjyymc;
	}
	private String bjyymc;
    
    public String getBgyy() {
		return bgyy;
	}
	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}
	public double getGrzhye() {
		return grzhye;
	}
	public void setGrzhye(double grzhye) {
		this.grzhye = grzhye;
	}
	public double getYjce() {
		return yjce;
	}
	public void setYjce(double yjce) {
		this.yjce = yjce;
	}
	public double getGrjcjs() {
		return grjcjs;
	}
	public void setGrjcjs(double grjcjs) {
		this.grjcjs = grjcjs;
	}
	public String getTqyy() {
		return tqyy;
	}
	public void setTqyy(String tqyy) {
		this.tqyy = tqyy;
	}
	public String getZcgrzh() {
		return zcgrzh;
	}
	public void setZcgrzh(String zcgrzh) {
		this.zcgrzh = zcgrzh;
	}
	public String getZcgrxm() {
		return zcgrxm;
	}
	public void setZcgrxm(String zcgrxm) {
		this.zcgrxm = zcgrxm;
	}
	public String getZrgrzh() {
		return zrgrzh;
	}
	public void setZrgrzh(String zrgrzh) {
		this.zrgrzh = zrgrzh;
	}
	public String getZrgrxm() {
		return zrgrxm;
	}
	public void setZrgrxm(String zrgrxm) {
		this.zrgrxm = zrgrxm;
	}
	private String zcgrzh;
    private String zcgrxm;
    private String zrgrzh;
    private String zrgrxm;
    
    
    
    
    public String getDwjjlx() {
		return dwjjlx;
	}
	public void setDwjjlx(String dwjjlx) {
		this.dwjjlx = dwjjlx;
	}
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	public String getDwdz() {
		return dwdz;
	}
	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	public String getYjny() {
		return yjny;
	}
	public void setYjny(String yjny) {
		this.yjny = yjny;
	}
	public String getJcbl() {
		return jcbl;
	}
	public void setJcbl(String jcbl) {
		this.jcbl = jcbl;
	}
	public String getJbzhkhyh() {
		return jbzhkhyh;
	}
	public void setJbzhkhyh(String jbzhkhyh) {
		this.jbzhkhyh = jbzhkhyh;
	}
	public String getJbzhyhzh() {
		return jbzhyhzh;
	}
	public void setJbzhyhzh(String jbzhyhzh) {
		this.jbzhyhzh = jbzhyhzh;
	}
	public String getStyhmc() {
		return styhmc;
	}
	public void setStyhmc(String styhmc) {
		this.styhmc = styhmc;
	}
	public double getBgqgrjcjs() {
		return bgqgrjcjs;
	}
	public void setBgqgrjcjs(double bgqgrjcjs) {
		this.bgqgrjcjs = bgqgrjcjs;
	}
	public double getBghgrjcjs() {
		return bghgrjcjs;
	}
	public void setBghgrjcjs(double bghgrjcjs) {
		this.bghgrjcjs = bghgrjcjs;
	}
	public double getBgqyjce() {
		return bgqyjce;
	}
	public void setBgqyjce(double bgqyjce) {
		this.bgqyjce = bgqyjce;
	}
	public double getBghyjce() {
		return bghyjce;
	}
	public void setBghyjce(double bghyjce) {
		this.bghyjce = bghyjce;
	}
	public double getDwyjce() {
		return dwyjce;
	}
	public void setDwyjce(double dwyjce) {
		this.dwyjce = dwyjce;
	}
	public double getGryjce() {
		return gryjce;
	}
	public void setGryjce(double gryjce) {
		this.gryjce = gryjce;
	}
	public String getBgyd() {
		return bgyd;
	}
	public void setBgyd(String bgyd) {
		this.bgyd = bgyd;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getBgsx() {
		return bgsx;
	}
	public void setBgsx(String bgsx) {
		this.bgsx = bgsx;
	}
	public String getBgqxx() {
		return bgqxx;
	}
	public void setBgqxx(String bgqxx) {
		this.bgqxx = bgqxx;
	}
	public String getBghxx() {
		return bghxx;
	}
	public void setBghxx(String bghxx) {
		this.bghxx = bghxx;
	}
	public String getBgrq() {
		return bgrq;
	}
	public void setBgrq(String bgrq) {
		this.bgrq = bgrq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBpmid() {
		return bpmid;
	}
	public void setBpmid(String bpmid) {
		this.bpmid = bpmid;
	}
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	public String getTqyybm() {
		return tqyybm;
	}
	public void setTqyybm(String tqyybm) {
		this.tqyybm = tqyybm;
	}
	public String getDwbh() {
		return dwbh;
	}
	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}
	public String getZxjgbm() {
		return zxjgbm;
	}
	public void setZxjgbm(String zxjgbm) {
		this.zxjgbm = zxjgbm;
	}
	public String getZjbzxbm() {
		return Zjbzxbm;
	}
	public void setZjbzxbm(String zjbzxbm) {
		Zjbzxbm = zjbzxbm;
	}
	private String cxrq_begin;
	private String cxrq_end;
	private String jcyd;
	private double syje;
	private String syrs;
	private String zjrs;
	private double zjje;
	private String jsrs;
	private double jsje;
	private String hjrs;
	private double hjje;
	private double fsehj;
	private double fslxehj;
	private double yuehj;
	private double fsrshj;
	private double syjehj;
	private double syrshj;
	private double zjrshj;
	private double zjjehj;
	private double jsrshj;
	private double jsjehj;
	private double hjrshj;
	private double hjjehj;
	
	public double getFsrshj() {
		return fsrshj;
	}
	public void setFsrshj(double fsrshj) {
		this.fsrshj = fsrshj;
	}
	public double getSyjehj() {
		return syjehj;
	}
	public void setSyjehj(double syjehj) {
		this.syjehj = syjehj;
	}
	public double getSyrshj() {
		return syrshj;
	}
	public void setSyrshj(double syrshj) {
		this.syrshj = syrshj;
	}
	public double getZjrshj() {
		return zjrshj;
	}
	public void setZjrshj(double zjrshj) {
		this.zjrshj = zjrshj;
	}
	public double getZjjehj() {
		return zjjehj;
	}
	public void setZjjehj(double zjjehj) {
		this.zjjehj = zjjehj;
	}
	public double getJsrshj() {
		return jsrshj;
	}
	public void setJsrshj(double jsrshj) {
		this.jsrshj = jsrshj;
	}
	public double getJsjehj() {
		return jsjehj;
	}
	public void setJsjehj(double jsjehj) {
		this.jsjehj = jsjehj;
	}
	public double getHjrshj() {
		return hjrshj;
	}
	public void setHjrshj(double hjrshj) {
		this.hjrshj = hjrshj;
	}
	public double getHjjehj() {
		return hjjehj;
	}
	public void setHjjehj(double hjjehj) {
		this.hjjehj = hjjehj;
	}
	public double getFslxehj() {
		return fslxehj;
	}
	public void setFslxehj(double fslxehj) {
		this.fslxehj = fslxehj;
	}
	public double getYuehj() {
		return yuehj;
	}
	public void setYuehj(double yuehj) {
		this.yuehj = yuehj;
	}
	public double getFsehj() {
		return fsehj;
	}
	public void setFsehj(double fsehj) {
		this.fsehj = fsehj;
	}
	public String getJcyd() {
		return jcyd;
	}
	public void setJcyd(String jcyd) {
		this.jcyd = jcyd;
	}
	public double getSyje() {
		return syje;
	}
	public void setSyje(double syje) {
		this.syje = syje;
	}
	public String getSyrs() {
		return syrs;
	}
	public void setSyrs(String syrs) {
		this.syrs = syrs;
	}
	public String getZjrs() {
		return zjrs;
	}
	public void setZjrs(String zjrs) {
		this.zjrs = zjrs;
	}
	public double getZjje() {
		return zjje;
	}
	public void setZjje(double zjje) {
		this.zjje = zjje;
	}
	public String getJsrs() {
		return jsrs;
	}
	public void setJsrs(String jsrs) {
		this.jsrs = jsrs;
	}
	public double getJsje() {
		return jsje;
	}
	public void setJsje(double jsje) {
		this.jsje = jsje;
	}
	public String getHjrs() {
		return hjrs;
	}
	public void setHjrs(String hjrs) {
		this.hjrs = hjrs;
	}
	public double getHjje() {
		return hjje;
	}
	public void setHjje(double hjje) {
		this.hjje = hjje;
	}
	public int getCzyid() {
		return czyid;
	}
	public void setCzyid(int czyid) {
		this.czyid = czyid;
	}
	public String getCzy() {
		return czy;
	}
	public void setCzy(String czy) {
		this.czy = czy;
	}
	public String getGrzh() {
		return grzh;
	}
	public void setGrzh(String grzh) {
		this.grzh = grzh;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getCxrq_begin() {
		return cxrq_begin;
	}
	public void setCxrq_begin(String cxrq_begin) {
		this.cxrq_begin = cxrq_begin;
	}
	public String getCxrq_end() {
		return cxrq_end;
	}
	public void setCxrq_end(String cxrq_end) {
		this.cxrq_end = cxrq_end;
	}
	public double getQcye() {
		return qcye;
	}
	public void setQcye(double qcye) {
		this.qcye = qcye;
	}
	public double getBqzj() {
		return bqzj;
	}
	public void setBqzj(double bqzj) {
		this.bqzj = bqzj;
	}
	public double getBqjs() {
		return bqjs;
	}
	public void setBqjs(double bqjs) {
		this.bqjs = bqjs;
	}
	public double getDwwfpje() {
		return dwwfpje;
	}
	public void setDwwfpje(double dwwfpje) {
		this.dwwfpje = dwwfpje;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	private String dwmc;//单位名称varchar(255)输入
	private String jzrq;//记账日期date输入
	private double fse;//发生额decimal(18,2)输入
	private double fslxe;//发生利息额decimal(18,2)输入
	private double yue;//余额decimal(18,2)输入
	private int fsrs;//发生人数int输入
	private String ywmxlx;//业务明细类型varchar(2)输入
	private String ywmxlxbm;
	private String hbjny;//汇补缴年月varchar(13)输入
	private String ywlsh;//业务流水号varchar(20)输入
	private String czbz;//冲账标识varchar(2)输入
	private String ywfhczy;//操作员varchar(100)输入
	private String ywzy;//摘要varchar(200)输入
	
	public String getYwmxlxbm() {
		return ywmxlxbm;
	}
	public void setYwmxlxbm(String ywmxlxbm) {
		this.ywmxlxbm = ywmxlxbm;
	}
	public String getFfbm() {
		return ffbm;
	}
	public void setFfbm(String ffbm) {
		this.ffbm = ffbm;
	}
	public String getZxbm() {
		return zxbm;
	}
	public void setZxbm(String zxbm) {
		this.zxbm = zxbm;
	}
	public String getJgbm() {
		return jgbm;
	}
	public void setJgbm(String jgbm) {
		this.jgbm = jgbm;
	}
	public String getKhbh() {
		return khbh;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public String getZhbh() {
		return zhbh;
	}
	public void setZhbh(String zhbh) {
		this.zhbh = zhbh;
	}
	public String getYwfl() {
		return ywfl;
	}
	public void setYwfl(String ywfl) {
		this.ywfl = ywfl;
	}
	public String getYwlb() {
		return ywlb;
	}
	public void setYwlb(String ywlb) {
		this.ywlb = ywlb;
	}
	public String getBlqd() {
		return blqd;
	}
	public void setBlqd(String blqd) {
		this.blqd = blqd;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDwzh() {
		return dwzh;
	}
	public void setDwzh(String dwzh) {
		this.dwzh = dwzh;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getYwlx() {
		return ywlx;
	}
	public void setYwlx(int ywlx) {
		this.ywlx = ywlx;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getJzrq() {
		return jzrq;
	}
	public void setJzrq(String jzrq) {
		this.jzrq = jzrq;
	}
	public double getFse() {
		return fse;
	}
	public void setFse(double fse) {
		this.fse = fse;
	}
	public double getFslxe() {
		return fslxe;
	}
	public void setFslxe(double fslxe) {
		this.fslxe = fslxe;
	}
	public double getYue() {
		return yue;
	}
	public void setYue(double yue) {
		this.yue = yue;
	}
	public int getFsrs() {
		return fsrs;
	}
	public void setFsrs(int fsrs) {
		this.fsrs = fsrs;
	}
	public String getYwmxlx() {
		return ywmxlx;
	}
	public void setYwmxlx(String ywmxlx) {
		this.ywmxlx = ywmxlx;
	}
	public String getHbjny() {
		return hbjny;
	}
	public void setHbjny(String hbjny) {
		this.hbjny = hbjny;
	}
	public String getYwlsh() {
		return ywlsh;
	}
	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}
	public String getCzbz() {
		return czbz;
	}
	public void setCzbz(String czbz) {
		this.czbz = czbz;
	}
	public String getYwfhczy() {
		return ywfhczy;
	}
	public void setYwfhczy(String ywfhczy) {
		this.ywfhczy = ywfhczy;
	}
	public String getYwzy() {
		return ywzy;
	}
	public void setYwzy(String ywzy) {
		this.ywzy = ywzy;
	}
	
	
	
	
}
