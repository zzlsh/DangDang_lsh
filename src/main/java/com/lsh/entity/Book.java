package com.lsh.entity;

import java.util.Date;

public class Book {
	private String book_id;
	private String book_name;
	private String book_author;
	private String author_introduction;
	private String book_introduction;
	private String book_publisher;
	private Date book_publish_time;
	private Date book_printing_time;
	private Date book_putaway_time;
	private String book_edition;
	private String book_impression;
	private String book_paper;
	private String book_pages;
	private String book_pack;
	private String book_format;
	private String book_words;
	private String book_isbn;
	private String book_editer_comment;
	private String book_media_comment;
	private String book_catalog;
	private String book_cover;
	private Double book_original_price;
	private Double book_dangdang_price;
	private String book_inventory;
	private String book_sales_volume;
	private String sort_id;
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name
				+ ", book_author=" + book_author + ", author_introduction="
				+ author_introduction + ", book_introduction="
				+ book_introduction + ", book_publisher=" + book_publisher
				+ ", book_publish_time=" + book_publish_time
				+ ", book_printing_time=" + book_printing_time
				+ ", book_putaway_time=" + book_putaway_time
				+ ", book_edition=" + book_edition + ", book_impression="
				+ book_impression + ", book_paper=" + book_paper
				+ ", book_pages=" + book_pages + ", book_pack=" + book_pack
				+ ", book_format=" + book_format + ", book_words=" + book_words
				+ ", book_isbn=" + book_isbn + ", book_editer_comment="
				+ book_editer_comment + ", book_media_comment="
				+ book_media_comment + ", book_catalog=" + book_catalog
				+ ", book_cover=" + book_cover + ", book_original_price="
				+ book_original_price + ", book_dangdang_price="
				+ book_dangdang_price + ", book_inventory=" + book_inventory
				+ ", book_sales_volume=" + book_sales_volume + ", sort_id="
				+ sort_id + "]";
	}
	public Book(String book_id, String book_name, String book_author,
			String author_introduction, String book_introduction,
			String book_publisher, Date book_publish_time,
			Date book_printing_time, Date book_putaway_time,
			String book_edition, String book_impression, String book_paper,
			String book_pages, String book_pack, String book_format,
			String book_words, String book_isbn, String book_editer_comment,
			String book_media_comment, String book_catalog, String book_cover,
			Double book_original_price, Double book_dangdang_price,
			String book_inventory, String book_sales_volume, String sort_id) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.author_introduction = author_introduction;
		this.book_introduction = book_introduction;
		this.book_publisher = book_publisher;
		this.book_publish_time = book_publish_time;
		this.book_printing_time = book_printing_time;
		this.book_putaway_time = book_putaway_time;
		this.book_edition = book_edition;
		this.book_impression = book_impression;
		this.book_paper = book_paper;
		this.book_pages = book_pages;
		this.book_pack = book_pack;
		this.book_format = book_format;
		this.book_words = book_words;
		this.book_isbn = book_isbn;
		this.book_editer_comment = book_editer_comment;
		this.book_media_comment = book_media_comment;
		this.book_catalog = book_catalog;
		this.book_cover = book_cover;
		this.book_original_price = book_original_price;
		this.book_dangdang_price = book_dangdang_price;
		this.book_inventory = book_inventory;
		this.book_sales_volume = book_sales_volume;
		this.sort_id = sort_id;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((author_introduction == null) ? 0 : author_introduction
						.hashCode());
		result = prime * result
				+ ((book_author == null) ? 0 : book_author.hashCode());
		result = prime * result
				+ ((book_catalog == null) ? 0 : book_catalog.hashCode());
		result = prime * result
				+ ((book_cover == null) ? 0 : book_cover.hashCode());
		result = prime
				* result
				+ ((book_dangdang_price == null) ? 0 : book_dangdang_price
						.hashCode());
		result = prime
				* result
				+ ((book_editer_comment == null) ? 0 : book_editer_comment
						.hashCode());
		result = prime * result
				+ ((book_edition == null) ? 0 : book_edition.hashCode());
		result = prime * result
				+ ((book_format == null) ? 0 : book_format.hashCode());
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result
				+ ((book_impression == null) ? 0 : book_impression.hashCode());
		result = prime
				* result
				+ ((book_introduction == null) ? 0 : book_introduction
						.hashCode());
		result = prime * result
				+ ((book_inventory == null) ? 0 : book_inventory.hashCode());
		result = prime * result
				+ ((book_isbn == null) ? 0 : book_isbn.hashCode());
		result = prime
				* result
				+ ((book_media_comment == null) ? 0 : book_media_comment
						.hashCode());
		result = prime * result
				+ ((book_name == null) ? 0 : book_name.hashCode());
		result = prime
				* result
				+ ((book_original_price == null) ? 0 : book_original_price
						.hashCode());
		result = prime * result
				+ ((book_pack == null) ? 0 : book_pack.hashCode());
		result = prime * result
				+ ((book_pages == null) ? 0 : book_pages.hashCode());
		result = prime * result
				+ ((book_paper == null) ? 0 : book_paper.hashCode());
		result = prime
				* result
				+ ((book_printing_time == null) ? 0 : book_printing_time
						.hashCode());
		result = prime
				* result
				+ ((book_publish_time == null) ? 0 : book_publish_time
						.hashCode());
		result = prime * result
				+ ((book_publisher == null) ? 0 : book_publisher.hashCode());
		result = prime
				* result
				+ ((book_putaway_time == null) ? 0 : book_putaway_time
						.hashCode());
		result = prime
				* result
				+ ((book_sales_volume == null) ? 0 : book_sales_volume
						.hashCode());
		result = prime * result
				+ ((book_words == null) ? 0 : book_words.hashCode());
		result = prime * result + ((sort_id == null) ? 0 : sort_id.hashCode());
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
		Book other = (Book) obj;
		if (author_introduction == null) {
			if (other.author_introduction != null)
				return false;
		} else if (!author_introduction.equals(other.author_introduction))
			return false;
		if (book_author == null) {
			if (other.book_author != null)
				return false;
		} else if (!book_author.equals(other.book_author))
			return false;
		if (book_catalog == null) {
			if (other.book_catalog != null)
				return false;
		} else if (!book_catalog.equals(other.book_catalog))
			return false;
		if (book_cover == null) {
			if (other.book_cover != null)
				return false;
		} else if (!book_cover.equals(other.book_cover))
			return false;
		if (book_dangdang_price == null) {
			if (other.book_dangdang_price != null)
				return false;
		} else if (!book_dangdang_price.equals(other.book_dangdang_price))
			return false;
		if (book_editer_comment == null) {
			if (other.book_editer_comment != null)
				return false;
		} else if (!book_editer_comment.equals(other.book_editer_comment))
			return false;
		if (book_edition == null) {
			if (other.book_edition != null)
				return false;
		} else if (!book_edition.equals(other.book_edition))
			return false;
		if (book_format == null) {
			if (other.book_format != null)
				return false;
		} else if (!book_format.equals(other.book_format))
			return false;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (book_impression == null) {
			if (other.book_impression != null)
				return false;
		} else if (!book_impression.equals(other.book_impression))
			return false;
		if (book_introduction == null) {
			if (other.book_introduction != null)
				return false;
		} else if (!book_introduction.equals(other.book_introduction))
			return false;
		if (book_inventory == null) {
			if (other.book_inventory != null)
				return false;
		} else if (!book_inventory.equals(other.book_inventory))
			return false;
		if (book_isbn == null) {
			if (other.book_isbn != null)
				return false;
		} else if (!book_isbn.equals(other.book_isbn))
			return false;
		if (book_media_comment == null) {
			if (other.book_media_comment != null)
				return false;
		} else if (!book_media_comment.equals(other.book_media_comment))
			return false;
		if (book_name == null) {
			if (other.book_name != null)
				return false;
		} else if (!book_name.equals(other.book_name))
			return false;
		if (book_original_price == null) {
			if (other.book_original_price != null)
				return false;
		} else if (!book_original_price.equals(other.book_original_price))
			return false;
		if (book_pack == null) {
			if (other.book_pack != null)
				return false;
		} else if (!book_pack.equals(other.book_pack))
			return false;
		if (book_pages == null) {
			if (other.book_pages != null)
				return false;
		} else if (!book_pages.equals(other.book_pages))
			return false;
		if (book_paper == null) {
			if (other.book_paper != null)
				return false;
		} else if (!book_paper.equals(other.book_paper))
			return false;
		if (book_printing_time == null) {
			if (other.book_printing_time != null)
				return false;
		} else if (!book_printing_time.equals(other.book_printing_time))
			return false;
		if (book_publish_time == null) {
			if (other.book_publish_time != null)
				return false;
		} else if (!book_publish_time.equals(other.book_publish_time))
			return false;
		if (book_publisher == null) {
			if (other.book_publisher != null)
				return false;
		} else if (!book_publisher.equals(other.book_publisher))
			return false;
		if (book_putaway_time == null) {
			if (other.book_putaway_time != null)
				return false;
		} else if (!book_putaway_time.equals(other.book_putaway_time))
			return false;
		if (book_sales_volume == null) {
			if (other.book_sales_volume != null)
				return false;
		} else if (!book_sales_volume.equals(other.book_sales_volume))
			return false;
		if (book_words == null) {
			if (other.book_words != null)
				return false;
		} else if (!book_words.equals(other.book_words))
			return false;
		if (sort_id == null) {
			if (other.sort_id != null)
				return false;
		} else if (!sort_id.equals(other.sort_id))
			return false;
		return true;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getAuthor_introduction() {
		return author_introduction;
	}
	public void setAuthor_introduction(String author_introduction) {
		this.author_introduction = author_introduction;
	}
	public String getBook_introduction() {
		return book_introduction;
	}
	public void setBook_introduction(String book_introduction) {
		this.book_introduction = book_introduction;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public java.sql.Date getBook_publish_time() {
		return new java.sql.Date(book_publish_time.getTime());
	}
	public void setBook_publish_time(Date book_publish_time) {
		this.book_publish_time = book_publish_time;
	}
	public java.util.Date getBook_printing_time() {
		return new java.sql.Date(book_printing_time.getTime());
	}
	public void setBook_printing_time(Date book_printing_time) {
		this.book_printing_time = book_printing_time;
	}
	public java.util.Date getBook_putaway_time() {
		return new java.sql.Date(book_putaway_time.getTime());
	}
	public void setBook_putaway_time(Date book_putaway_time) {
		this.book_putaway_time = book_putaway_time;
	}
	public String getBook_edition() {
		return book_edition;
	}
	public void setBook_edition(String book_edition) {
		this.book_edition = book_edition;
	}
	public String getBook_impression() {
		return book_impression;
	}
	public void setBook_impression(String book_impression) {
		this.book_impression = book_impression;
	}
	public String getBook_paper() {
		return book_paper;
	}
	public void setBook_paper(String book_paper) {
		this.book_paper = book_paper;
	}
	public String getBook_pages() {
		return book_pages;
	}
	public void setBook_pages(String book_pages) {
		this.book_pages = book_pages;
	}
	public String getBook_pack() {
		return book_pack;
	}
	public void setBook_pack(String book_pack) {
		this.book_pack = book_pack;
	}
	public String getBook_format() {
		return book_format;
	}
	public void setBook_format(String book_format) {
		this.book_format = book_format;
	}
	public String getBook_words() {
		return book_words;
	}
	public void setBook_words(String book_words) {
		this.book_words = book_words;
	}
	public String getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}
	public String getBook_editer_comment() {
		return book_editer_comment;
	}
	public void setBook_editer_comment(String book_editer_comment) {
		this.book_editer_comment = book_editer_comment;
	}
	public String getBook_media_comment() {
		return book_media_comment;
	}
	public void setBook_media_comment(String book_media_comment) {
		this.book_media_comment = book_media_comment;
	}
	public String getBook_catalog() {
		return book_catalog;
	}
	public void setBook_catalog(String book_catalog) {
		this.book_catalog = book_catalog;
	}
	public String getBook_cover() {
		return book_cover;
	}
	public void setBook_cover(String book_cover) {
		this.book_cover = book_cover;
	}
	public Double getBook_original_price() {
		return book_original_price;
	}
	public void setBook_original_price(Double book_original_price) {
		this.book_original_price = book_original_price;
	}
	public Double getBook_dangdang_price() {
		return book_dangdang_price;
	}
	public void setBook_dangdang_price(Double book_dangdang_price) {
		this.book_dangdang_price = book_dangdang_price;
	}
	public String getBook_inventory() {
		return book_inventory;
	}
	public void setBook_inventory(String book_inventory) {
		this.book_inventory = book_inventory;
	}
	public String getBook_sales_volume() {
		return book_sales_volume;
	}
	public void setBook_sales_volume(String book_sales_volume) {
		this.book_sales_volume = book_sales_volume;
	}
	public String getSort_id() {
		return sort_id;
	}
	public void setSort_id(String sort_id) {
		this.sort_id = sort_id;
	}
	
	
	
	

}
