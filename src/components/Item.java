package components;

public class Item {
    private String category;
	
	private String name;
	
	private double price;
	
	private int quantityStock;
	
	public Item( ) { }
	
	public Item(String category, String name, double price, int quantityStock) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
	}

    public String getCategory() {
		return category;
	}

    public String getName() {
		return name;
	}

    public double getPrice() {
		return price;
	}

    public int getQuantityStock() {
		return quantityStock;
	}

	public void setCategory(String category) {
		this.category = category;
	}

    public void setName(String name) {
		this.name = name;
	}

    public void setPrice(double price) {
		this.price = price;
	}

    public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

}
