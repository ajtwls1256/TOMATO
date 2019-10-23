package kr.co.tomato.vo;

import java.util.Date;

public class Item {
	 private int itemNo;
	    private int memberNo;
	    private int itemName;
	    private String itemMainCategory;
	    private String itemSubCategoty;
	    private int itemPrice;
	    private Date itemEnrollDate;
	    private String itemState;
	    private int readcount;
	    private String itemContent;
	    private int itemAmount;
	    private int itemDeleveryNy;
	    private String itemDealRegion;
	    private String itemThumFilename;
	    private String itemThumFilepath;
	    private String itemDealState;
	    
	    
	    public Item()
	    {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
	    
	    public Item(int itemNo, int memberNo, int itemName, String itemMainCategory,
	            String itemSubCategoty, int itemPrice, Date itemEnrollDate,
	            String itemState, int readcount, String itemContent, int itemAmount,
	            int itemDeleveryNy, String itemDealRegion, String itemThumFilename,
	            String itemThumFilepath, String itemDealState)
	    {
	        super();
	        this.itemNo = itemNo;
	        this.memberNo = memberNo;
	        this.itemName = itemName;
	        this.itemMainCategory = itemMainCategory;
	        this.itemSubCategoty = itemSubCategoty;
	        this.itemPrice = itemPrice;
	        this.itemEnrollDate = itemEnrollDate;
	        this.itemState = itemState;
	        this.readcount = readcount;
	        this.itemContent = itemContent;
	        this.itemAmount = itemAmount;
	        this.itemDeleveryNy = itemDeleveryNy;
	        this.itemDealRegion = itemDealRegion;
	        this.itemThumFilename = itemThumFilename;
	        this.itemThumFilepath = itemThumFilepath;
	        this.itemDealState = itemDealState;
	    }
	    
	    
	    public int getItemNo()
	    {
	        return itemNo;
	    }
	    public void setItemNo(int itemNo)
	    {
	        this.itemNo = itemNo;
	    }
	    public int getMemberNo()
	    {
	        return memberNo;
	    }
	    public void setMemberNo(int memberNo)
	    {
	        this.memberNo = memberNo;
	    }
	    public int getItemName()
	    {
	        return itemName;
	    }
	    public void setItemName(int itemName)
	    {
	        this.itemName = itemName;
	    }
	    public String getItemMainCategory()
	    {
	        return itemMainCategory;
	    }
	    public void setItemMainCategory(String itemMainCategory)
	    {
	        this.itemMainCategory = itemMainCategory;
	    }
	    public String getItemSubCategoty()
	    {
	        return itemSubCategoty;
	    }
	    public void setItemSubCategoty(String itemSubCategoty)
	    {
	        this.itemSubCategoty = itemSubCategoty;
	    }
	    public int getItemPrice()
	    {
	        return itemPrice;
	    }
	    public void setItemPrice(int itemPrice)
	    {
	        this.itemPrice = itemPrice;
	    }
	    public Date getItemEnrollDate()
	    {
	        return itemEnrollDate;
	    }
	    public void setItemEnrollDate(Date itemEnrollDate)
	    {
	        this.itemEnrollDate = itemEnrollDate;
	    }
	    public String getItemState()
	    {
	        return itemState;
	    }
	    public void setItemState(String itemState)
	    {
	        this.itemState = itemState;
	    }
	    public int getReadcount()
	    {
	        return readcount;
	    }
	    public void setReadcount(int readcount)
	    {
	        this.readcount = readcount;
	    }
	    public String getItemContent()
	    {
	        return itemContent;
	    }
	    public void setItemContent(String itemContent)
	    {
	        this.itemContent = itemContent;
	    }
	    public int getItemAmount()
	    {
	        return itemAmount;
	    }
	    public void setItemAmount(int itemAmount)
	    {
	        this.itemAmount = itemAmount;
	    }
	    public int getItemDeleveryNy()
	    {
	        return itemDeleveryNy;
	    }
	    public void setItemDeleveryNy(int itemDeleveryNy)
	    {
	        this.itemDeleveryNy = itemDeleveryNy;
	    }
	    public String getItemDealRegion()
	    {
	        return itemDealRegion;
	    }
	    public void setItemDealRegion(String itemDealRegion)
	    {
	        this.itemDealRegion = itemDealRegion;
	    }
	    public String getItemThumFilename()
	    {
	        return itemThumFilename;
	    }
	    public void setItemThumFilename(String itemThumFilename)
	    {
	        this.itemThumFilename = itemThumFilename;
	    }
	    public String getItemThumFilepath()
	    {
	        return itemThumFilepath;
	    }
	    public void setItemThumFilepath(String itemThumFilepath)
	    {
	        this.itemThumFilepath = itemThumFilepath;
	    }
	    public String getItemDealState()
	    {
	        return itemDealState;
	    }
	    public void setItemDealState(String itemDealState)
	    {
	        this.itemDealState = itemDealState;
	    }
}
