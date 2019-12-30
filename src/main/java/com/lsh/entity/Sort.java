package com.lsh.entity;

import java.util.List;

public class Sort {
	private String sort_id;
	private String sort_name;
	private String father_id;
	private String sort_rank;
	private Sort father_sort;
	//查询一级和所拥有的二级
	private List<Sort> secondOnFirst;
	public Sort() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sort(String sort_id, String sort_name, String father_id,
			String sort_rank, Sort father_sort, List<Sort> secondOnFirst) {
		super();
		this.sort_id = sort_id;
		this.sort_name = sort_name;
		this.father_id = father_id;
		this.sort_rank = sort_rank;
		this.father_sort = father_sort;
		this.secondOnFirst = secondOnFirst;
	}
	@Override
	public String toString() {
		return "Sort [sort_id=" + sort_id + ", sort_name=" + sort_name
				+ ", father_id=" + father_id + ", sort_rank=" + sort_rank
				+ ", father_sort=" + father_sort + ", secondOnFirst="
				+ secondOnFirst + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((father_id == null) ? 0 : father_id.hashCode());
		result = prime * result
				+ ((father_sort == null) ? 0 : father_sort.hashCode());
		result = prime * result
				+ ((secondOnFirst == null) ? 0 : secondOnFirst.hashCode());
		result = prime * result + ((sort_id == null) ? 0 : sort_id.hashCode());
		result = prime * result
				+ ((sort_name == null) ? 0 : sort_name.hashCode());
		result = prime * result
				+ ((sort_rank == null) ? 0 : sort_rank.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sort other = (Sort) obj;
		if (father_id == null) {
			if (other.father_id != null)
				return false;
		} else if (!father_id.equals(other.father_id))
			return false;
		if (father_sort == null) {
			if (other.father_sort != null)
				return false;
		} else if (!father_sort.equals(other.father_sort))
			return false;
		if (secondOnFirst == null) {
			if (other.secondOnFirst != null)
				return false;
		} else if (!secondOnFirst.equals(other.secondOnFirst))
			return false;
		if (sort_id == null) {
			if (other.sort_id != null)
				return false;
		} else if (!sort_id.equals(other.sort_id))
			return false;
		if (sort_name == null) {
			if (other.sort_name != null)
				return false;
		} else if (!sort_name.equals(other.sort_name))
			return false;
		if (sort_rank == null) {
			if (other.sort_rank != null)
				return false;
		} else if (!sort_rank.equals(other.sort_rank))
			return false;
		return true;
	}
	public String getSort_id() {
		return sort_id;
	}
	public void setSort_id(String sort_id) {
		this.sort_id = sort_id;
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	public String getFather_id() {
		return father_id;
	}
	public void setFather_id(String father_id) {
		this.father_id = father_id;
	}
	public String getSort_rank() {
		return sort_rank;
	}
	public void setSort_rank(String sort_rank) {
		this.sort_rank = sort_rank;
	}
	public Sort getFather_sort() {
		return father_sort;
	}
	public void setFather_sort(Sort father_sort) {
		this.father_sort = father_sort;
	}
	public List<Sort> getSecondOnFirst() {
		return secondOnFirst;
	}
	public void setSecondOnFirst(List<Sort> secondOnFirst) {
		this.secondOnFirst = secondOnFirst;
	}
	
	
	
	
}
