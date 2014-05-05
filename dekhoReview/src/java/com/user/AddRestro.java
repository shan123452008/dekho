package com.user;

import org.springframework.web.multipart.MultipartFile;

public class AddRestro {

	String restroName;
	String phone;
	String timing;
	String foodtype;
	String price;
	String comment;
	String location;
	MultipartFile uploadImage1;
	MultipartFile uploadImage2;
	MultipartFile uploadImage3;
	MultipartFile uploadImage4;
	MultipartFile uploadImage5;
	MultipartFile uploadImage6;
	public String getRestroName() {
		return restroName;
	}
	public void setRestroName(String restroName) {
		this.restroName = restroName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public String getFoodtype() {
		return foodtype;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public MultipartFile getUploadImage1() {
		return uploadImage1;
	}
	public void setUploadImage1(MultipartFile uploadImage1) {
		this.uploadImage1 = uploadImage1;
	}
	public MultipartFile getUploadImage2() {
		return uploadImage2;
	}
	public void setUploadImage2(MultipartFile uploadImage2) {
		this.uploadImage2 = uploadImage2;
	}
	public MultipartFile getUploadImage3() {
		return uploadImage3;
	}
	public void setUploadImage3(MultipartFile uploadImage3) {
		this.uploadImage3 = uploadImage3;
	}
	public MultipartFile getUploadImage4() {
		return uploadImage4;
	}
	public void setUploadImage4(MultipartFile uploadImage4) {
		this.uploadImage4 = uploadImage4;
	}
	public MultipartFile getUploadImage5() {
		return uploadImage5;
	}
	public void setUploadImage5(MultipartFile uploadImage5) {
		this.uploadImage5 = uploadImage5;
	}
	public MultipartFile getUploadImage6() {
		return uploadImage6;
	}
	public void setUploadImage6(MultipartFile uploadImage6) {
		this.uploadImage6 = uploadImage6;
	}

	
}
