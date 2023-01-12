public class Car implements Comparable {

    private String year, brand, price, color;


    /** setup este carro com os dados especifícados
     * @param year ano
     * @param brand marca
     * @param price preço
     * @param color cor
     */
    public Car(String year, String brand, String price, String color) {
        this.year = year;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /** retorna a descrição do carro
     * @return
     */
    public String toString(){

        return year + "\t" + brand + "\t" + color + "\t" + price;
    }

    /** usou-se o price para determinar a ordem
     * @param other o carro que vai ser comparado com este contacto
     * @return o inteiro do resultado da comparação
     */
    @Override
    public int compareTo(Object other) {

        int result = 0;

        if(year.equals(((Car)other).year)){

            result = year.compareTo(((Car)other).year);

        } else if(brand.equals(((Car)other).brand)){

            result = brand.compareTo(((Car)other).brand);

        } else if(price.equals(((Car)other).price)){

            result = price.compareTo(((Car)other).price);

        } else if(color.equals(((Car)other).color)){

            result = color.compareTo(((Car)other).color);
        }

        return result;
    }
}
