public class CategoryNode {
    private int CategoryName;
    private CategoryNode down;
    private ItemNode right;
    private int start_py;

    public CategoryNode(int dataToAdd) {
        CategoryName = dataToAdd;
        down = null;
        right = null;
        start_py=1;
    }

    public Object getCategoryName() { return CategoryName; }
    public void setCategoryName(int data) { this.CategoryName = data;  }
    public CategoryNode getDown() { return down;  }
    public void setDown(CategoryNode down) { this.down = down;   }
    public ItemNode getRight() { return right;  }
    public void setRight(ItemNode right) { this.right = right;   }
    public int getStart_py() {
        return start_py;
    }
    public void setStart_py(int start_py) {
        this.start_py = start_py;
    }
}
