package com.ducnh.synchronizedatabase.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
import org.hibernate.annotations.Nationalized;
import java.math.BigDecimal;


import lombok.Data;

@Entity
@Table(name = "total_purchase_order")
@Data
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(columnDefinition = "char(13)")
	public String stt_rec;
	
	@Column(columnDefinition = "char(3)")
	public String stt_rec0;
	
	@Column(columnDefinition = "char(24)")
	public String so_ct_dt;
	
	@Column(columnDefinition = "char(8)")
	public String ma_dvcs_dt;
	
	@Column(columnDefinition = "char(16)")
	public String ma_nvbh;
	
	@Column(length = 256)
	public String ten_nvbh;
	
	@Column(columnDefinition = "char(24)")
	public String ma_vt;
	
	@Column(length = 256)
	public String ref;
	
	@Column(length = 2048)
	@Nationalized
	public String ten_vt;
	
	@Column(columnDefinition = "char(24)")
	public String nh_vt1;
	
	@Column(columnDefinition = "char(24)")
	public String nh_vt2;
	
	@Column(columnDefinition = "char(24)")
	public String nh_vt3;
	
	@Column(columnDefinition = "nchar(20)")
	@Nationalized
	public String dvt;
	
	@Column
	public Date ngay_dt;
	
	@Column(columnDefinition = "varchar(16)")
	public String ma_kh;
	
	@Column(columnDefinition = "nvarchar(1024)")
	@Nationalized
	public String ten_kh;
	
	@Column
	public BigDecimal sl_dt;
	
	@Column
	public BigDecimal sl_duyet_po;
	
	@Column
	public BigDecimal sl_nhap_tm;
	
	@Column
	public BigDecimal sl_xuat_tm;
	
	@Column
	public BigDecimal sl_cl_tm;
	
	@Column
	public Date ngay_nhap_tm;
	
	@Column(columnDefinition = "char(48)")
	public String ma_lo_nhap_tm;
	
	@Column
	public Date han_lo_nhap_tm;
	
	@Column(columnDefinition = "char(8)")
	public String ma_dvcs_nk;
	
	@Column
	public BigDecimal sl_duyet_po_nk;
	
	@Column
	public BigDecimal sl_tk_nk;
	
	@Column
	public BigDecimal sl_nhap_nk;
	
	@Column
	public BigDecimal sl_xuat_nk;
	
	@Column
	public BigDecimal sl_cl_nk;
	
	@Column
	public BigDecimal t_sl_cl;
	
	@Column
	public Date ngay_nhap_nk;
	
	@Column(columnDefinition = "char(48)")
	public String ma_lo_nhap_nk;
	
	@Column
	public Date han_lo_nhap_nk;
	
	@Override
	public String toString() {
		return "PurchaseOrder{" +
				"id=" + id +
				", ma_vt=" + ma_vt + "}";	
	}
}
