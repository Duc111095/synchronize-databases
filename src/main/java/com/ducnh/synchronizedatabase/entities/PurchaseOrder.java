package com.ducnh.synchronizedatabase.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column
	public String stt_rec;
	
	@Column
	public String stt_rec0;
	
	@Column
	public String so_ct_dt;
	
	@Column
	public String ma_dvcs_dt;
	
	@Column
	public String ma_nvbh;
	
	@Column
	public String ten_nvbh;
	
	@Column
	public String ma_vt;
	
	@Column
	public String ref;
	
	@Column
	public String ten_vt;
	
	@Column
	public String nh_vt1;
	
	@Column
	public String nh_vt2;
	
	@Column
	public String nh_vt3;
	
	@Column
	public String dvt;
	
	@Column
	public LocalDateTime ngay_dt;
	
	@Column
	public String ma_kh;
	
	@Column
	public String ten_kh;
	
	@Column
	public Double sl_dt;
	
	@Column
	public Double sl_duyet_po;
	
	@Column
	public Double sl_nhap_tm;
	
	@Column
	public Double sl_xuat_tm;
	
	@Column
	public Double sl_cl_tm;
	
	@Column
	public LocalDateTime ngay_nhap_tm;
	
	@Column
	public String ma_lo_nhap_tm;
	
	@Column
	public LocalDateTime han_lo_nhap_tm;
	
	@Column
	public String ma_dvcs_nk;
	
	@Column
	public Double sl_duyet_po_nk;
	
	@Column
	public Double sl_tk_nk;
	
	@Column
	public Double sl_nhap_nk;
	
	@Column
	public Double sl_xuat_nk;
	
	@Column
	public Double sl_cl_nk;
	
	@Column
	public Double t_sl_cl;
	
	@Column
	public LocalDateTime ngay_nhap_nk;
	
	@Column
	public String ma_lo_nhap_nk;
	
	@Column
	public LocalDateTime han_lo_nhap_nk;
}
