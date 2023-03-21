package entities;

import java.util.Objects;

public class Sale {

    private Integer moth;
    private Integer year;
    private String seller;
    private Integer items;
    private Double total;

    public Sale() {

    }

    public Sale(Integer moth, Integer year, String seller, Integer items, Double total) {
        this.moth = moth;
        this.year = year;
        this.seller = seller;
        this.items = items;
        this.total = total;
    }

    public Integer getMoth() {
        return moth;
    }

    public void setMoth(Integer moth) {
        this.moth = moth;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return seller.equals(sale.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seller);
    }

    public Double averagePrice() {
        return getTotal() / getItems();
    }

    @Override
    public String toString() {
        return getSeller() + " - " + "R$ " + getTotal();
    }
}
