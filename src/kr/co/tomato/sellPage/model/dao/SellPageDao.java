package kr.co.tomato.sellPage.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Favorite;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.ItemInquiry;
import kr.co.tomato.vo.Member;
import kr.co.tomato.vo.Review;

public class SellPageDao {

	/* 조회수 +1 dao */
	public int readcount(Connection conn, int itemNo, int readcount) {
		PreparedStatement pstmt = null;
		String query = "update item set readcount = ? where item_no=?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, readcount);
			pstmt.setInt(2, itemNo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	/* 전체 상품 테이블 받아오는 dao */

	public Item sellpage(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Item item = new Item();

		String query = "select * from item where item_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				
				item.setItemNo(rset.getInt("item_no"));
				item.setMemberNo(rset.getInt("member_no"));
				item.setItemName(rset.getString("item_name"));
				item.setItemMainCategory(rset.getString("item_main_category"));
				item.setItemSubCategoty(rset.getString("item_sub_category"));
				item.setItemPrice(rset.getInt("item_price"));
				item.setItemEnrollDate(rset.getDate("item_enroll_date"));
				item.setItemState(rset.getString("item_state"));
				item.setReadcount(rset.getInt("readcount"));
				item.setFavoriteCount(rset.getInt("favorite_count"));
				item.setItemAmount(rset.getInt("item_amount"));
				item.setItemContent(rset.getString("item_content"));
				item.setItemDeliveryNY(rset.getInt("item_delivery_ny"));
				item.setItemDealRegion(rset.getString("item_deal_region"));
				item.setItemThumFilename(rset.getString("item_thum_filename"));
				item.setItemThumFilepath(rset.getString("item_thum_filepath"));
				item.setItemDealState(rset.getString("item_deal_state"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return item;

	}

	/* 찜수 받아오기 */
	public ArrayList<Favorite> checkFavorite(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Favorite> list = new ArrayList<Favorite>();
		
		String query = "select * from favorite where item_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Favorite favorite = new Favorite();
				
				favorite.setShopNo(rset.getInt("shop_no"));
				list.add(favorite);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;

	}

	/* 찜 정보 저장 */
	public int insertFavorite(Connection conn, int itemNo, int shopNo) {
		PreparedStatement pstmt = null;
		int resultf = 0;

		String query = "insert into favorite values(?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shopNo);
			pstmt.setInt(2, itemNo);
			resultf = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JDBCTemplate.close(pstmt);
		}

		return resultf;

	}

	/* 찜 수+1 */
	public int insertFavoriteCount(Connection conn, int itemNo, int favoriteCount) {
		PreparedStatement pstmt = null;
		int resultfc = 0;

		String query = "update item set favorite_count=? where item_no=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, favoriteCount);
			pstmt.setInt(2, itemNo);
			resultfc = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JDBCTemplate.close(pstmt);
		}
		return resultfc;

	}

	/* 상품 문의 저장 */
	public int insertItemInquiry(Connection conn, int index, String textarea, int itemNo, String memberName,
			int inquiryLevel) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = "insert into item_inquiry values(item_inquiry_no_seq.nextval,?,?,?,sysdate,?,null)";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberName);
			pstmt.setInt(2, itemNo);
			pstmt.setString(3, textarea);
			pstmt.setInt(4, inquiryLevel);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	/* member 가져오기 */
	public Member Member(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = new Member();

		String query = "select * from member where member_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member.setMemberNo(rset.getInt("member_no"));
				member.setEmail(rset.getString("email"));
				member.setMemberPw(rset.getString("member_pw"));
				member.setMemberName(rset.getString("member_name"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setZipCode(rset.getString("zip_code"));
				member.setMemberBank(rset.getString("member_bank"));
				member.setMemberAccount(rset.getString("member_account"));
				member.setShopName(rset.getString("shop_name"));
				member.setShopContent(rset.getString("email"));
				member.setShopReadcount(rset.getInt("shop_readcount"));
				member.setFileName(rset.getString("file_name"));
				member.setFilePath(rset.getString("file_path"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}

	/* 상품문의 가져오기 */
	public ArrayList<ItemInquiry> itemInquiry(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ItemInquiry> inquiry = new ArrayList<ItemInquiry>();

		String query = "select * from item_inquiry where item_ref=? order by item_inquiry_no ASC";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				ItemInquiry iteminquiry = new ItemInquiry();

				iteminquiry.setItemInquiryNo(rset.getInt("item_inquiry_no"));
				iteminquiry.setItemInquiryWriter(rset.getString("item_inquiry_writer"));
				iteminquiry.setItemRef(rset.getInt("item_ref"));
				iteminquiry.setItemInquiryComment(rset.getString("item_inquiry_comment"));
				iteminquiry.setItemInquiryDate(rset.getDate("item_inquiry_date"));
				iteminquiry.setItemInquiryLevel(rset.getInt("item_inquiry_level"));
				iteminquiry.setItemInquiryRef(rset.getInt("item_inquiry_ref"));
				inquiry.add(iteminquiry);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);

		}
		return inquiry;

	}

	/* 후기 불러오기 */
	public ArrayList<Review> reviews(Connection conn, int memberNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> review = new ArrayList<Review>();

		String query = "select * from review where shop_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNum);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Review reviews = new Review();

				reviews.setReviewNo(rset.getInt("review_no"));
				reviews.setShopNo(rset.getInt("shop_no"));
				reviews.setReviewWriter(rset.getString("review_writer"));
				reviews.setReviewDate(rset.getDate("review_date"));
				reviews.setReviewContent(rset.getString("review_content"));
				reviews.setReviewScore(rset.getInt("review_score"));
				review.add(reviews);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);

		}
		return review;

	}

	/* 상품 문의 삭제 */
	public int deleteItemInquiry(Connection conn, int itemInquiryNo, int itemInquiryLevel, int itemRef) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from item_inquiry where item_inquiry_level=? and item_ref=? and item_inquiry_no=?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, itemInquiryLevel);
			pstmt.setInt(2, itemRef);
			pstmt.setInt(3, itemInquiryNo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	/* 후기 저장 */
	public int insertReview(Connection conn, int index, int shopNo, String reviewWriter, String reviewContent,
			int reviewScore) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println(reviewWriter);
		String query = "insert into review values(review_no_seq.nextval,?,?,sysdate,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, shopNo);
			pstmt.setString(2, reviewWriter);
			pstmt.setString(3, reviewContent);
			pstmt.setInt(4, reviewScore);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	/* 후기 삭제 */
	public int deleteReview(Connection conn, int shopNo, int reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "delete from review where shop_no=? and review_no =?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shopNo);
			pstmt.setInt(2, reviewNo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	/* 결제 정보 저장 */
	public int insertPayment(Connection conn, String merchantUid, int itemNo, int memberNo, String impUid,
			int paymentPay, int paymentDate, String paymentApplyNum, int commission, String paymentState) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "insert into payment values (?,?,?,?,?,?,default,?,?,'판매중')";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, merchantUid);
			pstmt.setInt(2, itemNo);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, impUid);
			pstmt.setInt(5, paymentPay);
			pstmt.setString(6, paymentState);
			pstmt.setString(7, paymentApplyNum);
			pstmt.setInt(8, commission);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	/* 거래 정보 저장 */
	public int insertDeal(Connection conn, int buyer, int saler, String dealState, int itemNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "insert into deal values (deal_no_seq.nextval,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, buyer);
			pstmt.setInt(2, saler);
			pstmt.setInt(3, itemNo);
			pstmt.setString(4, dealState);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/* 답글 가져오기 */
	public ArrayList<ItemInquiry> itemInquiryReply(Connection conn, int itemRef, int itemInquiryLevel) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ItemInquiry> inquiryReply = new ArrayList<ItemInquiry>();

		String query = "select * from item_inquiry where item_ref =? and item_inquiry_level=? order by item_inquiry_no ASC";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemRef);
			pstmt.setInt(2, itemInquiryLevel);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				ItemInquiry iteminquiry = new ItemInquiry();
				iteminquiry.setItemInquiryNo(rset.getInt("item_inquiry_no"));
				iteminquiry.setItemInquiryWriter(rset.getString("item_inquiry_writer"));
				iteminquiry.setItemInquiryRef(rset.getInt("item_inquiry_ref"));
				iteminquiry.setItemInquiryComment(rset.getString("item_inquiry_comment"));
				iteminquiry.setItemInquiryDate(rset.getDate("item_inquiry_date"));
				iteminquiry.setItemInquiryLevel(rset.getInt("item_inquiry_level"));
				iteminquiry.setItemRef(rset.getInt("item_inquiry_ref"));
				inquiryReply.add(iteminquiry);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return inquiryReply;

	}
	/*답글 저장*/
	public int insertInquiryReply(Connection conn, int itemInquiryNo, int itemRef, int itemInquiryRef,
			int itemInquiryLevel, String itemInquiryWriter, String content) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "insert into item_inquiry values(item_inquiry_no_seq.nextval,?,?,?,sysdate,?,?)";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, itemInquiryWriter);
			pstmt.setInt(2, itemRef);
			pstmt.setString(3,content);
			pstmt.setInt(4, itemInquiryLevel);
			pstmt.setInt(5, itemInquiryNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteItemInquiryReply(Connection conn,int itemReplyNo, int itemReplyRef, int itemReplyLevel, int itemReplyInquiryRef) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="delete from item_inquiry where item_inquiry_no =? and item_ref=? and item_inquiry_level =? and item_inquiry_ref=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemReplyNo);
			pstmt.setInt(2,itemReplyRef);
			pstmt.setInt(3, itemReplyLevel);
			pstmt.setInt(4, itemReplyInquiryRef);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}return result;
		
	}

	public int itemStateUpdate(Connection conn , int itemNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query="update item set item_state = '판매중' where item_no = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}return result;
	}
	/*admin 상품문의 가져오기*/
	public ArrayList<Item> photoList(Connection conn,int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Item> photoList = new ArrayList<Item>();

		String query = "select * from item where member_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				Item item = new Item();
				
				item.setItemNo(rset.getInt("item_no"));
				item.setMemberNo(rset.getInt("member_no"));
				item.setItemName(rset.getString("item_name"));
				item.setItemMainCategory(rset.getString("item_main_category"));
				item.setItemSubCategoty(rset.getString("item_sub_category"));
				item.setItemPrice(rset.getInt("item_price"));
				item.setItemEnrollDate(rset.getDate("item_enroll_date"));
				item.setItemState(rset.getString("item_state"));
				item.setReadcount(rset.getInt("readcount"));
				item.setFavoriteCount(rset.getInt("favorite_count"));
				item.setItemAmount(rset.getInt("item_amount"));
				item.setItemContent(rset.getString("item_content"));
				item.setItemDeliveryNY(rset.getInt("item_delivery_ny"));
				item.setItemDealRegion(rset.getString("item_deal_region"));
				item.setItemThumFilename(rset.getString("item_thum_filename"));
				item.setItemThumFilepath(rset.getString("item_thum_filepath"));
				item.setItemDealState(rset.getString("item_deal_state"));
				photoList.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return photoList;
	}
	
	/*admin 상점후기 가져오기*/
	public ArrayList<ItemInquiry> itemInquiry(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ItemInquiry> inquiry = new ArrayList<ItemInquiry>();

		String query = "select * from item_inquiry ";

		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				ItemInquiry iteminquiry = new ItemInquiry();

				iteminquiry.setItemInquiryNo(rset.getInt("item_inquiry_no"));
				iteminquiry.setItemInquiryWriter(rset.getString("item_inquiry_writer"));
				iteminquiry.setItemRef(rset.getInt("item_ref"));
				iteminquiry.setItemInquiryComment(rset.getString("item_inquiry_comment"));
				iteminquiry.setItemInquiryDate(rset.getDate("item_inquiry_date"));
				iteminquiry.setItemInquiryLevel(rset.getInt("item_inquiry_level"));
				iteminquiry.setItemInquiryRef(rset.getInt("item_inquiry_ref"));
				inquiry.add(iteminquiry);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);

		}
		return inquiry;

	}

	public ArrayList<Review> review(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> review = new ArrayList<Review>();

		String query = "select * from review ";

		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Review reviews = new Review();

				reviews.setReviewNo(rset.getInt("review_no"));
				reviews.setShopNo(rset.getInt("shop_no"));
				reviews.setReviewWriter(rset.getString("review_writer"));
				reviews.setReviewDate(rset.getDate("review_date"));
				reviews.setReviewContent(rset.getString("review_content"));
				reviews.setReviewScore(rset.getInt("review_score"));

				review.add(reviews);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);

		}
		return review;
	}

}
