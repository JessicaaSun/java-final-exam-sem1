class Sale {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double totalServiceExpense = serviceExpense - (serviceExpense * customer.getServiceMemberDiscount());
        double totalProductExpense = productExpense - (productExpense * customer.getProductMemberDiscount());
        return totalServiceExpense + totalProductExpense;
    }

   public void displayInfo() {
    System.out.println("=====================================");
    System.out.println("          SALE RECEIPT               ");
    System.out.println("=====================================");
    System.out.println("Customer: " + customer.getCustomerName());
    System.out.println("Membership: " + customer.getCustomerType());
    System.out.println("Date of Sale: " + date);
    System.out.println("-------------------------------------");
    System.out.println("SERVICE CHARGES & DISCOUNTS:");
    double serviceDiscountAmount = serviceExpense * customer.getServiceMemberDiscount();
    double productDiscountAmount = productExpense * customer.getProductMemberDiscount();
    System.out.printf("Service Charge (Before Discount): $%.2f\n", serviceExpense);
    System.out.printf("Product Cost (Before Discount): $%.2f\n", productExpense);
    System.out.printf("Service Discount Applied: -$%.2f\n", serviceDiscountAmount);
    System.out.printf("Product Discount Applied: -$%.2f\n", productDiscountAmount);
    System.out.println("-------------------------------------");
    System.out.printf("Net Service Charge: $%.2f\n", serviceExpense - serviceDiscountAmount);
    System.out.printf("Net Product Cost: $%.2f\n", productExpense - productDiscountAmount);
    System.out.println("=====================================");
    System.out.printf("TOTAL DUE: $%.2f\n", getTotalExpense());
    System.out.println("=====================================");
}

}
