package com.shineyue.bean.ztbg;

public class Jcdwjcrztbg {
	
	private String dwzh;//--单位账号
	private String grzh;//--职工账号
	private String xingming;//姓名
	private String bglb;//--变更类别
	private String djrq;//--冻结日期
	private double djje ;//--冻结金额
	private int sfqb;//--是否全部冻结解冻 
	private String blqd;//--办理渠道
	private int userid;//--操作员id
	private String msg;//--返回信息：0-成功，1-职工已存在个人状态变更清册,2-职工账户已销户或调出, 99-不成功
	private String only;//唯一值（等于''时为第一条记录
	private int ret;//--返回值0成功99失败
	private  String  fcyy;
	private String  ywlshArr;
	
	public String getYwlshArr() {
		return ywlshArr;
	}
	public void setYwlshArr(String ywlshArr) {
		this.ywlshArr = ywlshArr;
	}
	public String getFcyy() {
		return fcyy;
	}
	public void setFcyy(String fcyy) {
		this.fcyy = fcyy;
	}
	private String bgyy;//--变更原因编码
	private String bgyd;//--变更月度
	
	private String pzid;//唯一记录id
	private String bgrq;//变更日期
	private double ycje;//月缴存金额
	private String pzbh;//流水号
	private String xdwzh;//新单位账号
	
	private String ycjeArr;//月缴存金额
	private String useridArr;//--操作员id
	
	private String zjhm;//证件号码
	private String zydwzh;//新单位账号
	private String tzrq;//转出日期
	
	private String grbh;
	private String zcdwbh;
	private String zcdwmc;
	private String zrdwbh;
	private String zrdwmc;
	private String id;
	
	private String zxbm;
	private String jgbm;
	private String khbh;
	private String ywfl;
	private String ywlb;
	private String ffbm;
	private String ywlsh;
	private String lrsj;
	private String dwmc;
	private String jbrxm;
	private String jbrsjhm;
	private int dwjcrs;
	private double yjcze;
	private String djyy;
	private String djlx;
	private String jdyy;
	private String bz;
	private int count;
	private int page;
	private int size;
	private double kdjje;
	private double kjdje;
	private String sfqbdj;
	private String djjsrq;
	private String djbz;
	private String czy;
	private String djywlsh;
	private String sfjd;
	private double ljdjje;
	private String jzny;
	private long bpmid;
	private String dwbh;
	private String djjd;
	private String bgywlsh;
	private String sbyy;
	private double grzhye;
	private String xdwbh;
	private String ywbm;
	private String number;
	private String dwxz;
	
	
	


	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDwxz() {
		return dwxz;
	}
	public void setDwxz(String dwxz) {
		this.dwxz = dwxz;
	}
	public String getYwbm() {
		return ywbm;
	}
	public void setYwbm(String ywbm) {
		this.ywbm = ywbm;
	}
	public String getXdwbh() {
		return xdwbh;
	}
	public void setXdwbh(String xdwbh) {
		this.xdwbh = xdwbh;
	}
	public double getGrzhye() {
		return grzhye;
	}
	public void setGrzhye(double grzhye) {
		this.grzhye = grzhye;
	}
	public String getSbyy() {
		return sbyy;
	}
	public void setSbyy(String sbyy) {
		this.sbyy = sbyy;
	}
	public String getBgywlsh() {
		return bgywlsh;
	}
	public void setBgywlsh(String bgywlsh) {
		this.bgywlsh = bgywlsh;
	}
	public double getLjdjje() {
		return ljdjje;
	}
	public void setLjdjje(double ljdjje) {
		this.ljdjje = ljdjje;
	}
	public String getDjjd() {
		return djjd;
	}
	public void setDjjd(String djjd) {
		this.djjd = djjd;
	}
	public String getDwbh() {
		return dwbh;
	}
	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}
	public String getJzny() {
		return jzny;
	}
	public void setJzny(String jzny) {
		this.jzny = jzny;
	}
	public long getBpmid() {
		return bpmid;
	}
	public void setBpmid(long bpmid) {
		this.bpmid = bpmid;
	}
	public String getSfjd() {
		return sfjd;
	}
	public void setSfjd(String sfjd) {
		this.sfjd = sfjd;
	}
	public String getDjywlsh() {
		return djywlsh;
	}
	public void setDjywlsh(String djywlsh) {
		this.djywlsh = djywlsh;
	}
	public String getCzy() {
		return czy;
	}
	public void setCzy(String czy) {
		this.czy = czy;
	}
	public String getDjbz() {
		return djbz;
	}
	public void setDjbz(String djbz) {
		this.djbz = djbz;
	}
	public String getDjjsrq() {
		return djjsrq;
	}
	public void setDjjsrq(String djjsrq) {
		this.djjsrq = djjsrq;
	}
	public String getSfqbdj() {
		return sfqbdj;
	}
	public void setSfqbdj(String sfqbdj) {
		this.sfqbdj = sfqbdj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public double getKdjje() {
		return kdjje;
	}
	public void setKdjje(double kdjje) {
		this.kdjje = kdjje;
	}
	public double getKjdje() {
		return kjdje;
	}
	public void setKjdje(double kjdje) {
		this.kjdje = kjdje;
	}
	public String getJdyy() {
		return jdyy;
	}
	public void setJdyy(String jdyy) {
		this.jdyy = jdyy;
	}
	public String getYwlsh() {
		return ywlsh;
	}
	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}
	public String getLrsj() {
		return lrsj;
	}
	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
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
	public int getDwjcrs() {
		return dwjcrs;
	}
	public void setDwjcrs(int dwjcrs) {
		this.dwjcrs = dwjcrs;
	}
	public double getYjcze() {
		return yjcze;
	}
	public void setYjcze(double yjcze) {
		this.yjcze = yjcze;
	}
	public String getDjyy() {
		return djyy;
	}
	public void setDjyy(String djyy) {
		this.djyy = djyy;
	}
	public String getDjlx() {
		return djlx;
	}
	public void setDjlx(String djlx) {
		this.djlx = djlx;
	}
	public String getYcjeArr() {
		return ycjeArr;
	}
	public void setYcjeArr(String ycjeArr) {
		this.ycjeArr = ycjeArr;
	}
	public String getUseridArr() {
		return useridArr;
	}
	public void setUseridArr(String useridArr) {
		this.useridArr = useridArr;
	}
	public String getFfbm() {
		return ffbm;
	}
	public void setFfbm(String ffbm) {
		this.ffbm = ffbm;
	}
	public int getRet() {
		return ret;
	}
	public void setRet(int ret) {
		this.ret = ret;
	}
	public String getDwzh() {
		return dwzh;
	}
	public void setDwzh(String dwzh) {
		this.dwzh = dwzh;
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
	public String getBglb() {
		return bglb;
	}
	public void setBglb(String bglb) {
		this.bglb = bglb;
	}
	public String getDjrq() {
		return djrq;
	}
	public void setDjrq(String djrq) {
		this.djrq = djrq;
	}
	public double getDjje() {
		return djje;
	}
	public void setDjje(double djje) {
		this.djje = djje;
	}
	public int getSfqb() {
		return sfqb;
	}
	public void setSfqb(int sfqb) {
		this.sfqb = sfqb;
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getOnly() {
		return only;
	}
	public void setOnly(String only) {
		this.only = only;
	}
	public String getBgyy() {
		return bgyy;
	}
	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}
	public String getBgyd() {
		return bgyd;
	}
	public void setBgyd(String bgyd) {
		this.bgyd = bgyd;
	}
	public String getPzid() {
		return pzid;
	}
	public void setPzid(String pzid) {
		this.pzid = pzid;
	}
	public String getBgrq() {
		return bgrq;
	}
	public void setBgrq(String bgrq) {
		this.bgrq = bgrq;
	}
	public double getYcje() {
		return ycje;
	}
	public void setYcje(double ycje) {
		this.ycje = ycje;
	}
	public String getPzbh() {
		return pzbh;
	}
	public void setPzbh(String pzbh) {
		this.pzbh = pzbh;
	}
	public String getXdwzh() {
		return xdwzh;
	}
	public void setXdwzh(String xdwzh) {
		this.xdwzh = xdwzh;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getZydwzh() {
		return zydwzh;
	}
	public void setZydwzh(String zydwzh) {
		this.zydwzh = zydwzh;
	}
	public String getTzrq() {
		return tzrq;
	}
	public void setTzrq(String tzrq) {
		this.tzrq = tzrq;
	}
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	public String getZcdwbh() {
		return zcdwbh;
	}
	public void setZcdwbh(String zcdwbh) {
		this.zcdwbh = zcdwbh;
	}
	public String getZcdwmc() {
		return zcdwmc;
	}
	public void setZcdwmc(String zcdwmc) {
		this.zcdwmc = zcdwmc;
	}
	public String getZrdwbh() {
		return zrdwbh;
	}
	public void setZrdwbh(String zrdwbh) {
		this.zrdwbh = zrdwbh;
	}
	public String getZrdwmc() {
		return zrdwmc;
	}
	public void setZrdwmc(String zrdwmc) {
		this.zrdwmc = zrdwmc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	
	
	
}
