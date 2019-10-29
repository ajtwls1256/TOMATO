package kr.co.tomato.vo;

import java.util.ArrayList;

public class SearchPageData
{
    
    private ArrayList<Item> list;
    private String pageNavi;
    private ArrayList<CategoryResult> categorySubResult;
    private ArrayList<CategoryResult> categoryMainResult;
    public SearchPageData()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public SearchPageData(ArrayList<Item> list, String pageNavi,
            ArrayList<CategoryResult> categorySubResult,
            ArrayList<CategoryResult> categoryMainResult)
    {
        super();
        this.list = list;
        this.pageNavi = pageNavi;
        this.categorySubResult = categorySubResult;
        this.categoryMainResult = categoryMainResult;
    }
    public ArrayList<Item> getList()
    {
        return list;
    }
    public void setList(ArrayList<Item> list)
    {
        this.list = list;
    }
    public String getPageNavi()
    {
        return pageNavi;
    }
    public void setPageNavi(String pageNavi)
    {
        this.pageNavi = pageNavi;
    }
    public ArrayList<CategoryResult> getCategorySubResult()
    {
        return categorySubResult;
    }
    public void setCategorySubResult(ArrayList<CategoryResult> categorySubResult)
    {
        this.categorySubResult = categorySubResult;
    }
    public ArrayList<CategoryResult> getCategoryMainResult()
    {
        return categoryMainResult;
    }
    public void setCategoryMainResult(ArrayList<CategoryResult> categoryMainResult)
    {
        this.categoryMainResult = categoryMainResult;
    }
    
    
    
    
   
    
    
}
