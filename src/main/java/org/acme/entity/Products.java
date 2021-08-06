package org.acme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="products")
@NamedQuery(name="products.findAll", query="SELECT p FROM Products p ORDER BY id")
public class Products {
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name", nullable=false, length=150)
	private String name;
	@Column(name="name_imp", length=150)
	private String impName;
	@Column(name="selling_price", nullable=false)
	private double sellingPrice;
	@Column(name="active", nullable=false)
	private int active;
	@Column(name="comission", nullable=false)
	private int comission;
	@Column(name="category_product_id")
	private Long categoryId;
	@Column(name="type_product_id")
	private Long typeId;
	@Column(name="measure_id")
	private Long measureId;
	@Column(name="measure_qtt")
	private double measureQtt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImpName() {
		return impName;
	}
	public void setImpName(String impName) {
		this.impName = impName;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getComission() {
		return comission;
	}
	public void setComission(int comission) {
		this.comission = comission;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getMeasureId() {
		return measureId;
	}
	public void setMeasureId(Long measureId) {
		this.measureId = measureId;
	}
	public double getMeasureQtt() {
		return measureQtt;
	}
	public void setMeasureQtt(double measureQtt) {
		this.measureQtt = measureQtt;
	}
	
	
}
