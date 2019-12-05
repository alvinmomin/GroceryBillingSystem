import javafx.scene.control.Alert;

public class Item
{
    protected String type;
    protected String department;
    protected String phone;
    protected String date;
    protected String code;
    protected String name;

    protected double quantity;
    protected double price;
    protected double discount;
    protected double total;
    protected double finalTotal;
    protected double tax;


    public Item(String cde, String typ, String nme, double quant, double prce, String disc, String dep)
    {
        total = (quant*prce);
        code = cde;
        name = nme; 
        type = typ;
        date = disc;
        department = dep;
        quantity = quant;
        price = prce;

        if(department.equals("Food"))
        {
            if(!type.equals("Candy"))
            {
                discount += 10;
                Alert typSale = new Alert(Alert.AlertType.CONFIRMATION);
                typSale.setTitle("Department Sale");
                typSale.setHeaderText(null);
                typSale.setContentText("10% off Candy!");
                typSale.show();
            }
        }

        if (department.equals("Home Improvement"))
        {
            HomeImpDisc();
        }

        if (!department.equals("Soda"))
        {
            if (date.equals("Friday") || date.equals("Friday"))
            {
                discount += 10;
                Alert techSale = new Alert(Alert.AlertType.CONFIRMATION);
                techSale.setTitle("Department Sale");
                techSale.setHeaderText(null);
                techSale.setContentText("10% off today!");
                techSale.show();
            }
        }


    }
    public Item(String phne)
    {
        phone = phne;
    }

    Item(){}

    public double calcFinalTotal()
    {
        finalTotal += total + calcTax() - calcDiscount();
        return finalTotal;
    }

    public String createString()
    {
        String stringVar =
                "Code: " + code
                        + "\nType: " + type
                        + "\nName:" + name
                        + "\nQuantity: " + quantity
                        + "\nPrice: " + price
                        + "\nTotal: " + total
                        + "\nTax: " + calcTax()
                        + "\nDiscount: " + discount
                        + "\nSavings: " + calcDiscount();

        return stringVar;
    }

    public void display()
    {
        System.out.println(code +"\n"+ type +"\n"+ name +"\n"+ quantity +"\n"+price+"\n"+ discount +"\n"+ total);
    }

    public double calcDiscount()
    {
        double savings = price*(discount / 100);
        return savings;
    }

    public double calcTax()
    {
        double salesTax = 0;

        if(department.equals("Grocery"))
        {
            tax = 0; salesTax = price*(tax/100);
        }
        else
        {
            tax = 8.25;
            salesTax = price*(tax/100);
        }

        return salesTax;
    }

    public void HomeImpDisc()
    {
        if(price > 1000)
        {
            discount += 10;
        }
    }

    //getters

    public String getCode() { return code; }

    public String getName(){
        return name;
    }

    public String getType(){ return type; }

    public String getDepartment(){ return department; }

    public double getPrice(){ return price; }

    public double getDiscount(){ return discount; }

    public double getQuantity(){ return quantity; }




    //setters

    public void setCode(String cde){ code = cde; }
    public void setName(String nme){ name = nme; }
    public void setType(String typ){ type = typ; }
    public void setQuantity(double quant){ quantity = quant; }
    public void setPrice(double prce){ price = prce; }
    public void setDiscount(double disc){ discount = disc; }
    public void setDepartment(String dep){ department = dep; }
    public String getPhone(){ return phone; }
    public String getDate(){ return date; }
    public void setPhone(String numb){ phone = numb; }
    public void setDate(String dte){ date = dte; }

}