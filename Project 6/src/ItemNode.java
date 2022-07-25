public class ItemNode {
    private char ItemName;
    private ItemNode next;
    private int x;
    private int y;

    public ItemNode(char dataToAdd) {
        ItemName = dataToAdd;
        next = null;
        x=0;
        y=0;
    }

    public char getItemName() { return ItemName; }
    public void setItemName(char data) { this.ItemName = data;  }
    public ItemNode getNext() { return next;  }
    public void setNext(ItemNode next) { this.next = next;   }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
