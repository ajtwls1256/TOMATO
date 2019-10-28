package kr.co.tomato.myshop.model.vo;

import java.sql.Date;

public class Review {
 
		private int reviewNo;
		private int shopNo;
		private String reviewWriter;
		private Date reviewDate;
		private String reviewContent;
		private int reviewScore;
		
		public Review() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Review(int reviewNo, int shopNo, String reviewWriter, Date reviewDate, String reviewContent,
				int reviewScore) {
			super();
			this.reviewNo = reviewNo;
			this.shopNo = shopNo;
			this.reviewWriter = reviewWriter;
			this.reviewDate = reviewDate;
			this.reviewContent = reviewContent;
			this.reviewScore = reviewScore;
		}

		public int getReviewNo() {
			return reviewNo;
		}

		public void setReviewNo(int reviewNo) {
			this.reviewNo = reviewNo;
		}

		public int getShopNo() {
			return shopNo;
		}

		public void setShopNo(int shopNo) {
			this.shopNo = shopNo;
		}

		public String getReviewWriter() {
			return reviewWriter;
		}

		public void setReviewWriter(String reviewWriter) {
			this.reviewWriter = reviewWriter;
		}

		public Date getReviewDate() {
			return reviewDate;
		}

		public void setReviewDate(Date reviewDate) {
			this.reviewDate = reviewDate;
		}

		public String getReviewContent() {
			return reviewContent;
		}

		public void setReviewContent(String reviewContent) {
			this.reviewContent = reviewContent;
		}

		public int getReviewScore() {
			return reviewScore;
		}

		public void setReviewScore(int reviewScore) {
			this.reviewScore = reviewScore;
		}
	
}
