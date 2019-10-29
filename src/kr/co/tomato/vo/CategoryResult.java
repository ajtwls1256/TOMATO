package kr.co.tomato.vo;

public class CategoryResult
{
    private String itemSubCategory;
    private String itemMainCategory;
    private int total;
    public CategoryResult()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public CategoryResult(String itemSubCategory, String itemMainCategory,
            int total)
    {
        super();
        this.itemSubCategory = itemSubCategory;
        this.itemMainCategory = itemMainCategory;
        this.total = total;
    }
    public String getItemSubCategory()
    {
        return itemSubCategory;
    }
    public void setItemSubCategory(String itemSubCategory)
    {
        this.itemSubCategory = itemSubCategory;
    }
    public String getItemMainCategory()
    {
        return itemMainCategory;
    }
    public void setItemMainCategory(String itemMainCategory)
    {
        this.itemMainCategory = itemMainCategory;
    }
    public int getTotal()
    {
        return total;
    }
    public void setTotal(int total)
    {
        this.total = total;
    }
    
   
    
    
}
