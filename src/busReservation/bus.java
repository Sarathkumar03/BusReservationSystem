package busReservation;

public class bus {

    private int busNo;
    private boolean Ac;
    private int Capacity;

    bus(int busNo,boolean ac,int capacity){
        this.busNo=busNo;
        this.Ac=Ac;
        this.Capacity=capacity;

    }
    public int getBusNo() {
        return busNo;
    }
   public void setBusNo(int number)
   {
       busNo=number;
   }
   public boolean isAc()
   {
       return Ac;
   }
   public void setAc(boolean ac)
   {
       Ac=ac;
   }
   public int getCapacity()
   {
       return Capacity;
   }
   public void setCapacity(int capacity)
   {
       Capacity=capacity;
   }
   public void displaybusinfo()
   {
       System.out.println("bus number is "+busNo+"is ac "+Ac+"and capacity "+Capacity);
   }

}
