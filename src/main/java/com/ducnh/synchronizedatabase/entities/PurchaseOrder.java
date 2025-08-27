package com.ducnh.synchronizedatabase.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;

import java.util.Date;
import org.hibernate.annotations.Nationalized;
import java.math.BigDecimal;


import lombok.Data;

@Entity
@Table(name = "total_purchase_order", indexes = @Index(columnList = "so_ct_dt"))
@Data
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "char(13)")
	private String stt_rec;
	
	@Column(columnDefinition = "char(3)")
	private String stt_rec0;
	
	@Column(columnDefinition = "char(24)")
	private String so_ct_dt;
	
	@Column(columnDefinition = "char(8)")
	private String ma_dvcs_dt;
	
	@Column(columnDefinition = "char(16)")
	private String ma_nvbh;
	
	@Column(length = 256)
	private String ten_nvbh;
	
	@Column(columnDefinition = "char(24)")
	private String ma_vt;
	
	@Column(length = 256)
	private String ref;
	
	@Column(length = 2048)
	@Nationalized
	private String ten_vt;
	
	@Column(columnDefinition = "char(24)")
	private String nh_vt1;
	
	@Column(columnDefinition = "char(24)")
	private String nh_vt2;
	
	@Column(columnDefinition = "char(24)")
	private String nh_vt3;
	
	@Column(columnDefinition = "nchar(20)")
	@Nationalized
	private String dvt;
	
	@Column
	private Date ngay_dt;
	
	@Column(columnDefinition = "varchar(16)")
	private String ma_kh;
	
	@Column(columnDefinition = "nvarchar(1024)")
	@Nationalized
	private String ten_kh;
	
	@Column
	private BigDecimal sl_dt;
	
	@Column
	private BigDecimal sl_duyet_po;
	
	@Column
	private BigDecimal sl_nhap_tm;
	
	@Column
	private BigDecimal sl_xuat_tm;
	
	@Column
	private BigDecimal sl_cl_tm;
	
	@Column
	private Date ngay_nhap_tm;
	
	@Column(columnDefinition = "char(48)")
	private String ma_lo_nhap_tm;
	
	@Column
	private Date han_lo_nhap_tm;
	
	@Column
	private Date ngay_xuat_tm;
	
	@Column(columnDefinition = "char(24)")
	private String so_px_tm;
	
	@Column(columnDefinition = "char(48)")
	private String ma_lo_xuat_tm;
	
	@Column
	private Date han_lo_xuat_tm;
	
	@Column(columnDefinition = "varchar(16)")
	private String ma_kh_xuat_tm;
	
	@Column(columnDefinition = "nvarchar(1024)")
	@Nationalized
	private String ten_kh_xuat_tm;
	
	@Column(columnDefinition = "char(8)")
	private String ma_dvcs_nk;
	
	@Column
	private BigDecimal sl_duyet_po_nk;
	
	@Column
	private BigDecimal sl_tk_nk;
	
	@Column
	private BigDecimal sl_nhap_nk;
	
	@Column
	private BigDecimal sl_xuat_nk;
	
	@Column
	private BigDecimal sl_cl_nk;
	
	@Column
	private BigDecimal t_sl_cl;
	
	@Column
	private Date ngay_nhap_nk;
	
	@Column(columnDefinition = "char(48)")
	private String ma_lo_nhap_nk;
	
	@Column
	private Date han_lo_nhap_nk;
	
	@Column
	private Date ngay_xuat_nk;
	
	@Column(columnDefinition = "char(48)")
	private String ma_lo_xuat_nk;
	
	@Column
	private Date han_lo_xuat_nk;
	
	@Column(columnDefinition = "varchar(16)")
	private String ma_kh_xuat_nk;
	
	@Column(columnDefinition = "nvarchar(1024)")
	@Nationalized
	private String ten_kh_xuat_nk;
	
	@Column
	private int systotal;
	
	@Column
	private int sysorder;
	
	@Override
	public String toString() {
		return "PurchaseOrder{" +
				"id=" + id +
				", ma_vt=" + ma_vt + "}";	
	}
}
