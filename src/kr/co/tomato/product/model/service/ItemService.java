package kr.co.tomato.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.product.model.dao.ItemDao;
import kr.co.tomato.vo.BuySellItem;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.ItemViewData;
import kr.co.tomato.vo.OrderItem;
import kr.co.tomato.vo.PageData;

public class ItemService {
	
	// 아이템 삽입
	public int insertItem(Item item) {
		
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		int result = dao.insertItem(conn, item);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<Item> selectAll(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		
		ArrayList<Item> list = dao.selectAll(conn, memberNo);
		
		if(list != null) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return list;
	}

	public int deleteItem(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		int result = dao.deleteItem(conn, itemNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Item> searchKeyword(String type, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Item> list = null;
		ItemDao dao = new ItemDao();
		
		switch(type) {
			case "allItem" : list = dao.searchKeywordAll(conn, keyword);
				break;
			case "dealingItem" : list = dao.searchKeywordDealing(conn, keyword);
				break;
			case "onsaleItem" : list = dao.searchKeywordOnsale(conn, keyword);
				break;
			case "soldItem" : list = dao.searchKeywordsold(conn, keyword);
				break;
		}
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<BuySellItem> buyItem(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ItemDao dao = new ItemDao();
		ArrayList<BuySellItem> list = dao.buyItem(conn, memberNo);
		
		if(list != null) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<BuySellItem> sellItem(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		
		ArrayList<BuySellItem> list = dao.sellItem(conn, memberNo);
		
		if(list != null) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return list;
	}

	public PageData selectList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		int numPerPage = 10;
		int totalCount = dao.totalCount(conn);
		
		int totalPage = (totalCount % numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		ArrayList<Item> list = dao.selectList(conn, start, end);	
		int pageNaviSize = 10;
		String pageNavi = "";
		int pageNo = 0;
		
		if(reqPage<3) {
			pageNo = 1;
		} else {
			pageNo = reqPage - 2;
		}
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/itemList?reqPage"
					+ (reqPage-1) + "'>이전</a>";
		}
		int i = 1;
		
		while(! (i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
			} else {
				pageNavi += "<a class='btn' href='/itemList?reqPage="
						+ pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		} 
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/itemList?reqPage="
					+ pageNo + "'>다음</a>";
		}
		PageData pd = new PageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public OrderItem orderItems(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		
		ArrayList<BuySellItem> blist = dao.buyItem(conn, memberNo);
		ArrayList<BuySellItem> slist = dao.sellItem(conn, memberNo);
		
		OrderItem item = new OrderItem();
		item.setbList(blist);
		item.setsList(slist);

		JDBCTemplate.close(conn);
		return item;
	}

	public ItemViewData selectOne(int itemNo, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		Item i = dao.selectOne(conn, itemNo, memberNo);
		if (i != null) {
			int result = dao.readCount(conn, itemNo, memberNo);
			
			if (result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}
		JDBCTemplate.close(conn);
		ItemViewData ivd = new ItemViewData(i);
		
		return ivd;
	}

	public int itemModify(Item i) {
		Connection conn = JDBCTemplate.getConnection();
	      ItemDao dao = new ItemDao();
	      int result = dao.itemModify(conn, i);

	      if (result > 0) {
	         JDBCTemplate.commit(conn);
	      } else {
	         JDBCTemplate.rollback(conn);
	      }
	      JDBCTemplate.close(conn);
	      return result;
	}
	
}
