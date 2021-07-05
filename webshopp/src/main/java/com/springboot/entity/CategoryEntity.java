package com.springboot.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "name_vn")
    private String nameVN;
    
    @OneToMany(mappedBy = "categoryEntity", fetch = FetchType.EAGER)
    List<ProductEntity> productEntities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameVN() {
        return nameVN;
    }

    public void setNameVN(String nameVN) {
        this.nameVN = nameVN;
    }

	public List<ProductEntity> getProductEntities() {
		return productEntities;
	}

	public void setProductEntities(List<ProductEntity> productEntities) {
		this.productEntities = productEntities;
	}

    
    
}
